package academy.kovalevskyi.codingbootcamp.week1.day3;

import java.util.List;
import java.util.function.Function;

public class ListHelper {

    public static <T> int length(ListNode<T> someNode) {
        int size = 0;
        ListNode<T> newList = someNode;
        while (newList.getPrev() != null) {
            newList = newList.getPrev();
            size ++;
        }
        while (newList.getNext() != null) {
            newList = newList.getNext();
            size++;
        }
        return  ++size;
    }

    public static <T> ListNode<T> createOne(T value) {
        ListNode<T> newValue = new ListNode<>(null, null, value);
        return newValue;
    }

    public static <T> ListNode<T> addToEnd(ListNode<T> someNode, T newValue) {
        ListNode<T> newList = someNode;
        ListNode<T> newNode = createOne(newValue);
        while (newList.getNext() != null) {
            newList = newList.getNext();
        }
        newNode.setPrev(newList);
        newList.setNext(newNode);
        return newNode;
    }

    public static <T> ListNode<T> addToStart(ListNode<T> someNode, T newValue) {
        ListNode<T> newList = someNode;
        ListNode<T> newNode = createOne(newValue);
        while (newList.getPrev() != null) {
            newList = newList.getPrev();
        }
        newNode.setNext(newList);
        newList.setPrev(newNode);
        return newNode;
    }

    public static <T> boolean contains(ListNode<T> someNode, T value) {
        ListNode<T> newList = someNode;
        while (newList.getPrev() != null) {
            if (newList.getPrev().getValue().equals(value)) {
                return true;
            }
            newList = newList.getPrev();
        }
        while (newList.getNext() != null) {
            if (newList.getNext().getValue().equals(value)) {
                return true;
            }
            newList = newList.getNext();
        }
        return false;
    }

    public static <T, R> ListNode<R> map(ListNode<T> someNode, Function<T, R> mapFunction) {
        ListNode<T> newNode = someNode;
        while (newNode.getPrev() != null) {
            newNode = newNode.getPrev();
        }
        ListNode<R> newListR = createOne(mapFunction.apply(newNode.getValue()));
        newNode = newNode.getNext();
        while (newNode.getNext() != null) {
            R newValue = mapFunction.apply(newNode.getValue());
            addToEnd(newListR, newValue);
            newNode = newNode.getNext();

        }
        return addToEnd(newListR, mapFunction.apply(newNode.getValue()));

    }

    public static <T> void connect(ListNode<T> someNode, ListNode<T> to) {
        someNode.setNext(to);
        to.setPrev(someNode);
    }

    public static <T> ListNode<T> insertAfter(ListNode<T> prev, T newValue) {
        ListNode<T> thisList = prev;
        ListNode<T> thisNext = thisList.getNext();
        ListNode<T> newList = createOne(newValue);
        thisList.setNext(newList);
        newList.setPrev(thisList);
        newList.setNext(thisNext);
        if (thisNext != null) {
            thisNext.setPrev(newList);
        }
        return newList;
    }

    public static <T> void insertAfter(ListNode<T> prev, T[] newValue) {
        for (int i = 0; i < newValue.length; i++) {
            prev = insertAfter(prev, newValue[i]);
        }
    }

    public static <T> void delete(ListNode<T> current) {
        if (current.getPrev() == null) {
            current.getNext().setPrev(null);
            return;
        }
        if (current.getNext() == null) {
            current.getPrev().setNext(null);
            return;
        }
        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());
    }
}
