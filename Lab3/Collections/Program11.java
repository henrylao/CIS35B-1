import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class Program11{
  public static void main(String[] args) {
    LinkedHashMap<String,String> lHashMap = new LinkedHashMap<String,String>();

    lHashMap.put("1", "One");
    lHashMap.put("2", "Two");
    lHashMap.put("3", "Three");

    Set st = lHashMap.keySet();

    Iterator itr = st.iterator();

    while (itr.hasNext()){
      System.out.println(itr.next());
    }
    st.remove("2");

    boolean blnExists = lHashMap.containsKey("2");
    System.out.println(blnExists);
  }
}
