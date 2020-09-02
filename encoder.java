public class Encoder {
  public Encoder() {

  }
  public void encode(String filename) {
    BufferedReader br = new BufferedReader(new File(filename));
    BufferedWriter bw = new BufferedWriter(new FileWriter(filename+".lzw"));


  }
}
