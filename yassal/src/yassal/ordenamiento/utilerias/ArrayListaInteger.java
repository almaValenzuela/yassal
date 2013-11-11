package yassal.ordenamiento.utilerias;

import java.util.Random;

public class ArrayListaInteger {
	
	private ListaInteger lista=new ListaInteger();
		
	public ListaInteger getLista() {
		return lista;
	}

	public void setLista(ListaInteger lista) {
		this.lista = lista;
	}

	public void addNodo(Nodo nodo){
		Nodo lastNodo=lastNodo();
		if(lastNodo==null){
			nodo.setAnterior(lastNodo);
			lista.setNodo(nodo);
			lista.setLongitud(lista.getLongitud()+1);
		}else{
			nodo.setAnterior(lastNodo);
			lastNodo.setSiguiente(nodo);
			lista.setLongitud(lista.getLongitud()+1);
		}
	}
	
	public Nodo lastNodo(){
		if(lista.getLongitud()>0){
			Nodo ultimoNodo=lista.getNodo();
			while(ultimoNodo.getSiguiente()!=null){
				ultimoNodo=ultimoNodo.getSiguiente();
			}		
			return ultimoNodo;
		} else {
			return lista.getNodo();
		}
	}
	
	public ArrayListaInteger llenarArregloLista() {
		ArrayListaInteger lista=new ArrayListaInteger();
		
		Nodo nodo;
		Random valor=new Random();
		for (int i = 0; i < 5; i++) {
			nodo=new Nodo(valor.nextInt(1000),null,i); 
			lista.addNodo(nodo);
		}
		
//		Nodo elNodo=lista.getLista().getNodo();
//		for (int i = 0; i < lista.getLista().getLongitud(); i++) {	
//			System.out.println("Posicion "+i+")"+elNodo.getPosicion());
//			System.out.println("Elemento "+i+") "+elNodo.getElemento().longValue());
//			elNodo=elNodo.getSiguiente();
//		}
		
		return lista;
		
	}

}
