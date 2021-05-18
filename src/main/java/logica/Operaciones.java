
package logica;

import java.util.List;

public interface Operaciones<T> {
    public List<T> consultar();
    public List<T> agregar(Integer dato);
    
}
