package br.com.vemrankser.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class NavbarPage extends BasePage {

    private static final By btnCarrinho =
            By.cssSelector("#__next > div:nth-child(1) > header > div.responsive-header__button-wrapper > button");
    private static final By msgErroCarrinhoVazio =
            By.cssSelector("body > div.drawer > div > div > div > div > div > span.restaurant-cart__empty--large");
    private static final By campoBuscarItemOuLoja =
            By.cssSelector("#__next > div:nth-child(1) > header > div.search-input > form > div > input");
    private static final By msgErroNenhumProduto =
            By.className("cardstack-info-card__title");
    private static final By primeiroItemDaLista =
            By.cssSelector("div > section > section > article > section:nth-child(1) > ul > li:nth-child(1) > article > div > div > div.swiper-wrapper > div");
    private static final By btnAdicionarAoCarrinho =
            By.xpath("/html/body/div[11]/div/div/div/div/section/div[2]/div[5]/div/button");
    private static final By btnFecharModalProduto =
            By.xpath("/html/body/div[11]/div/div/div/div/div[2]/div[3]/button");
    private static final By btnMudarBuscaPorItem =
            By.id("marmita-tab1-1");
    private static final By toastCupomInvalido =
            By.xpath("//*[@id=\"__next\"]/div[1]/div/div/span[2]");
    private static final By divBtnCupom =
            By.cssSelector("body > div.drawer > div > div > div > div > div > div:nth-child(2) > div > div > div.checkout-voucher");
    private static final By campoCupom =
            By.id("campaignCode");
    private static final By btnAdicionarCupom =
            By.cssSelector("body > div.drawer > div > div > div > div > div > div:nth-child(1) > div > div > form.manual-voucher > button");
    public static final By btnRemoverProdutoCarrinho =
            By.cssSelector("body > div.drawer > div > div > div > div > div > div:nth-child(2) > div > div > div.restaurant-cart-items-list > div > div.restaurant-cart-item__buttons-wrapper > button.btn.btn--link.btn--gray.btn--size-m.restaurant-cart-item__button");


    @Step("Preencher campo buscar.")
    public void preencherCampoBuscar(String item) {

        sendKeys(campoBuscarItemOuLoja, item);
    }
    @Step("Cliclar em buscar.")
    public void pressionarTeclaEnterCampoEnter() {

        WebElement campoBuscar = element(campoBuscarItemOuLoja);
        campoBuscar.sendKeys(Keys.ENTER);
    }
    @Step("Cliclar no botão adicionar cupom.")
    public void clicarBtnAdicionarCupom() {

        click(btnAdicionarCupom);
    }
    public String buscarCampoMsgErroBuscaProduto() {

        return getText(msgErroNenhumProduto);
    }
    @Step("Cliclar no primeiro item da lista.")
    public void clicarNoPrimeiroItemDaLista() {

        click(primeiroItemDaLista);
    }
    @Step("Cliclar no botão fechar modal do produto.")
    public void clicarBotaoFecharModalProduto() {

        click(btnFecharModalProduto);
    }
    @Step("Cliclar no botão adicionar ao carrinho.")
    public void clicarAdicionarAoCarrinho() {

        click(btnAdicionarAoCarrinho);
    }
    @Step("Cliclar no botão do carrinho.")
    public void clicarBtnCarrinho() {

        click(btnCarrinho);
    }
    @Step("Cliclar no botão buscar item.")
    public void clicarBtnBuscarPorItem() {

        click(btnMudarBuscaPorItem);
    }
    public String buscarMesnagemCarrinhoVazio() {

        return getText(msgErroCarrinhoVazio);
    }
    public boolean verificarMsgCarrinhoVazioEstaPresente() {

        try{
            driver.findElement(msgErroCarrinhoVazio);
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }

    public String buscarMsgToastCupom() {

        return getText(toastCupomInvalido);
    }
    @Step("Cliclar no botão cupom.")
    public void clicarBtnCupom() {

        click(divBtnCupom);
    }
    @Step("Preencher campo cupom.")
    public void preencherCampoCupom(String cupom) {

        sendKeys(campoCupom, cupom);
    }
    @Step("Cliclar no botão remover.")
    public void clicarBtnRemoverProdutoCarrinho() {

        click(btnRemoverProdutoCarrinho);
    }
}
