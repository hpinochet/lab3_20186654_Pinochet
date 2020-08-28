package git;

import java.util.ArrayList;
import java.util.Scanner;

public class Git {
    
    public static ZonaTrabajo gitinit(String nombreRepositorio, String nombreAutor){
        ZonaTrabajo nuevaZona = new ZonaTrabajo(nombreRepositorio,nombreAutor);
        return nuevaZona;
    }
    
    public static ZonaTrabajo gitCrear(ZonaTrabajo zona){
        
        // Se obtiene lista actual de textos planos Workspace
        Workspace auxiliarWorkspace = zona.getWorkspace();
        ArrayList<TextoPlano> textosWorkspaceAux = auxiliarWorkspace.getTextosPlanos();
        
        // Se obtienen datos del nuevo texto plano
        
        Scanner objRepo = new Scanner(System.in);
        System.out.println("Ingrese nombre de texto plano: ");
        String nombre = objRepo.nextLine();
        
        Scanner objContenodo = new Scanner(System.in);
        System.out.println("Ingrese contenido de texto plano: ");
        String contenido = objRepo.nextLine();
               
        String fecha = Metodos.obtenerFecha();
        
        // Se crea nuevo texto plano y se agrega
        TextoPlano texto = new TextoPlano(nombre,fecha,contenido);
        textosWorkspaceAux.add(texto);
        
        // Se filtan archviso repetidos
        
        ArrayList<TextoPlano> textosWorkspaceAux2 = Metodos.repetidosTextosPlanos(textosWorkspaceAux);
        
        // Se crea nuevo Workspace
        Workspace workspaceFinal = new Workspace();
        workspaceFinal.setTextosPlanos(textosWorkspaceAux2);
        
        // Se instala nuevo workspace
        zona.setWorkspace(workspaceFinal);
        
        // Se retorna nueva zona de trabajo        
        return zona;
    }
}
