package entidades;

public class Persona {

	private String nombre;
	private float pesoKg;
	private float alturaMt;
	private int edad;
	private char genero;
	
	public Persona() {
		
		this("oscar",18,80.5f,1.8f,'m');				
	}
	
	public Persona(String nombre, int edad) {
		
		this.nombre = nombre;
		this.edad = edad;
	}
	
	public Persona(String nombre, int edad, float pesoKg, float alturaMt, char genero) {
		
		this.nombre = nombre;
		this.edad = edad;
		this.pesoKg = pesoKg;
		this.alturaMt = alturaMt;
		this.genero = genero;
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPesoKg() {
		return pesoKg;
	}
	public void setPesoKg(float pesoKg) {
		this.pesoKg = pesoKg;
	}
	public float getAlturaMt() {
		return alturaMt;
	}
	public void setAlturaMt(float alturaMt) {
		this.alturaMt = alturaMt;
	}	
	
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}	

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public String toString() {
		
		return String.format("nombre: %s, edad: %d, peso %.2fKg, altura: %.2fMt, genero: %s",nombre,edad,pesoKg,alturaMt,String.valueOf(genero));
	}
}
