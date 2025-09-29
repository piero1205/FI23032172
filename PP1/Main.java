package inverso.java;

import java.util.Scanner;

public class InversoJava {

    public static String operacion() {

        Scanner num = new Scanner(System.in);

        System.out.print("Escribe un numero ");

        int ingreso = num.nextInt();

        int inverso = recursivo(ingreso, 0);

        num.close();

        return ingreso + " " + inverso;

    }
       
    public static int recursivo(int n, int inverso) {

        if (n == 0) {

            return inverso;
        }

        int residuo = n % 10;
        inverso = inverso * 10 + residuo;

        return recursivo(n / 10, inverso);
    }
 
    public static void main(String[] args) {

         System.out.println(operacion());

    }
}
