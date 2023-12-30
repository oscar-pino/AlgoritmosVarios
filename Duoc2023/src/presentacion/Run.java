package presentacion;

import java.util.ArrayList;
import java.util.Scanner;
import entidades.Empleado;
import entidades.OpcionesTipo;
import entidades.Persona;
import entidades.guias.Guia1;
import entidades.guias.Guia2;
import entidades.guias.Guia3;
import entidades.guias.Guia4;


/**
 * Run va a representar una serie de ejercicios basados en 4 guias distintas, cada ejercicio puede ser seleccionado
 * por el usuario mediante un menu de consola. Las guias de los ejercicios desarrollados en este proyecto se encuentran 
 * en el package (guias.pdf).
 * @author Oscar Pino 2023.
 */

public class Run {

	private int opcionGuia, opcionEjercicio, inicioMenu, finMenu, inicioEjercicio, finEjercicio;
	private String respuesta, temp;
	private boolean continuarJuego, continuarGuia, continuarEjercicio, resultadoCorrecto, menusActivos[];
	private float entradas[], resultados[];
	private float entradaUnica, resultadoUnico, rangoInicial, rangoFinal;
	private static Guia1 g1;
	private static Guia2 g2;
	private static Guia3 g3;
	private static Guia4 g4;
	private OpcionesTipo opcionMenu;
	private OpcionesTipo opcionVarios;
	private static Scanner in = new Scanner(System.in);	

	public static void main(String[] args) {

		Run r = new Run();
		g1 = new Guia1();
		g2 = new Guia2();
		g3 = new Guia3();
		g4 = new Guia4();

		r.continuarEjercicio = true;
		r.continuarGuia = true;
		r.continuarJuego = true;
		r.opcionGuia = 0;
		r.opcionEjercicio = 0;
		r.inicioMenu = 1;
		r.finMenu = 5;
		r.menusActivos = new boolean[2];

		do {

			if (r.opcionGuia == 5) {	
				
				if(r.menusActivos[0])
					r.menusActivos[0] = false;

				do {
					
					r.opcionVarios = OpcionesTipo.SALIR_APLICACION;
					r.validarRespuesta();

					if (r.respuesta.equalsIgnoreCase("s")) {
						r.continuarJuego = false;
						break;
					} else {
						r.opcionGuia = 0;

					}

				} while (r.temp.equals("s"));

				if (r.temp.equals("n"))
					break;

			} else if (r.opcionGuia > r.finMenu || r.opcionGuia < r.inicioMenu) {

				if (r.opcionGuia != 0) {

					System.out.print("\n*****************************\ningrese un valor valido [" + r.inicioMenu + "-"
							+ r.finMenu + "]\n*****************************\n");
				}

				else {
					r.continuarGuia = true;
					r.opcionEjercicio = 0;
					r.menusActivos[0] = true;
					r.opcionMenu = OpcionesTipo.OPCION_GUIA;
					r.solicitarOpcion(r.opcionMenu);
				}

			} else { // opcion guia correcta

				r.inicioEjercicio = r.inicioMenu;
				r.finEjercicio = r.obtenerFinalEjercicio();
				r.menusActivos[0] = false;

				do {

					 if (r.opcionEjercicio == r.finEjercicio) {					 
						
						if(r.menusActivos[1])
							r.menusActivos[1] = false;
						
						do {
							
							r.opcionVarios = OpcionesTipo.VOLVER_MENU_PRINCIPAL;
							r.validarRespuesta();
							
							if (r.respuesta.equalsIgnoreCase("s")) {
								r.continuarGuia = false;
								r.opcionGuia = 0;
								break;
							} else {
								r.opcionEjercicio = 0;
							}							
							
						} while (r.temp.equals("s"));						

					} else if (r.opcionEjercicio < r.inicioEjercicio || r.opcionEjercicio > r.finEjercicio) {
						
						if (r.opcionEjercicio != 0){
							
							System.out.print("\n*****************************\ningrese un valor valido [" + r.inicioEjercicio + "-"
									+ r.finEjercicio + "]\n*****************************\n");
							
						} else{
							r.menusActivos[1] = true;
							r.opcionMenu = OpcionesTipo.OPCION_EJERCICIO;
							r.solicitarOpcion(r.opcionMenu);
						}

					} else {

						int n1, n2, nr;

						while (r.continuarEjercicio) {
							// inicio switch
							switch (r.opcionGuia) {

							case 1: // guia 1

								switch (r.opcionEjercicio) {

								case 1:
									r.entradas = new float[2];
									r.resultados = new float[1];
									//r.tipoOpcion = "valor";
									System.out.print("\ningrese primer valor: ");
									r.temp = in.next();

									r.entradas[0] = r.verificarValor(r.temp);
									System.out.print("ingrese segundo valor: ");
									r.temp = in.next();
									r.entradas[1] = r.verificarValor(r.temp);
									r.resultadoUnico = g1.g1e1(r.entradas[0], r.entradas[1]);
									System.out.printf("\n《 %.2f + %.2f = %.2f 》\n", r.entradas[0], r.entradas[1],
											r.resultadoUnico);
									break;
								case 2:
									//r.tipoOpcion = "radio";
									r.rangoInicial = 0.1f;
									System.out.print("\ningrese radio de circunferencia (mt): ");
									r.temp = in.next();
									r.entradaUnica = r.verificarValor(r.temp, r.rangoInicial, null);
									r.resultadoUnico = g1.g1e2(r.entradaUnica);
									System.out.printf(
											"\n《 el area de una circunferencia de radio %.2f mt = %.2f mt\u00b2 》\n",
											r.entradaUnica, r.resultadoUnico);
									break;
								case 3:

									r.entradas = new float[2];
									System.out.print("\ningrese primer valor: ");
									r.temp = in.next();
									r.entradas[0] = r.verificarValor(r.temp);
									System.out.print("ingrese segundo valor: ");
									r.temp = in.next();
									r.entradas[1] = r.verificarValor(r.temp);
									r.resultados = g1.g1e3(r.entradas[0], r.entradas[1]);
									System.out.printf("\n《 la suma de %.2f + %.2f = %.2f 》\n", r.entradas[0],
											r.entradas[1], r.resultados[0]);
									System.out.printf("《 la resta de %.2f - %.2f = %.2f 》\n", r.entradas[0],
											r.entradas[1], r.resultados[1]);
									System.out.printf("《 la multiplicacion de %.2f * %.2f = %.2f 》\n", r.entradas[0],
											r.entradas[1], r.resultados[2]);
									System.out.printf("《 la division de %.2f / %.2f = %.2f 》\n", r.entradas[0],
											r.entradas[1], r.resultados[3]);

									break;
								case 4:
									//r.tipoOpcion = "horasTrabajadas";
									r.rangoInicial = 0;
									System.out.print("\ningrese horas trabajadas, durante el mes: ");
									r.temp = in.next();
									r.entradaUnica = r.verificarValor(r.temp, r.rangoInicial, null);
									r.resultadoUnico = g1.g1e4(r.entradaUnica);
									System.out.printf(
											"《 \nel sueldo bruto para un empleado con %.2f horas trabajadas es de %.2f pesos 》\n",
											r.entradaUnica, r.resultadoUnico);
									break;
								case 5:
									//r.tipoOpcion = "gradosCelsius";
									System.out.print("\ningrese cantidad de grados celsius a convertir: ");
									r.temp = in.next();
									r.entradaUnica = r.verificarValor(r.temp);
									r.resultadoUnico = g1.g1e5(r.entradaUnica);
									System.out.printf("《 \n%.2f grados celsius equivalen a %.2f grados fahrenheit 》\n",
											r.entradaUnica, r.resultadoUnico);

									break;
								case 6:
									r.entradas = new float[3];
									//r.tipoOpcion = "valor";
									System.out.print("\ningrese primer valor: ");
									r.temp = in.next();
									r.entradas[0] = r.verificarValor(r.temp);
									System.out.print("ingrese segundo valor: ");
									r.temp = in.next();
									r.entradas[1] = r.verificarValor(r.temp);
									System.out.print("ingrese tercer valor: ");
									r.temp = in.next();
									r.entradas[2] = r.verificarValor(r.temp);
									r.resultados = g1.g1e6(r.entradas[0], r.entradas[1], r.entradas[2]);
									System.out.printf(
											"\n---------------------------------------------------\n《 la suma de n1: %.2f + n2: %.2f = %.2f 》\n"
													+ "《 la multiplicacion de n2: %.2f * n3: %.2f = %.2f 》\n"
													+ "《 la division de (op1): %.2f / (op2): %.2f = %.2f 》\n---------------------------------------------------\n",
											r.entradas[0], r.entradas[1], r.resultados[0], r.entradas[1], r.entradas[2],
											r.resultados[1], r.resultados[0], r.resultados[1], r.resultados[2]);
									break;
								case 7:
									r.resultados = new float[2];
									//r.tipoOpcion = "radio";
									System.out.print("\ningrese radio (mt): ");
									r.temp = in.next();
									r.entradaUnica = r.verificarValor(r.temp);
									r.resultados = g1.g1e7(r.entradaUnica);
									System.out.printf(
											"\n《 una esfera con radio %.2f mt tiene como volumen: %.2f mt y un area: %.2f mt\u00b2 》\n",
											r.entradaUnica, r.resultados[0], r.resultados[1]);
									break;
								case 8:
									r.rangoInicial = 0.1f;
									//r.tipoOpcion = "dolares";
									System.out.print("\ningrese cantidad de dolares a convertir: ");
									r.temp = in.next();
									r.entradaUnica = r.verificarValor(r.temp, r.rangoInicial, null);
									r.resultadoUnico = g1.g1e8(r.entradaUnica);
									System.out.printf("\n《 %.2f dolares equivalen a %.2f $CL》\n", r.entradaUnica,
											r.resultadoUnico);
									break;
								case 9:
									r.entradas = new float[2];
									//r.tipoOpcion = "base";
									System.out.print("\ningrese base (mt): ");
									r.temp = in.next();
									r.entradas[0] = r.verificarValor(r.temp);
									//r.tipoOpcion = "altura";
									System.out.print("\ningrese altura (mt): ");
									r.temp = in.next();
									r.entradas[1] = r.verificarValor(r.temp);
									r.resultadoUnico = g1.g1e9(r.entradas[0], r.entradas[1]);
									System.out.printf(
											"\n《 el area de un triangulo con base %.2f y altura de %.2f = %.2f mt\u00b2 》\n",
											r.entradas[0], r.entradas[1], r.resultadoUnico);
									break;
								case 10:
									r.rangoInicial = 1f;
									r.rangoFinal = 7f;
									r.entradas = new float[4];
									//r.tipoOpcion = "nota";
									System.out.println();
									for (int i = 0; i < 4; i++) {

										System.out.print("ingrese nota " + (i + 1) + ": ");
										r.temp = in.next();
										r.entradas[i] = r.verificarValor(r.temp, r.rangoInicial, null);
									}

									r.resultados = g1.g1e10(r.entradas);

									System.out.printf(
											"\n---------------------------------------------------------------------\npromedio normal n1: %.2f, n2: %.2f, n3: %.2f, n4: %.2f = %.2f\n"
													+ "promedio ponderado n1: %.2f, n2: %.2f, n3: %.2f, n4: %.2f = %.2f\n---------------------------------------------------------------------\n",
											r.entradas[0], r.entradas[1], r.entradas[2], r.entradas[3], r.resultados[4],
											r.resultados[0], r.resultados[1], r.resultados[2], r.resultados[3],
											r.resultados[5]);
									break;
								case 11:
									r.entradas = new float[2];
									//r.tipoOpcion = "base";
									r.rangoInicial = 0.1f;
									System.out.print("\ningrese base (mt): ");
									r.temp = in.next();
									r.entradas[0] = r.verificarValor(r.temp, r.rangoInicial, null);
									//r.tipoOpcion = "altura";
									do {
										System.out.print("ingrese altura (mt): ");
										r.temp = in.next();
										r.entradas[1] = r.verificarValor(r.temp, r.rangoInicial, null);

										if (r.entradas[0] == r.entradas[1])
											System.out.println(
													"\n**************************************\ningrese una altura diferente a la base\n**************************************\n");

									} while (r.entradas[0] == r.entradas[1]);
									r.resultados = g1.g1e11(r.entradas[0], r.entradas[1]);
									System.out.printf(
											"\n《 el perimetro y area de un rectangulo con base %.2f y altura de %.2f es:\n perimetro = %.2f mt, area = %.2f mt\u00b2 》\n",
											r.entradas[0], r.entradas[1], r.resultados[0], r.resultados[1]);
									break;
								case 12:
									r.entradas = new float[2];
									//r.tipoOpcion = "peso";
									r.rangoInicial = 0.1f;
									System.out.print("\ningrese peso (kg): ");
									r.temp = in.next();
									r.entradas[0] = r.verificarValor(r.temp, r.rangoInicial, null);
									//r.tipoOpcion = "altura";
									System.out.print("\ningrese altura (mt): ");
									r.temp = in.next();
									r.entradas[1] = r.verificarValor(r.temp, r.rangoInicial, null);
									r.resultadoUnico = g1.g1e12(r.entradas[0], r.entradas[1]);
									System.out.printf(
											"\n《 con %.2f mt de altura y un peso de %.2f kg se obtiene un IMC = %.2f 》\n",
											r.entradas[1], r.entradas[0], r.resultadoUnico);
									break;
								}
								break;
							case 2: // guia 2

								String respuestaTemporal;
								boolean[] aciertos;
								String[] soluciones;

								switch (r.opcionEjercicio) {

								case 1:
									//r.tipoOpcion = "edad";
									r.rangoInicial = 1f;
									System.out.print("\ningrese edad: ");
									r.temp = in.next();
									r.entradaUnica = r.verificarValor(r.temp, r.rangoInicial, null);
									System.out.printf(
											g2.g2e1((int) r.entradaUnica)
													? "\n《 ud. tiene %d anios y es mayor de edad 》\n"
													: "\n《 ud.tiene %d anios y es menor de edad 》\n",
											(int) r.entradaUnica);
									break;
								case 2:
									//r.tipoOpcion = "valor";
									System.out.print("\ningrese valor: ");
									r.temp = in.next();
									r.entradaUnica = r.verificarValor(r.temp);
									System.out.printf(g2.g2e2((int) r.entradaUnica) ? "\n《 %.2f es un valor par 》\n"
											: "\n《 %.2f es un valor impar 》\n", r.entradaUnica);
									break;
								case 3:
									//r.tipoOpcion = "nota";
									r.rangoInicial = 1f;
									r.rangoFinal = 7f;
									System.out.print("\ningrese promedio de nota final: ");
									r.temp = in.next();
									r.entradaUnica = r.verificarValor(r.temp, r.rangoInicial, null);
									System.out.printf(
											g2.g2e3(r.entradaUnica)
													? "\n《 felicitaciones, has aprobado con una nota %.2f 》\n"
													: "\n《 lo sentimos, has reprobado con una nota %.2f 》\n",
											r.entradaUnica);
									break;
								case 4:
									r.entradas = new float[2];
									//r.tipoOpcion = "opcion";
									r.rangoInicial = 1f;
									r.rangoFinal = 2f;

									System.out.println(
											"\nSeleccione el tipo de grados a convertir\n\n-----------------------\n1. Celsius a Fahrenheit\n"
													+ "2. Fahrenheit a Celsius\n-----------------------\n");
									System.out.print("ingrese opcion: ");
									r.temp = in.next();
									r.entradas[0] = r.verificarValor(r.temp, (int) r.rangoInicial, (int) r.rangoFinal);

									respuestaTemporal = ((int) r.entradas[0] == 1) ? "gradosCelsius"
											: "gradosFahrenheit";

									System.out
											.print(((int) r.entradas[0] == 1) ? "\ningrese cantidad de grados celsius: "
													: "\ningrese cantidad de grados fahrenheit: ");
									r.temp = in.next();
									r.entradas[1] = r.verificarValor(r.temp);
									r.resultadoUnico = g2.g2e4((int) r.entradas[0], r.entradas[1]);
									System.out.printf(
											((int) r.entradas[0] == 1)
													? "\n《 %.2f grados celsius = %.2f grados fahrenheit 》\n"
													: "\n《 %.2f grados fahrenheit = %.2f grados celsius 》\n",
											r.entradas[1], r.resultadoUnico);
									break;
								case 5:
									String[] palabras = new String[2];
									System.out.print("\ningrese primera palabra: ");
									palabras[0] = in.next();
									System.out.print("ingrese segunda palabra: ");
									palabras[1] = in.next();
									System.out.printf(
											(g2.g2e5(palabras[0], palabras[1])) ? "\n《 p1: %s es igual a p2: %s 》\n"
													: "\n《 p1: %s es diferente a p2: %s 》\n",
											palabras[0], palabras[1]);
									break;
								case 6:
									r.rangoInicial = 0.1f;
									r.entradas = new float[2];
									//r.tipoOpcion = "horasTrabajadas";
									System.out.print("\ningrese horas trabajadas: ");
									r.temp = in.next();
									r.entradas[0] = r.verificarValor(r.temp, r.rangoInicial, null);
									//r.tipoOpcion = "valorHora";
									System.out.print("ingrese valor de hora: ");
									r.temp = in.next();
									r.entradas[1] = r.verificarValor(r.temp, r.rangoInicial, null);
									r.resultados = g2.g2e6(r.entradas[0], r.entradas[1]);

									System.out.println("\n----------------------------------------------------");
									System.out.printf("《 horas trabajadas: %.2f, valor hora: %.2f 》\n\n", r.entradas[0],
											r.entradas[1]);
									if (r.resultados[1] > 0)
										System.out.printf("sueldo base: %.2f\nsueldo bruto: %.2f", r.resultados[0],
												r.resultados[2]);
									else
										System.out.printf("sueldo bruto: %.2f", r.resultados[0], r.resultados[2]);
									System.out.printf(((int) r.resultados[1] == 0) ? "\nud. tiene: 0 horas extras\n"
											: "\nud. tiene: %.2f horas extras\n", r.resultados[1]);
									System.out.println("----------------------------------------------------");
									break;
								case 7:
									r.entradas = new float[2];
									//r.tipoOpcion = "opcion";
									r.rangoInicial = 1f;
									r.rangoFinal = 2f;

									System.out.println(
											"\nSeleccione el tipo de moneda a convertir\n\n------------------\n1. pesos a dolares\n"
													+ "2. dolares a pesos\n------------------\n");
									System.out.print("ingrese opcion: ");
									r.temp = in.next();
									r.entradas[0] = r.verificarValor(r.temp, (int) r.rangoInicial, (int) r.rangoFinal);

									respuestaTemporal = ((int) r.entradas[0] == 1) ? "pesos" : "dolares";

									System.out.print(((int) r.entradas[0] == 1) ? "\ningrese cantidad de pesos: "
											: "\ningrese cantidad de dolares: ");
									r.temp = in.next();
									r.entradas[1] = r.verificarValor(r.temp);
									r.resultadoUnico = g2.g2e7((int) r.entradas[0], r.entradas[1]);
									System.out.printf(
											((int) r.entradas[0] == 1) ? "\n《 %.2f pesos = %.2f dolares 》\n"
													: "\n《 %.2f dolares = %.2f pesos 》\n",
											r.entradas[1], r.resultadoUnico);
									break;
								case 8:
									//r.tipoOpcion = "nota";
									r.entradas = new float[4];
									r.rangoInicial = 1f;
									r.rangoFinal = 7f;
									for (int i = 0; i < 4; i++) {
										if (i == 0)
											System.out.println();
										System.out.print("ingrese nota " + (i + 1) + ": ");
										r.temp = in.next();
										r.entradas[i] = r.verificarValor(r.temp, r.rangoInicial, r.rangoFinal);
									}
									r.resultados = g2.g2e8(r.entradas);
									respuestaTemporal = (r.resultados[6] == 1) ? "felicitaciones, has aprobado"
											: "lo sentimos, has reprobado";
									System.out.printf(
											"\n---------------------------------------------------------------------\npromedio normal n1: %.2f, n2: %.2f, n3: %.2f, n4: %.2f = %.2f\n"
													+ "promedio ponderado n1: %.2f, n2: %.2f, n3: %.2f, n4: %.2f = %.2f\n\n%s con un %.2f\n---------------------------------------------------------------------\n",
											r.entradas[0], r.entradas[1], r.entradas[2], r.entradas[3], r.resultados[5],
											r.resultados[0], r.resultados[1], r.resultados[2], r.resultados[3],
											r.resultados[4], respuestaTemporal, r.resultados[4]);
									break;
								case 9:
									//r.tipoOpcion = "opcion";
									r.entradas = new float[3];
									r.rangoInicial = 1f;
									r.rangoFinal = 4f;
									System.out.println(
											"\nSeleccione una operacion a realizar\n\n------------------\n1. sumar\n2. restar\n3. multiplicar\n4. dividir"
													+ "\n------------------\n");
									System.out.print("ingrese una opcion: ");
									r.temp = in.next();
									r.entradas[0] = r.verificarValor(r.temp, (int) r.rangoInicial, (int) r.rangoFinal);

									System.out.println();
									for (int i = 1; i < 3; i++) {
										//r.tipoOpcion = "valor";
										System.out.print("ingrese valor " + i + ": ");
										r.temp = in.next();
										r.entradas[i] = r.verificarValor(r.temp);

										if (r.entradas[i] == 0) {

											do {
												//r.tipoOpcion = "denominador";
												System.out.println(
														"\n******************************\nno se puede dividir entre cero\n******************************\n");
												System.out.print("ingrese nuevo denominador: ");
												r.temp = in.next();
												r.entradas[2] = r.verificarValor(r.temp);

											} while (r.entradas[i] == 0);
										}
									}

									r.resultados = g2.g2e9(r.entradas[1], r.entradas[2]);

									switch ((int) r.entradas[0]) {

									case 1:
										System.out.printf("\n《 la suma de %.2f + %.2f = %.2f 》\n", r.entradas[1],
												r.entradas[2], r.resultados[0]);
										break;
									case 2:
										System.out.printf("\n《 la resta de %.2f - %.2f = %.2f 》\n", r.entradas[1],
												r.entradas[2], r.resultados[1]);
										break;
									case 3:
										System.out.printf("\n《 la multiplicacion de %.2f * %.2f = %.2f 》\n",
												r.entradas[1], r.entradas[2], r.resultados[2]);
										break;
									case 4:
										System.out.printf("\n《 la division de %.2f / %.2f = %.2f 》\n", r.entradas[1],
												r.entradas[2], r.resultados[3]);
										break;
									}

									break;
								case 10:
									//r.tipoOpcion = "angulo";
									r.entradas = new float[3];
									r.rangoInicial = 0.1f;
									r.rangoFinal = 180f;
									System.out.println();
									for (int i = 0; i < 3; i++) {

										System.out.print("ingrese angulo " + (i + 1) + ": ");
										r.temp = in.next();
										r.entradas[i] = r.verificarValor(r.temp, r.rangoInicial, r.rangoFinal);
									}
									r.resultados = g2.g2e10(r.entradas);
									System.out.printf("\n《 a1: %.2f, a2: %.2f, a3: %.2f = %.2f", r.entradas[0],
											r.entradas[1], r.entradas[2], r.resultados[0]);
									System.out.println(
											(r.resultados[1] == 1) ? " es un triangulo 》" : " no es un triangulo 》");

									break;
								case 11:
									//r.tipoOpcion = "diaSemana";
									System.out.print("\ningrese un dia de la semana, en valor numerico: ");
									r.temp = in.next();
									r.rangoInicial = 1f;
									r.rangoFinal = 7f;
									r.entradaUnica = r.verificarValor(r.temp, r.rangoInicial, r.rangoFinal);
									respuestaTemporal = g2.g2e11((int) r.entradaUnica);
									System.out.printf("\n《 el valor %d equivale al dia %s 》\n", (int) r.entradaUnica,
											respuestaTemporal);
									break;
								case 12:
									//r.tipoOpcion = "opcion";
									r.entradas = new float[2];
									r.rangoInicial = 1f;
									r.rangoFinal = 3f;
									System.out.println(
											"\nSeleccione la figura, que desea calcular el area\n\n--------------\n1. triangulo\n2. circulo\n3. rectangulo"
													+ "\n--------------\n");
									System.out.print("ingrese una opcion: ");
									r.temp = in.next();
									r.entradaUnica = r.verificarValor(r.temp, (int) r.rangoInicial, (int) r.rangoFinal);
									System.out.println();

									switch ((int) r.entradaUnica) {

									case 1:
										//r.tipoOpcion = "base";
										r.rangoInicial = 0;
										System.out.print("ingrese base (mt): ");
										r.temp = in.next();
										r.entradas[0] = r.verificarValor(r.temp, r.rangoInicial, null);
										//r.tipoOpcion = "altura";
										System.out.print("ingrese altura (mt): ");
										r.temp = in.next();
										r.entradas[1] = r.verificarValor(r.temp, r.rangoInicial, null);
										break;
									case 2:
										//r.tipoOpcion = "radio";
										r.rangoInicial = 0;
										System.out.print("ingrese radio (mt): ");
										r.temp = in.next();
										r.entradas[0] = r.verificarValor(r.temp, r.rangoInicial, null);
										break;
									case 3:
										//r.tipoOpcion = "base";
										r.rangoInicial = 0;
										System.out.print("ingrese base (mt): ");
										r.temp = in.next();
										r.entradas[0] = r.verificarValor(r.temp, r.rangoInicial, null);
										do {
											//r.tipoOpcion = "altura";
											System.out.print("ingrese altura (mt): ");
											r.temp = in.next();
											r.entradas[1] = r.verificarValor(r.temp, r.rangoInicial, null);

											if (r.entradas[0] == r.entradas[1]) {

												System.out.println(
														"\n**********************************************************************\n"
																+ "la altura debe ser distinta de la base, para poder armar un rectangulo\n"
																+ "**********************************************************************\n");
												System.out.print("ingrese nueva opcion: ");
											}

										} while (r.entradas[0] == r.entradas[1]);
										break;
									}

									if ((int) r.entradaUnica == 2) {

										r.resultadoUnico = g2.g2e12((int) r.entradaUnica, null, null, r.entradas[0]);
										System.out.printf(
												"\n《 el area de un circulo con un radio: %.2f mt = %.2f mt\u00b2 》\n",
												r.entradas[0], r.resultadoUnico);

									} else {

										respuestaTemporal = ((int) r.entradaUnica == 1) ? "triangulo" : "rectangulo";
										r.resultadoUnico = g2.g2e12((int) r.entradaUnica, r.entradas[0], r.entradas[1],
												null);

										System.out.printf(
												"\n《 el area de un %s con una base: %.2f mt y una altura: %.2f mt = %.2f mt\u00b2 》\n",
												respuestaTemporal, r.entradas[0], r.entradas[1], r.resultadoUnico);
									}

									break;
								case 13:
									r.entradas = new float[2];
									//r.tipoOpcion = "promedio";
									r.rangoInicial = 1f;
									r.rangoFinal = 7f;
									System.out.print("\ningrese promedio final del curso: ");
									r.temp = in.next();
									r.entradas[0] = r.verificarValor(r.temp, r.rangoInicial, r.rangoFinal);

									r.rangoInicial = 0f;
									r.rangoFinal = 100f;
									//r.tipoOpcion = "asistencia";
									System.out.print("ingrese asistencia en (%): ");
									r.temp = in.next();
									r.entradas[1] = r.verificarValor(r.temp, r.rangoInicial, r.rangoFinal);
									aciertos = g2.g2e13(r.entradas[0], r.entradas[1]);

									if (aciertos[0] && aciertos[1])
										System.out.print("\n《 felicitaciones, has aprobado con una nota: "
												+ r.entradas[0] + " y una asistencia: " + r.entradas[1] + "% 》\n");
									else {
										if (!aciertos[0] && aciertos[1])
											System.out.print("\n《 lo sentimos, has reprobado por nota: " + r.entradas[0]
													+ ", tienes una asistencia: " + r.entradas[1] + "% 》\n");
										else if (aciertos[0] && !aciertos[1])
											System.out.print(
													"\n《 lo sentimos, has reprobado por asistencia: " + r.entradas[1]
															+ "%, tienes un promedio final: " + r.entradas[0] + " 》\n");
										else
											System.out.print("\n《 lo sentimos, has reprobado por nota: " + r.entradas[0]
													+ " y asistencia: " + r.entradas[1] + "% 》\n");
									}
									break;
								case 14:
									System.out.print("\ningrese primera palabra: ");
									r.temp = in.next();
									System.out.print("ingrese segunda palabra: ");
									respuestaTemporal = in.next();
									aciertos = g2.g2e14(r.temp, respuestaTemporal);

									if (aciertos[0])
										System.out.printf("\n《 p1 => " + r.temp + ": " + r.temp.length() + ", p2 => "
												+ respuestaTemporal + ": " + respuestaTemporal.length()
												+ " (p1 = p2) 》\n");
									else if (aciertos[1])
										System.out.printf("\n《 p1 => " + r.temp + ": " + r.temp.length() + ", p2 => "
												+ respuestaTemporal + ": " + respuestaTemporal.length()
												+ " (p1 > p2) 》\n");
									else
										System.out.printf("\n《 p1 => " + r.temp + ": " + r.temp.length() + ", p2 => "
												+ respuestaTemporal + ": " + respuestaTemporal.length()
												+ " (p1 < p2) 》\n");
									break;
								case 15:
									//r.tipoOpcion = "valor";
									r.entradas = new float[2];
									System.out.print("\ningrese primer valor: ");
									r.temp = in.next();
									r.entradas[0] = r.verificarValor(r.temp);
									System.out.print("ingrese segundo valor: ");
									r.temp = in.next();
									r.entradas[1] = r.verificarValor(r.temp);
									aciertos = g2.g2e15(r.entradas[0], r.entradas[1]);

									if (aciertos[0])
										System.out.printf(
												"\n《 n1: " + r.entradas[0] + " = n2: " + r.entradas[1] + " 》\n");
									else if (aciertos[1])
										System.out.printf(
												"\n《 n1: " + r.entradas[0] + " > n2: " + r.entradas[1] + " 》\n");
									else
										System.out.printf(
												"\n《 n1: " + r.entradas[0] + " < n2: " + r.entradas[1] + " 》\n");
									break;
								case 16:
									r.entradas = new float[3];
									//r.tipoOpcion = "valor";
									System.out.print("\ningrese valor a: ");
									r.temp = in.next();
									r.entradas[0] = r.verificarValor(r.temp);
									System.out.print("ingrese valor b: ");
									r.temp = in.next();
									r.entradas[1] = r.verificarValor(r.temp);
									System.out.print("ingrese valor c: ");
									r.temp = in.next();
									r.entradas[2] = r.verificarValor(r.temp);
									r.resultados = g2.g2e16(r.entradas[0], r.entradas[1], r.entradas[2]);

									if (r.resultados[0] < 0)
										System.out.println("\n《 ¡no tiene solucion en los números reales! 》");
									if (r.resultados[0] == 0)
										System.out.printf(
												"\n《 la ecuación tiene solamente una solucion real, x = %.2f 》\n",
												r.resultados[1]);
									else {
										System.out.printf("\n《 x1 = %.2f, x2 = %.2f 》\n", r.resultados[1],
												r.resultados[2]);
									}
									break;
								case 17:
									float valorEntrada = 10000f;
									//r.tipoOpcion = "edad";
									r.rangoInicial = 1;
									System.out.print("\ningrese edad: ");
									r.temp = in.next();
									r.entradaUnica = r.verificarValor(r.temp, r.rangoInicial, null);

									if (r.entradaUnica >= 18) {

										do {
											System.out.print("ingrese genero: ");
											r.temp = in.next();

											if (!r.temp.equalsIgnoreCase("m") && !r.temp.equalsIgnoreCase("f"))
												System.out.println(
														"\n*******************\ndebe ingresar (m|f)\n*******************\n");

										} while (!r.temp.equalsIgnoreCase("m") && !r.temp.equalsIgnoreCase("f"));

										r.resultadoCorrecto = g2.g2e17((int) r.entradaUnica, r.temp);

										if (r.resultadoCorrecto)
											System.out.printf(
													"\n《 ud. es mayor de edad, es hombre y debe pagar entrada: %d 》\n",
													(int) valorEntrada);
										else
											System.out.println(
													"\n《 ud. es mayor de edad, es mujer y no debe pagar entrada 》");

									} else
										System.out.println(
												"\n《 ud. es menor de edad y no puede ingresar al establecimiento 》");

									break;
								case 18:
									r.entradas = new float[2];
									r.rangoInicial = 0.1f;
									//r.tipoOpcion = "peso";
									System.out.print("\ningrese peso (kg): ");
									r.temp = in.next();
									r.entradas[0] = r.verificarValor(r.temp, r.rangoInicial, null);
									//r.tipoOpcion = "altura";
									System.out.print("ingrese altura (mt): ");
									r.temp = in.next();
									r.entradas[1] = r.verificarValor(r.temp, r.rangoInicial, null);
									soluciones = g2.g2e18(r.entradas[0], r.entradas[1]);
									System.out.printf("\n《 IMC: %.2f => %s 》\n", Float.parseFloat(soluciones[0]),
											soluciones[1]);
									break;
								case 19:
									r.entradas = new float[3];
									//r.tipoOpcion = "valor";
									System.out.println();
									for (int i = 0; i < 3; i++) {
										System.out.print("ingrese valor " + (i + 1) + ": ");
										r.temp = in.next();
										r.entradas[i] = r.verificarValor(r.temp);
									}
									r.resultados = g2.g2e19(r.entradas);
									System.out.println("------------------------------");
									System.out.printf(
											"valores ingresados desordenados:\nn1: %.2f, n2: %.2f, n3: %.2f\n\nvalores ordenados:\n"
													+ "%.2f, %.2f, %.2f\n",
											r.entradas[0], r.entradas[1], r.entradas[2], r.resultados[0],
											r.resultados[1], r.resultados[2]);
									System.out.println("------------------------------");
									break;
								case 20:
									//r.tipoOpcion = "valor";
									System.out.print("\ningrese valor: ");
									r.temp = in.next();
									r.entradaUnica = r.verificarValor(r.temp);
									r.resultadoCorrecto = g2.g2e20((int) r.entradaUnica);
									if (r.resultadoCorrecto)
										System.out.printf("\n《 el numero %d si es multiplo de 6 》\n",
												(int) r.entradaUnica);
									else
										System.out.printf("\n《 el numero %d no es multiplo de 6 》\n",
												(int) r.entradaUnica);
									break;
								case 21:
									r.entradas = new float[6];
									char[] coeficientes = { 'a', 'b', 'c', 'd', 'e', 'f' };
									//r.tipoOpcion = "valor";
									System.out.println();
									for (int i = 0; i < 6; i++) {
										System.out.print("ingrese valor " + coeficientes[i] + ": ");
										r.temp = in.next();
										r.entradas[i] = r.verificarValor(r.temp);
									}
									respuestaTemporal = g2.g2e21(r.entradas);

									if (respuestaTemporal == null)
										System.out.println("\n《 el sistema no tiene solucion 》");
									else {
										soluciones = respuestaTemporal.split(",");
										System.out.printf("\n《 x: %s, y: %s 》\n", soluciones[0], soluciones[1]);
									}

									break;
								}
								break;
							case 3: // guia 3
								ArrayList<Float> valoresDinamicos;
								ArrayList<Persona> personas;
								ArrayList<Empleado> empleados;
								switch (r.opcionEjercicio) {

								case 1:
									r.temp = g3.g3e1();
									System.out.println(r.temp);

									break;
								case 2:
									r.entradas = new float[3];
									//r.tipoOpcion = "valor";
									System.out.println();
									for (int i = 0; i < 2; i++) {
										System.out.print("ingrese valor " + (i + 1) + ": ");
										r.temp = in.next();
										r.entradas[i] = r.verificarValor(r.temp);
									}
									respuestaTemporal = g3.g3e2((int) r.entradas[0], (int) r.entradas[1]);
									System.out.println(respuestaTemporal);
									break;
								case 3:
									r.temp = g3.g3e3();
									System.out.println(r.temp);
									break;
								case 4:
									r.temp = g3.g3e4();
									System.out.println(r.temp);
									break;
								case 5:
									valoresDinamicos = new ArrayList<Float>();
									//r.tipoOpcion = "estatura";
									r.rangoInicial = 0.1f;
									respuestaTemporal = "";

									System.out.println();
									do {
										System.out.print("digite (0) para salir, ingrese estatura (mt): ");
										r.temp = in.next();
										r.entradaUnica = r.verificarValor(r.temp, r.rangoInicial, null);

										if ((int) r.entradaUnica == 0) {

											r.opcionVarios = OpcionesTipo.DEJAR_INGRESAR_ESTATURAS;											
											r.validarRespuesta();

											if (r.temp.equalsIgnoreCase("s"))
												break;
										} else if ((int) r.entradaUnica > 0)
											valoresDinamicos.add(r.entradaUnica);

									} while ((int) r.entradaUnica != 0);

									respuestaTemporal = "";

									if (valoresDinamicos.size() > 0) {
										r.resultadoUnico = g3.g3e5(valoresDinamicos);

										for (float d : valoresDinamicos)
											respuestaTemporal += (d + ", ");

										System.out.println("\nalturas ingresadas: "
												+ respuestaTemporal.substring(0, respuestaTemporal.length() - 2));
										System.out.printf("《 el promedio de %d alturas ingresadas es: %.2f mt 》\n",
												valoresDinamicos.size(), r.resultadoUnico);
									}
									break;
								case 6:
									//r.tipoOpcion = "valor";
									r.rangoInicial = 1f;
									r.rangoFinal = 20f;
									System.out.print("\ningrese tabla a mostrar (1-20): ");
									r.temp = in.next();
									r.entradaUnica = r.verificarValor(r.temp, (int) r.rangoInicial, (int) r.rangoFinal);
									respuestaTemporal = g3.g3e6((int) r.entradaUnica);
									System.out.println("\n" + respuestaTemporal);
									break;
								case 7:
									//r.tipoOpcion = "valor";
									r.entradas = new float[2];
									System.out.println();
									for (int i = 0; i < 2; i++) {
										System.out.print("ingrese valor " + (i + 1) + ": ");
										r.temp = in.next();
										r.entradas[i] = r.verificarValor(r.temp);
									}
									respuestaTemporal = g3.g3e7((int) r.entradas[0], (int) r.entradas[1]);
									System.out.println("\n" + respuestaTemporal);
									break;
								case 8:
									valoresDinamicos = new ArrayList<Float>();
									//r.tipoOpcion = "angulo";
									r.rangoInicial = 0;
									r.rangoFinal = 360f;
									respuestaTemporal = "";

									System.out.println();
									do {
										r.rangoInicial = 0.1f;
										r.rangoFinal = 360f;

										System.out.print("digite (0) para salir, ingrese angulo: ");
										r.temp = in.next();
										r.entradaUnica = r.verificarValor(r.temp, r.rangoInicial, r.rangoFinal);

										if ((int) r.entradaUnica == 0) {

											r.opcionVarios = OpcionesTipo.DEJAR_INGRESAR_ANGULOS;
											r.validarRespuesta();

											if (r.respuesta.equalsIgnoreCase("s"))
												break;
										} else if ((int) r.entradaUnica > 0)
											valoresDinamicos.add(r.entradaUnica);

									} while ((int) r.entradaUnica != 0);

									respuestaTemporal = "";

									if (valoresDinamicos.size() > 0) {
										r.resultados = g3.g3e8(valoresDinamicos);

										for (float d : valoresDinamicos)
											respuestaTemporal += (d + ", ");

										System.out.println("\nangulos ingresados: "
												+ respuestaTemporal.substring(0, respuestaTemporal.length() - 2));
										System.out.printf(
												"tipos de angulos: agudos = %d, rectos = %d, obtusos = %d, llanos = %d, concavos = %d\ncantidad de angulos totales: %d\n",
												(int) r.resultados[0], (int) r.resultados[4], (int) r.resultados[3],
												(int) r.resultados[2], (int) r.resultados[1], valoresDinamicos.size());
									}
									break;
								case 9:
									r.entradas = new float[10];
									//r.tipoOpcion = "valor";
									System.out.println();
									for (int i = 0; i < 10; i++) {
										System.out.print("ingrese valor " + (i + 1) + ": ");
										r.temp = in.next();
										r.entradas[i] = r.verificarValor(r.temp);
									}
									r.resultados = g3.g3e9(r.entradas);
									System.out.printf(
											"\n---------------------------------\ndetalle de valores ingresados:\nvalores negativos: %d\nvalores positivos: %d\nvalores multiplos de 15: %d\nsuma de los valores pares: %.2f\n---------------------------------\n",
											(int) r.resultados[0], (int) r.resultados[1], (int) r.resultados[2],
											r.resultados[3]);
									break;
								case 10:
									personas = new ArrayList<Persona>();
									Persona usuario;
									//r.tipoOpcion = "edad";
									r.rangoInicial = 1;
									respuestaTemporal = "";

									do {
										usuario = new Persona();
										System.out.print("\ningrese edad: ");
										r.temp = in.next();
										r.entradaUnica = r.verificarValor(r.temp, r.rangoInicial, null);
										usuario.setEdad((int) r.entradaUnica);

										if (usuario.getEdad() >= 18) {

											do {
												System.out.print("ingrese genero: ");
												r.temp = in.next();

												if (!r.temp.equalsIgnoreCase("m") && !r.temp.equalsIgnoreCase("f"))

													System.out.println(
															"\n*******************\ndebe ingresar (m|f)\n*******************\n");

											} while (!r.temp.equalsIgnoreCase("m") && !r.temp.equalsIgnoreCase("f"));

											usuario.setGenero(r.temp.charAt(0));

											if (usuario.getGenero() != ' ' && usuario.getEdad() >= 18)
												personas.add(usuario);

										} else {
											System.out.println(
													"\n-------------------------------------------------------------------------\n¡lo sentimos ud. es menor de edad y no puede ingresar al establecimiento!\n"
															+ "-------------------------------------------------------------------------");
										}

										r.opcionVarios = OpcionesTipo.AGREGAR_OTRA_PERSONA;
										r.validarRespuesta();

									} while (r.respuesta.equalsIgnoreCase("s"));

									r.resultados = g3.g3e10(personas);

									respuestaTemporal = "";

									for (Persona p : personas)
										respuestaTemporal += (p.getGenero() + ":" + p.getEdad() + ", ");

									System.out.println(
											"\n----------------------------------------------------------\ndatos usuarios ingresados: "
													+ respuestaTemporal.substring(0, respuestaTemporal.length() - 2));
									System.out.printf(
											"cantidad de personas ingresadas: %d\ncantidad de varones: %d\ncantidad de mujeres: %d\npromedio edad general: %.2f\npromedio edad varones %.2f\npromedio edad mujeres: %.2f\n----------------------------------------------------------\n",
											(int) r.resultados[0], (int) r.resultados[1], (int) r.resultados[2],
											r.resultados[3], r.resultados[4], r.resultados[5]);

									break;
								case 11:
									empleados = new ArrayList<Empleado>();
									//r.tipoOpcion = "nombre";
									r.rangoInicial = Empleado.SUELDO_MINIMO;
									String[] departamentos = { "RR.HH", "contabilidad", "informatica" };
									Empleado empleado;
									r.entradas = new float[3]; // 0: RR.HH, 1: contabilidad, 2: informatica
									float aumento = 0;
									float[] aumentos = { 20f, 10f, 5f, 2f };

									do {
										empleado = new Empleado();
										do {
											System.out.print("\ningrese nombre: ");
											r.temp = in.next();
											in.next();
											if (r.temp.length() < 3)
												System.out.println(
														"\n************************************************************\ndebe ingresar un nombre con 3 caracteres como minimo\n************************************************************\n");

										} while (r.temp.length() < 3);

										empleado.setNombre(r.temp);

										//r.tipoOpcion = "departamento";
										do {
											System.out.print("ingrese departamento: ");
											r.temp = in.next();

											if (!r.temp.equalsIgnoreCase(departamentos[0])
													&& !r.temp.equalsIgnoreCase(departamentos[1])
													&& !r.temp.equalsIgnoreCase(departamentos[2]))
												System.out.println(
														"\n***********************************************************************************\ndebe ingresar uno de los siguientes departamento (RR.HH, contabilidad, informatica)\n***********************************************************************************\n");

										} while (!r.temp.equalsIgnoreCase(departamentos[0])
												&& !r.temp.equalsIgnoreCase(departamentos[1])
												&& !r.temp.equalsIgnoreCase(departamentos[2]));

										empleado.setDepartamento(r.temp);

										switch (empleado.getDepartamento()) {

										case "RR.HH":
											r.entradas[0]++;
											break;
										case "contabilidad":
											r.entradas[1]++;
											break;
										case "informatica":
											r.entradas[2]++;
											break;
										}

										//r.tipoOpcion = "sueldo";
										System.out.print("ingrese sueldo: ");
										r.temp = in.next();
										empleado.setSueldo(r.verificarValor(r.temp, r.rangoInicial, null));

										if (empleado.getSueldo() <= 900_000)
											aumento = empleado.getSueldo() * (aumentos[0] / 100);
										else if (empleado.getSueldo() <= 1_300_000)
											aumento = empleado.getSueldo() * (aumentos[1] / 100);
										else if (empleado.getSueldo() <= 1_800_000)
											aumento = empleado.getSueldo() * (aumentos[2] / 100);
										else
											aumento = empleado.getSueldo() * (aumentos[3] / 100);

										System.out.printf("\nnombre: %s\nsueldo actual: %.2f\nnuevo sueldo: %.2f\n",
												empleado.getNombre(), empleado.getSueldo(),
												(empleado.getSueldo() + aumento));

										empleados.add(empleado);

										r.opcionVarios = OpcionesTipo.AGREGAR_OTRA_PERSONA;
										r.validarRespuesta();

									} while (r.respuesta.equalsIgnoreCase("s"));

									r.resultados = g3.g3e11(empleados);

									System.out.printf(
											"\n------------------------------------\ncantidades por departamentos\nRR.HH: %d\ncontabilidad: %d\ninformatica: %d\n"
													+ "total de sueldos beses: %.2f\ntotal de nuevos sueldos: %.2f\n------------------------------------\n",
											(int) r.resultados[2], (int) r.resultados[3], (int) r.resultados[4],
											r.resultados[0], r.resultados[1]);
									break;
								case 12:
									//r.tipoOpcion = "nota";
									r.rangoInicial = 1f;
									r.rangoFinal = 7f;
									r.entradas = new float[4];

									System.out.println();
									for (int i = 0; i < 4; i++) {
										System.out.print("ingrese nota " + (i + 1) + ": ");
										r.temp = in.next();
										r.entradas[i] = r.verificarValor(r.temp, r.rangoInicial, r.rangoFinal);
									}
									r.resultadoUnico = g3.g3e12(r.entradas);
									System.out.printf("\nn1: %.2f, n2: %.2f, n3: %.2f, n4: %.2f\n", r.entradas[0],
											r.entradas[1], r.entradas[2], r.entradas[3]);
									System.out.printf(
											(r.resultadoUnico >= 4)
													? "《 felicidades has aprobado con un promedio final: %.2f 》\n"
													: "《 lo sentimos, has reprobado con un promedio final: %.2f 》\n",
											r.resultadoUnico);
									break;
								case 13:
									r.entradas = new float[2];
									//r.tipoOpcion = "opcion";
									r.rangoInicial = 1f;
									r.rangoFinal = 2f;

									System.out.println(
											"\nSeleccione el tipo de grados a convertir\n\n-----------------------\n1. Celsius a Fahrenheit\n"
													+ "2. Fahrenheit a Celsius\n-----------------------\n");
									System.out.print("ingrese opcion: ");
									r.temp = in.next();
									r.entradas[0] = r.verificarValor(r.temp, (int) r.rangoInicial, (int) r.rangoFinal);

									respuestaTemporal = ((int) r.entradas[0] == 1) ? "gradosCelsius"
											: "gradosFahrenheit";

									System.out
											.print(((int) r.entradas[0] == 1) ? "\ningrese cantidad de grados celsius: "
													: "\ningrese cantidad de grados fahrenheit: ");
									r.temp = in.next();
									r.entradas[1] = r.verificarValor(r.temp);
									r.resultadoUnico = g3.g3e13((int) r.entradas[0], r.entradas[1]);
									System.out.printf(
											((int) r.entradas[0] == 1)
													? "\n《 %.2f grados celsius = %.2f grados fahrenheit 》\n"
													: "\n《 %.2f grados fahrenheit = %.2f grados celsius 》\n",
											r.entradas[1], r.resultadoUnico);
									break;
								case 14:
									int zonas = 4;
									int zona = 7;
									// float[][] lluvias =
									// {{1f,2f,3f,0,5f,6f,0},{0,6f,5f,4f,3f,2f,1f},{1f,2f,3f,4f,5f,6f,7f},{7f,6f,0,4f,0,2f,0}};

									float[][] lluvias = new float[zonas][zona];
									//r.tipoOpcion = "lluvia";
									r.rangoInicial = 0;
									for (int i = 0; i < zonas; i++) {
										System.out.println("\n\t\t\tZONA " + (i + 1) + "\n");

										for (int j = 0; j < zona; j++) {

											System.out.print("(dia " + (j + 1) + ") ingrese lluvia caida en mm: ");
											r.temp = in.next();
											lluvias[i][j] = r.verificarValor(r.temp, r.rangoInicial, null);
										}
									}

									r.resultados = g3.g3e14(lluvias);
									respuestaTemporal = String.format(
											"\n------------------------------------------\nlluvia en zona 1: %.2f (mm), dias sin lluvia: %d\nlluvia en zona 2: %.2f (mm), dias sin lluvia: %d"
													+ "\nlluvia en zona 3: %.2f (mm), dias sin lluvia: %d\nlluvia en zona 4: %.2f (mm), dias sin lluvia: %d\n------------------------------------------\n",
											r.resultados[0], (int) r.resultados[4], r.resultados[1],
											(int) r.resultados[5], r.resultados[2], (int) r.resultados[6],
											r.resultados[3], (int) r.resultados[7]);
									System.out.println(respuestaTemporal);
									break;
								case 15:
									respuestaTemporal = "";
									long[] resultadosFulmigaciones;
									r.entradas = new float[2];
									//r.tipoOpcion = "opcion";
									r.rangoInicial = 1f;
									r.rangoFinal = 3f;
									ArrayList<float[]> fulmigaciones = new ArrayList<float[]>();

									do {
										System.out.println(
												"\nSeleccione el tipo de fulmigacion a realizar\n\n----------------------------------------------------\n1. Fulmigacion contra moscas, $5000 por hectarea\n"
														+ "2. Fulmigacion contra polillas, $10000 por hectarea\n3. Fulmigacion contra termitas, $15000 por hectarea\n----------------------------------------------------\n");
										System.out.print("ingrese opcion: ");
										r.temp = in.next();
										r.entradas[0] = r.verificarValor(r.temp, (int) r.rangoInicial,
												(int) r.rangoFinal);
										//r.tipoOpcion = "hectarea";
										r.rangoInicial = 1f;
										System.out.print("ingrese cantidad de hectareas a fulmigar (mt\u00b2): ");
										r.temp = in.next();
										r.entradas[1] = r.verificarValor(r.temp, r.rangoInicial, null);

										switch ((int) r.entradas[0]) {
										case 1:
											respuestaTemporal = "Fulmigacion contra moscas, $5000 por hectarea";
											break;
										case 2:
											respuestaTemporal = "Fulmigacion contra polillas, $10000 por hectarea";
											break;
										case 3:
											respuestaTemporal = "Fulmigacion contra termitas, $15000 por hectarea";
											break;
										}

										if (r.entradas[0] > 0 && r.entradas[1] > 0)
											fulmigaciones.add(new float[] { r.entradas[0], r.entradas[1] });

										System.out.printf("\n《 (%d) %s, area a fulmigar: %.2f (mt\u00b2) 》\n",
												(int) r.entradas[0], respuestaTemporal, r.entradas[1]);

										r.opcionVarios = OpcionesTipo.AGREGAR_OTRA_VENTA;
										r.validarRespuesta();

									} while (r.respuesta.equalsIgnoreCase("s"));

									resultadosFulmigaciones = g3.g3e15(fulmigaciones);

									respuestaTemporal = String.format(
											"\n--------------------------------\ncantidad de ventas realizadas: %d\nventas tipo 1: %d"
													+ "\nventas tipo 2: %d\nventas tipo 3: %d\ntotal recaudado: %d\n--------------------------------",
											(int) resultadosFulmigaciones[0], resultadosFulmigaciones[1],
											resultadosFulmigaciones[2], resultadosFulmigaciones[3],
											resultadosFulmigaciones[4]);

									System.out.println(respuestaTemporal);

									break;
								case 16:
									//r.tipoOpcion = "cantidadAlumno";
									r.rangoInicial = 1f;
									r.rangoFinal = 7f;
									System.out.print("\ningrese cantidad de alumnos a evaluar: ");
									r.temp = in.next();
									r.entradaUnica = r.verificarValor(r.temp, r.rangoInicial, r.rangoFinal);
									r.entradas = new float[(int) r.entradaUnica];
									//r.tipoOpcion = "promedio";
									respuestaTemporal = "\n------------------------------------------------\npromedios ingresados: ";
									System.out.println();
									for (int i = 0; i < (int) r.entradaUnica; i++) {
										System.out.print("ingrese promedio: ");
										r.temp = in.next();
										r.entradas[i] = r.verificarValor(r.temp, r.rangoInicial, r.rangoFinal);
										respuestaTemporal += r.entradas[i] + ", ";
									}
									respuestaTemporal = respuestaTemporal.substring(0, respuestaTemporal.length() - 2);
									r.resultados = g3.g3e16(r.entradas);
									respuestaTemporal += String.format(
											"\n\npromedio general del curso de programacion: %.2f\nalumnos aprobados: %d"
													+ "\nalumnos reprobados: %d\ncantidad de alumnos en el curso: %d\n------------------------------------------------",
											r.resultados[2], (int) r.resultados[0], (int) r.resultados[1],
											(int) r.resultados[3]);
									System.out.println(respuestaTemporal);
									break;
								case 17:
									empleados = new ArrayList<Empleado>();

									do {
										empleado = new Empleado();
										//r.tipoOpcion = "horasTrabajadas";
										r.rangoInicial = 0;
										System.out.print("\ningrese cantidad de horas trabajadas en el mes: ");
										r.temp = in.next();
										empleado.setHorastrabajadas(r.verificarValor(r.temp, r.rangoInicial, null));
										r.rangoInicial = Empleado.SUELDO_MINIMO / Empleado.HORAS_LEGALES;

										do {
											//r.tipoOpcion = "valorHora";
											System.out.print("ingrese valor hora trabajada: ");
											r.temp = in.next();
											empleado.setValorHora(r.verificarValor(r.temp));

											if (empleado.getValorHora() < r.rangoInicial) {

												System.out.println(
														"\n**********************************************************************\nno se permite un valor hora menor a lo permitido"
																+ " legalmente (" + r.rangoInicial
																+ ")\n**********************************************************************\n");
											}
										} while (empleado.getValorHora() < r.rangoInicial);

										if (empleado.getHorastrabajadas() > 0 && empleado.getValorHora() > 0)
											empleados.add(empleado);

										r.opcionVarios = OpcionesTipo.AGREGAR_OTRO_EMPLEADO;
										r.validarRespuesta();

									} while (r.respuesta.equalsIgnoreCase("s"));

									r.resultados = g3.g3e17(empleados);

									System.out.printf(
											"\n--------------------------------------------------------\ntotal de sueldos a cancelar por la empresa: %.2f\ncantidad de empleados "
													+ "con horas extras: %d\npromedio de horas extras trabajadas en la empresa: %.2f\n--------------------------------------------------------\n",
											r.resultados[0], (int) r.resultados[1], r.resultados[2]);
									break;
								case 18:
									int filas = 2;
									int columnas = 3;
									r.rangoInicial = 0.1f;
									r.rangoFinal = 360f;
									float[][] triangulos = new float[filas][columnas];
									ArrayList<float[]> triangulosRectangulos = new ArrayList<float[]>();
									//r.tipoOpcion = "cateto";

									for (int i = 0; i < triangulos.length; i++) {

										System.out.println("\n\t\tdatos de triangulo (" + (i + 1) + ")\n");

										for (int j = 0; j < triangulos[0].length; j++) {

											if (j == 0)
												System.out.print("ingrese cateto A: ");
											if (j == 1)
												System.out.print("ingrese cateto B: ");
											else if (j == 2) {
												//r.tipoOpcion = "hipotenusa";
												System.out.print("ingrese hipotenusa: ");
											}

											r.temp = in.next();
											triangulos[i][j] = r.verificarValor(r.temp, r.rangoInicial, r.rangoFinal);
										}
									}

									triangulosRectangulos = g3.g3e18(triangulos);

									respuestaTemporal = "triangulos rectangulos: ";

									for (float[] t : triangulosRectangulos) {

										respuestaTemporal += "i" + ((int) t[0] + 1) + ": " + t[1] + ", " + t[2] + ", "
												+ t[3] + " | ";

									}

									if (triangulosRectangulos.size() > 0) {
										System.out.println((triangulosRectangulos.size() > 1)
												? "\n《 ¡hay " + triangulosRectangulos.size()
														+ " triangulos rectangulos! 》"
												: "\n《 ¡hay 1 triangulo rectangulo! 》");

										System.out.println(
												respuestaTemporal.substring(0, respuestaTemporal.length() - 2));
									} else {
										System.out.println(
												"\n《 ¡No hay triangulos rectangulos, con los valores ingresados! 》");
									}

									break;
								}
								break;
							case 4: // guia 4
								int contArreglo;
								int contIndice;
								int longitud;
								int[] a;
								int[] b;
								int[] c;

								switch (r.opcionEjercicio) {

								case 1:
									//r.tipoOpcion = "valor";
									longitud = 3;
									a = new int[longitud];
									b = new int[longitud];
									contArreglo = 0;
									contIndice = 0;

									do {

										if (contArreglo == 0) {
											System.out.println("\n\t\tARREGLO A");
										} else if (contArreglo == 1) {
											System.out.println("\n\t\tARREGLO B");
										}

										for (contIndice = 0; contIndice < longitud; contIndice++) {

											if (contIndice == 0)
												System.out.print("\ningrese valor en indice " + contIndice + ": ");
											else
												System.out.print("ingrese valor en indice " + contIndice + ": ");
											r.temp = in.next();

											if (contArreglo == 0) {

												a[contIndice] = (int) r.verificarValor(r.temp);

											} else if (contArreglo == 1) {

												b[contIndice] = (int) r.verificarValor(r.temp);
											}
										}

										contArreglo++;

									} while (contArreglo < 2);

									c = g4.g4e1(a, b);

									respuestaTemporal = "\n----------------------\n";

									for (int i = 0; i < longitud; i++)
										respuestaTemporal += "[" + a[i] + "] + [" + b[i] + "] = [" + c[i] + "]\n";

									respuestaTemporal += "----------------------";
									System.out.println(respuestaTemporal);
									break;
								case 2:
									//r.tipoOpcion = "valor";
									longitud = 20;
									r.entradas = new float[longitud];
									contIndice = 0;

									do {

										if (contIndice == 0)
											System.out.print("\ningrese valor " + (contIndice + 1) + ": ");
										else
											System.out.print("ingrese valor " + (contIndice + 1) + ": ");

										r.temp = in.next();
										r.entradas[contIndice] = r.verificarValor(r.temp);

										contIndice++;

									} while (contIndice < longitud);

									System.out.print(
											"-----------------------------------------------------------------------------------------------------------------------------\nnumeros ingresados:  ");

									respuestaTemporal = "";

									for (int i = 0; i < r.entradas.length; i++) {

										respuestaTemporal += r.entradas[i] + ", ";
									}

									r.resultados = g4.g4e2(r.entradas);

									respuestaTemporal = respuestaTemporal.substring(0, respuestaTemporal.length() - 2);
									respuestaTemporal += "\n\npromedio de valores ingresados: "
											+ String.format("%.2f", r.resultados[0]) + "\nvalores mayores al promedio: "
											+ (int) r.resultados[1] + "\n";
									respuestaTemporal += "valores menores al promedio: " + (int) r.resultados[2]
											+ "\n-----------------------------------------------------------------------------------------------------------------------------";

									System.out.println(respuestaTemporal);
									break;
								case 3:
									longitud = 10;
									String[] nombres = new String[longitud];
									float[] pesos = new float[longitud];
									float[] estaturas = new float[longitud];

									//r.tipoOpcion = "peso";
									r.rangoInicial = 1f;

									for (int i = 0; i < longitud; i++) {

										System.out.println("\n\t\tEmpleado " + (i + 1) + ": ");

										do {
											System.out.print("\ningrese nombre: ");
											r.temp = in.next();

											if (r.temp.trim().equalsIgnoreCase(null))
												System.out.println(
														"\n*******************************\n¡no debe quedar el nombre vacio!\n*******************************\n");

										} while (r.temp.trim().equalsIgnoreCase(null));
										nombres[i] = r.temp;

										System.out.print("ingrese peso (kg): ");
										r.temp = in.next();
										pesos[i] = r.verificarValor(r.temp, r.rangoInicial, null);

										//r.tipoOpcion = "estatura";
										System.out.print("ingrese estatura (mt): ");
										r.temp = in.next();
										estaturas[i] = r.verificarValor(r.temp, r.rangoInicial, null);

									}
									System.out.println("\n\t\tReporte de Personas\n");

									System.out.println("Nombre\t\tpeso\testatura\n________________________________\n");

									respuestaTemporal = "";

									for (int i = 0; i < longitud; i++) {

										respuestaTemporal += String.format("%s\t\t%.2f\t%.2f\n", nombres[i], pesos[i],
												estaturas[i]);
									}

									r.resultados = g4.g4e3(nombres, pesos, estaturas);

									respuestaTemporal += String.format(
											"\nPromedio Peso: %.2f\nPromedio Estatura: %.2f\n", r.resultados[0],
											r.resultados[1]);
									System.out.println(respuestaTemporal);
									break;
								case 4:
									//r.tipoOpcion = "valor";
									longitud = 3;
									a = new int[longitud];
									b = new int[longitud];
									contArreglo = 0;
									contIndice = 0;

									do {

										if (contArreglo == 0) {
											System.out.println("\n\t\tARREGLO A");
										} else if (contArreglo == 1) {
											System.out.println("\n\t\tARREGLO B");
										}

										for (contIndice = 0; contIndice < longitud; contIndice++) {

											if (contIndice == 0)
												System.out.print("\ningrese valor en indice " + contIndice + ": ");
											else
												System.out.print("ingrese valor en indice " + contIndice + ": ");
											r.temp = in.next();

											if (contArreglo == 0) {

												a[contIndice] = (int) r.verificarValor(r.temp);

											} else if (contArreglo == 1) {

												b[contIndice] = (int) r.verificarValor(r.temp);
											}
										}

										contArreglo++;

									} while (contArreglo < 2);

									c = g4.g4e4(a, b);

									respuestaTemporal = "\n----------------------\n";

									for (int i = 0; i < longitud; i++)
										respuestaTemporal += "[" + a[i] + "] * [" + b[i] + "] = [" + c[i] + "]\n";

									respuestaTemporal += "----------------------";
									System.out.println(respuestaTemporal);

									break;
								case 5:
									longitud = 1;
									empleados = new ArrayList<Empleado>();
									Empleado empleado = null;
									//r.tipoOpcion = "nombre";
									r.rangoInicial = 1f;
									String[] datos;

									for (int i = 0; i < longitud; i++) {

										empleado = new Empleado();

										System.out.println("\n\t\tEmpleado " + (i + 1) + ": ");

										do {
											System.out.print("\ningrese nombre: ");
											r.temp = in.next();
											in.nextLine();

											if (r.temp.trim().length() < 3)
												System.out.print(
														"\n********************************************\n¡el nombre debe contener 3 o mas caracteres!\n********************************************\n");

										} while (r.temp.trim().length() < 3);
										empleado.setNombre(r.temp);

										//r.tipoOpcion = "edad";
										r.rangoInicial = 1f;
										System.out.print("ingrese edad del empleado: ");
										r.temp = in.next();
										empleado.setEdad((int) r.verificarValor(r.temp, r.rangoInicial, null));

										r.rangoInicial = 0;
										//r.tipoOpcion = "horasTrabajadas";
										r.rangoInicial = 0;
										System.out.print("ingrese horas trabajadas: ");
										r.temp = in.next();
										empleado.setHorastrabajadas(r.verificarValor(r.temp, r.rangoInicial, null));

										//r.tipoOpcion = "valorHora";
										System.out.print("ingrese valor hora: ");
										r.rangoInicial = Empleado.SUELDO_MINIMO / Empleado.HORAS_LEGALES;
										r.temp = in.next();
										empleado.setValorHora(r.verificarValor(r.temp, r.rangoInicial, null));

										empleados.add(empleado);

									}

									/*
									 * Empleado[] emps = new Empleado[5];
									 * 
									 * for(int i=0;i<5;i++) emps[i] = new Empleado();
									 * 
									 * emps[0].setNombre("oscar"); emps[0].setEdad(39);
									 * emps[0].setValorHora(3500.600f); emps[0].setHorastrabajadas(192.4f);
									 * emps[0].setSueldo(g4.obtenerSueldo(emps[0].getHorastrabajadas(),emps[0].
									 * getValorHora()));
									 * 
									 * emps[1].setNombre("juan"); emps[1].setEdad(29);
									 * emps[1].setValorHora(2850.20f); emps[1].setHorastrabajadas(120.4f);
									 * emps[1].setSueldo(g4.obtenerSueldo(emps[1].getHorastrabajadas(),emps[1].
									 * getValorHora()));
									 * 
									 * emps[2].setNombre("jose"); emps[2].setEdad(31);
									 * emps[2].setValorHora(3565.45f); emps[2].setHorastrabajadas(170f);
									 * emps[2].setSueldo(g4.obtenerSueldo(emps[2].getHorastrabajadas(),emps[2].
									 * getValorHora()));
									 * 
									 * 
									 * emps[3].setNombre("pedro"); emps[3].setEdad(21); emps[3].setValorHora(4000f);
									 * emps[3].setHorastrabajadas(210f);
									 * emps[3].setSueldo(g4.obtenerSueldo(emps[3].getHorastrabajadas(),emps[3].
									 * getValorHora()));
									 * 
									 * emps[4].setNombre("peter"); emps[4].setEdad(24); emps[4].setValorHora(2967f);
									 * emps[4].setHorastrabajadas(120.6f);
									 * emps[4].setSueldo(g4.obtenerSueldo(emps[4].getHorastrabajadas(),emps[4].
									 * getValorHora()));
									 * 
									 * empleados.add(emps[0]); empleados.add(emps[1]); empleados.add(emps[2]);
									 * empleados.add(emps[3]); empleados.add(emps[4]);
									 * 
									 */

									System.out.println("\ncantidad de empleados: " + empleados.size());

									System.out.println("\n\t\tReporte de Empleados\n");

									System.out.println("Nombre\t\tedad\tsueldo\n________________________________\n");

									respuestaTemporal = "";

									for (Empleado emp : empleados) {

										respuestaTemporal += String.format("%s\t\t%d\t%.2f\n", emp.getNombre(),
												emp.getEdad(), emp.getSueldo());
									}

									datos = g4.g4e5(empleados);

									respuestaTemporal += String.format(
											"\nTOTAL SUELDOS: %.2f\nEmpleado con Mayor sueldo: %s\nSueldo del empleado que gana mas: %.2f\nEdad del empleado que gana mas: %s",
											Float.parseFloat(datos[0]), datos[1], Float.parseFloat(datos[2]), datos[3]);
									System.out.println(respuestaTemporal);
									break;
								case 6:
									int[][] cuadrado = { { 2, 1, 3 }, { 6, 7, 9 }, { 5, 4, 8 } };

									System.out.println();
									for (int[] filas : cuadrado) {

										for (int v : filas) {

											System.out.print("[" + v + "] ");
										}
										System.out.println();
									}

									System.out.println((g4.g4e6(cuadrado)) ? "\nfelicitaciones es un cuadrado magico"
											: "\nlo sentimos, no es un cuadrado magico");
									break;
								case 7:

									int filas = 5;
									int columnas = 3;
									nombres = new String[filas];
									int[][] productos = new int[filas][columnas];
									int[][] produccion = null;
									String resultado = "";
									int sueldoMayor = 0;
									String nombreProducto = null;
									int idProducto = 0;

									for (int i = 0; i < filas; i++) {

										do {
											System.out.print("\nnombre producto " + (i + 1) + ": ");
											r.temp = in.next();

										} while (r.temp.length() == 0);

										nombres[i] = r.temp;

										for (int j = 0; j < columnas; j++) {

											r.rangoInicial = 0;
											//r.tipoOpcion = "valor";

											System.out.print("cantidad producida en turno " + (j + 1) + ": ");
											r.temp = in.next();
											productos[i][j] = (int) r.verificarValor(r.temp, (int) r.rangoInicial,
													null);
										}
									}
									System.out.println(
											"\n\t\t\tReporte diario de Produccion\nNombre\t\tTurno 1\tTurno 2\tTurno 3\tProd. Dia");
									produccion = g4.g4e7(productos);

									System.out.println("______________________________________________________");

									for (int i = 0; i < filas; i++) {

										resultado += String.format("\n%s\t\t%d\t%d\t%d\t%d", nombres[i],
												produccion[i][0], produccion[i][1], produccion[i][2], produccion[i][3]);

										if (produccion[i][3] > sueldoMayor) {
											sueldoMayor = produccion[i][3];
											idProducto = i;
											nombreProducto = nombres[i];
										}

									}
									resultado += String.format("\nTOTAL\t\t%d\t%d\t%d\t%d\n", produccion[2][0],
											produccion[2][1], produccion[2][2], produccion[2][3]);
									resultado += String.format(
											"\nArticulo con mayor produccion: %s\nProduccion del articulo: %d\n",
											nombreProducto, sueldoMayor);
									System.out.println(resultado);
									break;
								}
								break;
							/*
							 * default: System.out.println("\nes el nuevo 5");
							 * System.out.print("\n¿Realmente desea salir del sistema? (s|n): ");
							 * 
							 * r.temp = r.verficarRespuesta(in.next());
							 * 
							 * if (r.temp.equalsIgnoreCase("s")) break; else r.opcionGuia = 0; break;
							 */
							}
							// fin switch

							if (r.opcionEjercicio < r.finEjercicio || r.opcionEjercicio >= r.inicioEjercicio) {

								r.opcionVarios = OpcionesTipo.OTROS_VALORES;
								r.validarRespuesta();

								if (r.respuesta.equalsIgnoreCase("n")) {
									r.continuarEjercicio = false;
									r.opcionEjercicio = 0;
								}

							}
						}
					}

				}while (r.continuarGuia);
				;
			}
		} while (r.continuarJuego);

		System.out.println("\nDesarrollado por Oscar Pino 2023");
	}
	
	/**	 
	 * @return Devuelve el indice del ejercicio final de cada guia.
	 */

	public int obtenerFinalEjercicio() {

		int nuevo = 0;

		switch (opcionGuia) {

		case 1:
			nuevo = 13;
			break;
		case 2:
			nuevo = 22;
			break;
		case 3:
			nuevo = 19;
			break;
		case 4:
			nuevo = 8;
			break;
		}
		return nuevo;
	}
	
	/**
	 * Verifica que la respuesta sea correcta (s ó n).
	 */

	public void verficarRespuesta() {

		String respuesta = this.respuesta;

		while (!respuesta.equalsIgnoreCase("s") && !respuesta.equalsIgnoreCase("n")) {			

				mostrarMenu(opcionMenu);

				System.out.print(
						"\n***************************\ningrese opcion valida (s|n)\n***************************\n");

				obtenerMensaje();

				respuesta = in.next();
			}
		
		this.respuesta = respuesta;
	}

	/*
	 * public String verficarRespuesta(String dato, String mensaje) {
	 * 
	 * String respuesta = dato;
	 * 
	 * while (!respuesta.equalsIgnoreCase("s") && !respuesta.equalsIgnoreCase("n"))
	 * {
	 * 
	 * if (!respuesta.equalsIgnoreCase("s") && !respuesta.equalsIgnoreCase("n")) {
	 * 
	 * mostrarMenu(//tipoOpcion);
	 * 
	 * System.out.print(
	 * "\n***************************\ningrese opcion valida (s|n)\n***************************\n"
	 * ); System.out.print(mensaje); respuesta = in.next(); }
	 * 
	 * } return respuesta; }
	 */

	/**
	 * Muestra los distintos tipos de menu que se muestran en el programa
	 * @param tipo de menu a mostrar.
	 */
	public void mostrarMenu(OpcionesTipo tipo) {

		String salida = null;

		if (tipo.equals(OpcionesTipo.OPCION_GUIA)) {

			salida = "\n-----------\n1. Guia 1\n2. Guia 2\n3. Guia 3\n4. Guia 4\n5. salir\n-----------\n";

		} else if (tipo.equals(OpcionesTipo.OPCION_EJERCICIO)) {

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
		System.out.print(salida);
	}
	
	/**
	 * 
	 * @param valor a verificar el tipo de dato
	 * @return Devuelve true si valor es numerico, false en caso contrario.
	 */

	public boolean isNum(String valor) {

		try {

			Float.parseFloat(valor);
			return true;

		} catch (Exception e) {

			return false;
		}
	}
	
	/**
	 * Verifica que el valor ingresado, corresponda al formato correcto.
	 * @param valor debe corresponder a un tipo numerico.
	 * @return devuelve el valor numerico ingresado a un tipo de dato float.
	 */

	public float verificarValor(String valor) {

		float nuevoValor = 0;
		String textoNumerico = valor;

		while (!isNum(textoNumerico)) {
			
				mostrarMenu(opcionMenu);
				System.out.println("\n********************\ningrese solo numeros\n********************");
			
				opcionVarios = OpcionesTipo.VALOR;
				
				obtenerMensaje();				
				textoNumerico = in.next();
		}
		nuevoValor = Float.parseFloat(textoNumerico);

		return nuevoValor;
	}
	
	/**
	 * Verifica que el valor ingresado, corresponda al formato correcto y al rango correcto.
	 * @param valor debe corresponder a un tipo numerico
	 * @param rangoMinimo valor minimo que debe ingresar el usuario
	 * @param rangoMaximo valor maximo que debe ingresar el usuario
	 * @return devuelve el valor numerico ingresado a un tipo de dato float
	 */

	public float verificarValor(String valor, Number rangoMinimo, Number rangoMaximo) {

		float nuevoValor = verificarValor(valor);
		String textoNumerico = null;
		opcionVarios = OpcionesTipo.VALOR;

		if (rangoMinimo != null && rangoMaximo == null) {

			while (nuevoValor < rangoMinimo.floatValue() || (int) nuevoValor < rangoMinimo.intValue()) {

				mostrarMenu(opcionMenu);

				if (rangoMinimo instanceof Integer)
					System.out.println("\n***********************************\ningrese un valor mayor o igual a "
							+ (int) rangoMinimo + "\n***********************************");
				else
					System.out.println("\n***********************************\ningrese un valor mayor o igual a "
							+ rangoMinimo + "\n***********************************");

				obtenerMensaje();
				textoNumerico = in.next();
				nuevoValor = verificarValor(textoNumerico);
			}

		} else if (rangoMinimo == null && rangoMaximo != null) {

			while (nuevoValor > rangoMaximo.floatValue() || (int) nuevoValor > rangoMaximo.intValue()) {

				mostrarMenu(opcionMenu);

				if (rangoMinimo instanceof Integer)
					System.out.println("\n***********************************\ningrese un valor menor o igual a "
							+ (int) rangoMaximo + "\n***********************************");
				else
					System.out.println("\n***********************************\ningrese un valor menor o igual a "
							+ rangoMaximo + "\n***********************************");

				obtenerMensaje();
				textoNumerico = in.next();
				nuevoValor = verificarValor(textoNumerico);
			}
		} else {

			while ((int) nuevoValor < rangoMinimo.intValue() || (int) nuevoValor > rangoMaximo.intValue()
					|| nuevoValor < rangoMinimo.floatValue() || nuevoValor > rangoMaximo.floatValue()) {

				mostrarMenu(opcionMenu);

				if (rangoMinimo instanceof Integer && rangoMaximo instanceof Float)
					System.out.println(
							"\n********************************************\ningrese un valor dentro del rango ["
									+ rangoMinimo.intValue() + " - " + rangoMaximo.floatValue() + "]"
									+ "\n********************************************");
				else if (rangoMinimo instanceof Float && rangoMaximo instanceof Integer)
					System.out.println(
							"\n********************************************\ningrese un valor dentro del rango ["
									+ rangoMinimo.floatValue() + " - " + rangoMaximo.intValue() + "]"
									+ "\n********************************************");
				else if (rangoMinimo instanceof Integer && rangoMaximo instanceof Integer)
					System.out
							.println("\n******************************************\ningrese un valor dentro del rango ["
									+ rangoMinimo.intValue() + " - " + rangoMaximo.intValue() + "]"
									+ "\n******************************************");
				else
					System.out.println(
							"\n**********************************************\ningrese un valor dentro del rango ["
									+ rangoMinimo.floatValue() + " - " + rangoMaximo.floatValue() + "]"
									+ "\n**********************************************");

				obtenerMensaje();
				textoNumerico = in.next();
				nuevoValor = verificarValor(textoNumerico);
			}
		}

		return nuevoValor;
	}

	/*
	 * public float verificarValor(String valor, Number rangoMinimo, Number
	 * rangoMaximo) {
	 * 
	 * float nuevoValor = verificarValor(valor); String textoNumerico = valor;
	 * 
	 * if (rangoMinimo != null && rangoMaximo == null) {
	 * 
	 * while (nuevoValor < rangoMinimo.floatValue() || (int)nuevoValor <
	 * rangoMinimo.intValue()) {
	 * 
	 * mostrarMenu(//tipoOpcion);
	 * 
	 * if (rangoMinimo instanceof Integer) System.out.
	 * println("\n*****************************\ningrese un valor mayor o igual a" +
	 * (int)rangoMinimo + "\n*****************************\n"); else System.out.
	 * println("\n*****************************\ningrese un valor mayor o igual a" +
	 * rangoMinimo + "\n*****************************\n");
	 * 
	 * obtenerMensaje(); textoNumerico = in.next(); nuevoValor =
	 * verificarValor(textoNumerico); }
	 * 
	 * } else if (rangoMinimo == null && rangoMaximo != null) {
	 * 
	 * while (nuevoValor > rangoMaximo.floatValue() || (int)nuevoValor >
	 * rangoMaximo.intValue()) {
	 * 
	 * mostrarMenu(//tipoOpcion);
	 * 
	 * if (rangoMinimo instanceof Integer) System.out.
	 * println("\n*****************************\ningrese un valor menor o igual a" +
	 * (int)rangoMaximo + "\n*****************************\n"); else System.out.
	 * println("\n*****************************\ningrese un valor menor o igual a" +
	 * rangoMaximo + "\n*****************************\n");
	 * 
	 * obtenerMensaje(//tipoOpcion); textoNumerico = in.next(); nuevoValor =
	 * verificarValor(textoNumerico); } }else {
	 * 
	 * while ((int)nuevoValor < rangoMinimo.intValue() || (int)nuevoValor >
	 * rangoMaximo.intValue() || nuevoValor < rangoMinimo.floatValue() || nuevoValor
	 * > rangoMaximo.floatValue()) {
	 * 
	 * mostrarMenu(//tipoOpcion);
	 * 
	 * if (rangoMinimo instanceof Integer) System.out.
	 * println("\n*****************************\ningrese un valor dentro del rango ["
	 * +rangoMinimo.intValue()+" - "+rangoMaximo.intValue()+"]" +
	 * "\n*****************************\n"); else System.out.
	 * println("\n*****************************\ningrese un valor dentro del rango ["
	 * +rangoMinimo.floatValue()+" - "+rangoMaximo.floatValue()+"]" +
	 * "\n*****************************\n");
	 * 
	 * obtenerMensaje(//tipoOpcion); textoNumerico = in.next(); nuevoValor =
	 * verificarValor(textoNumerico); } }
	 * 
	 * return nuevoValor; }
	 */
	
	/**
	 * 
	 * Se obtiene el mensaje que solicita el dato al usuario
	 */
	public void obtenerMensaje() {			
		
		if(menusActivos[0] || menusActivos[1])
			System.out.print(opcionMenu.getMensajeOpcion());
		else
			System.out.print(opcionVarios.getMensajeOpcion());	
		
		
	}
//	
//	public Number obtenerTipo(Number tipo) {
//		
//		if(tipo.getClass().getSimpleName().equals("Float") || tipo.getClass().getSimpleName().equals("Double"))
//			return tipo.floatValue();
//		else
//			return tipo.intValue();
//	}	
	
	/**
	 * 
	 * @param args
	 */
	
	public void validarRespuesta() {		
	
		obtenerMensaje();
		respuesta = in.next();
		verficarRespuesta();
	}
	
	/**
	 * 
	 * @param args
	 */
	
	public void solicitarOpcion(OpcionesTipo tipo) {

		mostrarMenu(tipo);
		obtenerMensaje();
		temp = in.next();
		
		if (tipo.equals(OpcionesTipo.OPCION_GUIA))
			opcionGuia = (int) verificarValor(temp, inicioMenu, finMenu);		
		else if (tipo.equals(OpcionesTipo.OPCION_EJERCICIO))
			opcionEjercicio = (int) verificarValor(temp, inicioEjercicio, finEjercicio);		

	}

	private int[]  generaArrayAleatorioPorRango(int rangoMinimo, int rangoMaximo, int longitud) {

// tener en cuenta que la longitud solicitada, debe ser la misma cantidad que se da en el rango elegido
		
		int contador = 0;
		int[] arreglo = new int[longitud];
		int semilla = rangoMaximo - rangoMinimo + 1;
		
		do {

			int i = 0;
			int n = rd.nextInt(semilla)+rangoMinimo;

			for (i = 0; i < contador; i++) {
				
				if (arreglo[i] == n) // se evitan valores duplicados
					break;
			}

			if (i == contador) // indice 0 nunca sera 0								 
				arreglo[contador++] = n;

		} while (contador < longitud);
		
		return arreglo;
	}
	
}

