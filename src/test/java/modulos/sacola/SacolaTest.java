package modulos.sacola;

import modulos.paginas.*;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import modulos.paginas.BuscaProdutoPage;

import java.time.Duration;

@DisplayName("Testes de produtos adicionados na sacola do Magalu")
public class SacolaTest {

    private WebDriver navegador;


    @BeforeEach
    public void beforeEach(){
        // Acessando o site da magalu
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver100\\chromedriver.exe");
        this.navegador = new ChromeDriver();
        this.navegador.manage().window().maximize();
        this.navegador.get("https://www.magazineluiza.com.br/");
    }

    @Test
    public void testAdicionarProdutoNaSacola(){
        BuscaProdutoPage buscaProdutoPage = new BuscaProdutoPage(navegador);
        buscaProdutoPage.preencherCampoBusca("011338601");

        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        ListaProdutoPage listaProdutoPage = new ListaProdutoPage(navegador);
        listaProdutoPage.clicarEmProduto();

        ProdutoPage produtoPage = new ProdutoPage(navegador);
        produtoPage.selecionarVoltagem("110V");

        produtoPage.adicionarNaSacola();

        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        GarantiaProdutoPage garantiaProdutoPage = new GarantiaProdutoPage(navegador);
        garantiaProdutoPage.clicarContinuar();

        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // validar o código
        String codigoProduto = this.navegador.findElement(By.className("BasketItemProduct-info-sku")).getText();
        Assert.assertEquals(codigoProduto, "Código do produto: 011338601");

        // validar a quantidade
        String quantidadeProduto = this.navegador.findElement(By.className("BasketPriceBox-prices-title--normal")).getText();
        Assert.assertEquals(quantidadeProduto, "(1 item)");

        // validar a voltagem
        String tituloProduto = this.navegador.findElement(By.className("BasketItemProduct-info-title")).getText();
        Assert.assertEquals(tituloProduto.contains("110V"), true);

    }

    @AfterEach
    public void afterEach(){
        navegador.quit();
    }
}
