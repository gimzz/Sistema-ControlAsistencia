import com.miempresa.gestionasistencia.model.Asistencia;
import java.util.List;

public class AsistenciaDAO {
    boolean AgregarAsistencia(Asistencia);
    Asistencia ObtenerAsistenciaPorId(int id);
    List<Asistencia> obtenerAsistenciasporUsuario(int usuarioId);
    List<Asistencia> obtenerTodasAsistencias();
    boolean actualizarAsistencia(Asistencia asistencia);
    boolean eliminarAsistencia(int id);
}
