import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            Scanner scanInput = new Scanner(System.in);
            System.out.println("Enter the number of Equations: ");
            int noOfEquations = scanInput.nextInt();
            if(noOfEquations <= 0){
                System.out.println("no of equations is not bigger than 0");
                return ;
            }
            int[] as = new int[noOfEquations];
            int[] ms = new int[noOfEquations];
            int[] Ms = new int[noOfEquations];
            int[] Ys = new int[noOfEquations];
            int m = 1;
            for (int i = 0; i < noOfEquations; i++) {
                System.out.println("Enter a" + i + ": ");
                as[i] = scanInput.nextInt();
                System.out.println("Enter m" + i + ": ");
                ms[i] = scanInput.nextInt();
                m *= ms[i];
            }
            int result = 0;
            for (int i = 0; i < noOfEquations; i++) {
                Ms[i] = m / ms[i];
                Ys[i] = modInverse(Ms[i], ms[i]);
                result = (result + ((as[i] % m) * (Ms[i] % m) * (Ys[i] % m))) % m;
            }
            System.out.println("X = " + result);
        }catch(NumberFormatException e){
            System.out.println("invalid input");
        }catch(ArithmeticException e){
            System.out.println("Cannot solve by the Chinese Remainder Theorem");
        }catch(InputMismatchException e){
            System.out.println("invalid input");
        }
    }

    public static int modInverse(int a, int n) {
        int m0 = n;
        int y = 0, x = 1;
        if (n == 1) return 0;
        while (a > 1) {
            int q = a / n;
            int t = n;
            n = a % n;
            a = t;
            t = y;
            y = x - q * y;
            x = t;
        }
        if (x < 0) x += m0;
        return x;
    }
}
