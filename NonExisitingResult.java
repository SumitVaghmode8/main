import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.beust.jcommander.Parameters;
import com.freecrm.baseclass.BaseClass;

import org.openqa.selenium.WebElement;
public class NonExisitingResult extends BaseClass{
	@Test(groups= {"regression"})
    @Parameters({"browser"})
	public void AddtoCart(String browser)throws AWTException
	{
		NonExisitingResult Result=new NonExisitingResult();
		launch.launchBrowser(browser);
		driver.navigate().to("https://www.amazon.in/");
            // Wait for the page to load
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Find the search box, enter a query and submit the search
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

            // Optionally, print a confirmation message or verify the cart
            System.out.println("Product added to cart successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

	}
	
