package git;

import java.util.ArrayList;

public class Commit {
    
    private String autor;
    private String fecha;
    private String mensaje;
    private ArrayList<TextoPlano> TextosPlanos;
    
    public Commit(String autor, String fecha, String mensaje, ArrayList<TextoPlano> TextosPlanos) {
        this.autor = autor;
        this.fecha = fecha;
        this.mensaje = mensaje;
        this.TextosPlanos = TextosPlanos;
    }
    
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public ArrayList<TextoPlano> getTextosPlanos() {
        return TextosPlanos;
    }

    public void setTextosPlanos(ArrayList<TextoPlano> TextosPlanos) {
        this.TextosPlanos = TextosPlanos;
    }
    
    @Override
    public String toString() {
        return "Commit{" + "autor=" + autor + ", fecha=" + fecha + ", mensaje=" + mensaje + ", TextosPlanos=" + TextosPlanos + '}';
    }
}
