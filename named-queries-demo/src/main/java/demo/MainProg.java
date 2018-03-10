package demo;

import javax.persistence.EntityManager;

import demo.model.FacadeVideoGame;
import demo.model.GameGenre;
import demo.model.VideoGameQuery;
import demo.registrator.QueryRegistrator;

/**
 * démonstration des NamedQuery enregistrée de manièré programmatique.
 * 
 * @author fxrobin
 *
 */
public class MainProg
{
	public static void main(String[] args)
	{
		// 1ère étape : récupération d'un EntityManager et peuplement de données exemple.
		EntityManager em = ApplicationSingleton.createEntityManager();
		DataPopulator.populate(em);
		
		// Création de l'enregistreur de query JPQL et enregistrement de celle de l'enum.
		QueryRegistrator.build(em).register(VideoGameQuery.values());
			
		// on appelle la façade pour obtenir les jeux de type SHOOT_THEM_UP
		System.out.println("Jeux : Shoot them up");
		FacadeVideoGame.findByGenre(em, GameGenre.SHOOT_THEM_UP).forEach(System.out::println);
		
		// on appelle la façade pour obtenir les jeux commençant par "Rick"
		System.out.println("Jeux : commençant par Rick");
		FacadeVideoGame.findByNameLike(em, "Rick%").forEach(System.out::println);
		
		em.close();
	}

}
