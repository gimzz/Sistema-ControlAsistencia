import com.miempresa.gestionasistencia.model.Asistencia;
import java.util.List;

public interface AsistenciaDAO {
    boolean agregarAsistencia(Asistencia asistencia);
    Asistencia obtenerAsistenciaPorId(int id);
    List<Asistencia> obtenerAsistenciasPorUsuario(int usuarioId);
    List<Asistencia> obtenerTodasAsistencias();
    boolean actualizarAsistencia(Asistencia asistencia);
    boolean eliminarAsistencia(int id);
}
