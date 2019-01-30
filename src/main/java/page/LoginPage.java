package page;

import driver.Driver;
import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    private By other= By.id("tv_login_by_phone_or_others");
    private By passwordLogin=text("邮箱手机号密码登录");
    private By username=By.id("login_account");
    private By password=By.xpath("//*[@password='true']");
    private By login=By.id("button_next");
    private By msg=By.id("md_content");
    private By buttononfail = By.id("md_buttonDefaultPositive");
    private By closebutton = By.id("iv_action_back");

    String message;

    public LoginPage passwordFail(String phonenum,String pwd){
        find(other).click();
        find(passwordLogin).click();
        find(username).sendKeys(phonenum);
        find(password).sendKeys(pwd);
        find(login).click();
        message = find(msg).getText();
        find(buttononfail).click();
        return this;
    }

    public String getMessage(){
        return message;
    }

    public ProfilePage gotoProfile(){
        find(closebutton).click();
        return new ProfilePage();
    }
}
