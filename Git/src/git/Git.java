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
    
    public static ZonaTrabajo gitAdd(ZonaTrabajo zona){
        
        // Archivos Workspace

        Workspace workspaceAuxiliar = zona.getWorkspace();
        ArrayList<TextoPlano> workspaceTextos = workspaceAuxiliar.getTextosPlanos();

        // Archivos Index

        Index indexAuxliar = zona.getIndex();
        ArrayList<TextoPlano> indexTextos = indexAuxliar.getTextosPlanos();
        
        // Caso borde
        if(workspaceTextos.isEmpty()){
            System.out.println("El Workspace no posee archivos");
            System.out.println(" ");
            return zona;
        }
        
        System.out.println("Escoja opción de add");
        System.out.println("1. Todos los Archivos");
        System.out.println("2. Ingresar Archivos especificos");
        Scanner objOpcion = new Scanner(System.in);
        System.out.println("INTRODUZCA SU OPCIÓN: ");
        int opcion = objOpcion.nextInt();
        
        // Opcion de Ingresar todos los Archivos
        if(opcion == 1){

            // Se unen las listas
            
            ArrayList<TextoPlano> TextosPlanosFinal = Metodos.unirTextosPlanos(indexTextos, workspaceTextos);
            
            // Repetidos 

            ArrayList<TextoPlano> TextosPlanosFinal2 = Metodos.repetidosTextosPlanos(TextosPlanosFinal);
            
            // Se crea nuevo Index
            
            Index indexFinal = new Index();
            indexFinal.setTextosPlanos(TextosPlanosFinal2);
            
            // Se insatala nuevo index
            
            zona.setIndex(indexFinal);
            
            // Se retorna nueva zona
            
            return zona;
        }

        // Opcion de Ingresar siertos archivos
        if(opcion == 2){
            
            // Se pregunta cuales archivos se eligiran
            System.out.println("Cuantos archivos agregara: ");
            Scanner objCantidad = new Scanner(System.in);
            int Cantidad = objCantidad.nextInt();
            
            // Se obtienen los archivos ingresados por el usuario
            ArrayList<TextoPlano> workspaceAuxiliar2 = Metodos.obtenerArchivos(workspaceTextos,Cantidad);
            
            // Se unen las listas
            
            ArrayList<TextoPlano> TextosPlanosFinal = Metodos.unirTextosPlanos(indexTextos, workspaceAuxiliar2);
            
            // Repetidos 

            ArrayList<TextoPlano> TextosPlanosFinal2 = Metodos.repetidosTextosPlanos(TextosPlanosFinal);
            
            // Se crea nuevo Index
            
            Index indexFinal = new Index();
            indexFinal.setTextosPlanos(TextosPlanosFinal2);
            
            // Se insatala nuevo index
            
            zona.setIndex(indexFinal);
            
            // Se retorna nueva zona
            
            return zona;
        }
        return zona;
    }
        
    public static ZonaTrabajo gitCommit(ZonaTrabajo zona){
        
        //Selectores
        
        // Commits Local Repository
        
        LocalRepository auxiliarLocal = zona.getLocal();
        ArrayList<Commit> commitsAux = auxiliarLocal.getCommits();
         
        // Convertir a commit Index
        
        Index auxiliarIndex = zona.getIndex();
        ArrayList<TextoPlano> textosIndex = auxiliarIndex.getTextosPlanos();
        
        // Condicion de Borde
        if(textosIndex.isEmpty()){
            System.out.println("El Index no posee archivos");
            System.out.println(" ");
            return zona;
        }
        
        // Se obtienen los datos del usuario para el commit
        
        System.out.println("Ingrese nombre del autor del commit: ");
        Scanner objAutor = new Scanner(System.in);
        String nombreAutor = objAutor.nextLine();
        
        System.out.println("Ingrese mensaje del commit: ");
        Scanner objMensaje = new Scanner(System.in);
        String mensajeCommit = objMensaje.nextLine();
        
        String fecha = Metodos.obtenerFecha();
         
        // Se crea el nuevo Commit
        
        Commit commitAux = new Commit(nombreAutor,fecha,mensajeCommit,textosIndex);
        
        // Se inserta nuevo commit
        
        commitsAux.add(commitAux);
        
        // Se crea nuevo Index y Local Repository
        
        Index indexFinal = new Index();
            
        LocalRepository LocalFinal = new LocalRepository();
        LocalFinal.setCommits(commitsAux);

        // Se insatala nuevo Index y Local
        
        zona.setIndex(indexFinal);
        zona.setLocal(LocalFinal);

        // Se retorna nueva zona
        
        return zona;
    }
    
    public static ZonaTrabajo gitPush(ZonaTrabajo zona){
        
        // Selectores
        
        // Commits Remote Repository
        
        RemoteRepository auxiliarRemote = zona.getRemote();
        ArrayList<Commit> commitsRemote = auxiliarRemote.getCommits();
        
        // Commits Local Repository
        
        LocalRepository auxiliarLocal = zona.getLocal();
        ArrayList<Commit> commitsLocal = auxiliarLocal.getCommits();
        
        // Condicion de Borde
        
        if(commitsLocal.isEmpty()){
            System.out.println("El Local Repository no posee commits");
            System.out.println(" ");
            return zona;
        }
        
        // Se unen Los commits
        
        ArrayList<Commit> commitsFinal = Metodos.unirCommits(commitsRemote, commitsLocal);
        
        // Se filtran los commits
        
        ArrayList<Commit> commitsFinal2 = Metodos.repetidosCommits(commitsFinal);
        
        // Se crea nuevo Remote Repository
        
        RemoteRepository RemoteFinal = new RemoteRepository();
        RemoteFinal.setCommits(commitsFinal2);
        
        // Se inserta nuevo Remote Repository
        
        zona.setRemote(RemoteFinal);
        
        return zona;            
    }
            
}
