package Node;

public class DoubleLinkedNode<T> {
    private DoubleLinkedNode<T> nextNode;
    private DoubleLinkedNode<T> previousNode;
    private T value;

    public DoubleLinkedNode(DoubleLinkedNode<T> nextNode, DoubleLinkedNode<T> previousNode, T value) {
        this.nextNode = nextNode;
        this.previousNode = previousNode;
        this.value = value;
    }

    public DoubleLinkedNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(DoubleLinkedNode<T> nextNode) {
        this.nextNode = nextNode;
    }

    public DoubleLinkedNode<T> getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(DoubleLinkedNode<T> previousNode) {
        this.previousNode = previousNode;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
