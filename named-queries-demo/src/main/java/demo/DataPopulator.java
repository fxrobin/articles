package demo;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;

import demo.model.GameGenre;
import demo.model.VideoGame;

/**
 * classe responsable de l'insertion d'un ensemble de données
 * en jeu de test.
 * 
 * @author fxrobin
 *
 */
public class DataPopulator
{
	static void populate(EntityManager em)
	{
		Map <String, GameGenre> intialData = new HashMap<>();
		
		// Best ATARI-ST Games ever !
		intialData.put("Xenon", GameGenre.SHOOT_THEM_UP);
		intialData.put("Xenon 2", GameGenre.SHOOT_THEM_UP);
		intialData.put("Rick Dangerous", GameGenre.PLATEFORM);
		intialData.put("Rick Dangerous 2", GameGenre.PLATEFORM);
		intialData.put("Stunt Car Racer", GameGenre.RACING);	
		
		// on les persiste en base via l'entity manager.
		em.getTransaction().begin();
		intialData.entrySet().stream().map(e -> new VideoGame(e.getKey(), e.getValue())).forEach(em::persist);;
		em.getTransaction().commit();
	}

}
