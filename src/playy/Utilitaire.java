package playy;
import java.io.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static playy.Labyrinthe.TAILLE;

public class Utilitaire {

	public static void writePlateauToFile(int[][] plateau) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("plateau.txt"))) {
			for (int i = 0; i < TAILLE; i++) {
				for (int j = 0; j < TAILLE; j++) {
					writer.write(Integer.toString(plateau[i][j]));
					writer.write("\t");
				}
				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int[][] readPlateauFromFile() {
		Scanner scanner = new Scanner(System.in);
		String fichier =" ";
		System.out.println("Quel est votre niveau 1, 2 ou 3 :");
		int nv = scanner.nextInt();
		
		if (nv == 1) {
			fichier = "plateaufacile.txt";
			Labyrinthe.TAILLE = 20;
		}
		
		else if (nv == 2) {
			fichier = "plateaumoyen.txt";
			Labyrinthe.TAILLE = 31;
		}
		
		if (nv == 3) {
			fichier = "plateaudifficile.txt";
			Labyrinthe.TAILLE = 34;
		}
		
		int[][] plateau = new int[TAILLE][TAILLE];
		try (Scanner scanner1 = new Scanner(new File(fichier))) {
			for (int i = 0; i < TAILLE; i++) {
				if (scanner1.hasNextLine()) {
					String line = scanner1.nextLine();
					String[] values = line.split("\t");

					for (int j = 0; j < TAILLE && j < values.length; j++) {
						plateau[i][j] = Integer.parseInt(values[j]);
					}
				} else {
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		plateau = Arrays.stream(plateau)
				.map(row -> Arrays.stream(row)
						.map(value -> value == 2 ? 0 : value)
						.toArray())
				.toArray(int[][]::new);

		return plateau;
	}

}
