package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
    static Properties prop;
        public ReadConfig(){
            File file = new File("configuration/config.properties");
            prop= new Properties();
            FileInputStream fs = null;
            try {
                fs = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            try {
                prop.load(fs);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        public String getBrowser(){
            String browser = prop.getProperty("browser");
            return browser;
        }
    public static String getWebUrl() {
        String url = prop.getProperty("baseUrl");
        return url;

    }
}
