package proyecto;

import java.util.Scanner;

import proyecto.Profesor.Administrador;

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

	public static Usuario[] crearUsuario(Usuario[] usuarios) {
		Scanner sc = new Scanner(System.in);

		System.out.println("¿Quieres crear un alumno (1) o un profesor (2)?");
		int opcion = sc.nextInt();

		System.out.println("Escribe el nombre de usuario.");
		String nombre = sc.next();

		System.out.println("Escribe la contraseña.");
		String contraseña = sc.next();

		System.out.println("Escribe el curso.");
		String curso = sc.next();

		switch (opcion) {
		case 2:
			System.out.println("¿Es administrador?");
			String administrador = sc.next();

			for (int i = 0; i < usuarios.length; i++) {
				if (usuarios[i] == null) {
					usuarios[i] = new Profesor(nombre, contraseña, curso, administrador);
					return usuarios;
				}
			}
			break;
		default:
			for (int i = 0; i < usuarios.length; i++) {
				if (usuarios[i] == null) {
					usuarios[i] = new Alumno(nombre, contraseña, curso);
					return usuarios;
				}
			}
			break;
		}

		return usuarios;
	}
	
	public static Usuario[] modificarUsuario(Usuario[] usuarios) {
		Scanner sc = new Scanner(System.in);

		System.out.println("¿Qué quieres modificar?");
		System.out.println("1. Nombre.");
		System.out.println("2. Contraseña.");
		System.out.println("3. Curso.");
		int opcion = sc.nextInt();

		System.out.println("Escribe el id del usuario.");
		int id = sc.nextInt();

		String nombre = null;
		String contraseña = null;
		String curso = null;

		switch (opcion) {
		case 1:
			System.out.println("Escribe el nuevo nombre de usuario.");
			nombre = sc.next();

			for (Usuario usuario : usuarios) {
				if (usuario != null && usuario.getId() == id) {
					usuario.setNombre(nombre);
				}
			}
			break;
		case 2:
			System.out.println("Escribe la nueva contraseña.");
			contraseña = sc.next();

			for (Usuario usuario : usuarios) {
				if (usuario != null && usuario.getId() == id) {
					usuario.setContraseña(contraseña);
				}
			}
			break;
		case 3:
			System.out.println("Escribe el nuevo curso.");
			curso = sc.next();

			for (Usuario usuario : usuarios) {
				if (usuario != null && usuario.getId() == id) {
					usuario.setCurso(curso);
				}
			}
			break;
		default:
			System.out.println("Elige una opción válida.");
		}

		return usuarios;
	}

	public static Usuario[] eliminarUsuario(Usuario[] usuarios, Usuario usuarioActual) {
		Scanner sc = new Scanner(System.in);

		System.out.println("¿Quieres buscar por nombre (1) o por id de usuario (2)?");
		int opcion = sc.nextInt();

		switch (opcion) {
		case 1:
			System.out.println("Escribe el nombre de usuario.");
			String nombre = sc.next();
			for (int i = 0; i < usuarios.length; i++) {
				if (usuarios[i] != usuarioActual) {
					if (usuarios[i] != null && usuarios[i].getNombre().equals(nombre)) {
						usuarios[i] = null;
					}
				}
			}
			break;
		case 2:
			System.out.println("Escribe el id del usuario.");
			int id = sc.nextInt();
			for (int i = 0; i < usuarios.length; i++) {
				if (usuarios[i] != usuarioActual) {
					if (usuarios[i] != null && usuarios[i].getId() == id) {
						usuarios[i] = null;
					}
				}
			}
			break;
		default:
			System.out.println("Elige una opción válida.");
		}

		return usuarios;
	}
	
	public static void listarUsuario(Usuario[] usuarios) {
		for (Usuario usuario : usuarios) {
			if (usuario != null) {
				if (usuario instanceof Alumno) {
					System.out.println(GREEN + usuario + RESET);
				}
				if (usuario instanceof Profesor && ((Profesor) usuario).getAdministrador().equals(Administrador.NO)) {
					System.out.println(BLUE + usuario + RESET);
				}
				if (usuario instanceof Profesor && ((Profesor) usuario).getAdministrador().equals(Administrador.SI)) {
					System.out.println(RED + usuario + RESET);
				}
			}
		}
	}

	// Copiado de internet
	public static final String RESET = "\u001B[0m";
	public static final String RED = "\u001B[31m";
	public static final String GREEN = "\u001B[32m";
	public static final String BLUE = "\u001B[34m";
	
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
