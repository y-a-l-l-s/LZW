import java.util.*;
import java.io.*;
import java.util.HashMap;
public class Encoder {
	private HashMap <String,Integer> dict;
	private int counter, maxCodes;
	public Encoder(int maxCodes) {
		dict = new HashMap<String, Integer>();
		counter = 0;
		this.maxCodes = maxCodes;
		setup(256);
	}
	public void encode (String fileName) throws IOException {
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
		}
		br.close();
		bw.flush();
		bw.close();
	}

	//writes the Integer onto the output file
	private void write (Integer num, BufferedWriter writer) {
		try {
			int c1 = (int) (num / 256);
			writer.write((char)c1);
			int c2 = (int) (num % 256);
			writer.write((char)c2);
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
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
		if (counter < maxCodes) {
			dict.put(str, counter);
			counter++;
		}
		return dict.get(str.substring(0,str.length()-1));
	}
}
