package demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Singleton de création et d'obtention d'un EntityManager au moyen d'une
 * EntityMangagerFactory.
 * 
 * @author fxrobin
 *
 */
public class ApplicationSingleton
{
	private static final ApplicationSingleton INSTANCE = new ApplicationSingleton();

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("named-queries-demo");

	/**
	 * @return une instance d'entityManager issue de la factory.
	 */
	public static EntityManager createEntityManager()
	{
		return INSTANCE.emf.createEntityManager();
	}

}
