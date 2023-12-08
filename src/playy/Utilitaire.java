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
		int[][] plateau = new int[TAILLE][TAILLE];

		try (Scanner scanner = new Scanner(new File("plateaudifficile.txt"))) {
			for (int i = 0; i < TAILLE; i++) {
				if (scanner.hasNextLine()) {
					String line = scanner.nextLine();
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
