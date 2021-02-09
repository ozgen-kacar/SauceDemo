package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    /*
     this class will be responsible for loading properties file and will provide
     access to values based on key names
     I use this class to load custom.properties files
    */

    private static Properties configFile;


    static {
        try {
            FileInputStream fileInputStream = new FileInputStream("configuration.properties");

            configFile = new Properties();
            configFile.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            System.out.println("File was not loaded:(");
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return configFile.getProperty(key);
    }

}
