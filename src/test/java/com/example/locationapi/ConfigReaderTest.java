package com.example.locationapi;

import com.example.utils.ConfigReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
import java.io.IOException;

@SpringBootTest
public class ConfigReaderTest {

    @Test
    void testNotExistingFile() {
        Assertions.assertThrows(FileNotFoundException.class, () -> new ConfigReader("not existing"));
        Assertions.assertThrows(FileNotFoundException.class, () -> new ConfigReader("config.property"));
    }

    @Test
    void testNullableFilename() {
        Assertions.assertThrows(NullPointerException.class, () -> new ConfigReader(null));
    }

    @Test
    void testExistingConfigFilename() {
        Assertions.assertDoesNotThrow(()-> new ConfigReader());
        Assertions.assertDoesNotThrow(()->new ConfigReader("config.properties"));
    }

    @Test
    void testConfigExistingValues() throws IOException {
        ConfigReader configReader = new ConfigReader("config.properties");
        Assertions.assertNotNull(configReader.getPropValues("dimension"));
        Assertions.assertNotNull(configReader.getPropValues("nasaApiKey"));
        Assertions.assertNotNull(configReader.getPropValues("bingApiKey"));
    }

    @Test
    void testInitConfigFilenameWrongFileName() throws IOException {
        var configReader = new ConfigReader();
        Assertions.assertThrows(FileNotFoundException.class, () -> configReader.initConfigProperties("config.prop"));
        Assertions.assertThrows(FileNotFoundException.class, () -> configReader.initConfigProperties("werw"));
    }

    @Test
    void testInitConfigFilenameNullableFileName() throws IOException {
        var configReader = new ConfigReader();
        Assertions.assertThrows(NullPointerException.class, () -> configReader.initConfigProperties(null));
    }

    @Test
    void testInitConfigFilenameRightFileName() throws IOException {
        var configReader = new ConfigReader();
        Assertions.assertDoesNotThrow(() -> configReader.initConfigProperties("config.properties"));
    }

    @Test
    void testConfigNonExistingValues() throws IOException {
        ConfigReader configReader = new ConfigReader("config.properties");
        Assertions.assertNull(configReader.getPropValues("213213"));
        Assertions.assertNull(configReader.getPropValues("nasaA34piKey"));
        Assertions.assertNull(configReader.getPropValues("bingApiKey1"));
        Assertions.assertNull(configReader.getPropValues("dimensions"));
    }



}
