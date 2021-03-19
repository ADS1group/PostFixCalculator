import Exceptions.MalformedExpressionException;

import java.util.ArrayList;
import java.util.Arrays;

public class Client {
    private CalculatorVisitor calculatorVisitor=new CalculatorVisitor();

    public static void main(String[] args) {
        Client client = new Client();
var tokenList=new ArrayList<>(Arrays.asList(
                new Operand(15),
                new Operand(5),
                new Operator(Operation.PLUS),
                new Operand(100),
                new Operator(Operation.MINUS)
        ));

        System.out.println("5 + 2 - 100 = " + client.evaluateExpression(tokenList));

        var tokenList2=  new ArrayList<>(Arrays.asList(
                new Operand(50),
                new Operand(2),
                new Operator(Operation.DIVIDE),
                new Operand(10),
                new Operator(Operation.MULTIPLY)
        ));
        System.out.println("50 / 2 * 10 = " + client.evaluateExpression(tokenList2));




    }

    public int evaluateExpression(ArrayList<Token> tokenList) {
        for (Token token: tokenList) {
            token.accept(calculatorVisitor);
        }
        try{
            return calculatorVisitor.getResult();
        }catch (MalformedExpressionException e){
            throw new RuntimeException("Malformed Expression Exception");
        }
    }
}
