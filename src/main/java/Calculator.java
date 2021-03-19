import Exceptions.MalformedExpressionException;

import javax.xml.crypto.MarshalException;

public interface Calculator {
    int getResult() throws MalformedExpressionException;
}
