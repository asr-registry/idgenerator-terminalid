package af.asr.terminalid.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import af.asr.terminalid.data.MachineId;
import af.asr.terminalid.data.MachineIdRepository;
import af.asr.terminalid.exception.MachineIdServiceException;
import af.asr.terminalid.exception.dataaccess.DataAccessLayerException;
import af.asr.terminalid.exception.idgenerator.spi.MachineIdGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;


@SpringBootTest
@RunWith(SpringRunner.class)
public class MachineIdServiceTest {

	@Value("${kernel.mid.test.valid-initial-mid}")
	private int initialMid;

	@Value("${kernel.mid.test.valid-new-mid}")
	private int newMid;

	@Autowired
	MachineIdGenerator<String> service;

	@MockBean
	MachineIdRepository repository;
	
	@MockBean
	private RestTemplate restTemplate;

	@Test
	public void generateMachineIdTest() {
		MachineId entity = new MachineId();
		entity.setMId(initialMid);
		when(repository.findLastMID()).thenReturn(null);
		when(repository.save(Mockito.any())).thenReturn(entity);
		assertThat(service.generateMachineId(), is(Integer.toString(initialMid)));
	}

	@Test
	public void generateNextMachineIdTest() {
		MachineId entity = new MachineId();
		entity.setMId(initialMid);
		MachineId entityResponse = new MachineId();
		entityResponse.setMId(newMid);
		when(repository.findLastMID()).thenReturn(entity);
		when(repository.save(Mockito.any())).thenReturn(entityResponse);
		assertThat(service.generateMachineId(), is(Integer.toString(newMid)));
	}

	@Test(expected = Exception.class)
	public void generateIdFetchExceptionTest() {
		when(repository.findLastMID()).thenThrow(new DataAccessLayerException("", "cannot execute statement", null));
		service.generateMachineId();
	}

	@Test(expected = MachineIdServiceException.class)
	public void generateIdInsertExceptionTest() {
		when(repository.findLastMID()).thenReturn(null);
		when(repository.save(Mockito.any()))
				.thenThrow(new MachineIdServiceException("", "cannot execute statement", new RuntimeException()));
		service.generateMachineId();
	}

	@Test(expected = Exception.class)
	public void idServiceFetchExceptionTest() throws Exception {

		when(repository.findLastMID())
				.thenThrow(new DataAccessLayerException("", "cannot execute statement", new RuntimeException()));
		service.generateMachineId();
	}

	@Test(expected = MachineIdServiceException.class)
	public void idServiceInsertExceptionTest() throws Exception {
		when(repository.save(Mockito.any()))
				.thenThrow(new MachineIdServiceException("", "cannot execute statement", new RuntimeException()));
		service.generateMachineId();
	}

	@Test(expected = Exception.class)
	public void machineIdServiceExceptionTest() throws Exception {
		MachineId entity = new MachineId();
		entity.setMId(1000);
		when(repository.findLastMID()).thenReturn(entity);
		when(repository.save(Mockito.any()))
				.thenThrow(new DataAccessLayerException("", "cannot execute statement", new RuntimeException()));
		service.generateMachineId();
	}

}
