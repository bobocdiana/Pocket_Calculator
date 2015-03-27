public interface Visitable {
	public void accept(Visitor v) throws SyntacticException,EvaluatorException;

}
