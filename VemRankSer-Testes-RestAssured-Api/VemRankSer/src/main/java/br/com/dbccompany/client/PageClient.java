package br.com.dbccompany.client;

import br.com.dbccompany.data.changeless.PageData;
import br.com.dbccompany.data.changeless.TrilhaData;
import br.com.dbccompany.data.changeless.UsuarioData;
import br.com.dbccompany.specs.AuthSpecs;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PageClient {

    public Response listarUsuarios(String pagina, String tamanho, String sort) {

        return
                given()
                        .log().all()
                        .spec(AuthSpecs.requestSpecAdmin())
                        .queryParam(PageData.PAGINA, pagina)
                        .queryParam(PageData.TAMANHO, tamanho)
                        .queryParam(PageData.SORT, sort)
                .when()
                        .get(PageData.LISTAR_USUARIOS)
                ;
    }

    public Response listarUsuariosSemAuth(String pagina, String tamanho, String sort, String nome) {

        return
                given()
                        .log().all()
                        .contentType(ContentType.JSON)
                        .queryParam(PageData.PAGINA, pagina)
                        .queryParam(PageData.TAMANHO, tamanho)
                        .queryParam(PageData.SORT, sort)
                        .queryParam(PageData.NOME, nome)
                .when()
                        .get(PageData.LISTAR_USUARIOS)
                ;
    }

    public Response listarUsuarioPorNome(String nome) {

        return
                given()
                        .log().all()
                        .spec(AuthSpecs.requestSpecAdmin())
                        .queryParam(PageData.NOME, nome)
                    .when()
                        .get(PageData.BUSCAR_NOME)
                ;
    }

    public Response listarTrilhaComUsuarios(String pagina, String tamanho, String nome) {

        return
                given()
                        .log().all()
                        .spec(AuthSpecs.requestSpecAdmin())
                        .queryParam(PageData.PAGINA, pagina)
                        .queryParam(PageData.TAMANHO, tamanho)
                        .queryParam(PageData.NOME, nome)
                    .when()
                        .get(TrilhaData.LISTAR_TRILHAS_COM_USUARIOS)
                ;
    }

    public Response listarTrilhaPorNome(String nome) {

        return
                given()
                        .log().all()
                        .spec(AuthSpecs.requestSpecAdmin())
                        .queryParam(PageData.NOME, nome)
                    .when()
                        .get(TrilhaData.LISTAR_TRILHA_POR_NOME)
                ;
    }

    public Response listarTrilhaPorRanking(Integer idTrilha) {

        return
                given()
                        .log().all()
                        .spec(AuthSpecs.requestSpecAdmin())
                        .queryParam(TrilhaData.ID_TRILHA, idTrilha)
                    .when()
                        .get(TrilhaData.LISTAR_RANKING_TRILHA)
                ;
    }

    public Response listarTrilhaPorEdicao(Integer nome) {

        return
                given()
                        .log().all()
                        .spec(AuthSpecs.requestSpecAdmin())
                        .queryParam(TrilhaData.EDICAO, nome)
                    .when()
                        .get(TrilhaData.LISTAR_TRILHA_POR_EDICAO)
                ;
    }

    public Response listarAlunosPorPagina(String pagina, String tamanho) {

        return
                given()
                        .log().all()
                        .spec(AuthSpecs.requestSpecAdmin())
                        .queryParam(PageData.PAGINA, pagina)
                        .queryParam(PageData.TAMANHO, tamanho)
                    .when()
                        .get(PageData.LISTAR_ALUNOS)
                ;
    }

    public Response buscarAlunoPorLogin(String login) {

        return
                given()
                        .log().all()
                        .spec(AuthSpecs.requestSpecAdmin())
                        .queryParam(UsuarioData.LOGIN, login)
                    .when()
                        .get(UsuarioData.BUSCAR_ALUNO)
                ;
    }

    public Response buscarListaDeTrilhaDoAluno(String pagina, String tamanho, String nome) {

        return
                given()
                        .log().all()
                        .spec(AuthSpecs.requestSpecAdmin())
                        .queryParam(PageData.PAGINA, pagina)
                        .queryParam(PageData.TAMANHO, tamanho)
                        .queryParam(PageData.NOME, nome)
                    .when()
                        .get(PageData.LISTAR_ALUNOS_TRILHA)
                ;
    }

    public Response buscarUsuarioPorId(Integer id) {

        return
                given()
                        .log().all()
                        .spec(AuthSpecs.requestSpecAdmin())
                        .queryParam(PageData.ID, id)
                    .when()
                        .get(UsuarioData.BUSCAR_ID_USUARIO)
                ;
    }

    public Response buscarTrilhaPorId(Integer idTrilha) {

        return
                given()
                        .log().all()
                        .spec(AuthSpecs.requestSpecAdmin())
                        .queryParam(TrilhaData.ID_TRILHA, idTrilha)
                    .when()
                        .get(TrilhaData.BUSCAR_ID_TRILHA)
                ;
    }
}
