package bintreeintarray;

import java.util.Arrays; 
import java.util.Stack;

public class BinTreeIntArray {

    private Integer[] _tree;

    public BinTreeIntArray(int size) {
        _tree = new Integer[size];
    }

    public Integer[] getTree() {
        return _tree;
    }

    public void insert(int value) {
        
        int n = 0;
        while (n < _tree.length) {
            if (_tree[n] == null) {
                _tree[n] = value;
                break;
            } else if (value < _tree[n]) {
                n = 2 * n + 1;
            } else if (value > _tree[n]) {
                n = 2 * n + 2;
            } else {
                break;
            }
        }

        System.out.println(" ↳ insert: " + value + " → " + Arrays.toString(_tree));
    }

    public void inOrderTraversal() { // left -> root -> right
        System.out.print(" ↳ inOrderTraversal → ");
        var stack = new Stack<Integer>();
        var index = 0;
        while (!stack.isEmpty() || (index < _tree.length && _tree[index] != null)) {
            while (index < _tree.length && _tree[index] != null) {
                stack.push(index);
                index = 2 * index + 1;
            }
            index = stack.pop();
            System.out.print(_tree[index] + " ");
            index = 2 * index + 2;
        }
        System.out.println();
    }

    public void preOrderTraversal() {
        System.out.print(" ↳ preOrderTraversal → ");

        Stack<Integer> pila = new Stack<>();
        if (_tree[0] != null) pila.push(0);

        while (!pila.isEmpty()) {
            int index = pila.pop();
            System.out.print(_tree[index] + " ");
            int right = 2 * index + 2;
            int left = 2 * index + 1;
            

            if (right < _tree.length && _tree[right] != null) {
                pila.push(right);
            }
            if (left < _tree.length && _tree[left] != null) {
                pila.push(left);
            }
        }

        System.out.println();
    }

    public void postOrderTraversal() {
        System.out.print(" ↳ postOrderTraversal → ");

        Stack<Integer> pila1 = new Stack<>();
        Stack<Integer> pila2 = new Stack<>();
        if (_tree[0] != null) pila1.push(0);

        while (!pila1.isEmpty()) {
            int n = pila1.pop();
            pila2.push(n);

            int left = 2 * n + 1;
            int right = 2 * n + 2;

            if (left < _tree.length && _tree[left] != null) {
                pila1.push(left);
            }
            if (right < _tree.length && _tree[right] != null) {
                pila1.push(right);
            }
        }

        while (!pila2.isEmpty()) {
            System.out.print(_tree[pila2.pop()] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        var tree = new BinTreeIntArray(7);
        System.out.println("Empty array → " + Arrays.toString(tree.getTree()));
        tree.insert(4);
        tree.insert(6);
        tree.insert(5);
        tree.insert(2);
        tree.insert(7);
        tree.insert(1);
        tree.insert(3);
        System.out.println("\nFull array → " + Arrays.toString(tree.getTree()));
        tree.inOrderTraversal();
        tree.preOrderTraversal();
        tree.postOrderTraversal();
    }
}
