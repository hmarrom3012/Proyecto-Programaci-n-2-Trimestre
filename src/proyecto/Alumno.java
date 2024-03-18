package proyecto;

public class Alumno extends Usuario {
	private Examen[] examenesRealizados;

	public Alumno() {
		super();
	}

	public Alumno(String nombre, String contraseña, String curso) {
		super(nombre, contraseña, curso);
	}

	public Examen[] getExamenesRealizados() {
		return examenesRealizados;
	}

	public void setExamenesRealizados(Examen[] examenesRealizados) {
		this.examenesRealizados = examenesRealizados;
	}

	@Override
	public String toString() {
		String cadena = "\n------------------------------------------";
		cadena += "\nID: " + this.id;
		cadena += "\nNombre: " + this.nombre;
		cadena += "\nContraseña: " + this.contraseña;
		cadena += "\nCurso: " + this.curso;
		cadena += "\nExámenes realizados: " + this.examenesRealizados;
		cadena += "\n------------------------------------------";
		return cadena;
	}
}
