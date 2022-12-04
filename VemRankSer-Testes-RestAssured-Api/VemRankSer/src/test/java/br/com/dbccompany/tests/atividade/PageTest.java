package br.com.dbccompany.tests.atividade;

import br.com.dbccompany.client.AtividadeClient;
import br.com.dbccompany.client.ModuloClient;
import br.com.dbccompany.client.TrilhaClient;
import br.com.dbccompany.data.changeless.AtividadeData;
import br.com.dbccompany.data.factory.AtividadeDataFactory;
import br.com.dbccompany.data.factory.ModuloDataFactory;
import br.com.dbccompany.data.factory.TrilhaDataFactory;
import br.com.dbccompany.dto.*;
import br.com.dbccompany.model.Atividade;
import br.com.dbccompany.model.Modulo;
import br.com.dbccompany.model.Trilha;
import br.com.dbccompany.tests.base.BaseTest;

import br.com.dbccompany.utils.Utils;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import org.apache.http.HttpStatus;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@Epic("Page Tests")
@Feature("Atividade")
@DisplayName("Listar Atividade")
public class PageTest extends BaseTest{

    AtividadeClient atividadeClient = new AtividadeClient();

    TrilhaClient trilhaClient = new TrilhaClient();

    ModuloClient moduloClient = new ModuloClient();

    @Test
    @Story("Deve listar com sucesso")
    public void testeDeveRetornarListaDeAtividadeNaTrilhaStatusPendente() {

        Modulo novoModulo = ModuloDataFactory.novoModulo();
        ModuloDTO moduloCadastrato = moduloClient.cadastrar(Utils.convertModuloToJson(novoModulo))
                .then()
                .extract().as(ModuloDTO.class);

        Trilha novatrilha =  TrilhaDataFactory.novaTrilha();
        TrilhaDTO trilhaCadastrada = trilhaClient.cadastrar(Utils.convertTrilhaToJson(novatrilha))
                .then()
                .extract().as(TrilhaDTO.class)
                ;

        Atividade novaAtividade = AtividadeDataFactory.novaAtividade(
                moduloCadastrato.getIdModulo(), trilhaCadastrada);

        AtividadeDTO cadastroAtividade = atividadeClient.cadastrar(moduloCadastrato.getIdModulo(),
                        trilhaCadastrada.getIdTrilha(), Utils.converterAtividadeToJson(novaAtividade))
                .then()
                .extract().as(AtividadeDTO.class);

        PageDTO atividadeStatusConcluidos = atividadeClient
                .listarAtividadeStatus("0", "1", trilhaCadastrada.getIdTrilha(), AtividadeData.PENDENTE)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(PageDTO.class);

        TodosDTO atividadeBuscada = atividadeStatusConcluidos.getElementos().get(0);

        Assertions.assertEquals(atividadeBuscada.getIdAtividade(), cadastroAtividade.getIdAtividade());
        Assertions.assertEquals(atividadeBuscada.getNomeInstrutor(), cadastroAtividade.getNomeInstrutor());
        Assertions.assertEquals(atividadeBuscada.getTitulo(), cadastroAtividade.getTitulo());
        Assertions.assertEquals(atividadeBuscada.getPesoAtividade(), cadastroAtividade.getPesoAtividade());
    }

//    @Test
//    @Story("Deve listar com sucesso")
//    public void testeDeveRetornarListaDeAtividadeNaTrilhaStatusSucesso() {
//
//        Modulo novoModulo = ModuloDataFactory.novoModulo();
//        ModuloDTO moduloCadastrato = moduloClient.cadastrar(Utils.convertModuloToJson(novoModulo))
//                .then()
//                .extract().as(ModuloDTO.class);
//
//        Trilha novatrilha =  TrilhaDataFactory.novaTrilha();
//        TrilhaDTO trilhaCadastrada = trilhaClient.cadastrar(Utils.convertTrilhaToJson(novatrilha))
//                .then()
//                .extract().as(TrilhaDTO.class)
//                ;
//
//        Atividade novaAtividade = AtividadeDataFactory.novaAtividade(
//                moduloCadastrato.getIdModulo(), trilhaCadastrada);
//
//        AtividadeDTO cadastroAtividade = atividadeClient.cadastrar(moduloCadastrato.getIdModulo(),
//                        trilhaCadastrada.getIdTrilha(), Utils.converterAtividadeToJson(novaAtividade))
//                .then()
//                .extract().as(AtividadeDTO.class);
//
//        PageDTO atividadeStatusConcluidos = atividadeClient
//                .listarAtividadeStatus("0", "1", trilhaCadastrada.getIdTrilha(), AtividadeData.CONCLUIDA)
//                .then()
//                .log().all()
//                .statusCode(HttpStatus.SC_OK)
//                .extract().as(PageDTO.class);
//
//        TodosDTO atividadeBuscada = atividadeStatusConcluidos.getElementos().get(0);
//
//        Assertions.assertEquals(atividadeBuscada.getIdAtividade(), cadastroAtividade.getIdAtividade());
//        Assertions.assertEquals(atividadeBuscada.getNomeInstrutor(), cadastroAtividade.getIdAtividade());
//        Assertions.assertEquals(atividadeBuscada.getTitulo(), cadastroAtividade.getIdAtividade());
//        Assertions.assertEquals(atividadeBuscada.getPesoAtividade(), cadastroAtividade.getIdAtividade());
//        Assertions.assertEquals(atividadeBuscada.getNome(), cadastroAtividade.getIdAtividade());
//        Assertions.assertEquals(atividadeBuscada.getEdicao(), cadastroAtividade.getIdAtividade());
//    }

    @Test
    @Story("Deve listar com sucesso")
    public void testeDeveListarTodasAsAtividadesPorPagina() {

        PageDTO atividadePorPagina = atividadeClient.listarPaginado("0", "1")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(PageDTO.class);

        Assert.assertNotNull(atividadePorPagina);
    }

    @Test
    @Story("Deve retornar mensagem de erro")
    public void testeDeveRetornarMensagemDeErroAoListarAtividadesPorPaginaNegativa() {

        ResponseDTO responseServer = atividadeClient.listarPaginado("-1", "1")
                .then()
                .statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR)
                .extract().as(ResponseDTO.class);

        Assert.assertEquals("Internal Server Error", responseServer.getError());
    }

    @Test
    @Story("Deve listar com sucesso")
    public void testeDeveBuscarAtividadePorId() {

        Modulo novoModulo = ModuloDataFactory.novoModulo();
        ModuloDTO moduloCadastrato = moduloClient.cadastrar(Utils.convertModuloToJson(novoModulo))
                .then()
                .extract().as(ModuloDTO.class);

        Trilha novatrilha =  TrilhaDataFactory.novaTrilha();
        TrilhaDTO trilhaCadastrada = trilhaClient.cadastrar(Utils.convertTrilhaToJson(novatrilha))
                .then()
                .extract().as(TrilhaDTO.class)
                ;

        Atividade novaAtividade = AtividadeDataFactory.novaAtividade(
                moduloCadastrato.getIdModulo(), trilhaCadastrada);

        AtividadeDTO cadastroAtividade = atividadeClient.cadastrar(moduloCadastrato.getIdModulo(),
                        trilhaCadastrada.getIdTrilha(), Utils.converterAtividadeToJson(novaAtividade))
                .then()
                .extract().as(AtividadeDTO.class);

        AtividadeDTO atividadeBuscada = atividadeClient.buscarAtividadePorId(cadastroAtividade.getIdAtividade())
                .then()
                .extract().as(AtividadeDTO.class);

        Assertions.assertEquals(cadastroAtividade.getIdAtividade(), atividadeBuscada.getIdAtividade());
        Assertions.assertEquals(cadastroAtividade.getNomeInstrutor(), atividadeBuscada.getNomeInstrutor());
        Assertions.assertEquals(cadastroAtividade.getTitulo(), atividadeBuscada.getTitulo());
        Assertions.assertEquals(cadastroAtividade.getPesoAtividade(), atividadeBuscada.getPesoAtividade());
        Assertions.assertTrue(cadastroAtividade.getDataCriacao().contains(atividadeBuscada.getDataCriacao().substring(0, 11)));
        Assertions.assertTrue(cadastroAtividade.getDataEntrega().contains(atividadeBuscada.getDataEntrega().substring(0, 11)));
    }

    @Test
    @Story("Deve retornar mensagem de erro")
    public void testeDeveRetornarErroAoBuscarAtividadePorIdNegativo() {

        ResponseDTO atividadeBuscada = atividadeClient.buscarAtividadePorId(Utils.faker.number().negative())
                .then()
                .extract().as(ResponseDTO.class);

        Assertions.assertEquals(atividadeBuscada.getStatus(), HttpStatus.SC_BAD_REQUEST);
        Assertions.assertEquals(atividadeBuscada.getMessage(), "Atividade não encontrada.");
    }


}
