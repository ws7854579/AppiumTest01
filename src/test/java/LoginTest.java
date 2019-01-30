import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LoginPage;
import page.MainPage;
import page.ProfilePage;

public class LoginTest {
    static MainPage mainPage;
    static ProfilePage profilePage;
    @BeforeClass
    static void beforeClass(){
        mainPage = MainPage.start();
        profilePage = mainPage.gotoProfilePage();
    }


    @Test(dataProvider = "getLoginParams",dataProviderClass = DataParams.class)
    public void TestLogin(String username,String pwd,String expected){
        LoginPage loginPage = profilePage.goLoginPage();
        loginPage.passwordFail(username,pwd);
        String msg = loginPage.getMessage();
        Assert.assertEquals(msg,expected);
        loginPage.gotoProfile();
    }

}
