import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class Day1 {

    public static void main(String[] args) {
        Long collect = getLines()
                .stream()
                .mapToLong(Long::valueOf)
                .map(l -> Long.divideUnsigned(l, 3L))
                .map(l -> l - 2L)
                .sum();
        System.out.println(collect);
    }

    private static List<String> getLines() {
        URL day1input = Day1.class.getResource("day1input");
        try {
            Path path = Paths.get(day1input.toURI());
            return Files.readAllLines(path);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

}
