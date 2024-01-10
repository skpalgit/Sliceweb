package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
    Properties prop;
        public ReadConfig(){

            try {
                File file = new File ("C:\\Users\\Admin\\Documents\\Appinventive\\Appinventive\\Automation\\GetSlice\\src\\main\\java\\configuration\\config.properties");
                prop  = new Properties();
                FileInputStream fs = new FileInputStream(file);
                prop.load(fs);
            } catch (FileNotFoundException e) {

                e.printStackTrace();
            } catch (IOException e) {

                e.printStackTrace();
            }

        }
        public String getBrowser(){
            String browser = prop.getProperty("browser");
            return browser;
        }
    public String getWebUrl() {
        String url = prop.getProperty("baseUrl");
        return url;

    }
}
