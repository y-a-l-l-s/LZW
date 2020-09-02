import.java.util.*;
import java.io.*;
import java.util.HashMap;
public class Encoder {
	private HashMap<String,Integer> hm;
	public Encoder() {
		hm = new HashMap<String, Integer>;
	}
	public void encode(String filename) {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		BufferedWriter bw = new BufferedWriter(new FileReader(filename+".lzw"));

	}
	
	private void firstChar (char c) {
		hm.put(c, 0);
		counter++;
	}
	
	private boolean isKey (String s) {
		return hm.containsKey(s);
	}
  


}
