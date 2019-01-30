import io.appium.java_client.TouchAction;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.MainPage;
import page.SearchPage;
import page.SelectedPage;

public class SearchTest {
    static MainPage mainPage;
    static SearchPage searchPage;
    static SelectedPage selectedPage;

    @BeforeMethod
    public void bfClass(){
        mainPage = MainPage.start();
        searchPage = mainPage.gotoSearchPage();
    }

    @Test(dataProvider = "getsearchKey",dataProviderClass = DataParams.class)
    public void testSearchButton(String keyword,String expect){
        searchPage.search(keyword);
        String content = searchPage.getStockName().get(0);
        Assert.assertEquals(content,expect);
    }

    @Test(dataProvider = "getsearchKey",dataProviderClass = DataParams.class)
    public void testSelected(String searchname,String stockname){
        searchPage.search(searchname);
        String getAtt = searchPage.getIfSelect();
        Boolean result = false;
        if (getAtt.equals("com.xueqiu.android:id/follow_btn")){
            searchPage.addStock();
            searchPage.nexttime();
            mainPage = searchPage.gobacktoMainPage();
            selectedPage = mainPage.gotoSelectedPage();
            result = selectedPage.findel(stockname);
        }else{
            System.out.println("现在是被选中状态======");
            mainPage = searchPage.gobacktoMainPage();
            selectedPage = mainPage.gotoSelectedPage();
            selectedPage.removeStock(stockname);
            mainPage = selectedPage.gotoMainPage();
            searchPage = mainPage.gotoSearchPage();
            searchPage.search(searchname);
            searchPage.addStock();
            searchPage.nexttime();
            mainPage = searchPage.gobacktoMainPage();
            selectedPage = mainPage.gotoSelectedPage();
            result = selectedPage.findel(stockname);
        }
        Assert.assertTrue(result);
    }

}
