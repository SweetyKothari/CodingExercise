import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrom("aaaa"));
        System.out.println(isPalindrom("abba"));
        System.out.println(isPalindrom("abcba"));
        System.out.println(isPalindrom("abcff"));
    }



    public static int searchmostPopulatr(int arr[],int len){

        Arrays.sort(arr);
        Map<Integer,Integer> count= new LinkedHashMap<>();
        for(int i=0;i<len-1;i++){
            for(int j=i+1;j<len-1;j++){
              if(arr[i] == arr[j]){
                  int counter=count.getOrDefault(arr[i],1);
                  count.put(arr[i],counter+1) ;
              }
              else{
                  break;
              }
            }
        }
        Integer max=count.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
        return max;
    }


    public static boolean isPalindrom(String str){
        int fullLength=str.length();
        char[] charArr=str.toCharArray();
        boolean flag=true;
        int mismatchCount=0;
        for(int i=0,j=fullLength-1;i< fullLength && j>0 ;i++,j--){
            if((charArr[i]!=charArr[j])){
                mismatchCount++;
            }
        }
        if(mismatchCount >1) {
            flag =false;
        }
        return flag;
    }
}
