package academy.kovalevskyi.codingbootcamp.week1.day3;

public class ListNode {

    private ListNode<T> prev = null;
    private ListNode<T> next = null;
    private T value;

    public ListNode(ListNode<T> prev, ListNode<T> next, T value) {
        this.prev = prev;
        this.next = next;
        this.value = value;
    }

    public void setPrev(ListNode<T> prev) {
        this.prev = prev;

    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }

    public ListNode<T> getNext() {
        return this.next;
    }

    public ListNode<T> getPrev() {
        return this.prev;
    }

    public T getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "Node{prevValue="
                + this.prev.getValue()
                + ", nextValue="
                + this.next.getValue()
                + ", thisValue="
                + this.getValue()
                + "}";
    }

}