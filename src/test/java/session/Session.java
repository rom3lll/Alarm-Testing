package session;

import factoryDevice.FactoryDevice;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.AfterEach;

import java.net.MalformedURLException;

public class Session {

    private static Session instance = null;
    private AppiumDriver driver;

    private Session() throws MalformedURLException {
        driver = FactoryDevice.make(FactoryDevice.DeviceType.ANDROID).create();
    }

    public static Session getInstance() throws MalformedURLException {
        if (instance == null)
            instance = new Session();
        return instance;
    }

    public void closeSession() {
        driver.quit();
        instance = null;
    }

    public AppiumDriver getDriver() {
        return driver;
    }

}
