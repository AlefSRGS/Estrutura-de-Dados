## Atividade 4 de Listas duplamente encadeadas Estruturas de Dados I 

### 1ª Questão: Considere uma lista duplamente encadeada, ordenada em ordem crescente e que pode conter valores repetidos. Implemente o método de inserção para esta lista. Lembre-se que esta lista permite valores repetidos. A inserção de um valor repetido na lista deverá acontecer sempre antes dos valores iguais ao que está sendo inserido.

5	8	13		21	21	21	25	28	37

 Ponto de inserção de um novo 21

### 2ª Questão: Imagine a seguinte situação: um funcionário de uma empresa organiza a lista de suas tarefas por _ordem decrescente_ de prioridade. Sempre que ele vai escolher uma nova tarefa para executar, ele pega a primeira tarefa da lista, ou seja, a de prioridade mais alta. Quando enviam a ele uma nova tarefa, ele a insere na lista, de acordo com a prioridade da mesma. Observe que é possível ter várias tarefas com a mesma prioridade. Neste caso, o critério utilizado para ordenação de tarefas de mesma prioridade é a ordem de chegada das tarefas. Ou seja, quando chega uma tarefa de prioridade já existente, ela é inserida após as tarefas de prioridade igual.
#### Implemente um programa, utilizando lista duplamente encadeada para controlar a lista de tarefas deste funcionário. Cada nó da lista deve conter a descrição e a prioridade da tarefa que ele representa. A prioridade da tarefa deve ser um número inteiro de um a dez. O programa deve conter os seguintes sub-programas (procedimentos ou funções):
- (a) Faça um procedimento para inserir uma nova tarefa na lista na posição correta de acordo com sua prioridade. Não pode existir na lista mais de uma tarefa com a mesma descrição;
- (b) Faça um procedimento para, dada a descrição de uma tarefa, procurá-la na lista e, caso encontre, informar quantas tarefas existem para serem executadas antes dela. Caso não encontre a tarefa procurada, o usuário deve ser informado;
- (c) Faça um procedimento chamado executarTarefa que remove uma tarefa da lista quando a mesma for ser executada. Lembre-se que o funcionário sempre executa a tarefa de mais alta prioridade;
- (d) Faça um procedimento para, dada a descrição de uma tarefa, cancelar a sua execução, ou seja, removê-la da lista de tarefas a serem executadas;
- (e) Faça um procedimento para exibir a descrição de todas as tarefas que possuem uma dada uma prioridade, informando também quantas são ao todo. Utilize, no procedimento, o algoritmo de busca sequencial melhorada;
- (f) Faça um procedimento para exibir a descrição e a prioridade de todas as tarefas cadastradas;
- (g) Faça um procedimento para, dada a descrição de uma tarefa, alterar sua prioridade. Isso vai implicar em alteração da posição da tarefa dentro da lista;

**OBS1**: Implemente um menu e um loop no programa principal para permitir que o usuário execute os métodos quantas vezes desejar.

**OBS2**: O programador é livre para implementar outros procedimentos/funções auxiliares que julgue necessário.
**OBS3**: O programa deverá validar a prioridade da tarefa para ser um valor inteiro de 1 a 10.

### 3ª Questão: Considere uma lista duplamente encadeada de inteiros ordenada em ordem crescente e que tem valores repetidos. Implemente um método de remoção que recebe como parâmetro o valor a ser removido. Caso exista na lista mais de uma cópia do valor a ser removido, o método implementado deverá remover todas as cópias de uma só vez.

### 4ª Questão: Considere uma lista duplamente encadeada de inteiros ordenada em ordem decrescente e que não tem valores repetidos. Implemente um método de remoção que recebe como parâmetro o valor a ser removido, faz uma busca pelo valor e, caso encontre, remove. OBS: Para procurar pelo valor a ser removido, utilize uma função de busca que recebe como parâmetro o valor procurado e retorna a referência para o nó que contém o valor procurado ou null, caso não encontre. Esta função deve ser de busca sequencial melhorada.