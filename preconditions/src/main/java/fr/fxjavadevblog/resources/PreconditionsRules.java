package fr.fxjavadevblog.resources;

/**
 * contient constantes globales utilisées pour valider
 * les données en arguments de méthodes.
 *
 * @author fxjavadevblog
 *
 */
public final class PreconditionsRules
{
	public static final int AGE_MIN = 0;
	public static final int AGE_MAX = 150;
	public static final String REGEXP_MAJUSCULES = "[A-Z]*";

	private PreconditionsRules()
	{
		// protection
	}
}
