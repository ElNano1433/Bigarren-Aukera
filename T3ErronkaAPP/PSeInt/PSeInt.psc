Algoritmo GestionProtectora
	// Dimensionar arreglos de tamaño 10 (en PSeInt los índices van de 1 a 10)
	Dimension nombres[10]
	Dimension tipos[10]
	Dimension edades[10]
	Dimension razas[10]
	Dimension ids[10]
	
	Definir nombres, tipos, edades, razas, ids Como Cadena
	Definir i, opcionPrincipal, opcionCategoria, productoElegido, cantidad, opcionServicio, posicionLibre Como Entero
	Definir subtotalCarrito Como Real
	Definir seguirComprando, nombreAdoptado, nombreModificar Como Cadena
	
	// Carga de datos iniciales
	nombres[1] <- "Jacobo"; tipos[1] <- "Katua";    edades[1] <- "1";  razas[1] <- "Laranja";          ids[1] <- "ID-001"
	nombres[2] <- "Luis";   tipos[2] <- "Txakurra"; edades[2] <- "3";  razas[2] <- "Chihuahua";        ids[2] <- "ID-002"
	nombres[3] <- "Pedro";  tipos[3] <- "Txakurra"; edades[3] <- "12"; razas[3] <- "Bichon maltes";    ids[3] <- "ID-003"
	nombres[4] <- "DiGref"; tipos[4] <- "Katua";    edades[4] <- "4";  razas[4] <- "Zuria eta beltza"; ids[4] <- "ID-004"
	
	// Espacios vacíos
	Para i <- 5 Hasta 10 Hacer
		nombres[i] <- ""
		tipos[i] <- ""
		edades[i] <- ""
		razas[i] <- ""
		ids[i] <- ""
	FinPara
	
	Repetir
		Escribir "=========================================="
		Escribir "          BIGARREN AUKERA - MENÚ          "
		Escribir "=========================================="
		Escribir "1. Adopzioan dauden animaliak ikusi"
		Escribir "2. Produktuak erosi"
		Escribir "3. Zerbitzuak eraldatu edo kontratatu"
		Escribir "4. Irten (Salir)"
		Escribir "Aukeratu -> " Sin Saltar
		Leer opcionPrincipal
		
		Segun opcionPrincipal Hacer
			1:
				MostrarAnimales(ids, tipos, edades, razas, nombres)
				
			2:
				subtotalCarrito <- 0
				seguirComprando <- "B"
				Repetir
					Escribir "------------------------------------------"
					Escribir "               PRODUKTUAK                 "
					Escribir "------------------------------------------"
					Escribir "1. Merchandising"
					Escribir "2. Maskota Jostailuak"
					Escribir "3. Maskotarentzat janaria"
					Escribir "4. Amaitu eta ordaindu"
					Escribir "Aukeratu -> " Sin Saltar
					Leer opcionCategoria
					
					Si opcionCategoria >= 1 Y opcionCategoria <= 3 Entonces
						Escribir "Aukeratu produktua (0 atzera egiteko): " Sin Saltar
						Leer productoElegido
						
						Si productoElegido <> 0 Entonces
							Escribir "Zenbat? " Sin Saltar
							Leer cantidad
							
							Segun opcionCategoria Hacer
								1: subtotalCarrito <- subtotalCarrito + CalcularPrecioMerchandising(productoElegido, cantidad)
								2: subtotalCarrito <- subtotalCarrito + CalcularPrecioJuguetes(productoElegido, cantidad)
								3: subtotalCarrito <- subtotalCarrito + CalcularPrecioComida(productoElegido, cantidad)
							FinSegun
							
							Escribir "Beste produkturen bat erosi nahi duzu? (B/E): " Sin Saltar
							Leer seguirComprando
						FinSi
					FinSi
				Hasta Que opcionCategoria = 4 O Mayusculas(seguirComprando) = "E"
				
				Si subtotalCarrito > 0 Entonces
					GenerarFactura(subtotalCarrito)
				Sino
					Escribir "Ez duzu produkturik erosi."
				FinSi
				
			3:
				Repetir
					Escribir "------------------------------------------"
					Escribir "               ZERBITZUAK                 "
					Escribir "------------------------------------------"
					Escribir "1. Animali bat adopzioan eman"
					Escribir "2. Animali bat adoptatu"
					Escribir "3. Animali baten adina aldatu"
					Escribir "4. Atzera"
					Escribir "Aukeratu -> " Sin Saltar
					Leer opcionServicio
					
					Segun opcionServicio Hacer
						1:
							posicionLibre <- -1
							Para i <- 1 Hasta 10 Hacer
								Si nombres[i] = "" Y posicionLibre = -1 Entonces
									posicionLibre <- i
								FinSi
							FinPara
							
							Si posicionLibre <> -1 Entonces
								Escribir "Sartu animaliaren izena -> " Sin Saltar
								Leer nombres[posicionLibre]
								Escribir "Sartu animali mota -> " Sin Saltar
								Leer tipos[posicionLibre]
								Escribir "Sartu adina -> " Sin Saltar
								Leer edades[posicionLibre]
								Escribir "Sartu arraza edo kolorea -> " Sin Saltar
								Leer razas[posicionLibre]
								
								Si posicionLibre < 10 Entonces
									ids[posicionLibre] <- "ID-00" + ConvertirATexto(posicionLibre)
								Sino
									ids[posicionLibre] <- "ID-0" + ConvertirATexto(posicionLibre)
								FinSi
							Sino
								Escribir "Ezin da animalia gehiago gehitu (zerrenda beteta dago)."
							FinSi
							
						2:
							MostrarAnimales(ids, tipos, edades, razas, nombres)
							Escribir "Zein adoptatu nahi duzu? " Sin Saltar
							Leer nombreAdoptado
							
							Para i <- 1 Hasta 10 Hacer
								Si nombres[i] <> "" Y Mayusculas(nombres[i]) = Mayusculas(nombreAdoptado) Entonces
									nombres[i] <- ""
									tipos[i] <- ""
									edades[i] <- ""
									razas[i] <- ""
									ids[i] <- ""
								FinSi
							FinPara
							
						3:
							MostrarAnimales(ids, tipos, edades, razas, nombres)
							Escribir "Aukeratu animalia: " Sin Saltar
							Leer nombreModificar
							ModificarEdad(nombres, nombreModificar, edades)
					FinSegun
				Hasta Que opcionServicio = 4
		FinSegun
	Hasta Que opcionPrincipal = 4
	
	Escribir "Programa amaitu da."
FinAlgoritmo

// ==========================================
// SUBPROCESOS Y FUNCIONES
// ==========================================

SubProceso MostrarAnimales(ids, tipos, edades, razas, nombres)
	Definir i Como Entero
	Escribir ""
	Para i <- 1 Hasta 10 Hacer
		Si nombres[i] <> "" Entonces
			Escribir "ID: ", ids[i], " | Izena: ", nombres[i], " | Mota: ", tipos[i], " | Adina: ", edades[i], " | Arraza/Kolorea: ", razas[i]
		FinSi
	FinPara
	Escribir ""
FinSubProceso

SubProceso ModificarEdad(nombres, nombreBuscado, edades)
	Definir i Como Entero
	Definir encontrado Como Logico
	Definir nuevaEdad Como Cadena
	encontrado <- Falso
	
	Para i <- 1 Hasta 10 Hacer
		Si nombres[i] <> "" Y Mayusculas(nombres[i]) = Mayusculas(nombreBuscado) Entonces
			encontrado <- Verdadero
			Escribir "Sartu adina berri: " Sin Saltar
			Leer nuevaEdad
			edades[i] <- nuevaEdad
		FinSi
	FinPara
	
	Si NO encontrado Entonces
		Escribir "Ez da animalia hori aurkitu."
	FinSi
FinSubProceso

Funcion precioTotal <- CalcularPrecioMerchandising(opcion, cantidad)
	Definir precioUnitario Como Real
	Definir precioTotal Como Real
	Segun opcion Hacer
		1: precioUnitario <- 10 // Kamiseta
		2: precioUnitario <- 20 // Sudadera
		3: precioUnitario <- 15 // Motxila
		De Otro Modo: precioUnitario <- 0
	FinSegun
	precioTotal <- precioUnitario * cantidad
FinFuncion

Funcion precioTotal <- CalcularPrecioJuguetes(opcion, cantidad)
	Definir precioUnitario Como Real
	Definir precioTotal Como Real
	Segun opcion Hacer
		1: precioUnitario <- 5  // Pilota
		2: precioUnitario <- 20 // Joko interaktiboa
		3: precioUnitario <- 5  // Lumadun makila
		4: precioUnitario <- 10 // Gaztelua
		De Otro Modo: precioUnitario <- 0
	FinSegun
	precioTotal <- precioUnitario * cantidad
FinFuncion

Funcion precioTotal <- CalcularPrecioComida(opcion, cantidad)
	Definir precioUnitario Como Real
	Definir precioTotal Como Real
	Segun opcion Hacer
		1: precioUnitario <- 5  // Katu 1kg
		2: precioUnitario <- 20 // Katu 5kg
		3: precioUnitario <- 5  // Txakur 1kg
		4: precioUnitario <- 20 // Txakur 5kg
		De Otro Modo: precioUnitario <- 0
	FinSegun
	precioTotal <- precioUnitario * cantidad
FinFuncion

SubProceso GenerarFactura(subtotal)
	Definir esAdoptante, esSocio Como Cadena
	Definir descAdopt, descSocio, descTotal, totalPagar Como Real
	
	Escribir ""
	Escribir "Badaukazu hemengo animalirik adoptatuta? (B/E): " Sin Saltar
	Leer esAdoptante
	Escribir "Gure enpresaren sozioa zara? (B/E): " Sin Saltar
	Leer esSocio
	
	descAdopt <- 0
	descSocio <- 0
	
	Si Mayusculas(esAdoptante) = "B" Entonces
		descAdopt <- subtotal * 0.10
	FinSi
	
	Si Mayusculas(esSocio) = "B" Entonces
		descSocio <- subtotal * 0.05
	FinSi
	
	descTotal <- descAdopt + descSocio
	totalPagar <- subtotal - descTotal
	
	Escribir "  +---------------------------------------+"
	Escribir "  |               FAKTURA                 |"
	Escribir "  +---------------------------------------+"
	Escribir "  | Subtotala:                ", subtotal, " €"
	Escribir "  | Deskontua:                ", descTotal, " €"
	Escribir "  |---------------------------------------|"
	Escribir "  | Deskontuak aplikatuta:    ", totalPagar, " €"
	Escribir "  +---------------------------------------+"
	Escribir ""
FinSubProceso