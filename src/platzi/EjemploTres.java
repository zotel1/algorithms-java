package platzi;

import java.util.Arrays;

public class EjemploTres {

    public static int[] unirListas(int[] nums1, int[] nums2, int m, int n) {
        int p1 = m-1;
        int p2 = n-1;

        for (int i = (n + m -1); i >= 0 ; i--) {
            if (p1 >= 0 && p2 >= 0) {
                if (nums1[p1] <= nums2[p2]) {
                    nums1[i] = nums2[p2];
                    p2--;
                } else {
                    nums1[i] = nums1[p1];
                    p1--;
                }
            } else if (p1 < 0) {
                nums1[i] = nums2[p2];
                p2--;
            }
        }
        return nums1;
    }

    public static void main(String[] args) {
        int[] nums1 = {-4, 1, 2, 3, 4, 5, 0, 0, 0};
        int m = 6;
        int[] nums2 = {-5, 2, 5, 6};
        int n = 3;

        System.out.println(Arrays.toString(unirListas(nums1, nums2, m, n)));
    }
}
