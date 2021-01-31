public class MedianTwoSortedArray {

    public static void main(String[] args) {

        int[] a= new int[] {3,5,6,6};
        int[] b= new int[] {1,2,5,6,6};

        System.out.println("Median of the value "+ getMedianOfSortedArray(a,b));

    }


    public static float getMedianOfSortedArray(int[] a,int [] b){

        if(a.length > b.length){
            return getMedianOfSortedArray(b ,a);

        }

        int m= a.length;
        int n=b.length;
        int start=0;
        int end =m;

        while(start <=end){
            int paritionX=(start+end)/2;
            int partiiony= (m+n+1)/2 -paritionX;
            int maxLeftX=paritionX ==0 ?Integer.MIN_VALUE : a[paritionX-1];
            int maxLeftY= partiiony ==0 ?Integer.MIN_VALUE : a[partiiony-1];
            int minRightX=paritionX ==0 ?Integer.MIN_VALUE : a[paritionX];
            int minRightY=partiiony ==0 ?Integer.MIN_VALUE : a[partiiony];
            if(maxLeftX <= minRightY && minRightX >= maxLeftY){
                if((m+n) %2 ==0){
                    return (Math.max(maxLeftX,maxLeftY) + Math.min(minRightX ,minRightY))/2;
                }
                return Math.max(maxLeftX,maxLeftY);
            }
            else{
                if(maxLeftX <= minRightY){
                    start=paritionX+1;
                }
                else {
                    end = paritionX -1;
                }
            }
        }
        return -1;

    }
}
