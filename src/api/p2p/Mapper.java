package api.p2p;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


public abstract class Mapper implements MapInterface, ReduceInterface{
	
	public int id;
	private TreeMap<String, String> map;
	
	public Mapper(int id) {
		this.id = id;
	}
	
	public void map(String line) throws IOException{

		String [] values = line.split(";");
		
		for (String value : values) {
			String outputKey = new String(value.toUpperCase().trim());
			String outputValue = new String();
			map.put(outputKey, outputValue);
		}
		
		//1 
//		String [] values = line.split(";");
//		
//		String key = values[0];
//		String value = line;
//		
//		map.put(key, value);
//		
			
	}
	
	public List<String> reduce(String search) throws IOException{
		List<String> values = new ArrayList<String>();
		for (String s : map.keySet()) {
			if (s.contains(search.toLowerCase())) {
				values.add(map.get(s));
			}
		}
		return values;
	}
}
