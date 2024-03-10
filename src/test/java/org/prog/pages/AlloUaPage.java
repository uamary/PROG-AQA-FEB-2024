package org.prog.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class AlloUaPage {

    private final WebDriver driver;
    public int page;
    public int currentPage;

    public AlloUaPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loadPage() {
        driver.get("https://allo.ua/");
    }

    public void searchForGoods(String searchValue) {
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys(searchValue);
        searchInput.sendKeys(Keys.ENTER);
    }

    public List<WebElement> getSearchResults() {
        return new WebDriverWait(driver, Duration.ofSeconds(30L))
                .until(
                        ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("div.product-card"),
                                1)
                );
    }

    public boolean searchResultsContain(String value) {
        List<WebElement> searchResults = getSearchResults();
        Assert.assertFalse(searchResults.isEmpty(), "Search results must not be empty!");
        boolean valueIsPresent = false;
        for (WebElement e : searchResults) {
            if (e.findElement(By.xpath("div/a")).getText().contains(value)) {
                valueIsPresent = true;
                break;
            }
        }
        return valueIsPresent;
    }

    public WebElement pagination(){
        return driver.findElement(By.className("pagination"));
    }

    public void scrollToElement(WebElement e) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
    }

    public void checkPageUrl(int page){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(3L));
        wait.until(ExpectedConditions.urlContains("index/p-" + page));
    }

    public void clickPageNumber(int page){
        WebElement p = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div[2]/div/div[2]/div[3]/ul/li["+page+"]/a"));
        p.click();
        checkPageUrl(page);
    }

    public int getCurrentPage(){
        WebElement p = driver.findElement(By.cssSelector("#__layout > div > div:nth-child(2) > div.v-catalog > div > div.v-catalog__products > div.pagination > ul > li.pagination__item.current"));
        int currentPage = Integer.parseInt(p.getText());
        return currentPage;
    }

    public void clickNextPage(){
        WebElement p = driver.findElement(By.className("pagination__next__link"));
        p.click();
        checkPageUrl(getCurrentPage()+1);
    }

    public void clickBackPage() throws InterruptedException {
        WebElement p = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div[2]/div/div[2]/div[3]/div[1]"));
        p.click();
        checkPageUrl(getCurrentPage());
    }
}
