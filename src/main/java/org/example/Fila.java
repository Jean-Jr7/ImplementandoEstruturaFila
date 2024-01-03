package org.example;

public class Fila {

    private No refNoEntradaFila;

    public Fila() {
        this.refNoEntradaFila = null;
    }

    public void enqueue(No novoNo){
        // Define o próximo nó do novo nó como o atual nó de entrada da fila.
        novoNo.setRefNo(refNoEntradaFila);
        // Atualiza o nó de entrada da fila para ser o novo nó.
        refNoEntradaFila = novoNo;
    }
    public boolean isEmpety() {
        return refNoEntradaFila == null;
    }
}
