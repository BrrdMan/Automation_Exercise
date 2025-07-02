package genericUtility;

import java.time.LocalDateTime;

/**
 * @author Devayan
 */
public class JavaUtility {

	/**
	 * This method is used to generate a n-digit random number
	 * 
	 * @param noOfDigits
	 * @return
	 */
	public long randomNumber(int noOfDigits) {
		long num = (long) (Math.random() * Math.pow(10, noOfDigits));
		while (true) {
			if (num >= Math.pow(10, noOfDigits - 1) && num < Math.pow(10, noOfDigits))
				break;
		}
		return num;
	}

	/**
	 * This method is used to get the timestamp
	 * 
	 * @return
	 */
	public String getTimestamp() {
		return LocalDateTime.now().toString().replace(":", "-");
	}
}
