Using TreeMap
import java.util.Map;
import java.util.TreeMap;

public class Program10{
  private static final Integer ONE = new Integer(1);

  public static void main(String args[]) {
    Map m = new TreeMap();

    m.put("a Key", "a Value");
    m.put("Java2s", "www.java2s.com");

    System.out.println(m.size() + " keys detected:");
    System.out.println(m);
  }
}
