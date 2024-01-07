package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilaTest {
    @Test
     void  validarEmpety() {
        Fila<Integer> minhaFila = new Fila<>();
        assertTrue(minhaFila.isEmpety());
    }
    @Test
    void validarEnqueue(){
        Fila<Integer> minhaFila = new Fila<>();
        minhaFila.enqueue(1);
        minhaFila.enqueue(4);
        minhaFila.enqueue(6);
        assertEquals(1,minhaFila.first());
    }
}