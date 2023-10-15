# Atividade de Estruturas de Dados 1
## Listas duplamente encadeadas

### 1 – Implemente uma classe LDEInteirosSemRepetidoscomos métodos abaixo:
(a) Um método (procedimento) para inserir um valor no final da lista. Este método deverá receber como parâmetro o valor a ser inserido. Este método não deverá inserir na lista valores repetidos.
(b) Um método (procedimento) para inserir um valor no inícioda lista. Este método deverá receber como parâmetro o valor a ser inserido. Este método não deverá inserir na lista valores repetidos. 

(c) Um método (procedimento) para remover o valor situado no início da lista.

(d) Um método (procedimento) para remover o valor situado no final da lista.

(e) Um método (procedimento) para exibir todos os valoresda lista.

(f) Um método (procedimento) para remover o valor específico da lista. Este método recebe como parâmetro o valor a ser removido, procura pelo valor na lista e, caso encontre, remove. 

(g) Um método (função) que procura um valor na lista. Este método recebe como parâmetro o valor a ser procurado. Se encontrar, retorna uma referência para o nó que contém o valor. Se não encontrar, retorna null.

### 2 – Já implementamos, nesta disciplina, a classe Queue utilizando um vetor para armazenar os dados da fila. Agora, implemente a classe Queue novamente, desta vez, utilizando uma lista duplamente encadeada(LDE) com nó descritor para armazenar os dados. Para esta questão, implemente uma fila de números inteiros. A fila deverá ser implementada com um comportamento PADRÃO de fila.
LEMBRETES: O conjunto de operações que definem uma fila PADRÃO é:

* **enQueue**: Enfileirar, ou seja, colocar um elemento no final da fila. Procedimento que recebe como parâmetro o elemento a ser enfileirado.
* **deQueue**: Desenfileirar, ou seja, retirar um elemento início da fila. Função que não recebe parâmetro, retira e retorna o elemento que se encontra no início da fila.
* **head**: Informar que elemento se encontra no início da fila. Função que não recebe parâmetro e retorna o elemento que se encontra no início da fila.
* **isEmpty**: Verificar se a fila está vazia. Função que não recebe parâmetro e retorna um booleano: true, se a filaestiver vazia e false, caso contrário.
* **isFull**: Verificar se a fila está cheia. Função que não recebe parâmetro e retorna um booleano: true, se a fila estiver cheia e false, caso contrário. Como, nesta implementação, a fila nunca ficará cheia, neste caso, especificamente, a função sempre retornará false. 

OBS: O teste de fila vazia não é feito dentro do método deQueue nem do head.