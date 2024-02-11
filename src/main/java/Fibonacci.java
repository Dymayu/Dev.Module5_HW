import java.util.logging.Logger;

public class Fibonacci {

    private static final Logger log = Logger.getLogger(String.valueOf(Fibonacci.class));

    /**
     *  n = 10
     *  time = 27
     *  n = 10,000,000.0
     *  time = 35
     *
     *  the complexity of the algorithm = O(log n)
     */
    public long iterativeMethod(int n) {
        long result = 0;

        if (n <= 1) {
            return n;
        }
        int prev = 0;
        int current = 1;

        for (int i = 2; i <= n; i++) {
            int temp = prev + current;
            prev = current;
            current = temp;
        }

        return current;
    }

    /**
     *  n = 10
     *  time = 25
     *  n = 50
     *  time = 53035
     *
     *  the complexity of the algorithm = O(N power N)
     */
    public long recursiveMethod(int n) {
        long result = 0;
        if (n <= 1) {
            return n;
        }

        result = recursiveMethod(n - 1) + recursiveMethod(n - 2);

        return result;
    }

    /**
     *  n = 10
     *  time = 26
     *  n = 10,000,000.0
     *  time = 68
     *
     *  the complexity of the algorithm = O(log n)
     */
    public long dynamicMethod(int n) {
        int[] resArr = new int[n + 1];
        resArr[0] = 0;
        resArr[1] = 1;

        for (int i = 2; i <= n; i++) {
            resArr[i] = resArr[i - 1] + resArr[i - 2];
        }

        return resArr[n];
    }


    public static void main(String[] args) {

        Fibonacci fibonacci = new Fibonacci();

        long startTime = System.currentTimeMillis();
        //log.info("Fibonacci iteratived method = " + fibonacci.iterativeMethod(10000000));
        //log.info("Fibonacci recursive method = " + fibonacci.recursiveMethod(50));
        log.info("Fibonacci dynamic method = " + fibonacci.dynamicMethod(10000000));

        long endTime = System.currentTimeMillis();
        log.info("TIME = " + (endTime - startTime));

    }
}
