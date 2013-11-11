package yassal.ordenamiento.comparacion;

import yassal.ordenamiento.utilerias.ArrayListaInteger;
import yassal.ordenamiento.utilerias.Nodo;

public class MOComparacionSimple {
	
	public ArrayListaInteger insertSort(ArrayListaInteger lista){
//		int costoRunTime=0;
		int ubicaKey,comparacionesTrue,comparacionesFalse;
		Nodo nodoKey=lista.getLista().getNodo().getSiguiente();
		for(ubicaKey=1; ubicaKey<lista.getLista().getLongitud();ubicaKey++){
//			costoRunTime++;
			Nodo elementoComparar = lista.getLista().getNodo();
			comparacionesTrue=ubicaKey-1;
			comparacionesFalse=0;
//			costoRunTime++;
			Integer key=nodoKey.getElemento();
//			costoRunTime++;			
			while(comparacionesTrue>=0 && comparacionesFalse<nodoKey.getPosicion()){				
				if(elementoComparar.getElemento().longValue()>key.longValue()){
//					costoRunTime++;
//					Nodo nodoActual=new Nodo(nodoKey.getElemento(),null,nodoKey.getPosicion());					
					
					elementoComparar.setSiguiente(nodoKey.getSiguiente());
					elementoComparar.setPosicion(elementoComparar.getPosicion()+1);
					Nodo siguiente=nodoKey.getSiguiente();
					siguiente.setAnterior(elementoComparar);
					nodoKey.setSiguiente(elementoComparar);
					elementoComparar.setAnterior(nodoKey);
					Nodo anterior=elementoComparar.getAnterior();
					anterior.setSiguiente(nodoKey);
					nodoKey.setAnterior(anterior);
//					nodoActual.setSiguiente(elementoComparar);
//					elementoComparar.setElemento(nodoActual.getElemento());
//					elementoComparar.setPosicion(nodoActual.getPosicion());
//					elementoComparar.setSiguiente(nodoActual.getSiguiente());
//					costoRunTime++;
					comparacionesTrue--;
//					costoRunTime++;
				}else{
					elementoComparar=elementoComparar.getSiguiente();
					comparacionesFalse++;
				}
			}
//			if(nodoActual!=null){				
//				nodoKey.setSiguiente(nodoActual.getSiguiente());
//				nodoKey.setPosicion(elementoComparar.getPosicion());
//				elementoComparar.setElemento(nodoKey.getElemento());
//				elementoComparar.setPosicion(nodoKey.getPosicion());
//				elementoComparar.setSiguiente(nodoKey.getSiguiente());
//			}else{
			
				nodoKey=nodoKey.getSiguiente();				
//			}
//			costoRunTime++;
		}
//		System.out.println("Costo del argoritmo: "+costoRunTime);
		return lista;
	}
	
	public static void main(String[] args) {
		ArrayListaInteger array=new ArrayListaInteger();
		
		array=array.llenarArregloLista();
		
		MOComparacionSimple sort=new MOComparacionSimple();
		
		ArrayListaInteger arraySorted=sort.insertSort(array);
		
		Nodo elNodo=arraySorted.getLista().getNodo();
		for (int i = 0; i < arraySorted.getLista().getLongitud(); i++) {	
			System.out.println("Posicion "+i+")"+elNodo.getPosicion());
			System.out.println("Elemento "+i+") "+elNodo.getElemento().longValue());
			elNodo=elNodo.getSiguiente();
		}
	}

}
