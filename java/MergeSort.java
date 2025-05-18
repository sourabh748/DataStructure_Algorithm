public class MergeSort {

    public static void merge(int[] arr, int start, int mid, int end){
        int[] temp = new int[end - start + 1];

        int left = start, right = mid + 1, k = 0;

        while( left <= mid && right <= end ){
            if (arr[left] < arr[right]){
                temp[k++] = arr[left++];
                continue;
            }
            temp[k++] = arr[right++];
        }

        while( left <= mid ) {
            temp[k++] = arr[left++];
        }
        while( right <= end ) {
            temp[k++] = arr[right++];
        }

        for( int i= start; i <= end; i++ ){
            arr[i] = temp[i - start];
        }
    }

    public static void mergeSort(int[] arr, int start, int end){
        if (start < end) {
            int mid = (start + end) / 2;

            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{-5, 20, 10, 3, 2, 0};

        mergeSort(arr, 0, arr.length -1);

        for (int i : arr) {
            System.out.print(i + ", ");
        }
    }
}
