package colas;

import java.util.ArrayDeque;
import java.util.Deque;

public class TheQueue<Type> implements TheQueueInterface<Type> {

    private Deque<Type> _queue;

    public TheQueue() {
        _queue = new ArrayDeque<>();
    }

    public void enqueue(Type item) {
        _queue.addLast(item);
    }

    public Type dequeue() {
        return _queue.pollFirst();
    }

    public Type getFront() {
        return _queue.peekFirst();
    }

    public boolean isEmpty() {
        return _queue.isEmpty();
    }

    public int getSize() {
        return _queue.size();
    }

    public String[] getCodons() {
        int size = _queue.size();
        int codonCount = size / 3;
        String[] codons = new String[codonCount];

        Object[] elements = _queue.toArray();
        for (int i = 0; i < codonCount; i++) {
            codons[i] = elements[i * 3] + "" + elements[i * 3 + 1] + "" + elements[i * 3 + 2];
        }

        return codons;
    }

    public String print() {
        return _queue.toString();
    }

}
