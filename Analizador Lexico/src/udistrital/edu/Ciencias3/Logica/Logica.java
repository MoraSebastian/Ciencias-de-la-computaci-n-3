package udistrital.edu.Ciencias3.Logica;

public class Logica {
	public String Analizar(String expresiones) {
		char[] caracteres = expresiones.toCharArray();
		boolean isinteger = false;
		boolean isreal = false;
		boolean isID = false;		
		String resultado = "";
		for (int i = 0; i < caracteres.length; i++) {											
			if(Character.isLetter(caracteres[i]) || caracteres[i]=='_' || caracteres[i]=='&') {
				isinteger = false;
				isreal = false;
				isID = true;
			}
			if(isinteger == true && (caracteres[i] == '.' || caracteres[i] == ',')) {
				//System.out.println("se entra por aca?");
				isreal = true;
				isinteger = false;
				isID = false;
			}
			if (Character.isDigit(caracteres[i]) && isreal == true  ) {
				//System.out.println("y por aca?");
				isreal = true;
				isinteger = false;
				isID = false;
			}else if(Character.isDigit(caracteres[i])) {
				isID = false;
				isinteger = true;
				isreal = false;
			}
			
			if(caracteres[i] == ' ' || i == caracteres.length -1 ) {				
				if(isinteger == true && isreal == false && isID == false) {
					resultado += "NUM_ENT  ";
				}
				if(isreal == true && isinteger == false && isID == false) {
					resultado += "NUM_REAL  ";
				}
				if (isID == true && isreal == false && isinteger == false) {
					resultado += "ID  ";
				}
				isinteger = false;
				isreal = false; 
				isID = false;
			}			
		}		
		return resultado;
	}		
}
