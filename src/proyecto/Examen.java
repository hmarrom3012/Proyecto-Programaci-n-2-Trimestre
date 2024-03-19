package proyecto;

import java.util.Scanner;

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

	enum Tipo {
		TEST, TEORICO
	}

	public Examen() {
		this.id = contadorExamenes;
		contadorExamenes++;
	}
	
	public Examen(int tema, String modulo, String[] preguntas, String[] respuestas) {
		this.id = contadorExamenes;
		this.tema = tema;
		this.modulo = modulo;
		this.preguntas = preguntas;
		this.respuestas = respuestas;
		contadorExamenes++;
	}

	public Examen(int tema, String modulo, String[] preguntas, String[] respuestas, Profesor profesor) {
		this.id = contadorExamenes;
		this.profesor = profesor;
		this.tema = tema;
		this.modulo = modulo;
		this.preguntas = preguntas;
		this.respuestas = respuestas;
		contadorExamenes++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTema() {
		return tema;
	}

	public void setTema(int tema) {
		this.tema = tema;
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public String getPregunta(int i) {
        if (i >= 0 && i < preguntas.length) {
            return preguntas[i];
        } else {
            return "Pregunta no encontrada.";
        }
    }

	public void setPreguntas(String[] preguntas) {
		this.preguntas = preguntas;
	}

	public String[] getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(String[] respuestas) {
		this.respuestas = respuestas;
	}

	public String[] getPreguntasContestadas() {
		return preguntasContestadas;
	}

	public void setPreguntasContestadas(String[] preguntasContestadas) {
		this.preguntasContestadas = preguntasContestadas;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public int corregir() {
		int nota = 0;
		for (int i = 0; i < this.preguntas.length; i++) {
			if (this.respuestas[i].equalsIgnoreCase(this.preguntasContestadas[i])) {
				nota++;
			}
		}
		
		return nota;
	}

	public static Examen[] crearExamen(Examen[] examenes, Profesor usuarioActual) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Escribe el módulo.");
		String modulo = sc.next();

		System.out.println("Escribe el tema.");
		int tema = sc.nextInt();

		String[] preguntas2 = new String[5];
		String[] respuestas2 = new String[5];

		boolean salir2 = false;
		while (!salir2) {
			for (int i = 0; i < 10; i++) {
				System.out.println("Escribe la pregunta.");
				preguntas2[i] = sc.next();

				System.out.println("Escribe la respuesta.");
				respuestas2[i] = sc.next();
			}

			for (int i = 0; i < examenes.length; i++) {
				examenes[i] = new Examen(tema, modulo, preguntas2, respuestas2, usuarioActual);
				salir2 = true;
			}
		}

		return examenes;
	}

	public static void listarExamen(Examen[] examenes) {
		for (Examen examen : examenes) {
			if (examen != null) {
				System.out.println(examen.toString());
			}
		}
	}
	
	@Override
	public String toString() {
		String cadena = "\n------------------------------------------";
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
