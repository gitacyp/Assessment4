package FolderTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetProduct extends BaseTest {

    @Test
    public void addProduct(){
        WebElement laptopLink = driver.get().findElement(By.xpath("//a[.='Laptops']"));
        laptopLink.click();

        WebElement firstItem = explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Sony vaio i5']")));
        firstItem.click();

        WebElement addToCart = explicitWait.get().until(ExpectedConditions.elementToBeClickable(By.xpath("//a[.='Add to cart']")));
        addToCart.click();

        Alert alert = explicitWait.get().until(ExpectedConditions.alertIsPresent());
        String alertMessage = alert.getText();
        Assert.assertTrue(alertMessage.equals("Product added") || alertMessage.equals("This product is not available."), "Alert message was not as expected: " + alertMessage);
        alert.accept();

        WebElement cart = driver.get().findElement(By.xpath("//a[@id='cartur']"));
        cart.click();

        WebElement cartDetail = explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[.='Sony vaio i5']")));

        Assert.assertTrue(cartDetail.getText().contains("Sony vaio i5"), "Product is not available");

    }
}
