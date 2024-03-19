package proyecto;

public class Examen {
	private int id;
	private int tema;
	private String modulo;
	private String[] preguntas;
	private String[] respuestas;
	private String[] preguntasContestadas;
	private int nota;
	private static int contadorExamenes = 1;

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

	public String[] getPreguntas() {
		return preguntas;
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

	@Override
	public String toString() {
		String cadena = "\n------------------------------------------";
		cadena += "\nTema: " + this.tema;
		cadena += "\nMódulo: " + this.modulo;
		cadena += "\nPreguntas: " + this.preguntas;
		cadena += "\nRespuestas: " + this.respuestas;
		cadena += "\nNota: " + this.nota;
		cadena += "\n------------------------------------------";
		return cadena;
	}
}
