package page;
import driver.Driver;
import org.openqa.selenium.By;

public class MainPage extends BasePage{
    private By profile = By.id("user_profile_icon");
    private By search = By.id("home_search");
    private By selected = text("自选");
    public static MainPage start(){
        Driver.start();

        return new MainPage();
    }

    public ProfilePage gotoProfilePage(){
        Driver.getCurrentDriver().findElement(profile).click();
        return new ProfilePage();
    }

    public SearchPage gotoSearchPage(){
        find(search).click();
        return new SearchPage();
    }

    public SelectedPage gotoSelectedPage(){
        find(selected).click();
        return new SelectedPage();
    }
}
