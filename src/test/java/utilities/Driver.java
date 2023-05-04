package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    /*
    POM de Driver icin TestBase classina extends etmek yerine Driver class indan
    static methodlar kullanarak driver olusturup, ilgili ayarlarin yapilmasi
    ve en sonda driver in kapatilmasi tercih edilmiştir
    POM de Driver class indaki getDriver() nin obje olusturularak kullanilmasini engellemek icin
    Singleton pattern kullanimi benimsenmistir.

    Singleton Pattern : tekli kullanim, bir class in farkli class lardan obje oluşturularak
    kullanimi ni engellemek icin kullanilir.

    Bunu saglamak icin yapmamiz gereken sey oldukca basit obje olusturmak icin kullanilan
    constructor i private yaptigimizda baska classlardan Drever class indan obje olusturulmasi mumkün OLMAZ
     */
    static WebDriver driver;

    private Driver(){

    }
    public static WebDriver getDriver(){

        if (driver == null) {

            switch (ConfigReader.getProperty("browser")){

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver=new SafariDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "headhess-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                default:
                    WebDriverManager.operadriver().setup();
                    driver=new ChromeDriver();


            }


            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.manage().window().maximize();
        }
        return driver;
    }
    public static void closeDriver(){
        if (driver!=null){
            driver.close();
            driver=null;
        }

    }
}
