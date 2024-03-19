package proyecto;

import java.util.Scanner;

/**
 * Clase que representa a un Alumno en el sistema, que extiende de Usuario.
 */
public class Alumno extends Usuario {
	private Examen[] examenesRealizados;
	private int contadorExamenes;

	/**
	 * Constructor por defecto de la clase Alumno.
	 */
	public Alumno() {
		super();
	}

	/**
	 * Constructor con parámetros de la clase Alumno.
	 * 
	 * @param nombre     Nombre del alumno.
	 * @param contraseña Contraseña del alumno.
	 * @param curso      Curso del alumno.
	 */
	public Alumno(String nombre, String contraseña, String curso) {
		super(nombre, contraseña, curso);
		this.examenesRealizados = new Examen[100];
	}

	/**
	 * Método para obtener los exámenes realizados por el alumno.
	 * 
	 * @return Array de exámenes realizados.
	 */
	public Examen[] getExamenesRealizados() {
		return examenesRealizados;
	}

	/**
	 * Método para agregar un examen realizado por el alumno.
	 * 
	 * @param examenRealizado Examen realizado por el alumno.
	 */
	public void setExamenesRealizados(Examen examenRealizado) {
		this.examenesRealizados[this.contadorExamenes] = examenRealizado;
		contadorExamenes++;
	}

	/**
	 * Método para agregar un examen realizado por el alumno.
	 * 
	 * @param examenRealizado Examen realizado por el alumno.
	 */
	public void agregarExamen(Examen examenRealizado) {
		for (int i = 0; i < examenesRealizados.length; i++) {
			if (examenesRealizados[i] == null) {
				examenesRealizados[i] = examenRealizado;
			}
		}
	}

	/**
	 * Método estático que permite a un alumno participar en un examen.
	 * 
	 * @param examenes      Array de exámenes disponibles.
	 * @param usuarios      Array de usuarios en el sistema.
	 * @param usuarioActual Usuario que está participando en el examen.
	 * @return El alumno actualizado después de participar en el examen.
	 */
	public static Alumno participarExamen(Examen[] examenes, Usuario[] usuarios, Usuario usuarioActual) {
		Scanner sc = new Scanner(System.in);

		try {
			if (examenes != null) {
				System.out.println("Escribe el id del examen.");
				int idExamen = sc.nextInt();

				for (Examen examen : examenes) {
					if (examen != null && examen.getId() == idExamen) {
						String[] preguntasContestada = new String[3];

						for (int i = 0; i < 3; i++) {
							System.out.println(examen.getPregunta(i));
							preguntasContestada[i] = sc.next();
						}

						examen.setPreguntasContestadas(preguntasContestada);
						int nota = examen.corregir();
						examen.setNota(nota);

						if (usuarioActual instanceof Alumno) {
							Alumno alumno = (Alumno) usuarioActual;
							alumno.agregarExamen(examen);
							return alumno;
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error: " + e.getMessage());
		}

		return (Alumno) usuarioActual;
	}

	/**
	 * Método estático que permite a un alumno ver la nota de un examen.
	 * 
	 * @param usuarioActual Alumno que desea ver la nota.
	 * @param modo          Modo de visualización de la nota.
	 */
	public static void verNota(Alumno usuarioActual, int modo) {
		Scanner sc = new Scanner(System.in);

		try {
			if (usuarioActual.getExamenesRealizados() != null) {
				Examen[] examenesRealizados = usuarioActual.getExamenesRealizados();
				switch (modo) {
				case 1: {
					System.out.println("Escribe el id del examen.");
					int idExamen = sc.nextInt();

					for (Examen examen : examenesRealizados) {
						if (examen != null && examen.getId() == idExamen) {
							System.out.println("Tu nota es " + examen.getNota() + " sobre "
									+ examen.getPreguntasContestadas().length + ".");
							return;
						}
					}
					System.out.println("El examen no fue encontrado.");
				}
					break;
				case 2:
					for (Examen examen : examenesRealizados) {
						if (examen != null) {
							System.out.println(examen.getNota());
						}
					}
					break;
				}
			} else {
				System.out.println("No has realizado ningun examen.");
			}
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error: " + e.getMessage());
		}
	}

	/**
	 * Método que devuelve una representación en forma de cadena del objeto Alumno.
	 * 
	 * @return Cadena que representa al alumno.
	 */
	@Override
	public String toString() {
		String cadena = "\n------------------------------------------";
		cadena += "\nID: " + this.id;
		cadena += "\nNombre: " + this.nombre;
		cadena += "\nContraseña: " + this.contraseña;
		cadena += "\nCurso: " + this.curso;
		cadena += "\nExámenes realizados: ";
		if (examenesRealizados != null) {
			for (Examen examen : examenesRealizados) {
				if (examen != null) {
					cadena += "\n" + examen.toString();
				}
			}
		} else {
			cadena += "\nNo hay exámenes realizados.";
		}
		cadena += "\n------------------------------------------";
		return cadena;
	}
}
