package MyLinkedList;

public class MyNode<T> {
    private MyNode<T> nextNode;
    private MyNode<T> previousNode;
    private T value;

    public MyNode(MyNode<T> nextNode, MyNode<T> previousNode, T value) {
        this.nextNode = nextNode;
        this.previousNode = previousNode;
        this.value = value;
    }

    public MyNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(MyNode<T> nextNode) {
        this.nextNode = nextNode;
    }

    public MyNode<T> getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(MyNode<T> previousNode) {
        this.previousNode = previousNode;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
