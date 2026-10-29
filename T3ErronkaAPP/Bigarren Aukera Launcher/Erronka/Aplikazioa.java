package Erronka;

import java.util.Scanner;

/**
 * "Erronka" babesetxea eta denda kudeatzeko aplikazioaren klase nagusia.
 * Animaliak zerrendatu, erregistratu, aldatu eta adoptatzea ahalbidetzen du,
 * baita produktuen erosketa (merchandising-a, jostailuak eta janaria) kudeatzea ere,
 * deskontuak kalkulatuz eta fakturak sortuz.
 *
 * @author Erronka
 * @version 1.0
 */
public class Aplikazioa {
	// Kontsolan inprimatutako menuei koloreak eta estiloak emateko ANSI kodeen konstanteak
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
	 * Erregistratutako animalien zerrenda sinplifikatua erakusten du (izena eta adina bakarrik).
	 *
	 * @param a Animalien izenak dituen array-a.
	 * @param b Animalien adinak dituen array-a.
	 */
	public static void izenadina(String[] a, String[] b) {
		// Izenen eta adinen array-en posizioak zeharkatzen ditugu
		for (int i = 0; i < a.length; i++) {
			// Bi array-etan posizioa hutsik ez dagoela egiaztatzen dugu
			if (a[i] != null || b[i] != null) {
				System.out.println(" ");
				System.out.print("Animaliaren izena: " + a[i] + ", ");
				System.out.print("Animali adina: " + b[i] + ", ");
			}
		}
		System.out.println(" ");
	}

	/**
	 * Animalia bat bilatzen du bere izenaren bidez eta bere adina balioztatutako balio berri batekin eguneratzen du.
	 *
	 * @param a Animalien izenen array-a.
	 * @param b Aldatu nahi den animaliaren izena.
	 * @param c Animalien uneko adinak dituen array-a.
	 * @param teklatua Kontsolako sarrera irakurtzeko Scanner objektua.
	 * @return Txertatutako kopuru berriarekin eguneratutako adinen array-a.
	 */

	public static String[] aldatu(String[] a, String b, String[] c, Scanner teklatua) {

		String adina = "";
		boolean aurkituta = false;

		do {

			System.out.print("Aukeratu animalia: ");
			b = teklatua.nextLine().trim();

			// Animalia bilatzen dugu
			for (int i = 0; i < a.length; i++) {

				if (a[i] != null && b.equalsIgnoreCase(a[i])) {

					aurkituta = true;

					boolean balidatu = false;

					// Adin berria balioztatzen dugu
					do {
						try {
							System.out.print("Sartu adina berri: ");
							adina = teklatua.nextLine();

							int ad = Integer.parseInt(adina);

							if (ad < 0) {
								throw new NumberFormatException();
							}

							c[i] = adina;
							balidatu = true;

						} catch (NumberFormatException e) {
							System.out.println("Mesedez, sartu baliozko zenbaki oso bat.");
						}

					} while (!balidatu);

					System.out.println("Animaliaren adina behar bezala aldatu da.");
					break;
				}
			}

			if (!aurkituta) {
				System.out.println("Ez da animalia hori aurkitu. Saiatu berriro.");
			}

		} while (!aurkituta);

		return c;
	}


	/**
	 * Erregistratutako animalien zerrenda osoa eta zehatza erakusten du (IDa,
	 * izena, mota/espeziea, adina eta arraza/kolorea).
	 *
	 * @param a Animalien identifikatzaileak (ID) dituen array-a.
	 * @param b Animalien motak/espezieak dituen array-a.
	 * @param c Animalien adinak dituen array-a.
	 * @param d Animalien arrazak edo koloreak dituen array-a.
	 * @param e Animalien izenak dituen array-a.
	 */
	public static void animaliakerakutsi(String[] a, String[] b, String[] c, String[] d, String[] e) {
		// Animalien datuak zeharkatzen ditugu
		for (int i = 0; i < a.length; i++) {
			// Posizioko atributuetako bat gutxienez nulua ez bada bakarrik inprimatzen dugu
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
	 * Emandako eroslearen baldintzaren arabera aplikagarri diren deskontuen euro kopuru osoa kalkulatzen du.
	 *
	 * @param a Egindako erosketen metatutako azpitotala eurotan.
	 * @param b Aurretiko adopzioaren adierazlea ('B'/'b' BAIrako, 'E'/'e' EZerako).
	 *          %10eko deskontua ematen du.
	 * @param c Bazkide izatearen adierazlea ('B'/'b' BAIrako, 'E'/'e' EZerako). %5eko
	 *          deskontua ematen du.
	 * @return Deskontatutako euroen zenbateko osoa.
	 */
	public static double desk(int a, char b, char c) {
		double adopt = 0;
		double socio = 0;

		// Adopzioagatiko deskontua (%10)
		if (b == 'B' || b == 'b') {
			adopt = a * 0.1;
		}

		// Bazkide izateagatiko deskontua (%5)
		if (c == 'B' || c == 'b') {
			socio = a * 0.05;
		}

		double totaldesk = socio + adopt;
		return totaldesk;
	}

	/**
	 * Elikagai hautaketaren kostu osoa kalkulatzen du aukeratutako produktuaren eta
	 * kantitatearen arabera.
	 *
	 * @param a Aukeratutako aukera (1: Katu pentsua 1kg, 2: Katu pentsua 5kg, 3: Txakur
	 *          pentsua 1kg, 4: Txakur pentsua 5kg).
	 * @param b Produktuaren unitate kantitatea.
	 * @return Unitaterainoko prezioa eta kantitatea biderkatzearen ondoriozko zenbateko osoa.
	 */
	public static int janaria(int a, int b) {
		// Aukeratutako aukeraren arabera unitateko prezioa esleitzea
		if (a == 1) {
			a = 5; // Katu pentsua 1kg -> 5€
		} else if (a == 2) {
			a = 20; // Katu pentsua 5kg -> 20€
		} else if (a == 3) {
			a = 5; // Txakur pentsua 1kg -> 5€
		} else {
			a = 20; // Txakur pentsua 5kg -> 20€
		}

		return a * b; // Azpitotala = Unitateko prezioa * Kantitatea
	}

	/**
	 * Jostailu hautaketaren kostu osoa kalkulatzen du aukeratutako aukeraren eta
	 * kantitatearen arabera.
	 *
	 * @param a Aukeratutako aukera (1: Pilota, 2: Joko interaktiboa, 3: Lumadun makila,
	 *          4: Gaztelua).
	 * @param b Unitate kantitatea.
	 * @return Aukeratutako jostailuen zenbateko osoa.
	 */
	public static int jostailuak(int a, int b) {
		// Jostailuaren arabera unitateko prezioa esleitzea
		if (a == 1) {
			a = 5; // Pilota -> 5€
		} else if (a == 2) {
			a = 20; // Joko interaktiboa -> 20€
		} else if (a == 3) {
			a = 5; // Lumadun makila -> 5€
		} else {
			a = 10; // Katuentzako gaztelua -> 10€
		}

		return a * b; // Azpitotala = Unitateko prezioa * Kantitatea
	}

	/**
	 * Merchandising hautaketaren kostu osoa kalkulatzen du artikuluaren eta
	 * kantitatearen arabera.
	 *
	 * @param a Aukeratutako aukera (1: Kamiseta, 2: Sudadera, 3: Motxila).
	 * @param b Unitate kantitatea.
	 * @return Merchandising produktuen zenbateko osoa.
	 */
	public static int merch(int a, int b) {
		// Merchandising produktuaren arabera unitateko prezioa esleitzea
		if (a == 1) {
			a = 10; // Kamiseta -> 10€
		} else if (a == 2) {
			a = 20; // Sudadera -> 20€
		} else {
			a = 15; // Motxila -> 15€
		}

		return a * b; // Azpitotala = Unitateko prezioa * Kantitatea
	}

	/**
	 * Erabiltzaileari deskontuen datuak eskatzen dizkio, metatutako azken prezioa
	 * kalkulatzen du eta faktura inprimatzen du.
	 *
	 * @param subtotala Erosketengatik metatutako azpitotal gordina.
	 * @param teklatua  Kontsolako sarrera irakurtzeko Scanner objektua.
	 */

	public static void fakturaErakutsi(int subtotala, Scanner teklatua) {

		// Bezeroak animaliarik adoptatu duen galdetzen du

		System.out.println(" ");
		char adopt = ' ';

		while (adopt != 'B' && adopt != 'E') {
			try {
				System.out.println("Badaukazu hemengo animalirik adoptatuta? (B/E)");
				String zbk = teklatua.nextLine().trim().toUpperCase();

				if (zbk.length() != 1) {
					throw new IllegalArgumentException();
				}
				adopt = zbk.charAt(0);
				if (adopt != 'B' && adopt != 'E') {
					throw new IllegalArgumentException();
				}
			} catch (IllegalArgumentException e) {
				System.out.println("Erantzun okerra! Sartu B (Bai) edo E (Ez).");
				adopt = ' ';
			}
		}

		// Bezeroa bazkidea den galdetzen du

		char socio = ' ';

		while (socio != 'B' && socio != 'E') {
			try {
				System.out.println("Gure enpresaren sozioa zara? (B/E)");
				String zbk = teklatua.nextLine().trim().toUpperCase();

				if (zbk.length() != 1) {
					throw new IllegalArgumentException();
				}

				socio = zbk.charAt(0);

				if (socio != 'B' && socio != 'E') {
					throw new IllegalArgumentException();
				}

			} catch (IllegalArgumentException e) {
				System.out.println("Erantzun okerra! Sartu B (Bai) edo E (Ez).");
				socio = ' ';
			}
		}

		// Aplikagarri diren deskontuen eta deskontudun prezioaren kalkulua

		double tot = desk(subtotala, adopt, socio);
		double prezioF = subtotala - tot;

		// Erosketaren laburpenaren inprimatze formatuduna

		String formatoFila = "  | %s%-25s%s %8s    |\n";

		System.out.println("  +---------------------------------------+");
		System.out.println("  |               " + AZUL + "FAKTURA" + RESET + "                 |");
		System.out.println("  +---------------------------------------+");

		System.out.printf(formatoFila, NARANJA_HEX, "Subtotala:", RESET, subtotala + "€");
		System.out.printf(formatoFila, VERDE_HEX, "Deskontua:", RESET, tot + "€");

		System.out.println("  |---------------------------------------|");

		System.out.printf(formatoFila, CELESTE_HEX, "Deskontuak aplikatuta:", RESET, prezioF + "€");

		System.out.println("  +---------------------------------------+");
		System.out.println();

	}


	/**
	 * Kontsolako pantaila garbitzen du detektatutako sistema eragilearen arabera
	 * (Windows edo Unix-en oinarritua).
	 */
	public static void limpiarConsola() {
		try {
			if (System.getProperty("os.name").contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				new ProcessBuilder("clear").inheritIO().start().waitFor();
			}
		} catch (Exception e) {
			// Sistemako komandoak exekutatzean akatsa gertatuz gero, hainbat lerro gehitzen ditu garbiketa simulatzeko
			System.out.println("\n\n");
		}
	}

	/**
	 * Aplikazioa exekutatzen duen metodo nagusia. Balio lehenetsiak hasieratzen ditu,
	 * menu iteratiboak erakusten ditu eta sistemaren logika koordinatzen du.
	 *
	 * @param args Komando-lineako argumentuak (ez dira erabiltzen).
	 */
	public static void main(String[] args) {

		Scanner teklatua = new Scanner(System.in);

		// Gehienez 10 animalia erregistratzeko array paraleloen hasieratzea
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

		int aukera = 0; // Menu nagusiko aukera
		boolean balmenu1 = true; // Zenbaki osoen sarreraren balioztatze-kontrola
		String zbk = " "; // Scanner bidezko testu-irakurketa

		// PROGRAMAREN BEGIZTA NAGUSIA
		do {
			// Menu nagusia aurkezteko eta balioztatzeko begizta
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

				// Zenbaki osoen sarreraren harrapaketa eta balioztatzea
				try {
					aukera = Integer.parseInt(zbk);
				} catch (NumberFormatException e) {
					System.out.println("Mesedez sartu zenbaki bat.");
					balmenu1 = false;
				}
			} while (balmenu1 == false);

			// MENU NAGUSIKO AUKEREN EBALUAZIOA
			switch (aukera) {
			// -------------------------------------------------------------
			// 1. AUKERA: Adopzioan dauden animalien zerrenda ikusi
			// -------------------------------------------------------------
			case 1:
				animaliakerakutsi(animaliid, animaliamota, adina, arraza, animaliizena);
				break;

			// -------------------------------------------------------------
			// 2. AUKERA: Produktuak erosteko prozesua
			// -------------------------------------------------------------
			case 2:
				int subtotalGuztira = 0; // Erosketa saskiaren metatzaile osoa
				boolean balmenu2 = true;
				int aukera2 = 0;
				char jarraitu = 'B'; // Erosketekin jarraitzeko kontrol-aldagaia ('B' = Bai)

				do {
					// Produktu kategoriaren aukeraketa balioztatzearekin
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
					// 2.1 Azpiazalpena: Merchandising-a
					case 1:
						int merch = 0;
						int kop = 0;
						boolean balmenu3 = true;

						// Artikuluaren aukeraketa merchandising-aren barruan
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

						// 0 aukeratuz gero, kategoria honen aukeraketa bertan behera geratzen da
						if (merch == 0) {
							break;
						}

						// Kantitatearen eskaera eta balioztatzea
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

						// merch() metodoak itzulitako azpitotala metatzen du
						subtotalGuztira += merch(merch, kop);
						System.out.println(
								"\n--> Produktua saskira gehitu da! Uneko azpitotala: " + subtotalGuztira + "€");
						System.out.print("Beste produkturen bat erosi nahi duzu? (B/E): ");
						zbk = teklatua.nextLine();
						jarraitu = zbk.isEmpty() ? 'E' : zbk.charAt(0);
						limpiarConsola();
						break;

					// 2.2 Azpiazalpena: Jostailuak
					case 2:
						int jost = 0;
						kop = 0;
						boolean balmenu4 = true;

						// Jostailuaren aukeraketa
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

						// Kantitatearen eskaera eta balioztatzea
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

						// jostailuak() metodoak itzulitako azpitotala metatzen du
						subtotalGuztira += jostailuak(jost, kop);
						System.out.println(
								"\n--> Produktua saskira gehitu da! Uneko azpitotala: " + subtotalGuztira + "€");
						System.out.print("Beste produkturen bat erosi nahi duzu? (B/E): ");
						zbk = teklatua.nextLine();
						jarraitu = zbk.isEmpty() ? 'E' : zbk.charAt(0);
						limpiarConsola();
						break;

					// 2.3 Azpiazalpena: Janaria
					case 3:
						boolean balmenu6 = true;
						int janaria = 0;
						kop = 0;

						// Janari motaren aukeraketa
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

						// Kantitatearen eskaera eta balioztatzea
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

						// janaria() metodoak itzulitako azpitotala metatzen du
						subtotalGuztira += janaria(janaria, kop);
						System.out.println(
								"\n--> Produktua saskira gehitu da! Uneko azpitotala: " + subtotalGuztira + "€");
						System.out.print("Beste produkturen bat erosi nahi duzu? (B/E): ");
						zbk = teklatua.nextLine();
						jarraitu = zbk.isEmpty() ? 'E' : zbk.charAt(0);
						limpiarConsola();
						break;

					// 2.4 Azpiazalpena: Erosketa amaitu eta ordainketara igaro
					case 4:
						jarraitu = 'E'; // 'E' (Ez) markatzen du erosketen begizta hautasteko
						break;
					}

					// Erabiltzaileak gehiago ez erostea erabakitzen badu, produktuen begiztatik ateratzen da
					if (jarraitu == 'E' || jarraitu == 'e') {
						break;
					}

				} while (aukera2 != 4);

				// Erosketak erregistratuta badaude, azken faktura igortzen dugu
				if (subtotalGuztira > 0) {
					fakturaErakutsi(subtotalGuztira, teklatua);
				} else {
					System.out.println("\nEz duzu produkturik erosi.");
				}
				break;

			// -------------------------------------------------------------
			// 3. AUKERA: Babesetxearen zerbitzuak
			// -------------------------------------------------------------
			case 3:
				int aukera3 = 0;
				boolean balmenu8 = true;

				do {
					// Zerbitzuak kudeatzeko bigarren mailako menua
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
					//while (!balmenu8); 

					switch (aukera3) {
					// 3.1 Azpiazalpena: Adopzioan eman (animalia berri bati alta eman)
					case 1:
					    // Array-etan lehenengo posizio librea bilatu
					    int pos = -1;
					    for (int i = 0; i < animaliizena.length; i++) {
					        if (animaliizena[i] == null) {
					            pos = i;
					            break;
					        }
					    }

					    // Array-etan lekua libre dagoen egiaztatu
					    if (pos == -1) {
					        System.out.println("Ezin da animalia gehiago gehitu (zerrenda beteta dago).");
					        break;
					    }

					    System.out.print("Sartu animaliaren izena -> ");
					    String izena = teklatua.nextLine();

					    System.out.print("Sartu animali mota -> ");
					    String animali = teklatua.nextLine();

					    // Animaliaren adinaren zenbaki osoaren harrapaketa eta balioztatzea
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


						String arrazaani = "";
						boolean balidazioArraza = false;

						do {
							System.out.print("Sartu animali arraza edo kolorea -> ");
							arrazaani = teklatua.nextLine().trim();

							try {
								if (arrazaani.isEmpty() || !arrazaani.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s]+")) {
									throw new IllegalArgumentException();
								}

								balidazioArraza = true;

							} catch (IllegalArgumentException e) {
								System.out.println("Errorea! Testua bakarrik sartu behar duzu.");
								balidazioArraza = false;
							}

						} while (!balidazioArraza);

					    // Datuak esleitutako indizean gorde eta IDa sekuentzialki sortu
					    animaliizena[pos] = izena;
					    animaliamota[pos] = animali;
					    adina[pos] = adi;
					    arraza[pos] = arrazaani;
					    animaliid[pos] = String.format("ID-%03d", pos + 1);
					    break;
					// 3.2 Azpiazalpena: Adoptatu (animalia ezabatu bere datuei null esleituz)

					case 2:

						animaliakerakutsi(animaliid, animaliamota, adina, arraza, animaliizena);

						boolean aurkitua = false;

						do {
							System.out.print("Zein adoptatu nahi duzu? ");
							String izenaani = teklatua.nextLine().trim();

							for (int i = 0; i < animaliizena.length; i++) {

								if (animaliizena[i] != null && izenaani.equalsIgnoreCase(animaliizena[i])) {

									System.out.println("Animalia aurkitu da eta adoptatua izan da.");

									// Animalia ezabatu bere datuak null jarriz
									animaliid[i] = null;
									animaliamota[i] = null;
									adina[i] = null;
									arraza[i] = null;
									animaliizena[i] = null;

									aurkitua = true;
									break;
								}
							}

							if (!aurkitua) {
								System.out.println("Animalia ez da aurkitu. Saiatu berriro.");
							}

						} while (!aurkitua);

						break;

					// 3.3 Azpiazalpena: Lehendik dagoen animalia baten adina aldatu
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

		} while (aukera != 4); // Programa amaitu egiten da menu nagusian 4 aukeratzean
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
        	Thread.sleep(2077);
			System.exit(0);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); 
        }

		teklatua.close(); // Scanner-a ixten dugu
		System.exit(0);
	}
}