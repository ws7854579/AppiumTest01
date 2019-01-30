package page;

import driver.Driver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.tools.ant.types.resources.Touchable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {
    static WebElement find(By locator){
        WebElement element = Driver.getCurrentDriver().findElement(locator);
        return element;
    }

    static By locate(String locator){
        if(locator.matches("/.*")){
            return By.xpath(locator);
        }else {
            return By.id(locator);
        }
    }

    static void pressButton(PointOption po){
        TouchAction ta = new TouchAction(Driver.getCurrentDriver());
        ta.longPress(po).release().perform();
    }

    static By text(String content){
        return By.xpath("//*[@text='"+content+"']");
    }

}
