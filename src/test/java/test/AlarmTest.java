package test;


import activity.AlarmScreen;
import activity.HeaderScreen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import session.Session;
import java.net.MalformedURLException;

public class AlarmTest {



    @BeforeEach
    public void setUp() throws MalformedURLException {
        HeaderScreen headerScreen=new HeaderScreen();
        headerScreen.goToAlarmScreen();
    }

    @Test
    public void Should_CreateAnAlarm() throws MalformedURLException {
        AlarmScreen alarmScreen= new AlarmScreen();
        alarmScreen.addAlarmButton.click();
        alarmScreen.saveAlarmButton.click();
        alarmScreen.closeAlarmSettingsButton.click();
    }


    @Test
    public void Should_CreateAnAlarmAndDelete() throws MalformedURLException {
        AlarmScreen alarmScreen= new AlarmScreen();
        alarmScreen.addAlarmButton.click();
        alarmScreen.saveAlarmButton.click();
        alarmScreen.deleteAlarmButton.click();
    }
    @Test
    public void Should_CreateAndWriteDescription() throws MalformedURLException {
        AlarmScreen alarmScreen= new AlarmScreen();
        alarmScreen.addAlarmButton.click();
        alarmScreen.saveAlarmButton.click();
        alarmScreen.typeDescriptionAlarm("Test Homework");

    }

    @Test
    public void Should_SelectAlarmDay() throws MalformedURLException {
        AlarmScreen alarmScreen= new AlarmScreen();
        alarmScreen.addAlarmButton.click();
        alarmScreen.saveAlarmButton.click();
        alarmScreen.repeatButton.click();
        alarmScreen.selectDay("monday");
        alarmScreen.closeAlarmSettingsButton.click();
    }
    @Test
    public void Should_TypeAlarmTime() throws MalformedURLException {
        AlarmScreen alarmScreen= new AlarmScreen();
        alarmScreen.addAlarmButton.click();
        alarmScreen.setTypeButton.click();
        alarmScreen.typeTime(7,30,"am");
        alarmScreen.saveAlarmButton.click();
        alarmScreen.closeAlarmSettingsButton.click();
    }
    @AfterEach
    public void tearDown() throws MalformedURLException {
        Session.getInstance().closeSession();
    }
}
