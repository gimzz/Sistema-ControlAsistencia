import java.util.Date;

public class Asistencia {
    private int id;
    private int usuarioId;
    private Date date;
    private String estado;

    public Asistencia() {
    }

    public Asistencia(int id, int usuarioId, Date date, String estado) {
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
