package activity;

import controlAppium.Button;
import controlAppium.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import session.Session;

import java.net.MalformedURLException;

public class AlarmScreen {

    public Button addAlarmButton = new Button(By.id("com.google.android.deskclock:id/fab"));
    public Button saveAlarmButton = new Button(By.id("android:id/button1"));
    public Button closeAlarmSettingsButton = new Button(By.xpath("//android.widget.ImageButton[@content-desc='Collapse alarm']"));
    public Button deleteAlarmButton = new Button(By.id("com.google.android.deskclock:id/delete"));
    public Button typeOnAlarmButton = new Button(By.id("com.google.android.deskclock:id/edit_label"));
    public Button repeatButton = new Button(By.id("com.google.android.deskclock:id/repeat_onoff"));
    public Button setTypeButton = new Button(By.id("android:id/toggle_mode"));
    public TextBox descriptionAlarmText = new TextBox(By.xpath("//android.widget.FrameLayout/alf/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.EditText"));

    public AlarmScreen() {
    }

    public void typeDescriptionAlarm(String text) throws MalformedURLException {
        typeOnAlarmButton.click();
        descriptionAlarmText.typeValue(text);
        saveAlarmButton.click();
    }

    public void typeTime(int hour, int minute, String meridian) throws MalformedURLException {
        WebElement hourTime = Session.getInstance().getDriver().findElement(By.id("android:id/input_hour"));
        hourTime.clear();
        hourTime.sendKeys(Integer.toString(hour));
        WebElement minuteTime = Session.getInstance().getDriver().findElement(By.id("android:id/input_minute"));
        minuteTime.clear();
        minuteTime.sendKeys(Integer.toString(minute));
        selectMeridian(meridian);
    }


    public void selectDay(String day) throws MalformedURLException {
        day = day.substring(0, 1).toUpperCase() + day.substring(1).toLowerCase();
        WebElement element = Session.getInstance().getDriver().findElement(By.xpath("//android.widget.CheckBox[@content-desc='" + day + "']"));
        element.click();
    }

    private void selectMeridian(String meridian) throws MalformedURLException {
        WebElement selectMeridian = Session.getInstance().getDriver().findElement(By.id("android:id/am_pm_spinner"));
        selectMeridian.click();
        meridian = meridian.toUpperCase();
        String meridianXpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[%s]";
        if (meridian.equals("AM")) {
            meridianXpath = String.format(meridianXpath, "1");
        } else if (meridian.equals("PM")) {
            meridianXpath = String.format(meridianXpath, "2");
        }
        WebElement element = Session.getInstance().getDriver().findElement(By.xpath(meridianXpath));
        element.click();
    }
}
