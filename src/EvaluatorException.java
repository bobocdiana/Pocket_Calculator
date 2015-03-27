
/**This class represents an Evaluator excption which is thrown
 * whenever an ilegally operation has to be done in the expression
 * such as log(0).
 * 
 * @author Diana
 *
 */
public class EvaluatorException extends RuntimeException {

	private static final long serialVersionUID = 5729607299984502799L;

	public static String NEG_SQRT = "negative value passed to square root";
	public static String NEG_LOG = "negative value passed to logarithm";
	public static String ZERO_LOG = "expression under logarithm evaluates to zero";
	
	//TODO	
	public static String message = "EvaluatorException";

	EvaluatorException() {
		
	}

	EvaluatorException(String s) {
		message = s;
	}
	
	public String getMessage() {
		return message;
	}
}
