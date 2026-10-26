package br.ulbra.partevisual

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertTrue
import org.junit.Ignore
import org.junit.Test

class TaskTest {

    @Test
    fun tarefaNovaComecaPendente() {
        // preparar + agir
        val tarefa = Task(title = "Estudar")
        // verificar
        assertFalse(tarefa.isCompleted)
    }

    @Test
    fun tarefaGuardaOTituloInformado() {
        val tarefa = Task(title = "Comprar pão")
        assertEquals("Comprar pão", tarefa.title)
    }

    @Test
    fun copyAlteraSoOCampoPedido() {
        val original = Task(id = 1L, title = "Estudar")
        val concluida = original.copy(isCompleted = true)

        assertTrue(concluida.isCompleted)
        assertEquals(original.id, concluida.id)
        assertEquals(original.title, concluida.title)
        assertFalse(original.isCompleted) // o original não muda
    }

    @Test
    fun tarefasComOsMesmosDadosSaoIguais() {
        val a = Task(id = 1L, title = "Estudar")
        val b = Task(id = 1L, title = "Estudar")
        assertEquals(a, b)
    }

    @Test
    fun tarefasComIdsDiferentesNaoSaoIguais() {
        val a = Task(id = 1L, title = "Estudar")
        val b = Task(id = 2L, title = "Estudar")
        assertNotEquals(a, b)
    }

    @Test
    fun tituloVazioEhAceitoPeloModelo() {
        // Caso de borda: o modelo não valida; a validação fica na tela (Toast).
        val tarefa = Task(title = "")
        assertEquals("", tarefa.title)
    }

    @Ignore("BUG conhecido: o id padrão usa System.currentTimeMillis() e pode repetir")
    @Test
    fun tarefasCriadasEmSequenciaTemIdsDiferentes() {
        val a = Task(title = "A")
        val b = Task(title = "B")
        assertNotEquals(a.id, b.id)
    }
}
