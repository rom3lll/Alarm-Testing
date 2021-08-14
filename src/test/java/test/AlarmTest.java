package test;


import activity.AlarmScreen;
import activity.HeaderScreen;
import org.junit.jupiter.api.*;
import session.Session;

import java.net.MalformedURLException;


public class AlarmTest {


    @BeforeEach
    public void setUp() throws MalformedURLException {
        HeaderScreen headerScreen = new HeaderScreen();
        headerScreen.goToAlarmScreen();
        AlarmScreen alarmScreen = new AlarmScreen();
        alarmScreen.deleteAlarmButton();
    }

    @Test
    public void Should_CreateAnAlarm() throws MalformedURLException {
        AlarmScreen alarmScreen = new AlarmScreen();
        alarmScreen.addAlarmButton.click();
        alarmScreen.saveAlarmButton.click();
        alarmScreen.closeAlarmSettingsButton.click();

        boolean actualResult = (alarmScreen.countAlarmButton() >= 1) ? true : false;
        boolean expectedResult = true;
        Assertions.assertEquals(expectedResult, actualResult, "Error");

    }


    @Test
    public void Should_CreateAnAlarmAndDelete() throws MalformedURLException {
        AlarmScreen alarmScreen = new AlarmScreen();
        alarmScreen.addAlarmButton.click();
        alarmScreen.saveAlarmButton.click();
        alarmScreen.deleteAlarmButton.click();

        String actualResult = alarmScreen.noAlarmText.getText();
        String expectedResult = "No Alarms";
        Assertions.assertEquals(expectedResult, actualResult, "Error");
    }

    @Test
    public void Should_CreateAndWriteDescription() throws MalformedURLException {
        AlarmScreen alarmScreen = new AlarmScreen();
        alarmScreen.addAlarmButton.click();
        alarmScreen.saveAlarmButton.click();
        alarmScreen.typeDescriptionAlarm("Test Homework");

        String actualResult = alarmScreen.alarmExistsByDescription("Test Homework");
        String expectedResult = "Test Homework";
        Assertions.assertEquals(actualResult, expectedResult, "Error");
    }

    @Test
    public void Should_CreateAlarmForTomorrow() throws MalformedURLException {
        AlarmScreen alarmScreen = new AlarmScreen();
        alarmScreen.addAlarmButton.click();
        alarmScreen.saveAlarmButton.click();
        alarmScreen.closeAlarmSettingsButton.click();

        String actualResult = alarmScreen.dayDescriptionText.getText();
        String expectedResult = "Tomorrow";
        Assertions.assertEquals(expectedResult, actualResult, "Error");
    }

    @Test
    public void Should_TypeAlarmTime() throws MalformedURLException {
        int hour = 7;
        int minute = 30;
        String meridian = "am";

        AlarmScreen alarmScreen = new AlarmScreen();
        alarmScreen.addAlarmButton.click();
        alarmScreen.setTypeButton.click();
        alarmScreen.typeTime(hour, minute, meridian);
        alarmScreen.saveAlarmButton.click();
        alarmScreen.closeAlarmSettingsButton.click();

        String actualResult = alarmScreen.getAlarmTime();
        String expectedResult = "7:30AM";
        Assertions.assertEquals(expectedResult, actualResult, "Error");
    }

    @AfterEach
    public void tearDown() throws MalformedURLException {
        Session.getInstance().closeSession();
    }

}
