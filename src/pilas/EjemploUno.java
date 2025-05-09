package pilas;

import java.util.Stack;

public class EjemploUno {

    public static void main(String[] args) {

        // create a new stack
        Stack<Integer> s = new Stack<>();

        // Push elements onto the stack
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        // pop elements from the stack
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
