package algoritmos;

import java.util.ArrayList;
import java.util.Scanner;

import entidad.Empleado;

public class Run {

	private Scanner in;
	private int opcionGuia;
	private int opcionEjercicio;
	private String temp;

	public static void main(String[] args) {

		Run r = new Run();
		Guia1 g1 = new Guia1();
		Guia2 g2 = new Guia2();
		Guia3 g3 = new Guia3();
		Guia4 g4 = new Guia4();
		r.in = new Scanner(System.in);
		r.temp = "";

		do {

			/*
			 * if (r.opcionGuia != 5) {
			 * 
			 * r.mostrarMenu("guia"); System.out.print("ingrese una opcion: "); temp =
			 * r.in.next();
			 * 
			 * if (r.obtenerOpcion(temp, "guias") == Integer.MIN_VALUE) {
			 * 
			 * while (r.obtenerOpcion(temp, "guias") == Integer.MIN_VALUE) {
			 * 
			 * r.mostrarMenu("guia"); System.out.print("ingrese nueva opcion: "); temp =
			 * r.in.next(); }
			 * 
			 * r.opcionGuia = r.obtenerOpcion(temp, "guias"); } }
			 */

			/*
			 * r.mostrarMenu("guia"); System.out.print("ingrese una opcion: "); temp =
			 * r.in.next(); System.out.println("sc: "+temp);
			 * 
			 * if (r.opcionGuia == 5) { System.out.print("Seguro quieres salir? (s/n)");
			 * temp = r.in.next();
			 * 
			 * if (temp.equalsIgnoreCase("n")) r.opcionGuia = 1; }
			 */

			r.mostrarMenu("guia");
			System.out.print("ingrese una opcion: ");
			r.temp = r.in.next();
			r.opcionGuia = r.esNumero(r.temp);

			while (r.opcionGuia == -1 || r.opcionGuia < 1 || r.opcionGuia > 5) {

				if(r.opcionGuia == -1) {
				System.out.println("\n********************\ningrese solo numeros\n********************");
				r.mostrarMenu("guia");
				System.out.print("ingrese nueva opcion: ");
				r.temp = r.in.next();
				r.opcionGuia = r.esNumero(r.temp);
				}
				else {
					
					System.out.println("\n**********************\ningrese opcion valida!\n**********************");
					r.mostrarMenu("guia");
					System.out.print("ingrese nueva opcion: ");
					r.temp = r.in.next();
					r.opcionGuia = r.esNumero(r.temp);
				}
			}
			
			if (r.opcionGuia == 5) {	
				
				System.out.print("\n¿Realmente quieres salir? (s/n): ");
				r.temp = r.in.next();
				
				while(!(r.temp.equalsIgnoreCase("s") || r.temp.equalsIgnoreCase("n"))) {							
						
						if(!(r.temp.equalsIgnoreCase("s") || r.temp.equalsIgnoreCase("n"))) {
						
							System.out.println("\n***************************\ningrese opcion valida (s|n)\n***************************");
							System.out.print("\n¿Realmente quieres salir? (s/n): ");
							r.temp = r.in.next();							
						}
						
					}
					
				if(r.temp.equalsIgnoreCase("s"))
					break;
				else
					r.opcionGuia = 0;
								
			}
			
			
		} while (r.opcionGuia != 5);

		r.in.close();

		System.out.println("\nGracias por preferir a Oscar Pino 2023");
		r.in.close();
	}

	public int esNumero(String num) {

		int valor;

		try {

			valor = Integer.parseInt(num);

		} catch (Exception e) {

			valor = -1;
		}

		return valor;
	}

	public void mostrarMenu(String tipo) {

		String salida = null;

		if (tipo.equalsIgnoreCase("guia")) {

			salida = "\n-----------\n1. Guia 1\n2. Guia 2\n3. Guia 3\n4. Guia 4\n5. Salir\n-----------\n";

		} else if (tipo.equalsIgnoreCase("ejercicio")) {

			switch (opcionGuia) {

			case 1:
				salida = "\n----------------\n1. Ejercicio 1\n2. Ejercicio 2\n3. Ejercicio 3\n4. Ejercicio 4\n5. Ejercicio 5\n6. Ejercicio 6\n7. Ejercicio 7\n8. Ejercicio 8"
						+ "\n9. Ejercicio 9\n10. Ejercicio 10\n11. Ejercicio 11\n12. Ejercicio 12\n13. Salir\n----------------";
				break;
			case 2:
				salida = "\n----------------\n1. Ejercicio 1\n2. Ejercicio 2\n3. Ejercicio 3\n4. Ejercicio 4\n5. Ejercicio 5\n6. Ejercicio 6\n7. Ejercicio 7\n8. Ejercicio 8"
						+ "\n9. Ejercicio 9\n10. Ejercicio 10\n11. Ejercicio 11\n12. Ejercicio 12\n13. Ejercicio 13\n14. Ejercicio 14\n15. Ejercicio 15"
						+ "\n16. Ejercicio 16\n17. Ejercicio 17\n18. Ejercicio 18\n19. Ejercicio 19\n20. Ejercicio 20\n21. Ejercicio 21\n22. Salir\n----------------";
				break;
			case 3:
				salida = "\n----------------\n1. Ejercicio 1\n2. Ejercicio 2\n3. Ejercicio 3\n4. Ejercicio 4\n5. Ejercicio 5\n6. Ejercicio 6\n7. Ejercicio 7\n8. Ejercicio 8"
						+ "\n9. Ejercicio 9\n10. Ejercicio 10\n11. Ejercicio 11\n12. Ejercicio 12\n13. Ejercicio 13\n14. Ejercicio 14\n15. Ejercicio 15"
						+ "\n16. Ejercicio 16\n17. Ejercicio 17\n18. Ejercicio 18\n19. Ejercicio 19\n20. Salir\n----------------";
				break;
			case 4:
				salida = "\n----------------\n1. Ejercicio 1\n2. Ejercicio 2\n3. Ejercicio 3\n4. Ejercicio 4\n5. Ejercicio 5\n6. Ejercicio 6\n7. Ejercicio 7\n8. Salir\n----------------";
				break;
			}
		}
		System.out.println(salida);
	}

	public void ordenandoMatriz() {

		Guia2 g2 = new Guia2();
		float[][] x = { { 1f, 2f, 3f }, { 1f, 3f, 2f }, { 2f, 1f, 3f }, { 2f, 3f, 1f }, { 3f, 1f, 2f },
				{ 3f, 2f, 1f } };

		float[] x1 = { 1f, 2f, 3f };
		float[] x2 = { 1f, 3f, 2f };
		float[] x3 = { 2f, 1f, 3f };
		float[] x4 = { 2f, 3f, 1f };
		float[] x5 = { 3f, 1f, 2f };
		float[] x6 = { 3f, 2f, 1f };

		System.out.println(g2.g2e19(x1)[0] + ", " + g2.g2e19(x1)[1] + ", " + g2.g2e19(x1)[2]);
		System.out.println(g2.g2e19(x2)[0] + ", " + g2.g2e19(x2)[1] + ", " + g2.g2e19(x2)[2]);
		System.out.println(g2.g2e19(x3)[0] + ", " + g2.g2e19(x3)[1] + ", " + g2.g2e19(x3)[2]);
		System.out.println(g2.g2e19(x4)[0] + ", " + g2.g2e19(x4)[1] + ", " + g2.g2e19(x4)[2]);
		System.out.println(g2.g2e19(x5)[0] + ", " + g2.g2e19(x5)[1] + ", " + g2.g2e19(x5)[2]);
		System.out.println(g2.g2e19(x6)[0] + ", " + g2.g2e19(x6)[1] + ", " + g2.g2e19(x6)[2]);
	}
}
