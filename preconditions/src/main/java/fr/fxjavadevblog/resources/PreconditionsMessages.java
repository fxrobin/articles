package fr.fxjavadevblog.resources;

/**
 * contient les chaines de formatage des messages.
 *
 * @author fxjavadevblog
 *
 */
public final class PreconditionsMessages
{
	public static final String  MSG_NOT_NULL = "L'argument %s ne peut pas être null";
	public static final String  MSG_UPPER_CASE = "L'argument %s doit être écrit en majuscules";
	public static final String  MSG_RANGE_PATTERN = "L'argument %s (%d) doit être compris entre  %d et %d";
	public static final String  MSG_NOT_EMPTY_COLLECTION = "l'argument %s ne peut pas être une collection vide";
	public static final String  MSG_NOT_PNG_IMAGE = "les données ne représentent pas une image PNG";

	private PreconditionsMessages()
	{
		// protection
	}
}
