package entidades.guias;

import java.util.ArrayList;

import entidades.Empleado;

public class Guia4 {

	public int[] g4e1(int[] a1, int[] a2) {

		int[] r = new int[a1.length];

		for (int i = 0; i < a1.length; i++)
			r[i] = a1[i] + a2[i];

		return r;
	}

	// r[] => 0: promedio, 1: mayores, 2: menores
	public float[] g4e2(float[] valores) {

		float suma = 0;
		float[] r = new float[3];

		for (float v : valores)
			suma += v;

		r[0] = suma / (float) valores.length;

		for (float v : valores) {

			if (v > r[0])
				r[1]++;
			else if (v < r[0])
				r[2]++;
		}

		return r;
	}

	// datos[] => 0: nombre, 1: peso, 2: altura
	public float[] g4e3(String[] nombres, float[] pesos, float[] alturas){//Persona[] personas) {

		float[] datos = new float[2];
		float promedioPeso = 0;
		float promedioEstatura = 0;

		for (int i = 0; i < nombres.length; i++) {			
			
			promedioPeso += pesos[i];
			promedioEstatura += alturas[i];
		}
		
		datos[0] = (float)promedioPeso / pesos.length;
		datos[1] = (float)promedioEstatura / alturas.length;

		return datos;
	}

	public int[] g4e4(int[] a1, int[] a2) {

		int[] r = new int[a1.length];

		for (int i = 0; i < a1.length; i++)
			r[i] = a1[i] * a2[i];

		return r;
	}

	// datos[] => 0: sueldos totales, 1: nombre, 2: sueldoEmpleado, 3: edad
	public String[] g4e5(ArrayList<Empleado> empleados) {
		
		float totalSueldos = 0;
		float sueldoMayor = 0;
		String[] datos = new String[4];
		int id = 0;
		
		for(int i=0;i<empleados.size();i++) {		
			
			empleados.get(i).setSueldo(obtenerSueldo(empleados.get(i).getHorastrabajadas(), empleados.get(i).getValorHora()));
			
			if(empleados.get(i).getSueldo() > sueldoMayor) {
				sueldoMayor = empleados.get(i).getSueldo();
				id = i;
			}
			
			totalSueldos += empleados.get(i).getSueldo();
		}
		
		datos[0] = String.valueOf(totalSueldos);
		datos[1] = empleados.get(id).getNombre();
		datos[2] = String.valueOf(empleados.get(id).getSueldo());
		datos[3] = String.valueOf(empleados.get(id).getEdad());
		
	return datos;

	}

	public boolean g4e6(int[][] cuadrado) {

		boolean[] aciertos = new boolean[8];
		boolean magico = true;

		aciertos[0] = (cuadrado[0][0] + cuadrado[0][1] + cuadrado[0][2] == 15);
		aciertos[1] = (cuadrado[1][0] + cuadrado[1][1] + cuadrado[1][2] == 15);
		aciertos[2] = (cuadrado[2][0] + cuadrado[2][1] + cuadrado[2][2] == 15);

		aciertos[3] = (cuadrado[0][0] + cuadrado[1][0] + cuadrado[2][0] == 15);
		aciertos[4] = (cuadrado[0][1] + cuadrado[1][1] + cuadrado[2][1] == 15);
		aciertos[5] = (cuadrado[0][2] + cuadrado[1][2] + cuadrado[2][2] == 15);

		aciertos[6] = (cuadrado[0][0] + cuadrado[1][1] + cuadrado[2][2] == 15);
		aciertos[7] = (cuadrado[0][2] + cuadrado[1][1] + cuadrado[2][0] == 15);

		for (boolean invalido : aciertos) {
			if (!invalido) {
				magico = false;
				break;
			}
		}

		return magico;
	}
	
	public int[][] g4e7(int[][] valores) {

		int filaAntigua = valores.length;
		int columnaAntigua = valores[0].length;
		int filaNueva = filaAntigua+1;
		int columnaNueva = columnaAntigua+1;
		int[][] resultados = new int[filaNueva][columnaNueva];
		int i = 0;
		int j = 0;
		int valorFila = 0;
		int valorColumna = 0;
		
		for (i = 0; i < filaAntigua; i++) {

			for (j = 0; j < columnaAntigua; j++) {

				// llenando matriz nueva, con los valores de matriz antigua
				resultados[i][j] = valores[i][j];
				
				// sumando valores individuales de cada fila
				resultados[i][columnaAntigua] += resultados[i][j];				
				
				// sumando valores individuales de cada columna
				resultados[filaAntigua][j] += resultados[i][j];
				
				// total de valores individuales de cada fila
				if(j == columnaAntigua-1)
					valorFila += resultados[i][columnaAntigua];
				
				// total de valores individuales de cada columna
				if(i == filaAntigua-1)
					valorColumna += resultados[filaAntigua][j];				
			}			
		}	
		
		if(valorFila == valorColumna)
			resultados[filaAntigua][columnaAntigua] = valorColumna;
		else
			resultados[filaAntigua][columnaAntigua] = -1;
			
		return resultados;
	}

	public float obtenerSueldo(float horasTrabajadas, float valorHora) {

		float horasExtras = 0;
		float sueldo = 0;

		if (horasTrabajadas > 180) {
			horasExtras = horasTrabajadas - Empleado.HORAS_LEGALES;
			sueldo = Empleado.HORAS_LEGALES * valorHora + (valorHora * 2 * horasExtras);
		} else {
			sueldo = horasTrabajadas * valorHora;
		}

		return sueldo;
	}	
}
