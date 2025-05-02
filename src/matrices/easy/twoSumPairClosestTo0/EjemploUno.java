package matrices.easy.twoSumPairClosestTo0;

public class EjemploUno {

    // function to find the minimun absolute sum pair
    static int minAbsSumPair(int[] arr) {

        // Inicialize the result with the sum of the first two element
        int res = arr[0] + arr[1];

        // Consider every pair, find its sum and update result if we get a smaller value
        for(int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if (Math.abs(sum) < Math.abs(res)) {
                    res = sum;
            }
                else if (Math.abs(sum) == Math.abs(res)) {
                    res = Math.max(res, sum);
                }
        }
    }
        return res;
}

    public static void main(String[] args) {
        int[] arr = { 0, -8, -6, 3};
        System.out.println(minAbsSumPair(arr));
    }
}
