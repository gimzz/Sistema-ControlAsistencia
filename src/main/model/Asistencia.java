import java.util.Date;
import com.miempresa.gestionasistencia.enums.EstadoAsistencia;

public class Asistencia {
    private int id;
    private int usuarioId;
    private Date date;
    private EstadoAsistencia estado;

    public Asistencia() {
    }

    public Asistencia(int id, int usuarioId, Date date, EstadoAsistencia estado) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.date = date;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public EstadoAsistencia getEstado() {
        return estado;
    }

    public void setEstado(EstadoAsistencia estado) {
        this.estado = estado;
    }
}
