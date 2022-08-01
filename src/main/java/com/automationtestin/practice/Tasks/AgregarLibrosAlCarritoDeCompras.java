package com.automationtestin.practice.Tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.automationtestin.practice.User_Interface.AutomationtestingHomePage.TXT_NOMBRE_LIBRO;
import static com.automationtestin.practice.User_Interface.AutomationtestingProductoPage.*;

public class AgregarLibrosAlCarritoDeCompras implements Task {


    private String cantidad_Libro;

    public AgregarLibrosAlCarritoDeCompras(String cantidad_Libro) {
        this.cantidad_Libro = cantidad_Libro;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(TXT_NOMBRE_LIBRO),Click.on(TXT_CANTIDAD_LIBROS),
                Enter.theValue(cantidad_Libro).into(TXT_CANTIDAD_LIBROS),Click.on(BTN_ADD_TO_BASKET)
                ,Click.on(BTN_VIEW_BASKET));

    }

    public static AgregarLibrosAlCarritoDeCompras on(String cantidad_Libro){
        return Instrumented.instanceOf(AgregarLibrosAlCarritoDeCompras.class).withProperties(cantidad_Libro);
    }


}
