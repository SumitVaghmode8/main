import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.beust.jcommander.Parameters;

import java.awt.AWTException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonAddToCartAndUpdateQuantity {
	@Test(groups= {"regression"})
    @Parameters({"browser"})
	public void AddtoCart(String browser)throws AWTException
	{
		AmazonAddToCartAndUpdateQuantity quantity=new AmazonAddToCartAndUpdateQuantity();
		launch.launchBrowser(browser);
		driver.navigate().to("https://www.amazon.in/");
            // Wait for the page to load
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            // Find the search box, enter "laptop", and submit the search
            WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
            searchBox.sendKeys("laptop");
            searchBox.submit();

            // Wait for search results to load
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Click on the first product in the search results
            WebElement firstProduct = driver.findElement(By.cssSelector(".s-main-slot .s-result-item"));
            firstProduct.click();

            // Wait for the product page to load
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Click the "Add to Cart" button
            WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
            addToCartButton.click();

            // Wait for the cart to update
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Navigate to the cart
            WebElement cartIcon = driver.findElement(By.id("nav-cart"));
            cartIcon.click();

            // Wait for the cart page to load
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Find the quantity dropdown and select "2"
            WebElement quantityDropdown = driver.findElement(By.name("quantity"));
            quantityDropdown.click(); // Click to reveal the dropdown options
            
            WebElement quantityOption = driver.findElement(By.xpath("//option[@value='2']"));
            quantityOption.click(); // Select "2" from the dropdown

            // Verify the quantity update
            WebElement quantityValue = driver.findElement(By.cssSelector(".a-dropdown-prompt"));
            if (quantityValue.getText().equals("2")) {
                System.out.println("Quantity successfully updated to 2.");
            } else {
                System.out.println("Failed to update quantity.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
            

}
