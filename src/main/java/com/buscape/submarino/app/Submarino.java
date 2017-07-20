package com.buscape.submarino.app;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Submarino implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		String param1 = null;
		if (args != null && args.length != 0) {
			param1 = args[0];
		}

		if ("start".equalsIgnoreCase(param1)) {
			Scanner sc = null;

			try {
				System.out.println("Informe as coordenadas:");

				sc = new Scanner(System.in);

				String entrada = sc.next().toUpperCase();
				
				String retorno = caulculaCoordenada(entrada);
				System.out.println(retorno);
				
			} catch (Exception e) {
				System.out.println("Erro:"+e.getMessage());
			} finally {
				if (sc != null) {
					sc.close();
				}
			}
		}
	}

	public String caulculaCoordenada(String entrada) {
		Integer x = 0;
		Integer y = 0;
		Integer z = 0;

		String direcao = "NORTE";

		if (entrada.matches("[MLRDU]+")) {

			String[] comandos = entrada.split("");

			for (String comando : comandos) {

				switch (comando) {
				case "M":

					switch (direcao) {
					case "NORTE":
						y = y + 1;
						break;
					case "LESTE":
						x = x + 1;
						break;
					case "SUL":
						y = y - 1;
						break;
					case "OESTE":
						x = x - 1;
						break;
					default:
						break;
					}
					break;

				case "L":
					switch (direcao) {
					case "NORTE":
						direcao = "OESTE";
						break;

					case "LESTE":
						direcao = "NORTE";
						break;

					case "SUL":
						direcao = "LESTE";
						break;

					case "OESTE":
						direcao = "SUL";
						break;

					default:
						break;
					}
					break;

				case "R":
					switch (direcao) {
					case "NORTE":
						direcao = "LESTE";
						break;

					case "LESTE":
						direcao = "SUL";
						break;

					case "SUL":
						direcao = "OESTE";
						break;

					case "OESTE":
						direcao = "NORTE";
						break;

					default:
						break;
					}
					break;

				case "D":
					z = z - 1;

					break;
				case "U":
					z = z + 1;
					break;
				default:
					break;
				}
			}
			return (x.toString() + " " + y.toString() + " " + z.toString() + " " + direcao);
		} else {
			throw new RuntimeException("Coordenada contem caracters que não são válidos!");

		}
	}

}
