package platzi;

public class EjemploCuatroV2 {

    public static int maxArea(int[] alturas) {
        int izquierda = 0;
        int derecha = alturas.length -1;
        int areaMaxima = 0;

        while (izquierda < derecha) {
            int areaActual = (derecha - izquierda ) * Math.min(alturas[izquierda], alturas[derecha]);
            areaMaxima = Math.max( areaActual, areaMaxima );
            if (alturas[izquierda] < alturas[derecha]) {
                izquierda += 1;
            } else {
                derecha -= 1;
            }
        }
        return areaMaxima;
    }

    public static void main(String[] args) {
        int[] alturas = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int areaMax = maxArea(alturas);
        System.out.println(areaMax);
    }
}
