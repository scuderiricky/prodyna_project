package com.example.utils;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {


    private static final String DEFAULT_CONFIG = "config.properties";
    private Properties configProperties;

    public ConfigReader() throws IOException {
        initConfigProperties(getDefaultConfigFileName());
    }

    public ConfigReader(String propFileName) throws IOException {
        initConfigProperties(propFileName);
    }

    public static final String getDefaultConfigFileName(){
        return DEFAULT_CONFIG;
    }

    public void initConfigProperties(String filename) throws IOException {
        if(filename == null){
            throw new NullPointerException("Filename cannot be null");
        }

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
        if (inputStream == null) {
            throw new FileNotFoundException("property file '" + filename + "' not found in the classpath");
        }
        else{
            configProperties = new Properties();
            configProperties.load(inputStream);
            inputStream.close();
        }
    }

    public String getPropValues(String key) {
       return configProperties.getProperty(key);
    }

}
