package modulos.sacola;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

@DisplayName("Testes de produtos adicionados na sacola do Magalu")
public class SacolaTest {

    private WebDriver navegador;

    @Test
    public void test(){
        // Acessando o site da magalu
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver100\\chromedriver.exe");
        this.navegador = new ChromeDriver();
        this.navegador.manage().window().maximize();
        this.navegador.get("https://www.magazineluiza.com.br/");

        WebElement inputBusca = this.navegador.findElement(By.id("input-search"));
        WebElement btnPesquisar = this.navegador.findElement(By.cssSelector("[data-testid='search-submit']"));

        // digitar na busca
        inputBusca.click();
        inputBusca.sendKeys("011338601");

        // clicar em buscar
        btnPesquisar.click();
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // clicar na lista de produtos
        WebElement produto = this.navegador.findElement(By.cssSelector("[data-testid='product-card-content']"));
        produto.click();

        //selecionar a voltagem
        WebElement inputVoltagem = this.navegador.findElement(By.id("variation-label"));
        inputVoltagem.click();
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        this.navegador.findElement(By.xpath("//*[text()=' 110V  ']")).click();

        // clicar no botão de adicionar a sacola
        WebElement btnAdicionar = this.navegador.findElement(By.className("js-add-cart-button"));
        btnAdicionar.click();

        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // clicar no botão continuar
        WebElement btnContinuar = this.navegador.findElement(By.className("price-warranty__btn--continue"));
        btnContinuar.click();

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
}
