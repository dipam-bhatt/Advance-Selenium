package Assessment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class editdelete {
	public static void main(String[] args) throws InterruptedException {
	    WebDriver driver = new DriverConnection().getConnection();
	    driver.get("https://demoqa.com/webtables");
	    
	    WebElement edit = driver.findElement(By.xpath("//span[@id='edit-record-1']"));
	    edit.click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//button[@class='close']/span[1]")).click();
	    WebElement delete = driver.findElement(By.xpath("//span[@id='delete-record-1']"));
	    delete.click();
		}
}
