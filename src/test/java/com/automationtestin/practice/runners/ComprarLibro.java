package com.automationtestin.practice.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/comprar_libro.feature",
        glue = "com.automationtestin.practice.stepdefinitions",
        snippets = SnippetType.CAMELCASE
)
public class ComprarLibro {
}
