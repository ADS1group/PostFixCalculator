public class CalculatorVisitor extends Operand implements Visitor, Calculator {
    private LinkedStack<Token> tokenStack;

    private void pushOperand(Operand operand) {

    }

    private void performOperation(Operator operator) {
        
    }

    @Override
    public int getResult() {
        return 0;
    }

    @Override
    public void visit(Operand operand) {

    }

    @Override
    public void visit(Operator operator) {

    }


}
