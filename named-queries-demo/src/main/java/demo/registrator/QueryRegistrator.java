package demo.registrator;

import java.util.logging.Level;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import lombok.extern.java.Log;

@Log
public class QueryRegistrator
{
	private EntityManager em;

	private QueryRegistrator()
	{

	}

	public static QueryRegistrator build(EntityManager em)
	{
		QueryRegistrator qr = new QueryRegistrator();
		qr.em = em;
		return qr;
	}

	/**
	 * enregistre la requête auprès de l'EntityManagerFactory.
	 * Cette requête deviendra alors une NamedQuery accessible via son enum.
	 * 
	 * @param query
	 * @return instance courante pour permettre du method chaining.
	 */
	public QueryRegistrator register(RegistrableQuery query)
	{
		Query realQuery = this.em.createQuery(query.getQuery());
		EntityManagerFactory emf = em.getEntityManagerFactory();
		emf.addNamedQuery(query.getIdentifier(), realQuery);
		if (log.isLoggable(Level.INFO))
		{
			log.info(String.format("Registered : %s >> %s", query.getIdentifier(), realQuery));
		}
		return this;
	}
	
	/**
	 * enregistre la requête auprès de l'EntityManagerFactory.
	 * Cette requête deviendra alors une NamedQuery accessible via son enum.
	 * 
	 * @param query
	 * @return instance courante pour permettre du method chaining.
	 */
	public QueryRegistrator register(RegistrableQuery... queries)
	{
		Stream.of(queries).forEach(this::register);
		return this;
	}

}
