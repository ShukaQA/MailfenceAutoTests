package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {

    private PropertyLoader() {
    }

    public static String returnConfigValue(final String property, String fileName) {
        Properties properties = new Properties();
        InputStream propFileInpStream = null;
        try {
            propFileInpStream = PropertyLoader.class.getClassLoader().getResourceAsStream(fileName);
            if (propFileInpStream == null) {
                throw new IOException("Property file '" + fileName + "' not found in the classpath.");
            }
            properties.load(propFileInpStream);
            String value = properties.getProperty(property);
            if (value == null) {
                throw new IllegalArgumentException("Property '" + property + "' not found in the file '" + fileName + "'.");
            }
            return value;
        } catch (IOException | IllegalArgumentException e) {
            System.err.println("Error loading property: " + e.getMessage());
            return null;
        } finally {
            if (propFileInpStream != null) {
                try {
                    propFileInpStream.close();
                } catch (IOException e) {
                    System.err.println("Failed to close the InputStream: " + e.getMessage());
                }
            }
        }
    }
}
