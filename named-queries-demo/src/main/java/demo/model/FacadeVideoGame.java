package demo.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 * façade de requêtage sur l'entité VideoGame.
 * 
 * @author fxrobin
 *
 */
public final class FacadeVideoGame
{
	private FacadeVideoGame()
	{
		
	}
	
	public static List <VideoGame> findByGenre(EntityManager em, GameGenre genre)
	{
		// création de la namedQuery, identifiée par sa valeur dans l'enum.
		TypedQuery<VideoGame> query = em.createNamedQuery(VideoGameQuery.FIND_BY_GENRE.getIdentifier(), VideoGame.class);
		query.setParameter("gameGenre", genre);
		return query.getResultList();
	}
	
	public static List <VideoGame> findByNameLike(EntityManager em, String nameLike)
	{
		// création de la namedQuery, identifiée par sa valeur dans l'enum.
		TypedQuery<VideoGame> query = em.createNamedQuery(VideoGameQuery.FIND_BY_NAME_LIKE.getIdentifier(), VideoGame.class);
		query.setParameter("name", nameLike);
		return query.getResultList();
	}
	
}
