package pairmatching.domain.pair.io;

import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;
import pairmatching.domain.pair.util.io.FileInput;

class FileInputTest {

    @Test
    public void readFileTest() throws IOException {
        //given
        String path = "src/main/resources/backend-crew.md";

        //when
        List<String> result = FileInput.readFile(path);

        //then
        for (String s : result) {
            System.out.println(s);
        }
    }
}