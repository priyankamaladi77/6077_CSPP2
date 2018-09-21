import java.io.*;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.regex.*;
import java.util.Set;


class BagofWords {
	List<Info> words;
	HashMap<String, Integer> map;
	HashMap<String, List<Integer>> euclidean;
	private int count;

	BagofWords() {
		words = new List<Info>();
		map = new HashMap<String, Integer>();
		euclidean = new HashMap<String, List<Integer>>();
		int count = 0;
	}

	public void addTo(Info info) {
		words.add(info);
	}

	public List getD() {
		return words;
	}
	public HashMap getMap() {
		return map;
	}
	public void countofword(Info info1) {
		String[] info = null;
		int count1 = 0;
		if (words.indexOf(info1) != -1) {
			info = words.get(words.indexOf(info1)).formatinfo();
		}
		for (int i = 0; i < info.length; i++) {
			if (map.containsKey(info[i])) {
				int count2 = map.get(info[i]);
				map.put(info[i], count2 + 1);
			} else {
				map.put(info[i], 1);
				count1 += 1;
			}
			this.count = count1;
		}
	}

	public double frequencycount(BagofWords bag) {
		HashMap<String, Integer> map1 = bag.getMap();
		Set key1 = map.keySet();
		Set key2 = map1.keySet();
		String[] keys1 = key1.toString().replace("[", "").replace("]", "").split(", ");
		String[] keys2 = key2.toString().replace("[", "").replace("]", "").split(", ");
		for (int i = 0; i < keys1.length; i++) {
			for (int j = 0; j < keys2.length; j++) {
				if (key2.contains(keys1[i]) && key1.contains(keys2[j])) {
						List<Integer> value = new List<Integer>();
						value.add(map.get(keys1[i]));
						value.add(map1.get(keys1[i]));
						euclidean.put(keys1[i], value);
				} else if(!key1.contains(keys2[j])) {
					List<Integer> value1 = new List<Integer>();
					value1.add(0);
					value1.add(map1.get(keys2[j]));
					euclidean.put(keys2[j], value1);
				} else if(!key2.contains(keys1[i])){
					List<Integer> value2 = new List<Integer>();
					value2.add(map.get(keys1[i]));
					value2.add(0);
					euclidean.put(keys1[i], value2);
				}
			}
		}

		double a = 0;
		double b = 0;
		int dot = 0;
		Set key = euclidean.keySet();
		String[] k = key.toString().replace("[", "").replace("]", "").split(", ");
		for (int i = 0; i < euclidean.size(); i++) {
			a += Math.pow(euclidean.get(k[i]).get(0), 2);
			b += Math.pow(euclidean.get(k[i]).get(1), 2);
			dot += euclidean.get(k[i]).get(0) * euclidean.get(k[i]).get(1);
		}
		double res = dot/(Math.sqrt(a) * Math.sqrt(b));
		return res * 100;
	}
	public int count() {
		return count;
	}
}
class Info {
	String file1;
	Info(Scanner sc1) {
		file1 = "";
		while (sc1.hasNextLine()) {
			file1 += sc1.nextLine();
			file1 += " ";
		}
		file1 = file1.toLowerCase();
	} 

	public String[] formatinfo() {
		file1 = file1.replaceAll("[^\\p{Alpha} ]", "");
		String[] info = file1.split(" ");
		return info;
	}

	public String getString() {
		return this.file1;
	}
}

public class Solution {
	public static void main(String[] args) {
		BagofWords f1 = new BagofWords();
		Scanner s = null;
		File files = new File("File4.txt");
		try {
		s = new Scanner(files);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Info f = new Info(s);
		f1.addTo(f);
		f1.countofword(f);
		System.out.println(f1.count());
		
		BagofWords f2 = new BagofWords();
		files = new File("File5.txt");
		try {
			s = new Scanner(files);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Info fi = new Info(s);
		f2.addTo(fi);
		f2.countofword(fi);
		System.out.println(f1.frequencycount(f2));
	}
}
