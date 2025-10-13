import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class Lista {
    
    ArrayList<String> lista = new ArrayList<>();
    
    public void push(String caracter) {
         
        lista.add(caracter);
    }

    public String pop() {
        
        if (lista.size() == 0) {
            
            return null;
            
        }
        
        return lista.remove(lista.size() - 1);
    }

    public String peek() {
        
        if (lista.size() == 0) {
            
            return null;
            
        }
        
        return lista.get(lista.size() - 1);
    }

    public boolean vacio() {
        
        if (lista.size() == 0) {
            
            return true;
            
        } else {
            
            return false;
            
        }
    }

    public int size() {
        
        return lista.size();
        
    }
    
} 

public class PP2 {

    public static void main(String[] args) {

        Lista pila = new Lista();

        try {
    
            FileReader extraer = new FileReader("input.txt");

            int n;
            
            while ((n = extraer.read()) != -1) {
                
                char caracter = (char) n;
                
                pila.push(String.valueOf(caracter));
            
            }
            
            extraer.close();

            FileWriter escribir = new FileWriter("output.txt");

            while (!pila.vacio()) {

                escribir.write(pila.pop());

            }

            escribir.close(); 

        } catch (IOException e) {

            }
        } 
} 
