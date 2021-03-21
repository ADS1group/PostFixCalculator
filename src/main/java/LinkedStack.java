import Exceptions.EmptyListException;

import java.util.EmptyStackException;

public class LinkedStack<T> implements Stack<T> {
    private List<T> linkedList;

    public LinkedStack() {
        linkedList = new LinkedList<>();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(T elm) {
        linkedList.addToFront(elm);
    }

    @Override
    public T pop() throws EmptyStackException{
        try {
            return linkedList.removeFirst();
        }
        catch (EmptyListException e)
        {
            throw new EmptyStackException();
        }

    }
}
