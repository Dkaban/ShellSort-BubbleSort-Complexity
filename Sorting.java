//*************************************************************************************
//  Sorting.java
//
//  AUTHOR: DUSTIN KABAN
//  STUDENT ID: T00663749
//  DATE: FEBRUARY 11th, 2021
//  COURSE: COMP2231
//
//  This class contains the algorithms for a ShellSort, BubbleSort and a modified version of BubbleSort
//  that exits the loop when a swap does not take place.  This class contains a small amount of prints
//  that display output to the user to demonstrate performance.  The bulk of the user displays happen in
//  AssignmentOne.java
//*************************************************************************************

public class Sorting
{
    /////////////SHELL SORT//////////////////////////////////////////////
    public static <T extends Comparable<T>>
    void shellSort(T[] data)
    {
        //We will be accessing this continuously
        int dataLength = data.length;

        //To help track when we should display the array to the user
        //boolean swap = false;
        int totalComparisons = 0, totalSwaps = 0;

        //Start the for loop at the floor value of array size / 2
        //Run through array until it's gap sorted according to the current gap
        for(int gap = dataLength/2;gap > 0; gap/= 2)
        {
            //Loop through elements starting at the gaps index
            for(int i=gap;i<dataLength;i+=1)
            {
                T temp = data[i];
                int j;
                //swap = false;

                //Move through the sorted elements until we find the elements correct position
                for(j = i; j >= gap && data[j - gap].compareTo(temp) > 0; j -= gap)
                {
                    data[j] = data[j-gap];
                    //swap = true;
                    totalSwaps++;
                }

                data[j] = temp;

                totalComparisons++;

                //If a swap happened, we want to display the array to the user
                //if(swap) displayArrayElements(data);
            }
        }
        displayTally("Shell Sort",totalComparisons,totalSwaps);
    }

    /////////////BUBBLE SORT//////////////////////////////////////////////
    /*
    The outer loop represents the n-1 passes through the data
    The inner loop scans through the data, performs the pairwise comparisons of the neighbouring data and swaps them if necessary
    Note: The outer loop also has the effect of decreasing the position that represents the maximum index to examine in the inner loop.
    That is, after the first pass, there is no need to consider the last value in the list because it is 'sorted', so forget about it.
    O(n^2)
     */
    public static <T extends Comparable<T>>
    void bubbleSort(T[] data)
    {
        int position, scan;
        T temp;
        int totalComparisons = 0, totalSwaps = 0;

        for (position =  data.length - 1; position >= 0; position--)
        {
            for (scan = 0; scan <= position - 1; scan++)
            {
                if (data[scan].compareTo(data[scan+1]) > 0)
                {
                    swap(data, scan, scan + 1);
                    //displayArrayElements(data);
                    totalSwaps++;
                }
                totalComparisons++;
            }
        }
        displayTally("Bubble Sort",totalComparisons,totalSwaps);
    }

    /////////////BUBBLE SORT 2//////////////////////////////////////////////
    public static <T extends Comparable<T>>
    void bubbleSort2(T[] data)
    {
        int position, scan;
        T temp;

        //No need to initialize as we do at the start of the do loop.
        boolean isSorted;
        position = data.length-1;

        //Used to track swaps and comparisons for user output
        int totalComparisons = 0, totalSwaps = 0;

        //Using a do loop because we have to check at least once if the array is sorted
        do {
            isSorted = true;
            for (scan = 0; scan <= position - 1; scan++)
            {
                if (data[scan].compareTo(data[scan+1]) > 0)
                {
                    //Swap the neighbouring values and continue
                    swap(data, scan, scan + 1);

                    //Display the entire array after the swap happens to the user
                    //displayArrayElements(data);

                    //This indicates the list is not sorted, so we need to loop again
                    isSorted = false;
                    //A swap happened, we want to track it
                    totalSwaps++;
                }
                //Each time we do a comparison, increment the counter
                totalComparisons++;
            }
            //We need to move through the array, so decrement position
            position--;

        }while(!isSorted);//Loop until we know the list is sorted

        //Display to the user the comparison and swap information
        displayTally("Bubble Sort 2",totalComparisons,totalSwaps);
    }

    private static <T> void displayArrayElements(T[] array)
    {
        //Display ever element of the array
        for (T integer : array)
        {
            System.out.print(integer + ",");
        }
        System.out.println("");
    }

    private static <T> void displayTally(String sortName, int totalComparisons, int totalSwaps)
    {
        //Displaying Comparison and Swap information the user
        System.out.println(sortName + " Comparisons: " + totalComparisons + " Swaps: " + totalSwaps);
    }

    private static <T extends Comparable<T>>
    void swap(T[] data, int index1, int index2)
    {
        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }
}
