package net.laddercode.util.collection;

import net.laddercode.util.type.Type;

public class StrHashMapUtil {
	
	public static StrHashMap copy(StrHashMap map, String[] keys) {
		StrHashMap result = new StrHashMap();
		
		for (String k : keys) {
			if (map.containsKey(k)) {
				result.put(k, map.get(k));
			}
			else {
				result.put(k, Type.NA);
			}
		}
		
		return result;
	}

}
