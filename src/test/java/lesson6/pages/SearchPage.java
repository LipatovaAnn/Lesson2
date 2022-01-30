package lesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage extends  BasePage {
    private String pageUrl = "https://www2.hm.com/ru_ru/index.html";

    @FindBy(xpath = "//button[contains(@class,'menu__search_toggle')]")
    private WebElement searchButton;

    @FindBy(id = "main-search")
    private WebElement searchInput;

    @FindBy(xpath = "//div[@id='page-content']/div/ul/li/article/div/a/img")
    private  WebElement firstResult;


    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageUrl() {
        return pageUrl;
    }

    public SearchPage openSearch() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
        return this;
    }

    public boolean isSearchInputVisible() {
        return searchInput.isDisplayed();
    }

    public SearchPage searchFor(String v) {
        searchInput.sendKeys(v);
        searchInput.sendKeys(Keys.ENTER);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.not(ExpectedConditions.urlContains(getPageUrl())));
        return  this;
    }

    public  boolean hasSearchResults(){
       return firstResult.isDisplayed();
    }

    public void clickFirstResult() {
        String currentUrl = driver.getCurrentUrl();
        firstResult.click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.not(ExpectedConditions.urlContains(currentUrl)));
    }
}