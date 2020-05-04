package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.Evidencias;

public class CriaConta {
	
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
		
		//STEP 2 - Clica no link LOGIN
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
		evidencias.takeScreenShot(driver, "clicaLogin");
		
		//STEP 3 - Digita Email
		driver.findElement(By.xpath("//*[@id=\"email_create\"]")).sendKeys("teste@testemail.com");
		evidencias.takeScreenShot(driver, "digitaEmail");
		
		//STEP 5 - Clica botão Create
		driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]")).click();
		evidencias.takeScreenShot(driver, "clicaCreate");		
		
		//STEP 6 - Abre página de cadastro
		driver.findElement(By.xpath("//*[@id=\"noSlide\"]/h1"));
		evidencias.takeScreenShot(driver, "realizarCadastro");
		
		
		
	}

}
