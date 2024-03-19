package proyecto;

public class Profesor extends Usuario {
	enum Administrador {
		SI, NO
	}

	private Administrador administrador;
	private Examen[] examenesCreados;

	public Profesor() {
		super();
	}

	public Profesor(String nombre, String contraseña, String curso, String admin) {
		super(nombre, contraseña, curso);
		setAdministrador(admin);
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(String admin) {
		if (admin == "SI" || admin == "si" || admin == "s") {
			this.administrador = Administrador.SI;
			System.out.println("Profesor creado como administrador.");
		} else {
			this.administrador = Administrador.NO;
			System.out.println("Profesor creado como usuario.");
		}
	}

	public Examen[] getExamenesCreados() {
		return examenesCreados;
	}

	public void setExamenesCreados(Examen[] examenesCreados) {
		this.examenesCreados = examenesCreados;
	}

	@Override
	public String toString() {
		String cadena = "\n------------------------------------------";
		cadena += "\nID: " + this.id;
		cadena += "\nNombre: " + this.nombre;
		cadena += "\nContraseña: " + this.contraseña;
		cadena += "\nAdministrador: " + this.administrador;
		cadena += "\nCurso: " + this.curso;
		cadena += "\nExámenes creados: " + this.examenesCreados;
		cadena += "\n------------------------------------------";
		return cadena;
	}
}
