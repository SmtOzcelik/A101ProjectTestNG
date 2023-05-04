package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class A101Page {
    public A101Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[text()='Kabul Et']")
    public WebElement CookiesButton;

    @FindBy(xpath = "(//a[@title='GİYİM & AKSESUAR'])[1]")
    public WebElement giyimAksesuarMenu;

    @FindBy(xpath = "//a[text()='Dizaltı Çorap']")
    public WebElement dizaltiCorapYazisi;

    @FindBy(xpath = "(//div[@class='product-desc '])[2]")
    public WebElement dizaltiSiyahCorapYazisi;

    @FindBy(xpath = "//div[@class='product-heading']")
    public WebElement ilkSiyahCorapYazisi;

    @FindBy(xpath = "//button[@class='add-to-basket button green block with-icon js-add-basket']")
    public WebElement sepeteEkleButonu;

    @FindBy(xpath = "//a[@class='go-to-shop']")
    public WebElement sepetiGoruntuleButton;

    @FindBy(xpath = "(//a[@title='Sepeti Onayla'])[2]")
    public WebElement sepetiOnaylaButonu;

    @FindBy(xpath = "//a[@class='auth__form__proceed js-proceed-to-checkout-btn']")
    public WebElement uyeOlmadanDevamEtButonu;

    @FindBy(xpath = "//input[@name='user_email']")
    public WebElement emailTextKutusu;

    @FindBy(xpath = "(//a[@class='new-address js-new-address'])[1]")
    public WebElement yeniAdresButonu;

    @FindBy(xpath = "//input[@name='title']")
    public WebElement adresBasligi;

    @FindBy(xpath = "//select[@class='js-cities']")
    public WebElement ilTextKutusu;

    @FindBy(xpath = "//select[@class='js-township']")
    public WebElement ilceTextKutusu;

    @FindBy(xpath = "//select[@class='js-district']")
    public WebElement mahalleTextKutusu;

    @FindBy(xpath = "//*[@class='js-address-textarea']")
    public WebElement adresTextKutusu;

    @FindBy(xpath = "//button[@class='button green address-modal-submit-button js-set-country js-prevent-emoji js-address-form-submit-button']")
    public WebElement kaydetButonu;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    public WebElement kaydetveDevamEtButonu;

    @FindBy(xpath = "//*[text()='2. ÖDEME SEÇENEKLERİ']")
    public WebElement sonAdimDogrulama;




}

