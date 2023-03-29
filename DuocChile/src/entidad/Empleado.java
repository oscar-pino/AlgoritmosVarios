package entidad;

public class Empleado extends Persona{

	private float sueldo;
	private float valorHora;
	private float horastrabajadas;
	private float horasExtras;
	public static final int HORAS_LEGALES = 180; 
	
	public Empleado() {
		
		super();
	}
	
	public Empleado(String nombre, int edad, float pesoKg, float alturaMt, float sueldo, float valorHora, float horasTrabajadas, float horasExtras) {		
		
		super(nombre,edad,pesoKg,alturaMt);
		this.sueldo = sueldo;
		this.valorHora = valorHora;
		this.horastrabajadas = horasTrabajadas;
		this.horasExtras = horasExtras;
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

	@Override
	public String toString() {
		return "Empleado [nombre="+this.getNombre()+", sueldo=" + sueldo + ", valorHora=" + valorHora + ", horasTrabajadas= "+String.valueOf(horastrabajadas)+"]";
	}	
	
	
}
