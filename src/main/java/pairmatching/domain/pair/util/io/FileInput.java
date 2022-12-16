package pairmatching.domain.pair.util.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileInput {

    public static List<String> readFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        List<String> result = new ArrayList<>();
        while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }
            result.add(line);
        }
        return result;
    }
}
