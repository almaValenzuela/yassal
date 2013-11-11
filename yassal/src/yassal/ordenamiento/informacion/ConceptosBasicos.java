package yassal.ordenamiento.informacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConceptosBasicos {
	
	private String informacion;
	
	public String inicioPresentacion(){
		
		informacion="" +
				"La conveniencia de usar algorimos adaptativos es la diferencia en tiempo de la ejecución " +
				"\nde algoritmos nen relación a los algoritmos ya conocidos" +
				"\nAgregar elementos a una secuencia de datos ordenados requiere menor tiempo " +
				"\nque si lo agregas y después verificas si está es la posicion adecuada (busqueda) " +
				"\ny reordenar los datos." +
				"\nPero al no saber si la secuencia de información que tenemos está ordenada o no, " +
				"\nlo que requerimos son algoritmos que permitan verificar si la secuencia ya está ordenada o no, " +
				"\npara posteriormente agregar el elemento deseado";
	
		return informacion;
	}
	
	public String notacionesBasicas(){
		informacion="" +
				"\nLimite de ordenamiento (z)- Es el máximo número de comparaciones " +
				"\nque se pueden llevar a cabo totalmente" +
				"\nen una secuencia para que quede ordenada" +
				"\nSecuencia Casi Ordenada (nearly sorted) - " +
				"\nSecuencia que ha requerido pocas operaciones o" +
				"\no fue creada de un ordenamiento con pocas permutaciones.";
		
		return informacion;
	}
	
	public String conceptoOrdenamientoAdaptativo(){		
		informacion="" +
				"La estructura para el análisis de algoritmos adaptativos en el pero caso " +
				"\nconsiste en dos partes: " +
				"\n1) La introduccion del concepto de una medición de preordenamientos " +
				"\ncomo una función que evalua desórdenes " +
				"\n2) El concepto de una adaptación optimal de un algoritmo con respecto " +
				"\na una medición de preordenamiento. " +
				"\nUna medicion de desordenamientos (M) es la evaluación de una secuencia " +
				"\nen términos del número de comparaciones " +
				"\nque se hacen en una secuencia para que quede ordenada." +
				"\nUn algoritmo de ordenamiento puede ser optimalmente adaptativo " +
				"\ncon respecto a una medición de desordenamiento " +
				"\nsi esta toma un numero de comparaciones que esté en un factor constante por debajo del límite.";
		
		return informacion;		
	}
	
	public void unidadesDeMedicionDeDesorden(){
		
		BufferedReader tcl=new BufferedReader(new InputStreamReader(System.in));
		int opcion=-1;
		do{
		System.out.println("Unidades de Medición");
		System.out.println("[1] Inv(X)");
		System.out.println("[2] Dis(i,j)");
		System.out.println("[3] Max(Xi)");
		System.out.println("[4] Exc(Xi)");
		System.out.println("[5] Rem");
		System.out.println("[6] Runs(X), SUS(X), SMS(X)");
		System.out.println("[7] Enc");
		System.out.println("[8] Osc");
		System.out.println("[9] Reg");
		System.out.println("[0] Salir");
			try {
				opcion = Integer.parseInt(tcl.readLine());
				switch(opcion){
					case 1:
						System.out.println(medicionInv()+"\n");
						System.out.println("Por ejemplo, consideramos este caso.......");
					break;
					case 2:
						System.out.println(medicionDis()+"\n");
						System.out.println("Por ejemplo, consideramos este caso.......");
					break;
					case 3:
						System.out.println(medicionMax()+"\n");
						System.out.println("Por ejemplo, consideramos este caso.......");
					break;
					case 4:
						System.out.println(medicionExc()+"\n");
					break;
					case 5:
						System.out.println(medicionRem()+"\n");
					break;
					case 6:
						System.out.println(medicionRuns()+"\n");
						System.out.println(medicionSUS()+"\n");
						System.out.println(medicionSMS()+"\n");
						/*
						 * Wz = (6,5,8,7,10,9,12,11,4,3,2)
							has 
						Runs(Wz) = 7, whereas
						
						SUS(W, ) = II{(6, 8,10, 12),
										(5$7,9,11),
										(4), (3), (2)}11 = 5
						and
						SMS(WZ) = II{(6, 8,10, 12),
										(5,7,9,11),
									(4,3,2)}11 = 3.
						 */
					break;
					case 7:
						System.out.println(medicionEnc()+"\n");
					break;
					case 8:
						System.out.println(medicionOsc()+"\n");
					break;
					case 9:
						System.out.println(medicionReg()+"\n");
					break;
					case 0:break;
					default:System.out.println("opcion incorrecta"); 
				}
			} catch (IOException e) {
				System.out.println("opcion incorrecta");
			} catch (NumberFormatException e){
				System.out.println("opcion incorrecta");
			}
		}while(opcion!=0);
		
	}
	
	public String medicionInv(){
		informacion="" +
				"Medición de Desorden: Inv(X)"+
				"\nInv(X) - Numero de inversiones de una secuencia" +
				"\nX - Colección de elementos x1 a xn" +
				"\ninversion - Permutacion de (Xi,Xj) si (i<j) & (Xi > Xj)" +
				"\n<<Su valor disminuye solo cuando X está ordenado y " +
				"\ncuando su valor depende solo del relativo orden en los elementos en X.   ";
		
		return informacion;
	}
	
	public String medicionDis(){	
		
		informacion="" +
				"Medición de Desorden: Dis(,)" +
				"\nDefinido por la distancia más larga que pueden tener dos elementos \n" +
				"para determinar su inversión" +
				"\n   ";
		
		return informacion;
	}
	
	public String medicionMax(){
		
		informacion="" +
				"Medicion de Desorden: Max(Xi)" +
				"\nDefinido por la distancia maxima que requiere un elemento " +
				"\nde una colección de datos en llegar a su posición correcta";
		
		return informacion;
		
	}
	
	public String medicionExc(){
		
		informacion="" +
				"Medicion de Desorden: Exc(Xi)" +
				"\nDefinido por la mínima cantidad de intercambios (exchange) " +
				"\nque se requiere para que un elemento llegue a su posicion correcta";
		
		return informacion;
	}
	
	public String medicionRem(){
		
		informacion="" +
				"Medicion de Desorden: Rem(X)" +
				"\nDefinido por le minimo numero de elementos que se deben remover " +
				"\npara obtener una subsecuencia ordenada";
		
		return informacion;
	}
	
	public String medicionRuns(){
		
		informacion="" +
				"Medición de Desorden: Runs(X)" +
				"\nDefinido por el número de elemenots mayores situados a elementos menores" +
				"\nque deben recorrer escalones hacia abajo entre las ejeciciones";
		
		return informacion;
	}
	
	public String medicionSUS(){
		
		informacion="" +
				"Medición de Desorden: SUS(X)" +
				"\nDefinido por la minima cantidad de subsecuencias ascendentes en que " +
				"\nse particiona una secuencia." +
				"\nSus siglas son por Shuffled Up-Sequences";
		
		return informacion;
	}
	
	public String medicionSMS(){
		
		informacion="" +
				"Medición de Desorden: SMS(X)" +
				"\nDefinido por la cantidad minima de subsecuencias monotonas " +
				"\n(ascendentes o descendentes) en la que se puede particionar una secuencia" +
				"\nSus siglas son por Shuffled Monotone Subsequence";
		
		return informacion;
	}

	public String medicionEnc(){
		
		informacion="" +
				"Medición de Desorden: Enc(X)" +
				"\nDefinido por el numero de listas ordenadas construidas por MelSort* en un secuencia de datos ";
		return informacion;
	}
	
	public String medicionOsc(){
		
		informacion="" +
				"Medición de Desorden: Osc(X)" +
				"\nDefinido por las oscilaciones de los elementos grandes y pequeños dentro de una secuencia." +
				"\nEsta medición surge del estudio de HearpSort";
		
		return informacion;
	}
	
	public String medicionReg(){
		
		informacion="" +
				"Medicion de Desorden: Reg" +
				"\nEs la unidad de medida optimal de un algoritmo de ordenamiento " +
				"\noptimalmente adaptativo con respecto a las otras unidades de medida";
		
		return informacion;
		
	}
}









