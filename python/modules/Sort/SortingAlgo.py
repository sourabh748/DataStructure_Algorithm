from typing import List, Any, Optional, Union

def bubble_sort(arr: List[Any], increasing: Optional[bool] = True ) -> None:
    '''
        It's easy to come up with a correct solution. Here's one:
        1. Iterate over the list of numbers, starting from the left
        2. Compare each number with the number that follows it
        3. If the number is greater than the one that follows it, swap the two elements
        4. Repeat steps 1 to 3 till the list is sorted.

        This method is called bubble sort, as it causes smaller elements to bubble to the top and larger to
        sink to the bottom.

        The time complexity of bubble sort Algorithm is O(N^2) and space complexity O(1)
    '''

    for i_dx in range(len(arr) -1):
        for j_dx in range(len(arr) -i_dx -1):
            if increasing:
                if arr[j_dx] > arr[j_dx + 1]:
                    arr[j_dx], arr[j_dx + 1] = arr[j_dx + 1], arr[j_dx]
            else:
                if arr[j_dx] < arr[j_dx + 1]:
                    arr[j_dx], arr[j_dx + 1] = arr[j_dx + 1], arr[j_dx]

def insertion_sort(arr:List[Any]) -> None:
    """
    insertion sort, where we keep the initial portion of the array sorted and insert the
    remaining elements one by one at the right position.

    Best Case Time complexity of Insertion Sort is O(N) and Worst case Time Complexity is O(N^2)
    Still, insertion sort algorithm is more efficient and less EXPENSIVE algoritm then bubble sort as bubble sort perform more swapping
    Operation then Insertion Sort.
    Because Insertion sort assumes that, data set is partially sorted so it perform less swapping Operation. ( It is more efficient when the data set is partially Sorted)
    """

    for index in range(len(arr)):
        curr =index

        while curr -1 >= 0 and arr[curr] < arr[curr -1]:
            arr[curr], arr[curr -1] = arr[curr -1], arr[curr]

            curr -= 1

def reverse_insertion_sort(arr:List[Any]) -> None:
    for index in range(len(arr)-1, -1, -1):
        curr = index

        while curr + 1 < len(arr) and arr[curr] < arr[curr + 1]:
            arr[curr], arr[curr +1] = arr[curr +1], arr[curr]

            curr += 1


def selection_sort(arr: List[Any]) -> None:
    for unsorted_index in range(len(arr)):
        min_index = unsorted_index
        for search in range(unsorted_index, len(arr)):
            if arr[search] < arr[min_index]:
                min_index = search

        arr[min_index], arr[unsorted_index] = arr[unsorted_index], arr[min_index]

def merge_sort(arr:List[Any] ) -> None:
    '''
    1. If the input list is empty or contains just one element, it is already sorted. Return it.
    2. If not, divide the list of numbers into two roughly equal parts.
    3. Sort each part recursively using the merge sort algorithm. You'll get back two sorted lists.
    4. Merge the two sorted lists to get a single sorted list

    Time Complexity of Merge Sort is O(log(N)) and space Complexity is O(N)
    Merge sort, a popular sorting algorithm, offers several advantages, particularly when dealing with large datasets, including its stability and consistent performance. 
    However, it also has drawbacks, such as requiring extra memory and being less efficient for very small datasets compared to some other sorting algorithms. 
    '''
    def merge(arr:List[Any], lo: int, mid: int, hi: int) -> None:
        temp = []
        
        start_l, start_r = lo, mid + 1

        while start_l <= mid and start_r <= hi:
            if arr[start_l] < arr[start_r]:
                temp.append(arr[start_l])
                start_l += 1
            else:
                temp.append(arr[start_r])
                start_r += 1

        while start_l <= mid:
            temp.append(arr[start_l])

            start_l += 1

        while start_r <= lo:
            temp.append(arr[start_r])

            start_r += 1

        for ele in temp:
            arr[lo] = ele
            lo += 1

    def sort(arr:List, lo, hi):
        if hi > lo:
            mid = (hi + lo) // 2

            sort(arr, lo, mid)
            sort(arr, mid + 1, hi)
            merge(arr, lo, mid, hi)

    sort(arr, 0, len(arr) -1)

def partition(arr: List[Any], start: int, end: int) -> int:
    left, right = start, end -1

    while right > left:

        if arr[left] <= arr[end]:
            left += 1
        elif arr[right] > arr[end]:
            right -= 1
        else:
            arr[left], arr[right] = arr[right], arr[left]
            left += 1
    
    if arr[left] > arr[end]:
        arr[left], arr[end] = arr[end], arr[left]
        return left
    
    return end

def quick_sort(arr: List[Any], start: int=0, end: Optional[Union[int, None]]= None) -> None:
    '''
    Quicksort
    To overcome the space inefficiencies of merge sort, we'll study another divide-and-conquer based
    sorting algorithm called quicksort, which works as follows:
        1. If the list is empty or has just one element, return it. It's already sorted.
        2. Pick a random element from the list. This element is called a pivot.
        3. Reorder the list so that all elements with values less than or equal to the pivot come before the
            pivot, while all elements with values greater than the pivot come after it. This operation is
            called partitioning.
        4. The pivot element divides the array into two parts which can be sorted independently by
            making a recursive call to quicksort.

    Worst Time complexity of QuickSort is O(N^2)
    '''
    if end is None:
        end = len(arr) -1
    
    if end > start:
        pivot = partition(arr, start, end)
        quick_sort(arr, start, pivot -1)
        quick_sort(arr, pivot + 1, end)