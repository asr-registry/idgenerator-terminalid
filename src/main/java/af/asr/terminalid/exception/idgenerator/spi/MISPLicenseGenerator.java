package af.asr.terminalid.exception.idgenerator.spi;

/**
 * Interface that provides method for license generation of MISP.
 * @param <T>
 *            The generic type.
 */
public interface MISPLicenseGenerator<T> {
	/**
	 * Method that generates a license of specified length.
	 * 
	 * @return the generated license.
	 */
	public T generateLicense();
}
