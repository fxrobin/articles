package fr.fxjavadevblog.demo;

import java.util.Arrays;

public final class ValidationUtils
{
	public static byte[] PNG_SIGNATURE = new byte[] { (byte) 0x89, 0x50, 0x4E, 0x47, 0x0D, 0x0A, 0x1A, 0x0A };
	
	private ValidationUtils()
	{
		// protection de cette classe utilitaire.
	}
	
	/**
	 * vérifie que le tableau d'octets contient bien la signature PNG.
	 * 
	 * @param data
	 * 		tableau d'octets à tester
	 * @return
	 * 		true si la signature PNG est trouvée, false dans le cas contraire.
	 */
	public static boolean isPngData(byte[] data)
	{
		return Arrays.equals(PNG_SIGNATURE, Arrays.copyOf(data, PNG_SIGNATURE.length));
	}
	
	/**
	 * vérifie que la référence désigne bien un tableau d'octets et que celui-ci
	 * contient bien la signature PNG.
	 * 
	 * @param data
	 * 		référence potentielle vers un tableau d'octets
	 * @return
	 * 		true si la signature PNG est trouvée, false dans le cas contraire
	 */
	public static boolean isPngData(Object data)
	{
		return (data instanceof byte[] && ValidationUtils.isPngData((byte[]) data));
	}
}
