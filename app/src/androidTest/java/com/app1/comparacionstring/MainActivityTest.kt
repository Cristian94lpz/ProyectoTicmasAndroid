package com.app1.comparacionstring

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get: Rule
    var rule : ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @Before

    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    /**
     * comparacion_null()
     * Con las dos casillas de texto vacias damos click en boton comparar
     * El resultado deberia ser : "Completa ambas casillas de texto"
     */
    @Test
    fun comparacion_null(){
        Espresso.onView(
            ViewMatchers.withId(R.id.compara)
        ).perform(
            ViewActions.click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.textResultado)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Completa ambas casillas de texto")
            )
        )

    }

    /**
     * comparacion_iguales()
     * Se completara ambas casillas de texto con el mismo texto
     * El resultado deberia ser: "Las cadenas de texto son iguales"
     */
    @Test
    fun comparacion_iguales(){
        Espresso.onView(
            ViewMatchers.withId(R.id.casilla1)
        ).perform(
            ViewActions.typeText("hola")
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.casilla2)
        ).perform(
            ViewActions.typeText("hola")
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.compara)
        ).perform(
            ViewActions.click()
        )


        Espresso.onView(
            ViewMatchers.withId(R.id.textResultado)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Las cadenas de caracteres son iguales")
            )
        )

    }

    /**
     * comparacion_desigual()
     * Se completara las casillas con distintos textos
     * El resultado deberia ser: "Las cadenas de caracteres son diferentes"
     */
    @Test
    fun comparacion_desigual(){
        Espresso.onView(
            ViewMatchers.withId(R.id.casilla1)
        ).perform(
            ViewActions.typeText("hola")
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.casilla2)
        ).perform(
            ViewActions.typeText("chau")
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.compara)
        ).perform(
            ViewActions.click()
        )


        Espresso.onView(
            ViewMatchers.withId(R.id.textResultado)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Las cadenas de caracteres son diferentes")
            )
        )

    }

}