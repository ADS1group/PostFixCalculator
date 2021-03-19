import Exceptions.EmptyListException;


public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private int size;


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addToFront(T data) {
        Node<T> newNode = new Node<T>(data);
        newNode.setNext(head);
        head = newNode;
        size++;

    }


    @Override
    public T removeFirst() throws EmptyListException {
        if ( isEmpty() ){
            throw new EmptyListException("LinkedList is empty");
        }
        // Store the reference of the head pointer
        Node<T> temp = head;
        // Move the head pointer to the next node
        head = head.getNext();
        // Set the stored reference to null
        temp.setData(null);
        size--;
        return temp.getData();

    }

}
