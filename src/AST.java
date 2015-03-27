import java.util.Stack;

/**This class represents the expression as a syntactic tree and
 * has a stack for the operators, a stack for the operands, a stack for
 * the postfixated form of the given expression, an array of strings which
 * contains the strings separated by spaces in the expression ( it could
 * be viewed as the tree's nodes ) and an int named current which represents
 * the curren node viewed as the root of the AST.
 * The class also is an implementation of the interface Visitable and implements
 * the visit method which calls the visit method of the visitor given as parameter.  
 * 
 * @author Diana
 *
 */
public class AST implements Visitable{
	public Stack<String> operations=new Stack<String> ();
	public Stack<Double> operators=new Stack<Double> ();
	public Stack<String> postfixat=new Stack<String> ();
	public String [] parser;
	public String postfixated_expression;
	public int current;
	
	@Override
	public void accept(Visitor v) throws SyntacticException,EvaluatorException {
		v.visit(this);
		
	}
	
	
}
