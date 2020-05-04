package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.Evidencias;

public class ValidaBusca {
	
	private WebDriver driver;
	private Evidencias evidencias =  new Evidencias();

	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Workspace\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() {
		
		//STEP 1 - Carrega o site de compras
		driver.get("http://automationpractice.com/index.php");
		assertTrue("Título da página difere do esperado", driver.getTitle().contentEquals("My Store"));
		evidencias.takeScreenShot(driver, "siteCarregado");
		
		//STEP 2 - Realiza a busca de um item e clica no botão pesquisar
		driver.findElement(By.xpath("//*[@id=\"search_query_top\"]")).sendKeys("Shirt");
		driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();
		
		//STEP 3 - Retorna a busca
		assertTrue("Título da página difere do esperado", driver.getTitle().contentEquals("Search - My Store"));
		evidencias.takeScreenShot(driver, "buscaResultado");
		
		
	}

}
