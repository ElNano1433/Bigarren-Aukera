package Erronka;

import java.util.Scanner;

/**
 * Clase principal para la aplicación de gestión de la protectora y tienda
 * "Erronka". Permite listar, registrar, modificar y adoptar animales, además de
 * gestionar la compra de productos (merchandising, juguetes y comida) con
 * cálculo de descuentos y generación de facturas.
 *
 * @author Erronka
 * @version 1.0
 */
public class Aplikazioa {
	// Constantes de códigos ANSI para dar colores y estilos a los menús impresos en
	// consola
	public static final String RESET = "\u001B[0m";
	public static final String COLOR_1 = "\u001B[38;5;66m";
	public static final String ROJO = "\u001B[31m";
	public static final String COLOR_2 = "\u001B[38;5;187m";
	public static final String AZUL = "\u001B[34m";
	public static final String COLOR_3 = "\u001b[38;2;161;65;0m";
	public static final String COLOR_4 = "\u001B[38;2;11;196;229m";
	public static final String COLOR_5 = "\u001B[38;2;255;153;234m";
	public static final String COLOR_6 = "\u001B[38;2;255;20;20m";
	public static final String GRISF4 = "\u001B[38;2;74;74;74m";
	public static final String VERDE_HEX = "\u001B[38;2;42;245;39m";
	public static final String NARANJA_HEX = "\u001B[38;2;245;125;39m";
	public static final String CELESTE_HEX = "\u001B[38;5;117m";

	
	/**
	 * Muestra una lista simplificada de los animales registrados (solo nombre y
	 * edad).
	 *
	 * @param a Array con los nombres de los animales.
	 * @param b Array con las edades de los animales.
	 */
	public static void izenadina(String[] a, String[] b) {
		// Recorremos las posiciones de los arrays de nombres y edades
		for (int i = 0; i < a.length; i++) {
			// Comprobamos que la posición no esté vacía en ambos arrays
			if (a[i] != null || b[i] != null) {
				System.out.println(" ");
				System.out.print("Animaliaren izena: " + a[i] + ", ");
				System.out.print("Animali adina: " + b[i] + ", ");
			}
		}
		System.out.println(" ");
	}

	/**
	 * Busca un animal por su nombre y actualiza su edad con un nuevo valor
	 * validado.
	 *
	 * @param a Array de nombres de animales.
	 * @param b Nombre del animal a modificar.
	 * @param c Array con las edades actuales de los animales.
	 * @return El array de edades actualizado con la nueva cifra introducida.
	 */
	public static String[] aldatu(String[] a, String b, String[] c, Scanner teklatua) {
		String adina = " ";
		boolean balidatu = false; // Flag para controlar el bucle de validación

		do {
			// Recorremos el array para encontrar el animal indicado
			for (int i = 0; i < a.length; i++) {
				// Comparamos sin diferenciar mayúsculas de minúsculas
				if (b.equalsIgnoreCase(a[i])) {
					try {
						System.out.print("Sartu adina berri: ");
						adina = teklatua.nextLine();
						// Intentamos parsear a entero para comprobar que es un número válido
						int ad = Integer.parseInt(adina);
						c[i] = adina; // Guardamos la nueva edad
						balidatu = true; // Marcamos como válido para salir del bucle
					} catch (NumberFormatException e) {
						// Notificamos el error si no ha introducido un número
						System.out.println("Mesedez sartu zenbaki bat.");
						balidatu = false;
					}
				}
			}
		} while (balidatu == false);
		return c;
	}

	/**
	 * Muestra una lista completa y detallada de los animales registrados (nombre,
	 * especie, edad y raza/color).
	 *
	 * @param a Array con los tipos/especies de los animales.
	 * @param b Array con las edades.
	 * @param c Array con las razas o colores.
	 * @param d Array con los nombres.
	 */
	public static void animaliakerakutsi(String[] a, String[] b, String[] c, String[] d, String[] e) {
		// Recorremos los datos de los animales
		for (int i = 0; i < a.length; i++) {
			// Solo imprimimos si al menos uno de los atributos de la posición no es nulo
			if (a[i] != null || b[i] != null || c[i] != null || d[i] != null || e[i] !=null) {
				System.out.println(" ");
				System.out.print("Animaliaren ID: " + a[i] + ", "); 
				System.out.print("Animaliaren izena: " + e[i] + ", "); 
				System.out.print("Animali mota: " + b[i] + ", "); 
				System.out.print("Adina: " + c[i] + ", "); 
				System.out.print("Arraza edo kolorea: " + d[i]); 
				System.out.println(" ");
			}
		}
		System.out.println(" ");
	}

	/**
	 * Calcula la suma total de euros en descuentos aplicables según la condición
	 * del comprador.
	 *
	 * @param a Subtotal acumulado de las compras realizadas en euros.
	 * @param b Indicador de adopción previa ('B'/'b' para SÍ, 'E'/'e' para NO).
	 *          Otorga un 10% de descuento.
	 * @param c Indicador de socio ('B'/'b' para SÍ, 'E'/'e' para NO). Otorga un 5%
	 *          de descuento.
	 * @return Importe total de euros descontados.
	 */
	public static double desk(int a, char b, char c) {
		double adopt = 0;
		double socio = 0;

		// Descuento por adopción (10%)
		if (b == 'B' || b == 'b') {
			adopt = a * 0.1;
		}

		// Descuento por condición de socio (5%)
		if (c == 'B' || c == 'b') {
			socio = a * 0.05;
		}

		double totaldesk = socio + adopt;
		return totaldesk;
	}

	/**
	 * Calcula el coste total de la selección de alimento según el producto y la
	 * cantidad elegidos.
	 *
	 * @param a Opción elegida (1: Pienso gato 1kg, 2: Pienso gato 5kg, 3: Pienso
	 *          perro 1kg, 4: Pienso perro 5kg).
	 * @param b Cantidad de unidades del producto.
	 * @return El importe total resultante de multiplicar precio unitario por
	 *         cantidad.
	 */
	public static int janaria(int a, int b) {
		// Asignación de precio unitario en función de la opción elegida
		if (a == 1) {
			a = 5; // Pienso gato 1kg -> 5€
		} else if (a == 2) {
			a = 25; // Pienso gato 5kg -> 25€
		} else if (a == 3) {
			a = 5; // Pienso perro 1kg -> 5€
		} else {
			a = 25; // Pienso perro 5kg -> 25€
		}

		return a * b; // Subtotal = Precio unitario * Cantidad
	}

	/**
	 * Calcula el coste total de la selección de juguetes según la opción y la
	 * cantidad elegidos.
	 *
	 * @param a Opción elegida (1: Pelota, 2: Juego interactivo, 3: Vara con plumas,
	 *          4: Castillo).
	 * @param b Cantidad de unidades.
	 * @return El importe total de los juguetes seleccionados.
	 */
	public static int jostailuak(int a, int b) {
		// Asignación de precio unitario en función del juguete
		if (a == 1) {
			a = 5; // Pelota -> 5€
		} else if (a == 2) {
			a = 20; // Juego interactivo -> 20€
		} else if (a == 3) {
			a = 5; // Vara con plumas -> 5€
		} else {
			a = 10; // Castillo para gatos -> 10€
		}

		return a * b; // Subtotal = Precio unitario * Cantidad
	}

	/**
	 * Calcula el coste total de la selección de merchandising según el artículo y
	 * la cantidad.
	 *
	 * @param a Opción elegida (1: Camiseta, 2: Sudadera, 3: Mochila).
	 * @param b Cantidad de unidades.
	 * @return El importe total de los productos de merchandising.
	 */
	public static int merch(int a, int b) {
		// Asignación de precio unitario según el producto de merchandising
		if (a == 1) {
			a = 10; // Camiseta -> 10€
		} else if (a == 2) {
			a = 20; // Sudadera -> 20€
		} else {
			a = 15; // Mochila -> 15€
		}

		return a * b; // Subtotal = Precio unitario * Cantidad
	}

	/**
	 * Solicita los datos de descuentos al usuario, calcula el precio final
	 * acumulado e imprime la factura.
	 *
	 * @param subtotala Subtotal bruto acumulado por las compras.
	 */
	public static void fakturaErakutsi(int subtotala, Scanner teklatua) {
		// Pregunta si el cliente ha adoptado un animal
		System.out.println(" ");
		System.out.println("Badaukazu hemengo animalirik adoptatuta? (B/E) ");
		String zbk = teklatua.nextLine();
		char adopt = zbk.isEmpty() ? 'E' : zbk.charAt(0);

		// Pregunta si el cliente es socio
		System.out.println("Gure enpresaren sozioa zara? (B/E) ");
		zbk = teklatua.nextLine();
		char socio = zbk.isEmpty() ? 'E' : zbk.charAt(0);

		// Cálculo de los descuentos aplicables y precio con descuento
		double tot = desk(subtotala, adopt, socio);
		double prezioF = subtotala - tot;

		// Impresión formateada del resumen de la compra
		// Definimos el formato para las filas de datos.
		// %-25s = Texto alineado a la izquierda, ocupando exactamente 25 caracteres.
		// Formato puro de texto: %-25s para la etiqueta y %8s para el precio
		// Modificamos el formato para recibir: [color], [texto de 25 caracteres], [reset], [precio]
		String formatoFila = "  | %s%-25s%s %8s    |\n";

		System.out.println("  +---------------------------------------+");
		System.out.println("  |               "+AZUL+"FAKTURA"+RESET+"                 |");
		System.out.println("  +---------------------------------------+");

		// Pasamos las variables de color por separado
		System.out.printf(formatoFila, NARANJA_HEX, "Subtotala:", RESET, subtotala + "€");
		System.out.printf(formatoFila, VERDE_HEX, "Deskontua:", RESET, tot + "€");

		System.out.println("  |---------------------------------------|");
		System.out.printf(formatoFila, CELESTE_HEX, "Deskontuak aplikatuta:", RESET, prezioF + "€");

		System.out.println("  +---------------------------------------+");
		System.out.println();

	}

	/**
	 * Limpia la pantalla de la consola según el sistema operativo detectado
	 * (Windows o basado en Unix).
	 */
	public static void limpiarConsola() {
		try {
			if (System.getProperty("os.name").contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				new ProcessBuilder("clear").inheritIO().start().waitFor();
			}
		} catch (Exception e) {
			// En caso de error al ejecutar comandos del sistema, añade varias líneas para
			// simular limpieza
			System.out.println("\n\n");
		}
	}

	/**
	 * Método principal que ejecuta la aplicación. Inicializa los datos
	 * predeterminados, muestra los menús iterativos y coordina la lógica del
	 * sistema.
	 *
	 * @param args Argumentos de la línea de comandos (no utilizados).
	 */
	public static void main(String[] args) {

		Scanner teklatua = new Scanner(System.in);

		// Inicialización de arrays paralelos para registrar hasta 10 animales
		String[] animaliizena = new String[10];
		animaliizena[0] = "Jacobo";
		animaliizena[1] = "Luis";
		animaliizena[2] = "Pedro";
		animaliizena[3] = "DiGref";

		String[] animaliamota = new String[10];
		animaliamota[0] = "Katua";
		animaliamota[1] = "Txakurra";
		animaliamota[2] = "Txakurra";
		animaliamota[3] = "Katua";

		String[] adina = new String[10];
		adina[0] = "1";
		adina[1] = "3";
		adina[2] = "12";
		adina[3] = "4";

		String[] arraza = new String[10];
		arraza[0] = "Laranja";
		arraza[1] = "Chihuahua";
		arraza[2] = "Bichon maltes";
		arraza[3] = "Zuria eta beltza";
		
		String[] animaliid = new String[10];
		animaliid[0] = "ID-001";
		animaliid[1] = "ID-002";
		animaliid[2] = "ID-003";
		animaliid[3] = "ID-004";

		int aukera = 0; // Opción del menú principal
		boolean balmenu1 = true; // Control de validación de entrada entera
		String zbk = " "; // Lectura de texto del Scanner

		// BUCLE PRINCIPAL DEL PROGRAMA
		do {
			// Bucle de presentación y validación del menú principal
			do {
				System.out.println("|-------------" + COLOR_1 + "BIGARREN AUKERA" + RESET + "--------------|" + COLOR_3
						+ "   / \\__" + RESET);
				System.out.println("|==========================================|" + COLOR_3 + "  (    " + RESET
						+ COLOR_4 + "@" + RESET + COLOR_3 + "\\___" + RESET);
				System.out.println("|1. " + COLOR_2 + "Adopzioan dauden animaliak ikusi" + RESET + "       |" + COLOR_3
						+ "  /         " + RESET + COLOR_5 + "O" + RESET);
				System.out.println("|==========================================|" + COLOR_3 + " /   (_" + RESET + GRISF4
						+ "____/" + RESET);
				System.out.println("|2. " + COLOR_2 + "Produktuak erosi" + RESET + "                       |" + COLOR_3
						+ "/_____/   " + RESET + COLOR_6 + "U" + RESET);
				System.out.println("|==========================================|" + COLOR_3 + "   / \\__" + RESET);
				System.out.println("|3. " + COLOR_2 + "Zerbitzuak eraldatu edo kontratatu" + RESET + "     |" + COLOR_3
						+ "  (    " + RESET + COLOR_4 + "@" + RESET + COLOR_3 + "\\___" + RESET);
				System.out.println("|==========================================|" + COLOR_3 + "  /         " + RESET
						+ COLOR_5 + "O" + RESET);
				System.out.println("|4. " + ROJO + "Irten" + RESET + "                                  |" + COLOR_3
						+ " /   (_" + RESET + GRISF4 + "____/" + RESET);
				System.out.println("|==========================================|" + COLOR_3 + "/_____/   " + RESET
						+ COLOR_6 + "U" + RESET);
				System.out.print(AZUL + "Aukeratu -> " + RESET);

				zbk = teklatua.nextLine();
				limpiarConsola();
				balmenu1 = true;

				// Captura y validación de entrada entera
				try {
					aukera = Integer.parseInt(zbk);
				} catch (NumberFormatException e) {
					System.out.println("Mesedez sartu zenbaki bat.");
					balmenu1 = false;
				}
			} while (balmenu1 == false);

			// EVALUACIÓN DE LAS OPCIONES DEL MENÚ PRINCIPAL
			switch (aukera) {
			// -------------------------------------------------------------
			// OPCIÓN 1: Ver lista de animales en adopción
			// -------------------------------------------------------------
			case 1:
				animaliakerakutsi(animaliid, animaliamota, adina, arraza, animaliizena);
				break;

			// -------------------------------------------------------------
			// OPCIÓN 2: Proceso de compra de productos
			// -------------------------------------------------------------
			case 2:
				int subtotalGuztira = 0; // Acumulador total del carrito de compra
				boolean balmenu2 = true;
				int aukera2 = 0;
				char jarraitu = 'B'; // Variable de control para seguir comprando ('B' = Bai / Sí)

				do {
					// Selección de categoría de producto con validación
					do {
						System.out.println("|-------------" + COLOR_1 + "   PRODUKTUAK  " + RESET + "--------------|");
						System.out.println("|==========================================|" + RESET);
						System.out.println("|1. " + COLOR_2 + "Merchandising" + RESET + "                          |");
						System.out.println("|==========================================|" + RESET);
						System.out.println("|2. " + COLOR_2 + "Maskota Jostailuak" + RESET + "                     |");
						System.out.println("|==========================================|" + RESET);
						System.out.println("|3. " + COLOR_2 + "Maskotarentzat janaria" + RESET + "                 |");
						System.out.println("|==========================================|" + RESET);
						System.out.println("|4. " + ROJO + "Amaitu eta ordaindu" + RESET + "                    |");
						System.out.println("|==========================================|" + RESET);
						System.out.print(AZUL + "Aukeratu -> " + RESET);

						zbk = teklatua.nextLine();
						limpiarConsola();
						balmenu2 = true;
						try {
							aukera2 = Integer.parseInt(zbk);
						} catch (NumberFormatException e) {
							System.out.println("Mesedez sartu zenbaki bat");
							balmenu2 = false;
						}
					} while (balmenu2 == false);

					switch (aukera2) {
					// Subopción 2.1: Merchandising
					case 1:
						int merch = 0;
						int kop = 0;
						boolean balmenu3 = true;

						// Selección de artículo dentro de merchandising
						do {
							System.out.println("|-------------" + COLOR_1 + " MERCHANDISING " + RESET + "--------------|");
							System.out.println("|==========================================|" + RESET);
							System.out.println("|1. " + COLOR_2 + "Kamiseta -> 10€" + RESET + "                        |");
							System.out.println("|==========================================|" + RESET);
							System.out.println("|2. " + COLOR_2 + "Sudadera -> 20€" + RESET + "                        |");
							System.out.println("|==========================================|" + RESET);
							System.out.println("|3. " + COLOR_2 + "Motxila -> 15€" + RESET + "                         |");
							System.out.println("|==========================================|" + RESET);
							System.out.println("|0. " + ROJO + "Atzera" + RESET + "                                 |");
							System.out.println("|==========================================|" + RESET);
							System.out.print(AZUL + "Aukeratu -> " + RESET);

							zbk = teklatua.nextLine();
							balmenu3 = true;
							limpiarConsola();
							try {
								merch = Integer.parseInt(zbk);
								if (merch < 0 || merch > 3) {
									System.out.println("Mesedez zenbakia 0 eta 3-ren artean.");
									balmenu3 = false;
								}
							} catch (NumberFormatException e) {
								System.out.println("Mesedez sartu zenbaki bat");
								balmenu3 = false;
							}
						} while (balmenu3 == false);

						// Si elige 0 se cancela la selección de esta categoría
						if (merch == 0) {
							break;
						}

						// Solicitud y validación de la cantidad
						boolean balmenu5 = true;
						do {
							System.out.print("Zenbat? ");
							zbk = teklatua.nextLine();
							balmenu5 = true;
							try {
								kop = Integer.parseInt(zbk);
							} catch (NumberFormatException e) {
								System.out.println("Mesedez sartu zenbaki bat");
								balmenu5 = false;
							}
						} while (balmenu5 == false);

						// Acumula el subtotal devuelto por el método merch()
						subtotalGuztira += merch(merch, kop);
						System.out.println(
								"\n--> Produktua saskira gehitu da! Uneko azpitotala: " + subtotalGuztira + "€");
						System.out.print("Beste produkturen bat erosi nahi duzu? (B/E): ");
						zbk = teklatua.nextLine();
						jarraitu = zbk.isEmpty() ? 'E' : zbk.charAt(0);
						limpiarConsola();
						break;

					// Subopción 2.2: Juguetes
					case 2:
						int jost = 0;
						kop = 0;
						boolean balmenu4 = true;

						// Selección del juguete
						do {
							System.out.println("|---------------" + COLOR_1 + " JOSTAILUAK " + RESET + "---------------|");
							System.out.println("|==========================================|" + RESET);
							System.out.println("|1. " + COLOR_2 + "Pilota -> 5€" + RESET + "                           |");
							System.out.println("|==========================================|" + RESET);
							System.out.println("|2. " + COLOR_2 + "Joko intereaktiboa -> 20€" + RESET + "              |");
							System.out.println("|==========================================|" + RESET);
							System.out.println("|3. " + COLOR_2 + "Lumadun makila -> 5€" + RESET + "                   |");
							System.out.println("|==========================================|" + RESET);
							System.out.println("|4. " + COLOR_2 + "Katuentxako gaztelua -> 10€" + RESET + "            |");
							System.out.println("|==========================================|" + RESET);
							System.out.println("|0. " + ROJO + "Atzera" + RESET + "                                 |");
							System.out.println("|==========================================|" + RESET);
							System.out.print(AZUL + "Aukeratu -> " + RESET);
							zbk = teklatua.nextLine();
							balmenu4 = true;
							limpiarConsola();
							try {
								jost = Integer.parseInt(zbk);
								if (jost < 0 || jost > 4) {
									System.out.println("Mesedez zenbakia 0 eta 4-ren artean.");
									balmenu4 = false;
								}
							} catch (NumberFormatException e) {
								System.out.println("Mesedez sartu zenbaki bat");
								balmenu4 = false;
							}
						} while (balmenu4 == false);

						if (jost == 0) {
							break;
						}

						// Solicitud y validación de cantidad
						boolean balJostKop = true;
						do {
							System.out.print("Zenbat? ");
							zbk = teklatua.nextLine();
							balJostKop = true;
							try {
								kop = Integer.parseInt(zbk);
							} catch (NumberFormatException e) {
								System.out.println("Mesedez sartu zenbaki bat");
								balJostKop = false;
							}
						} while (balJostKop == false);

						// Acumula el subtotal devuelto por el método jostailuak()
						subtotalGuztira += jostailuak(jost, kop);
						System.out.println(
								"\n--> Produktua saskira gehitu da! Uneko azpitotala: " + subtotalGuztira + "€");
						System.out.print("Beste produkturen bat erosi nahi duzu? (B/E): ");
						zbk = teklatua.nextLine();
						jarraitu = zbk.isEmpty() ? 'E' : zbk.charAt(0);
						limpiarConsola();
						break;

					// Subopción 2.3: Comida
					case 3:
						boolean balmenu6 = true;
						int janaria = 0;
						kop = 0;

						// Selección del tipo de comida
						do {
							System.out.println("|----------------" + COLOR_1 + " JANARIA " + RESET + "-----------------| ");
							System.out.println("|==========================================|" + RESET);
							System.out.println("|1. " + COLOR_2 + "Katu pentsua (1kg) -> 5€" + RESET + "               |");
							System.out.println("|==========================================|" + RESET);
							System.out.println("|2. " + COLOR_2 + "Katu pentsua (5kg) -> 25€" + RESET + "              |");
							System.out.println("|==========================================|" + RESET);
							System.out.println("|3. " + COLOR_2 + "Txakur pentsua (1kg) -> 5€" + RESET + "             |");
							System.out.println("|==========================================|" + RESET);
							System.out.println("|4. " + COLOR_2 + "Txakur pentsua (5kg) -> 25€" + RESET + "            |");
							System.out.println("|==========================================|" + RESET);
							System.out.println("|0. " + ROJO + "Atzera" + RESET + "                                 |");
							System.out.println("|==========================================|" + RESET);
							System.out.print(AZUL + "Aukeratu -> " + RESET);

							zbk = teklatua.nextLine();
							balmenu6 = true;
							limpiarConsola();
							try {
								janaria = Integer.parseInt(zbk);
								if (janaria < 0 || janaria > 4) {
									System.out.println("Mesedez zenbakia 0 eta 4-ren artean.");
									balmenu6 = false;
								}
							} catch (NumberFormatException e) {
								System.out.println("Mesedez sartu zenbaki bat");
								balmenu6 = false;
							}
						} while (balmenu6 == false);

						if (janaria == 0) {
							break;
						}

						// Solicitud y validación de cantidad
						boolean balmenu7 = true;
						do {
							System.out.print("Zenbat? ");
							zbk = teklatua.nextLine();
							balmenu7 = true;
							try {
								kop = Integer.parseInt(zbk);
							} catch (NumberFormatException e) {
								System.out.println("Mesedez sartu zenbaki bat");
								balmenu7 = false;
							}
						} while (balmenu7 == false);

						// Acumula el subtotal devuelto por el método janaria()
						subtotalGuztira += janaria(janaria, kop);
						System.out.println(
								"\n--> Produktua saskira gehitu da! Uneko azpitotala: " + subtotalGuztira + "€");
						System.out.print("Beste produkturen bat erosi nahi duzu? (B/E): ");
						zbk = teklatua.nextLine();
						jarraitu = zbk.isEmpty() ? 'E' : zbk.charAt(0);
						limpiarConsola();
						break;

					// Subopción 2.4: Terminar la compra y proceder al pago
					case 4:
						jarraitu = 'E'; // Marca 'E' (Ez / No) para romper el bucle de compras
						break;
					}

					// Si el usuario decide no seguir comprando, sale del bucle de productos
					if (jarraitu == 'E' || jarraitu == 'e') {
						break;
					}

				} while (aukera2 != 4);

				// Si hay compras registradas, emitimos la factura final
				if (subtotalGuztira > 0) {
					fakturaErakutsi(subtotalGuztira, teklatua);
				} else {
					System.out.println("\nEz duzu produkturik erosi.");
				}
				break;

			// -------------------------------------------------------------
			// OPCIÓN 3: Servicios de la protectora
			// -------------------------------------------------------------
			case 3:
				int aukera3 = 0;
				boolean balmenu8 = true;

				do {
					// Menú secundario para la gestión de servicios
					do {
						System.out.println("|---------------" + COLOR_1 + " ZERBITZUAK " + RESET + "---------------|");
						System.out.println("|==========================================|" + RESET);
						System.out.println("| 1. " + COLOR_2 + "Animali bat adopzioan eman" + RESET + "            |");
						System.out.println("|==========================================|" + RESET);
						System.out.println("| 2. " + COLOR_2 + "Animali bat adoptatu" + RESET + "                  |");
						System.out.println("|==========================================|" + RESET);
						System.out.println("| 3. " + COLOR_2 + "Animali baten adina aldatu" + RESET + "            |");
						System.out.println("|==========================================|" + RESET);
						System.out.println("| 4. " + ROJO + "Irten" + RESET + "                                 |");
						System.out.println("|==========================================|" + RESET);
						System.out.print(AZUL + "Aukeratu -> " + RESET);

						zbk = teklatua.nextLine();
						limpiarConsola();
						try {
							aukera3 = Integer.parseInt(zbk);
						} catch (NumberFormatException e) {
							System.out.println("Mesedez sartu zenbaki bat");
							balmenu8 = false;
						}
					} while (balmenu8 == false);

					switch (aukera3) {
					// Subopción 3.1: Dar en adopción (dar de alta un nuevo animal)
					case 1:
					    // Buscar la primera posición libre en los arrays
					    int pos = -1;
					    for (int i = 0; i < animaliizena.length; i++) {
					        if (animaliizena[i] == null) {
					            pos = i;
					            break;
					        }
					    }

					    // Comprobar si hay espacio disponible en los arrays
					    if (pos == -1) {
					        System.out.println("Ezin da animalia gehiago gehitu (zerrenda beteta dago).");
					        break;
					    }

					    System.out.print("Sartu animaliaren izena -> ");
					    String izena = teklatua.nextLine();

					    System.out.print("Sartu animali mota -> ");
					    String animali = teklatua.nextLine();

					    // Captura y validación entera de la edad del animal
					    String adi = "";
					    boolean balidazio = true;
					    do {
					        System.out.print("Sartu animaliaren adina: ");
					        adi = teklatua.nextLine();
					        try {
					            int ad = Integer.parseInt(adi);
					            balidazio = true;
					        } catch (NumberFormatException e) {
					            System.out.println("Mesedez, zenbaki bat sartu");
					            balidazio = false;
					        }
					    } while (!balidazio);

					    System.out.print("Sartu animali arraza edo kolorea -> ");
					    String arrazaani = teklatua.nextLine();

					    // Guardar los datos en el índice asignado y generar el ID en orden secuencial
					    animaliizena[pos] = izena;
					    animaliamota[pos] = animali;
					    adina[pos] = adi;
					    arraza[pos] = arrazaani;
					    animaliid[pos] = String.format("ID-%03d", pos + 1);
					    break;
					// Subopción 3.2: Adoptar (eliminar animal asignando null a sus datos)
					case 2:
						animaliakerakutsi(animaliid, animaliamota, adina, arraza, animaliizena);
						System.out.print("Zein adoptatu nahi duzu? ");
						String izenaani = teklatua.nextLine();

						// Buscamos por nombre y ponemos a null todos sus atributos
						for (int i = 0; i < animaliizena.length; i++) {
							if (izenaani.equalsIgnoreCase(animaliizena[i])) {
								animaliid[i] = null;
								animaliamota[i] = null;
								adina[i] = null;
								arraza[i] = null;
								animaliizena[i] = null;
							}
						}
						break;

					// Subopción 3.3: Cambiar la edad de un animal existente
					case 3:
						izenadina(animaliizena, adina);
						System.out.print("Aukeratu animalia: ");
						String adinberria = teklatua.nextLine();
						adina = aldatu(animaliizena, adinberria, adina, teklatua);
						break;
					}
				} while (aukera3 != 4);
				break;
			}

		} while (aukera != 4); // El programa finaliza al seleccionar 4 en el menú principal
		try {
		System.out.println("                       ;\\\r\n"
				+ "                      |' \\\r\n"
				+ "   _                  ; : ;\r\n"
				+ "  / `-.              /: : |\r\n"
				+ " |  ,-.`-.          ,': : |\r\n"
				+ " \\  :  `. `.       ,'-. : |\r\n"
				+ "  \\ ;    ;  `-.__,'    `-.|\r\n"
				+ "   \\ ;   ;  :::  ,::'`:.  `.\r\n"
				+ "    \\ `-. :  `    :.    `.  \\\r\n"
				+ "     \\   \\    ,   ;   ,:    (\\\r\n"
				+ "      \\   :., :.    ,'o)): ` `-.\r\n"
				+ "     ,/,' ;' ,::\"'`.`---'   `.  `-._\r\n"
				+ "   ,/  :  ; '\"      `;'          ,--`.\r\n"
				+ "  ;/   :; ;             ,:'     (   ,:)\r\n"
				+ "    ,.,:.    ; ,:.,  ,-._ `.     \\\"\"'/\r\n"
				+ "    '::'     `:'`  ,'(  \\`._____.-'\"'\r\n"
				+ "       ;,   ;  `.  `. `._`-.  \\\\\r\n"
				+ "       ;:.  ;:       `-._`-.\\  \\`.\r\n"
				+ "        '`:. :        |' `. `\\  ) \\\r\n"
				+ "           ` ;:       |    `--\\__,'\r\n"
				+ "             '`      ,'\r\n"
				+ "                  ,-'\r\n");
			System.exit(0);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); 
        }

		teklatua.close(); // Cerramos el Scanner
		System.exit(0);
	}
}