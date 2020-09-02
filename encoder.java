import.java.util.*;
import java.io.*;
import java.util.HashMap;
public class Encoder {
	private HashMap<String,Integer> dict;
	private Integer counter;
	public Encoder() {
		dict = new HashMap<String, Integer>;
		counter = 0;
	}
  public void encode(String filename) {
    BufferedReader br = new BufferedReader(new File(filename));
    BufferedWriter bw = new BufferedWriter(new FileWriter(filename+".lzw"));

	}
	//
	private void firstChar (char c) {
		dict.put(c, 0);
		counter++;
	}
	//
	private boolean isKey (String s) {
		return dict.containsKey(s);
	}
	//adds new string to HashMap with the value of counter. Increments counter. Returns the associated value of str - 1 letter.
	public Integer addKey (String str) { 
		dict.put(str, counter);
		counter++;
		return dict.get(str.substring(0,str.length()-1));;
	}
}
