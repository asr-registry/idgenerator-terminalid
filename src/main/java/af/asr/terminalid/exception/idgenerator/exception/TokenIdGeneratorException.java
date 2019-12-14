package af.asr.terminalid.exception.idgenerator.exception;


import af.asr.terminalid.exception.common.BaseUncheckedException;

/**
 * Class to handle exceptions in Token ID Generation.
 *
 */
public class TokenIdGeneratorException extends BaseUncheckedException {

	/**
	 * Serial version ID.
	 */
	private static final long serialVersionUID = -7905208050229631306L;

	/**
	 * Constructor for TokenIdGeneratorException with errorCode and errorMessage as
	 * the arguments.
	 * 
	 * @param errorCode    the error code.
	 * 
	 * @param errorMessage the error message.
	 */
	public TokenIdGeneratorException(String errorCode, String errorMessage) {
		super(errorCode, errorMessage);
	}
}
