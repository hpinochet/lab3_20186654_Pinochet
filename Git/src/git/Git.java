package git;

public class Git {
    
    public static ZonaTrabajo gitinit(String nombreRepositorio, String nombreAutor){
        ZonaTrabajo nuevaZona = new ZonaTrabajo(nombreRepositorio,nombreAutor);
        return nuevaZona;
    }
    
}
