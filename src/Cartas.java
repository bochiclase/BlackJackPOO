import java.util.Random;


public class Cartas {

	private static String[] baraja = { "Picas", "Treboles", "Rombos", "Corzones" };

	public String palo() {
		int carta;
		Random r = new Random();
		carta = r.nextInt(4);
		String palo = baraja[carta];
		return palo;

	}

	public int valor() {
		int valor;
		Random r = new Random();
		valor = r.nextInt(13) + 1;
		return valor;

	}

	public int ValorVerdadero(int peso) {

		int ValorVerdadero = peso;
		if (peso > 1 && peso < 11) {
			ValorVerdadero = peso;
		}
		if (peso == 11 || peso == 12 || peso == 13 ) {
			ValorVerdadero = 10;
		}
		if (peso == 1) {
			ValorVerdadero = 11;
		}

		return ValorVerdadero;
	}

	public String figuras(int suma) {

		String figuras = "";

		if (suma > 1 && suma < 11) {
			figuras = Integer.toString(suma);
		}
		if (suma == 11) {
			figuras = "Principe J";
		}
		if (suma == 12) {
			figuras = "Reina Q";
		}
		if (suma == 13) {
			figuras = "Rey K";
		}
		if (suma == 1) {
			figuras = "AS";
		}

		return figuras;

	}

}