import java.util.Arrays;

public class Main{

    public static void main(String[] args) {
        int[] nums = {9, 4, 6, 5, 2, 10, 7, 1, 8};

        int[] evenNums = new int[nums.length];
        int evenCount = 0;

        for (int num : nums) {
            if (num % 2 == 0) {
                evenNums[evenCount++] = num;
            }
        }
        System.out.println("Array prima dell'ordinamento: ");
        System.out.println(Arrays.toString(nums));
        // Ordina i numeri pari usando il merge sort
        mergeSort(evenNums, evenCount);

        // Riporta i numeri pari ordinati nell'array originale
        int evenIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                nums[i] = evenNums[evenIndex++];
            }
        }

        System.out.println("Array dopo l'ordinamento: ");
        System.out.println(Arrays.toString(nums));
    }
    //int [] arr e int n corrispondono a dei parametri in entrata

    public static void mergeSort(int[] arr, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        // Copia gli elementi nella parte sinistra e destra
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < n; i++) {
            right[i - mid] = arr[i];
        }

        // Ricorsione per ordinare le due metà
        mergeSort(left, mid);
        mergeSort(right, n - mid);

        // Unisci le due metà ordinate
        merge(arr, left, right, mid, n - mid);
    }

    public static void merge(int[] arr, int[] left, int[] right, int leftSize, int rightSize) {
        int i = 0, j = 0, k = 0;
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                k++;
                i++;
            } else {
                arr[k] = right[j];
                k++;
                j++;
            }
        }
        while (i < leftSize) {
            arr[k] = left[i];
            k++;
            i++;
        }
        while (j < rightSize) {
            arr[k] = right[j];
            k++;
            j++;
        }
    }
}
