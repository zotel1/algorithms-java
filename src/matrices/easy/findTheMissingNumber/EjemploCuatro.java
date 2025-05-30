public class EjemploCuatro {
    public static int missingNum(int[] arr) {
        int n = arr.length + 1;
        int xor1 = 0, xor2 = 0;

        // XOR all numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            xor1 ^= i;
        }

        // Missing number is the XOR of xor1 and xor2
        return xor1 ^ xor2;
        }

    public static void main(String[] args) {
        int[] arr = {8, 2, 4, 5, 3, 7, 1 };
        int res = missingNum(arr);
        System.out.println(res);
    }
}
