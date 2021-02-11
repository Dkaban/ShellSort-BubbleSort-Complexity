# ShellSort vs BubbleSort Execution Time Evaluation

## Language: Java
## IDE: IntelliJ
This program tests the ShellSort and BubbleSort algorithms in various capacities.

### Main Functions To Know
- ShellSort(T[] data}
- BubbleSort(T[] data)
- BubbleSort2(T[] data)
Note: BubbleSort2 is an improved algorithm of BubbleSort that kicks out when a swap does not happen.

#### Tests Run
- Random Unsorted Array of size 10, 100, 1000
- Random Sorted Array of size 10, 100, 1000
Note: Adjustable MAX_INTEGER value (most tests were run using 100 as value)

##### Output
- Time it takes to run the algorithm using System.nanoTime()
- Amount of swaps and comparisons made by each algorithm and displaying the updated Arrays as they're sorted.

###### Output Example:
------ Sorting Random Array -----
Shell Sort Comparisons: 22 Swaps: 11
Time Elapsed in nanoseconds: 22790800
Bubble Sort Comparisons: 45 Swaps: 25
Time Elapsed in nanoseconds: 101700
Bubble Sort 2 Comparisons: 42 Swaps: 25
Time Elapsed in nanoseconds: 89500
Shell Sort Comparisons: 503 Swaps: 465
Time Elapsed in nanoseconds: 318600
Bubble Sort Comparisons: 4950 Swaps: 2415
Time Elapsed in nanoseconds: 795600
Bubble Sort 2 Comparisons: 4895 Swaps: 2415
Time Elapsed in nanoseconds: 520900
Shell Sort Comparisons: 8006 Swaps: 7512
Time Elapsed in nanoseconds: 1609400
Bubble Sort Comparisons: 499500 Swaps: 254408
Time Elapsed in nanoseconds: 23332400
Bubble Sort 2 Comparisons: 499490 Swaps: 254408
Time Elapsed in nanoseconds: 26156900
----- Sorting Already Sorted Array -----
Shell Sort Comparisons: 22 Swaps: 0
Time Elapsed in nanoseconds: 93800
Bubble Sort Comparisons: 45 Swaps: 0
Time Elapsed in nanoseconds: 178400
Bubble Sort 2 Comparisons: 9 Swaps: 0
Time Elapsed in nanoseconds: 120800
Shell Sort Comparisons: 503 Swaps: 0
Time Elapsed in nanoseconds: 152600
Bubble Sort Comparisons: 4950 Swaps: 0
Time Elapsed in nanoseconds: 119100
Bubble Sort 2 Comparisons: 99 Swaps: 0
Time Elapsed in nanoseconds: 29600
Shell Sort Comparisons: 120005 Swaps: 0
Time Elapsed in nanoseconds: 9648100
Bubble Sort Comparisons: 49995000 Swaps: 0
Time Elapsed in nanoseconds: 424509100
Bubble Sort 2 Comparisons: 9999 Swaps: 0
Time Elapsed in nanoseconds: 392900
