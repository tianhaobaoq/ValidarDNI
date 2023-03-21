package validardni;
import javax.swing.JOptionPane;
public class ValidarDNI {
	static final String LETRAS_DNI="TRWAGMYFPDXBNJZSQVHLCKE";
	
	static char extraerLetraDNI (String DNI) {
		return DNI.charAt(DNI.length()-1);
	}
	
	static int extraerNumeroDNI (String DNI) {
		return Integer.parseInt(DNI.substring(0, DNI.length()-1));
	}
	
	static char calcularLetraDNI (int numerosDNI) {
		return LETRAS_DNI.charAt(numerosDNI%23);
	}
	
	static boolean validarDNI (String DNI) {
		if(DNI.length()!=9) {
			return false;
		}
		
		for(int i=0;i<8;i++) {
			if (Character.isDigit(DNI.charAt(i)) == false) {
			return false;
			}
		}
		
		if (Character.isLetter(DNI.charAt(8)) == false) {
			return false;
		}
		
		char letra = Character.toUpperCase(extraerLetraDNI(DNI));
		int numero = extraerNumeroDNI(DNI);
		if(((calcularLetraDNI(numero)) == letra)) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		String DNI = JOptionPane.showInputDialog(null, "Inserte el DNI a validar: ");
		boolean valido = validarDNI(DNI);
		if (valido == true) {
			JOptionPane.showMessageDialog(null, "El DNI indicado es válido");
		}else {
			JOptionPane.showMessageDialog(null, "El DNI indicado no es válido");

		}
		
	}
}
