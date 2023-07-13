package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        AList<Integer> Ns = new AList<Integer>();
        AList<Double> times = new AList<Double>();
        AList<Integer> opCounts = new AList<Integer>();
        for (int i = 1000; i <= 128000 ; i*=2 ) {
            Ns.addLast(i);
            opCounts.addLast(10000);
            SLList<Integer> test = new SLList<Integer>();
            for (int j = 0; j < i ; j++) {
                test.addLast(j);
            }
            long start = System.currentTimeMillis();
            for (int j = 0; j < 10000; ++j) {
                test.getLast();
            }
            long end = System.currentTimeMillis();
            times.addLast((end - start) / 1000.0);
        }
        printTimingTable(Ns , times , opCounts);
    }

}
