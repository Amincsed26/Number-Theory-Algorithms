import java.sql.SQLOutput;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        try{
            Scanner scanInput = new Scanner(System.in);
            System.out.println("Enter the number you want to check : ");
            int number = scanInput.nextInt();
            if(number < 0) {
                System.out.println("you entered negative number");
                return;
            }else{
                if(isPrime(number)) System.out.println(number + " is prime number");
                else  System.out.println(number + " is composite number");
            }
        }catch(Exception e){
            System.out.println("Invalid input");
            return;
        }
    }
    public static boolean isPrime(int n) {
        if (n <= 1) return false;

        // by default all are false
        boolean[] isComposite = new boolean[n + 1];

        for (int i = 2; i * i <= n; i++) {
            if (!isComposite[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isComposite[j] = true;
                }
            }
        }
        return !isComposite[n];
    }
}