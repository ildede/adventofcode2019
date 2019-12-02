package cloud.happydev;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Integer> getIntcode(URL input) {
        try {
            Path path = Paths.get(input.toURI());
            String line = Files.readString(path);
            String[] split = line.split(",");
            return Arrays.stream(split)
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
