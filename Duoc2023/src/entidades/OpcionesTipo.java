package entidades;

public enum OpcionesTipo {
	
	ALTURA("ingrese nueva altura: "),
	ANGULO("ingrese nuevo angulo: "),
	ASISTENCIA("ingrese nueva asistencia: "),
	BASE("ingrese nueva base: "),
	CANTIDAD_ALUMNO("ingrese nueva cantidad de alumnos: "),
	CATETO("ingrese nuevo cateto: "),
	DENOMINADOR("ingrese nuevo denominador: "),
	DEPARTAMENTO("ingrese nuevo departamento: "),
	DIA_SEMANA("ingrese nuevo dia semana: "),
	DOLARES("ingrese nueva cantidad de dolares: "),
	EDAD("ingrese nueva edad: "),
	EJERCICIO("ingrese nueva opcion ejercicio: "),
	ESTATURA("ingrese nueva estatura (mt): "),
	GENERO("ingrese nuevo genero: "),
	GRADOS_CELSIUS("ingrese nueva cantidad de grados celsius: "),
	GRADOS_FAHRENHEIT("ingrese nueva cantidad de grados fahrenheit: "),
	GUIA("ingrese nueva opcion guia: "),
	HECTAREA("ingrese nueva cantidad de hectareas: "),
	HIPOTENUSA("ingrese nueva hipotenusa: "),
	HORAS_TRABAJADAS("ingrese nueva horas trabajadas: "),
	LLUVIA("ingrese nueva cantidad mm: "),
	NOMBRE("ingrese nuevo nombre: "),
	NOTA("ingrese nueva nota: "),
	OPCION("ingrese nueva opcion: "),
	PESO("ingrese nuevo peso (kg): "),
	PESOS("ingrese nueva cantidad de pesos: "),
	PROMEDIO("ingrese nuevo promedio: "),
	RADIO("ingrese nuevo radio: "),
	SUELDO("ingrese nuevo sueldo: "),
	VALOR("ingrese nuevo valor: "),
	VALOR_HORA("ingrese nuevo valor hora: "),
	SALIR_APLICACION("\n¿Deseas salir de la aplicacion? (s/n): "),
	VOLVER_MENU_PRINCIPAL("\n¿Deseas volver al menu principal? (s/n): "),
	OTROS_VALORES("\n¿Quieres probar con otros valores? (s/n): "),
	DEJAR_INGRESAR_ESTATURAS("\n¿quieres dejar de ingresar estaturas? (s|n): "),
	DEJAR_INGRESAR_ANGULOS("\n¿quieres dejar de ingresar angulos? (s|n): "),
	AGREGAR_OTRA_PERSONA("\n¿quieres agregar otra persona? (s|n): "),
	AGREGAR_OTRA_VENTA("\n¿quieres agregar otra venta? (s|n): "),
	AGREGAR_OTRO_EMPLEADO("\n¿quieres agregar otro empleado? (s|n): "),
	OPCION_GUIA("\ningrese opcion guia: "),
	OPCION_EJERCICIO("\ningrese opcion ejercicio: ");
	

	private String mensajeOpcion;
	
	private OpcionesTipo(String mensajeOpcion) {
		
		this.mensajeOpcion = mensajeOpcion;
	}
	
	public String getMensajeOpcion() {
		
		return mensajeOpcion;
	}
}
