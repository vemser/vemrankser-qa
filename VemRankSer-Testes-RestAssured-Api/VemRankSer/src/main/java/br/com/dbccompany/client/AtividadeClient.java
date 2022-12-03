package br.com.dbccompany.client;

import br.com.dbccompany.data.changeless.*;
import br.com.dbccompany.specs.AuthSpecs;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AtividadeClient {
    public Response cadastrar(Integer idModulo, Integer idTrilha, String cadastroAtividade) {

        return
                given()
                        .log().all()
                        .spec(AuthSpecs.requestSpecAdmin())
                        .queryParam(ModuloData.ID_MODULO, idModulo)
                        .queryParam(TrilhaData.ID_TRILHA, idTrilha)
                        .body(cadastroAtividade)
                    .when()
                        .post(AtividadeData.CADASTRO_ATIVIDADE)
                ;
    }

    public Response avaliarAluno(Integer idAtividade, String pontuacao) {

        return
                given()
                        .log().all()
                        .spec(AuthSpecs.requestSpecAdmin())
                        .body(pontuacao)
                    .when()
                        .put(AtividadeData.AVALIAR_ATIVIDADE_ALUNO + idAtividade)
                ;
    }

    public Response entregarAtividade(Integer idAtividade, String link) {

        return
                given()
                        .log().all()
                        .spec(AuthSpecs.requestSpecAdmin())
                        .body(link)
                    .when()
                        .put(AtividadeData.ENTREGAR_ATIVIDADE + idAtividade)
                ;
    }

    public Response listarPaginado(String pagina, String tamanho) {

        return
                given()
                        .log().all()
                        .spec(AuthSpecs.requestSpecAdmin())
                        .queryParam(PageData.PAGINA, pagina)
                        .queryParam(PageData.TAMANHO, tamanho)
                    .when()
                        .get(AtividadeData.LISTAR_PAGINADO)
                ;
    }

    public Response listarAtividadeStatus(String pagina, String tamanho, Integer idTrilha, String atividadeStatus) {
        return
            given()
                    .log().all()
                    .spec(AuthSpecs.requestSpecAdmin())
                    .queryParam(PageData.PAGINA, pagina)
                    .queryParam(PageData.TAMANHO, tamanho)
                    .queryParam(TrilhaData.ID_TRILHA, idTrilha)
                    .queryParam(AtividadeData.ATIVIDADE_STATUS, atividadeStatus)
                .when()
                    .get(AtividadeData.LISTAR_STATUS)
            ;
    }

    public Response listarAtividadePorTrilhaModulo(String pagina, String tamanho, Integer idTrilha, Integer idModulo, String atividadeStatus) {
        return
                given()
                        .log().all()
                        .spec(AuthSpecs.requestSpecAdmin())
                        .queryParam(PageData.PAGINA, pagina)
                        .queryParam(PageData.TAMANHO, tamanho)
                        .queryParam(TrilhaData.ID_TRILHA, idTrilha)
                        .queryParam(ModuloData.ID_MODULO, idModulo)
                        .queryParam(AtividadeData.ATIVIDADE_STATUS, atividadeStatus)
                    .when()
                        .get(AtividadeData.LISTAR_ATIVIDADE_POR_TRILHA_MODULO)
                ;
    }

    public Response listarMuralInstrutor(String pagina, String tamanho, Integer idTrilha) {
        return
                given()
                        .log().all()
                        .spec(AuthSpecs.requestSpecAdmin())
                        .queryParam(PageData.PAGINA, pagina)
                        .queryParam(PageData.TAMANHO, tamanho)
                        .queryParam(TrilhaData.ID_TRILHA, idTrilha)
                    .when()
                        .get(AtividadeData.LISTAR_MURAL_INSTRUTOR)
                ;
    }

    public Response listarMuralAluno(String pagina, String tamanho, String atividadeStatus, Integer idUsuario) {
        return
                given()
                        .log().all()
                        .spec(AuthSpecs.requestSpecAdmin())
                        .queryParam(PageData.PAGINA, pagina)
                        .queryParam(PageData.TAMANHO, tamanho)
                        .queryParam(AtividadeData.ATIVIDADE_STATUS, atividadeStatus)
                        .queryParam(UsuarioData.ID_USUARIO, idUsuario)
                    .when()
                        .get(AtividadeData.LISTAR_MURAL_ALUNO)
                ;
    }

    public Response buscarAtividadePorId(Integer idAtividade) {
        return
                given()
                        .log().all()
                        .spec(AuthSpecs.requestSpecAdmin())
                        .queryParam(AtividadeData.ID_ATIVIDADE, idAtividade)
                    .when()
                        .get(AtividadeData.BUSCAR_ATIVIDADE_POR_ID)
                ;
    }
}
