import Exceptions.MalformedExpressionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    private Client client;

    @BeforeEach
    void setCalculatorVisitorUp(){
        this.client = new Client();
    }

    @Test
    void evaluateExpressionTest1() {
        var tokenList=new ArrayList<>(Arrays.asList(
                new Operand(15),
                new Operand(5),
                new Operator(Operation.PLUS),
                new Operand(100),
                new Operator(Operation.MINUS)
        ));
        assertEquals(client.evaluateExpression(tokenList),-80);
    }

    @Test
    void evaluateExpressionTest2(){
        var tokenList2=  new ArrayList<>(Arrays.asList(
                new Operand(50),
                new Operand(2),
                new Operator(Operation.DIVIDE),
                new Operand(10),
                new Operator(Operation.MULTIPLY)
        ));
        assertEquals(client.evaluateExpression(tokenList2),250);
    }
    @Test
    void evaluateExpressionTestException(){
        var tokenList2=  new ArrayList<>(Arrays.asList(
                new Operand(1),
                new Operand(2),
                new Operator(Operation.DIVIDE),
                new Operator(Operation.MULTIPLY)
        ));
        assertThrows(RuntimeException.class,()->{client.evaluateExpression(tokenList2);});
    }

}