package techproed.tests.day26_ExcelDataProvider;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C01_DataProvider {
    @DataProvider
    public static Object[][] kullanicilar() {
        return new Object[][]{{ConfigReader.getProperty("email1"),ConfigReader.getProperty("password1")},
                {ConfigReader.getProperty("email2"),ConfigReader.getProperty("password2")}};
    }
    @Test(dataProvider = "kullanicilar")
    public void test1(String email,String password) {
        Driver.getDriver().get(ConfigReader.getProperty("blueRentACarUrl"));
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.login.click();//login buttonuna tıklar
        blueRentalPage.email.sendKeys(email, Keys.TAB,password,Keys.ENTER);
        ReusableMethods.bekle(3);
        Driver.closeDriver();
    }
}
/*
email1=sam.walker@bluerentalcars.com
email2=kate.brown@bluerentalcars.com
email3=raj.khan@bluerentalcars.com
email4=pam.raymond@bluerentalcars.com
password1=c!fas_art
password2=tad1$Fas
password3=v7Hg_va^
password4=Nga^g6!
 */