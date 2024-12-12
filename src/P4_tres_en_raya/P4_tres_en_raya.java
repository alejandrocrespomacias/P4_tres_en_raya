package P4_tres_en_raya;

import java.util.Scanner;
import java.util.Random;


public class P4_tres_en_raya {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner sc = new Scanner(System.in);
		 
		Random rand = new Random();
		 
		 
		 
		String[][] tablero = new String[3][3];
		 
		 
		String jugador1, jugador2;
		
		
		String turno;
		
		
		
		System.out.print("Ingresa el nombre del Jugador 1: ");
	        jugador1 = sc.nextLine(); 
	        
	    System.out.print("Ingresa el nombre del Jugador 2: ");
	        jugador2 = sc.nextLine(); 
	        
	        
	        turno = rand.nextBoolean() ? jugador1 : jugador2; 
	        
	        
	   System.out.println("La moneda se ha lanzado: " + turno + " empieza el juego.");  
	   
	   
	   
	   boolean jugar = true;
       while (jugar) {
           
           for (int i = 0; i < 3; i++) {
               for (int j = 0; j < 3; j++) {
                   tablero[i][j] = " ";  
               }
           }

          
           boolean juegoTerminado = false;
           while (!juegoTerminado) {
              
               System.out.println("\nTablero:");
               for (int i = 0; i < 3; i++) {
                   for (int j = 0; j < 3; j++) {
                       System.out.print("[" + tablero[i][j] + "] ");  
                   }
                   System.out.println();
               }
	        
           }
	        
	        
	        
	        
	        
	        
	        
           }	
	}

}
