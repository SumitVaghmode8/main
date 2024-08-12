
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.beust.jcommander.Parameters;

import java.awt.AWTException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonSearchExistingProduct  extends BaseClass{
	@Test(groups= {"regression"})
    @Parameters({"browser"})
	public void AddtoCart(String browser)throws AWTException
	{
		AmazonSearchExistingResult Result=new AmazonSearchExistingResult();
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

            // Find search result items
            List<WebElement> searchResults = driver.findElements(By.cssSelector(".s-main-slot .s-result-item"));

            if (searchResults.isEmpty()) {
                System.out.println("No search results found for 'laptop'.");
            } else {
                System.out.println("Found " + searchResults.size() + " search results for 'laptop':");

                // Print the titles of the first few results
                for (int i = 0; i < Math.min(5, searchResults.size()); i++) {
                    WebElement result = searchResults.get(i);
                    WebElement titleElement = result.findElement(By.cssSelector("h2 a span"));
                    System.out.println((i + 1) + ". " + titleElement.getText());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
