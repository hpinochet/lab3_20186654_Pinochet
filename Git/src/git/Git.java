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
    
    public static ZonaTrabajo gitPull(ZonaTrabajo zona){
        
        // Selectores
        
        // Textos Planos Workspace
        
        Workspace workspace = zona.getWorkspace();
        ArrayList<TextoPlano> TextosPlanosWorkspace = workspace.getTextosPlanos();
        
        // Commits Remote Repository
        
        RemoteRepository auxiliarRemote = zona.getRemote();
        ArrayList<Commit> commitsRemote = auxiliarRemote.getCommits();
        
        // Condicion de Borde
        
        if(commitsRemote.isEmpty()){
            System.out.println("El Remote Repository no posee commits");
            System.out.println(" ");
            return zona;
        }
            
        // Se extraen los Textos planos de los commits
        
        ArrayList<TextoPlano> TextosPlanosFinal = new ArrayList<>();
        
        for(int i = 0; i < commitsRemote.size(); i++){
            Commit auxiliarCommit = commitsRemote.get(0);
            ArrayList<TextoPlano> auxliarTextosPlanos = auxiliarCommit.getTextosPlanos();
            Metodos.unirTextosPlanos(TextosPlanosFinal, auxliarTextosPlanos);
        }
        
        // Se unen los Textos planos del Remote Repository con los de Workspace
        
        ArrayList<TextoPlano> TextosPlanosFinal2 = Metodos.unirTextosPlanos(TextosPlanosWorkspace, TextosPlanosFinal);
            
        // Repetidos 

        ArrayList<TextoPlano> TextosPlanosFinal3 = Metodos.repetidosTextosPlanos(TextosPlanosFinal2);
        
        // Se crea nuevo Workspace
        Workspace workspaceFinal = new Workspace();
        workspaceFinal.setTextosPlanos(TextosPlanosFinal3);
        
        // Se instala nuevo workspace
        zona.setWorkspace(workspaceFinal);
        
        // Se retorna nueva zona de trabajo        
        return zona;
             
    }
    
    public static void gitStatus(ZonaTrabajo zona){
        
        // Informacion Repositorio
        
        String nombreRepo = zona.getNombreRepositorio();
        String nombreAutor = zona.getNombreAutor();
        
        // Numero Archivos Worksapce
        
        Workspace workspace = zona.getWorkspace();
        ArrayList<TextoPlano> textosPlanoWorkpace = workspace.getTextosPlanos();
        int nArchWorkspace = textosPlanoWorkpace.size();
        
        // Numero Archivos Index
        
        Index index = zona.getIndex();
        ArrayList<TextoPlano> textosPlanoIndex = index.getTextosPlanos();
        int nArchIndex = textosPlanoIndex.size();
        
        // Numero Commits Local Repository
        
        LocalRepository local = zona.getLocal();
        ArrayList<Commit> commitsLocal = local.getCommits();
        int nCommLocal = commitsLocal.size();
        
        // Numero Commits Remote Repository
        
        RemoteRepository remote = zona.getRemote();
        ArrayList<Commit> commitsRemote = remote.getCommits();
        
        boolean Cambios = Metodos.alDia(commitsLocal, commitsRemote);
        
        if(Cambios){
            System.out.println("Nombre Repositorio: " + nombreRepo + "\nNombre Autor Repositorio: " + nombreAutor + "\nNumero Archivos en Workspace: " +
                    nArchWorkspace + "\nNumero Archivos en Index: " + nArchIndex + "\nNumero Commits en Local Repository: " + nCommLocal 
                    + "\nRemote Repository esta al dia: Sí" );
        }else{
            System.out.println("Nombre Repositorio: " + nombreRepo + "\nNombre Autor Repositorio: " + nombreAutor + "\nNumero Archivos en Workspace: " +
                    nArchWorkspace + "\nNumero Archivos en Index: " + nArchIndex + "\nNumero Commits en Local Repository: " + nCommLocal
                    + "\nRemote Repository esta al dia: No" );
        }
    }
    
    public static void gitLog(ZonaTrabajo zona){
        
        // Commits Local Repository
        
        LocalRepository local = zona.getLocal();
        ArrayList<Commit> commitsLocal = local.getCommits();
        
        ArrayList<Commit> ultimosCommits = new ArrayList<>();
        
        if(commitsLocal.size() <= 5){
            for(int i = commitsLocal.size() - 1; i >= 0; i-- ){
                ultimosCommits.add(commitsLocal.get(i));
            }
        }else{
            for(int i = commitsLocal.size() - 1; i >= commitsLocal.size() - 5; i-- ){
                ultimosCommits.add(commitsLocal.get(i));
            }           
        }
        
        System.out.println(ultimosCommits);
    }
    
    
}
