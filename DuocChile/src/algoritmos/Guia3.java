package algoritmos;

import java.util.ArrayList;

public class Guia3 {

	public String g3e1() {
		
		String r = "";
		int c = 0;
		
		for(int i = 100; i<251; i++) {
			
			if(i % 2 == 0) {
				
				if(i < 250)
					r += (i+", \n");
				else
					r += i;
				
				c++;
			}
		}
		
		r += "\ncantidad de pares: "+c;
		return r;
	}
	
	public String g3e2(int n1, int n2) {
		
		String r = "";
		int inicio = n1;
		int fin = n2;
		int c = 0;
		
		if(n1 > n2) {
			
			inicio = n2;
			fin = n1;
		}
		
		for(int i = inicio; i<=fin; i++) {
			
			if(i % 2 != 0) {
				
				if(i <= fin)
					r += (i+", \n");
				c++;
			}
		}
		
		r=r.substring(0, r.length()-3);
		r += "\nrango ["+((inicio>fin)?fin:inicio)+" | "+((fin>inicio)?fin:inicio)+"] cantidad de numeros impares ingresados: "+c;
		return r;
	}
	
	public String g3e3() {
		
		String r = "";
		int c = 0;
		
		for(int i=11; i<=11*25; i+=11) {
			r+=(i+",\n");
			c++;
		}
		
		return r.substring(0, r.length()-2)+"\nmultiplos de 11 contabilizados: "+c;
	}
	
	public String g3e4() {
		
		String r = "";
		int c = 0;
		
		for(int i=8; i<=500; i+=8) {
			r+=(i+",\n");
			c++;
		}
		
		return r.substring(0, r.length()-2)+"\nmultiplos de 8 contabilizados: "+c;
	}
	
	public float g3e5(ArrayList<Float> alturas)	{
		
		float suma = 0;
		
		for(float tall : alturas)
			suma += tall;
		
		return suma / alturas.size();
	}
	
	public String g3e6(int tabla) {
		
		String respuesta = "";
		
		respuesta = "***************\n";
		
		for(int i=1; i<21; i++) {
			
			respuesta+=tabla+" * "+i+" = "+(i*tabla)+"\n";
		}
		
		respuesta += "***************";
		
		return respuesta;
	}
	
public String g3e7(int n1, int n2) {
		
		String r = "";
		int inicio = n1;
		int fin = n2;
		int c = 0;
		
		if(n1 > n2) {
			
			inicio = n2;
			fin = n1;
		}
		
		for(int i = inicio; i<=fin; i++) {
			
			if(i % 3 == 0 && i != 0) {
				
				if(i <= fin)
					r += (i+", \n");
				
				c++;
			}
		}
		
		r=r.substring(0, r.length()-3);
		r += "\nrango ["+((inicio>fin)?fin:inicio)+" | "+((fin>inicio)?fin:inicio)+"] cantidad de multiplos de 3: "+c;
		return r;
	}

	// cantidades[0] = agudo, cantidades[1] = concavo, cantidades[2] = llano, cantidades[3] = obtuso, cantidades[4] = recto
	public int[] g3e8(float angulo) {
		
		int[] cantidades = new int[5];
		
		if(angulo > 180 && angulo < 360)
			cantidades[1]++;
		else if(angulo == 180)
			cantidades[2]++;
		else if(angulo > 90 && angulo < 180)
			cantidades[3]++;
		else if(angulo == 90)
			cantidades[4]++;
		else
			cantidades[0]++;
		
		return cantidades;
			
	}
	
	// cuentas[0] = negativos, cuentas[1] = positivos, cuentas[2] = multiplos de 15, cuentas[3] = suma de pares
	public int[] g3e9(int[] valores) {
		
		int[] cuentas = new int[4];
		int sumaPares = 0;
		
		for(int n : valores) {
			
			if(n < 0)
				cuentas[0]++;
			else
				cuentas[1]++;
			
			if(n % 15 == 0)
				cuentas[2]++;
			
			if(n % 2 == 0)
				cuentas[3]+=n;
				
		}
		
		return cuentas;
	}
	
	//datos[] => 0 = cantidad de ingresados, 1 = hombres ingresados, 2 = mujeres ingresadas, 3 = promedio edad ingresados, 4 = promedio edad hombres, 5 = promedio edad mujeres,   
	public float[] g3e10(int[] edad, char[] genero) {
		
		// edades[] => 0=edad general, 1=edad hombres, 2=edad mujeres
		float[] edades = new float[3];
		float[] datos = new float[6];
		
		for(int i=0; i<edad.length; i++) {
		
		if(edad[i] >= 18) {
			
			datos[0]++;
			
			if(genero[i] == 'm') {
				datos[1]++;
				edades[1] += edad[i];
			}
			else if(genero[i] == 'f') {
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
	
	public String g3e11(String nombre, String departamento, float sueldo) {
		
		return null;
	}
}
