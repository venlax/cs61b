package deque;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyArrayDequeTest {
    @Test
    public void addTest(){
        ArrayDeque<Integer> ad = new  ArrayDeque<Integer>();
        for (int i = 0; i < 8 ; ++i) {
            ad.addFirst(i);
        }
        ad.printDeque();
    }

}
