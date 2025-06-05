package grafos.waterJugProblem;

import java.util.LinkedList;
import java.util.Queue;

/*Dada dos jarras vacías de m y n litros respectivamente. Las jarras no tienen marcas que permitan medir cantidades más pequeñas. Hay que utilizar las jarras para medir d litros de agua. La tarea consiste en encontrar el número mínimo de operaciones a realizar para obtener d litros de agua en una de las jarras. En caso de que no exista ninguna solución, retorna -1.

Las operaciones que puede realizar son:

Vaciar una jarra
Llena una jarra
Vierta agua de una jarra a la otra hasta que una de las jarras esté vacía o llena.
Ejemplo:

Entrada: m = 3, n = 5, d = 4
 Salida: 6
Explicación: Las operaciones son las siguientes:

Inicialmente, ambas jarras están vacías (jarra1 = 0, jarra2 = 0).
Paso 1: Llene la jarra de 5 litros -> (0, 5).
Paso 2: Vierta de la jarra de 5 litros a la jarra de 3 litros -> (3, 2).
Paso 3: Vacíe la jarra de 3 litros -> (0, 2).
Paso 4: Vierta los 2 litros de la jarra de 5 litros a la jarra de 3 litros -> (2, 0).
Paso 5: Vuelva a llenar la jarra de 5 litros -> (2, 5).
Paso 6: Vierta 1 litro de la jarra de 5 litros en la jarra de 3 litros -> (3, 4).
Ahora, la jarra de 5 litros contiene exactamente 4 litros, por lo que paramos y volvemos 6 pasos.

Entrada: m = 8, n = 56, d = 46
Salida: -1
Explicación: No es posible llenar ninguna de las jarras con 46 litros de agua.*/

public class EjemploUno {
    // Function to find the minimum operations to obtain
    // d liters in one jug
    static int minSteps(int m, int n, int d) {
        if (d > Math.max(m, n)) return -1;

        // Queue for BFS: each state is (jug1, jug2, steps)
        Queue<int[]> q = new LinkedList<>();

        // Tracking visited states
        boolean[][] visited = new boolean[m + 1][n + 1];

        // Start with both jugs empty
        q.add(new int[] {0, 0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int jug1 = curr[0], jug2 = curr[1], steps = curr[2];

            if (jug1 == d || jug2 == d) return steps;

            // All possible operations:

            // 1: Fill jug1
            if (!visited[m][jug2]) {
                visited[m][jug2] = true;
                q.add(new int[] {m, jug2, steps + 1});
            }

            // 2: Fill jug2
            if (!visited[jug1][n]) {
                visited[jug1][n] = true;
                q.add(new int[] {jug1, n, steps + 1});
            }

            // 3: Empty jug1
            if (!visited[0][jug2]) {
                visited[0][jug2] = true;
                q.add(new int[] {0, jug2, steps + 1});
            }

            // 4: Empty jug2
            if (!visited[jug1][0]) {
                visited[jug1][0] = true;
                q.add(new int[] {jug1, 0, steps + 1});
            }

            // 5: Pour jug1 into jug2
            int pour1to2 = Math.min(jug1, n - jug2);
            if (!visited[jug1 - pour1to2][jug2 + pour1to2]) {
                visited[jug1 - pour1to2][jug2 + pour1to2] = true;
                q.add(new int[] {jug1 - pour1to2, jug2
                        + pour1to2, steps + 1});
            }

            // 6: Pour jug2 into jug1
            int pour2to1 = Math.min(jug2, m - jug1);
            if (!visited[jug1 + pour2to1][jug2 - pour2to1]) {
                visited[jug1 + pour2to1][jug2 - pour2to1] = true;
                q.add(new int[] {jug1 + pour2to1, jug2
                        - pour2to1, steps + 1});
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        // jug1 = 4 litre, jug2 = 3 litre
        int m = 4, n = 3, d = 2;
        System.out.println(minSteps(m, n, d));
    }
}
