package cn.wandingkeji.comm.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SessionIdGeneratorUtils {
	
	private static final Logger log = LoggerFactory.getLogger(SessionIdGeneratorUtils.class);
	private static String jvmRoute = "";

	private static int sessionIdLength = 16;

	private static String secureRandomClass = null;
	
	private static String secureRandomProvider = null;
	
	private static String secureRandomAlgorithm = "SHA1PRNG";

	private static final Queue<SecureRandom> randoms = new ConcurrentLinkedQueue<SecureRandom>();

	public static String getJvmRoute() {
		return jvmRoute;
	}

	public void setJvmRoute(String jvmRoute) {
		this.jvmRoute = jvmRoute;
	}

	public static int getSessionIdLength() {
		return sessionIdLength;
	}

	public void setSessionIdLength(int sessionIdLength) {
		this.sessionIdLength = sessionIdLength;
	}

	private static SecureRandom createSecureRandom() {
		SecureRandom result = null;
		long t1 = System.currentTimeMillis();
		if (secureRandomClass != null) {
			try {
				// Construct and seed a new random number generator
				Class<?> clazz = Class.forName(secureRandomClass);
				result = (SecureRandom) clazz.newInstance();
			} catch (Exception e) {
				log.error(
						secureRandomClass, e);
			}
		}

		boolean error = false;
		if (result == null) {
			// No secureRandomClass or creation failed. Use SecureRandom.
			try {
				if (secureRandomProvider != null
						&& secureRandomProvider.length() > 0) {
					result = SecureRandom.getInstance(secureRandomAlgorithm,
							secureRandomProvider);
				} else if (secureRandomAlgorithm != null
						&& secureRandomAlgorithm.length() > 0) {
					result = SecureRandom.getInstance(secureRandomAlgorithm);
				}
			} catch (NoSuchAlgorithmException e) {
				error = true;
				log.error(
						secureRandomAlgorithm, e);
			} catch (NoSuchProviderException e) {
				error = true;
				log.error(
						secureRandomProvider, e);
			}
		}

		if (result == null && error) {
			// Invalid provider / algorithm
			try {
				result = SecureRandom.getInstance("SHA1PRNG");
			} catch (NoSuchAlgorithmException e) {
				log.error(
						secureRandomAlgorithm, e);
			}
		}

		if (result == null) {
			// Nothing works - use platform default
			result = new SecureRandom();
		}

		// Force seeding to take place
		result.nextInt();

		long t2 = System.currentTimeMillis();
		if ((t2 - t1) > 100) {
			log.warn("sessionIdGeneratorBase.createRandom",
					result.getAlgorithm(), Long.valueOf(t2 - t1));
		}
		log.info("SecureRandom:{}",result==null);
		return result;
	}

	private static void getRandomBytes(byte bytes[]) {

		SecureRandom random = randoms.poll();
		if (random == null) {
			random = createSecureRandom();
		}
		random.nextBytes(bytes);
		randoms.add(random);
		log.info(""+randoms.size());
	}
	
	public static String generateSessionId(){
		return generateSessionId(null);
	}

	public static String generateSessionId(String route) {

		byte random[] = new byte[16];
		int sessionIdLength = getSessionIdLength();

		// Render the result as a String of hexadecimal digits
		// Start with enough space for sessionIdLength and medium route size
		StringBuilder buffer = new StringBuilder(2 * sessionIdLength + 20);

		int resultLenBytes = 0;

		while (resultLenBytes < sessionIdLength) {
			getRandomBytes(random);
			for (int j = 0; j < random.length
					&& resultLenBytes < sessionIdLength; j++) {
				byte b1 = (byte) ((random[j] & 0xf0) >> 4);
				byte b2 = (byte) (random[j] & 0x0f);
				if (b1 < 10)
					buffer.append((char) ('0' + b1));
				else
					buffer.append((char) ('A' + (b1 - 10)));
				if (b2 < 10)
					buffer.append((char) ('0' + b2));
				else
					buffer.append((char) ('A' + (b2 - 10)));
				resultLenBytes++;
			}
		}

		if (route != null && route.length() > 0) {
			buffer.append('.').append(route);
		} else {
			String jvmRoute = getJvmRoute();
			if (jvmRoute != null && jvmRoute.length() > 0) {
				buffer.append('.').append(jvmRoute);
			}
		}

		return buffer.toString();
	}

}
