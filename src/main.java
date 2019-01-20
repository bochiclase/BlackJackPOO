import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		char contestacion;
		char afi = 's';
		Cartas pieza = new Cartas();

		do {
			System.out.println("           ¿¿¿Quieres Jugar???");
			System.out.println();
			System.out.println("                 Pulsa S");
			contestacion = sc.next().charAt(0);
			
			
			if (Character.toLowerCase(contestacion) != afi) {
				System.out.println("ADIOS");
				break;
			}

			
			
			else {
				// PARA JUGADOR
				int sumajugador = 0;
				int resta = 0;
				int pesojugador;
				int preciojugador;
				String cartajugador;
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println("#################################################");
				System.out.println("    TUS CARTAS SON");
				System.out.println();
				for (int i = 1; i < 3; i++) {
					pesojugador = pieza.valor();
					preciojugador = pieza.ValorVerdadero(pesojugador);
					cartajugador = pieza.figuras(pesojugador);
					System.out
							.println("La carta es " + cartajugador + " de " + pieza.palo() + " vale " + preciojugador);
					sumajugador += preciojugador;
					resta = 21 - sumajugador;
				}
				System.out.println();
				System.out.println("--------------------------------");
				System.out.println("El valor de tus cartas es " + sumajugador);
				System.out.println("--------------------------------");
				System.out.println("Te faltan " + resta + " para BLACKJACK");
				System.out.println();
				System.out.println();

				
				
				
				// PARA EL CRUPIER
				int sumacrupier = 0;
				int pesocrupier = pieza.valor();
				int preciocrupier = pieza.ValorVerdadero(pesocrupier);
				String cartacrupier = pieza.figuras(pesocrupier);
				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
				System.out.println("    CARTAS DE LA BANCA");
				System.out.println();
				System.out
						.println("La banca muestra " + cartacrupier + " de " + pieza.palo() + " vale " + preciocrupier);
				sumacrupier += preciocrupier;
				System.out.println();

				if (sumajugador == 21) {
					System.out.println("HAS GANADO, QUE SUERTE TIENES BLACKJACK EN LA PRIMERA MANO");
					;
				} else {
					
					
					// Pregunta

					Scanner t = new Scanner(System.in);
					char letra;
					char si = 's';
					char no = 'n';

					do {
						System.out.println();
						System.out.println();
						System.out.println("                          ¿QUIERES OTRA CARTA?");
						System.out.println();
						System.out.println(      "Pulsa S para SI o Pulsa N para NO.   Recuerda llevas un TOTAL de " + sumajugador);

						letra = t.next().charAt(0);

						if (Character.toLowerCase(letra) == si) {

							pesojugador = pieza.valor();
							preciojugador = pieza.ValorVerdadero(pesojugador);
							cartajugador = pieza.figuras(pesojugador);
							System.out.println();
							System.out.println("#################################################");
							System.out.println("    TUS CARTAS SON");
							System.out.println();
							System.out.println(
									"La carta es " + cartajugador + " de " + pieza.palo() + " vale " + preciojugador);
							sumajugador += preciojugador;
							resta = 21 - sumajugador;
							System.out.println();
							System.out.println("--------------------------------");
							System.out.println("El valor de tus cartas es " + sumajugador);
							System.out.println("--------------------------------");
							System.out.println();
							if (sumajugador > 21) {
								System.out.println("Lo siento te has pasado");
								System.out.println("La BANCA GANA Tu pierdes");
							}

							else {
								System.out.println("Te faltan " + resta + " para BLACKJACK");
								System.out.println();

							}

						}

						if (Character.toLowerCase(letra) == no) {

							do {
								int pesocrupier2 = pieza.valor();
								int preciocrupier2 = pieza.ValorVerdadero(pesocrupier2);
								String cartacrupier2 = pieza.figuras(pesocrupier2);
								System.out.println();
								System.out.println();
								System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
								System.out.println("    CARTAS DE LA BANCA");
								System.out.println();
								System.out.println("La banca muestra " + cartacrupier2 + " de " + pieza.palo()
										+ " vale " + preciocrupier2);
								sumacrupier += preciocrupier2;
								System.out.println();
								System.out.println();
								System.out.println("La  BANCA tiene " + sumacrupier);

							} while (sumacrupier < 17 || sumacrupier < sumajugador);

							System.out.println("TU tienes " + sumajugador);
							System.out.println();
							System.out.println();

							if (sumacrupier == sumajugador) {

								System.out.println("EMPATES");
								System.out.println();
								System.out.println();
								break;
							}

							if (sumacrupier < sumajugador && sumajugador < 22 || sumacrupier > 21
									|| sumajugador == 21) {
								System.out.println("ENORABUENA HAS GANADO");
								System.out.println();
								System.out.println();
								break;
							}

							if (sumacrupier > sumajugador && sumacrupier < 22 || sumacrupier == 21) {
								System.out.println("Lo siento has perdido, la BANCA GANA");
								System.out.println();
								System.out.println();
								break;
							}

						}
						if (sumajugador == 21) {

							System.out.println("TIENES BLACKJACK");
							System.out.println();
							System.out.println();
							break;
						}

					} while (Character.toLowerCase(letra) != si || Character.toLowerCase(letra) != no);

				}
			}
		} while (Character.toLowerCase(contestacion) == afi);
		sc.close();
	}

}
