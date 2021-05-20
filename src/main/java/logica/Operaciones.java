
package logica;

import java.util.List;

public interface Operaciones<T> {
    public List<T> consultar();
    public T agregar(String dato);
    
}
