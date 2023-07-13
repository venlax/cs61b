package deque;

public class ArrayDeque<T> {

    private T[] arr;

    private int size;

    private int frontPos;
    private int lastPos;
    class Iterator<T>{
        private int pos = frontPos;
        
        public T iter;
        public Iterator() {
            iter = (T)arr[frontPos];
        }
        private void posNext(){
            pos++;
            while(pos < 0){
                pos += arr.length;
            }
            if(pos >= arr.length){
                pos %= arr.length;
            }
            
        }
        public T next() {
            if(pos == lastPos)return null;
            posNext();
            iter = (T) arr[pos];
            return iter;
        }

        public T getVal(){
            return iter;
        }
    }

    public Iterator<T> iterator(){
        
        return new Iterator<T>();
    }
    public ArrayDeque() {
        arr = (T[]) new Object[8];
        size = 0;
        frontPos = 0;
        lastPos = 0;
    }

    public ArrayDeque(T item){
        arr = (T[]) new Object[8];
        arr[0] = item;
        frontPos = 0;
        lastPos = 0;
        size = 1;
    }

    public void addFirst(T item){
        if(size == arr.length){
            resize(size * 2);
        }
        if(frontPos == 0 && lastPos == 0){
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
        if(size == arr.length){
            resize(size * 2);
        }
        lastPos++;
        adjust();
        arr[lastPos] = item;
        size += 1;
    }

    public void adjust(){
        while(frontPos < 0){
            frontPos += arr.length;
        }
        if(frontPos >= arr.length){
            frontPos %= arr.length;
        }
        if(lastPos >= arr.length){
            lastPos %= arr.length;
        }
    }
    public void resize(int size) {
        T[] temp = (T[]) new Object[size];
        int count = 0;
        adjust();
        if(frontPos > lastPos){
            for (int i = frontPos; i < this.size; i++) {
                temp[count++] = arr[i];
            }
            for (int i = 0; i <= lastPos; i++) {
                temp[count++] = arr[i];
            }
        }else{
            for (int i = frontPos; i < lastPos; i++) {
                temp[count++] = arr[i];
            }
        }

        frontPos = 0;
        lastPos = count - 1;
        arr = temp;
    }
    public int size(){
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque(){
        adjust();
        if(frontPos > lastPos){
            for (int i = frontPos; i < this.arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            for (int i = 0; i <= lastPos; i++) {
                System.out.print(arr[i]);
                if(i != lastPos) System.out.print(" ");
                else{
                    System.out.println();
                }
            }
        }else{
            for (int i = frontPos; i < lastPos; i++) {
                System.out.print(arr[i]);
                if(i != lastPos) System.out.print(" ");
                else{
                    System.out.println();
                }
            }
        }
    }
    public T removeFirst(){
        if(size == 0)return null;
        adjust();
        T result = arr[frontPos];
        arr[frontPos++] = null;
        size -= 1;
        if(arr.length >= 16 && arr.length - size * 4 > 0){
            resize(size * 2);
        }
        return result;
    }

    public T removeLast() {
        if(size == 0)return null;
        adjust();
        T result = arr[lastPos];
        arr[lastPos--] = null;
        size -= 1;
        if(arr.length >= 16 && arr.length - size * 4 > 0){
            resize(size * 2);
        }
        return result;
    }

    public T get(int index){
        int temp = (index + frontPos) % this.arr.length;
        return arr[temp];
    }
    public boolean equals(Object o) {
        if(!(o instanceof ArrayDeque))return false;
        ArrayDeque<?> temp = (ArrayDeque) o;
        if(this == temp)return true;
        if(this.size() != temp.size)return false;
        ArrayDeque.Iterator iterator = temp.iterator();
        Iterator<T> iterator2 = this.iterator();
        if(!iterator2.getVal().equals(iterator.getVal()))return false;
        while(iterator.next() != null && iterator2.next() != null){
            if(!iterator2.getVal().equals(iterator.getVal()))return false;
        }
        return true;
    }
    public static void main(String[] args) {

        ArrayDeque<Integer> ad = new ArrayDeque<Integer>();
        ArrayDeque<Integer> ad2 = new ArrayDeque<Integer>();
        for (int i = 0; i < 50; i++) {
            if(i % 2 == 0)ad.addFirst(i);
            else ad.addLast(i);
        }
        for (int i = 0; i < 50; i++) {
            if(i % 2 == 1)ad2.addFirst(i);
            else ad2.addLast(i);
        }

        System.out.println(ad.equals("xixi"));
    }
}

