package lesson6.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private String pageUrl = "https://www2.hm.com/ru_ru/index.html";

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement cookieBtn;

    @Override
    public String getPageUrl() {
        return pageUrl;
    }

    public boolean acceptAllCookiesButtonIsDisplayed() {
        return cookieBtn.isDisplayed();
    }

    public void clickAcceptAllCookies() {
        cookieBtn.click();
    }
}