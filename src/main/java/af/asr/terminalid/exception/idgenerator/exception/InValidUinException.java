package af.asr.terminalid.exception.idgenerator.exception;

import af.asr.terminalid.exception.common.BaseUncheckedException;

/**
 * Custom exception for Invalid Uin Exception

 *
 */
public class InValidUinException extends BaseUncheckedException {
	/**
	 * The generated serial version id
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor initialize InValidUinException
	 * 
	 * @param errorCode    The errorcode for this exception
	 * @param errorMessage The error message for this exception
	 */
	public InValidUinException(String errorCode, String errorMessage) {
		super(errorCode, errorMessage);
	}
}
