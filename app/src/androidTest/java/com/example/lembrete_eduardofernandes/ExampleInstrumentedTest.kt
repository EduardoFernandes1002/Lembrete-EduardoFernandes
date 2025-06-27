package com.example.lembrete_eduardofernandes

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withHint


import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.lembrete_eduardofernandes", appContext.packageName)

        val activityScenario: ActivityScenario<MainActivity> =
            ActivityScenario.launch(MainActivity::class.java)

        activityScenario.moveToState(Lifecycle.State.RESUMED)


        /**
         *
         *  Na Fragment area janela de Login
         *
         */


        onView(withId(R.id.textViewLogin)).check(matches(isDisplayed()))
        onView(withId(R.id.textViewLogin)).check(matches(withText("Login")))

        onView(withId(R.id.textViewEmail)).check(matches(isDisplayed()))
        onView(withId(R.id.textViewEmail)).check(matches(withText("Email:")))

        onView(withId(R.id.editTxtEmail)).check(matches(isDisplayed()))
        onView(withId(R.id.editTxtEmail)).check(matches(withHint("Email")))

        onView(withId(R.id.textViewSenha)).check(matches(isDisplayed()))
        onView(withId(R.id.textViewSenha)).check(matches(withText("Senha:")))

        onView(withId(R.id.editTxtPassword)).check(matches(isDisplayed()))
        onView(withId(R.id.editTxtPassword)).check(matches(withHint("Senha")))

        onView(withId(R.id.btnLogin)).check(matches(isDisplayed()))
        onView(withId(R.id.btnLogin)).check(matches(withText("Entrar")))

        onView(withId(R.id.btnCadastro)).check(matches(isDisplayed()))
        onView(withId(R.id.btnCadastro)).check(matches(withText("Cadastre-se")))
        onView(withId(R.id.btnCadastro)).perform(click())

        /**
         *
         *  Na Fragment de Cadastro do usuario
         *
         */

        onView(withId(R.id.textViewCadastro)).check(matches(isDisplayed()))
        onView(withId(R.id.textViewCadastro)).check(matches(withText("Cadastro")))

        onView(withId(R.id.textViewNomeCadastro)).check(matches(isDisplayed()))
        onView(withId(R.id.textViewNomeCadastro)).check(matches(withText("Nome:")))

        onView(withId(R.id.editTxtNomeCadastro)).check(matches(isDisplayed()))
        onView(withId(R.id.editTxtNomeCadastro)).check(matches(withHint("Digite seu Nome")))

        onView(withId(R.id.textViewEmailCadastro)).check(matches(isDisplayed()))
        onView(withId(R.id.textViewEmailCadastro)).check(matches(withText("Email:")))

        onView(withId(R.id.editTxtEmailCadastro)).check(matches(isDisplayed()))
        onView(withId(R.id.editTxtEmailCadastro)).check(matches(withHint("Digite seu Email")))

        onView(withId(R.id.textViewSenhaCadastro)).check(matches(isDisplayed()))
        onView(withId(R.id.textViewSenhaCadastro)).check(matches(withText("Senha:")))

        onView(withId(R.id.editTextPasswordCadastro)).check(matches(isDisplayed()))
        onView(withId(R.id.editTextPasswordCadastro)).check(matches(withHint("Digite sua Senha")))

        onView(withId(R.id.btnVoltarLogin)).check(matches(isDisplayed()))
        onView(withId(R.id.btnVoltarLogin)).check(matches(withText("Voltar")))

        onView(withId(R.id.btnCadastrar)).check(matches(isDisplayed()))
        onView(withId(R.id.btnCadastrar)).check(matches(withText("Cadastrar")))

        // typeTexts nos inputs

        onView(withId(R.id.editTxtNomeCadastro)).perform(typeText("Thiago"), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.editTxtNomeCadastro)).check(matches(isDisplayed()))
        onView(withId(R.id.editTxtNomeCadastro)).check(matches(withText("Thiago")))

        onView(withId(R.id.editTxtEmailCadastro)).perform(typeText("Thiago@teste.com"), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.editTxtEmailCadastro)).check(matches(isDisplayed()))
        onView(withId(R.id.editTxtEmailCadastro)).check(matches(withText("Thiago@teste.com")))

        onView(withId(R.id.editTextPasswordCadastro)).perform(typeText("Dias123"), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.editTextPasswordCadastro)).check(matches(isDisplayed()))
        onView(withId(R.id.editTextPasswordCadastro)).check(matches(withText("Dias123")))

        onView(withId(R.id.btnCadastrar)).perform(click())

        /**
         *
         *  Fragment Login novamente!
         *
         */

        Thread.sleep(4000)

        onView(withId(R.id.textViewLogin)).check(matches(isDisplayed()))
        onView(withId(R.id.textViewLogin)).check(matches(withText("Login")))

        onView(withId(R.id.textViewEmail)).check(matches(isDisplayed()))
        onView(withId(R.id.textViewEmail)).check(matches(withText("Email:")))

        onView(withId(R.id.editTxtEmail)).check(matches(isDisplayed()))
        onView(withId(R.id.editTxtEmail)).check(matches(withHint("Email")))

        onView(withId(R.id.textViewSenha)).check(matches(isDisplayed()))
        onView(withId(R.id.textViewSenha)).check(matches(withText("Senha:")))

        onView(withId(R.id.editTxtPassword)).check(matches(isDisplayed()))
        onView(withId(R.id.editTxtPassword)).check(matches(withHint("Senha")))

        onView(withId(R.id.btnLogin)).check(matches(isDisplayed()))
        onView(withId(R.id.btnLogin)).check(matches(withText("Entrar")))

        onView(withId(R.id.btnCadastro)).check(matches(isDisplayed()))
        onView(withId(R.id.btnCadastro)).check(matches(withText("Cadastre-se")))

        // Inputs e Login

        onView(withId(R.id.editTxtEmail)).perform(typeText("Thiago@teste.com"), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.editTxtEmail)).check(matches(isDisplayed()))
        onView(withId(R.id.editTxtEmail)).check(matches(withText("Thiago@teste.com")))

        onView(withId(R.id.editTxtPassword)).perform(typeText("Dias123"), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.editTxtPassword)).check(matches(isDisplayed()))
        onView(withId(R.id.editTxtPassword)).check(matches(withText("Dias123")))

        onView(withId(R.id.btnLogin)).perform(click())


        /**
         *
         *  Na Fragment de Lembrete
         *
         */

        Thread.sleep(4000)


        onView(withId(R.id.btnVoltar)).check(matches(isDisplayed()))
        onView(withId(R.id.btnVoltar)).check(matches(withText("Voltar")))

        onView(withId(R.id.textViewBemVindo)).check(matches(isDisplayed()))
        onView(withId(R.id.textViewBemVindo)).check(matches(withText("Bem Vindo")))

        onView(withId(R.id.textInputEditText)).check(matches((isDisplayed())))
        onView(withId(R.id.textInputEditText)).check(matches((withHint("Digite um lembrete!"))))

        onView(withId(R.id.btnDeletar)).check(matches(isDisplayed()))
        onView(withId(R.id.btnDeletar)).check(matches(withText("Deletar")))

        onView(withId(R.id.btnSalvar)).check(matches(isDisplayed()))
        onView(withId(R.id.btnSalvar)).check(matches(withText("Salvar")))

        // Escrevendo e salvando lembrete

        onView(withId(R.id.textInputEditText)).perform(typeText("TesteLembrete"), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.textInputEditText)).check(matches((isDisplayed())))
        onView(withId(R.id.textInputEditText)).check(matches((withText("TesteLembrete"))))

        onView(withId(R.id.btnSalvar)).perform(click())

        onView(withId(R.id.textInputEditText)).check(matches((isDisplayed())))
        onView(withId(R.id.textInputEditText)).check(matches((withText("TesteLembrete"))))


        onView(withId(R.id.btnVoltar)).perform(click())

        /**
         *
         *  Volta ao login e relogando para verificar
         *  se em lembrete exibe o lembrete!
         *
         */

        //reLogin

        Thread.sleep(4000)

        onView(withId(R.id.textViewLogin)).check(matches(isDisplayed()))
        onView(withId(R.id.textViewLogin)).check(matches(withText("Login")))

        onView(withId(R.id.textViewEmail)).check(matches(isDisplayed()))
        onView(withId(R.id.textViewEmail)).check(matches(withText("Email:")))

        onView(withId(R.id.editTxtEmail)).check(matches(isDisplayed()))
        onView(withId(R.id.editTxtEmail)).check(matches(withHint("Email")))

        onView(withId(R.id.textViewSenha)).check(matches(isDisplayed()))
        onView(withId(R.id.textViewSenha)).check(matches(withText("Senha:")))

        onView(withId(R.id.editTxtPassword)).check(matches(isDisplayed()))
        onView(withId(R.id.editTxtPassword)).check(matches(withHint("Senha")))

        onView(withId(R.id.btnLogin)).check(matches(isDisplayed()))
        onView(withId(R.id.btnLogin)).check(matches(withText("Entrar")))

        onView(withId(R.id.btnCadastro)).check(matches(isDisplayed()))
        onView(withId(R.id.btnCadastro)).check(matches(withText("Cadastre-se")))

        // Inputs e Login

        onView(withId(R.id.editTxtEmail)).perform(typeText("Thiago@teste.com"), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.editTxtEmail)).check(matches(isDisplayed()))
        onView(withId(R.id.editTxtEmail)).check(matches(withText("Thiago@teste.com")))

        onView(withId(R.id.editTxtPassword)).perform(typeText("Dias123"), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.editTxtPassword)).check(matches(isDisplayed()))
        onView(withId(R.id.editTxtPassword)).check(matches(withText("Dias123")))

        onView(withId(R.id.btnLogin)).perform(click())

        // lembrete de novo:

        Thread.sleep(4000)

        onView(withId(R.id.btnVoltar)).check(matches(isDisplayed()))
        onView(withId(R.id.btnVoltar)).check(matches(withText("Voltar")))

        onView(withId(R.id.textViewBemVindo)).check(matches(isDisplayed()))
        onView(withId(R.id.textViewBemVindo)).check(matches(withText("Bem Vindo")))

        onView(withId(R.id.textInputEditText)).check(matches((isDisplayed())))
        onView(withId(R.id.textInputEditText)).check(matches((withText("TesteLembrete"))))

        onView(withId(R.id.btnDeletar)).check(matches(isDisplayed()))
        onView(withId(R.id.btnDeletar)).check(matches(withText("Deletar")))

        onView(withId(R.id.btnSalvar)).check(matches(isDisplayed()))
        onView(withId(R.id.btnSalvar)).check(matches(withText("Salvar")))

        onView(withId(R.id.btnDeletar)).perform(click())

        onView(withId(R.id.textInputEditText)).check(matches((isDisplayed())))
        onView(withId(R.id.textInputEditText)).check(matches((withText(""))))

        onView(withId(R.id.btnVoltar)).perform(click())

        Thread.sleep(4000)

        // Ultima verificação login por que sim!

        onView(withId(R.id.textViewLogin)).check(matches(isDisplayed()))
        onView(withId(R.id.textViewLogin)).check(matches(withText("Login")))

        onView(withId(R.id.textViewEmail)).check(matches(isDisplayed()))
        onView(withId(R.id.textViewEmail)).check(matches(withText("Email:")))

        onView(withId(R.id.editTxtEmail)).check(matches(isDisplayed()))
        onView(withId(R.id.editTxtEmail)).check(matches(withHint("Email")))

        onView(withId(R.id.textViewSenha)).check(matches(isDisplayed()))
        onView(withId(R.id.textViewSenha)).check(matches(withText("Senha:")))

        onView(withId(R.id.editTxtPassword)).check(matches(isDisplayed()))
        onView(withId(R.id.editTxtPassword)).check(matches(withHint("Senha")))

        onView(withId(R.id.btnLogin)).check(matches(isDisplayed()))
        onView(withId(R.id.btnLogin)).check(matches(withText("Entrar")))

        onView(withId(R.id.btnCadastro)).check(matches(isDisplayed()))
        onView(withId(R.id.btnCadastro)).check(matches(withText("Cadastre-se")))



    }
}