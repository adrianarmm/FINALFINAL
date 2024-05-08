public class EfficiencyComparison {
    public static long functionA(int n) {
        return 1024 * n;
    }

    public static long functionB(int n) {
        return 16 * n * n * n;
    }

    public static void main(String[] args) {
        int n = 8;
        long A = functionA(n);
        long B = functionB(n);

        System.out.println("For n = " + n);
        System.out.println("Function A has " + A + " operations");
        System.out.println("Function B has " + B + " operations");
        System.out.println("Therefore, for n >= " + n + ", function A is more efficient");
    }
}