package deque;

public class MaxArrayDeque<T> extends ArrayDeque<T>{

    private Comparator<T> comp;
    public MaxArrayDeque(Comparator<T> c){
        comp = c;
    }

    public T max(){
        if(this.size() == 0)return null;
        Iterator<T> iterator = this.iterator();
        T max = iterator.getVal();
        while(iterator.next() != null){
            if(comp.compare(max , iterator.getVal()))max = iterator.getVal();
            else{
                continue;
            }
        }
        return max;
    }

    public T max(Comparator<T> c){
        if(this.size() == 0)return null;
        Iterator<T> iterator = this.iterator();
        T max = iterator.getVal();
        while(iterator.next() != null){
            if(c.compare(max , iterator.getVal()))max = iterator.getVal();
            else{
                continue;
            }
        }
        return max;

    }
    public static void main(String[] args) {
        ComparatorInt<Integer> comp = new ComparatorInt<Integer>();
        MaxArrayDeque<Integer> ad = new MaxArrayDeque<Integer>(comp);
        for (int i = 0; i < 8 ; ++i) {
            ad.addFirst(i);
            System.out.println(ad.max());
        }
        ad.printDeque();
    }
}
abstract class Comparator<T> {
    public abstract boolean compare(T o1, T o2);
}

class ComparatorInt<T> extends Comparator<T> {
    @Override
    public boolean compare(T o1, T o2) {
        return (Integer)o1 < (Integer)o2;
    }

}