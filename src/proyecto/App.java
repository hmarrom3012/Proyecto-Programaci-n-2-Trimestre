package proyecto;

import java.util.Scanner;

/**
 * Esta clase representa la aplicación principal del programa.
 * Permite gestionar usuarios, exámenes y sesiones de usuario.
 */
public class App {

    /**
     * Método principal que inicia la aplicación.
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Usuario[] usuarios = new Usuario[100];
        Examen[] examenes = new Examen[100];
        Usuario usuarioActual = null;

        boolean salir = false;

        try {
            do {
                usuarioActual = null;
                boolean salida = false;

                // Menú principal
                while (!salida) {
                    System.out.println("1. Iniciar sesión.");
                    System.out.println("2. Crear usuario.");
                    System.out.println("3. Importar datos.");
                    System.out.println("4. Salir.");
                    System.out.println("Elige una opción (1-4).");
                    int opcion = sc.nextInt();

                    switch (opcion) {
                        case 1:
                            usuarioActual = iniciarSesion(usuarios);
                            if (usuarioActual != null) {
                                salida = true;
                            }
                            break;
                        case 2:
                            usuarios = Usuario.crearUsuario(usuarios);
                            break;
                        case 3:
                            usuarios = importarUsuarios(usuarios);
                            examenes = importarExamenes(examenes);
                            break;
                        case 4:
                            salir = true;
                            salida = true;
                            break;
                        default:
                            System.out.println("Elige una opción válida.");
                            break;
                    }
                }

                // Menú de usuario
                if (usuarioActual != null) {
                    salida = false;

                    while (!salida) {
                        System.out.println("1. Listar usuario actual.");
                        System.out.println("2. Listar usuarios.");
                        System.out.println("3. Crear usuario.");
                        System.out.println("4. Modificar usuario.");
                        System.out.println("5. Borrar usuario.");
                        System.out.println("6. Crear examen.");
                        System.out.println("7. Listar examenes.");
                        System.out.println("8. Participar en un examen.");
                        System.out.println("9. Ver nota de un examen.");
                        System.out.println("10. Ver nota de todos los exámenes.");
                        System.out.println("11. Cerrar sesión.");
                        System.out.println("Elige una opción (1-11).");
                        int opcion = sc.nextInt();

                        switch (opcion) {
                            case 1:
                                System.out.println(usuarioActual);
                                break;
                            case 2:
                                Usuario.listarUsuario(usuarios);
                                break;
                            case 3:
                                usuarios = Usuario.crearUsuario(usuarios);
                                break;
                            case 4:
                                usuarios = Usuario.modificarUsuario(usuarios);
                                break;
                            case 5:
                                usuarios = Usuario.eliminarUsuario(usuarios, usuarioActual);
                                break;
                            case 6:
                                if (usuarioActual instanceof Profesor) {
                                    examenes = Examen.crearExamen(examenes, (Profesor) usuarioActual);
                                } else {
                                    System.out.println("No eres un profesor.");
                                }
                                break;
                            case 7:
                                Examen.listarExamen(examenes);
                                break;
                            case 8:
                                if (usuarioActual instanceof Alumno) {
                                    usuarioActual = Alumno.participarExamen(examenes, usuarios, usuarioActual);
                                } else {
                                    System.out.println("No eres un alumno.");
                                }
                                break;
                            case 9:
                                if (usuarioActual instanceof Alumno) {
                                    Alumno.verNota((Alumno) usuarioActual, 1);
                                } else {
                                    System.out.println("No eres un alumno.");
                                }
                                break;
                            case 10:
                                if (usuarioActual instanceof Alumno) {
                                    Alumno.verNota((Alumno) usuarioActual, 2);
                                } else {
                                    System.out.println("No eres un alumno.");
                                }
                                break;
                            case 11:
                                salida = true;
                                break;
                            default:
                                System.out.println("Elige una opción válida.");
                                break;
                        }
                    }
                }
            } while (!salir);
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    /**
     * Método para iniciar sesión.
     * @param usuarios Array de usuarios registrados.
     * @return Usuario que ha iniciado sesión.
     */
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

    /**
     * Método para pedir la contraseña de usuario que inicia sesión.
     * @param usuarios Array de usuarios registrados.
     * @param nombreUsuario Nombre de usuario.
     * @return Usuario que ha iniciado sesión.
     */
    private static Usuario pedirContraseña(Usuario[] usuarios, String nombreUsuario) {
        Scanner sc = new Scanner(System.in);
        Usuario usuarioActual = null;

        for (int i = 0; i < usuarios.length; i++) {
            if (compruebaUsuario(usuarios[i], nombreUsuario)) {
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

    /**
     * Método para verificar si existe un usuario con el nombre especificado.
     * @param usuario Usuario a verificar.
     * @param nombre Nombre de usuario a buscar.
     * @return true si el usuario existe, false de lo contrario.
     */
    private static boolean compruebaUsuario(Usuario usuario, String nombre) {
        if (usuario != null && usuario.getNombre().equals(nombre)) {
            return true;
        }
        return false;
    }

    /**
     * Método para verificar si la contraseña proporcionada es correcta para el usuario especificado.
     * @param usuario Usuario a verificar.
     * @param contraseña Contraseña a verificar.
     * @return true si la contraseña es correcta, false de lo contrario.
     */
    private static boolean compruebaContraseña(Usuario usuario, String contraseña) {
        if (usuario != null && usuario.getContraseña().equals(contraseña)) {
            return true;
        }
        return false;
    }

    /**
     * Método para importar datos de usuarios predefinidos.
     * @param usuarios Array de usuarios para importar.
     * @return Array de usuarios con los datos importados.
     */
    private static Usuario[] importarUsuarios(Usuario[] usuarios) {
        // Datos generados con Chat GPT
        usuarios[90] = new Profesor("David_Garcia", "davgar", "1º DAM", "si");
        usuarios[91] = new Profesor("Ana_Martinez", "anamar", "2º DAW", "si");
        usuarios[92] = new Profesor("Laura_Sanchez", "lausan", "1º DAW", "no");
        usuarios[93] = new Profesor("Juan_Perez", "juaper", "2º DAM", "no");
        usuarios[94] = new Profesor("Alejandro_Lopez", "alelop", "1º DAM", "no");
        usuarios[95] = new Alumno("Andres_Martinez", "andmar", "1º DAM");
        usuarios[96] = new Alumno("Sofia_Garcia", "sofgar", "2º DAW");
        usuarios[97] = new Alumno("Javier_Lopez", "javlop", "1º DAW");
        usuarios[98] = new Alumno("Valentina_Rodriguez", "valrod", "2º DAM");
        usuarios[99] = new Alumno("Daniel_Gonzalez", "dangon", "1º DAM");
        return usuarios;
    }

    /**
     * Método para importar datos de exámenes predefinidos.
     * @param examenes Array de exámenes para importar.
     * @return Array de exámenes con los datos importados.
     */
    static Examen[] importarExamenes(Examen[] examenes) {
        // Datos generados con Chat GPT
        String[] preguntas1 = new String[3];
        preguntas1[0] = "¿Qué es un CPU?";
        preguntas1[1] = "¿Qué significa la primera letra de USB?";
        preguntas1[2] = "¿Qué es RAM?";
        String[] respuestas1 = new String[3];
        respuestas1[0] = "Procesador";
        respuestas1[1] = "Universal";
        respuestas1[2] = "Memoria";
        String[] preguntas2 = new String[3];
        preguntas2[0] = "¿Qué es un for?";
        preguntas2[1] = "¿Qué es una variable?";
        preguntas2[2] = "¿Qué es Java?";
        String[] respuestas2 = new String[3];
        respuestas2[0] = "Bucle";
        respuestas2[1] = "Almacenamiento";
        respuestas2[2] = "Lenguaje";
        examenes[0] = new Examen(1, "Sistemas informáticos", preguntas1, respuestas1);
        examenes[1] = new Examen(3, "Programación", preguntas2, respuestas2);
		return examenes;
	}
}
