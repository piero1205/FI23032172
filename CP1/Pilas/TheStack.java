package pilas;

import java.util.Stack;

public class TheStack<Type> implements TheStackInterface<Type> {

    private Stack<Type> _stack;
    
    private Integer _capacity;

    public TheStack(Integer capacity) {
        
        _stack = new Stack<Type>();
        
        _capacity = capacity;
    }

    public Boolean push(Type item) {
        
        if (_stack.size() < _capacity) {
            _stack.push(item);
            return true;
        }
        return false;
    }

    public Type pop() {
        return _stack.isEmpty() ? null : _stack.pop();
    }

    public Type peek() {
        return _stack.isEmpty() ? null : _stack.peek();
    }

    public Boolean empty() {
        return _stack.isEmpty();
    }

    public Integer size() {
        return _stack.size();
    }

    public String print() {
        return _stack.toString();
    }
}
