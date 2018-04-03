/*
 Jackson Frank
 File: Anagrams.java
 Purpose: Discovers all the anagrams of a given word
 */

import java.util.*;
import java.io.*;

public class Anagrams {
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		String file = "words_alpha.txt";
		
		Scanner console = new Scanner(System.in);
		
		System.out.print("Word: ");
		String str = console.next();
		
		Map<String, Set<String>> canonicals = getMap(file);
	}
	
	public static Map<String, Set<String>> getMap(String file) throws FileNotFoundException {
		Scanner input = new Scanner(new File("src/" + file));
		Map<String, Set<String>> map = new HashMap<String, Set<String>>();
		
		while(input.hasNext()) {
			String current = input.next();
			char[] array = current.toCharArray();
			for(int i = array.length-1; i > 0; i--) {
				char lg = array[0];
				int g;
				for(g = 0; g < i; g++) {
					if(array[g] > lg) {
						lg = current.charAt(g);
					}
					
				}
				char temp = array[g];
				array[g] = array[i];
				array[i] = temp;
			}
			String canonical = array.toString();
			if(map.containsKey(canonical)) {
				Set<String> set = new HashSet<String>();
				set.addAll(map.get(canonical));
				set.add(current);
				map.put(canonical, set);
			}
			else {
				Set<String> set = new HashSet<String>();
				set.add(current);
				map.put(canonical, set);
			}
		}
		
		return map;
	}

}
