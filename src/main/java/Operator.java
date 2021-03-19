public class Operator extends Token {
    private Operation operation;

    @Override
    public void accept(CalculatorVisitor visitor) {

    }

    public Operation getOperation() {
        return operation;
    }
}
