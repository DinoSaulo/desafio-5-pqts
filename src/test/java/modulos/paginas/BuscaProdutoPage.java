package modulos.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BuscaProdutoPage {

    private WebDriver navegador;

    public BuscaProdutoPage (WebDriver navegador){
        this.navegador = navegador;
    }

    public BuscaProdutoPage preencherCampoBusca(String idProduto){
        this.navegador.findElement(By.id("input-search")).click();
        this.navegador.findElement(By.id("input-search")).sendKeys(idProduto);

        this.navegador.findElement(By.cssSelector("[data-testid='search-submit']")).click();

        return this;
    }

}
