package udistrital.edu.Ciencias3.Colas;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String correr = "Si";
		String opcion = "0";
		int opcion2 = 0;
		//Iteradores
		int it;	
		int[] tamanos = new int[3];
		Cola[] colas = new Cola[3];
		for (it = 0; it<3; it++) {
			colas[it] = new Cola();
		}
		
		//Atributo que representa al cliente actual que entra a hacer cola
		int cliente = 0;
							
		//arrays donde se guardaran los datos de la cola para mostrarlos "graficamente"
		ArrayList[] clientescolas = new ArrayList[3];
		for(it = 0; it<3; it++) {
			clientescolas[it] = new ArrayList<Integer>();
		}
		
		do {
			cliente++;
			System.out.println("Opciones para realizar:");
			System.out.println("1. Adicionar Cliente");
			System.out.println("2. Atender Cliente");			
			System.out.println("3. Terminar");
			
			System.out.println(" ");
			opcion = br.readLine();
			switch(opcion) {
			case "1":				
				//Para este caso los clientes se trataran como números, pues no tienen ninguna otra informacion relevante								
				for (it = 0; it<3; it++) {					
					tamanos[it] = colas[it].getTamano();
					System.out.println("tamano: "+ tamanos[it]);
				}
				int temp = DeterminarMenor(tamanos);	
				System.out.println("temp (menor): "+ temp);
				colas[temp].InsCola(cliente);
				clientescolas[temp].add(cliente);
				System.out.println("Se ha agregado el Cliente: "+cliente +" a la caja: " + (temp+1));
				
				//Visualización de como quedaron las cajas luego de la adición del cliente
				MostrarCaja(clientescolas);
				
			break;
			case "2":
				System.out.print("Elija el número de la caja que atendera: ");
				opcion2 = Integer.parseInt( br.readLine());	
				
				colas[opcion2-1].AtenderCola();
				if(!clientescolas[opcion2-1].isEmpty()) {
					clientescolas[opcion2-1].remove(0);	
					System.out.println("Se atendio con exito en la caja: "+ opcion2);
				}else {
					System.out.println("La caja que eligio esta vacia.");
				}									
				//Visualización de como quedaron las cajas luego de la adición del cliente
				MostrarCaja(clientescolas);
				
			break;
			case "3":
				System.out.println(";)");
				correr = "No";
			break;
			}	
			
		
		}while(correr.equals("Si"));
	}
	/**
	 * Función que retorna el menor de tres números
	 * @param valores
	 * @return el entero menor
	 */
	public static int DeterminarMenor(int[] valores) {
		if((valores[0] <= valores[1]) && (valores[0] <= valores[2])){
	        return 0;
	        }else{	        	
	            if((valores[1] <= valores[0]) && (valores[1] <= valores[2])){
	            return 1;
	            }else{
	            return 2;
	        }
	    }
	}
	public static void MostrarCaja(ArrayList[] arrayL) {
		for (int it = 0; it < 3; it++ ) {					
			System.out.println("Caja " + (it+1) + ": " + arrayL[it]);					
		}
	}
}
