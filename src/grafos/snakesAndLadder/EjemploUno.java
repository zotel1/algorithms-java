package grafos.snakesAndLadder;

import java.util.LinkedList;
import java.util.Queue;

/*
* Dado un tablero de serpiente y escalera, encuentre el número minimo de lanzamientos de dados necesarios para llegar al
* destino o a la ultima casilla desde la fuente o la 1ª celda. Básicamente, el jugador tiene control total sobre el resultado de la tirada de dados y quiere averiguar el número mínimo de tiradas necesarias para llegar a la última casilla.
Si el jugador llega a una casilla que es la base de una escalera, el jugador tiene que subir por esa escalera y si llega a una casilla es la boca de la serpiente, y tiene que bajar hasta la cola de la serpiente sin tirar los dados.
* Resultado: 3
Explicación: Los siguientes son los pasos:



Primero lanza dos dados para llegar a la casilla número 3 y luego escala para llegar a la 22
Luego lanza 6 para llegar a 28.
Finalmente a través de 2 para llegar a 30.
También puede haber otras soluciones como (2, 2, 6), (2, 4, 4), (2, 3, 5).. etcetera.*/
public class EjemploUno {

    // An entry in queue used in BFS
    static class qentry {
        int v; // Vertex number
        int dist; // Distance of this vertex from source
    }

    // This function return minimum number of dice
    // throws required to Reach las cell from 0' th cell
    // in a snake and ladder game. move[] is an array of
    // size N where N is no. of cells on board If there
    // is no snake or ladder from cell i, then move[i]
    // is -1 Otherwise move[i] contains cell to which
    // snake or ladder at i takes to.

    static int getMinDiceThrow(int move[], int n) {
        int visited[] = new int[n];
        Queue<qentry> q = new LinkedList<>();
        qentry qe = new qentry();
        qe.v = 0;
        qe.dist = 0;

        // Mark the node 0 as visited and enqueue it.
        visited[0] = 1;
        q.add(qe);

        // Do a BFS starting from vertex at index 0
        while (!q.isEmpty()) {
            qe = q.remove();
            int v = qe.v;

            // If front vertex is the destination
            // vertex, we are done
            if (v == n - 1)
                break;

            // Otherwise dequeue the front vertex and
            // enqueue its adjacent vertices ( or cell numbers reachable through a dice throw)
            for (int j = v + 1; j <= (v + 6) && j < n; ++j) {
                // If this cell is already visited, then ignore
                if (visited[j] == 0) {
                    // Otherwise calculate its distance and mark it as visited
                    qentry a = new qentry();
                    a.dist = (qe.dist + 1);
                    visited[j] = 1;

                    // Check if there a snake or ladder at 'j' then tail of snake or top of ladder become the adjacent of 'i'
                    if (move[j] != -1)
                        a.v = move[j];
                    else
                        a.v = j;
                    q.add(a);
                }
            }
        }

        // We reach here when 'qe' has last vertex return the distance of vertex in 'qe'
        return qe.dist;
    }

    public static void main(String[] args) {
        // let us construct board given in above diagram
        int N = 30;
        int moves[] = new int[N];
        for (int i = 0; i < N; i++)
            moves[i] = -1;

        // Ladders
        moves[2] = 21;
        moves[4] = 7;
        moves[10] = 25;
        moves[19] = 28;

        // Snakes
        moves[26] = 0;
        moves[20] = 8;
        moves[16] = 3;
        moves[18] = 6;

        System.out.println("Min Dice throws required is " + getMinDiceThrow(moves, N));
    }
}
