package cs207.linear;
import java.io.PrintWriter;

/**
 * Assorted utilities for working with strings.
 *
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 */
public class StringUtils {
  // +------------------+--------------------------------------------
  // | Provided methods |
  // +------------------+

  /**
   * Determine whether the parens match in string.
   */
  public static boolean checkMatching(String str) throws Exception {
    Stack<Character> parens = new LinkedStack<Character>();

    for(int i = 0; i<str.length(); i++){
      if(str.charAt(i) == '(' || str.charAt(i) == '['){
        try{
        parens.push(str.charAt(i));
        } catch (Exception e){
          throw new Exception("Stack is Full");
        }
      }
      else if(str.charAt(i) == ')'){
        if(parens.pop() != '('){
          return false;
        }
      }
      else if(str.charAt(i) == ']'){
        if(parens.pop() != '['){
          return false;
        }
      }
    } 
    return parens.isEmpty();
  } // checkMatching

  // +-------------+-------------------------------------------------
  // | Experiments |
  // +-------------+
  /**
   * A quick set of experiments with checkMatching.
   */
  static void checkMatchingExperiments(PrintWriter pen) {
    checkMatchingExperiment(pen, "");
    checkMatchingExperiment(pen, "()");
    checkMatchingExperiment(pen, "(");
    checkMatchingExperiment(pen, ")");
    checkMatchingExperiment(pen, "Hello (there) (world (!!))");
    // Feel free to add your own
  } // PrintWriter()

  /**
   * A single experiment with checkMatching.
   */
  static void checkMatchingExperiment(PrintWriter pen, String str) {
    pen.print("checkMatching(\"" + str + "\") = ");
    pen.flush();
    try {
      pen.println(checkMatching(str));
    } catch (Exception e) {
      pen.println("*** ERROR *** " + e.toString());
    }
  } // checkMatchingExperiment(PrintWriter, String)

  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
   * Run a few experiments.
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    checkMatchingExperiments(pen);
    pen.close();
  } // main(String[])
} // class StringUtils