import java.util.Iterator;
import java.util.PriorityQueue;

public class FindKthElement {


    public void findNthElement(int arr[],int k){

        //fill all element in array

        PriorityQueue<Integer> minHeap= new PriorityQueue<>();

        for(int i=0;i<k ;i++) {
            minHeap.add(arr[i]);
        }

        for(int j=k;j<arr.length;j++){


           if(minHeap.peek() > arr[j])
               continue;

           else {
               minHeap.poll();
               minHeap.add(arr[j]);
           }
        }


        Iterator iterator = minHeap.iterator();

        while (iterator.hasNext())
        {
            System.out.print(iterator.next() + " ");
        }    }

    public static void main(String[] args) {

        int arr[] = { 11, 3, 2, 1, 15, 5, 4,
                45, 88, 96, 50, 45 };
        new FindKthElement().findNthElement(arr,3);
    }
}

