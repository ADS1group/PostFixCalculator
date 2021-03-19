public class Operand extends Token {
    private int value;

    @Override
    public void accept(CalculatorVisitor visitor) {

    }

    public int getValue() {
        return value;
    }
}
