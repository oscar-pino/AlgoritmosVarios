package entidades;

public class Empleado extends Persona{

	private float sueldo;
	private float valorHora;
	private float horastrabajadas;
	private float horasExtras;
	private String departamento;
	public static final int HORAS_LEGALES = 180; 
	public static final float SUELDO_MINIMO = 470_000f;
	
	public Empleado() {
		
		this("oscar",18,80.5f,1.8f,'m',1_000_000f,5_000f,200f,20f,"informatica");
	}
	
	public Empleado(String nombre, int edad, float pesoKg, float alturaMt, char genero, float sueldo, float valorHora, float horasTrabajadas, float horasExtras, String departamento) {		
		
		super(nombre,edad,pesoKg,alturaMt,genero);
		this.sueldo = sueldo;
		this.valorHora = valorHora;
		this.horastrabajadas = horasTrabajadas;
		this.horasExtras = horasExtras;
		this.departamento = departamento;
		
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	public float getValorHora() {
		return valorHora;
	}

	public void setValorHora(float valorHora) {
		this.valorHora = valorHora;
	}	

	public float getHorastrabajadas() {
		return horastrabajadas;
	}

	public void setHorastrabajadas(float horastrabajadas) {
		this.horastrabajadas = horastrabajadas;
	}	

	public float getHorasExtras() {
		return horasExtras;
	}

	public void setHorasExtras(float horasExtras) {
		this.horasExtras = horasExtras;
	}
	
	

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Empleado [nombre="+this.getNombre()+", sueldo=" + sueldo + ", valorHora=" + valorHora + ", horasTrabajadas= "+String.valueOf(horastrabajadas)+", departamento= "+departamento+"]";
	}	
	
	
}
