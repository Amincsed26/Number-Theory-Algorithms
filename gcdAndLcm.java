import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            Scanner scanInput = new Scanner(System.in);
            System.out.println("Enter first number : ");
            int a = scanInput.nextInt();
            System.out.println("Enter second number : ");
            int b = scanInput.nextInt();

            if(a < 0 || b < 0){
                System.out.println("cannot calculate neither gcd nor lcm");
                return;
            }
            System.out.println("choose an option");
            System.out.println("1.solve using prime factorization");
            System.out.println("2.solve using euclid algorithm");
            int option = scanInput.nextInt();
            switch(option){
                case 1:
                    System.out.println("GCD of " + a + ", " + b + " is " + calculateGCDFromPrimeFactors(computePrimeFactors(a),computePrimeFactors(b)));
                    System.out.println("LCM of " + a + ", " + b + " is " + calculateLCMFromPrimeFactors(computePrimeFactors(a),computePrimeFactors(b)));
                    break;
                case 2:
                    System.out.println("GCD of " + a + ", " + b + " is " + calculateGCD(a,b));
                    System.out.println("LCM of " + a + ", " + b + " is " + calculateLCM(a,b));
                    break;
                default:
                    System.out.println("cannot understand your input ");
                    break;
            }
        }catch(Exception e){
            System.out.println("invalid input");
        }

    }
    public static int calculateGCD(int a, int b) {
        if(a < b){
            int temp = b;
            b = a;
            a = temp;
        }
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static int calculateLCM(int a, int b) {
        return (a * b) / calculateGCD(a, b);
    }
    public static int calculateGCDFromPrimeFactors(ArrayList<Integer> primeFactorsA,
                                                   ArrayList<Integer> primeFactorsB) {
        ArrayList<Integer> commonPrimeFactors = new ArrayList<>();
        for (int factor : primeFactorsA) {
            if (primeFactorsB.contains(factor)) {
                commonPrimeFactors.add(factor);
                primeFactorsB.remove(Integer.valueOf(factor));
            }
        }
        int gcd = 1;
        for (int factor : commonPrimeFactors) {
            gcd *= factor;
        }
        return gcd;
    }
    public static int calculateLCMFromPrimeFactors(ArrayList<Integer> primeFactorsA,
                                                   ArrayList<Integer> primeFactorsB) {
        ArrayList<Integer> allPrimeFactors = new ArrayList<>(primeFactorsA);
        for (int factor : primeFactorsB) {
            if (!allPrimeFactors.contains(factor)) {
                allPrimeFactors.add(factor);
            } else {
                primeFactorsA.remove(Integer.valueOf(factor));
            }
        }
        int lcm = 1;
        for (int factor : allPrimeFactors) {
            lcm *= factor;
        }
        return lcm;
    }
    public static ArrayList<Integer> computePrimeFactors(int n) {
        ArrayList<Integer> primeFactors = new ArrayList();
        if (n < 2) return primeFactors;
        int i = 2;
        while(n > 1) {
            if (n % i == 0) {
                primeFactors.add(i);
                n /= i;
            } else ++i;
        }
        return primeFactors;
        }
    }