public class MathsPowerCalculator {
    public static void main(String[] args) {
        calculate(2.10000,3);

    }

    public static double calculate(double x, int n) {
        double sum=x;
        int absVal=n;
        if(n <0){
            absVal=-(n);
        }
        for(int i=1;i<absVal ;i++){
            sum= sum *x;
        }
        if(n<0){
            sum=1/sum;
        }
        System.out.print("Sum "+sum);
        return sum;

    }
}
