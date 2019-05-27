package udistrital.edu.Ciencias3.Pilas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		
		String opcion = "SI";
		Pila p = new Pila();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String op = "0";
		int valor;
		
		while (opcion.equals("SI")) {
			System.out.println("¿qué desea hacer?");
			System.out.println("1. agregar un elemento.");
			System.out.println("2. Sacar un elemento.");
			System.out.println("3. Mirar el tope.");
			System.out.println("4. buscar un elemento.");
			System.out.println("5. Mostrar el total de elementos.");
			System.out.println("6. Mostrar el promedio.");
			System.out.println("7. Salir.");
			op  = br.readLine();
			System.out.println(" ");
			
			switch (op){
				case "1":
					System.out.println("Ingrese el valor: ");
					valor = Integer.valueOf(br.readLine());
					p.push(valor);
				break;
				case "2":
					System.out.println("El valor sacado es: "+p.pop().getValor());
					
				break;
				case "3":
					System.out.println("El valor del tope es: "+p.tope());
				break;
				case "4":
					System.out.println("Ingrese el valor a buscar: ");
					valor = Integer.valueOf(br.readLine());
					System.out.println("El valor "+valor+" está "+p.buscar(valor)+" Veces");
				break;
				case "5":
					System.out.println("El total de elementos de la pila es: "+p.getTamano());
				break;
				case "6":
					System.out.println("El promedio total es: "+p.promedio());
				break;
				case "7":
					opcion = "No";
				break;
				
			}
			System.out.println("-----------------------------------------------------------------");
			
		}
	}

}
