package af.asr.terminalid.exception.idgenerator.spi;

/**
 * Interface that provides methods to generate Machine ID.
 * @param <T> the id type.
 */
public interface MachineIdGenerator<T> {
	/**
	 * This method generates machine ID.
	 * 
	 * @return the generated machine ID.
	 */
	public T generateMachineId();

}
