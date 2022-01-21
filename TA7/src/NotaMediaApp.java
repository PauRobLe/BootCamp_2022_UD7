/**
 * @author Pau Robuste
 */
//IMPORTS
import java.util.Hashtable;
import javax.swing.JOptionPane;
//Inicio
public class NotaMediaApp {
	
	static Hashtable<String,String> alumnoNota = new Hashtable<String,String>();
	static int totalAlumnos=0;
	
	public static void main(String[] args) {
		//Variable
		int opcio=0;
		//Bucle - Menu Opciones
		do {
			String res = JOptionPane.showInputDialog("Seleccione una opcion: \n 1-Introducir alumnos y asignar notas \n 2-Mostrar alumnos y notas \n 3-Salir");
			opcio = Integer.parseInt(res);
			
			switch(opcio) {
			case 1:
				listaAlumnos();
			break;
			case 2:
				mostrarAlumnos();
			break;
			case 3:
				break;
			}	
		}while(opcio!=3);
	}
	//Listar Alumnos - Mostrar Alumno segun el nombre introducido
	public static void listaAlumnos() {
		
		double media=0, nota=0, suma=0, i=0;
		String nombre = JOptionPane.showInputDialog("Introduce el nombre del alumno?"); 
		
		do {
			//Mostrar nota del alumno y salir
			String n = JOptionPane.showInputDialog("Nota del alumno (Exit = 0)"); 
			alumnoNota.put(nombre, n); 
			nota = Double.parseDouble(n); 
			suma=suma+nota; 
			i++; 
		
		}while(nota!=0);
		i--;
		media = suma/i; 
		String mediaS = String.valueOf(media); 
		alumnoNota.put(nombre, mediaS);	
		totalAlumnos ++;
		
	}
	//Mostrar alumno con notas
	public static void mostrarAlumnos() {
		
		System.out.println("Alumno - Nota");		
		for(String i : alumnoNota.keySet()) {	
			System.out.println(i + " - " + alumnoNota.get(i));		
		}	
	}
} // - Final del  programa