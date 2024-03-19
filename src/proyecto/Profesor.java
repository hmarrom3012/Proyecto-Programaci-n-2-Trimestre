package proyecto;

/**
 * Clase que representa a un Profesor en el sistema, que extiende de Usuario.
 */
public class Profesor extends Usuario {
	/**
	 * Enum para indicar si el profesor es administrador o no.
	 */
	enum Administrador {
		SI, NO
	}

	private Administrador administrador;

	/**
	 * Constructor por defecto de la clase Profesor.
	 */
	public Profesor() {
		super();
	}

	/**
	 * Constructor de la clase Profesor con parámetros.
	 * 
	 * @param nombre     Nombre del profesor.
	 * @param contraseña Contraseña del profesor.
	 * @param curso      Curso del profesor.
	 */
	public Profesor(String nombre, String contraseña, String curso) {
		super(nombre, contraseña, curso);
	}

	/**
	 * Constructor de la clase Profesor con parámetros.
	 * 
	 * @param nombre     Nombre del profesor.
	 * @param contraseña Contraseña del profesor.
	 * @param curso      Curso del profesor.
	 * @param admin      Indicador de administrador (SI o NO).
	 */
	public Profesor(String nombre, String contraseña, String curso, String admin) {
		super(nombre, contraseña, curso);
		try {
			setAdministrador(admin);
		} catch (IllegalArgumentException e) {
			System.out.println("Error al establecer el administrador: " + e.getMessage());
		}
	}

	/**
	 * Método para obtener el estado del administrador.
	 * 
	 * @return Estado del administrador.
	 */
	public Administrador getAdministrador() {
		return administrador;
	}

	/**
	 * Método para establecer el estado del administrador.
	 * 
	 * @param admin Estado del administrador (SI o NO).
	 */
	public void setAdministrador(String admin) {
		try {
			if (admin.equalsIgnoreCase("SI")) {
				this.administrador = Administrador.SI;
				System.out.println("Profesor creado como administrador.");
			} else if (admin.equalsIgnoreCase("NO")) {
				this.administrador = Administrador.NO;
				System.out.println("Profesor creado como usuario.");
			} else {
				throw new IllegalArgumentException("El valor de administrador debe ser 'SI' o 'NO'.");
			}
		} catch (Exception e) {
			System.out.println("Error al establecer el administrador: " + e.getMessage());
		}
	}

	/**
	 * Método toString para representar un Profesor como cadena de texto.
	 * 
	 * @return Representación del profesor como cadena de texto.
	 */
	@Override
	public String toString() {
		String cadena = "\n------------------------------------------";
		cadena += "\nID: " + this.id;
		cadena += "\nNombre: " + this.nombre;
		cadena += "\nContraseña: " + this.contraseña;
		cadena += "\nAdministrador: " + this.administrador;
		cadena += "\nCurso: " + this.curso;
		cadena += "\n------------------------------------------";
		return cadena;
	}
}
