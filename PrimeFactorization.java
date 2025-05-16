import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            Scanner scanInput = new Scanner(System.in);
            System.out.println("Enter a number : ");
            int n =  scanInput.nextInt();
            ArrayList<Integer> result = computePrimeFactors(n);
            System.out.println(result);
        }catch(Exception e) {System.out.println("invalid input"); return;}

    }
    public static ArrayList<Integer> computePrimeFactors(int n) {
        ArrayList<Integer> primeFactors = new ArrayList<>();
        if (n < 2) return primeFactors;
        int i = 2;
        while (n > 1) {
            if (n % i == 0) {
                primeFactors.add(i);
                n /= i;
            } else ++i;
        }
        return primeFactors;
    }
}