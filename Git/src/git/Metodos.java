package git;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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
}
