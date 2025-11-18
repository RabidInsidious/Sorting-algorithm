
/* Marc-Alexandre Martin-Lauzer

*/

import java.util.Arrays;
import java.util.Random;

public class SortAnal {
   public static int comparisonsInInsertionSort(int[] array){
      if (array == null || array.length == 0){
         return 0; //no comparioons for loser null or empty arrays because they are losers
      }
      int count = 0;
      int size = array.length;
      for(int i = 1; i < size; ++i){
         int v = array[i];
         int j = i - 1;
         /*while((j >= 0) && (array[j] > v)){ ->the inital format of the pseudocode from reference problem
	    count = count + 1;
	    array[j + 1] = array[j];
	    j = j - 1;
         }
	 if (j >= 0){
	    count = count + 1; -> my inital solution to the while loop being skipped if j !>= 0, however no values however I believe doing this will overcount j and undercount anaylsis of array[j] > v
         }
	*/
	while (j >= 0) {
	   count++; //Count every comparison made
	   if (array[j] <= v){
	      break; // exit if no shift is needed
	   }
	   array[j + 1] = array[j];
	   j--;
	}
        array[j + 1] = v;
      }
      return count;
   }

   public static void main(String[] args){
      Random rand = new Random();
      //arrays to hold the values
      int[] randomCount = new int[20];
      int[] ascendingCount = new int[20];
      int[] descendingCount = new int[20];
      int[] sizes = new int[20];

      //an int of z will be incremented along size that will represent the index of the prior arrays
      for(int size = 1000, index = 0; size <= 20000; size+=1000, index++){
	 //creating a random array
         int[] randomArray = new int[size];
         for(int elem = 0; elem < size; ++elem){
	    randomArray[elem] = rand.nextInt(10000);
         }
	 //creating array for ascending order
	 int[] ascendingArray = randomArray.clone();
	 Arrays.sort(ascendingArray);

	 //creating array for descending order
	 int[] descendingArray = new int[size];
	 for (int i = 0; i < size; ++i){
	    descendingArray[i] = ascendingArray[size - 1 - i];
	 }

	 //doing the comparisons for all 3 arrays
         randomCount[index] = comparisonsInInsertionSort(randomArray.clone());
         ascendingCount[index] = comparisonsInInsertionSort(ascendingArray.clone());
         descendingCount[index] = comparisonsInInsertionSort(descendingArray.clone());
	 sizes[index] = size;
     }

     System.out.println("values with labels for clarity");

     for(int index = 0; index < 20; index++){
        System.out.println("Size: " + sizes[index] + ", Random order comparisons: " + randomCount[index]);
     }

     System.out.println();

     for(int index = 0; index < 20; index++){
        System.out.println("Size: " + sizes[index] + ", Ascending order comparisons: " + ascendingCount[index]);
     }

     System.out.println();


     for(int index = 0; index < 20; index++){
        System.out.println("Size: " + sizes[index] + ", descending order comparisons: " + descendingCount[index]);
     }

     System.out.println();

     System.out.println("just pure values for transfer and analysis");

     for(int index = 0; index < 20; index++){
        System.out.println(sizes[index] + " " + randomCount[index]);
     }

     System.out.println();

     for(int index = 0; index < 20; index++){
        System.out.println(sizes[index] + " " + ascendingCount[index]);
     }

     System.out.println();

     for(int index = 0; index < 20; index++){
        System.out.println(sizes[index] + " " + descendingCount[index]);
     }

   }

}
