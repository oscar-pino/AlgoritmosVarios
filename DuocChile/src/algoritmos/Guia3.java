package algoritmos;

import java.util.ArrayList;

public class Guia3 {

	public String g3e1() {

		String r = "";
		int c = 0;

		for (int i = 100; i < 251; i++) {

			if (i % 2 == 0) {

				if (i < 250)
					r += (i + ", \n");
				else
					r += i;

				c++;
			}
		}

		r += "\ncantidad de pares: " + c;
		return r;
	}

	public String g3e2(int n1, int n2) {

		String r = "";
		int inicio = n1;
		int fin = n2;
		int c = 0;

		if (n1 > n2) {

			inicio = n2;
			fin = n1;
		}

		for (int i = inicio; i <= fin; i++) {

			if (i % 2 != 0) {

				if (i <= fin)
					r += (i + ", \n");
				c++;
			}
		}

		r = r.substring(0, r.length() - 3);
		r += "\nrango [" + ((inicio > fin) ? fin : inicio) + " | " + ((fin > inicio) ? fin : inicio)
				+ "] cantidad de numeros impares ingresados: " + c;
		return r;
	}

	public String g3e3() {

		String r = "";
		int c = 0;

		for (int i = 11; i <= 11 * 25; i += 11) {
			r += (i + ",\n");
			c++;
		}

		return r.substring(0, r.length() - 2) + "\nmultiplos de 11 contabilizados: " + c;
	}

	public String g3e4() {

		String r = "";
		int c = 0;

		for (int i = 8; i <= 500; i += 8) {
			r += (i + ",\n");
			c++;
		}

		return r.substring(0, r.length() - 2) + "\nmultiplos de 8 contabilizados: " + c;
	}

	public float g3e5(ArrayList<Float> alturas) {

		float suma = 0;

		for (float tall : alturas)
			suma += tall;

		return suma / alturas.size();
	}

	public String g3e6(int tabla) {

		String respuesta = "";

		respuesta = "***************\n";

		for (int i = 1; i < 21; i++) {

			respuesta += tabla + " * " + i + " = " + (i * tabla) + "\n";
		}

		respuesta += "***************";

		return respuesta;
	}

	public String g3e7(int n1, int n2) {

		String r = "";
		int inicio = n1;
		int fin = n2;
		int c = 0;

		if (n1 > n2) {

			inicio = n2;
			fin = n1;
		}

		for (int i = inicio; i <= fin; i++) {

			if (i % 3 == 0 && i != 0) {

				if (i <= fin)
					r += (i + ", \n");

				c++;
			}
		}

		r = r.substring(0, r.length() - 3);
		r += "\nrango [" + ((inicio > fin) ? fin : inicio) + " | " + ((fin > inicio) ? fin : inicio)
				+ "] cantidad de multiplos de 3: " + c;
		return r;
	}

	// cantidades[] => 0: agudo, 1: concavo, 2: llano, 3: obtuso, 4: recto
	public int[] g3e8(float angulo) {

		int[] cantidades = new int[5];

		if (angulo > 180 && angulo < 360)
			cantidades[1]++;
		else if (angulo == 180)
			cantidades[2]++;
		else if (angulo > 90 && angulo < 180)
			cantidades[3]++;
		else if (angulo == 90)
			cantidades[4]++;
		else
			cantidades[0]++;

		return cantidades;

	}

	// cuentas[] => 0: negativos, 1: positivos, 2: multiplos de 15, 3: suma de pares
	public int[] g3e9(int[] valores) {

		int[] cuentas = new int[4];

		for (int n : valores) {

			if (n < 0)
				cuentas[0]++;
			else
				cuentas[1]++;

			if (n % 15 == 0)
				cuentas[2]++;

			if (n % 2 == 0)
				cuentas[3] += n;

		}

		return cuentas;
	}

	// datos[] => 0: cantidad de ingresados, 1: hombres ingresados, 2: mujeres
	// ingresadas, 3: promedio edad ingresados, 4: promedio edad hombres, 5:
	// promedio edad mujeres
	public float[] g3e10(int[] edad, char[] genero) {

		// edades[] => 0: edad general, 1: edad hombres, 2: edad mujeres
		float[] edades = new float[3];
		float[] datos = new float[6];

		for (int i = 0; i < edad.length; i++) {

			if (edad[i] >= 18) {

				datos[0]++;

				if (genero[i] == 'm') {
					datos[1]++;
					edades[1] += edad[i];
				} else if (genero[i] == 'f') {
					datos[2]++;
					edades[2] += edad[i];
				}

				edades[0] += edad[i];

			}
		}
		datos[3] = (edades[0] / edad.length);
		datos[4] = (edades[1] / datos[1]);
		datos[5] = (edades[2] / datos[2]);

		return datos;
	}

	// sueldos[] => 0: sueldo normal, 1: nuevo sueldo
	public float[] g3e11(float sueldo) {

		float[] sueldos = new float[2];
		float porciento = 0;
		float nuevoSueldo = 0;

		if (sueldo > 1_800_000) {

			porciento = 2f / 100;
		} else if (sueldo > 1_300_000 && sueldo <= 1_800_000) {

			porciento = 5f / 100;
		} else if (sueldo > 900_000 && sueldo <= 1_300_000) {

			porciento = 10f / 100;

		} else {

			porciento = 20f / 100;
		}

		nuevoSueldo = sueldo + (sueldo * porciento);

		sueldos[0] = sueldo;
		sueldos[1] = nuevoSueldo;

		return sueldos;

	}

	public float g3e12(float[] notas) {

		float sumas = 0;
		float promedio = 0;

		for (float nota : notas)
			sumas += nota;

		promedio = (float) sumas / notas.length;

		return promedio;
	}

	// datos[] => 0: grados convertidos, 1: cantidad celsius, 2: cantidad fahrenheit
	public float[] g3e13(String[] tipoGrados, float[] cantidadGrados) {

		float[] datos = new float[3];

		for (int i = 0; i < tipoGrados.length; i++) {

			if (tipoGrados[i].equalsIgnoreCase("celsius")) {

				datos[0] = (9f / 5) * cantidadGrados[i] + 32;
				datos[1]++;

			} else if (tipoGrados[i].equalsIgnoreCase("fahrenheit")) {

				datos[0] = (cantidadGrados[i] - 32) * (5f / 9);
				datos[2]++;
			}
		}

		return datos;
	}

	// lluviaEnZona[] => 0: zonaA, 1: zonaB, 2: zonaC, 3: zona4, 4: sinLluviaA, 5:
	// sinLluviaB, 6: sinLluviaC, 5: sinLluviaD
	public float[] g3e14(float[][] zonas) {

		float[] lluviaEnZona = new float[8];
		int[] diaSinLluvia = new int[4];
		int contador = 0;

		for (float[] semana : zonas) {

			for (float dia : semana) {

				lluviaEnZona[contador] += dia;

				if (dia == 0)
					diaSinLluvia[contador]++;
			}

			contador++;
		}

		lluviaEnZona[4] = diaSinLluvia[0];
		lluviaEnZona[5] = diaSinLluvia[1];
		lluviaEnZona[6] = diaSinLluvia[2];
		lluviaEnZona[7] = diaSinLluvia[3];

		return lluviaEnZona;
	}

	// datos[] => 0: saldo de ventas(1), 1: saldo de ventas(2), 2: saldo de
	// ventas(3), 3: cantidad de ventas(1), 4: cantidad de ventas(2), 5: cantidad de
	// ventas(3), 6: saldo final
	public long[] g3e15(int[] tipo, float[] cantidadHectareas) {

		float porciento = 0;
		long[] datos = new long[7];
		float[] tarifas = { 5_000f, 10_000f, 15_000f };
		float saldoTemporal = 0;

		for (int i = 0; i < tipo.length; i++) {

			if (cantidadHectareas[i] > 500) {

				porciento = 15f / 100f;
			} else if (cantidadHectareas[i] > 300) {

				porciento = 10f / 100f;
			} else if (cantidadHectareas[i] > 100) {

				porciento = 5f / 100f;
			}

			switch (tipo[i]) {

			case 1:
				saldoTemporal = tarifas[0] * cantidadHectareas[i];
				datos[0] += (saldoTemporal - (saldoTemporal * porciento));
				datos[3]++;
				break;
			case 2:
				saldoTemporal = tarifas[1] * cantidadHectareas[i];
				datos[1] += (saldoTemporal - (saldoTemporal * porciento));
				datos[4]++;
				break;
			case 3:
				saldoTemporal = tarifas[2] * cantidadHectareas[i];
				datos[2] += (saldoTemporal - (saldoTemporal * porciento));
				datos[5]++;
				break;
			}

		}
		datos[6] = (datos[0] + datos[1] + datos[2]);

		return datos;
	}

	// datos[] 0: aprobados, 1: reprobados, 2: promedio asignatura de programación,
	// 3: total de alumnos contabilizados
	public float[] g3e16(float[] notas) {

		float[] datos = new float[4];
		float suma = 0;

		for (float nota : notas) {

			if (nota >= 4)
				datos[0]++;
			else
				datos[1]++;

			datos[3]++;

			suma += nota;
		}

		datos[2] = (float) (suma / notas.length);

		return datos;
	}

	// datos[] 0: sueldo a pagar, 1: empleados con horas extras, 2: promedio de
	// horas extras
	public float[] g3e17(float[] horasTrabajadas, float[] valorHora) {

		final int HORAS_LEGALES = 180;
		float[] datos = new float[3];
		float sumaHorasExtras = 0;
		float horasExtras = 0;
		float adicional = 0;

		for (int i = 0; i < horasTrabajadas.length; i++) {
			
			if (horasTrabajadas[i] > HORAS_LEGALES) {

				horasExtras = horasTrabajadas[i] - HORAS_LEGALES;
				sumaHorasExtras += horasExtras;
				datos[1]++;
				
				adicional = (float)horasExtras * valorHora[i] * 2;
				
				datos[0] += (float) (HORAS_LEGALES * valorHora[i] + adicional);
			}
			else {
				
				datos[0] += (float) (horasTrabajadas[i] * valorHora[i]);
			}

			
		}		

		datos[2] = (float) sumaHorasExtras / datos[1];

		return datos;
	}
	
	// r[] => 0: si(1) no(2), 1: cateto A, 2: cateto B, 3: hipotenusa
	public double[][] g3e18(double[][] triangulos) {
		
		int filas = triangulos.length;
		double[][] r = new double[filas][4];
		int verificado = 0;
		double catetoA = 0; 
		double catetoB = 0; 
		double hipotenusa = 0; 
		
		for(int i=0;i<triangulos.length;i++) {
			
			verificado = 0;			
			catetoA = Math.pow(triangulos[i][0], 2);
			catetoB = Math.pow(triangulos[i][1], 2);
			hipotenusa = Math.pow(triangulos[i][2], 2);			
					
			if(catetoA+catetoB == hipotenusa)
				verificado = 1;
			
			r[i][0] = verificado;
			r[i][1] = catetoA;
			r[i][2] = catetoB;
			r[i][3] = hipotenusa;
		}
		
		return r;
	}
}
