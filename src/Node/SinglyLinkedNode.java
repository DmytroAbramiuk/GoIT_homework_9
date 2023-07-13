package Node;

public class SinglyLinkedNode<T> {
    private SinglyLinkedNode<T> nextNode;
    private T value;

    public SinglyLinkedNode(SinglyLinkedNode<T> nextNode, T value) {
        this.nextNode = nextNode;
        this.value = value;
    }

    public SinglyLinkedNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(SinglyLinkedNode<T> nextNode) {
        this.nextNode = nextNode;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
