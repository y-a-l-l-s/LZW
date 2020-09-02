import.java.util.*;
import java.io.*;
import java.util.HashMap;
public class Encoder {
	private HashMap<String,Integer> hm;
	private Integer counter;
	public Encoder() {
		hm = new HashMap<String, Integer>;
		counter = 0;
	}
  public void encode(String filename) {
    BufferedReader br = new BufferedReader(new File(filename));
    BufferedWriter bw = new BufferedWriter(new FileWriter(filename+".lzw"));

	}

	private void firstChar (char c) {
		hm.put(c, 0);
		counter++;
	}

	private boolean isKey (String s) {
		return hm.containsKey(s);
	}

	public Integer addKey (String str) { //adds new string to HashMap with the value of counter. Increments counter. Returns the associated value of str - 1 letter.
		hm.put(str, counter);
		counter++;
		return hm.get(str.substring(0,str.length()-1));;
	}
}
