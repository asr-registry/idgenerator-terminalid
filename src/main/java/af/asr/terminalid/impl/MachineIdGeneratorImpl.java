package af.asr.terminalid.impl;

import af.asr.terminalid.data.MachineId;
import af.asr.terminalid.data.MachineIdRepository;
import af.asr.terminalid.exception.MachineIdServiceException;
import af.asr.terminalid.exception.dataaccess.DataAccessLayerException;
import af.asr.terminalid.exception.idgenerator.spi.MachineIdGenerator;
import af.asr.terminalid.utils.MachineIdConstant;
import af.asr.terminalid.utils.MathUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.persistence.EntityExistsException;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Implementation class for {@link MachineIdGenerator}.
 *
 */
@Component
public class MachineIdGeneratorImpl implements MachineIdGenerator<String> {
	/**
	 * The length of machine ID.
	 */
	@Value("${kernel.machineid.length}")
	private int machineIdLength;

	/**
	 * Autowired reference for {@link MachineIdRepository}.
	 */
	@Autowired
	private MachineIdRepository machineIdRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.mosip.kernel.core.idgenerator.spi.MachineIdGenerator#generateMachineId()
	 */
	@Override
	public String generateMachineId() {
		int generatedMID = 0;

		final int initialValue = MathUtils.getPow(MachineIdConstant.ID_BASE.getValue(), machineIdLength - 1);

		MachineId machineId = null;

		try {
			machineId = machineIdRepository.findLastMID();
		} catch (DataAccessLayerException dataAccessLayerException) {
			throw new DataAccessLayerException(MachineIdConstant.MID_FETCH_EXCEPTION.getErrorCode(),
					MachineIdConstant.MID_FETCH_EXCEPTION.getErrorMessage(), dataAccessLayerException.getCause());
		}
		try {
			if (machineId == null) {
				machineId = new MachineId();
				machineId.setMId(initialValue);
				machineId.setCreatedBy("SYSTEM");
				machineId.setCreatedDateTime(LocalDateTime.now(ZoneId.of("UTC")));
				machineId.setUpdatedBy("SYSTEM");
				machineId.setUpdatedDateTime(null);
				generatedMID = initialValue;
				machineIdRepository.save(machineId);
			} else {
				generatedMID = machineId.getMId() + 1;
				MachineId entity = new MachineId();
				entity.setMId(generatedMID);
				entity.setCreatedDateTime(LocalDateTime.now(ZoneId.of("UTC")));
				entity.setUpdatedDateTime(LocalDateTime.now(ZoneId.of("UTC")));
				entity.setUpdatedBy("SYSTEM");
				entity.setCreatedBy("SYSTEM");
				machineIdRepository.save(entity);
			}

		} catch (DataAccessLayerException e) {
			if (e.getCause().getClass() == EntityExistsException.class) {
				generateMachineId();
			} else {
				throw new DataAccessLayerException(MachineIdConstant.MID_INSERT_EXCEPTION.getErrorCode(),
						MachineIdConstant.MID_INSERT_EXCEPTION.getErrorMessage(), e);
			}
		}
		return String.valueOf(generatedMID);
	}
}
