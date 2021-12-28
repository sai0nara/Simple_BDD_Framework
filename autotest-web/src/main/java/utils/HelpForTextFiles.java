package utils;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class HelpForTextFiles {

    /**
     * The method reads strings from the file.
     *
     * @param fileName = path to the file from src/resources or test/resources.
     * @return string from the file as a {@code String}
     */
    public static String readFileToString(String fileName) {
        String fileAsString;
        InputStream inputStream;
        try {
            inputStream = HelpForTextFiles.class.getClassLoader().getResourceAsStream(fileName);
            fileAsString = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Can't parse file: " + fileName);
        }
        return fileAsString;
    }
}
