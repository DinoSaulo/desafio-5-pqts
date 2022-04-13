package modulos.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ListaProdutoPage {
    private WebDriver navegador;

    public ListaProdutoPage (WebDriver navegador){
        this.navegador = navegador;
    }

    public ListaProdutoPage clicarEmProduto(){
        this.navegador.findElement(By.cssSelector("[data-testid='product-card-content']")).click();

        return this;
    }

}
