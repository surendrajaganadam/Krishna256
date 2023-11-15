package scripts.SeleniumFramework4X.Exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class Automation Exception
 */
@SuppressWarnings("serial")
public class AutomationException extends Exception {

	/** The message. */
	private String message = null;

	/** The logger. */
	private static final Logger LOG = LoggerFactory.getLogger(AutomationException.class);

	/**
	 * Instantiates a new Automation exception.
	 */
	public AutomationException() {
		super();
	}

	/**
	 * Instantiates a new Automation exception.
	 *
	 * @param message
	 *            the message
	 */
	public AutomationException(String message) {
		super(message);
		this.message = message;
	}

	/**
	 * Instantiates a new Automation exception.
	 *
	 * @param cause
	 *            the cause
	 */
	public AutomationException(Throwable cause) {
		super(cause);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Throwable#toString()
	 */
	@Override
	public String toString() {
		return message;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return message;
	}
}