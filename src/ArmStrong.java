import java.util.ArrayList;
import java.util.List;

public class ArmStrong extends  Thread{

    public static void main(String[] args) {

        Thread r1= new Thread("first");
        int[] input3rdArray= new int[3];
        Integer i1= new Integer(1);
        Integer i2= new Integer(1);
        String s1="111";
        String s2="111";
        String s3= new String("111");
        String s4= new String("111");
        s4.intern();
        s3.intern();
        if(i1.equals(i2)){
            System.out.println("True");
        }
        if(s1== s2){
            System.out.println("String equals...literals ");
        }
        if(s3 == s4){
            System.out.println("S3 & S4 String equals using new ");

        }

        if(s1.equals(s4)){
            System.out.println("S1 & S String equals ");

        }
        r1.start();
        r1.interrupt();
        int c = 0, a, temp;
        int n = 153;//It is the number to check armstrong
        temp = n;

        while (n > 0) {
            c = n % 10;
            n = n / 10;
            temp = c;
        }

        println(1);
        String s = "Hello WOrld!";
        System.out.println(s instanceof  String);
        List<Object> list= new ArrayList<>();
        list.add("sdd");

                list.add(1);

                String one="1";
                String two="1";
                if(one.equals(two)){
                    System.out.println("sds true");
                }
                Integer a1= new Integer(1);
                Integer b1= new Integer(1);
                if(a1.equals(b1))  System.out.println("Integer true");





    }

    static Exception println(Integer a){
        if(a>0){
            return new Exception("ss");

        }
        else{
            return new RuntimeException("");
        }

    }
}

