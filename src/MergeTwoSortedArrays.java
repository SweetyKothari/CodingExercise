import java.util.Arrays;

public class MergeTwoSortedArrays {

    public static void main(String[] args) {

        int arr1[]={1,4,5};
        int arr2[]={2,3,5};

        int arr3[]=mergTwoArrays(arr1, arr2);

        for(int i=0;i<arr3.length ;i++){
            System.out.println("Element "+i+ " Value :" +arr3[i]);
        }
        int[] merged = mergeArrays(new int[] { 23, 39, 63, 68 },
                new int[] { 11, 21, 76 });
        System.out.println(Arrays.toString(merged));

    }

    private static int[] mergTwoArrays(int[] arr, int[] arr2) {
        int arr1Size= arr.length;
        int arr2Size= arr2.length;
        int[] arr3 = new int[arr1Size+arr2Size];
        int i=0,j=0,k=0;
        while(i < arr1Size && j <arr2Size){
            if(arr[i]< arr2[j])
                arr3[k++]=arr[i++];
            else
                arr3[k++]=arr[j++];
        }
        while(i<arr1Size){
            arr3[k++]=arr[i++];
        }

        while(j<arr2Size){
            arr3[k++]=arr[j++];
        }

        return arr3;
    }


    public static int[] mergeArrays(int[]... arrays) {
        int n = 0;
        for (int[] a : arrays)
            n += a.length;
        int[] result = new int[n];

        // Start at index 0 in each source array
        int[] idx = new int[arrays.length];

        // Merge source arrays into result array
        for (int i = 0; i < n; i++) {

            // Find smallest value
            int minJ = -1, minVal = 0;
            for (int j = 0; j < arrays.length; j++) {
                if (idx[j] < arrays[j].length) {
                    int val = arrays[j][idx[j]];
                    if (minJ == -1 || val < minVal) {
                        minJ = j;
                        minVal = val;
                    }
                }
            }

            // Add to result array and step forward in appropriate source array
            result[i] = minVal;
            idx[minJ]++;
        }
        return result;
    }
}
