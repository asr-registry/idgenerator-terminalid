package af.asr.terminalid.exception.idgenerator.exception;

import af.asr.terminalid.exception.common.BaseUncheckedException;
import org.springframework.stereotype.Component;

@Component
public class PridGenerationException extends BaseUncheckedException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * No Argument Constructor
	 */
	public PridGenerationException() {
		super();
	}

	/**
	 * Constructor the initialize PreIdGenerationException
	 * 
	 * @param errorCode    for this exception
	 * 
	 * @param errorMessage for this exception
	 */
	public PridGenerationException(String errorCode, String errorMessage) {
		super(errorCode, errorMessage);
	}
}
