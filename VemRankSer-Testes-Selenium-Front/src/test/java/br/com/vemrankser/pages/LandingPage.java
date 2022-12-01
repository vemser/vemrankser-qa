package br.com.vemrankser.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LandingPage extends BasePage{

    private static final By campoEnderecoInicio =
            By.cssSelector("body > div:nth-child(11) > div > div > div > div > div > div:nth-child(1) > div > div > div.address-list-step__container.address-list-step__container--visible > div.address-search-input.address-search-input--role-button > button.address-search-input__button");

    private static final By primeiroEnderecoLista =
            By.cssSelector("body > div:nth-child(11) > div > div > div > div > div > div:nth-child(2) > div > div.address-search-step > div.address-search-step__results > ul > li:nth-child(1) > div > button");

    private static final By botaoConfirmarLocalizacao =
            By.cssSelector("body > div:nth-child(11) > div > div > div > div > div > div:nth-child(3) > div.address-maps__map > button");

    private static final By botaoSalvarEndereco =
            By.cssSelector("body > div:nth-child(11) > div > div > div > div > div > div:nth-child(3) > div.address-finder__complete-form.address-finder__complete-form--active > div.complete-address > form > div.complete-address--save-btn > button");

    private static final By mensagemErroEnderecoInvalido =
            By.cssSelector("body > div:nth-child(11) > div > div > div > div > div > div:nth-child(2) > div > div.address-search-step > div.address-search-step__results > div > span");

    private static final By mensagemErroNumeroNaoInformado =
            By.cssSelector("body > div:nth-child(11) > div > div > div > div > div > div:nth-child(2) > div > div.address-number.address-number--visible > div > p");
    private static final By btnBuscarComNumero =
            By.cssSelector("body > div:nth-child(11) > div > div > div > div > div > div:nth-child(2) > div > div.address-number.address-number--visible > div > form > button");
    private static final By campoPreencherNumero =
            By.cssSelector("body > div:nth-child(11) > div > div > div > div > div > div:nth-child(2) > div > div.address-number.address-number--visible > div > form > div.address-number__input > div > label > input");

    private static final By msgPreencherNumero =
            By.cssSelector("body > div:nth-child(43) > div > div > div > div > div > div:nth-child(2) > div > div.address-number.address-number--visible > div > form > div.address-number__input > div > span");



    @Step("Preencher campo endereço.")
    public String preencherCampoEndereco() {

        String endereco = "rua uberlandia 588";
        sendKeys(campoEnderecoInicio, endereco);

        return endereco;
    }

    @Step("Preencher campo endereço com endereço inválido.")
    public String preencherCampoEnderecoInvalido() {

        String endereco = "rua @@@@@";
        sendKeys(campoEnderecoInicio, endereco);

        return endereco;
    }

    public String buscarCampoMensagemErroEnderecoInvalido() {

        return getText(mensagemErroEnderecoInvalido);
    }

    @Step("Cliclar primeiro item da lista de busca.")
    public void clicarPrimeiroItemDaLista() {

        click(primeiroEnderecoLista);
    }
    @Step("Cliclar no botão salvar localização.")
    public void clicarBotaoConfirmarLocalizacao() {

        click(botaoConfirmarLocalizacao);
    }
    @Step("Cliclar no botão salvar endereço.")
    public void clicarSalvarEndereco() {

        click(botaoSalvarEndereco);
    }
    public String buscarCampoEndereco() {

        return element(campoEnderecoInicio).getAttribute("aria-label");
    }
    @Step("Preencher campo com endereço sem numero.")
    public void preencherEnderecoSemNumero() {

        sendKeys(campoEnderecoInicio, "Rua Rua Uberlandia");
    }

    public String buscarCampoErrorEnderecoSemNumero() {

       return getText(mensagemErroNumeroNaoInformado);
    }

    public String verificarBtnEstaDesabilitado() {

        return element(btnBuscarComNumero).getAttribute("disabled");
    }
    @Step("Preencher campo numero com letras.")
   public void preencherCampoNumeroComLetras() {

        sendKeys(campoPreencherNumero, "AAAA");
   }
}
