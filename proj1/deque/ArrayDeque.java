package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {

    private T[] arr;

    private int size;

    private int frontPos;
    private int lastPos;

    private class Iteratorad<T> implements Iterator<T> {
        private int pos = frontPos;
        private boolean flag = true;
        private T iter;

        Iteratorad() {
            iter = (T) arr[frontPos];
        }

        private void posNext() {
            pos++;
            while (pos < 0) {
                pos += arr.length;
            }
            if (pos >= arr.length) {
                pos %= arr.length;
            }

        }

        @Override
        public boolean hasNext() {
            if(size == 0) {
                return false;
            }
            return flag;
        }

        public T next() {
            iter = (T) arr[pos];
            if (pos == lastPos) {
                flag = false;
            }
            posNext();
            return iter;
        }

        public T getVal() {
            return iter;
        }
    }

    public Iterator<T> iterator() {

        return new Iteratorad<T>();
    }

    public ArrayDeque() {
        arr = (T[]) new Object[8];
        size = 0;
        frontPos = 0;
        lastPos = 0;
    }


    public void addFirst(T item) {
        if (size == arr.length) {
            resize(size * 2);
        }
        if (frontPos == 0 && lastPos == 0 && size == 0) {
            arr[0] = item;
            size += 1;
            return;
        }
        frontPos--;
        adjust();
        arr[frontPos] = item;
        size += 1;
    }

    public void addLast(T item) {
        if (size == arr.length) {
            resize(size * 2);
        }
        if (frontPos == 0 && lastPos == 0 && size == 0) {
            arr[0] = item;
            size += 1;
            return;
        }
        lastPos++;
        adjust();
        arr[lastPos] = item;
        size += 1;
    }

    private void adjust() {
        while (frontPos < 0) {
            frontPos += arr.length;
        }
        while (lastPos < 0) {
            lastPos += arr.length;
        }
        if (frontPos >= arr.length) {
            frontPos %= arr.length;
        }
        if (lastPos >= arr.length) {
            lastPos %= arr.length;
        }
    }

    private void resize(int size_) {
        T[] temp = (T[]) new Object[size_];
        int count = 0;
        adjust();
        if (frontPos > lastPos) {
            for (int i = frontPos; i < this.size; i++) {
                temp[count++] = arr[i];
            }
            for (int i = 0; i <= lastPos; i++) {
                temp[count++] = arr[i];
            }
        } else {
            for (int i = frontPos; i <= lastPos; i++) {
                temp[count++] = arr[i];
            }
        }

        frontPos = 0;
        lastPos = count - 1;
        arr = temp;
    }

    public int size() {
        return size;
    }


    public void printDeque() {
        adjust();
        if (frontPos > lastPos) {
            for (int i = frontPos; i < this.arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            for (int i = 0; i <= lastPos; i++) {
                System.out.print(arr[i]);
                if (i != lastPos) {
                    System.out.print(" ");
                }
                else {
                    System.out.println();
                }
            }
        } else {
            for (int i = frontPos; i < lastPos; i++) {
                System.out.print(arr[i]);
                if (i != lastPos) {
                    System.out.print(" ");
                }
                else {
                    System.out.println();
                }
            }
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        adjust();
        T result = arr[frontPos];
        arr[frontPos++] = null;
        size -= 1;
        if (arr.length >= 16 && arr.length - size * 4 > 0) {
            resize(size * 2);
        }
        return result;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        adjust();
        T result = arr[lastPos];
        arr[lastPos--] = null;
        size -= 1;
        if (arr.length >= 16 && arr.length - size * 4 > 0) {
            resize(size * 2);
        }
        return result;
    }

    public T get(int index) {
        int temp = (index + frontPos) % this.arr.length;
        return arr[temp];
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof Deque)){
            return false;
        }

        Deque<T> obj = (Deque<T>)o;
        if (obj.size() != this.size()){
            return false;
        }
        for(int i = 0; i < obj.size(); i += 1){
            T itemFromObj =  obj.get(i);
            T itemFromThis = this.get(i);
            if (!itemFromObj.equals(itemFromThis)){
                return false;
            }
        }
        return true;
    }

//    public static void main(String[] args) {
//        Deque<Integer> lld = new LinkedListDeque<Integer>();
//
//        Deque<Integer> ad = new ArrayDeque<Integer>();
//        lld.addLast(1);
//        ad.addFirst(1);
//        System.out.println(lld.equals(ad));
//        System.out.println(ad.equals(lld));
//    }
}

