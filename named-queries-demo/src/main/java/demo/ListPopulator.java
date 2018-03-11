package demo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import demo.model.GameGenre;
import demo.model.VideoGame;

public class ListPopulator
{
    private List <VideoGame> data = new LinkedList<>();
	
	private ListPopulator() {}
	
	public static ListPopulator start()
	{
		return new ListPopulator();
	}
	
	public ListPopulator add(String name, GameGenre gameGenre)
	{
		data.add(new VideoGame(name, gameGenre));
		return this;
	}
	
	public List<VideoGame> build()
	{
		return new ArrayList<>(data);
	}
}
