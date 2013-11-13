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
	
	/*
	 * Adaptative Merge sort
	 */	
	public int[] adaptativeMergingSort(int[] lista)
	{
		 final int N = lista.length;
         if(N<=1) 
         	return lista;
		
		int superposicion=0;
        for(int i=0;i<lista.length-1;i++)
        {	
        	 if(lista[i]>lista[i+1])
        	 {
        		 superposicion=i;	
        	 }
        }
        System.out.println("superposicion: "+superposicion );
        
        int[] izq = Arrays.copyOfRange(lista, 0, superposicion);//Xizq
        int[] der = Arrays.copyOfRange(lista, superposicion, N);//Yder 
		mergingAdaptative(izq);
		mergingAdaptative(der);
		combinarAdaptative(lista, izq, der);
		return lista;
	}
	
    public int[] mergingAdaptative(int[] lista) {    	
        final int N = lista.length;
        if(N<=1) 
        	return lista;
        
        int mitad=N/2;
        	 
        int[] izq = Arrays.copyOfRange(lista, 0, mitad);//Xizq
        int[] der = Arrays.copyOfRange(lista, mitad, N);//Yder
        mergingAdaptative(izq);
        mergingAdaptative(der);
        combinarAdaptative(lista, izq, der);
    	return lista;
    }
    
    public int[] combinarAdaptative(int[] lista, int[] izq, int[] der) 
    {
        int i = 0;
        int j = 0;
        for(int k=0; k<lista.length;k++) {
            if(i>=izq.length) { lista[k]=der[j++]; continue; }
            if(j>=der.length) { lista[k]=izq[i++]; continue; }
            lista[k]=(izq[i]<der[j])?izq[i++]:der[j++];
        }
        return lista;
    }	
    
    /*
	 * Straight Insertion Sort
	 */	
    public int [] straightInsertionSort(int lista[])
	{
		int i=0;
		int t=0;
		final int N = lista.length;
        if(N<=1) 
        	return lista;
        
		for(int j=1;j<N;j++)
		{
			i=j-1;
			t=lista[j];
			while(t<lista[i])
			{
				lista[i+1]=lista[i]; 
				i=i-1; 
			}	
			lista[i+1]=t;
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
