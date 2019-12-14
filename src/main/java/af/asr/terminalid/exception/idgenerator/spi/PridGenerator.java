package af.asr.terminalid.exception.idgenerator.spi;

/**
 * This is an interface for the generation of RID
 *
 */
public interface PridGenerator<T> {
	/**
	 * Function to generate an Id
	 * 
	 * @return The generated id
	 */
	T generateId();

}
