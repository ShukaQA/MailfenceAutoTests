package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {

    private PropertyLoader() {
    }

    public static String returnConfigValue(final String property, String fileName) {
        Properties properties = new Properties();

        try (InputStream propFileInpStream = PropertyLoader.class.getClassLoader()
                .getResourceAsStream(fileName)) {

            properties.load(propFileInpStream);
            return properties.getProperty(property);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property;
    }
}