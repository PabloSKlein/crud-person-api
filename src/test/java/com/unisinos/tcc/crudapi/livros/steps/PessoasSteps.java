package com.unisinos.tcc.crudapi.livros.steps;

import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.given;

public class PessoasSteps {

    private final String URL = "http://localhost:8080/pessoas";

    private Response response;

    @Quando("Eu pesquisar a pessoa de documento {string}")
    public void euPesquisarAPessoaDeDocumento(String arg0) {
        response = given()
                .param("documento", arg0)
                .when()
                .get(URL);
    }

    @Entao("O status retornado deve ser {int}")
    public void oStatusRetornadoDeveSer(int arg0) {
        response.then()
                .statusCode(arg0);
    }


    @E("O campo {string} deve ser {string}")
    public void oCampoDeveSer(String arg0, String arg1) {
        response.then()
                .body(arg0, Matchers.equalTo(arg1));
    }
}
