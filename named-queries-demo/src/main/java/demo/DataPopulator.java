package demo;

import java.util.List;

import javax.persistence.EntityManager;

import demo.model.GameGenre;
import demo.model.VideoGame;

/**
 * classe responsable de l'insertion d'un ensemble de données en jeu de test.
 * 
 * @author fxrobin
 *
 */
public class DataPopulator
{
	static void populate(EntityManager em)
	{
		// Best ATARI-ST Games ever !
		List<VideoGame> data = ListPopulator.start()
				.add("Xenon", GameGenre.SHOOT_THEM_UP)
				.add("Xenon 2", GameGenre.SHOOT_THEM_UP)
				.add("Rick Dangerous", GameGenre.PLATFORM)
				.add("Rick Dangerous 2", GameGenre.PLATFORM)
				.add("Stunt Car Racer", GameGenre.RACING)
				.build();

		// on les persiste en base via l'entity manager.
		em.getTransaction().begin();
		data.forEach(em::persist);
		em.getTransaction().commit();
	}

}
