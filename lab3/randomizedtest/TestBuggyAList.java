package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void simpleComparisonTest(){
        AListNoResizing<Integer> an = new AListNoResizing<>();
        BuggyAList<Integer> ba = new BuggyAList<>();
        an.addLast(4);
        ba.addLast(4);
        an.addLast(5);
        ba.addLast(5);
        an.addLast(6);
        ba.addLast(6);
        for (int i = 0; i < 3 ; ++i) {
            assertTrue(an.removeLast() == ba.removeLast());
        }
    }

    @Test
    public void randomFuncTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();

        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 2);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                System.out.println("size: " + size);
            }
        }
    }


}
