package platzi;

// Container with most water
/* alturas = [1,8,6,2,5,4,8,3,7] ---------------------> 49*/
public class EjemploCuatro {

    public static int containerWithMostWater(int[] alturas) {
        int mejorArea = 0;
        int p1 = 0;
        int p2 = alturas.length -1;

        while (p1 != p2) {
            int altura = Math.min(alturas[p1], alturas[p2]);
            int ancho = p2 - p1;
            int area = altura * ancho;

            if (area > mejorArea) {
                mejorArea = area;
            }

            if (alturas[p1] < alturas[p2]) {
                p1++;
            } else {
                p2--;
            }
        }

        return mejorArea;
    }

    public static void main(String[] args) {
        int[] alturas = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int areaMax = containerWithMostWater(alturas);
        System.out.println(areaMax);
    }

}
