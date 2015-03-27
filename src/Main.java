import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	public static void main (String [] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    String s,expression;
	    ExpressionParser p=new ExpressionParser();
	    try {
			while ((expression = in.readLine()) != null && expression.length() != 0) {
			//  System.out.println(s);
			//  expression=p.postfixat(s);
			  System.out.println("dupa: "+expression);
			  System.out.println(p.eval(expression));
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (SyntacticException e) {
			e.printStackTrace();
		}
		
	}
}
