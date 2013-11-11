package yassal.ordenamiento.comparacion;

import java.util.Random;

public class MOAdaptativo {
	
	/*
	 * Merge sort por pares
	 */
	
	public int[] mergeSort(int lista[]) {
		lista = dividir(lista);
		return lista;
	}

	private int[] dividir(int[] lista){
		int nlista = lista.length;
		if(nlista<2) return lista;
		int middle=nlista/2;
		int []left=new int[middle];
		int []right=new int[nlista-middle];
		for (int i = 0; i < middle; i++) {
			left[i]=lista[i];
		}
		int k=0;
		for (int i = middle; i < nlista; i++) {
			right[k]=lista[i];
			k++;
		}
		left=dividir(left);
		right=dividir(right);
		return combinar(left,right,lista);
	}
		
	private int [] combinar(int []left, int right[], int[] lista){
		int nleft=left.length;
		int nright=right.length;
		int l=0,r=0,li=0;
		while(l<nleft && r<nright){
			if(left[l]<=right[r]){
				lista[li]=left[l];
				l++;
			}
			else{
				lista[li]=right[r];
				r++;
			}
			li++;
		}
		while(l<nleft){
			lista[li]=left[l];
			l++;
			li++;
		}
		while(r<nright){
			lista[li]=right[r];
			r++;
			li++;
		}
		return lista;
	}
	
	public static void main(String[] args) {
		MOComparacionDividirConquistar orden = new MOComparacionDividirConquistar();
		Random r=new Random();
		int listita[] = new int[10];
		for (int i = 0; i < listita.length; i++) {
			listita[i]=r.nextInt(99);
			System.out.print(listita[i]+" ");
		}
		System.out.println();
		orden.mergeSort(listita);
		for (int i = 0; i < listita.length; i++) {
			System.out.print(listita[i]+" ");
		}
	}

}
