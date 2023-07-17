package tester;
import static org.junit.Assert.*;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import student.StudentArrayDeque;
public class TestArrayDequeEC {

    @Test
    public void addAndRemoveTest(){
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < 20; ++i) {
            if (StdRandom.bernoulli()) {
               sad.addLast(i);
               ads.addLast(i);
               output.append("addLast(").append(i).append(")\n");
            }
        }
        assertEquals(sad.size() , ads.size());
        int length = sad.size();
        for (int i = 0; i < length; ++i) {
            output.append("removeLast()\n");
            assertEquals(output.toString(), sad.removeLast() , ads.removeLast());
        }
        assertEquals(sad.size(), 0);
        for (int i = 0; i < 20; ++i) {
            if (StdRandom.bernoulli()) {
                sad.addLast(i);
                ads.addLast(i);
                output.append("addLast(").append(i).append(")\n");
            }
        }
        assertEquals(sad.size() , ads.size());
        int length2 = sad.size();
        for (int i = 0; i < length2; ++i) {
            output.append("removeLast()\n");
            assertEquals(output.toString(), sad.removeLast() , ads.removeLast());
        }
    }


    @Test
    public void addAndRemoveTest2(){
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < 20; ++i) {
            if (StdRandom.bernoulli()) {
                sad.addLast(i);
                ads.addLast(i);
                output.append("addLast(").append(i).append(")\n");
            }
        }
        assertEquals(sad.size() , ads.size());
        int length = sad.size();
        for (int i = 0; i < length; ++i) {
            output.append("removeFirst()\n");
            assertEquals(output.toString(), sad.removeFirst() , ads.removeFirst());
        }
        assertEquals(sad.size(), 0);
        for (int i = 0; i < 20; ++i) {
            if (StdRandom.bernoulli()) {
                sad.addFirst(i);
                ads.addFirst(i);
                output.append("addFirst(").append(i).append(")\n");
            }
        }
        assertEquals(sad.size() , ads.size());
        int length2 = sad.size();
        for (int i = 0; i < length2; ++i) {
            output.append("removeLast()\n");
            assertEquals(output.toString(), sad.removeLast() , ads.removeLast());
        }
    }
}
