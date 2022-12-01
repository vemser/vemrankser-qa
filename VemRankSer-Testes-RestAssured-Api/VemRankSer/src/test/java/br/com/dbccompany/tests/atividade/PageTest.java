package br.com.dbccompany.tests.atividade;

import br.com.dbccompany.client.AtividadeClient;
import br.com.dbccompany.data.changeless.AtividadeData;
import br.com.dbccompany.dto.AtividadeDTO;
import br.com.dbccompany.dto.PageDTO;
import br.com.dbccompany.dto.ResponseDTO;
import br.com.dbccompany.dto.TodosDTO;
import br.com.dbccompany.tests.base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@Epic("Page Tests")
@Feature("Atividade")
@DisplayName("Listar Atividade")
public class PageTest extends BaseTest{

    AtividadeClient atividadeClient = new AtividadeClient();


    @Test
    @Story("Deve listarUsuarios com sucesso")
    public void testeDeveListarTodasAsAtividadesConcluidas() {

        AtividadeDTO[] atividadesConcluidas = atividadeClient.listarStatus(AtividadeData.CONCLUIDA)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().all()
                .extract().as(AtividadeDTO[].class);

        Assert.assertNotNull(atividadesConcluidas);
    }

    @Test
    @Story("Deve listarUsuarios com sucesso")
    public void testeDeveListarTodasAsAtividadesPendentes() {

        AtividadeDTO[] atividadesPendentes = atividadeClient.listarStatus(AtividadeData.PENDENTE)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(AtividadeDTO[].class);

        Assert.assertNotNull(atividadesPendentes);
    }

    @Test
    @Story("Deve listarUsuarios com sucesso")
    public void testeDeveListarTodasAsAtividadesPorPagina() {

        PageDTO atividadePorPagina = atividadeClient.listar("0", "1", AtividadeData.LISTAR_PAGINADO)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(PageDTO.class);

        Assert.assertNotNull(atividadePorPagina);
    }

    @Test
    @Story("Deve listarUsuarios com sucesso")
    public void testeDeveListarTodasAsAtividadesPorNota() {

        PageDTO atividadesPorNota = atividadeClient.listar("0", "1", AtividadeData.LISTAR_NOTA)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(PageDTO.class);

        Assert.assertNotNull(atividadesPorNota);
    }

    @Test
    @Story("Deve listarUsuarios com sucesso")
    public void testeDeveListarTodasAsAtividadesNoMural() {

        PageDTO atividadeNoMural = atividadeClient.listar("0", "1", AtividadeData.LISTAR_MURAL)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(PageDTO.class);

        Assert.assertNotNull(atividadeNoMural);
    }

    @Test
    @Story("Deve retornar mensagem de erro")
    public void testeDeveRetornarMensagemDeErroAoListarAtividadesPorPaginaNegativa() {

        ResponseDTO responseServer = atividadeClient.listar("-1", "1", AtividadeData.LISTAR_PAGINADO)
                .then()
                .statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR)
                .extract().as(ResponseDTO.class);

        Assert.assertEquals("Internal Server Error", responseServer.getError());
    }

    @Test
    @Story("Deve listarUsuarios com sucesso")
    public void testeDeveListarTodasAsAtividadesPorNotaComTamanhoNegativo() {

        ResponseDTO responseServer = atividadeClient.listar("0", "-1", AtividadeData.LISTAR_NOTA)
                .then()
                .statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR)
                .extract().as(ResponseDTO.class);

        Assert.assertEquals("Internal Server Error", responseServer.getError());

    }

    @Test
    @Story("Deve listarUsuarios com sucesso")
    public void testeDeveListarTodasAsAtividadesNoMuralComPaginaETamanhoNegativos() {

        ResponseDTO responseServer = atividadeClient.listar("-1", "-1", AtividadeData.LISTAR_MURAL)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR)
                .extract().as(ResponseDTO.class);

        Assert.assertEquals("Internal Server Error", responseServer.getError());
    }
}
