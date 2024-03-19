package proyecto;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Usuario[] usuarios = new Usuario[100];
		usuarios[0] = new Profesor("Pepe", "Pepe", "1º DAM", "no");
		Usuario usuarioActual = null;

		boolean salida = false;
		
		while (!salida) {
			while (!salida) {
				System.out.println("1. Iniciar sesión.");
				System.out.println("2. Crear usuario.");
				System.out.println("3. Salir.");
				System.out.println("Elige una opción (1-3).");
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
					salida = true;
					break;
				default:
					System.out.println("Elige una opción válida.");
					break;
				}
			}
			
		}
		System.out.println(usuarioActual);
		sc.close();
	}

	private static Usuario iniciarSesion(Usuario[] usuarios) {
		Scanner sc = new Scanner(System.in);
		boolean salida = false;
		Usuario usuarioActual = null;

		while (!salida) {
			System.out.print("Nombre de usuario: ");
			String nombreUsuario = sc.next();
			
			usuarioActual = pedirContraseña(usuarios, nombreUsuario);
			
			salida = true;
		}
		
		return usuarioActual;
	}

	private static Usuario pedirContraseña(Usuario[] usuarios, String nombreUsuario) {
		Scanner sc = new Scanner(System.in);
		Usuario usuarioActual = null;
		
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
		
		return usuarioActual;
	}

	private static boolean compruebaUsuario(Usuario usuario, String nombre) {
		if (usuario != null && usuario.getNombre().equals(nombre)) {
			return true;
		}
		return false;
	}
	
	private static boolean compruebaContraseña(Usuario usuario, String contraseña) {
		if (usuario != null && usuario.getContraseña().equals(contraseña)) {
			return true;
		}
		return false;
	}

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

	
	
}
