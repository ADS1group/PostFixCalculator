import Exceptions.MalformedExpressionException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorVisitorTest {
    private Calculator calculator;

    @BeforeEach
    void setCalculatorUp()
    {
        calculator = new CalculatorVisitor();
    }

    @Test
    void getResultException() {
        assertThrows(MalformedExpressionException.class,()->{
            calculator.getResult();
        });
    }
}