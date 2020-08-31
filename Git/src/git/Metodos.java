package git;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Metodos {
    
    public static String obtenerFecha(){
        LocalDateTime objFecha = LocalDateTime.now();   
        DateTimeFormatter objFormateado = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
        String formattedDate = objFecha.format(objFormateado);  
        return formattedDate;
    }
    
    public static ArrayList<TextoPlano> repetidosTextosPlanos(ArrayList<TextoPlano> TextosPlanosFinal){
        ArrayList<TextoPlano> TextosPlanosFinal2 = new ArrayList<>();
        TextoPlano Aux;
        TextoPlano Aux2;
        boolean Repetido = false;

        for(int i = 0; i < TextosPlanosFinal.size(); i++){
            Aux = TextosPlanosFinal.get(i);
            for(int j = i + 1; j < TextosPlanosFinal.size(); j++){
                Aux2 = TextosPlanosFinal.get(j);
                if(Aux.equals(Aux2)){
                    Repetido = true;
                }                
            }
            if(Repetido == false){
                TextosPlanosFinal2.add(TextosPlanosFinal.get(i));
            }
            Repetido = false;
        }
        
        return TextosPlanosFinal2;      
    }
    
    public static ArrayList<TextoPlano> unirTextosPlanos(ArrayList<TextoPlano> TextosAux, ArrayList<TextoPlano> TextosAux2){
        
        ArrayList<TextoPlano> TextosPlanosFinal = new ArrayList<>();
        
        for(int i = 0; i < TextosAux.size(); i++){
            TextosPlanosFinal.add(TextosAux.get(i));
        }
        
        for(int i = 0; i < TextosAux2.size(); i++){
            TextosPlanosFinal.add(TextosAux2.get(i));
        }
        
        return TextosPlanosFinal;
    }
    
    public static ArrayList<TextoPlano> obtenerArchivos(ArrayList<TextoPlano> TextosPlanos, int Cantidad){
        
        ArrayList<TextoPlano> TextosPlanosFinal = new ArrayList<>();
        
        for(int i = 0; i < Cantidad; i++){        
            System.out.println("Nombre del archivo: ");
            Scanner objArchivo = new Scanner(System.in);
            String nombreArchivo = objArchivo.nextLine();
            for(int j = 0; j < TextosPlanos.size(); j++){
                TextoPlano Aux2 = TextosPlanos.get(j);
                String nombreArchivoAux = Aux2.getNombre();
                if(nombreArchivo.equals(nombreArchivoAux)){
                    TextosPlanosFinal.add(Aux2);
                }
                
            }
        }
        
        return TextosPlanosFinal;       
    }
    
    public static ArrayList<Commit> unirCommits(ArrayList<Commit> commitsAux, ArrayList<Commit> commitsAux2){
        
        ArrayList<Commit> CommitsFinal = new ArrayList<>();
        
        for(int i = 0; i < commitsAux.size(); i++){
            CommitsFinal.add(commitsAux.get(i));
        }
        
        for(int i = 0; i < commitsAux2.size(); i++){
            CommitsFinal.add(commitsAux2.get(i));
        }
        
        return CommitsFinal;
    }
    
    public static ArrayList<Commit> repetidosCommits(ArrayList<Commit> CommitsFinal){
        ArrayList<Commit> CommitsFinal2 = new ArrayList<>();
        Commit Aux;
        Commit Aux2;
        boolean Repetido = false;

        for(int i = 0; i < CommitsFinal.size(); i++){
            Aux = CommitsFinal.get(i);
            for(int j = i + 1; j < CommitsFinal.size(); j++){
                Aux2 = CommitsFinal.get(j);
                if(Aux.equals(Aux2)){
                    Repetido = true;
                }                
            }
            if(Repetido == false){
                CommitsFinal2.add(CommitsFinal.get(i));
            }
            Repetido = false;
        }
        
        return CommitsFinal2;
    }
        
}
