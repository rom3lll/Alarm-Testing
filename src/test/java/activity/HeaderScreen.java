package activity;


import controlAppium.Button;
import org.openqa.selenium.By;
import java.net.MalformedURLException;

public class HeaderScreen {

    public HeaderScreen(){}

    public Button alarmButton= new Button(By.xpath("//android.widget.HorizontalScrollView/android.widget.LinearLayout/za[1]"));
    public Button clockButton= new Button(By.xpath("//android.widget.HorizontalScrollView/android.widget.LinearLayout/za[2]"));
    public Button timerButton= new Button(By.xpath("//android.widget.HorizontalScrollView/android.widget.LinearLayout/za[3]"));
    public Button stopwatchButton= new Button(By.xpath("//android.widget.HorizontalScrollView/android.widget.LinearLayout/za[3]"));

    public void goToAlarmScreen() throws MalformedURLException {
        alarmButton.click();
    }

}
