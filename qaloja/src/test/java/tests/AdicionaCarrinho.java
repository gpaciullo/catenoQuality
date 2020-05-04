package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.Evidencias;

public class AdicionaCarrinho {
	
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
	public void test() throws InterruptedException {
		
		//STEP 1 - Carrega o site de compras
		driver.get("http://automationpractice.com/index.php");
		assertTrue("Título da página difere do esperado", driver.getTitle().contentEquals("My Store"));
		evidencias.takeScreenShot(driver, "siteCarregado");
		
		//STEP 2 - Clica em um item na tela inicial
		driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/h5/a")).click();
		evidencias.takeScreenShot(driver, "selecionaProduto");
		
		//STEP 3 - Adiciona o item ao carrinho
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button")).click();
		evidencias.takeScreenShot(driver, "adicionaProduto");
		
		//STEP 4 - Vai a tela de Confirmação
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")).click();
		evidencias.takeScreenShot(driver, "confirmaProduto");
		
		//STEP 5 - Vai a tela de pagamento
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span")).click();
		evidencias.takeScreenShot(driver, "Pagamento");
		
		
	}

}
