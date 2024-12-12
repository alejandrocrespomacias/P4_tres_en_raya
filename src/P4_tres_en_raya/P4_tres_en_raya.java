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
	        
           
               int fila, columna;
               System.out.println(turno + ", es tu turno (escoge una casilla):");
               while (true) {
                 
                   System.out.print("Ingresa la fila (0-2): ");
                   fila = sc.nextInt();
                   System.out.print("Ingresa la columna (0-2): ");
                   columna = sc.nextInt();

                 
                   if (tablero[fila][columna].equals(" ")) {
                      
                       tablero[fila][columna] = turno.equals(jugador1) ? "X" : "O";
                       break;  
                   } else {
                       
                       System.out.println("¡Esa casilla ya está ocupada! Intenta de nuevo.");
                   }
               }
	        
	        
               
          boolean hayGanador = false;
               
           for (int i = 0; i < 3; i++) {
               if (tablero[i][0].equals(tablero[i][1]) && tablero[i][1].equals(tablero[i][2]) && !tablero[i][0].equals(" ")) {
                   hayGanador = true;  
                   break;
               		}
           		}
               
           for (int j = 0; j < 3; j++) {
               if (tablero[0][j].equals(tablero[1][j]) && tablero[1][j].equals(tablero[2][j]) && !tablero[0][j].equals(" ")) {
                   hayGanador = true;  
                   break;
               		}
           		}
             
           if (tablero[0][0].equals(tablero[1][1]) && tablero[1][1].equals(tablero[2][2]) && !tablero[0][0].equals(" ")) {
               hayGanador = true;  
           }
           if (tablero[0][2].equals(tablero[1][1]) && tablero[1][1].equals(tablero[2][0]) && !tablero[0][2].equals(" ")) {
               hayGanador = true;  
           		}
	        
           
           if (hayGanador) {
               
               System.out.println("\nTablero Final:");
               for (int i = 0; i < 3; i++) {
                   for (int j = 0; j < 3; j++) {
                       System.out.print("[" + tablero[i][j] + "] ");  
                   }
                   System.out.println();
               }
               System.out.println("\n¡" + turno + " ha ganado!");  
               juegoTerminado = true;  
           } else {
              
               boolean empate = true;
             
               for (int i = 0; i < 3; i++) {
                   for (int j = 0; j < 3; j++) {
                       if (tablero[i][j].equals(" ")) {
                           empate = false;  
                           break;
                       }
                   }
               }
	        
               if (empate) {
                  
                   System.out.println("\nTablero Final:");
                   for (int i = 0; i < 3; i++) {
                       for (int j = 0; j < 3; j++) {
                           System.out.print("[" + tablero[i][j] + "] ");  
                       }
                       System.out.println();
                   }
                   System.out.println("\n¡Es un empate!");  
                   juegoTerminado = true; 
               } else {
                   
                   turno = turno.equals(jugador1) ? jugador2 : jugador1;
               }
           }
       }
	        
           }	
	}

}
