package page;

import driver.Driver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import sun.applet.Main;

import java.util.ArrayList;

import static driver.Driver.getCurrentDriver;

public class SearchPage extends BasePage{
    private By searchbutton = By.id("search_input_text");
    //private By stockname = By.id("stockName");
    private By cancelsearch = locate("com.xueqiu.android:id/action_close");


    public SearchPage search(String keyword){
        find(searchbutton).sendKeys(keyword);
        return this;
    }

    public ArrayList<String> getStockName(){
        ArrayList<String> array = new ArrayList<String>();
        for(WebElement e: Driver.getCurrentDriver().findElements(By.id("stockName"))){
            array.add(e.getText());
        }
        return array;
    }

    public String getIfSelect(){
        AndroidElement select = (AndroidElement) find(By.xpath("//*[contains(@resource-id,'follow') and contains(@resource-id,'_btn')]"));
        String att = select.getAttribute("resourceId");
        System.out.println(att);
        return att;
    }

    public void addStock(){
        AndroidElement select=(AndroidElement) find(By.xpath("//*[contains(@resource-id, 'follow') and contains(@resource-id, '_btn')]"));
        select.click();
    }

    public MainPage gobacktoMainPage(){
        find(cancelsearch).click();
        return new MainPage();
    }

    public void nexttime(){
        try{
            WebElement check = find(locate("com.xueqiu.android:id/md_buttonDefaultNegative"));
            check.click();
        }catch (Error e){
            System.out.println("继续下一步。");
        }
    }



}
