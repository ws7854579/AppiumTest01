import org.testng.annotations.DataProvider;

public class DataParams {
    @DataProvider
    public Object[][] getLoginParams(){
        return new Object[][]{
                {"13333","qwerty12","手机号码填写错误"},
                {"13716018392","qwerty12","用户名或密码错误"}
        };
    }

    @DataProvider
    public Object[][] getsearchKey(){
        return new Object[][]{
                {"sina","新浪"},
                {"pdd","拼多多"}
        };
    }
}
