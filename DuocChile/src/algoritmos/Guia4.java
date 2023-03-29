package algoritmos;

import java.util.ArrayList;

import entidad.Empleado;
import entidad.Persona;

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
	public String[][] g4e3(Persona[] personas) {

		String[][] datos = new String[10][3];

		for (int i = 0; i < personas.length; i++) {
			datos[i][0] = personas[i].getNombre();
			datos[i][1] = String.valueOf(personas[i].getPesoKg());
			datos[i][2] = String.valueOf(personas[i].getAlturaMt());
		}

		return datos;
	}

	public int[] g4e4(int[] a1, int[] a2) {

		int[] r = new int[a1.length];

		for (int i = 0; i < a1.length; i++)
			r[i] = a1[i] * a2[i];

		return r;
	}

	// nombre, edad, horasTrabajadas, valorHora
	public Empleado[] g4e5(Empleado[] empleados) {
		
		Empleado[] calculados = empleados;
		
		int i = 0;
		
		for(Empleado emp : calculados) {
			
			emp.setSueldo(obtenerSueldo(emp.getHorastrabajadas(), emp.getValorHora()));
			
			if(emp.getHorastrabajadas() > 180)
				emp.setHorasExtras(emp.getHorastrabajadas() - 180);
			i++;
		}
	return calculados;

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
	
	public ArrayList<float[]> g4e7(int[][] cantidades) {
		
		float[] sumaPromedios = new float[cantidades.length];
		float[] promedios = new float[cantidades.length];
		float[] turnos = new float[cantidades[0].length];
		ArrayList<float[]> valores = new ArrayList<float[]>();	
		
		for(int i=0;i<cantidades.length;i++) {
			
			for(int j=0;j<cantidades[0].length;j++) {					
				
				if(j==0)
				turnos[0] += cantidades[i][0];
				
				if(j==1)
				turnos[1] += cantidades[i][1];
				
				if(j==2)
				turnos[2] += cantidades[i][2]; 
				
				sumaPromedios[i] += cantidades[i][j];				
			}
		}
		
		for(int k=0;k<sumaPromedios.length;k++)
			promedios[k] = sumaPromedios[k] / 3f;			
			
			valores.add(promedios);
			valores.add(turnos);
			
		
		return valores;
	}

	private float obtenerSueldo(float horasTrabajadas, float valorHora) {

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
