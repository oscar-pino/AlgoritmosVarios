package entidades.guias;

import java.util.ArrayList;

import entidades.Empleado;
import entidades.Persona;

public class Guia3 {

	public String g3e1() {
		
		int c = 0;

		String r = "\nvalores pares en el rango (100-250):\n《 ";
		
		for (int i = 100; i <= 250; i++) 
			if(i%2==0) {
				r+=(i)+",";
				c++;
			}

		r = r.substring(0, r.length()-1)+" 》\n";
		r+="cantidad de valores pares en el rango: "+c;
		
		return r;
	}

	public String g3e2(int n1, int n2) {

		String r = "";
		int inicio = n1;
		int fin = n2;
		int c = 0;	
		String temp = "("+inicio+"~"+fin+")";
		
		r += "\nvalores impares en el rango "+temp+":\n《 ";
		
		if (n1 > n2) {

			inicio = n2;
			fin = n1;
		}

		for (int i = inicio; i <= fin; i++) {

			if (i % 2 != 0) {

				if (i <= fin)
					r += (i + ", ");
				c++;
			}
		}

		r = r.substring(0, r.length() - 2)+ " 》\ncantidad de valores impares en el rango "+temp+": " + c;
		return r;
	}

	public String g3e3() {

		String r = "\n《 ";
		int c = 0;

		for (int i = 11; i <= 11 * 25; i += 11) {
			r += (i + ", ");
			c++;
		}

		return r.substring(0, r.length() - 2) + " 》\nmultiplos de 11 contabilizados: " + c;
	}

	public String g3e4() {

		String r = "\n《 ";
		int c = 0;

		for (int i = 8; i <= 500; i += 8) {
			r += (i + ", ");
			c++;
		}

		return r.substring(0, r.length() - 2) + " 》\nmultiplos de 8 contabilizados: " + c;
	}

	public float g3e5(ArrayList<Float> alturas) {

		float suma = 0;

		for (float tall : alturas)
			suma += tall;

		return suma / alturas.size();
	}

	public String g3e6(int tabla) {

		String respuesta = "";

		respuesta = "----------------\n";

		for (int i = 1; i < 21; i++) {

			respuesta += tabla + " * " + i + " = " + (i * tabla) + "\n";
		}

		respuesta += "----------------";

		return respuesta;
	}

	public String g3e7(int n1, int n2) {

		String r = "";
		int inicio = n1;
		int fin = n2;
		int c = 0;
		String temp = "("+inicio+"~"+fin+")";
		
		r += "valores multiplos de 3 en el rango "+temp+":\n《 ";
		if (n1 > n2) {

			inicio = n2;
			fin = n1;
		}

		for (int i = inicio; i <= fin; i++) {

			if (i % 3 == 0 && i != 0) {

				if (i <= fin)
					r += (i + ", ");

				c++;
			}
		}

		r = r.substring(0, r.length() - 2)+ " 》\ncantidad de valores multiplos de 3 : "+ c;

		return r;
	}

	// cantidades[] => 0: agudo, 1: concavo, 2: llano, 3: obtuso, 4: recto
	public float[] g3e8(ArrayList<Float> angulos) {

		float[] cantidades = new float[5];

		for(float angulo : angulos) {
		
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
		}

		return cantidades;

	}

	// cuentas[] => 0: negativos, 1: positivos, 2: multiplos de 15, 3: suma de pares
	public float[] g3e9(float[] valores) {

		float[] cuentas = new float[4];

		for (float n : valores) {

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
	public float[] g3e10(ArrayList<Persona> personas) {
		
		// edades[] => 0: edad general, 1: edad hombres, 2: edad mujeres
				float[] edades = new float[3];
				float[] datos = new float[6];
				boolean[] existenGeneros = new boolean[2]; // 0: hombre, 1: mujer

				for (Persona p : personas) {

					if (p.getEdad() >= 18) {

						datos[0]++;

						if (p.getGenero() == 'm') {
							datos[1]++;
							edades[1] += p.getEdad();
							existenGeneros[0] = true;
						} else {
							datos[2]++;
							edades[2] += p.getEdad();
							existenGeneros[1] = true;
						}

						edades[0] += p.getEdad();					
					}
				}
				datos[3] = (edades[0] / personas.size());
				datos[4] = (existenGeneros[0])?(edades[1] / datos[1]):0;
				datos[5] = (existenGeneros[1])?(edades[2] / datos[2]):0;

				return datos;
	}

	// datos[] => 0: sueldo normal, 1: nuevo sueldo, 2: RR.HH, 3: contabilidad, 4: informatica
	public float[] g3e11(ArrayList<Empleado> empleados) {

		float[] datos = new float[5];
		int[] aumentos = {20,10,5,2};
		float aumento = 0;
		
		for(Empleado e : empleados ) {
			
			datos[0] += e.getSueldo();
			
			if(e.getSueldo() <= 900_000)
				aumento = e.getSueldo()*(aumentos[0]/(float)100);
			else if(e.getSueldo() <= 1_300_000)
				aumento = e.getSueldo()*(aumentos[1]/(float)100);
			else if(e.getSueldo() <= 1_800_000)
				aumento = e.getSueldo()*(aumentos[2]/(float)100);
			else
				aumento = e.getSueldo()*(aumentos[3]/(float)100);	
			
			datos[1] += e.getSueldo() + aumento;
			
			switch(e.getDepartamento().toLowerCase()) {
			
			case "rr.hh":
				datos[2]++;
				break;
			case "contabilidad":
				datos[3]++;
				break;
			case "informatica":
				datos[4]++;
				break;
			}
		}		
		
		return datos;
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
	public float g3e13(int tipo, float cantidadGrados) {

		float resultado = 0;

		if (tipo == 1) { // grados celsius

			resultado = (9f / 5) * cantidadGrados + 32;

		} else if (tipo == 2) { // grados fahrenheit

			resultado = (cantidadGrados - 32) * (5f / 9);
		}

		return resultado;
	}

	// lluviaEnZona[] => 0: zonaA, 1: zonaB, 2: zonaC, 3: zona4, 4: sinLluviaA, 5:
	// sinLluviaB, 6: sinLluviaC, 7: sinLluviaD
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

	// datos[] => 0: cantidad de ventas 1: recaudado tipo 1, 2: recaudado tipo 2, 3: recaudado tipo 3, 4: monto total recaudado
	public long[] g3e15(ArrayList<float[]> fulmigaciones) {

		float porciento = 0;
		long[] datos = new long[5];
		float[] tarifas = { 5_000f, 10_000f, 15_000f };
		float saldoTemporal = 0;
		int tipo = 0;
		float hectareas = 0;
		
		datos[0] = fulmigaciones.size();
		
		for(float[] x : fulmigaciones) {
			
			tipo = (int)x[0];
			hectareas = x[1];
			saldoTemporal = 0;
			porciento = 0;
			
			if (hectareas > 500) 
				porciento = 15f / 100f;
			else if (hectareas > 300) 
				porciento = 10f / 100f;
			else if (hectareas > 100) 
				porciento = 5f / 100f;				
			
			switch (tipo) {

			case 1:
				saldoTemporal = tarifas[0] * (float)hectareas;
				datos[1] += saldoTemporal - saldoTemporal * porciento;
				break;
			case 2:
				saldoTemporal = tarifas[1] * (float)hectareas;
				datos[2] += saldoTemporal - saldoTemporal * porciento;
				break;
			case 3:
				saldoTemporal = tarifas[2] * (float)hectareas;
				datos[3] += saldoTemporal - saldoTemporal * porciento;
				break;
			}						
		}				
		datos[4] = datos[1] + datos[2] + datos[3];
		
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

	// datos[] 0: sueldo a pagar, 1: empleados con horas extras, 2: promedio de horas extras	
	public float[] g3e17(ArrayList<Empleado> empleados){

		final int HORAS_LEGALES = 180;
		float[] datos = new float[3];
		float sumaHorasExtras = 0;
		float horasExtras = 0;
		float adicional = 0;

		for (Empleado e : empleados) {
			
			if (e.getHorastrabajadas() > HORAS_LEGALES) {

				horasExtras = e.getHorastrabajadas() - HORAS_LEGALES;
				sumaHorasExtras += horasExtras;
				datos[1]++;
				
				adicional = (float)horasExtras * e.getValorHora() * 2;
				
				datos[0] += (float) (HORAS_LEGALES * e.getValorHora() + adicional);
			}
			else {
				
				datos[0] += (float) (e.getHorastrabajadas() * e.getValorHora());
			}			
		}		

		datos[2] = (float) sumaHorasExtras / datos[1];

		return datos;
	}	
	
	public ArrayList<float[]> g3e18(float[][] triangulos) {

		ArrayList<float[]> resultados = new ArrayList<float[]>();
		float ca=0, cb=0, hp=0;
		int c = 0;
		int cont = 0;		
			
			for(float[] triangulo : triangulos) {
				
				for(float cateto : triangulo) {
					
					if(c == 0)
						ca = cateto;
					else if(c == 1)
						cb = cateto;
					else
						hp = cateto;	
					
				if(ca != 0 && cb != 0 && hp != 0)
					if(Math.pow(ca, 2)+Math.pow(cb, 2)==Math.pow(hp, 2)) {					
						resultados.add(new float[]{(float)cont,ca,cb,hp});
					}
				
				c++;
					
					if(c == 3)
						c = 0;				
				}
				
				cont++;
			}

		return resultados;
	}
}