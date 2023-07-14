package deque;

import java.util.Comparator;
import java.util.Iterator;

public class MaxArrayDeque<T> extends ArrayDeque<T>{

    private Comparator<T> comp;
    public MaxArrayDeque(Comparator<T> c){
        comp = c;
    }

    public T max(){
        if(this.size() == 0)return null;
        Iterator<T> iterator = this.iterator();
        T max = this.get(0);
        while(iterator.hasNext()){
            T temp = iterator.next();
            if(comp.compare(max , temp) < 0)max = temp;
            else{
                continue;
            }
        }
        return max;
    }

    public T max(Comparator<T> c){
        if(this.size() == 0)return null;
        Iterator<T> iterator = this.iterator();
        T max = this.get(0);
        while(iterator.hasNext()){
            T temp = iterator.next();
            if(c.compare(max , temp) < 0)max = temp;
            else{
                continue;
            }
        }
        return max;
    }
    public static void main(String[] args) {

    }
}

