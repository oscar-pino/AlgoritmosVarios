package algoritmos;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

			r.opcionGuia = 0;
			r.opcionEjercicio = 0;
			r.temp = "";

			do {

				r.mostrarMenu("guia");
				System.out.print("ingrese guia: ");
				r.temp = r.in.next();
				r.opcionGuia = r.esNumeroInt(r.temp);

				if (r.opcionGuia == Integer.MIN_VALUE || r.opcionGuia < 1 || r.opcionGuia > 5) {

					if (r.opcionGuia == Integer.MIN_VALUE)
						System.out.println("\n********************\ningrese solo numeros\n********************");
					else
						System.out.println(
								"\n****************************\ningrese opcion valida [1-5]!\n****************************");
				}

			} while (r.opcionGuia == Integer.MIN_VALUE || r.opcionGuia < 1 || r.opcionGuia > 5);

			if (r.opcionGuia == 5) {

				System.out.print("\n¿Quieres finalizar el programa? (s/n): ");
				r.temp = r.in.next();

				while (!(r.temp.equalsIgnoreCase("s") || r.temp.equalsIgnoreCase("n"))) {

					if (!(r.temp.equalsIgnoreCase("s") || r.temp.equalsIgnoreCase("n"))) {

						System.out.println(
								"\n***************************\ningrese opcion valida (s|n)\n***************************");
						System.out.print("\n¿Realmente quieres finalizar? (s/n): ");
						r.temp = r.in.next();
					}

				}

				if (r.temp.equalsIgnoreCase("s"))
					break;
				else
					r.opcionGuia = 0;

			} else if (r.opcionGuia != 5) { // aca empieza todo

				int fin = 0;

				switch (r.opcionGuia) {

				case 1:
					fin = 13;
					break;
				case 2:
					fin = 22;
					break;
				case 3:
					fin = 19;
					break;
				case 4:
					fin = 8;
					break;
				}
				// ingreso menu ejercicios

				do {
					do {
						r.mostrarMenu("ejercicio");
						System.out.print("ingrese ejercicio: ");
						r.temp = r.in.next();
						r.opcionEjercicio = r.esNumeroInt(r.temp);

						if (r.opcionEjercicio == Integer.MIN_VALUE)
							System.out.println("\n********************\ningrese solo numeros\n********************");
						else if (r.opcionEjercicio < 1 || r.opcionEjercicio > fin)
							System.out.println("\n****************************\ningrese opcion valida [1-" + fin
									+ "]!\n****************************");

					} while (r.opcionEjercicio == Integer.MIN_VALUE || r.opcionEjercicio < 1
							|| r.opcionEjercicio > fin);

					if (r.opcionEjercicio == fin) {

						System.out.print("\n¿Quieres volver al menu principal? (s/n): ");
						r.temp = r.in.next();

						while (!r.temp.equalsIgnoreCase("s") && !r.temp.equalsIgnoreCase("n")) {

							if (!r.temp.equalsIgnoreCase("s") && !r.temp.equalsIgnoreCase("n")) {

								System.out.println(
										"\n***************************\ningrese opcion valida (s|n)\n***************************");
								System.out.print("\n¿Realmente quiere volver al menu principal? (s/n): ");
								r.temp = r.in.next();
							}

						}

						if (r.temp.equalsIgnoreCase("s"))
							break;
						else
							r.opcionEjercicio = 0;
					} else {
						// inicio de algorimos
						System.out.println();

						float n1;
						float n2;
						float n3;
						float radio;
						float base;
						float altura;
						float monedaOrigen;
						float monedaCambiada;
						float[] resultados;

						switch (r.opcionGuia) {

						case 1:
							switch (r.opcionEjercicio) {

							case 1:

								do {

									do {
										System.out.print("ingrese n1: ");
										r.temp = r.in.next();
										n1 = r.esNumeroFloat(r.temp);
										if (n1 == Float.MIN_VALUE)
											System.out.println(
													"\n********************\ningrese solo numeros\n********************\n");
									} while (n1 == Float.MIN_VALUE);

									do {
										System.out.print("ingrese n2: ");
										r.temp = r.in.next();
										n2 = r.esNumeroFloat(r.temp);
										if (n2 == Float.MIN_VALUE)
											System.out.println(
													"\n********************\ningrese solo numeros\n********************\n");
									} while (n2 == Float.MIN_VALUE);

									System.out.printf("\n《 %.2f + %.2f = %.2f 》\n", n1, n2, g1.g1e1(n1, n2));

									do {

										System.out.print("\n¿desea probar otros numeros? (s/n): ");
										r.temp = r.in.next();
										System.out.println();
										if (!r.temp.equalsIgnoreCase("s") && !r.temp.equalsIgnoreCase("n")) {

											System.out.println(
													"\n***************************\ningrese opcion valida (s|n)\n***************************");

										}

									} while (!r.temp.equalsIgnoreCase("s") && !r.temp.equalsIgnoreCase("n"));

									if (r.temp.equalsIgnoreCase("n"))
										break;

								} while (r.temp.equalsIgnoreCase("s"));

								break;
							case 2:
								radio = 0;

								do {

									do {
										System.out.print("ingrese radio: ");
										r.temp = r.in.next();
										radio = r.esNumeroFloat(r.temp);
										if (radio == Float.MIN_VALUE)
											System.out.println(
													"\n********************\ningrese solo numeros\n********************\n");
									} while (radio == Float.MIN_VALUE);

									System.out.printf("\n《 el area de una circunferencia de radio %.2f = %.2f 》\n",
											radio, g1.g1e2(radio));

									do {

										System.out.print("\n¿desea probar otros numeros? (s/n): ");
										r.temp = r.in.next();
										System.out.println();
										if (!r.temp.equalsIgnoreCase("s") && !r.temp.equalsIgnoreCase("n")) {

											System.out.println(
													"\n***************************\ningrese opcion valida (s|n)\n***************************");

										}

									} while (!r.temp.equalsIgnoreCase("s") && !r.temp.equalsIgnoreCase("n"));

									if (r.temp.equalsIgnoreCase("n"))
										break;

								} while (r.temp.equalsIgnoreCase("s"));
								break;
							case 3:

								do {

									do {
										System.out.print("ingrese n1: ");
										r.temp = r.in.next();
										n1 = r.esNumeroFloat(r.temp);
										if (n1 == Float.MIN_VALUE)
											System.out.println(
													"\n********************\ningrese solo numeros\n********************\n");
									} while (n1 == Float.MIN_VALUE);

									do {
										System.out.print("ingrese n2: ");
										r.temp = r.in.next();
										n2 = r.esNumeroFloat(r.temp);
										if (n2 == Float.MIN_VALUE)
											System.out.println(
													"\n********************\ningrese solo numeros\n********************\n");
									} while (n2 == Float.MIN_VALUE);

									resultados = g1.g1e3(n1, n2);

									System.out.printf("\n %.2f + %.2f = %.2f \n", n1, n2, resultados[0]);
									System.out.printf(" %.2f - %.2f = %.2f \n", n1, n2, resultados[1]);
									System.out.printf(" %.2f * %.2f = %.2f \n", n1, n2, resultados[2]);

									if (n2 != 0)
										System.out.printf(" %.2f / %.2f = %.2f \n", n1, n2, resultados[3]);
									else
										System.out.printf(" %.2f / %.2f = (error al dividir por cero!)\n", n1, n2);

									do {

										System.out.print("\n¿desea probar otros numeros? (s/n): ");
										r.temp = r.in.next();
										System.out.println();
										if (!r.temp.equalsIgnoreCase("s") && !r.temp.equalsIgnoreCase("n")) {

											System.out.println(
													"\n***************************\ningrese opcion valida (s|n)\n***************************");

										}

									} while (!r.temp.equalsIgnoreCase("s") && !r.temp.equalsIgnoreCase("n"));

									if (r.temp.equalsIgnoreCase("n"))
										break;

								} while (r.temp.equalsIgnoreCase("s"));

								break;
							case 4:
								float horasTrabajadas;
								do {
									do {
										System.out.print("ingrese horas trabajadas: ");
										r.temp = r.in.next();
										horasTrabajadas = r.esNumeroFloat(r.temp);
										if (horasTrabajadas == Float.MIN_VALUE)
											System.out.println(
													"\n********************\ningrese solo numeros\n********************\n");
									} while (horasTrabajadas == Float.MIN_VALUE);

									System.out.printf("\n《 el sueldo bruto de un empleado con %.2f horas trabajadas es = %.2f 》\n",
											horasTrabajadas, g1.g1e4(horasTrabajadas));

									do {

										System.out.print("\n¿desea probar otros numeros? (s/n): ");
										r.temp = r.in.next();
										System.out.println();
										if (!r.temp.equalsIgnoreCase("s") && !r.temp.equalsIgnoreCase("n")) {

											System.out.println(
													"\n***************************\ningrese opcion valida (s|n)\n***************************");

										}

									} while (!r.temp.equalsIgnoreCase("s") && !r.temp.equalsIgnoreCase("n"));

									if (r.temp.equalsIgnoreCase("n"))
										break;

								} while (r.temp.equalsIgnoreCase("s"));
								break;
							case 5:
								float gradosCelsius;
								do {
									do {
										System.out.print("ingrese cantidad de grados celsius a convertir: ");
										r.temp = r.in.next();
										gradosCelsius = r.esNumeroFloat(r.temp);
										if (gradosCelsius == Float.MIN_VALUE)
											System.out.println(
													"\n********************\ningrese solo numeros\n********************\n");
									} while (gradosCelsius == Float.MIN_VALUE);

									System.out.printf("\n《 %.2f grados celsius = %.2f grados fahrenheit 》\n",
											gradosCelsius, g1.g1e5(gradosCelsius));

									do {

										System.out.print("\n¿desea probar otros numeros? (s/n): ");
										r.temp = r.in.next();
										System.out.println();
										if (!r.temp.equalsIgnoreCase("s") && !r.temp.equalsIgnoreCase("n")) {

											System.out.println(
													"\n***************************\ningrese opcion valida (s|n)\n***************************");

										}

									} while (!r.temp.equalsIgnoreCase("s") && !r.temp.equalsIgnoreCase("n"));

									if (r.temp.equalsIgnoreCase("n"))
										break;

								} while (r.temp.equalsIgnoreCase("s"));
								break;
							case 6:						
								
								do {

									do {
										System.out.print("ingrese n1: ");
										r.temp = r.in.next();
										n1 = r.esNumeroFloat(r.temp);
										if (n1 == Float.MIN_VALUE)
											System.out.println(
													"\n********************\ningrese solo numeros\n********************\n");
									} while (n1 == Float.MIN_VALUE);

									do {
										System.out.print("ingrese n2: ");
										r.temp = r.in.next();
										n2 = r.esNumeroFloat(r.temp);
										if (n2 == Float.MIN_VALUE)
											System.out.println(
													"\n********************\ningrese solo numeros\n********************\n");
									} while (n2 == Float.MIN_VALUE);
									
									do {
										System.out.print("ingrese n3: ");
										r.temp = r.in.next();
										n3 = r.esNumeroFloat(r.temp);
										if (n3 == Float.MIN_VALUE)
											System.out.println(
													"\n********************\ningrese solo numeros\n********************\n");
									} while (n3 == Float.MIN_VALUE);
									
									resultados = g1.g1e6(n1, n2, n3);

									System.out.printf("\nsumando los 2 primeros numeros %.2f + %.2f = %.2f \n", n1, n2, resultados[0]);
									System.out.printf("multiplicando los ultimos 2 numeros  %.2f - %.2f = %.2f \n", n2, n3, resultados[1]);
									System.out.printf("division de operaciones anteriores %.2f * %.2f = %.2f \n", resultados[0], resultados[1], resultados[2]);

									do {

										System.out.print("\n¿desea probar otros numeros? (s/n): ");
										r.temp = r.in.next();
										System.out.println();
										if (!r.temp.equalsIgnoreCase("s") && !r.temp.equalsIgnoreCase("n")) {

											System.out.println(
													"\n***************************\ningrese opcion valida (s|n)\n***************************");

										}

									} while (!r.temp.equalsIgnoreCase("s") && !r.temp.equalsIgnoreCase("n"));

									if (r.temp.equalsIgnoreCase("n"))
										break;

								} while (r.temp.equalsIgnoreCase("s"));
								break;
							case 7:
								radio = 0;

								do {

									do {
										System.out.print("ingrese radio: ");
										r.temp = r.in.next();
										radio = r.esNumeroFloat(r.temp);
										if (radio == Float.MIN_VALUE)
											System.out.println(
													"\n********************\ningrese solo numeros\n********************\n");
									} while (radio == Float.MIN_VALUE);

									System.out.printf("\n《 el volumen y area de una esfera con radio %.2f => area: %.2f volumen: %.2f 》\n",
											radio, g1.g1e7(radio)[1], g1.g1e7(radio)[0]);

									do {

										System.out.print("\n¿desea probar otros numeros? (s/n): ");
										r.temp = r.in.next();
										System.out.println();
										if (!r.temp.equalsIgnoreCase("s") && !r.temp.equalsIgnoreCase("n")) {

											System.out.println(
													"\n***************************\ningrese opcion valida (s|n)\n***************************");

										}

									} while (!r.temp.equalsIgnoreCase("s") && !r.temp.equalsIgnoreCase("n"));

									if (r.temp.equalsIgnoreCase("n"))
										break;

								} while (r.temp.equalsIgnoreCase("s"));
								break;
							case 8:
								do {

									do {
										System.out.print("ingrese cantidad de dolares a convertir en pesos chilenos: ");
										r.temp = r.in.next();
										monedaOrigen = r.esNumeroFloat(r.temp);
										if (monedaOrigen == Float.MIN_VALUE)
											System.out.println(
													"\n********************\ningrese solo numeros\n********************\n");
									} while (monedaOrigen == Float.MIN_VALUE);
									
									monedaCambiada = g1.g1e8(monedaOrigen);
									
									System.out.printf("\n《 %.2f $US = %.2f $CL 》\n",
											monedaOrigen, monedaCambiada);

									do {

										System.out.print("\n¿desea probar otros numeros? (s/n): ");
										r.temp = r.in.next();
										System.out.println();
										if (!r.temp.equalsIgnoreCase("s") && !r.temp.equalsIgnoreCase("n")) {

											System.out.println(
													"\n***************************\ningrese opcion valida (s|n)\n***************************");

										}

									} while (!r.temp.equalsIgnoreCase("s") && !r.temp.equalsIgnoreCase("n"));

									if (r.temp.equalsIgnoreCase("n"))
										break;

								} while (r.temp.equalsIgnoreCase("s"));
								break;
							case 9:
								do {

									do {
										System.out.print("ingrese base: ");
										r.temp = r.in.next();
										base = r.esNumeroFloat(r.temp);
										if (base == Float.MIN_VALUE)
											System.out.println(
													"\n********************\ningrese solo numeros\n********************\n");
									} while (base == Float.MIN_VALUE);

									do {
										System.out.print("ingrese altura: ");
										r.temp = r.in.next();
										altura = r.esNumeroFloat(r.temp);
										if (altura == Float.MIN_VALUE)
											System.out.println(
													"\n********************\ningrese solo numeros\n********************\n");
									} while (altura == Float.MIN_VALUE);

									System.out.printf("\n《 el area de un triangulo con base: %.2f y altura: %.2f = %.2f 》\n",
											base, altura, g1.g1e9(base, altura));

									do {

										System.out.print("\n¿desea probar otros numeros? (s/n): ");
										r.temp = r.in.next();
										System.out.println();
										if (!r.temp.equalsIgnoreCase("s") && !r.temp.equalsIgnoreCase("n")) {

											System.out.println(
													"\n***************************\ningrese opcion valida (s|n)\n***************************");

										}

									} while (!r.temp.equalsIgnoreCase("s") && !r.temp.equalsIgnoreCase("n"));

									if (r.temp.equalsIgnoreCase("n"))
										break;

								} while (r.temp.equalsIgnoreCase("s"));
								break;
							case 10:
								break;
							case 11:
								break;
							case 12:
								break;
							}
							// final guia 1
							break;
						case 2:
							switch (r.opcionEjercicio) {

							case 1:
								break;
							case 2:
								break;
							case 3:
								break;
							case 4:
								break;
							case 5:
								break;
							case 6:
								break;
							case 7:
								break;
							case 8:
								break;
							case 9:
								break;
							case 10:
								break;
							case 11:
								break;
							case 12:
								break;
							case 13:
								break;
							case 14:
								break;
							case 15:
								break;
							case 16:
								break;
							case 17:
								break;
							case 18:
								break;
							case 19:
								break;
							case 20:
								break;
							case 21:
								break;
							}
							// final guia 2
							break;
						case 3:
							switch (r.opcionEjercicio) {

							case 1:
								break;
							case 2:
								break;
							case 3:
								break;
							case 4:
								break;
							case 5:
								break;
							case 6:
								break;
							case 7:
								break;
							case 8:
								break;
							case 9:
								break;
							case 10:
								break;
							case 11:
								break;
							case 12:
								break;
							case 13:
								break;
							case 14:
								break;
							case 15:
								break;
							case 16:
								break;
							case 17:
								break;
							case 18:
								break;
							}
							// final guia 3
							break;
						case 4:
							switch (r.opcionEjercicio) {

							case 1:
								break;
							case 2:
								break;
							case 3:
								break;
							case 4:
								break;
							case 5:
								break;
							case 6:
								break;
							case 7:
								break;
							}
							// final guia 4
							break;

						}
						// fin de algorimos

					}

				} while (r.opcionEjercicio != fin);

				// finalizo menu ejercicios
			}

		} while (r.opcionGuia != 5);

		r.in.close();

		System.out.println("\nGracias por preferir a Oscar Pino 2023");
		r.in.close();
	}

	public int esNumeroInt(String num) {

		int valor;

		try {

			valor = Integer.parseInt(num);

		} catch (Exception e) {

			valor = Integer.MIN_VALUE;
		}

		return valor;
	}

	public float esNumeroFloat(String num) {

		float valor;

		try {

			valor = Float.parseFloat(num);

		} catch (Exception e) {

			valor = Float.MIN_VALUE;
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
						+ "\n9. Ejercicio 9\n10. Ejercicio 10\n11. Ejercicio 11\n12. Ejercicio 12\n13. Salir\n----------------\n";
				break;
			case 2:
				salida = "\n----------------\n1. Ejercicio 1\n2. Ejercicio 2\n3. Ejercicio 3\n4. Ejercicio 4\n5. Ejercicio 5\n6. Ejercicio 6\n7. Ejercicio 7\n8. Ejercicio 8"
						+ "\n9. Ejercicio 9\n10. Ejercicio 10\n11. Ejercicio 11\n12. Ejercicio 12\n13. Ejercicio 13\n14. Ejercicio 14\n15. Ejercicio 15"
						+ "\n16. Ejercicio 16\n17. Ejercicio 17\n18. Ejercicio 18\n19. Ejercicio 19\n20. Ejercicio 20\n21. Ejercicio 21\n22. Salir\n----------------\n";
				break;
			case 3:
				salida = "\n----------------\n1. Ejercicio 1\n2. Ejercicio 2\n3. Ejercicio 3\n4. Ejercicio 4\n5. Ejercicio 5\n6. Ejercicio 6\n7. Ejercicio 7\n8. Ejercicio 8"
						+ "\n9. Ejercicio 9\n10. Ejercicio 10\n11. Ejercicio 11\n12. Ejercicio 12\n13. Ejercicio 13\n14. Ejercicio 14\n15. Ejercicio 15"
						+ "\n16. Ejercicio 16\n17. Ejercicio 17\n18. Ejercicio 18\n19. Salir\n----------------\n";
				break;
			case 4:
				salida = "\n----------------\n1. Ejercicio 1\n2. Ejercicio 2\n3. Ejercicio 3\n4. Ejercicio 4\n5. Ejercicio 5\n6. Ejercicio 6\n7. Ejercicio 7\n8. Salir\n----------------\n";
				break;
			}
		}
		System.out.println(salida);
	}

	public void capturarOpcion(String tipo) {

		int opcion = 0;

		if (tipo.equalsIgnoreCase("guia")) {

			while (opcion < 1 || opcion > 5 || opcion == Integer.MIN_VALUE) {

				if (opcion == Integer.MIN_VALUE) {

					System.out.println("\n********************\ningrese solo numeros\n********************\n");

				} else {

					System.out.println(
							"\n****************************\ningrese opcion valida [1-5]!\n****************************");
				}
				System.out.print("ingrese nueva opcion guia: ");
				temp = in.next();
				opcion = esNumeroInt(temp);
			}

			opcionGuia = opcion;

		} else if (tipo.equalsIgnoreCase("ejercicio")) {

			boolean[] op = new boolean[4];
			op[0] = opcionGuia == 1 && opcionEjercicio < 1 || opcionEjercicio > 13;
			op[1] = opcionGuia == 2 && opcionEjercicio < 1 || opcionEjercicio > 22;
			op[2] = opcionGuia == 3 && opcionEjercicio < 1 || opcionEjercicio > 19;
			op[3] = opcionGuia == 4 && opcionEjercicio < 1 || opcionEjercicio > 8;

			while (opcionEjercicio == -1 || !op[0] || !op[1] || !op[2] || !op[3]) {

				if (opcionEjercicio == Integer.MIN_VALUE) {
					System.out.println("\n********************\ningrese solo numeros\n********************");

				} else if (op[0]) {

					System.out.println(
							"\n*****************************\ningrese opcion valida [1-13]!\n*****************************");
				} else if (op[1]) {

					System.out.println(
							"\n*****************************\ningrese opcion valida [1-22]!\n*****************************");
				} else if (op[2]) {

					System.out.println(
							"\n*****************************\ningrese opcion valida [1-20]!\n*****************************");
				} else if (op[3]) {

					System.out.println(
							"\n****************************\ningrese opcion valida [1-8]!\n****************************");
				}

				mostrarMenu("ejercicio");
				System.out.print("ingrese nueva opcion ejercicio: ");
				temp = in.next();
				opcionEjercicio = esNumeroInt(temp);

			}

		}

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
