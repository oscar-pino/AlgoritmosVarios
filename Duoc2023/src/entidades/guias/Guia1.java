package entidades.guias;

public class Guia1 {

	public float g1e1(float n1, float n2) {
		
		return n1+n2;
	}
	
	public float g1e2(float radio) {
				
		return (float)(Math.PI*Math.pow(radio, 2));
	}
	
	// r[] => 0: suma, 1: resta, 2: multiplicacion, 3: division
	public float[] g1e3(float n1, float n2) {
		
		float[] r = new float[4];
		
		r[0] = n1+n2;
		r[1] = n1-n2;
		r[2] = n1*n2;
		r[3] = (n2 == 0)?Float.MIN_VALUE:(float)n1/n2;
		
		return r;
	}
	
	public float g1e4(float horasTrabajadas) {
		
		final float SUELDO_MINIMO = 410000;
		final float VALOR_HORA = SUELDO_MINIMO / 160;
		
		return VALOR_HORA*horasTrabajadas;
	}
	
	public float g1e5(float celsius) {
		
		return (9f/5)*celsius+32;
	}
	
	public float[] g1e6(float n1, float n2, float n3) {
		
		float r[] = new float[3];
		r[0] = n1+n2;
		r[1] = n2*n3;
		r[2] = r[0] / r[1];
		
		return r;
	}
	
	public float[] g1e7(float radio) {
		
		float[] r = new float[2];
		
		r[0] = (float) ((4f/3)*Math.PI*Math.pow(radio, 3)); // volumen
		
		r[1] = (float)(4f*Math.PI*Math.pow(radio, 2)); // area
		
		return r;
	}
	
	public float g1e8(float dolares) {
		
		return dolares * 806.68f;
	}
	
	public float g1e9(float base, float altura) {
		
		return base * altura / 2f;
	}
	
	// promedios[] (ponderados)=> 0: n1, 1: n2, 2: n3, 3: n4, 4: promedio sin ponderacion, 5: promedio ponderado
	public float[] g1e10(float[] notas) {
		
		int ponderados[] = new int[3];
		float promedios[] = new float[6];
		float temporal = 0;
		float promedioFinalNoPonderado = 0;
		float promedioFinalPonderado = 0;
		
		ponderados[0] = 30;
		ponderados[1] = 25;
		ponderados[2] = 20;
		
		promedios[0] = notas[0] * ((float)ponderados[0] / 100);
		promedios[1] = notas[1] * ((float)ponderados[1] / 100);
		promedios[2] = notas[2] * ((float)ponderados[1] / 100);
		promedios[3] = notas[3] * ((float)ponderados[2] / 100);
		
		for(float n : notas)
			temporal+=n;
		
		promedioFinalNoPonderado = temporal / notas.length;
		
		promedios[4] = promedioFinalNoPonderado;
		
		temporal = 0;
		
		for(int i=0;i<4;i++)
			temporal += promedios[i];		
		
		promedioFinalPonderado = temporal;
		
		promedios[5] = promedioFinalPonderado;
			
		return promedios;
	}
	
	public float[] g1e11(float base, float altura) {
		
		float[] r = new float[2];
		
		r[0] = (float)(base * 2 + altura * 2); // perimetro
		r[1] = (float)(base * altura); // area
		
		return r;
	}
	
	public float g1e12(float pesoKg, float alturaMt) {
		
		return (float)(pesoKg / Math.pow(alturaMt,2));
	}
}
