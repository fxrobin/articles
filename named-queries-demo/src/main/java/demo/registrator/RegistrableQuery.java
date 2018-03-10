package demo.registrator;

/**
 * représente une requête JPQL et son identifiant pour 
 * devenir une "NamedQuery".
 * 
 * @author fxrobin
 *
 */
public interface RegistrableQuery
{
	/**
	 * @return la requête JPQL.
	 */
	String getQuery();

	/**
	 * @return l'identifiant de la requête JPQL.
	 */
	String getIdentifier();
}
