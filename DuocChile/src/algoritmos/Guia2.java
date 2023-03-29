package algoritmos;

public class Guia2 {

	public boolean g2e1(int edad) {

		if (edad >= 18)
			return true;
		else
			return false;
	}

	public boolean g2e2(int valor) {

		if (valor % 2 == 0)
			return true;
		else
			return false;
	}

	public float g2e3(float[] notas) {

		float suma = 0;
		float promedio = 0;

		for (float nota : notas)
			suma += nota;

		promedio = (float) suma / notas.length;

		return promedio;

	}

	public float g2e4(String tipoGrados, float cantidadGrados) {

		float resultado = 0;

		if (tipoGrados.equalsIgnoreCase("celsius")) {

			resultado = (9f / 5) * cantidadGrados + 32;

		} else if (tipoGrados.equalsIgnoreCase("fahrenheit")) {

			resultado = (cantidadGrados - 32) * (5f / 9);
		}

		return resultado;
	}
	
	public boolean g2e5(String p1, String p2) {

		return (p1.trim().equalsIgnoreCase(p2.trim())) ? true : false;
	}

	// x[] =>  0:sueldo base, 1: horas extras, 2: sueldo bruto 
	public float[] g2e6(float horasTrabajadas, float valorHora) {

		float horasExtras = 0;
		final int HORAS_LEGALES = 180;
		float sueldoBase = 0;
		float sueldoEmpleado = 0;
		float[] r = new float[3];

		
		if (horasTrabajadas > 180) {

			horasExtras = horasTrabajadas - HORAS_LEGALES;
			sueldoBase = HORAS_LEGALES * valorHora;
			sueldoEmpleado = sueldoBase + (horasExtras * (valorHora * 2));
			
			r[0] = sueldoBase;
			r[1] = horasExtras;
			r[2] = sueldoEmpleado;

		} else {

			sueldoEmpleado = horasTrabajadas * valorHora;
			
			r[0] = sueldoEmpleado;
			r[1] = 0;
			r[2] = sueldoEmpleado;
		}

		return r;		
	}

	// r[] => 0:original, 1: convertido
	public String g2e7(String monedaConvertir, float valorOrigen) {

		float saldo = 0;
		final float VALOR_DOLAR = 826.60f;
		final float VALOR_PESOS = 1f / 826.60f;
		float[] r = new float[2];
		String resultado = null;

		if (monedaConvertir.equalsIgnoreCase("pesos")) {

			saldo = valorOrigen * VALOR_PESOS;
			
			r[0] = valorOrigen;
			r[1] = saldo;

		} else if (monedaConvertir.equalsIgnoreCase("dolar")) {

			saldo = valorOrigen * VALOR_DOLAR;
			
			r[0] = valorOrigen;
			r[1] = saldo;
		}

		return resultado;
	}

	public boolean g2e8(float[] notas) {
		
		float suma = 0;
		float promedioFinal = 0;
		int[] ponderados = new int[3];
		ponderados[0] = 30;
		ponderados[1] = 25;
		ponderados[2] = 20;
		boolean r = false;

		float[] promedios = new float[4];
		promedios[0] = notas[0] * (ponderados[0] / 100);
		promedios[1] = notas[1] * (ponderados[1] / 100);
		promedios[2] = notas[2] * (ponderados[1] / 100);
		promedios[3] = notas[3] * (ponderados[2] / 100);

		for (float n : promedios)
			suma += n;

		promedioFinal = (float) suma / notas.length;

		if (promedioFinal >= 3.95)
			r = true;
		

		return r;

	}

	// opcion => 1: suma, 2: resta, 3: multiplicacion, 4: division
	public float g2e9(int opcion, float n1, float n2) {

		float r = 0;
		
		switch(opcion) {
		
		case 1:
			r = n1 + n2;
			break;
		case 2:
			r = n1 - n2;
			break;
		case 3:
			r = n1 * n2;
			break;
		case 4:
			r = n1 / n2;
			break;
		}
		
		return r;
	}

	public boolean g2e10(float[] angulos) {

		return (angulos[0] + angulos[1] + angulos[2] == 180)?true:false;
	}

	public String g2e11(int diaSemana) {

		String dia = "El numero: " + diaSemana + " corresponde al dia => ";

		switch (diaSemana) {
		case 1:
			dia += "Lunes";
			break;
		case 2:
			dia += "Martes";
			break;
		case 3:
			dia += "Miercoles";
			break;
		case 4:
			dia += "Jueves";
			break;
		case 5:
			dia += "Viernes";
			break;
		case 6:
			dia += "sabado";
			break;
		case 7:
			dia += "Domingo";
			break;
		}
		return dia;
	}

	// 1 = circulo, 2 = radio, 3 = triangulo, datos[0] = radio, datos[1] = base, datos[2] = altura
	public float g2e12(int opcion, float[] datos) {
		
		float area = 0;

		switch(opcion) {
		
		case 1:
			area = (float)(Math.PI * Math.pow(datos[0], 2));
			break;
		case 2:
			area = (float)(datos[1] * datos[2]);
			break;
		case 3:
			area = ((float)(datos[1] * datos[2])/2f);
			break;		
		}
		return area;
	}

	// r[] => 0: p1 +caracteres, 1: p2 +caracteres, 2: iguales caracteres
	public boolean[] g2e14(String p1, String p2) {
		
		boolean[] r = new boolean[3];		
		
		if(p1.trim().length() > p2.trim().length()) 
			r[0] = true;
		else if(p2.trim().length() > p1.trim().length()) 
			r[1] = true;
		else
			r[2] = true;
		
		return r;
		
	}
	
	// r[] 0: n1-mayor, 1: n2-mayor, 2: iguales caracteres
	public boolean[] g2e15(float n1, float n2) {
		
		boolean[] r = new boolean[3];		
		
		if(n1 > n2)
			r[0] = true;
		else if(n2 > n1)
			r[1] = true;
		else
			r[2] = true;
		
		return r;
	}
	
	// r[] 0: a, 1: b, 2: c, 3: x1, 4: x2, 5: det
	public float[] g2e16(float a, float b, float c) {
			
		float determinante = 0;
		float raizDeterminante = 0;
		float[] r = new float[6];
		
		determinante = (float)Math.pow(b,2)-4f*a*c;
		
		if(determinante >= 0) {
			
			raizDeterminante = (float)Math.sqrt((double)determinante);
			r[0] = a;
			r[1] = b;
			r[2] = c;
			r[3] = (-(b)+raizDeterminante)/(float)(2f*a);		
			r[4] = (-(b)-raizDeterminante)/(float)(2f*a);			
		}
		
		r[5] = determinante;
		
		return r;
	}
	
	// genero => f ó m
	public String g2e17(int edad, char genero) {
		
		String respuesta = null;
		
		if(edad >= 18) {
			
			respuesta = (genero == 'm')?"ud. es hombre y debe pagar: $10.000 por entrada":"Ud. es mujer y no debe pagar entrada";
				
		}
		else {
			respuesta = "Ud. no es mayor de edad, tiene prohibido ingresar!";
		}
		
		return respuesta;
	}
	
	public String g2e18(float peso, float altura) {
		
		float imc = 0;
		String respuesta = null;
		
		imc = (float)(peso / (Math.pow(altura, 2)));
		
		if(imc > 40f)
			respuesta = "Obeso: Tipo III";
		else if(imc > 34.99f && imc < 41f)
			respuesta = "Obeso: Tipo II";
		else if(imc > 29.99f && imc < 35f)
			respuesta = "Obeso: Tipo I";
		else if(imc > 24.99f && imc < 30f)
			respuesta = "Sobrepeso";
		else if(imc > 18.49f && imc < 25f)
			respuesta = "Peso Normal";
		else if(imc > 16.49f && imc < 18.50f)
			respuesta = "Infrapeso: delgadez aceptable";
		else if(imc > 15.99f && imc < 17f)
			respuesta = "Infrapeso: delgadez moderada";
		else
			respuesta = "Infrapeso: delgadez severa";
			
			return respuesta;
	}
	
	public float[] g2e19(float[] valores) {
		
		float[] r = new float[3];
		
		if(valores[0] > valores[1] && valores[0] > valores[2]) {
			
			if(valores[1] > valores[2]) {
				
				r[0] = valores[0];
				r[1] = valores[1];
				r[2] = valores[2];
			}
			else {
				
				r[0] = valores[0];
				r[1] = valores[2];
				r[2] = valores[1];
			}
		}
		else if(valores[1] > valores[0] && valores[1] > valores[2]) {
			
			if(valores[0] > valores[2]) {
				
				r[0] = valores[1];
				r[1] = valores[0];
				r[2] = valores[2];
			}
			else {
				
				r[0] = valores[1];
				r[1] = valores[2];
				r[2] = valores[0];
			}
			
		}
		else if(valores[2] > valores[0] && valores[2] > valores[1]) {
			
			if(valores[0] > valores[1]) {
				
				r[0] = valores[2];
				r[1] = valores[0];
				r[2] = valores[1];
			}
			else {
				
				r[0] = valores[2];
				r[1] = valores[1];
				r[2] = valores[0];
			}
			
		}
		return r;
	}
	
	public boolean g2e20(int valor) {
		
		return (valor % 3 == 0 && valor % 2 == 0)?true:false;
	}
	
	// datos[] => 0: a ,1: b ,2: c ,3: d ,4: e ,5: f
	public String g2e21(float[] datos) {
		
		float x = 0;
		float y = 0;
		float t = 0;
		String respuesta = null;
		
		t = datos[0] * datos[4] - datos[1] * datos[3];
		
		if(t == 0)
			respuesta = "El sistema no tiene ecuacion";
		else
		{
			x = ((datos[2] * datos[4]) - (datos[1] * datos[5])) / ((datos[0] * datos[4]) - (datos[1] * datos[3]));
			
			y = ((datos[0] * datos[5]) - (datos[2] * datos[3])) / ((datos[0] * datos[4]) - (datos[1] * datos[3]));
			
			respuesta = "X: "+x+"\nY: "+y;
		}
		return respuesta;		
	}
}