package fr.fxjavadevblog.demo;

import java.util.Map;
import java.util.function.Supplier;

public class MapPopulator<K, V>
{

	private Map<K, V> data;

	public static <K, V> MapPopulator<K, V> init(Supplier<Map<K, V>> supplier)
	{
		MapPopulator<K, V> mp = new MapPopulator<>();
		mp.data = supplier.get();
		return mp;
	}

	public MapPopulator<K, V> put(K k, V v)
	{
		data.put(k, v);
		return this;
	}

	public Map<K,V> build()
	{
		return data;
	}

}
