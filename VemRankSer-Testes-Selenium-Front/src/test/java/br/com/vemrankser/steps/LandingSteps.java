package br.com.vemrankser.steps;

import br.com.vemrankser.pages.HomePage;
import br.com.vemrankser.pages.LandingPage;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;

import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Landing Page")
public class LandingSteps extends BaseSteps{
    LandingPage landingPage = new LandingPage();

    HomePage homePage = new HomePage();

    @Test(description = "Teste com endereço válido.")
    @Description("Descrição Teste: Validar exibir endereço correto após preencher com endereço válido.")
    public void deveInformarEnderecoEscolhidoNavBar () {

        landingPage.preencherCampoEndereco();
        landingPage.clicarPrimeiroItemDaLista();
        landingPage.clicarBotaoConfirmarLocalizacao();
        landingPage.clicarSalvarEndereco();

        Assert.assertEquals("R. Uberlândia,\n" +
                "588", homePage.buscarCampoEndreco());
    }

    @Test(description = "Teste não preenche campo endereço.")
    @Description("Descrição Teste: Validar deve informar ao usuário para preencher endereço.")
    public void deveInformarUsuarioParaBuscarEnderecoCasoCampoEstejaVazio() {

        String campoVazio = landingPage.buscarCampoEndereco();

        Assert.assertEquals("Buscar endereço e número", campoVazio);
    }

    @Test(description = "Teste com endereço inválido.")
    @Description("Descrição Teste: Validar preencher com endereço inválido exibe mensagem de erro.")
    public void deveRetornarMensagemErroAoInformarEnderecoInvalido() {
        landingPage.preencherCampoEnderecoInvalido();
        String mensagemErro = landingPage.buscarCampoMensagemErroEnderecoInvalido();

        Assert.assertEquals("Verifique o nome e número do local e busque novamente", mensagemErro);
    }


    @Test(description = "Teste com endereço sem informar número.")
    @Description("Descrição Teste: Validar preencher com endereço sem o número do endereço exibe mensagem 'Você não informou o número de endereço'.")
    public void devePedirNumeroDoEnderecoCasoNaoSejaInformado() {

        landingPage.preencherEnderecoSemNumero();
        landingPage.clicarPrimeiroItemDaLista();
        String msg = landingPage.buscarCampoErrorEnderecoSemNumero();

        Assert.assertEquals("Você não informou o número de endereço", msg);
    }

    @Test(description = "Teste botão 'salvar endereço' desabilitado.")
    @Description("Descrição Teste: Validar botão 'salvar endereço' desabilitado ao não preencher campo com número de endereço.")
    public void deveDesabilitarBtnSalvarEnderecoCasoNumeroNaoSejaInformado() {

        landingPage.preencherEnderecoSemNumero();
        landingPage.clicarPrimeiroItemDaLista();

        String btnBuscarEnderecoDisabled = landingPage.verificarBtnEstaDesabilitado();

        Assert.assertEquals("true", btnBuscarEnderecoDisabled);
    }

    @Test(description = "Teste preencher número de endereço com valor inválido.")
    @Description("Descrição Teste: Validar preencher com número de endereço inválido mantém botão 'salvar endereço' desabilitado.")
    public void deveManterBtnDesabilitadoCasoSejaDigitadoValorInvalido() {

        landingPage.preencherEnderecoSemNumero();
        landingPage.clicarPrimeiroItemDaLista();
        landingPage.preencherCampoNumeroComLetras();

        String btnBuscarEnderecoDisabled = landingPage.verificarBtnEstaDesabilitado();

        Assert.assertEquals(btnBuscarEnderecoDisabled, "true");
    }
}
