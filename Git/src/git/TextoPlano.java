package git;

public class TextoPlano {
    
    private String nombre;
    private String fecha;
    private String contenido;
    
    public TextoPlano(String nombre, String fecha, String contenido) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.contenido = contenido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    @Override
    public String toString() {
        return "TextoPlano{" + "nombre=" + nombre + ", fecha=" + fecha + ", contenido=" + contenido + '}';
    }
}
