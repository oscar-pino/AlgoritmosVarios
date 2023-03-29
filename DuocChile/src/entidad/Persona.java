package entidad;

public class Persona {

	private String nombre;
	private float pesoKg;
	private float alturaMt;
	private int edad;
	
	public Persona() {
		
		this("oscar",18,80.5f,1.8f);				
	}
	
	public Persona(String nombre, int edad, float pesoKg, float alturaMt) {
		
		this.nombre = nombre;
		this.edad = edad;
		this.pesoKg = pesoKg;
		this.alturaMt = alturaMt;
		
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

	public String toString() {
		
		return String.format("nombre: %s, edad: %d, peso %.2fKg, altura: %.2fMt",nombre,edad,pesoKg,alturaMt);
	}
}
