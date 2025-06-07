public class Asistencia {
    private int id;
    private int usuario_id;
    private Date date;
    private String estado;


    public class Asistencia(){

    }

    public class Asistencia(int id, int usuario_id, Date date, String estado){
        this.id=id;
        this.usuario_id=usuario_id;
        this.date=date;
        this.estado=estado;

    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id;
    }
     public int getUsuarioId() {
        return usuario_id;
    }
    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date fecha) {
        this.date = date;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
