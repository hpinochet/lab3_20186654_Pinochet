package git;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        System.out.println("### BIENVENIDO A SIMULACIÓN GIT ###");
        System.out.println("### Cree su nuevo repositorio ###");
        
        Scanner objRepo = new Scanner(System.in);
        System.out.println("Ingrese nombre de repositorio: ");
        String nombreRepo = objRepo.nextLine();
        
        Scanner objAutor = new Scanner(System.in);
        System.out.println("Ingrese nombre autor de repositorio: ");
        String nombreAutor = objAutor.nextLine();
                
        ZonaTrabajo Zona = Git.gitinit(nombreRepo, nombreAutor);
        System.out.println(" ");
        System.out.println(Zona);
        System.out.println(" ");
        
        int opcion = 0;
        
        while(opcion != 8){
            System.out.println("### SIMULACIÓN GIT ###");
            System.out.println("Escoja su opción");
            System.out.println("1. Crear nuevo archivo");
            System.out.println("2. add");
            System.out.println("3. commit");
            System.out.println("4. pull");
            System.out.println("5. push");
            System.out.println("6. status");
            System.out.println("7. log");
            System.out.println("8. salir");
            Scanner objOpcion = new Scanner(System.in);
            System.out.println("INTRODUZCA SU OPCIÓN: ");
            opcion = objOpcion.nextInt();
            
            System.out.println(" ");
            
            if(opcion == 1){
                Zona = Git.gitCrear(Zona);
            }
            
            if(opcion == 2){
                Zona = Git.gitAdd(Zona);
            }
            
            if(opcion == 3){
                Zona = Git.gitCommit(Zona);
            }
            /*
            if(opcion == 4){
                Zona = Git.gitPull(Zona);
            }
            
            if(opcion == 5){
                Zona = Git.gitPush(Zona);
            }
            
            if(opcion == 6){
                Git.gitStatus(Zona);
                System.out.println(" ");
            }
            
            if(opcion == 7){
                Git.gitLog(Zona);
                System.out.println(" ");
            }
            */

            System.out.println(Zona);
            System.out.println(" ");
        }        
    }
}
