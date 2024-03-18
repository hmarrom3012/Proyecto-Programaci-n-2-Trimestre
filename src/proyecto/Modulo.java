package proyecto;

public class Modulo {
	private String nombre;
	private Profesor profesor;
	private Alumno[] alumnos;

	public Modulo() {
	}

	public Modulo(String nombre, Profesor profesor) {
		this.nombre = nombre;
		this.profesor = profesor;
	}

	public Modulo(String nombre, Profesor profesor, Alumno[] alumnos) {
		this.nombre = nombre;
		this.profesor = profesor;
		this.alumnos = alumnos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Alumno[] getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(Alumno[] alumnos) {
		this.alumnos = alumnos;
	}

	@Override
	public String toString() {
		String cadena = "\n------------------------------------------";
		cadena += "\nNombre: " + this.nombre;
		cadena += "\nProfesor: " + this.profesor;
		cadena += "\nAlumnos: " + this.alumnos;
		cadena += "\n------------------------------------------";
		return cadena;
	}
}
