import Exceptions.EmptyListException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedStackTest {
    private Stack<String> linkedStack;

    @BeforeEach
    void setLinkedStackUp() {
        this.linkedStack = new LinkedStack<>();
    }

    @Test
    void isEmptyZero() {
        assertTrue(this.linkedStack.isEmpty());
    }

    @Test
    void isEmptyOne() {
        this.linkedStack.push("ABOBA");
        assertFalse(this.linkedStack.isEmpty());
    }

    @Test
    void pushAndPopOne() throws EmptyListException {
        this.linkedStack.push("ABOBA");
        assertEquals("ABOBA",this.linkedStack.pop());
    }

    @Test
    void pushAndPopMany() throws EmptyListException {
        this.linkedStack.push("ABOBA1");
        this.linkedStack.push("ABOBA2");
        assertEquals("ABOBA2",this.linkedStack.pop());
        assertEquals("ABOBA1",this.linkedStack.pop());

    }

    @Test
    void popEmptyStackException() {
        assertThrows(EmptyStackException.class,()->{
            this.linkedStack.pop();
        });
    }
}