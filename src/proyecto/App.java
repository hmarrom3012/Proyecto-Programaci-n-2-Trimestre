package proyecto;

import java.util.Scanner;
<<<<<<< HEAD
import proyecto.Profesor.Administrador;
=======
>>>>>>> 7d42be4afc533b1463bd7d4ce358aa081360d534

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Usuario[] usuarios = new Usuario[100];
<<<<<<< HEAD
		Examen[] examenes = new Examen[100];
		Usuario usuarioActual = null;

		boolean salida = false;

		do {
			while (!salida) {
				System.out.println("1. Iniciar sesión.");
				System.out.println("2. Crear usuario.");
				System.out.println("3. Importar datos.");
				System.out.println("4. Salir.");
				System.out.println("Elige una opción (1-4).");
=======
		usuarios[0] = new Profesor("Pepe", "Pepe", "1º DAM", "no");
		Usuario usuarioActual = null;

		boolean salida = false;
		
		while (!salida) {
			while (!salida) {
				System.out.println("1. Iniciar sesión.");
				System.out.println("2. Crear usuario.");
				System.out.println("3. Salir.");
				System.out.println("Elige una opción (1-3).");
>>>>>>> 7d42be4afc533b1463bd7d4ce358aa081360d534
				int opcion = sc.nextInt();

				switch (opcion) {
				case 1:
					usuarioActual = iniciarSesion(usuarios);
					salida = true;
					break;
				case 2:
					usuarios = crearUsuario(usuarios);
					break;
				case 3:
<<<<<<< HEAD
					usuarios = importarUsuarios(usuarios);
					examenes = importarExamenes(examenes);
					break;
				case 4:
=======
>>>>>>> 7d42be4afc533b1463bd7d4ce358aa081360d534
					salida = true;
					break;
				default:
					System.out.println("Elige una opción válida.");
					break;
				}
			}
<<<<<<< HEAD

			salida = false;

			while (!salida) {
				System.out.println("1. Listar usuario actual.");
				System.out.println("2. Listar usuarios.");
				System.out.println("3. Crear usuario.");
				System.out.println("4. Modificar usuario.");
				System.out.println("5. Borrar usuario.");
				System.out.println("6. Crear examen.");
				System.out.println("7. Participar en un examen.");
				System.out.println("8. Ver nota de un examen.");
				System.out.println("9. Ver nota de todos los exámenes.");
				System.out.println("10. Salir.");
				System.out.println("Elige una opción (1-10).");
				int opcion = sc.nextInt();

				switch (opcion) {
				case 1:
					System.out.println(usuarioActual);
					break;
				case 2:
					listarUsuario(usuarios);
					break;
				case 3:
					usuarios = crearUsuario(usuarios);
					break;
				case 4:
					usuarios = modificarUsuario(usuarios);
					break;
				case 5:
					usuarios = eliminarUsuario(usuarios);
					break;
				case 6:
					examenes = crearExamen(examenes);
					break;
				case 7:
					if (usuarioActual instanceof Alumno) {
						usuarioActual = participarExamen(examenes, usuarios, usuarioActual);
					} else {
						System.out.println("No eres un alumno.");
					}
					break;
				case 8:
					if (usuarioActual instanceof Alumno) {
						verNota((Alumno) usuarioActual, 1);
					} else {
						System.out.println("No eres un alumno.");
					}
					break;
				case 9:
					if (usuarioActual instanceof Alumno) {
						verNota((Alumno) usuarioActual, 2);
					} else {
						System.out.println("No eres un alumno.");
					}
					break;
				case 10:
					salida = true;
					break;
				default:
					System.out.println("Elige una opción válida.");
					break;
				}
			}

		} while (!salida);
=======
			
		}
		System.out.println(usuarioActual);
>>>>>>> 7d42be4afc533b1463bd7d4ce358aa081360d534
		sc.close();
	}

	private static Usuario iniciarSesion(Usuario[] usuarios) {
		Scanner sc = new Scanner(System.in);
		boolean salida = false;
		Usuario usuarioActual = null;

		while (!salida) {
			System.out.print("Nombre de usuario: ");
			String nombreUsuario = sc.next();
<<<<<<< HEAD

			usuarioActual = pedirContraseña(usuarios, nombreUsuario);

			salida = true;
		}

=======
			
			usuarioActual = pedirContraseña(usuarios, nombreUsuario);
			
			salida = true;
		}
		
>>>>>>> 7d42be4afc533b1463bd7d4ce358aa081360d534
		return usuarioActual;
	}

	private static Usuario pedirContraseña(Usuario[] usuarios, String nombreUsuario) {
		Scanner sc = new Scanner(System.in);
		Usuario usuarioActual = null;
<<<<<<< HEAD

=======
		
>>>>>>> 7d42be4afc533b1463bd7d4ce358aa081360d534
		for (Usuario usuario : usuarios) {
			if (compruebaUsuario(usuario, nombreUsuario)) {
				System.out.print("Contraseña: ");
				String contraseñaUsuario = sc.next();

				boolean salida = false;

				while (!salida) {
					for (Usuario usu : usuarios) {
						if (compruebaContraseña(usu, contraseñaUsuario)) {
							usuarioActual = usu;
							System.out.println("El usuario " + nombreUsuario + " ha iniciado sesión.");
							salida = true;
						}
					}
				}
			}
		}
<<<<<<< HEAD

=======
		
>>>>>>> 7d42be4afc533b1463bd7d4ce358aa081360d534
		return usuarioActual;
	}

	private static boolean compruebaUsuario(Usuario usuario, String nombre) {
		if (usuario != null && usuario.getNombre().equals(nombre)) {
			return true;
		}
		return false;
	}
<<<<<<< HEAD

=======
	
>>>>>>> 7d42be4afc533b1463bd7d4ce358aa081360d534
	private static boolean compruebaContraseña(Usuario usuario, String contraseña) {
		if (usuario != null && usuario.getContraseña().equals(contraseña)) {
			return true;
		}
		return false;
	}

<<<<<<< HEAD
	private static void listarUsuario(Usuario[] usuarios) {
		for (Usuario usuario : usuarios) {
			if (usuario != null) {
				if (usuario instanceof Profesor) {
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

	private static Usuario[] crearUsuario(Usuario[] usuarios) {
		Scanner sc = new Scanner(System.in);
		boolean salida = false;

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

	private static Usuario[] modificarUsuario(Usuario[] usuarios) {
		Scanner sc = new Scanner(System.in);

		System.out.println("¿Es alumno (1) o profesor (2)?");
		int opcionUsuario = sc.nextInt();

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
			break;
		case 2:
			System.out.println("Escribe la nueva contraseña.");
			contraseña = sc.next();
			break;
		case 3:
			System.out.println("Escribe el nuevo curso.");
			curso = sc.next();
			break;
		default:
			System.out.println("Elige una opción válida.");
		}

		switch (opcionUsuario) {
		case 2:
			System.out.println("¿Es administrador?");
			String administrador = sc.next();

			for (Usuario usuario : usuarios) {
				if (usuario != null && usuario.getId() == id) {
					usuario = new Profesor(nombre, contraseña, curso, administrador);
					return usuarios;
				}
			}
			break;
		default:
			for (Usuario usuario : usuarios) {
				if (usuario != null && usuario.getId() == id) {
					usuario = new Alumno(nombre, contraseña, curso);
					return usuarios;
				}
			}
			break;
		}

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

	private static Usuario[] eliminarUsuario(Usuario[] usuarios) {
		Scanner sc = new Scanner(System.in);

		System.out.println("¿Quieres buscar por nombre (1) o por id de usuario (2)?");
		System.out.println("Escribe el id del usuario.");
		int opcion = sc.nextInt();

		switch (opcion) {
		case 1:
			System.out.println("Escribe el nombre de usuario.");
			String nombre = sc.next();
			for (Usuario usuario : usuarios) {
				if (usuario != null && usuario.getNombre().equalsIgnoreCase(nombre)) {
					usuario = null;
				}
			}
			break;
		case 2:
			System.out.println("Escribe el id del usuario.");
			int id = sc.nextInt();
			for (Usuario usuario : usuarios) {
				if (usuario != null && usuario.getId() == id) {
					usuario = null;
				}
			}
			break;
		default:
			System.out.println("Elige una opción válida.");
		}

		return usuarios;
	}

	private static Examen[] crearExamen(Examen[] examenes) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Escribe el módulo.");
		String modulo = sc.next();

		System.out.println("Escribe el tema.");
		int tema = sc.nextInt();

		String[] preguntas2 = new String[10];
		String[] respuestas2 = new String[10];

		boolean salir2 = false;
		while (!salir2) {
			for (int i = 0; i < 10; i++) {
				System.out.println("Escribe la pregunta.");
				preguntas2[i] = sc.next();

				System.out.println("Escribe la respuesta.");
				respuestas2[i] = sc.next();
			}

			for (int i = 0; i < examenes.length; i++) {
				examenes[i] = new Examen(tema, modulo, preguntas2, respuestas2);
				salir2 = true;
			}
		}

		return examenes;
	}

	private static Alumno participarExamen(Examen[] examenes, Usuario[] usuarios, Usuario usuarioActual) {
		Scanner sc = new Scanner(System.in);

		Examen examenActual = null;

		System.out.println("Escribe el id del examen.");
		int idExamen = sc.nextInt();

		for (Examen examen : examenes) {
			if (examen != null && examen.getId() == idExamen) {
				examenActual = examen;
			}
		}

		String[] examenPreguntas = examenActual.getPreguntas();
		String[] preguntasContestada = new String[10];

		for (int i = 0; i < examenPreguntas.length; i++) {
			System.out.println(examenPreguntas[i]);
			preguntasContestada[i] = sc.next();
		}

		examenActual.setPreguntasContestadas(preguntasContestada);
		examenActual.setNota(examenActual.corregir());

		Alumno alumno = (Alumno) usuarioActual;
		alumno.setExamenesRealizados(examenActual);

		return alumno;
	}

	private static void verNota(Alumno usuarioActual, int modo) {
		Scanner sc = new Scanner(System.in);

		Examen[] examenesRealizados = usuarioActual.getExamenesRealizados();
		switch (modo) {
		case 1: {
			System.out.println("Escribe el id del examen.");
			int idExamen = sc.nextInt();

			for (Examen examen : examenesRealizados) {
				if (examen != null && examen.getId() == idExamen) {
					System.out.println(examen.getNota());
				}
			}
		}
			break;
		case 2:
			for (Examen examen : examenesRealizados) {
				System.out.println(examen.getNota());
			}
			break;
		}
	}
	
	// Datos generados con Chat GPT
	private static Usuario[] importarUsuarios(Usuario[] usuarios) {
		usuarios[0] = new Profesor("David_Garcia", "davgar", "1º DAM", "si");
		usuarios[1] = new Profesor("Ana_Martinez", "anamar", "2º DAW", "si");
		usuarios[2] = new Profesor("Laura_Sanchez", "lausan", "1º DAW", "no");
		usuarios[3] = new Profesor("Juan_Perez", "juaper", "2º DAM", "no");
		usuarios[4] = new Profesor("Alejandro_Lopez", "alelop", "1º DAM", "no");
		usuarios[5] = new Alumno("Andres_Martinez", "andmar", "1º DAM");
		usuarios[6] = new Alumno("Sofia_Garcia", "sofgar", "2º DAW");
		usuarios[7] = new Alumno("Javier_Lopez", "javlop", "1º DAW");
		usuarios[8] = new Alumno("Valentina_Rodriguez", "valrod", "2º DAM");
		usuarios[9] = new Alumno("Daniel_Gonzalez", "dangon", "1º DAM");
		return usuarios;
	}
	
	// Datos generados con Chat GPT
	private static Examen[] importarExamenes(Examen[] examenes) {
		String[] preguntas1 = new String[3];
		preguntas1[0] = "¿Qué es un CPU?";
		preguntas1[1] = "¿Qué significa la primera letra de USB?";
		preguntas1[2] = "¿Qué es RAM?";
		String[] respuestas1 = new String[3];
		respuestas1[0] = "Procesador";
		respuestas1[1] = "Universal";
		respuestas1[2] = "Memoria";
		String[] preguntas2 = new String[3];
		preguntas1[0] = "¿Qué es un for?";
		preguntas1[1] = "¿Qué es una variable?";
		preguntas1[2] = "¿Qué es Java?";
		String[] respuestas2 = new String[3];
		preguntas1[0] = "Bucle";
		preguntas1[1] = "Almacenamiento";
		preguntas1[2] = "Lenguaje";
		examenes[0] = new Examen(1, "Sistemas informáticos", preguntas1, respuestas1);
		examenes[1] = new Examen(3, "Programación", preguntas2, respuestas2);
		return examenes;
	}

	// Copiado de internet
	public static final String RESET = "\u001B[0m";
	public static final String RED = "\u001B[31m";
	public static final String GREEN = "\u001B[32m";
	public static final String BLUE = "\u001B[34m";
=======
	private static Usuario[] crearUsuario(Usuario[] usuarios) {
		Scanner sc = new Scanner(System.in);
		boolean salida = false;
		
		while (!salida) {
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
			salida = true;
		}
		return usuarios;
	}

	
	
>>>>>>> 7d42be4afc533b1463bd7d4ce358aa081360d534
}
