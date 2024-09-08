
package Interfaz;

import Objetos.Producto;
import java.util.List;

/**
 *
 * @author 228761
 */
public interface IProductoDAO {
    public boolean agregar(Producto producto);
    public boolean eliminar(int id);
    public boolean actualizar(Producto producto);
    public Producto consultar(int id);
    public List<Producto> consultar();
}
