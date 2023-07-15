package deque;


import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    private DequeNode<T> first;
    private DequeNode<T> last;
    private int size;
    private class DequeNode<T> {
        private T val;
        private DequeNode<T> front;
        private DequeNode<T> next;

        DequeNode(T val, DequeNode<T> front, DequeNode<T> next) {
            this.val = val;
            this.front = front;
            this.next = next;
        }

        T getVal() {
            return val;
        }

    }
    private class Iteratorll<T> implements Iterator<T> {
        private DequeNode<T> iterator;

        Iteratorll() {
            iterator = null;
        }

        Iteratorll(DequeNode<T> iterator) {
            this.iterator = iterator;
        }

        @Override
        public boolean hasNext() {
            return iterator != null;
        }

        public T next() {
            T returnValue = iterator.getVal();
            iterator = iterator.next;
            return returnValue;
        }


    }

    public LinkedListDeque() {
        first = null;
        last = null;
        size = 0;
    }


    public void addFirst(T item) {
        if (first == null) {
            DequeNode<T> temp = new DequeNode<>(item, null, null);
            first = last = temp;
        } else {
            DequeNode<T> temp = new DequeNode<>(item, null, first);
            first.front = temp;
            first = temp;
        }
        size++;
    }

    public void addLast(T item) {
        if (last == null) {
            DequeNode<T> temp = new DequeNode<>(item, null, null);
            first = last = temp;
        } else {
            DequeNode<T> temp = new DequeNode<>(item, last, null);
            last.next = temp;
            last = temp;
        }
        size++;
    }


    public int size() {
        return size;
    }

    public void printDeque() {
        DequeNode<T> temp = first;
        while (temp != null) {
            System.out.print(temp.getVal());
            temp = temp.next;
            if (temp != null) {
                System.out.println();
            }
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T result = first.getVal();
        if (size == 1) {
            first = last = null;
            size = 0;
            return result;
        }
        //TODO
        DequeNode<T> temp = first.next;
        if (temp != null) {
            first.next = null;
            first = temp;
            temp.front = null;
        }
        size--;
        return result;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T result = last.getVal();
        if (size == 1) {
            first = last = null;
            size = 0;
            return result;
        }
        last = last.front;
        size--;
        return result;
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        DequeNode<T> temp = first;
        while (index != 0) {
            index--;
            temp = temp.next;
        }
        return temp.getVal();
    }

    public T getRecursive(int index) {
        return recursive(index, first);
    }

    private T recursive(int index, DequeNode<T> node) {
        if (node == null) {
            return null;
        }
        if (index == 0) {
            return node.getVal();
        } else {
            return recursive(index - 1, node.next);
        }
    }

    public Iterator<T> iterator() {
        return new Iteratorll<T>(this.first);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof Deque)) {
            return false;
        }

        Deque<T> obj = (Deque<T>) o;
        if (obj.size() != this.size()) {
            return false;
        }
        for (int i = 0; i < obj.size(); i += 1) {
            T itemFromObj =  obj.get(i);
            T itemFromThis = this.get(i);
            if (!itemFromObj.equals(itemFromThis)) {
                return false;
            }
        }
        return true;
    }
}


