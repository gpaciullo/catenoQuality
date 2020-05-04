package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.Evidencias;

public class RealizaLogin {
	
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
		
		//STEP 3 - Digita Usuário
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("teste@testemail.com");
		evidencias.takeScreenShot(driver, "digitaUsuario");
		
		//STEP 4 - Digita Senha
		driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("teste");
		evidencias.takeScreenShot(driver, "digitaSenha");
		
		//STEP 5 - Clica botão login
		driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
		evidencias.takeScreenShot(driver, "clicaSubmit");
		
		
		//STEP 6 - Retorna MSG de erro
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]"));
		evidencias.takeScreenShot(driver, "retornoErro");
		
		
		
	}

}
