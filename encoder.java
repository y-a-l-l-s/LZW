import java.util.*;
import java.io.*;
import java.util.HashMap;
public class Encoder {
	private HashMap<String,Integer> dict;
	private Integer counter;
	public Encoder(int chars) {
		dict = new HashMap<String, Integer>();
		counter = 0;
		setup(chars);
	}
	public void encode (String fileName) {

    BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
    BufferedWriter bw = new BufferedWriter(new FileWriter(new File(fileName.substring(0, fileName.length()-4)+".lzw")));
    char current;
    String temp = "";
    while (br.ready()) {
      current = (char) br.read();
      temp += current;
      while (isKey(temp) && br.ready()) {
        current = (char) br.read();
        temp += current;
      }
			if (br.ready()) {
      	write(addKey(temp), bw);
      	temp = "" + current;
			} else {
				if (isKey(temp)) {
					write(dict.get(temp), bw);
				} else {
					write(addKey(temp), bw);
					write(dict.get(current), bw);
				}
			}
	    br.close();
			bw.flush();
			bw.close();
    }
  }

  //writes the Integer onto the output file
  private void write (Integer num, BufferedWriter writer) {
          String tempString = "" + num;
          writer.write(tempString);
  }

	private void setup (int chars) {
		for (int i = 0; i < chars; i++) {
			dict.put("" + (char) i, i);
		}
		counter = chars;
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
