package af.asr.terminalid.exception.idgenerator.spi;

/**
 * Interface that provides methods for Token ID generation.
 *
 */
public interface TokenIdGenerator<T> {
	/**
	 * Method when called would create random token id.
	 * 
	 * @return tokenId
	 */
	T generateId();
}
