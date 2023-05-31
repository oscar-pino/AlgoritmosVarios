package trabajo_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Run {

	static Scanner leer = new Scanner(System.in);
	static BufferedReader leerstring = new BufferedReader(new InputStreamReader(System.in));//
	static String nom, sexo;
	static int edad;
	static int cant;
	static int a[] = new int[cant];

	static int Menu() {
		int op;
		System.out.println("\n              M E NU     PARA\n\n..............................");
		System.out.println("1.- ingreso de datos ");
		System.out.println("2.- Saca promedio 3 notas ");
		System.out.println("3.- Ingresar arreglo");
		System.out.println("4.- mostrar arreglo");
		System.out.println("5.- ");
		System.out.println("6- ");
		System.out.println("7.- ");
		System.out.println("8.- ");
		System.out.println("9.- ");
		System.out.println("10.- FIN");
		System.out.println("..............................");
		System.out.print("\ningrese opcion: ");
		op = leer.nextInt();

		return op;
	}

	// aqui deben ir los otros metodos
	static void ingresodatos() throws IOException {
		System.out.println("Ingreso de datos");
		System.out.println("================");
		System.out.print("\nIngreso nombre completo: ");
		nom = leerstring.readLine();
		System.out.print("Ingreso su edad: ");
		edad = leer.nextInt();
		System.out.print("Ingreso su sexo m = masculino o f= femenino: ");
		sexo = leer.next();
		mostrarDatos();
	}

	static void promedios() {
		float n1, n2, n3, prom;
		System.out.println("calcula promedios de 3 notas\n");
		System.out.println("============================");
		
		do {
			System.out.print("Ingrese nota 1: ");
			n1 = leer.nextFloat();

				if (n1 < 1 || n1 > 7)
					 {
						System.out.println("\ndebe ingresar nota 1 dentro del rango [1-7]\n");
					}

		} while (n1 < 1 || n1 > 7);
		
		do {
			System.out.print("Ingrese nota 2: ");
			n2 = leer.nextFloat();

				if (n2 < 1 || n2 > 7)
					 {
						System.out.println("\ndebe ingresar nota 2 dentro del rango [1-7]\n");
					}

		} while (n2 < 1 || n2 > 7);
		
		do {
			System.out.print("Ingrese nota 3: ");
			n3 = leer.nextFloat();

				if (n3 < 1 || n3 > 7)
					 {
						System.out.println("\ndebe ingresar nota 3 dentro del rango [1-7]\n");
					}

		} while (n3 < 1 || n3 > 7);		

		 prom=(n1+n2+n3)/3; if(prom>=4){ System.out.printf("\nsu promedio es: %.2f\n",
		 prom); System.out.println("su situacion es Aprobado"); } else{
		 System.out.printf("\nsu promedio es: %.2f\n", prom);
		 System.out.println("su situacion es Reprobado"); }
		 
	}

	public static void arreglo() {

		int i;
		int num;
		
		System.out.print("Ingrese cantidad de datos para el arreglo: ");
		cant = leer.nextInt();
		a = new int[cant];
		System.out.println();
		for (i = 0; i < cant; i++) {
			System.out.print("Ingrese valor "+(i+1)+": ");
			num = leer.nextInt();
			a[i] = num;
		}
	}

	public static void mostrararreglo() {
		for (int i = 0; i < a.length; i++) {
			System.out.print("valor " + i + ": " + a[i]+", ");
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		/*
		int num = 0;
		Scanner in = new Scanner(System.in);
		String temp = null;
		
		do {
			System.out.print("\ningrese numero: ");
			temp = in.next();
			
			if(!isNum(temp))
				System.out.println("\ndebes ingresar numeros no letras");
			else {
				
				if(Integer.parseInt(temp) < 1 || Integer.parseInt(temp) > 7)
					System.out.println("\ndebes ingresar un numero dentro del rango [1-7]");
			}
			
		}while(!isNum(temp) || Integer.parseInt(temp) < 1 || Integer.parseInt(temp) > 7);
		*/
		int longitud = 30;
		int[] indices = new int[longitud];
		int[] arreglo = new int[longitud];
		Random rd = new Random();
		int temp = 0;
		
		for(int i=0;i<longitud;i++)
			indices[i] = (i+1);
		
		for(int c : indices)
			System.out.print("["+c+"] ");
		
		for(int i=0; i<longitud;i++) {
			
			do {
			
				temp = rd.nextInt(31-1);				
					
			}while(temp == indices[temp]);
			
			arreglo[i] = temp;
		}
		
		System.out.println("\n\nArreglo: ");
		for(int d : arreglo)
			System.out.print("["+d+"] ");
			
	}
	
	public static boolean isNum(String dat) {
		
		try {
			Float.parseFloat(dat);
			return true;
			
		}catch(Exception e){
			
			return false;
		}
		
	}

	public static void main2(String[] args) throws IOException {
		int opcion = 0;
		do {
			opcion = Menu();
			System.out.println();
			switch (opcion) {
			case 1: {
				ingresodatos();
				System.out.println();
				break;
			}
			case 2: {
				promedios();
				System.out.println();
				break;
			}
			case 3: {
				arreglo();
				System.out.println();
				break;
			}
			case 4: {
				if(a.length != 0)
				mostrararreglo();
				else
					System.out.println("\nel arreglo esta vacio!");
				System.out.println();
				break;
			}
			case 5: {
				;
				break;
			}
			case 6: {
				;
				break;
			}
			case 7: {
				;
				break;
			}
			case 8: {
				;
				break;
			}
			case 9: {
				;
				break;
			}
			case 10: {
				System.out.println("\n GRACIAS POR PREFERIRNOS");
				break;
			}
			default: {
				System.out.println("\n ERROR DE INGRESO [ de 1 hasta 10 ] ");
				break;
			}
			}
		} while (opcion != 10);
	}

	public static void mostrarDatos() {

		if (edad >= 18)
			System.out.println("\n" + nom + ", " + sexo + ", " + edad);
		else {
			if (sexo.equalsIgnoreCase("m"))
				System.out.println("\n" + nom + ", Masculino, " + edad);
			else
				System.out.println("\n" + nom + ", Femenino, " + edad);
		}
	}

}
