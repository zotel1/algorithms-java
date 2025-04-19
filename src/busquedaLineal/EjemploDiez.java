package busquedaLineal;

public class EjemploDiez {

    // Function to perform Two Way Linear Search
    public static int search(int[] arr, int target,
                             int size)
    {
        // Initialize the starting and ending pointers
        int start = 0, end = size - 1;

        // Iterate till start and end cross each other
        while (start <= end) {
            // If the start element is equal to target,
            // return start as the index of target element
            if (arr[start] == target) {
                return start;
            }
            // If the ending element is equal to target,
            // return end as the index of target element
            if (arr[end] == target) {
                return end;
            }
            // If target is not equal to starting or ending
            // element, increment start by 1 and decrement
            // end by 1
            start++;
            end--;
        }
        // Return -1 if the target element is not found
        return -1;
    }

    // Driver code
    public static void main(String[] args)
    {
        // Sample Input
        int[] arr = { 3, 9, 12, 16, 20 };
        int target = 12;
        int size = arr.length;
        int pos = search(arr, target, size);
        if (pos == -1) {
            System.out.println(
                    "Element is not present in array");
        }
        else {
            System.out.println(
                    "Element is present at index " + pos);
        }
    }

}
