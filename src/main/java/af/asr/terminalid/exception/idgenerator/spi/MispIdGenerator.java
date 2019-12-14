package af.asr.terminalid.exception.idgenerator.spi;

/**
 * This is an interface for the generation of MISPID
 */
public interface MispIdGenerator<T> {
	/**
	 * Function to generate an Id
	 * 
	 * @return The generated id
	 */
	public T generateId();

}
