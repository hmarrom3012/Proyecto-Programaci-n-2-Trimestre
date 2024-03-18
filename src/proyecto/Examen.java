package proyecto;

public class Examen {
	private int tema;
	private Modulo modulo;
	private Tipo tipo;
	private String[] preguntas;
	private String[] respuestas;
	private int nota;

	enum Tipo {
		TEST, TEORICO
	}

	public Examen() {
	}

	public Examen(int tema, Modulo modulo, Tipo tipo, String[] preguntas, String[] respuestas) {
		this.tema = tema;
		this.modulo = modulo;
		this.tipo = tipo;
		this.preguntas = preguntas;
		this.respuestas = respuestas;
	}

	public int getTema() {
		return tema;
	}

	public void setTema(int tema) {
		this.tema = tema;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
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

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		String cadena = "\n------------------------------------------";
		cadena += "\nTema: " + this.tema;
		cadena += "\nMódulo: " + this.modulo;
		cadena += "\nTipo: " + this.tipo;
		cadena += "\nPreguntas: " + this.preguntas;
		cadena += "\nRespuestas: " + this.respuestas;
		cadena += "\nNota: " + this.nota;
		cadena += "\n------------------------------------------";
		return cadena;
	}

}
