package modulos.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GarantiaProdutoPage {

    private WebDriver navegador;

    public GarantiaProdutoPage(WebDriver navegador){
        this.navegador = navegador;
    }

    public GarantiaProdutoPage clicarContinuar(){
        this.navegador.findElement(By.className("price-warranty__btn--continue")).click();
        return this;
    }
}
