
public interface Visitor {
	public void visit(AST expression) throws SyntacticException,EvaluatorException;
}
