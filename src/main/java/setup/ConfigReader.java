package setup;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;
    private static final String propertyFilePath = "src/main/resources/TestConfigData.properties";

    public static Properties loadProperties() {
        BufferedReader reader;

        if (properties != null) {
            return properties;
        }

        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();

            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return properties;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

//    public static String getUserName() {
//        return properties.getProperty("userName");
//    }
//
//    public static String getPassword() {
//        return properties.getProperty("password");
//    }
//
//    public static String getEmail() {
//        return properties.getProperty("email");
//    }
//
//    public static String getRequestData() {
//        return properties.getProperty("searchRequest");
//    }
//
//    public static String getToken() {
//        return properties.getProperty("token");
//    }
}
