import Exceptions.EmptyListException;
import Exceptions.MalformedExpressionException;

import java.util.EmptyStackException;

public class CalculatorVisitor implements Visitor, Calculator {

    private LinkedStack<Token> tokenStack;

    public CalculatorVisitor() {
        tokenStack = new LinkedStack<>();
    }

    private void pushOperand(Operand operand) {
        if (operand != null) {
            tokenStack.push(operand);
        }

    }

    private void performOperation(Operator operator) throws MalformedExpressionException {
        Token o1;
        Token o2;
        try {
            o1 = tokenStack.pop();
            o2 = tokenStack.pop();
        } catch (EmptyStackException e) {
            throw new MalformedExpressionException("Malformed Expression Exception");
        }
        if (!(o1 instanceof Operand) || !(o2 instanceof Operand)) {
            throw new MalformedExpressionException("Malformed Expression Exception");
        }
        Operand operator1 = (Operand) o1;
        Operand operator2 = (Operand) o2;

        Operand result;
        switch (operator.getOperation()) {

            case MINUS:
                result = new Operand(operator2.getValue() - operator1.getValue());
                tokenStack.push(result);
                break;
            case PLUS:
                result = new Operand(operator2.getValue() + operator1.getValue());
                tokenStack.push(result);
                break;
            case MULTIPLY:
                result = new Operand(operator2.getValue() * operator1.getValue());
                tokenStack.push(result);
                break;
            case DIVIDE:
                result = new Operand(operator2.getValue() / operator1.getValue());
                tokenStack.push(result);
                break;
        }

    }

    @Override
    public int getResult() throws MalformedExpressionException {
         {
            try {
                return ((Operand) tokenStack.pop()).getValue();
            } catch (EmptyStackException e) {
                throw new MalformedExpressionException("Malformed Expression Exception");
            }
        }
    }

    @Override
    public void visit(Operand operand) {
        if (operand != null) {
            tokenStack.push(operand);
        }


    }

    @Override
    public void visit(Operator operator) {
        if (operator != null) {
            try {
                performOperation(operator);
            } catch (MalformedExpressionException e) {
                throw new RuntimeException("Malformed Expression Exception");
            }
        }
    }


}
