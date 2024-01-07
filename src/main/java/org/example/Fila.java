package org.example;

public class Fila<T> {

    private No<T> refNoEntradaFila;

    public Fila() {
        this.refNoEntradaFila = null;
    }

    public void enqueue(T obj) {
        No novoNo = new  No (obj);
        // Define a refDenó do novo nó como o atual nó de entrada da fila.
        novoNo.setRefNo(refNoEntradaFila);
        // Atualiza o nó de entrada da fila para ser o novo nó.
        refNoEntradaFila = novoNo;
        /*
         * +---------------------+
         *|       Fila          |
         *+---------------------+
         *| refNoEntradaFila    |
         *+---------------------+
         *         |
         *          V
         *+---------------------+       +---------------------+       +---------------------+
         *|        No           |------>|        No           |------>|        No           |
         *+---------------------+       +---------------------+       +---------------------+
         *| valor               |       | valor               |       | valor               |
         *| refNo---------------|------>| refNo---------------|------>| refNo---------------|---> null
         *+---------------------+       +---------------------+       +---------------------+
         */
    }


    public T first() {
        // Passo 1: Verifica se a fila NÃO está vazia.
        if (!this.isEmpety()) {  // Corrigindo a condição para verificar se NÃO está vazia.

            // Inicializa a variável 'primeiroNo' com a referência para o primeiro nó da fila.
            No primeiroNo = refNoEntradaFila;

            // Loop para percorrer os nós até encontrar o último nó da fila.
            while (true) {
                // Se o próximo nó não for nulo, atualiza 'primeiroNo' para o próximo nó.
                if (primeiroNo.getRefNo() != null) {
                    primeiroNo = primeiroNo.getRefNo();
                } else {
                     break;
                }
            }
            return (T) primeiroNo.getObject();
        }
        return null;  // Por simplicidade, mas este retorno não será alcançado se a fila estiver vazia.
    }

    /**
     * Remove e retorna o nó no início da fila (front) e atualiza a referência para o próximo nó na fila.
     * <p>
     * Lógica:
     * 1. Verifica se a fila NÃO está vazia usando o método isEmpty().
     * 2. Se a fila NÃO estiver vazia, inicializa duas variáveis: 'primeiroNo' e 'noAuxiliar' com a referência para o primeiro nó da fila.
     * 3. Percorre os nós da fila até encontrar o último nó, atualizando as referências necessárias.
     * 4. Remove o nó no início da fila e retorna esse nó.
     *
     * @return nó removido (o antigo primeiro nó da fila).
     * Se a fila estiver vazia, retorna null.
     */
    public T Dequeue() {
        // Passo 1: Verifica se a fila NÃO está vazia.
        if (!this.isEmpety()) {  // Verifica se a fila NÃO está vazia.

            // Inicializa duas variáveis com a referência para o primeiro nó da fila.
            No primeiroNo = refNoEntradaFila;
            No noAuxiliar = refNoEntradaFila;

            // Loop para percorrer os nós até encontrar o último nó da fila.
            while (true) {
                // Se o próximo nó não for nulo, atualiza 'noAuxiliar' e 'primeiroNo' para o próximo nó.
                if (primeiroNo.getRefNo() != null) {
                    noAuxiliar = primeiroNo;  // Atualiza noAuxiliar para o nó atual.
                    primeiroNo = primeiroNo.getRefNo();  // Atualiza primeiroNo para o próximo nó.
                } else {
                    // Se o próximo nó for nulo, significa que 'primeiroNo' agora aponta para o último nó.
                    // Atualiza 'noAuxiliar' para não apontar para o último nó (configurando sua referência como null).
                    noAuxiliar.setRefNo(null);
                    break;  // Sai do loop após ajustar as referências corretamente.
                }
            }
            // Retorna o nó que foi removido (o antigo primeiro nó da fila).
            return (T) primeiroNo.getObject();
        }
        // Se a fila estiver vazia, retorna null.
        return null;
    }

    public boolean isEmpety() {
        return refNoEntradaFila == null? true:false;
    }

    @Override
    public String toString() {
        // Inicializa uma string vazia para armazenar a representação da fila.
        String stringRetorno = "";

        // Inicializa 'noAuxiliar' com a referência para o primeiro nó da fila.
        No noAuxiliar = refNoEntradaFila;

        // Verifica se a fila NÃO está vazia.
        if (refNoEntradaFila != null) {
            // Loop para percorrer os nós e construir a representação em string.
            while (true) {
                // Adiciona a representação do nó atual à string de retorno.
                stringRetorno += "[No{Objeto=" + noAuxiliar.getObject() + "}]+--->";

                // Se o próximo nó não for nulo, atualiza 'noAuxiliar' para o próximo nó.
                if (noAuxiliar.getRefNo() != null) {
                    noAuxiliar = noAuxiliar.getRefNo();
                } else {
                    // Se o próximo nó for nulo, indica o final da fila na representação e sai do loop.
                    stringRetorno += "null";
                    break;
                }
            }
        } else {
            // Se a fila estiver vazia, define a representação como "null".
            stringRetorno = "null";
        }

        // Retorna a representação em string da fila.
        return stringRetorno;
    }
}
