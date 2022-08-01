package com.automationtestin.practice.stepdefinitions;

import com.automationtestin.practice.Tasks.AgregarLibrosAlCarritoDeCompras;
import com.automationtestin.practice.Tasks.VercarritodeCompra;
import com.automationtestin.practice.Utils.DriverControler;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import java.io.IOException;
import java.util.Map;

import static com.automationtestin.practice.User_Interface.AutomationtestingCheckoutPage.TXT_PRECIO_TOTAL;

public class ComprarLibroStepdefinitions {

    @Before
    public void before() throws IOException {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^que me encuentro en la pagina de compras de practice\\.automationtesting$")
    public void queMeEncuentroEnLaPaginaDeComprasDePracticeAutomationtesting() {
        OnStage.theActorCalled("kevin").can(BrowseTheWeb.with(DriverControler.chromeHisBrowserWeb().on("https://practice.automationtesting.in/shop/")));

    }


    @Cuando("^compro (\\d+) unidades del libro Android Quick Start Guide$")
    public void comproUnidadesDelLibroAndroidQuickStartGuide(String cantidad, Map<String, String> data) {
        OnStage.theActorInTheSpotlight().attemptsTo(AgregarLibrosAlCarritoDeCompras.on(cantidad),
                VercarritodeCompra.in(data));



    }

    @Entonces("^verifico que el  sea el correcto (.*)$")
    public void verificoQueElSeaElCorrecto(String precioFinal) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion.the(TXT_PRECIO_TOTAL), WebElementStateMatchers.containsText(precioFinal)));

    }
}
