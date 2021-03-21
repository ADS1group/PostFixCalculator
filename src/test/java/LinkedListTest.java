import Exceptions.EmptyListException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    private List<String> linkedList;

    @BeforeEach
    void setLinkedListUp() {
        this.linkedList = new LinkedList<String>();
    }

    @Test
    void isEmptyZero() {
        assertTrue(linkedList.isEmpty());
    }

    @Test
    void isEmptyOne() {
        this.linkedList.addToFront("ABOBA");
        assertFalse(this.linkedList.isEmpty());
    }

    @Test
    void sizeZero() {
        assertEquals(0,this.linkedList.size());
    }

    @Test
    void sizeOne() {
        this.linkedList.addToFront("ABOBA");
        assertEquals(1,this.linkedList.size());
    }

    @Test
    void sizeMany() {
        this.linkedList.addToFront("ABOBA");
        this.linkedList.addToFront("ABOBA");
        assertEquals(2,this.linkedList.size());
    }

    @Test
    void addToFrontAndRemoveFirstOne() throws EmptyListException {
        this.linkedList.addToFront("ABOBA");
        assertEquals("ABOBA",this.linkedList.removeFirst());
    }

    @Test
    void addToFrontAndRemoveFirstMany() throws EmptyListException {
        this.linkedList.addToFront("ABOBA1");
        this.linkedList.addToFront("ABOBA2");
        assertEquals("ABOBA2",this.linkedList.removeFirst());
        assertEquals("ABOBA1",this.linkedList.removeFirst());
    }

    @Test
    void removeFirstException() {
        assertThrows(EmptyListException.class, ()->{
            this.linkedList.removeFirst();
        });
    }
}