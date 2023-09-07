package entidades.guias;

public class Guia2 {

	Guia1 g1 = new Guia1();

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

	public boolean g2e3(float promedioFinal) {		

		return promedioFinal >= 4;
	}

	public float g2e4(int tipo, float cantidadGrados) {

		float resultado = 0;

		if (tipo == 1) { // grados celsius

			resultado = (9f / 5) * cantidadGrados + 32;

		} else if (tipo == 2) { // grados fahrenheit

			resultado = (cantidadGrados - 32) * (5f / 9);
		}

		return resultado;
	}

	public boolean g2e5(String p1, String p2) {

		return (p1.trim().equals(p2.trim())) ? true : false;
	}

	// x[] => 0:sueldo base, 1: horas extras, 2: sueldo bruto
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

	public float g2e7(int tipo, float valorOrigen) {

		float saldo = 0;
		final float VALOR_DOLAR = 796.49f;
		final float VALOR_PESOS = 1f / VALOR_DOLAR;
		float convertido = 0;

		if (tipo == 1) {
			saldo = valorOrigen * VALOR_PESOS;
		} else if (tipo == 2) {
			saldo = valorOrigen * VALOR_DOLAR;
		}

		convertido = saldo;

		return convertido;
	}

	// r[] => notas ponderadas 0,1,2,3, 4: promedio ponderado, 5: promedio normal 6: aprobado? 1:si, 0:no
	public float[] g2e8(float[] notas) {
		
		float[] r = new float[7];
		float[] porcientos = {30f,25f,25f,20f};
		float promedioNormal = 0;
		float promedioPonderado = 0;
		int i;
		
		for(float n : notas)
			promedioNormal += n;
		
		promedioNormal /= notas.length; 
		
		for(i=0;i<notas.length;i++) {
			
			r[i] = notas[i] * (porcientos[i] / 100); 
			promedioPonderado += r[i];
		}
		
		r[4] = promedioPonderado;
		r[5] = promedioNormal;	

		r[6] = (promedioPonderado >= 3.95)?1f:0;
		
		return r;
	}

	// r => 0: suma, 1: resta, 2: multiplicacion, 3: division
	public float[] g2e9(float n1, float n2) {

		float[] r = g1.g1e3(n1, n2);

		return r;
	}

	//r => 0: suma de angulos, 1: es triangulo? 0:no, 1:si
	public float[] g2e10(float[] angulos) {

		float[] r = new float[2];
		r[0] = angulos[0] + angulos[1] + angulos[2];
		r[1] = (r[0] == 180) ? 1f : 0;
		
		return r;
	}

	public String g2e11(int diaSemana) {

		String dia = "";

		switch (diaSemana) {
		case 1:
			dia = "lunes";
			break;
		case 2:
			dia = "martes";
			break;
		case 3:
			dia = "miercoles";
			break;
		case 4:
			dia = "jueves";
			break;
		case 5:
			dia = "viernes";
			break;
		case 6:
			dia = "sabado";
			break;
		case 7:
			dia = "domingo";
			break;
		}
		return dia;
	}

	public float g2e12(int tipo, Float base, Float altura, Float radio) {

		float area = 0;

		switch (tipo) {

		case 1:
			area = ((float) base * altura) / 2;
			break;
		case 2:
			area = (float) (Math.PI * Math.pow((double) radio, 2));
			break;
		case 3:
			area = ((float) base * altura);
			break;
		}
		return area;
	}

	// r[] => 0: nota 1: asistencia
	public boolean[] g2e13(Float nota, Float asistencia) {

		boolean[] r = new boolean[2];

		if (nota >= 4 && asistencia >= 75) {
			r[0] = true;
			r[1] = true;
		} else if (nota >= 4 && asistencia < 75) {
			r[0] = true;
			r[1] = false;
		} else if (nota < 4 && asistencia >= 75) {
			r[0] = false;
			r[1] = true;
		} else {
			r[0] = false;
			r[1] = false;			
		}

		return r;
	}

	// r[] => 0: iguales, 1: p1 > p2, 2: p2 > p1
	public boolean[] g2e14(String p1, String p2) {

		boolean[] r = new boolean[3];

		if (p1.trim().length() == p2.trim().length())
			r[0] = true;
		else if (p1.trim().length() > p2.trim().length())
			r[1] = true;
		else
			r[2] = true;

		return r;

	}

	// r[] 0: iguales, 1: n1 > n2, 2: n2 > n1
	public boolean[] g2e15(float n1, float n2) {

		boolean[] r = new boolean[3];

		if (n1 - n2 == 0)
			r[0] = true;
		else if (n1 * 100 > n2 * 100 )
			r[1] = true;
		else if(n1 * 100 < n2 * 100 )
			r[2] = true;

		return r;
	}

	// r[] 0: determinante, 1: x1, 2: x2
	public float[] g2e16(float a, float b, float c) {

		float determinante = 0;
		float raizDeterminante = 0;
		float[] r = new float[3];

		determinante = (float) Math.pow(b, 2) - 4f * a * c;
		r[0] = determinante;

		if (determinante >= 0) {

			raizDeterminante = (float) Math.sqrt((double) determinante);
			
			r[1] = (-(b) + raizDeterminante) / (float) (2f * a);
			r[2] = (-(b) - raizDeterminante) / (float) (2f * a);
		}

		return r;
	}

	
	
	public boolean g2e17(int edad, String genero) {	
		
		return (edad >= 18 && genero.equalsIgnoreCase("m"));
	}

	// respuestas[] => 0: imc, 1: detalle 
	public String[] g2e18(float peso, float altura) {

		float imc = 0;
		String[] respuestas = new String[2];

		imc = peso / (float)(Math.pow(altura, 2));
		
		respuestas[0] = String.valueOf(imc);

		if (imc > 40)
			respuestas[1] = "Obeso: Tipo III";
		
		else if (imc >= 35 && imc <= 40)
			respuestas[1] = "Obeso: Tipo II";
		
		else if (imc >= 30 && imc <= 34.99)
			respuestas[1] = "Obeso: Tipo I";
		
		else if (imc >= 25 && imc <= 29.99)
			respuestas[1] = "Sobrepeso";
		
		else if (imc >= 18.50 && imc <= 24.99)
			respuestas[1] = "Peso Normal";
		
		else if (imc >= 17 && imc <= 18.49)
			respuestas[1] = "Infrapeso: delgadez aceptable";
		
		else if (imc >= 16 && imc <= 16.99)
			respuestas[1] = "Infrapeso: delgadez moderada";
		
		else if (imc < 16)
			respuestas[1] = "Infrapeso: delgadez severa";

		return respuestas;
	}

	public float[] g2e19(float[] valores) {

		float[] r = new float[3];

		if (valores[0] < valores[1] && valores[0] < valores[2]) {

			if (valores[1] < valores[2]) {

				r[0] = valores[0];
				r[1] = valores[1];
				r[2] = valores[2];
			} else {

				r[0] = valores[0];
				r[1] = valores[2];
				r[2] = valores[1];
			}
		} else if (valores[1] < valores[0] && valores[1] < valores[2]) {

			if (valores[0] < valores[2]) {

				r[0] = valores[1];
				r[1] = valores[0];
				r[2] = valores[2];
			} else {

				r[0] = valores[1];
				r[1] = valores[2];
				r[2] = valores[0];
			}

		} else if (valores[2] < valores[0] && valores[2] < valores[1]) {

			if (valores[0] < valores[1]) {

				r[0] = valores[2];
				r[1] = valores[0];
				r[2] = valores[1];
			} else {

				r[0] = valores[2];
				r[1] = valores[1];
				r[2] = valores[0];
			}

		}
		return r;
	}

	public boolean g2e20(int valor) {

		return (valor % 3 == 0 && valor % 2 == 0) ? true : false;
	}

	// datos[] => 0: a ,1: b ,2: c ,3: d ,4: e ,5: f
	public String g2e21(float[] datos) {

		float x = 0;
		float y = 0;
		float t = 0;
		String respuesta = null;

		t = datos[0] * datos[4] - datos[1] * datos[3];

		if (t == 0)
			respuesta = null;
		else {
			x = ((datos[2] * datos[4]) - (datos[1] * datos[5])) / ((datos[0] * datos[4]) - (datos[1] * datos[3]));

			y = ((datos[0] * datos[5]) - (datos[2] * datos[3])) / ((datos[0] * datos[4]) - (datos[1] * datos[3]));

			respuesta = x + "," + y;
		}
		return respuesta;
	}
	
	public float getImc(float imc) {
		
		return (float)(Math.pow(1.8, 2) * imc);
	}
}
