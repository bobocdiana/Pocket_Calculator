
/**This class represents a SyntacticException which is thrown whenever
 * a syntactic mistake is discovered in the expression.
 * 
 * @author Diana
 *
 */
public class SyntacticException extends Exception {

	private static final long serialVersionUID = 2916684190445948659L;
	
	//TODO
	String message = "SyntacticException";

	SyntacticException() {

	}

	SyntacticException(String s) {
		message = s;
	}
	
	public String getMessage() {
		return message;
	}
}
