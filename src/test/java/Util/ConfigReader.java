package Util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    public static Properties initialize_Properties() {
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("./Configs/Positions.properties");
            properties.load(fileInputStream);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return getProperties();
    }

    public static Properties getProperties() {
        return properties;
    }
}
