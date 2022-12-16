### Algorithms

## Space and Time complexyt 

# Big-O notation

* Classifies performance as input size grow
* "O" indicates the order of operation: time scale to perform an operation
* Many algorithms and data structures have more that one big-O


# Common Big-O Terms

* O(1)       Constant time.  Look a single element in an array.
* O(log n)   Logarithnmic.  Find an iten in a sorted array with binary search.
* O(n)       Linear time: Search an unsorted array for a specific falue.
* O(n log n) Long-linear: Complex sorting algorithms like heap sort and merge sort
* O(n2)      Quadratic: Simple sorting algothms such bubble sort, selection sort, and insertion sort.

## Data structures

# Arrays

* Position collection identified by intex or key
* Randon access
* Calculate item index: O(1)
* Insert or delete item at beginning: O(n)
* Insert or delete item at middle: O(n)
* Insert or delete item at end: O(1)

# Linked list

* Linear collection of data or elements.
* Contain reference to the next node in the list
* Hold whatever data the applicatoin needs
* Easily insert and remove elements
* Underlying memory doesn't need to be reorganized.
* Can't do constant-time random item access 
* Item lookup is linear in time complexity O(n)

# Stack / Pilha

* First In Last out
* Push Pop operations
* Last item pushed is the first one popped.
* Push add O(1)
* Pop remove O(1)
* Peek get element O(1)

# Queue

* Support adding and removind
* First item added is the first item out.
* 