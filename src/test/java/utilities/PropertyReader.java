package utilities;

//single tone design pattern

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private static final Properties _prop;
    private static final Properties _alertMessage;
    private static final Properties _data;


    static {
        _prop = loadProps("configuration.properties");
        _alertMessage = loadProps("alert-messages.properties");
        _data = loadProps("data.properties");
    }

    private static Properties loadProps(String path){
        Properties props = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = ClassLoader.getSystemResourceAsStream(path);
            if (inputStream != null){
                props.load(inputStream);
                return props;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String getProperty(String key){
        return _prop.getProperty(key);
    }
    public static String getAlertMessage(String key) {return _alertMessage.getProperty(key);}
    public static String getData(String key) {return _data.getProperty(key);}
}