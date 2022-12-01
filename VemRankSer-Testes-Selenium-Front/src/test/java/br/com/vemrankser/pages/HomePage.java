package br.com.vemrankser.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HomePage extends BasePage {

    LandingPage landingPage = new LandingPage();

    private static final By campoEndereco =
            By.cssSelector("#__next > div:nth-child(1) > header > button");

    private static final By btnVerMais =
            By.cssSelector("#__next > div:nth-child(1) > main > div > div.content-container.cardstack-home > section > article:nth-child(3) > section:nth-child(2) > div > button");

    private static final By bigBannerImage =
            By.cssSelector("#__next > div:nth-child(1) > main > div > div.content-container.cardstack-home > section > article:nth-child(1) > section:nth-child(2) > ul > div > div.swiper-wrapper > div.swiper-slide.swiper-slide-active > li > a > span > img");

    private static final By btnRightArrow =
            By.cssSelector("#__next > div:nth-child(1) > main > div > div.content-container.cardstack-home > section > article:nth-child(1) > section:nth-child(2) > ul > div > div.swiper-button-next");

    private static final By btnLeftArrow =
            By.cssSelector("#__next > div:nth-child(1) > main > div > div.content-container.cardstack-home > section > article:nth-child(1) > section:nth-child(2) > ul > div > div.swiper-button-prev");
    private static final By boxFitImageBanner =
            By.cssSelector("#__next > div:nth-child(1) > main > div > div.content-container.cardstack-home > section > article:nth-child(1) > section:nth-child(2) > ul > div > div.swiper-wrapper > div.swiper-slide.swiper-slide-active > li");

    private static final By quartoImageBanner =
            By.cssSelector("#__next > div:nth-child(1) > main > div > div.content-container.cardstack-home > section > article:nth-child(1) > section:nth-child(2) > ul > div > div.swiper-wrapper > div.swiper-slide.swiper-slide-active");

    private static final By listaDeProdutos =
            By.cssSelector("#__next > div:nth-child(1) > main > div > div.content-container.cardstack-home > section > article:nth-child(3) > section:nth-child(1) > div > div.merchant-list-v2__wrapper");

            private static final By cardLojaHome =
            By.cssSelector("#__next > div:nth-child(1) > main > div > div.content-container.cardstack-home > section > article:nth-child(3) > section:nth-child(1) > div > div.merchant-list-v2__wrapper > div:nth-child(2) > a > div > div.merchant-v2__figure-container");
            
            private static final By tituloLoja =
            By.cssSelector("#__next > div:nth-child(1) > main > div.restaurant-container > div > header.merchant-info > div.merchant-info__content-container > div > div.merchant-info__title-container > h1");
            
    @Step("Acesso página Home.")
    public void entrarPaginaHome() {

        landingPage.preencherCampoEndereco();
        landingPage.clicarPrimeiroItemDaLista();
        landingPage.clicarBotaoConfirmarLocalizacao();
        landingPage.clicarSalvarEndereco();
    }

    public String buscarCampoEndreco() {

        return getText(campoEndereco);
    }
    @Step("Cliclar no botão 'Ver mais'.")
    public void clicarBtnVerMais() {

        click(btnVerMais);
    }

    public int verificarListaLojasOuItens() {

        WebElement elemento = element(listaDeProdutos);

        List<WebElement> childelements = elemento.findElements(By.className("merchant-list-v2__item-wrapper"));

        return  childelements.size();
    }

    public String retonarEstadoBotaoEsquerdo() {

        return element(btnLeftArrow).getAttribute("class");
    }

    public String retonarEstadoBotaoDireito() {

        return element(btnRightArrow).getAttribute("class");
    }

    public void clicarCincoVezesBotaoDireito() {

        Actions action = new Actions(driver);
        action.doubleClick(element(btnRightArrow)).doubleClick().click().perform();
    }

    public void hoverBigBannerImage() {

        Actions action = new Actions(driver);

        action.moveToElement(element(bigBannerImage)).perform();
    }

    public String pegarTamanhoBannerImage() {

        WebElement image = element(boxFitImageBanner);

        return image.getCssValue("transform");
    }

    public void mudarParaQuartoElementoCarrosselBanner() {

        Actions action = new Actions(driver);

        action.doubleClick(element(btnRightArrow)).doubleClick().perform();
    }

    public String verificarClasseQuartoBanner() {

        return element(quartoImageBanner).getAttribute("class");
    }

    public void clicarCardLoja() {

        click(cardLojaHome);
    }

    public String buscarCampoTituloLoja() {

        return getText(tituloLoja);
    }
}
