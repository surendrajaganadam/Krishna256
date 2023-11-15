package scripts.SeleniumFramework4X.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class PropertyUtils.
 *
 */
public class PropertyUtils {

	/** The logger. */
	private static final Logger LOG = LoggerFactory.getLogger(PropertyUtils.class);

	/** The property file. */
	Properties propertyFile = new Properties();

	/** The file name. */
	String fileName;

	/** The value. */
	String value;

	/**
	 * Gets the property.
	 *
	 * @param property
	 *            the property
	 * @return the property
	 */
	public String getProperty(String property) {
		try {
			value = propertyFile.getProperty(property);
		} catch (Exception exception) {
			LOG.error("Error while fetching the property ::" + exception);
		}
		return value;
	}

	/**
	 * Sets the property.
	 *
	 * @param strKey
	 *            the str key
	 * @param strValue
	 *            the str value
	 * @throws Throwable
	 *             the throwable
	 */
	public void setProperty(String strKey, String strValue) throws Throwable {
		try {
			propertyFile.setProperty(strKey, strValue);
			propertyFile.store(new FileOutputStream(fileName), null);
		} catch (Exception exception) {
			LOG.error("Error while adding the property ::" + exception);

		}
	}

	/**
	 * Removes the property.
	 *
	 * @param property
	 *            the property
	 */
	public void removeProperty(String property) {
		try {
			propertyFile.remove(property);
			propertyFile.store(new FileOutputStream(fileName), null);
		} catch (Exception exception) {
			LOG.error("Error while removing the property ::" + exception);
		}
	}

	/**
	 * Instantiates a new property utils.
	 *
	 * @param fileName
	 *            the file name
	 */
	public PropertyUtils(String fileName) {
		this.fileName = fileName;

		LOG.info("Property File Name is ::" + fileName);
		File propertyfile = new File(fileName);
		if (propertyfile.exists()) {
			FileInputStream fileInputStream = null;
			try {
				fileInputStream = new FileInputStream(propertyfile);
				if (fileInputStream != null) {
					propertyFile.load(fileInputStream);
					fileInputStream.close();
				}
			} catch (FileNotFoundException fileNotFoundException) {
				LOG.error("Error while finding Property file ::" + fileNotFoundException.getMessage());
			} catch (IOException iOException) {
				System.out
						.println("Error while Loading file in loading propetry file is ::" + iOException.getMessage());
			} catch (Exception exception) {
				LOG.error("Error propetry file is ::" + exception.getMessage());

			} finally {
				IOUtils.closeQuietly(fileInputStream);

			}
		} else {
			LOG.error("File not found::" + fileName);
		}

	}

	/**
	 * Gets the host name.
	 *
	 * @return the host name
	 * @throws UnknownHostException
	 *             the unknown host exception
	 */
	// return environmental details
	public static String getHostName() throws UnknownHostException {
		// byte[] ipAddr = addr.getAddress();
		String hostname = null;
		try {
			InetAddress iNetAdderss = InetAddress.getLocalHost();
			hostname = iNetAdderss.getHostName();
		} catch (Exception exception) {
			LOG.error("Error while getting the host name::" + exception.getMessage());
		}
		return hostname;
	}

}