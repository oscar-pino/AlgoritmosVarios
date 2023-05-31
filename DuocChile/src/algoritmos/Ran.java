package algoritmos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ran {

	private static Scanner in = new Scanner(System.in);
	private int og, oe;
	private String rta;
	private int n1, n2, rdo;

	public static void main(String[] args) {

		Ran r = new Ran();
		Random rd = new Random();
		String temp;
		System.out.println();
		
		Scanner ent = new Scanner(System.in);
		
		System.out.print("este es el nombre capturado: ");
		temp = ent.nextLine();
		
		System.out.println("el valor capturado es: "+temp);
	
		
	}
	
	public static float[][] aleatorio(){
		
		Random rd = new Random();
		float[][] x = new float[4][7];
		int n = 0;
		System.out.println();
		for(int i=0;i<x.length;i++) {
			
			for(int j=0;j<x[0].length;j++) {
				
				n = rd.nextInt(100);
				
				x[i][j] = n * (n/100f);
				
			}
			
		}
		return x;
	}
	
	public boolean isNum(String x) {
		
		try {
			Float.parseFloat(x);
			return true;			
			
		}catch(Exception e) {
			
			return false;
		}
	}
	
	public void mensaje(String tipo) {
		
		switch(tipo) {
		
		case "numero":
			System.out.print("\ningrese nuevo numero: ");
			break;
		case "dos":
			System.out.print("\nno debe ingresar dos\n");
			break;
		case "tres":
			System.out.print("\nno debe ingresar tres\n");
			break;
		}
	}
	
	public Number validando(String valor, String tipo) {
		
		String pido = valor;	
		Number n = null;
			
			while(!isNum(pido)) {
				
				mensaje("numero");
				pido = in.next();
				
			}
			
			if(pido.contains("."))
				n = Float.parseFloat(pido);			
			else
				n = Integer.parseInt(pido);
					
			
			return n;		
	}
	
	public Number validando(String valor, Number inicio, Number fin, String tipo) {
		
		String recupero = valor;
		Number retorno = null;
		Number a;
		Number z;
		
		if(inicio != null && fin != null) {
			
			do {
				
				retorno = validando(recupero, tipo);
				
				if(inicio instanceof Float) {
					a = (float)inicio;
					z = (float)fin;
				}else {
					
					a = (int)inicio;
					z = (int)fin;
				}
				
				if((float)retorno < (float)a || (float)retorno > (float)z) {
					
					System.out.println("debe ingresar un rango valido ["+a+"-"+z+"]");
					
				}
				
			}while((float)retorno < (float)inicio || (float)retorno > (float)fin);
			
		}
		
		return retorno;
	}
	
	public static void miLlenado() {
		
		int longitud  = 30;
		int[] indices =  new int[longitud];
		int[] arreglo =  new int[longitud];
		Random rd = new Random();
		int j, c = 0, n;		
		
		
		for(int i = 0; i<longitud;i++)
			indices[i] = i;
		
		System.out.println("indices: ");
		for(int i : indices)
			System.out.print("["+i+"]");
		
		do {
			
			n = rd.nextInt(longitud);		
			
			for(j=0;j<c;j++) {
				
				 if (arreglo[j] == n) // evitando repetir números en arreglo generado
                     break;
			}
			
			 if (j == c)   
                 arreglo[c++] = n;
               
			
		}while(c < longitud);
		
		System.out.println("\ngenerados: ");
		for(int k : arreglo)
			System.out.print("["+k+"]");
		
		System.out.println("\n\nordenados: ");
		Arrays.sort(arreglo);
		for(int l : arreglo)
			System.out.print("["+l+"]");
		
		System.out.println("\n\ndesordenados: ");
		Arrays.sort(arreglo);
		for(int l = arreglo.length; l>-1; l--)
			System.out.print("["+l+"]");
		
	}
	
	public static String chars(int longitud) {
		
		String x = "";
		
		for(int i=0;i<longitud;i++)
			x += "*";
		
		return x.trim();
	}

	public static void main2(String[] args) {

		System.out.println();
		// Ran.ruleta();
		String tipo = "valor 1";
		if (CharSequence.compare("valor 1", tipo) == 0)
			System.out.println("son iguales");

		/*
		 * byte[] valores =
		 * {111,115,99,97,114,32,112,105,110,111,32,98,101,108,108,111}; //
		 * "oscar pino bello"
		 * 
		 * ArrayList<Byte> datos = new ArrayList<Byte>();
		 * 
		 * String nombre = new String(valores,0,valores.length-1);
		 * 
		 * System.out.println(nombre);
		 */

		/*
		 * Charset ch = Charset.defaultCharset();
		 * System.out.println("\ncaracteres validos: "+ch.displayName());
		 * 
		 * Run r = new Run();
		 * 
		 * System.out.print("\ningrese nota: "); String x = in.next(); float y =
		 * r.verificarValor(x, 1f, 5f, "valor");
		 * 
		 * System.out.println("el valor saliente es = "+y);
		 */
	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * Ran r = new Ran();
	 * 
	 * do { System.out.
	 * println("\n*************\n1 g1\n2 g2\n3 g3\n4 g4\n5 salir\n*************");
	 * 
	 * System.out.print("\ningrese opcion guia: "); r.og = in.nextInt();
	 * 
	 * if (r.og != 5) {
	 * 
	 * do {
	 * 
	 * r.mostrarMenu(r.og);
	 * 
	 * System.out.print("ingrese opcion ejercicio: "); r.oe = in.nextInt();
	 * 
	 * if (r.oe != r.getSalir(r.og)) {
	 * 
	 * do {
	 * 
	 * switch (r.og) {
	 * 
	 * case 1: // guia 1 switch (r.oe) {
	 * 
	 * case 1: System.out.print("\ningrese n1: "); r.n1 = in.nextInt();
	 * System.out.print("ingrese n2: "); r.n2 = in.nextInt(); r.g1e1(r.n1, r.n2);
	 * break; case 2: r.g1e2(); break; case 3: r.g1e3(); break; case 4:
	 * System.out.print("\nDesea seguir en la guia 1: "); r.rta = in.next();
	 * 
	 * if (r.rta.equalsIgnoreCase("n")) break; else r.oe = 0; break; } break; case
	 * 2: // guia 2 switch (r.oe) {
	 * 
	 * case 1: System.out.print("\ningrese n1: "); r.n1 = in.nextInt();
	 * System.out.print("ingrese n2: "); r.n2 = in.nextInt(); r.g2e1(r.n1, r.n2);
	 * break; case 2: break; case 3: break; case 4: break; case 5:
	 * System.out.print("\nDesea seguir en la guia 2: "); r.rta = in.next();
	 * 
	 * if (r.rta.equalsIgnoreCase("n")) break; else r.oe = 0; break; } break; case
	 * 3: // guia 3 switch (r.oe) {
	 * 
	 * case 1: System.out.print("\ningrese n1: "); r.n1 = in.nextInt();
	 * System.out.print("ingrese n2: "); r.n2 = in.nextInt(); r.g3e1(r.n1, r.n2);
	 * break; case 2: break; case 3: break; case 4: break; case 5: break; case 6:
	 * System.out.print("\nDesea seguir en la guia 3: "); r.rta = in.next();
	 * 
	 * if (r.rta.equalsIgnoreCase("n")) break; else r.oe = 0; break; } break; case
	 * 4: // guia 4 switch (r.oe) {
	 * 
	 * case 1: System.out.print("\ningrese n1: "); r.n1 = in.nextInt();
	 * System.out.print("ingrese n2: "); r.n2 = in.nextInt(); r.g4e1(r.n1, r.n2);
	 * break; case 2: break; case 3: break; case 4: break; case 5: break; case 6:
	 * break; case 7: System.out.print("\nDesea seguir en la guia 4: "); r.rta =
	 * in.next();
	 * 
	 * if (r.rta.equalsIgnoreCase("n")) break; else r.oe = 0; break; } break;
	 * 
	 * } // fin switch
	 * 
	 * System.out.print("\ndeseas probar otros valores? (s|n): "); r.rta =
	 * in.next();
	 * 
	 * if (r.rta.equalsIgnoreCase("n")) break;
	 * 
	 * } while (r.rta.equalsIgnoreCase("s"));
	 * 
	 * // r.oe = 0;
	 * 
	 * } else {
	 * 
	 * System.out.print("\nde verdad quieres salir de la guia: " + r.og +
	 * "? (s|n): "); r.rta = in.next();
	 * 
	 * if (r.rta.equalsIgnoreCase("s")) break; else r.oe = 0; } } while (r.oe !=
	 * r.getSalir(r.og));
	 * 
	 * } else {
	 * 
	 * System.out.print("\nde verdad quieres salir? "); r.rta = in.next();
	 * 
	 * if (r.rta.equalsIgnoreCase("s")) break; else r.og = 0; }
	 * 
	 * } while (r.og != 5);
	 * System.out.println("\nGracias por elegir a oscar pino 2023"); }
	 */

	public void g1() {

		System.out.println("elegiste la guia 1");
	}

	public void g1e1(int n1, int n2) {

		rdo = n1 + n2;
		System.out.println("g1 e1 => la suma de " + n1 + " + " + n2 + " = " + rdo);
	}

	public void g1e2() {

		System.out.println("g1 e2");
	}

	public void g1e3() {

		System.out.println("g1 e3");
	}

	public void g2() {

		System.out.println("elegiste la guia 2");
	}

	public void g2e1(int n1, int n2) {

		rdo = n1 - n2;
		System.out.println("g2 e1 => la resta de " + n1 + " - " + n2 + " = " + rdo);
	}

	public void g2e2() {

		System.out.println("g2 e2");
	}

	public void g2e3() {

		System.out.println("g2 e3");
	}

	public void g2e4() {

		System.out.println("g2 e4");
	}

	public void g3() {

		System.out.println("elegiste la guia 3");
	}

	public void g3e1(int n1, int n2) {

		rdo = n1 * n2;
		System.out.println("g3 e1 => la multiplicacion de " + n1 + " * " + n2 + " = " + rdo);
	}

	public void g3e2() {

		System.out.println("g3 e2");
	}

	public void g3e3() {

		System.out.println("g3 e3");
	}

	public void g3e4() {

		System.out.println("g3 e4");
	}

	public void g3e5() {

		System.out.println("g3 e5");
	}

	public void g4() {

		System.out.println("elegiste la g4");
	}

	public void g4e1(int n1, int n2) {

		rdo = n1 / n2;
		System.out.println("g4 e1 => la division de " + n1 + " / " + n2 + " = " + rdo);
	}

	public void g4e2() {

		System.out.println("g4 e2");
	}

	public void g4e3() {

		System.out.println("g4 e3");
	}

	public void g4e4() {

		System.out.println("g4 e4");
	}

	public void g4e5() {

		System.out.println("g4 e5");
	}

	public void g4e6() {

		System.out.println("g4 e6");
	}

	public void mostrarMenu(int guia) {

		String menu = null;

		switch (guia) {

		case 1:
			menu = "\n**********\nGuia1\n\n1. g1e1\n2. g1e2\n3. g1e3\n4. salir\n**********\n";
			break;
		case 2:
			menu = "\n**********\nGuia2\n\n1. g2e1\n2. g2e2\n3. g2e3\n4. g2e4\n5. salir\n**********\n";
			break;
		case 3:
			menu = "\n**********\nGuia3\n\n1. g3e1\n2. g3e2\n3. g3e3\n4. g3e4\n5. g3e5\n6. salir\n**********\n";
			break;
		case 4:
			menu = "\n**********\nGuia4\n\n1. g4e1\n2. g4e2\n3. g4e3\n4. g4e4\n5. g4e5\n6. g4e6\n7. salir\n**********\n";
			break;
		}
		System.out.println(menu);
	}

	public int getSalir(int guia) {

		int r = 0;

		switch (guia) {

		case 1:
			r = 4;
			break;
		case 2:
			r = 5;
			break;
		case 3:
			r = 6;
			break;
		case 4:
			r = 7;
			break;
		}
		return r;
	}

	public static void ruleta() {
		// codigo bueno
		boolean continuar = true;
		int intento = 0;

		while (continuar) {

			intento++;
			int limite = 30;
			int indice = 0;
			int valorEnIndice = 0;

			System.out.println("#################################################################################");

			System.out.println(" Intento " + intento);
			Scanner in = new Scanner(System.in);
			System.out.print(" Ingrese Indice: ");
			indice = Integer.parseInt(in.nextLine());

			//System.out.print(" Ingrese valor del indice: ");
			//valorEnIndice = Integer.parseInt(in.nextLine());

			System.out.println("------------------------------------------------");
			System.out.println("Indice ingresado: " + indice);
			//System.out.println(" Valor asociado al indice :" + valorEnIndice);

			int arreglo[] = new int[limite];

			Random rand = new Random();

			int contador = 0;
			System.out.println("\nIndices");

			for (int j = 0; j < limite; j++) {
				arreglo[j] = j;
				System.out.print("[" + (j) + "]" + " ");
			}

			do {

				int i, n = rand.nextInt(limite);

				for (i = 0; i < contador; i++) {
					
					if (arreglo[i] == n) // quitando valores repetidos
						break;
				}

				if (i == contador) // los indices no seran iguales al arreglo llenado en el mismo indice
					arreglo[contador++] = n;

			} while (contador < limite);
			
			System.out.println("\n\nValores");

			for (int n : arreglo) {
				System.out.print("[" + (n) + "]" + " ");
			}
			
			System.out.print(" \n\nIngrese valor del indice: ");
			valorEnIndice = Integer.parseInt(in.nextLine());
			
			System.out.println("Valor asociado al indice :" + valorEnIndice);
			System.out.println("");

			if (arreglo[indice] == valorEnIndice) {

				System.out.println("Indice " + indice + " corresponde al valor " + arreglo[indice]);
				System.out.println("");
				System.out.println("  ######      ###    ##    ##    ###     ######  ######## ######## ");
				System.out.println(" ##    ##    ## ##   ###   ##   ## ##   ##    ##    ##    ##       ");
				System.out.println(" ##         ##   ##  ####  ##  ##   ##  ##          ##    ##       ");
				System.out.println(" ##   #### ##     ## ## ## ## ##     ##  ######     ##    ######   ");
				System.out.println(" ##    ##  ######### ##  #### #########       ##    ##    ##       ");
				System.out.println(" ##    ##  ##     ## ##   ### ##     ## ##    ##    ##    ##       ");
				System.out.println("  ######   ##     ## ##    ## ##     ##  ######     ##    ######## ");
				System.out.println("");
				continuar = false;

			} else {
				
				System.out.println("Indice " + indice + " No correponde al valor " + arreglo[indice]);
				System.out.println("");
				System.out.println("	########  ######## ########  ########  ####  ######  ######## ######## ");
				System.out.println("	##     ## ##       ##     ## ##     ##  ##  ##    ##    ##    ##       ");
				System.out.println("	##     ## ##       ##     ## ##     ##  ##  ##          ##    ##       ");
				System.out.println("	########  ######   ########  ##     ##  ##   ######     ##    ######   ");
				System.out.println("	##        ##       ##   ##   ##     ##  ##        ##    ##    ##       ");
				System.out.println("	##        ##       ##    ##  ##     ##  ##  ##    ##    ##    ##       ");
				System.out.println("	##        ######## ##     ## ########  ####  ######     ##    ######## ");
				System.out.println("");
				System.out.print(" \nDeseas seguir jugando ?  S/N: ");
			}
			if ((in.nextLine()).equals("n")) {
				continuar = false;
				System.out.println("");
				System.out.println(" Juego finalizado ");
			}
		}

		System.out.println("#################################################################################");
	}
}
