package grafos.wordLadder;

/*samos  el retroceso para resolver este problema porque nos permite explorar sistemáticamente
todas las secuencias de transformación posibles desde la palabra inicial hasta la palabra objetivo,
al tiempo que nos aseguramos de no volver a visitar la misma palabra dentro de una ruta determinada. En cada paso, probamos todos los cambios posibles de una letra en la palabra actual y procedemos de forma recursiva si la palabra resultante existe en el diccionario y aún no se ha visitado. El retroceso permite al algoritmo "retroceder" una vez que llega a un callejón sin salida o completa una ruta, y luego probar una opción diferente. */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EjemploUno {
    // Recursive function to find the shortest transformation chain
    public static int minWordTransform(String start, String target, Map<String, Integer> mp) {
        // If start word is the same as target, no transformation is needed
        if (start.equals(target)) return 1;

        int mini = Integer.MAX_VALUE;

        // Mark current word as visited
        mp.put(start, 1);

        // Try changing each character of the word
        for (int i = 0; i < start.length(); i++) {
            char[] chars = start.toCharArray();
            char originalChar = chars[i];

            // Try all posible lowercase letters at position i
            for(char ch = 'a'; ch <= 'z'; ch++) {
                chars[i] = ch;
                String transformed = new String(chars);

                // If the new word exists in dictionary and is not viosited
                if (mp.containsKey(transformed) && mp.get(transformed) == 0) {
                    // Recursive call for next transforemation
                    mini = Math.min(mini, 1 + minWordTransform(transformed, target, mp));
                }
            }

            // Restore original character before movbing to the next position
            chars[i] = originalChar;
        }

        // Mark current word as unvisited (backtracking)
        mp.put(start, 0);

        return mini;
    }

    // Wrapper function to prepare the map and call recursive function
    public static int wordLadder(String start, String target, ArrayList<String> arr) {

        Map<String, Integer> mp = new HashMap<>();

        // Initialize all words from the dictionary as unvited
        for (String word : arr) {
            mp.put(word, 0);
        }

        int result = minWordTransform(start, target, mp);
        if(result== Integer.MAX_VALUE)
            result = 0;
        return result;
    }

    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>(Arrays.asList(
                "poon", "plee", "same", "poie", "plie", "poin", "plea"));

        String start = "toon";
        String target = "plea";
        System.out.println(wordLadder(start, target, arr));
    }
}
