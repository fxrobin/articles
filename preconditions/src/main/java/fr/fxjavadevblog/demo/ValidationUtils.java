package fr.fxjavadevblog.demo;

import java.util.Arrays;

public class ValidationUtils
{

	public static boolean isPngData(byte[] photo)
	{
		// signature d'une entête PNG
		byte[] signature = new byte[] { (byte) 0x89,	0x50,	0x4E,	0x47, 0x0D, 0x0A, 0x1A, 0x0A };
		Arrays.equals(signature, Arrays.copyOf(photo, signature.length));
		return true;
	}

}
