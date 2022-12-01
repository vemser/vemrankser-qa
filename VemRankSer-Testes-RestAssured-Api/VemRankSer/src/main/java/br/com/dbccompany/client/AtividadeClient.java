package br.com.dbccompany.client;

import br.com.dbccompany.data.changeless.AtividadeData;
import br.com.dbccompany.data.changeless.UsuarioData;
import br.com.dbccompany.specs.AuthSpecs;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AtividadeClient {
    public Response cadastrar(Integer idUsusario, String usuarioAtualizado) {

        return
                given()
                        .log().all()
                        .spec(AuthSpecs.requestSpecAdmin())
                        .pathParam("idUsuario", idUsusario)
                        .body(usuarioAtualizado)
                    .when()
                        .put(UsuarioData.ATUALIZAR_USUARIO+"{idUsuario}")
                ;
    }

    public Response listar(String pagina, String tamanho, String url) {
        return
                given()
                        .log().all()
                        .spec(AuthSpecs.requestSpecAdmin())
                        .queryParam("pagina", pagina)
                        .queryParam("tamanho", tamanho)
                    .when()
                        .get(url)
                ;
    }

    public Response listarStatus(String atividadeStatus) {
        return
            given()
                    .log().all()
                    .spec(AuthSpecs.requestSpecAdmin())
                    .queryParam("atividadeStatus", atividadeStatus)
                .when()
                    .get(AtividadeData.LISTAR_STATUS)
            ;
    }
}
