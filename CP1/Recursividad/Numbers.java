package recursividad;

public class Numbers {

    private static final double N = 25;

    public static double formula(double z) {
        return round((z + Math.sqrt(4 + Math.pow(z, 2))) / 2);
    }

    public static double recursive(double z) {
        return round(fRec(z, N) / fRec(z, N - 1));
    }

    public static double iterative(double z) {
        return round(fIte(z, N) / fIte(z, N - 1));
    }

    private static double fRec(double z, double n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return z * fRec(z, n - 1) + fRec(z, n - 2);
        }
    }

    private static double fIte(double z, double n) {
        double a = 1;
        double b = 1;
        double result = 1;

        for (int i = 2; i <= n; i++) {
            result = z * b + a;
            a = b;
            b = result;
        }
        return result;
    }

    private static double round(double value) {
        double ROUND = 10000000000.0;
        return Math.round(value * ROUND) / ROUND;
    }
}

//https://www.geeksforgeeks.org/dsa/recurrence-relations-a-complete-guide/?utm_source=chatgpt.com
//https://es.wikipedia.org/wiki/N%C3%BAmero_met%C3%A1lico
