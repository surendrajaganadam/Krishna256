package scripts.SeleniumFramework4X.Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class ProductImpl.
 */
public class Execution {

	/** The execution key. */
	private String executionKey;

	/** The logger. */
	private static final Logger LOG = LoggerFactory.getLogger(Execution.class);

	/** The execution issue id. */
	private Integer executionIssueId;

	/** The execution id. */
	private Integer executionId;

	/**
	 * Sets the execution key.
	 *
	 * @param executionKey
	 *            the new execution key
	 */
	public void setExecutionKey(final String executionKey) {
		this.executionKey = executionKey;
	}

	/**
	 * Sets the execution issue id.
	 *
	 * @param executionIssueId
	 *            the new execution issue id
	 */
	public void setExecutionIssueId(final Integer executionIssueId) {
		this.executionIssueId = executionIssueId;
	}

	/**
	 * Sets the execution id.
	 *
	 * @param executionId
	 *            the new execution id
	 */
	public void setExecutionId(final Integer executionId) {
		this.executionId = executionId;
	}

	/**
	 * Gets the execution key.
	 *
	 * @return the execution key
	 */
	public final String getExecutionKey() {
		return executionKey;
	}

	/**
	 * Gets the execution issue id.
	 *
	 * @return the execution issue id
	 */
	public final Integer getExecutionIssueId() {
		return executionIssueId;
	}

	/**
	 * Gets the execution id.
	 *
	 * @return the execution id
	 */
	public final Integer getExecutionId() {
		return executionId;
	}
}