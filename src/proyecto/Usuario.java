package proyecto;

public abstract class Usuario {
	protected int id;
	protected String nombre;
	protected String contraseña;
	protected String curso;
	private static int contadorUsuarios;

	public Usuario() {
		this.id = contadorUsuarios;
		contadorUsuarios++;
	}

	public Usuario(String nombre, String contraseña, String curso) {
		this.id = contadorUsuarios;
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.curso = curso;
		contadorUsuarios++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public static int getContadorUsuarios() {
		return contadorUsuarios;
	}

	public static void setContadorUsuarios(int contadorUsuarios) {
		Usuario.contadorUsuarios = contadorUsuarios;
	}

	@Override
	public String toString() {
		String cadena = "\n------------------------------------------";
		cadena += "\nID: " + this.id;
		cadena += "\nNombre: " + this.nombre;
		cadena += "\nContraseña: " + this.contraseña;
		cadena += "\nCurso: " + this.curso;
		cadena += "\n------------------------------------------";
		return cadena;
	}
}
