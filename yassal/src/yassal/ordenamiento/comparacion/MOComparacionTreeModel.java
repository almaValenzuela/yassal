package yassal.ordenamiento.comparacion;

import java.util.Random;

public class MOComparacionTreeModel {
	
	public int[] heapSort(int [] lista){
		construirHeap(lista,lista.length-1);
		int hearpSize=lista.length-1;
		for (int i = hearpSize; i >0; i--) {
			exchange(lista, 0, i);
			hearpSize--;
			maxHearp(lista, hearpSize, 0);
		}
		return lista;
	}
	
	private void construirHeap(int[] lista,int longitud){		
		int heapSize=longitud;
		for (int i = heapSize/2; i >=0; i--) {
			maxHearp(lista,heapSize,i);
		}
	}
	
	private void maxHearp(int [] lista,int hearpSize, int posicion){
		int valorMayor=0;
		int left=2*posicion;
		int right=2*posicion+1;
		if(left<=hearpSize && lista[left]>lista[posicion]){
			valorMayor=left;
		}else{
			valorMayor=posicion;
		}
		if(right<=hearpSize && lista[right]>lista[valorMayor]){
			valorMayor=right;
		}
		if(valorMayor!=posicion){
			exchange(lista,posicion,valorMayor);
			maxHearp(lista, hearpSize,valorMayor);
		}		
	}
	
	private void exchange(int[] lista,int i,int j){
		int temporal=lista[i];
		lista[i]=lista[j];
		lista[j]=temporal;
	}
	
	public static void main(String[] args) {
		MOComparacionTreeModel orden = new MOComparacionTreeModel();
		Random r=new Random();
		int listita[] = new int[10];
		for (int i = 0; i < listita.length; i++) {
			listita[i]=r.nextInt(99);
			System.out.print(listita[i]+" ");
		}
		System.out.println();
		orden.heapSort(listita);
		for (int i = 0; i < listita.length; i++) {
			System.out.print(listita[i]+" ");
		}
	}
	/*
	public ArrayList<Integer> radixSort(ArrayList<Integer> lista){
		int conteo=0;
		int k=cantidadDigitos(lista);
		lista=ordenaRadix(lista,k,0,conteo);
		return lista;
	}
	
	 public static void radixxSort(int[] arr){
	        if(arr.length == 0)
	            return;
	        int[][] np = new int[arr.length][2];
	        int[] q = new int[0x100];
	        int i,j,k,l,f = 0;
	        for(k=0;k<4;k++){
	            for(i=0;i<(np.length-1);i++)
	                np[i][1] = i+1;
	            np[i][1] = -1;
	            for(i=0;i<q.length;i++)
	                q[i] = -1;
	            for(f=i=0;i<arr.length;i++){
	                j = ((0xFF<<(k<<3))&arr[i])>>(k<<3);
	                if(q[j] == -1)
	                    l = q[j] = f;
	                else{
	                    l = q[j];
	                    while(np[l][1] != -1)
	                        l = np[l][1];
	                    np[l][1] = f;
	                    l = np[l][1];
	                }
	                f = np[f][1];
	                np[l][0] = arr[i];
	                np[l][1] = -1;
	            }
	            for(l=q[i=j=0];i<0x100;i++)
	                for(l=q[i];l!=-1;l=np[l][1])
	                        arr[j++] = np[l][0];
	        }
		
	private ArrayList<Integer> ordenaRadix(ArrayList<Integer> lista,int k,int posDigit,int conteo){
		int conteoOrdenamientoDigito=0;
		int  lsd=0;
		Nodo radix[]=new Nodo[10];
		for(int i=0; i < lista.size();i++) {
			conteoOrdenamientoDigito++;
			if(posDigit>0){
				int v=0;
				long digit=lista.get(i).longValue();
				while(v<posDigit){
					conteoOrdenamientoDigito++;
					digit=digit/10;
					v++;
				}				
				lsd=(int) digit%10;
			}else{
				lsd=(int) lista.get(i)%10;
			}
			if(radix[lsd]==null){
				radix[lsd]=new Nodo();
				radix[lsd].getSiguiente().add(lista.get(i));
			}
			else{
				radix[lsd].getSiguiente().add(lista.get(i));
			}
		}
		System.out.println("Numero de veces para acomodar por digito posicion 10 a la "+conteo+": "+conteoOrdenamientoDigito);
		conteo++;
		int conteoAgregarLista=0;
		lista.clear();
		ArrayList<Integer> datos;
		for(int i=0;i<10;i++){
			conteoAgregarLista++;
			if(radix[i]!=null){
				datos=radix[i].getSiguiente();
				for (Integer nodo : datos) {
					conteoAgregarLista++;
					lista.add(nodo);
				}
			}
		}
		System.out.println("Numero de veces para regresar datos a la lista: "+conteoAgregarLista);
		k--;
		posDigit++;
		if(k>0){
			lista=ordenaRadix(lista,k,posDigit,conteo);
			radix=null;
		}
		return lista;
	}
	
	private int cantidadDigitos(ArrayList<Integer> lista){
		int conteo=0;
		int nDigit=0;
		int k=0;
		for (int i = 0; i < lista.size(); i++) {
			conteo++;
			long num=lista.get(i).longValue();
			do{
				num=num/10;
				nDigit++;
				conteo++;
			}while(num>0);
			conteo++;
			if(nDigit>k){
				k=nDigit;
			}
			nDigit=0;
		}
		System.out.println("Numero de veces que se ejecuto para saber la cantidad de digitos: "+conteo);
		System.out.println("Mas ..... ");
		return k;
	}
	
	// utilizar a[i]%b.lenght
	// utlizar merge para concatener las cadenas
	public ArrayList<Integer> bucketSort(ArrayList<Integer> lista){
		int conteo=0;
		int digitos=cantidadDigitos(lista);
		long mayor=numeroMayor(lista);	
		int conteoBuckets=0;
		long []limites=new long[digitos+1];
		long rango=mayor/(digitos+1);
		for(int k=digitos;k>=0;k--){
			conteoBuckets++;
			limites[k]=((rango+1)*(k+1));
		}
		System.out.println("Numero de ciclos para crear los buckets: "+conteoBuckets);
		System.out.println("Mas ..... ");
		Nodo buckets[]= new Nodo[digitos+1];		
		for (int j = 0; j < lista.size(); j++) {
			conteo++;
			int conteoElementosBucket=0;
			for (int i = 0; i < buckets.length; i++) {
				conteoElementosBucket++;
				if(lista.get(j).longValue()<=limites[i]){
					if(buckets[i]==null){
						buckets[i]=new Nodo();
						buckets[i].getSiguiente().add(lista.get(j));
					}else{
						buckets[i].getSiguiente().add(lista.get(j));
					}
					break;
				}
			}
			System.out.println("Numero de ciclos para introducir elementos en un bucket: "+conteoElementosBucket);
		}
		lista.clear();
		for (Nodo nodo : buckets) {
			conteo++;
			if(nodo!=null){
				ArrayList<Integer> nuevaLista=nodo.getSiguiente();
				MOComparacionSimple ordenar=new MOComparacionSimple();
				nuevaLista=ordenar.insertSort(nuevaLista);
				if(lista.isEmpty()){
					lista=nuevaLista;
				}else{
					for (Integer integer : nuevaLista) {
						conteo++;
						lista.add(integer);
					}
				}
			}			
		}
		System.out.println("Numero de veces que se ejecuto para ordenamiento bucket: "+conteo);
		return lista;
	}
	
	private long numeroMayor(ArrayList<Integer> lista){
		int conteoCiclosMayor=0;
		long mayor=lista.get(0).longValue();
		for (int i = 0; i < lista.size(); i++) {
			conteoCiclosMayor++;
			if(lista.get(i).longValue()>mayor){
				mayor=lista.get(i).longValue();
			}
		}
		System.out.println("Numero de ciclos para encontar el numero mayor: "+conteoCiclosMayor);
		System.out.println("Mas ..... ");
		return mayor;
	}
	/*
	 * public class BucketSort{
 
   public static void sort(int[] a, int maxVal) {
      int [] bucket=new int[maxVal+1];
 
      for (int i=0; i<bucket.length; i++) {
         bucket[i]=0;
      }
 
      for (int i=0; i<a.length; i++) {
         bucket[a[i]]++;
      }
 
      int outPos=0;
      for (int i=0; i<bucket.length; i++) {
         for (int j=0; j<bucket[i]; j++) {
            a[outPos++]=i;
         }
      }
   }
 
 
   public static void main(String[] args) {
      int maxVal=5;
      int [] data= {5,3,0,2,4,1,0,5,2,3,1,4}; 
 
      System.out.println("Before: " + Arrays.toString(data));
      sort(data,maxVal);
      System.out.println("After:  " + Arrays.toString(data));
   }
}
	 */
	
}
