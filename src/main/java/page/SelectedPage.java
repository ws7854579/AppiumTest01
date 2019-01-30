package page;

import driver.Driver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SelectedPage extends BasePage{
    private By remove = text("删除");
    private By main = text("雪球");

    public Boolean findel(String checkName){
        try{
            WebElement check = find(text(checkName));
        }catch (Error e){
            return false;
        }
        return true;
    }

    public void removeStock(String name){
        WebElement element = find(text(name));
        PointOption po = new PointOption();
        po.withCoordinates(element.getLocation().getX(),element.getLocation().getY());
        pressButton(po);
        find(remove).click();
    }

    public MainPage gotoMainPage(){
        find(main).click();
        return new MainPage();
    }

}
