package core.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyLoader {

    private static final Map<String, Properties> propertiesCache = new HashMap<>();

    private PropertyLoader() {
    }

    public static String returnConfigValue(final String property, String fileName) {
        Properties properties = propertiesCache.get(fileName);

        System.out.println(properties);
        if (properties == null) {
            properties = loadProperties(fileName);
            if (properties != null) {
                propertiesCache.put(fileName, properties);
                System.out.println(properties);
            }
        }
        assert properties != null;
        return properties.getProperty(property);
    }


    private static Properties loadProperties(String fileName) {
        Properties properties = new Properties();
        try (InputStream propFileInpStream = PropertyLoader.class.getClassLoader().getResourceAsStream(fileName)) {
            if (propFileInpStream == null) {
                System.err.println("Property file '" + fileName + "' not found in the classpath.");
                return null;
            }
            properties.load(propFileInpStream);
        } catch (IOException e) {
            System.err.println("Error loading property file '" + fileName + "': " + e.getMessage());
            return null;
        }
        return properties;
    }
}
