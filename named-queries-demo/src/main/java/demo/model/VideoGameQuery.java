package demo.model;

import demo.registrator.RegistrableQuery;

/**
 * contient l'ensemble des requêtes JPQL.
 * 
 * @author robin
 *
 */
public enum VideoGameQuery implements RegistrableQuery
{
    /**
     * retourne les VideoGame en fonction de leur genre. 
     * Argument JPQL attendu : gameGenre de type GameGenre.	
     */
	FIND_BY_GENRE("SELECT vg FROM VideoGame vg WHERE vg.gameGenre = :gameGenre"), 
	
	/**
	 * retourne les VideoGame en fonction d'un nom approchant (LIKE). 
	 * Argument JPQL attendu : name de type String.
	 */
	FIND_BY_NAME_LIKE("SELECT vg FROM VideoGame vg WHERE vg.name LIKE :name");

	
    // partie "technique"
	
	/**
	 * String JPQL de la requête
	 */
	final String query;

	/**
	 * constructeur pour chaque valeur de l'enum.
	 * 
	 * @param returnedClass
	 * @param query
	 */
	private VideoGameQuery(String query)
	{
		this.query = query;
	}


	/**
	 * retourne la requête JPQL
	 */
	@Override
	public String getQuery()
	{
		return this.query;
	}

	/**
	 * contruit et retourne l'identifiant de la requête JPQL qui sert de clé pour
	 * la namedQuery.
	 */
	@Override
	public String getIdentifier()
	{
		return String.format("%s_%s", this.getClass(), this.name());
	}

}
