package testcore.helper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFile {
    private static Properties properties;

    public ConfigFile(){
        BufferedReader reader = null;
        String propertyFilePath = "src/test/resources/config.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try { properties.load(reader); }
            catch (IOException e) { e.printStackTrace(); }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Properties file not found at path : " + propertyFilePath);
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getBrowser(){
        String browser = properties.getProperty("browser");
        if(browser!= null) {
            return browser;
        }
        else throw new RuntimeException("browser not specified in the config.properties");
    }

    public String getURL(){
        String url = properties.getProperty("url");
        if(url!= null) {
            return url;
        }
        else throw new RuntimeException("url not specified in the config.properties");
    }
}
