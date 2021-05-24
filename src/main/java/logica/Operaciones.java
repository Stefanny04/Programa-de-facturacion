
package logica;

import java.util.List;

public interface Operaciones<T> {
    public List<T> consultar();
    public T llevarInventario(String dato);
    public int actualizarExt(int cant, T dato);
}
