public class Proceso {
    private String nombreProceso;
    private String nombreUsuario;
    private int nice;

    public Proceso(String nombreProceso, String nombreUsuario, int nice) {
        this.nombreProceso = nombreProceso;
        this.nombreUsuario = nombreUsuario;
        this.nice = nice;
    }

    public String getNombreProceso() {
        return nombreProceso;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public int getNice() {
        return nice;
    }

    @Override
    public String toString() {
        int prioridad = 20 + nice;
        return nombreProceso + "," + nombreUsuario + "," + prioridad + ",PR=" + (100 + prioridad);
    }
}
