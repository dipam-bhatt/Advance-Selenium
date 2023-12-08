package M8AdvanceSelenium;


	

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

import ExcelsheetReader.Excelsheet;
import util.DriverConnection;




	public class Q1 {
		static WebDriver driver;

		@BeforeClass
		public void openBrowser() {
			driver = new DriverConnection().getConnectionDriver();
driver.get("https://careercenter.tops-int.com/");
		}

		@Test(dataProvider = "dp")
		public void logintest(long MobNo, long pass) throws InterruptedException {
			String mo = String.valueOf(MobNo);
			String pas = String.valueOf(pass);
			System.out.println(MobNo + " " + pass);
			WebElement MobileNo = driver.findElement(By.id("mobile"));
			MobileNo.clear();
			MobileNo.sendKeys(mo);
			System.out.println("mob no entered");
			WebElement password = driver.findElement(By.id("password"));
			password.clear();
			password.sendKeys(pas);
			System.out.println("Pass no entered");
			Thread.sleep(2000);
			WebElement lgn_But = driver.findElement(By.xpath("//form[@id='loginForm']/div[3]/input"));
			// Thread.sleep(2000);
			lgn_But.click();
			System.out.println("login clicked");
			Thread.sleep(2000);
		}

		@DataProvider(name = "dp")
		public Object[][] data() {
			Excelsheet  ex = new Excelsheet() ("C:\\Users\\HP\\OneDrive\\Desktop\\excel\\Datadrivven.xlsx", "Sheet1");
			int row = ex.rowCount();
			System.out.println("row : " + row);
			int col = ex.colCount();
			System.out.println("col : " + col);

			Object obj[][] = new Object[row - 1][col];

			for (int i = 1; i < row; i++) {
				for (int j = 0; j < col; j++) {
					String data = ex.getData(i, j);
					obj[i - 1][j] = data;
				}
			}
			return obj;
		}
	}


