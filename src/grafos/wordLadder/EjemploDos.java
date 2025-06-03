package grafos.wordLadder;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class EjemploDos {
    static int wordLadder(String start, String target, String[] arr) {

        // set to keep track of universited words
        Set<String> st = new HashSet<String>();
        for(int i = 0; i < arr.length; i++)
            st.add(arr[i]);

        // Store the current chain length
        int res = 0;
        int m = start.length();

        // Queue to store words to visit
        Queue<String> words = new LinkedList<>();
        words.add(start);

        while (!words.isEmpty()) {
            int len = words.size();
            res++;

            // Iterate through all words at the same level
            for (int i = 0; i < len; ++i) {
                String word = words.poll();

                // For every character of the word
                for (int j = 0; j < m; ++j) {

                    // Retain the original character at the current position
                    char[] wordArr = word.toCharArray();
                    char ch = wordArr[j];

                    // Replace the current character with every possible lowercase alphabet
                    for (char c = 'a'; c <= 'z'; ++c) {
                        wordArr[j] = c;
                        String newWord = new String(wordArr);

                        // Skip the word if already added of not present in set
                        if (!st.contains(newWord))
                            continue;

                        // If target word is found
                        if (newWord.equals(target))
                            return res + 1;

                        // Remove the word from set
                        st.remove(newWord);

                        // And push the newly generated word wich will be a parte of the chain
                        words.add(newWord);
                    }
                    // Restore the original character
                    wordArr[j] = ch;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"poon", "plee", "same", "poie", "plie", "poin", "plea"};
        String start = "toon";
        String target = "plea";
        System.out.println(wordLadder(start, target, arr));
    }
}
