package proyecto;

import java.util.Scanner;

public class Alumno extends Usuario {
	private Examen[] examenesRealizados;
	private int contadorExamenes;

	public Alumno() {
		super();
	}

	public Alumno(String nombre, String contraseña, String curso) {
		super(nombre, contraseña, curso);
		this.examenesRealizados = new Examen[100];
	}

	public Examen[] getExamenesRealizados() {
		return examenesRealizados;
	}

	public void setExamenesRealizados(Examen examenesRealizados) {
		this.examenesRealizados[this.contadorExamenes] = examenesRealizados;
		contadorExamenes++;
	}

	public void agregarExamen(Examen examenRealizado) {
		for (int i = 0; i < examenesRealizados.length; i++) {
	        if (examenesRealizados[i] == null) {
	            examenesRealizados[i] = examenRealizado;
	        }
	    }
	}

	public static Alumno participarExamen(Examen[] examenes, Usuario[] usuarios, Usuario usuarioActual) {
		Scanner sc = new Scanner(System.in);

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

		return (Alumno) usuarioActual;
	}

	public static void verNota(Alumno usuarioActual, int modo) {
		Scanner sc = new Scanner(System.in);

		if (usuarioActual.getExamenesRealizados() != null) {
			Examen[] examenesRealizados = usuarioActual.getExamenesRealizados();
			switch (modo) {
			case 1: {
				System.out.println("Escribe el id del examen.");
				int idExamen = sc.nextInt();

				for (int i = 0; i < examenesRealizados.length; i++) {
					if (examenesRealizados[i] != null && examenesRealizados[i].getId() == idExamen) {
						System.out.println("Tu nota es " + examenesRealizados[i].getNota() + " sobre "
								+ examenesRealizados[i].getPreguntasContestadas().length + ".");
						i = examenesRealizados.length;
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
		} else {
			System.out.println("No has realizado ningun examen.");
		}
	}
	
	@Override
	public String toString() {
		String cadena = "\n------------------------------------------";
		cadena += "\nID: " + this.id;
		cadena += "\nNombre: " + this.nombre;
		cadena += "\nContraseña: " + this.contraseña;
		cadena += "\nCurso: " + this.curso;
		cadena += "\nExámenes realizados: " + this.examenesRealizados.toString();
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
