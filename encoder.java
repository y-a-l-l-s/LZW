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
	    BufferedWriter bw = new BufferedWriter(new FileWriter(filename.substring(0, filename.length-4)+".lzw"));
			setup();
	    char current;
	    String temp = "";
	    while (br.ready()) {
	      current = br.read();
	      temp += current;
	      while (temp.isKey() && br.ready()) {
	        current = br.read();
	        temp += current;
	      }
				if (br.ready()) {}
	      	write(addKey(temp));
	      	temp = current;
				} else {
					if (isKey(temp) {
						write(temp);
					} else {
						write(addKey(temp));
						write(current);
					}
				}
    }
    br.close();
	}

  //writes the Integer onto the output file
  private void write(Integer num, BufferedWriter writer) { 
          String tempString = num;
          writer.write(tempString);
          writer.flush();
          writer.close();
  }

	private setup (int chars) {
		for (i = 0; i < chars; i++) {
			dict.put(i, (char) i);
		}
		counter = chars
	}

	//
	private boolean isKey (String s) {
		return dict.containsKey(s);
	}

	//adds new string to HashMap with the value of counter. Increments counter. Returns the associated value of str - 1 letter.
	private Integer addKey (String str) {
		dict.put(str, counter);
		counter++;
		return dict.get(str.substring(0,str.length()-1));;
	}
}
