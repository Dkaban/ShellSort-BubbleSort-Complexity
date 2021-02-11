//*************************************************************************************
//  SortingDriver.java
//
//  AUTHOR: DUSTIN KABAN
//  DATE: FEBRUARY 11th, 2021
//
//  This class demonstrates the use of ShellSort, BubbleSort and a modified version of BubbleSort
//  that exits the loop when a swap does not take place.  This displays the results to the user along with
//  displaying the time taken to execute a sort to demonstrate time complexity.
//*************************************************************************************

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class SortingDriver
{
    //Used for displaying and running the correct sorting algorithm to the user.
    private enum SortType {ShellSort, BubbleSort, BubbleSort2}
    //Setting a constant for how big we want the numbers to be inside of our randomized arrays
    private static final int MAX_INTEGER = 100;

    public static void main(String[] args)
    {
        //Perform all the sorting and displaying required for the ShellSort (Question 1)
        //NOTE: Some functions / variables are commented out in Sorting.java so this may not function properly
        //doShellSort();

        //Perform all the sorting and displaying required for the BubbleSort (Question 2)
        //NOTE: Some functions / variables are commented out in Sorting.java so this may not function properly
        //doBubbleSorts();

        //Perform all the sorting and displaying required by the ShellSort, BubbleSort, and BubbleSort2 algorithms
        //(Question 3)
        doAllSorts();
    }

    private static void doShellSort()
    {
        //Create an initialized array, and then two random arrays one of size 10 other of size 20
        Integer[] defaultArray = {9,6,8,12,3,1,7};
        Integer[] randomTenArray = ThreadLocalRandom.current().ints(1,MAX_INTEGER)
                .limit(10).boxed().toArray(Integer[]::new);
        Integer[] randomTwentyArray = ThreadLocalRandom.current().ints(1,MAX_INTEGER)
                .limit(20).boxed().toArray(Integer[]::new);

        //Display the sorting information to the user
        displayArray("Default Array",defaultArray,SortType.ShellSort);
        displayArray("Random Ten",randomTenArray, SortType.ShellSort);
        displayArray("Random Twenty",randomTwentyArray,SortType.ShellSort);
    }

    private static void doBubbleSorts()
    {
        ///We create a sorted array, along with a randomized array.  We want to
        Integer[] sortedArray = {1,4,8,11,26,29,33,66,100,105};
        Integer[] randomArray = ThreadLocalRandom.current().ints(1,MAX_INTEGER)
                .limit(10).boxed().toArray(Integer[]::new);
        Integer[] randomSort2Array = randomArray.clone();

        displayArray("BubbleSort",sortedArray,SortType.BubbleSort);
        displayArray("BubbleSort2",sortedArray,SortType.BubbleSort2);
        displayArray("BubbleSort",randomArray,SortType.BubbleSort);
        displayArray("BubbleSort2",randomSort2Array,SortType.BubbleSort2);
    }

    private static void doAllSorts()
    {
        //Run through ShellSort, BubbleSort, BubbleSort2 with randomized arrays of size 10, 100, 1000
        System.out.println("------ Sorting Random Array -----");
        testRandomArrayDifferentSizes(10);
        testRandomArrayDifferentSizes(100);
        testRandomArrayDifferentSizes(1000);

        //Run through ShellSort, BubbleSort, BubbleSort2 with already sorted arrays of size 10, 100, 1000
        System.out.println("----- Sorting Already Sorted Array -----");
        testSameArrayDifferentSizes(10);
        testSameArrayDifferentSizes(100);
        testSameArrayDifferentSizes(10000);
    }

    private static void testRandomArrayDifferentSizes(int size)
    {
        //We don't want to check sizes over this because it runs extremely slowly.
        if(size > 10000) size = 10000;

        //Create random array and clone it so we don't try to sort an already sorted array
        Integer[] randomArray = ThreadLocalRandom.current().ints(1,MAX_INTEGER).limit(size).boxed().toArray(Integer[]::new);
        Integer[] randomBubbleArray = randomArray.clone();
        Integer[] randomBubbleTwoArray = randomArray.clone();

        //Used to keep track of execution time for each sort
        long startTime, elapsedTime;

        //Get the time before the algorithm starts
        startTime = System.nanoTime();
        Sorting.shellSort(randomArray);
        //Check the time after it ends, for each sort
        elapsedTime = System.nanoTime() - startTime;
        //Display time to the user
        System.out.println("Time Elapsed in nanoseconds: " + elapsedTime);

        startTime = System.nanoTime();
        Sorting.bubbleSort(randomBubbleArray);
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("Time Elapsed in nanoseconds: " + elapsedTime);

        startTime = System.nanoTime();
        Sorting.bubbleSort2(randomBubbleTwoArray);
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("Time Elapsed in nanoseconds: " + elapsedTime);
    }

    private static void testSameArrayDifferentSizes(int size)
    {
        //Create a random array of the size passed into the function
        Integer[] randomArray = ThreadLocalRandom.current().ints(1,MAX_INTEGER).limit(size).boxed().toArray(Integer[]::new);

        //Sort the array so we can check the sorting algorithms against an already sorted array
        Arrays.sort(randomArray);

        //Same as in the random array, we are using this for tracking execution time for the sorts
        long startTime, elapsedTime;

        startTime = System.nanoTime();
        Sorting.shellSort(randomArray);
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("Time Elapsed in nanoseconds: " + elapsedTime);

        startTime = System.nanoTime();
        Sorting.bubbleSort(randomArray);
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("Time Elapsed in nanoseconds: " + elapsedTime);

        startTime = System.nanoTime();
        Sorting.bubbleSort2(randomArray);
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("Time Elapsed in nanoseconds: " + elapsedTime);
    }

    private static void displayArray(String arrayName, Integer[] array, SortType type)
    {
        //User displays for the array type and the initial elements
        System.out.print("----------------------------------------------\n");
        System.out.print(arrayName +"\n");
        displayArrayElements(array);
        System.out.print("\n");

        //Used for display information based on the type of sorting algorithm we want to check
        switch(type)
        {
            case ShellSort:
                Sorting.shellSort(array);
                break;

            case BubbleSort:
                Sorting.bubbleSort(array);
                break;

            case BubbleSort2:
                Sorting.bubbleSort2(array);
                break;

            default:
                //Do Nothing
                break;
        }

        System.out.print("----------------------------------------------\n");
    }

    private static void displayArrayElements(Integer[] array)
    {
        //For looping through the array and displaying each individual element
        for (Integer integer : array)
        {
            System.out.print(integer + ",");
        }
    }
}
