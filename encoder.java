public class Encoder {
  public Encoder() {

  }
  public void encode(String filename) {
    BufferedReader br = new BufferedReader(new FileReader(filename));
    BufferedWriter bw = new BufferedWriter(new FileReader(filename+".lzw"));


  }
}
