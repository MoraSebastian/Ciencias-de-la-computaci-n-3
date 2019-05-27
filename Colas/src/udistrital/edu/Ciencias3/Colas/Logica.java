package udistrital.edu.Ciencias3.Colas;


public class Logica {	
	/**
	 * Attribute con las colas que se manejaran, la razón de utilizar array es por la facilidad que brinda para las diferentes 
	 * operaciones que se pueden hacer
	 */
	private Cola[] colas;
	/**
	 * Atributo que detalla el cliente actual que se insertara 
	 */
	private int cliente;
	
	/**
	 * Constructor
	 */
	public Logica() {
		cliente = 0;
		colas = new Cola[3];
		for (int i = 0; i < 3; i++) {
			colas[i] = new Cola();
			colas[i].setId(i+1);
		}
	}
	
	/**
	 * Método para agregar clientes nuevos a la cola de menor longitud
	 */
	
	public int AgregarCliente() {
	
		//Se aumenta el cliente

		cliente++;
		int i = 0;
		//Se ordenan las colas de menor a mayor 

		OrdenamientoSeleccion();

		//Se itera preguntando si la cola esta habilitada para resivir clientes
		while(!colas[i].getEstado()) {
			i++;			
		}
		colas[i].InsCola(cliente);
		return colas[i].getId();
	}
	
	/**
	 * Método para agregar clientes cuando estos vienen de una cola cerrada
	 * @param cliente, número del cliente que se esta insertando
	 */
	public int AgregarCliente(int cliente) {

		int i = 0;
		//Se ordenan las colas de menor a mayor 
		OrdenamientoSeleccion();
		//Se itera preguntando si la cola esta habilitada para resivir clientes
		while(!colas[i].getEstado()) {
			i++;
		}
		colas[i].InsCola(cliente);
		return colas[i].getId();
	}
	/**
	 * Método que se encarga de atender al cliente de la respectiva cola
	 * @param id, identificador de la cola que se esta atendiendo
	 * @return el nodo con la información que se atendio
	 */
	public Nodo AtenderCliente(int id) {
		int i = 0;
		while(colas[i].getId() != id) {
			i++;
		}
		return colas[i].AtenderCola();
	}
	/**
	 * Método que se encarga de cerrar la cola, inhabilitandola, y salvando sus clientes y redistribuyendolos en las otras colas
	 * Hay que tener en cuenta que cerrar no es lo mismo que eliminar(operación propia de la cola)
	 * @param id, identificador de la cola que se quiere cerrar
	 */
	public void CerrarCola(int id) {		
		int i = 1;
		//Se busca la cola que se cerrara con su id
		while(colas[i].getId() != id) {
			i++;
		}
		//Se cierra la cola
		colas[i].setEstado(false);		
		//Se salvan los nodos de la cola cerrada guardandolos en las otras colas
		int tamano = colas[i].getTamano();		
		for (int j = 0; j < tamano; j++) {
			AgregarCliente(colas[i].AtenderCola().getValor());
		}
	}
	public void AbrirCola(int id) {
		int i = 1;
		//Se busca la cola que se abrira con su id
		while(colas[i].getId() != id) {
			i++;
		}
		if(colas[i].getEstado()==false) {
			colas[i].setEstado(true);
		}
	}
	
	/**
	 * Método que se encarga de ordenar el array de las colas según su tamaño (número de clientes) de menor a mayor
	 */
	public void OrdenamientoSeleccion() {
		Cola temp;
		int  i, j;		
		for(i = 1; i < 3; i++) {
			j = i;
			temp = colas[j];			
			while((j > 0) && (colas[j-1].getTamano() > temp.getTamano())  ) {
				colas[j] = colas[j-1];
				j--;
			}
			colas[j] = temp;			
		}				
	}
}


