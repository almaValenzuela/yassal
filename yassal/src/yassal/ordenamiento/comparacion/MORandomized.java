package yassal.ordenamiento.comparacion;

import java.util.Random;

public class MORandomized {
	
	public int[] randomizedMergeSort(int lista[]) {
		lista = dividir(lista,0,lista.length-1);
		return lista;
	}

	private int[] dividir(int[] lista,int inicio,int fin){
		int nlista = lista.length;
		if(nlista<2) return lista;
		int division=randomDesicion(lista, inicio, fin);
		int []left=new int[division];
		int []right=new int[nlista-division];
		for (int i = 0; i < division; i++) {
			left[i]=lista[i];
		}
		int k=0;
		for (int i = division; i < nlista; i++) {
			right[k]=lista[i];
			k++;
		}
		left=dividir(left,0,left.length-1);
		right=dividir(right,0,right.length-1);
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
	
	private int randomDesicion(int lista[],int left,int right){
		Random r=new Random();
		return r.nextInt(right-left+1)+left;
	}
		
	public void randomizedQuickSort(int lista[]) {
		quickys(lista, 0, lista.length - 1);
	}

	private void quickys(int[] lista, int inicia, int termina) {
		int p=0;
		if (inicia < termina) {
			p = randomizedPartition(lista, inicia, termina);
			quickys(lista, inicia, p - 1);
			quickys(lista, p + 1, termina);
		}
	}

	private int randomizedPartition(int[]lista,int left,int right){
		//rnd.nextInt(HASTA-DESDE+1)+DESDE
		Random r=new Random();
		int ran=r.nextInt(right-left+1)+left;
		swap(lista, right, ran);
		return partition(lista, left, right);
	}
	
	private int partition(int[] lista, int left, int right) {
		int pivote = lista[right];
		int i=left-1;
		for (int j = left; j < right; j++) {
			if(lista[j]<=pivote){
				i++;	
//				swap(lista,i,j);
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
		MORandomized orden = new MORandomized();
		Random r=new Random();
		int listita[] = new int[10];
		for (int i = 0; i < listita.length; i++) {
			listita[i]=r.nextInt(99);
			//System.out.print(listita[i]+" ");
		}
		System.out.println();		
		orden.randomizedQuickSort(listita);
		System.out.println("ok");
//		for (int i = 0; i < listita.length; i++) {
//			System.out.print(listita[i]+" ");
//		}
	}

}
