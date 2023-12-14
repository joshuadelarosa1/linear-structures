package cs207.linear;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.io.PrintWriter;



public class IteratorPriorityQueue {

  public static void main(String[] args) throws Exception{

    int cap = 15;
    PrintWriter pen = new PrintWriter(System.out, true);

    Comparator<String> compareLengths = new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        if (l1 < l2) {
          return -1;
        } else if (l1 == l2) {
          int result = s1.compareTo(s2);
          return result;
        } else {
          return 1;
        } // else (l1 > l2)
      } // compare(String,String)
    };

    BuiltinPriorityQueue<String> pq;

    pq = new BuiltinPriorityQueue<String>(cap, compareLengths);

    ReportingLinearStructure<String> expt = new ReportingLinearStructure<String>(pq, "expt");
    
    expt.isEmpty();
    expt.put("one");
    expt.peek();
    expt.put("abc");
    expt.peek();
    expt.put("two");
    expt.peek();
    expt.get();
    expt.put("three");
    expt.peek();
    expt.put("four");
    expt.get();
    expt.get();
    expt.put("x");
    expt.peek();
    expt.get();
    expt.get();
    expt.get();


  } 
}