package af.asr.terminalid.exception.idgenerator.spi;

/**
 * Interface that provides method to generate Registration Center ID.
 *
 * @param <T> the id type.
 */
public interface RegistrationCenterIdGenerator<T> {
	/**
	 * This method generates registration center id.
	 * 
	 * @return the generated registration center id.
	 */
	public T generateRegistrationCenterId();
}
