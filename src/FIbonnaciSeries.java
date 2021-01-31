import java.util.Scanner;

public class FIbonnaciSeries {

    public static void main(String[] args) {

        System.out.println("Enter number upto which Fibonacci series to print: ");
        int number = new Scanner(System.in).nextInt();

        System.out.println("Fibonacci series upto " + number +" numbers : "); //printing Fibonacci series upto number
        for(int i=1; i<=number; i++){
            System.out.print(fibonnaci2(i) +" ");
            for(int k=0;k<fibonacci(i);k++){
                System.out.print("* ");
            }
            System.out.println();
//            System.out.print(fibonacci(i) +" ");
        }
        System.out.println("Enter number wh4ich is prime ");
        int numberPrime = new Scanner(System.in).nextInt();
        System.out.print("No is prime "+isPrimeOrNo(number) +" ");

    }

    public static  int fibonacci(int number){
        if(number ==1 || number ==2){
            return 1;
        }
        else{
           return fibonacci(number-1 )+fibonacci(number-2);
        }

    }

    public static boolean isPrimeOrNo(int number){
        if(number ==2 || number ==3){
            return true;
        }
        else {
            int sqrt= (int) Math.sqrt(number)+1;
            for(int i=2; i<sqrt;i++){
                if(number %i ==0){
                  return true;
                }
            }
            return false;
        }
    }

    public static  int fibonnaci2(int number){
        if(number ==1 || number ==2){
            return 1;
        }
        else{
            int fib1=1,fib2=1,fibbVal=1;

            for(int i=3;i<=number;i++){
                fibbVal=fib1+fib2;
                fib1=fib2;
                fib2=fibbVal;
            }
            return fibbVal;
        }

    }
}
