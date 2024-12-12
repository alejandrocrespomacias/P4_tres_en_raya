package P4_tres_en_raya;

import java.util.Scanner;
import java.util.Random;


public class P4_tres_en_raya {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner sc = new Scanner(System.in);
		 
		Random rand = new Random();
		 
		 
		//Tablero de 3x3 donde se guardarán las jugadas 
		String[][] tablero = new String[3][3];
		 
		//Nombre de los jugadores
		String jugador1, jugador2;
		
		//Turno acual del jugador
		String turno;
		
		
		
		System.out.print("Ingresa el nombre del Jugador 1: ");
	        jugador1 = sc.nextLine(); 
	        
	    System.out.print("Ingresa el nombre del Jugador 2: ");
	        jugador2 = sc.nextLine(); 
	        // Se lanza una "moneda" para decidir quién empieza
	        // Hago un random de 50/50 % con el bolean de jugador 1 y 2
	        turno = rand.nextBoolean() ? jugador1 : jugador2; 
	        
	        
	   System.out.println("La moneda se ha lanzado: " + turno + " empieza el juego.");  
	   
	   
	   // Bucle principal que continuará hasta que se decida no jugar más
	   boolean jugar = true;
       while (jugar) {
    	  //Tablero vacío con espacios   
           for (int i = 0; i < 3; i++) {
               for (int j = 0; j < 3; j++) {
                   tablero[i][j] = " ";  // Las csillas empizan vacias
               }
           }

           // Bucle para continuar el juego mientras no haya un ganador ni empate
           boolean juegoTerminado = false;
           while (!juegoTerminado) {
        	// Mostrar el tablero actual después de cada movimiento   
               System.out.println("\nTablero:");
               for (int i = 0; i < 3; i++) {
                   for (int j = 0; j < 3; j++) {
                       System.out.print("[" + tablero[i][j] + "] ");  // Mostrar estado actual de cada casilla
                   }
                   System.out.println();
               }
	        
            // Pedir el movimiento al jugador actual (fila y columna)
               int fila, columna;
               System.out.println(turno + ", es tu turno (escoge una casilla):");
               while (true) {
            	   // Pedir las coordenadas de la casilla (fila y columna)
                   System.out.print("Ingresa la fila (0-2): ");
                   fila = sc.nextInt();
                   System.out.print("Ingresa la columna (0-2): ");
                   columna = sc.nextInt();

                // Validar que la casilla elegida no esta ocupada
                   if (tablero[fila][columna].equals(" ")) {
                 // Poner la ficha del jugador en la casilla elegida      
                       tablero[fila][columna] = turno.equals(jugador1) ? "X" : "O";
                       break;  
                   } else {
                 //	Excepcion por si la casilla esta ocupada y saltre este mensaje de error
                       System.out.println("¡Esa casilla ya está ocupada! Intenta de nuevo.");
                   }
               }
	        
	        
           // Verificar si alguien ha ganado     
          boolean hayGanador = false;
          // Revisar las filas     
           for (int i = 0; i < 3; i++) { // Recorremos cada fila del tablero (hay 3 filas en total).
        	// Comprobamos si las tres casillas de la fila son iguales y que no estén vacías
               if (tablero[i][0].equals(tablero[i][1]) && tablero[i][1].equals(tablero[i][2]) && !tablero[i][0].equals(" ")) {
                   hayGanador = true;  // Si las tres casillas en la fila son iguales, hay un ganador
                   break;
               		}
           		}
               
           for (int j = 0; j < 3; j++) {
               if (tablero[0][j].equals(tablero[1][j]) && tablero[1][j].equals(tablero[2][j]) && !tablero[0][j].equals(" ")) {
                   hayGanador = true;  // Si las tres casillas en la columna son iguales, hay un ganador
                   break;
               		}
           		}
             
           if (tablero[0][0].equals(tablero[1][1]) && tablero[1][1].equals(tablero[2][2]) && !tablero[0][0].equals(" ")) {
               hayGanador = true;// Si las tres casillas de la diagonal izquierda son iguales y no están vacías, gana
           }
           if (tablero[0][2].equals(tablero[1][1]) && tablero[1][1].equals(tablero[2][0]) && !tablero[0][2].equals(" ")) {
               hayGanador = true;  // Si las tres casillas de la diagonal dercha son iguales y no están vacías,hay ganador
           		}
	        
           
           if (hayGanador) {
        	   // Mostrar el tablero al final	despues	de	un ganador
               System.out.println("\nTablero Final:");
               for (int i = 0; i < 3; i++) {
                   for (int j = 0; j < 3; j++) {
                       System.out.print("[" + tablero[i][j] + "] "); //  estado final del tablero 
                   }
                   System.out.println();
               }
               System.out.println("\n¡" + turno + " ha ganado!");  // Decir el ganador
               juegoTerminado = true;  
           } else {
        	// Verificar si hay empate
               boolean empate = true;
            // Revisar todas las casillas para ver si hay alguna vacía 
               for (int i = 0; i < 3; i++) {
                   for (int j = 0; j < 3; j++) {
                       if (tablero[i][j].equals(" ")) {
                           empate = false;  
                           break;
                       }
                   }
               }
	        
               if (empate) {
            	   // Si no hay más casillas vacías, el juego termina en empate  
                   System.out.println("\nTablero Final:");
                   for (int i = 0; i < 3; i++) {
                       for (int j = 0; j < 3; j++) {
                           System.out.print("[" + tablero[i][j] + "] "); // Mostrar el estado final del tablero 
                       }
                       System.out.println();
                   }
                   System.out.println("\n¡Es un empate!");  //Decir si es empate
                   juegoTerminado = true; 
               } else {
            	   // Si no hay ganador ni empate,	se cambiara	de turno al siguiente jugador 
                   turno = turno.equals(jugador1) ? jugador2 : jugador1;
               		}
           		}
           }
	        //Jugar otra vez 
           System.out.print("¿Quieren jugar otra vez? (sí/no): ");
           sc.nextLine();  
           String respuesta = sc.nextLine();  
           
           if (respuesta.equalsIgnoreCase("no")) {
               jugar = false;  //Si es no se termina el juego  😞
           				}
           		}	
		}

}
