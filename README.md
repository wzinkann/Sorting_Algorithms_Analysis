# Sorting_Algorithms_Analysis

a.	A short description of the work you did.
The purpose of project 2 was to see how different methods of sorting affected how fast the array could be sorted. The main topic that was new was utilizing selection and partition in order to fully optimize the sorting algorithm. As seen in my measured running time, method 3 (the only method to involve selection and partition) was the fastest by a sizeable amount, beating the other two methods which both rely on comparison-based sorting.

b.	An explanation for anything unusual or unexpected.
One thing that was unusual was that my code was inconsistent when using a random number generator to generate 10,000 elements and run my three different algorithms to produce the 500 largest elements. For some reason, both my method 2 and method 3 occasionally had trouble with this, when generating 100 elements and producing only the 10 largest elements, all of my methods work every time, I am not entirely sure why this is the case. Because of this, my average time measurements are done by generating 100 elements and selecting the 10 largest.

c.	Your results on the provided test data for each algorithm.
Here is the result from the first element in pa2_input.txt :
Method 1 : [100, 100, 100, 100, 100, 100, 100, 100, 100, 100]
Method 2 : [100, 100, 100, 100, 99, 99, 98, 98, 97, 97]
Method 3 : [100, 100, 100, 100, 99, 99, 98, 98, 97, 97]

d.	The average measured running time for each algorithm.
Method 1 Average Time: 29559
Method 2 Average Time: 31642
Method 3 Average Time: 17474

e.	The asymptotic time complexity analysis of each algorithm.
Method 1: T(n): k(n2)
Method 2: T(n): k(n2)
Method 1: T(n): k(n)
