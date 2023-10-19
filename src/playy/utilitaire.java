package playy;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class utilitaire {
	public static String convertToCSV(String[] data) {
	    return Stream.of(data)
	      .collect(Collectors.joining(","));
	}
	
	public static void create(List<String[]> dataLines) throws IOException {
	    File csvOutputFile = new File("labyrinthe");
	    try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
	        dataLines.stream()
	          .forEach(pw::println);
	    }
	}
}
