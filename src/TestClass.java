import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestClass
{
    public static void throwit()
    {
        throw new RuntimeException();
    }
    public static void main(String args[])
    {


        int n=29;
        int sum =0;
        while(n>0 || sum >1){
            int rem=n%10;
            System.out.println(rem);
            n=n/10;
            sum+=rem*rem;
            System.out.println("Sum "+sum);

        }

        double a = 354.03;
        int  b = 256;
        byte c = (byte) a;
        byte d = (byte) b;
        System.out.println(c + "\t"  + d);
        List<String> list = new ArrayList<String>();
        list.add("DoSelect");
        list.add("InMobi");
        list.add("CampusHash");
        list.add("mKhoj");
        list.add("Microsoft");

        System.out.println("Original: " + list);

        Collections.rotate(list, -2);

        System.out.println("Rotated: " + list);


        int x = 0x80000000;
        System.out.print(x + " and ");
        x = x >>> 31;
        System.out.println(x);

        int result = 0;

        Boolean b1 = new Boolean("TRUE");
        Boolean b2 = new Boolean("true");
        Boolean b3 = new Boolean("tRuE");
        Boolean b4 = new Boolean("false");

        if (b1 == b2)result = 1;
        if (b1.equals(b2))result = result + 10;
        if (b2 == b4)result = result + 100;
        if (b2.equals(b4))result = result + 1000;
        if (b2.equals(b3))result = result + 10000;
        System.out.println(result);
        int x1=20;
        String sup = (x < 15) ? "small" : (x < 22)? "tiny" : "huge";
        System.out.println(sup);


        try
        {
            System.out.println("Hello world ");
            throwit();
            System.out.println("try block ");
        }
        finally
        {
            System.out.println("Finally");
        }
    }
}