package proyecto;

import java.util.Scanner;

/**
 * Clase que representa un Examen en el sistema.
 */
public class Examen {
	private int id;
	private Profesor profesor;
	private int tema;
	private String modulo;
	private String[] preguntas;
	private String[] respuestas;
	private String[] preguntasContestadas;
	private int nota;
	private static int contadorExamenes;

	/**
	 * Constructor por defecto de la clase Examen.
	 */
	public Examen() {
		this.id = contadorExamenes;
		contadorExamenes++;
	}

	/**
	 * Constructor con parámetros de la clase Examen.
	 * 
	 * @param tema       Tema del examen.
	 * @param modulo     Módulo del examen.
	 * @param preguntas  Preguntas del examen.
	 * @param respuestas Respuestas del examen.
	 */
	public Examen(int tema, String modulo, String[] preguntas, String[] respuestas) {
		this.id = contadorExamenes;
		this.tema = tema;
		this.modulo = modulo;
		this.preguntas = preguntas;
		this.respuestas = respuestas;
		contadorExamenes++;
	}

	/**
	 * Constructor con parámetros de la clase Examen.
	 * 
	 * @param tema       Tema del examen.
	 * @param modulo     Módulo del examen.
	 * @param preguntas  Preguntas del examen.
	 * @param respuestas Respuestas del examen.
	 * @param profesor   Profesor que crea el examen.
	 */
	public Examen(int tema, String modulo, String[] preguntas, String[] respuestas, Profesor profesor) {
		this.id = contadorExamenes;
		this.profesor = profesor;
		this.tema = tema;
		this.modulo = modulo;
		this.preguntas = preguntas;
		this.respuestas = respuestas;
		contadorExamenes++;
	}

	/**
	 * Método para obtener el ID del examen.
	 * 
	 * @return ID del examen.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Método para establecer el ID del examen.
	 * 
	 * @param id ID del examen.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Método para obtener el tema del examen.
	 * 
	 * @return Tema del examen.
	 */
	public int getTema() {
		return tema;
	}

	/**
	 * Método para establecer el tema del examen.
	 * 
	 * @param tema Tema del examen.
	 */
	public void setTema(int tema) {
		this.tema = tema;
	}

	/**
	 * Método para obtener el módulo del examen.
	 * 
	 * @return Módulo del examen.
	 */
	public String getModulo() {
		return modulo;
	}

	/**
	 * Método para establecer el módulo del examen.
	 * 
	 * @param modulo Módulo del examen.
	 */
	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	/**
	 * Método para obtener una pregunta específica del examen.
	 * 
	 * @param i Índice de la pregunta.
	 * @return Pregunta específica del examen.
	 */
	public String getPregunta(int i) {
		if (i >= 0 && i < preguntas.length) {
			return preguntas[i];
		} else {
			return "Pregunta no encontrada.";
		}
	}

	/**
	 * Método para establecer las preguntas del examen.
	 * 
	 * @param preguntas Array de preguntas del examen.
	 */
	public void setPreguntas(String[] preguntas) {
		this.preguntas = preguntas;
	}

	/**
	 * Método para obtener las respuestas del examen.
	 * 
	 * @return Array de respuestas del examen.
	 */
	public String[] getRespuestas() {
		return respuestas;
	}

	/**
	 * Método para establecer las respuestas del examen.
	 * 
	 * @param respuestas Array de respuestas del examen.
	 */
	public void setRespuestas(String[] respuestas) {
		this.respuestas = respuestas;
	}

	/**
	 * Método para obtener las preguntas contestadas en el examen.
	 * 
	 * @return Array de preguntas contestadas en el examen.
	 */
	public String[] getPreguntasContestadas() {
		return preguntasContestadas;
	}

	/**
	 * Método para establecer las preguntas contestadas en el examen.
	 * 
	 * @param preguntasContestadas Array de preguntas contestadas en el examen.
	 */
	public void setPreguntasContestadas(String[] preguntasContestadas) {
		this.preguntasContestadas = preguntasContestadas;
	}

	/**
	 * Método para obtener la nota del examen.
	 * 
	 * @return Nota del examen.
	 */
	public int getNota() {
		return nota;
	}

	/**
	 * Método para establecer la nota del examen.
	 * 
	 * @param nota Nota del examen.
	 */
	public void setNota(int nota) {
		this.nota = nota;
	}

	/**
	 * Método para corregir el examen y obtener la nota.
	 * 
	 * @return Nota del examen.
	 */
	public int corregir() {
		int nota = 0;
		for (int i = 0; i < this.preguntas.length; i++) {
			if (this.respuestas[i].equalsIgnoreCase(this.preguntasContestadas[i])) {
				nota++;
			}
		}

		return nota;
	}

	/**
	 * Método estático para que un profesor cree un examen.
	 * 
	 * @param examenes      Arreglo de exámenes existentes.
	 * @param usuarioActual Profesor que está creando el examen.
	 * @return Array de exámenes actualizado con el nuevo examen.
	 */
	public static Examen[] crearExamen(Examen[] examenes, Profesor usuarioActual) {
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Escribe el módulo.");
			String modulo = sc.next();
			sc.nextLine();

			System.out.println("Escribe el tema.");
			int tema = sc.nextInt();
			sc.nextLine();

			String[] preguntas = new String[5];
			String[] respuestas = new String[5];

			boolean salir2 = false;
			while (!salir2) {
				for (int i = 0; i < 5; i++) {
					System.out.println("Escribe la pregunta.");
					preguntas[i] = sc.nextLine();

					System.out.println("Escribe la respuesta.");
					respuestas[i] = sc.nextLine();
				}

				for (int i = 0; i < examenes.length; i++) {
					examenes[i] = new Examen(tema, modulo, preguntas, respuestas, usuarioActual);
					salir2 = true;
				}
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		return examenes;
	}

	/**
	 * Método estático para listar los exámenes.
	 * 
	 * @param examenes Array de exámenes a listar.
	 */
	public static void listarExamen(Examen[] examenes) {
		for (Examen examen : examenes) {
			if (examen != null) {
				System.out.println(examen.toString());
			}
		}
	}

	/**
	 * Método toString para representar un Examen como cadena de texto.
	 * 
	 * @return Representación del examen como cadena de texto.
	 */
	@Override
	public String toString() {
		String cadena = "\n------------------------------------------";
		cadena += "\nID: " + this.id;
		cadena += "\nTema: " + this.tema;
		cadena += "\nMódulo: " + this.modulo;
		cadena += "\nProfesor: " + this.profesor;
		cadena += "\nPreguntas: ";
		if (preguntas != null) {
			for (String pregunta : preguntas) {
				if (pregunta != null) {
					cadena += "\n" + pregunta.toString();
				}
			}
		} else {
			cadena += "\nNo hay preguntas.";
		}
		cadena += "\nRespuestas: ";
		if (respuestas != null) {
			for (String respuesta : respuestas) {
				if (respuesta != null) {
					cadena += "\n" + respuesta.toString();
				}
			}
		} else {
			cadena += "\nNo hay respuestas.";
		}
		cadena += "\nNota: " + this.nota;
		cadena += "\n------------------------------------------";
		return cadena;
	}
}
