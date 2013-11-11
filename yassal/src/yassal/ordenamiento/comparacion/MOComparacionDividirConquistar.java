package yassal.ordenamiento.comparacion;

import java.util.Random;

public class MOComparacionDividirConquistar {

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
	/*
	 * Haciendo una variacion de merge es haciendo pares de elementos
	 */
	
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

	public void quickSort(int lista[]) {
		quickys(lista, 0, lista.length - 1);
	}

	private void quickys(int[] lista, int left, int right) {
		if (left < right) {
			int pivote = partition(lista, left, right);
			quickys(lista, left, pivote-1);
			quickys(lista, pivote + 1, right);
		}
	}

	private int partition(int[] lista, int left, int right) {
		int pivote = lista[right];
		int i=left-1;
		for (int j = left; j < right-1; j++) {
			if(lista[j]<=pivote){
				i++;
				swap(lista,i,j);
			}			
		}
		swap(lista,i+1,right);
		return i+1;
	}

	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
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
