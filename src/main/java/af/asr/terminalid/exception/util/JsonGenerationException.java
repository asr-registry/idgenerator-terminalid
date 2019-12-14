package af.asr.terminalid.exception.util;

import af.asr.terminalid.exception.common.BaseCheckedException;

public class JsonGenerationException extends BaseCheckedException {
	private static final long serialVersionUID = 7464354823823756787L;

	public JsonGenerationException(String errorCode, String errorMessage, Throwable rootCause) {
		super(errorCode, errorMessage, rootCause);

	}

	public JsonGenerationException(String string) {

	}

}
