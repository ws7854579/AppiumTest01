package page;

import driver.Driver;
import org.openqa.selenium.By;

public class ProfilePage extends BasePage{
    private By login = text("登录雪球");

    public LoginPage goLoginPage(){
        Driver.getCurrentDriver().findElement(login).click();
        return new LoginPage();
    }
}
