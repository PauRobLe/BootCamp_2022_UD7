/**
 * @author Pau Robuste
 */
import java.util.Hashtable;
import javax.swing.JOptionPane;
public class VentasSupermercadoApp {
	//Variables Globales - Inicio a 0 - Limpio
	static double precioSIVA=0, precioIVA=0, precioTotalSIVA=0, precioTotalIVA=0, cambio=0;
	static String IVA;
	
	public static void main(String[] args) {
		//Contdor Productos
		int cont=0;
		
		Hashtable<String, Double> caja = new Hashtable<String,Double>(); 
		//Listado Objetos-Productos y su precio
		caja.put("260100", 20.00);
		caja.put("260101", 15.00);
		caja.put("260102", 1.50);
		caja.put("260103", 2.00);
		caja.put("260104", 7.25);
		caja.put("260105", 17.99);
		
		String quantS = JOptionPane.showInputDialog("Cuantos productos distintos lleva usted en el carro de la compra?");
		int cantidadTotal = Integer.parseInt(quantS);
		//Bucle productos comprados
		do {
			
			String cod = JOptionPane.showInputDialog("Cual es el identificador del producto que ha comprado?");
			//cantidadidad del producto
			String cantidad = JOptionPane.showInputDialog("Quantos lleva?");
			int quant = Integer.parseInt(cantidad);
			
			precioSIVA = calcularPrecio(caja, cod, quant);
			precioTotalSIVA += precioSIVA;
			String IVA = JOptionPane.showInputDialog("Cual es el IVA del producto introducido?\n1 - 21%\n2 - 4%");
			precioIVA = calcularIVA(precioSIVA, IVA);
			precioTotalIVA += precioIVA;
			
			cont++;
		}while(cont!=cantidadTotal);
		//Bolsa con la cantidad de articulos
		System.out.println("Usted ha comprado un total de " + cont + " articulo/s");
		//Precio sin IVA
		System.out.println("El precio total sin IVA es de " + precioSIVA);
		//Precio con IVA
		System.out.println("El precio total con IVA es de " + precioIVA);
		
		String cantidadPag = JOptionPane.showInputDialog("Usted tiene que pagar " + precioIVA + "cuanto desea pagar?");
		double pagado = Double.valueOf(cantidadPag);
		
		cambio = cambioPag(pagado, precioTotalIVA);
		
		System.out.println("El cambio es de " + cambio + "€");
	}

	//Calculamos el precio sin IVA
	public static double calcularPrecio(Hashtable<String,Double> ref, String cod, int quant) { 
		double precio=0;
		
		for(String i : ref.keySet()) {
			if(i.equals(cod)) {
				precio = ref.get(i);	
			}		
		}
		precio = precio * quant;	
		return precio;
	}
	
	//Calculo el IVA
	public static double calcularIVA(double precio, String IVA) {
		double pfinal = 0;
		
		if(IVA == "1") {
			pfinal = precio + (precio * 0.21);
		}else {
			pfinal = precio + (precio * 0.04);
		}
		return pfinal;
	}
	
	//Calculo cambio 
	public static double cambioPag(double pagado, double precioTotalIVA) {
		double cambio=0;
		
		cambio = pagado - precioTotalIVA;
		return cambio;
	}
}