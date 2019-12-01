import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class LineReader {

    public List<String> getLines(URL input) {
        try {
            Path path = Paths.get(input.toURI());
            return Files.readAllLines(path);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
