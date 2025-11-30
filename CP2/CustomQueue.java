public class CustomQueue {

    private QueueNode _head;

    public CustomQueue() {
        _head = null;
    }

    public void enqueue(int index) {
        var node = new QueueNode(index);
        
        if (_head == null) {
            _head = node;
        } else {
            
            QueueNode curr = _head;
            while (curr.getNext() != null) {
                curr = curr.getNext();
            }
            curr.setNext(node);
        }
        
    }

    public int dequeue() {
        var index = -1;
        
        if (_head != null) {
            index = _head.getIndex();
            _head = _head.getNext();
        }
        
        return index;
    }

    public int getSize() {
        var size = 0;
        
        QueueNode curr = _head;
        while (curr != null) {
            size++;
            curr = curr.getNext();
        }
        
        return size;
    }

    public String getIndexes() {
        var builder = new StringBuilder();
        for (var index = dequeue(); index > -1; index = dequeue()) {
            builder.append(" " + index);
        }
        return builder.toString();
    }
}
