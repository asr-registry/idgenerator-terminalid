package af.asr.terminalid.exception.idgenerator.spi;

/**
 * @param <T>
 *            the return type of generateId() method.
 */
public interface PartnerIdGenerator<T> {

	/**
	 * This method generate PartnerId.
	 * 
	 * @return the provided type.
	 */
	public T generateId();

}
