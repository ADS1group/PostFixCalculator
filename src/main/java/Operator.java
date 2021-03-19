public class Operator extends Token {
    private Operation operation;

    public Operator(Operation operation) {
        this.operation = operation;
    }

    @Override
    public void accept(CalculatorVisitor visitor) {
        if(visitor!=null) {
            visitor.visit(this);
        }
    }

    public Operation getOperation() {
        return operation;
    }
}
