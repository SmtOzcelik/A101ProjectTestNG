package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class A101Page {
    public A101Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


}
