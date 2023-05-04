package test;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.A101Page;
import utilities.ConfigReader;
import utilities.Driver;

public class TestCase  {
    /*
     Uçtan uca ödeme ekranına kadar Selenium’da java dili ile chrome browser kullanarak test otomasyon ödevi yapılacak.
     Ödeme ekranı doldurulmayacak. Aşağıdaki senaryoyu web ve mobil olmak üzere 2 çeşit oluşturabilirlerse çok iyi olur. En az Web’de yapmak zorunlu.
     - Senaryoya üye kaydı oluşturmadan devam edilecek.
     - Giyim--> Aksesuar--> Kadın İç Giyim-->Dizaltı Çorap bölümüne girilir.
     - Açılan ürünün siyah olduğu doğrulanır.
     - Sepete ekle butonuna tıklanır.
     - Sepeti Görüntüle butonuna tıklanır.
     - Sepeti Onayla butonuna tıklanır.
     - Üye olmadan devam et butonuna tıklanır.
     - Mail ekranı gelir.
     - Sonrasında adres ekranı gelir. Adres oluştur dedikten sonra ödeme ekranı gelir.
     - Siparişi tamamla butonuna tıklayarak, ödeme ekranına gidildiği ,doğru ekrana yönlendiklerini kontrol edecekler.
     */

    @Test
    public void a101Test() throws InterruptedException {
        A101Page a101Page=new A101Page();

        Actions actions=new Actions(Driver.getDriver());
        Faker faker=new Faker();

        // Kullanici "https://a101.com.tr" sayfasina gider.
        Driver.getDriver().get(ConfigReader.getProperty("a101Url"));

        // Cookies kabul edilir.
        a101Page.CookiesButton.click();


        // Kullanici "Giyim&Aksesuar" bolumune mouse'u getirerek bekler.
        actions.moveToElement(a101Page.giyimAksesuarMenu).perform();


        // Kullanıcı "Kadın İç Giyim" bolumun altındaki "Dizaltı Çorap" bolumune tiklar.
            a101Page.dizaltiCorapYazisi.click();

        // Kullanici acilan sayfada siyah olan urune tiklar.
        a101Page.dizaltiSiyahCorapYazisi.click();


        // Kullanıcı açılan sayfada ilk ürünün "SİYAH" olup olmadığını doğrular.
         String actualSonuc= a101Page.ilkSiyahCorapYazisi.getText();
         String expectedSonuc="SİYAH";
        Assert.assertTrue(actualSonuc.contains(expectedSonuc));

        // Kullanici "Sepete Ekle" butonuna tiklar.
        a101Page.sepeteEkleButonu.click();

        // Kullanici "Sepeti Görüntüle" butonuna tiklar.
        a101Page.sepetiGoruntuleButton.click();

        // Kullanici "Sepeti Onayla" butonuna tiklar.
        a101Page.sepetiOnaylaButonu.click();

        // Kullanici "Üye Olmadan Devam Et" butonuna tiklar.
        a101Page.uyeOlmadanDevamEtButonu.click();


        // Kullanici mail adresini girer.
        a101Page.emailTextKutusu.sendKeys(faker.internet().emailAddress(), Keys.ENTER);


        // Kullanici "Yeni adres oluştur" butonuna tiklar.
        a101Page.yeniAdresButonu.click();


        // Kullanici "Adres Başlığı" ve diger bilgilerini girer.
        actions.click(a101Page.adresBasligi).sendKeys("Ev adresi").sendKeys(Keys.TAB)
                .sendKeys(faker.name().firstName()).sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName()).sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().phoneNumber()).sendKeys(Keys.TAB)
                .perform();

        // Kullanici "il" secer.
        Select selectIlKutusu=new Select(a101Page.ilTextKutusu);
        selectIlKutusu.selectByVisibleText("ANKARA");

        // Kullanici "ilçe" secer.
        Thread.sleep(1000);
        Select selectilceKutusu=new Select(a101Page.ilceTextKutusu);
        selectilceKutusu.selectByVisibleText("YENİMAHALLE");

        // Kullanici "mahalle" secer.
        Thread.sleep(1000);
        Select selectMahalleKutusu=new Select(a101Page.mahalleTextKutusu);
        selectMahalleKutusu.selectByVisibleText("DEMETEVLER MAH");

        // Kullanici adres bilgilerini girer.
        Thread.sleep(1000);
        a101Page.adresTextKutusu.sendKeys("DemetevlerMah 317. cadde 36/10");


        // Kullanici "Kaydet" butonuna tiklar.
        Thread.sleep(1000);
        a101Page.kaydetButonu.click();


        // Adres kaydedildikten ve kargo secildikten sonra kullanici "Kaydet ve Devam Et" butonuna tiklar.
        Thread.sleep(1000);
        a101Page.kaydetveDevamEtButonu.click();
        a101Page.kaydetveDevamEtButonu.click();

        // Kullanici "Ödeme Seçenekleri" sayfasina geldigini dogrular.

        Assert.assertTrue(a101Page.sonAdimDogrulama.isDisplayed());
        // Kullanici browser'i kapatir.
        Driver.closeDriver();

    }
}
