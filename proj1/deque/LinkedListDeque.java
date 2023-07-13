package deque;


public class LinkedListDeque<T> {
    private dequeNode<T> first;
    private dequeNode<T> last;
    private int size;
    LinkedListDeque() {
        first = null;
        last = null;
        size = 0;
    }
//    LinkedListDeque(T item){
//        dequeNode<T> temp = new dequeNode<>(item , null,null);
//        first = temp;
//        last = temp;
//        size = 1;
//    }
    
    public void addFirst(T item){
        if(first == null){
            dequeNode<T> temp = new dequeNode<>(item, null,null);
            first = last = temp;
        }else{
            dequeNode<T> temp = new dequeNode<>(item,null ,first);
            first.front = temp;
            first = temp;
        }
        size++;
    }
    public void addLast(T item){
        if (last == null){
            dequeNode<T> temp = new dequeNode<>(item, null,null);
            first = last = temp;
        }else{
            dequeNode<T> temp = new dequeNode<>(item, last,null);
            last.next = temp;
            last = temp;
        }
        size++;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque(){
        dequeNode<T> temp = first;
        while(temp != null){
            System.out.print(temp.getVal());
            temp = temp.next;
            if(temp != null) System.out.println();
        }
    }

    public T removeFirst(){
        if(size == 0)return null;
        T result = first.getVal();
        first = first.next;
        size--;
        return result;
    }

    public T removeLast(){
        if(size == 0)return null;
        T result = last.getVal();
        last = last.front;
        size--;
        return result;
    }

    public T get(int index){
        if(index >= size || index < 0)return null;
        dequeNode<T> temp = first;
        while(index != 0) {
            index--;
            temp = temp.next;
        }
        return temp.getVal();
    }

    public T getRecursive(int index){
        return recursive(index , first);
    }

    public T recursive(int index , dequeNode<T> node){
        if(node == null)return null;
        if(index == 0)return node.getVal();
        else{
            return recursive(index - 1 , node.next);
        }
    }

    public Iterator<T> iterator() {
        return new Iterator<>(this.first);
    }

    public boolean equals(Object o) {
        if(!(o instanceof LinkedListDeque))return false;
        LinkedListDeque<?> temp = (LinkedListDeque) o;
        if(this == temp)return true;
        if(this.size() != temp.size)return false;
        Iterator< ? > iterator = temp.iterator();
        dequeNode<T> temp_ = first;
        while(iterator.iterator != null){
            if(!temp_.getVal().equals(iterator.iterator.getVal()))return false;
            iterator = iterator.next();
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> temp1 = new LinkedListDeque<Integer>();
        temp1.addLast(1);
        temp1.addLast(1);
        temp1.addLast(1);
        temp1.addLast(1);
        temp1.addLast(1);
        LinkedListDeque<Integer> temp2 = new LinkedListDeque<Integer>();
        temp2.addLast(1);
        temp2.addLast(1);
        temp2.addLast(1);
        temp2.addLast(1);
        System.out.println(temp1.equals(temp2));
    }
}

class dequeNode<T>{
    private T val;
    public dequeNode<T> front;
    public dequeNode<T> next;

    dequeNode(T val,  dequeNode<T> front , dequeNode<T> next) {
        this.val = val;
        this.front = front;
        this.next = next;
    }

    T getVal() {
        return val;
    }

}

class Iterator<T> {
    public dequeNode<T> iterator;

    Iterator(){
        iterator = null;
    }

    Iterator(dequeNode<T> iterator){
        this.iterator = iterator;
    }

    Iterator<T> next() {
        return new Iterator<>(iterator.next);
    }
}