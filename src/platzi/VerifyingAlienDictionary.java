package platzi;

/*En una lengua alienígena, sorprendentemente,
también utilizan las letras del español, pero
posiblemente en un orden diferente, una permutación
de nuestro alfabeto.

Dada una secuencia de palabras escritas en el idiomaextranjero, y el orden del alfabeto, devuelve el verdadero
si y solo si las palabras dadas están ordenadas
lexicográficamente en este idioma extranjero.

ejemplo:

palabras = ["conocer", "cono"]
orden_alfabeto =                ----------------> Falso
"abcdefghijklmnopqrstuvwxyz"

palabras = ["habito", "hacer", "lectura", "sonreir"]
orden_alfabeto = "hlacdefgijkmnopqrstuvwxyz"         -------------> Verdadero*/

import java.util.HashMap;
import java.util.Map;

public class VerifyingAlienDictionary {
    public static boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> dict = new HashMap<Character, Integer>();
        for (int index = 0; index < 26; index++) {
            dict.put(order.charAt(index), index + 1);
        }

        for (int index = 0; index + 1 < words.length; index++) {
            if (words[index].equals(words[index + 1])) {
                continue;
            }

            int wordLength = Math.max(words[index].length(), words[index + 1].length());
            for (int wordIndex = 0; wordIndex < wordLength; wordIndex++) {
                int val1 = words[index].length() > wordIndex ? dict.get(words[index].charAt(wordIndex)) : 0;
                int val2 = words[index + 1].length() > wordIndex ? dict.get(words[index + 1].charAt(wordIndex)) : 0;

                if (val1 > val2) {
                    return false;
                } else if (val1 < val2) {
                    break;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"habito", "hacer", "lectura", "sonreir"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";

        boolean result = isAlienSorted(words, order);
        System.out.println("¿Están ordenadas?: " + result);
    }
}