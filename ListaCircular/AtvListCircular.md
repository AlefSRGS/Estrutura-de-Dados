## Atividade de Estruturas de Dados I Listas duplamente encadeadas circulares


#### Questão única: Uma empresa deseja criar uma plataforma de streaming de vídeo que irá disponibilizar filmes aos seus usuários. Esta plataforma possuirá um aplicativo para armazenar e gerenciar as informações sobre os filmes por ela disponibilizados. Este aplicativo irá organizar os filmes por categorias e, através dele, será possível gerenciar o cadastro de filmes da plataforma. Você foi contratado para implementar este aplicativo. No aplicativo, o cadastro de filmes da plataforma será implementado utilizando lista linear duplamente encadeada circular. Na implementação do cadastro de filmes, deverá ser utilizada uma lista principal, ordenada em ordem alfabética crescente, que armazenará as categorias nas quais os filmes estão classificados. Deverão existir também, listas secundárias, uma para cada categoria que tenha filmes cadastrados, que armazenarão as informações sobre os filmes. Todas as listas de filmes (listas secundárias) serão ordenadas pelo título do filme em ordem alfabética crescente. A lista principal e as listas secundárias não possuem elementos repetidos.
#### Sua implementação deverá ser composta pelas seguintes classes: classe NodePrincipal, classe ListaCategorias, classe Categoria, classe NodeSecundaria, classe ListaFilmes, classe Filme e classe aplicação. Você é livre para implementar outras classes que julgue necessárias.
#### Segue abaixo a lista das classes obrigatórias com seus atributos e métodos a serem implementados: 
public class Categoria implements Comparable <Categoria> {

private String descrição;	// nome da categoria

private ListaFilmes lista;	// referência para a lista de filmes daquela categoria

// métodos da classe (gets, sets, construtor, compareTo, toString)

....
}
public class NodePrincipal { private NodePrincipal ante;
private Categoria info; // exemplo: “Filmes de ação” private NodePrincipal prox;
// métodos da classe (gets, sets, construtor)
....
}

public class ListaCategorias {
private NodePrincipal primeiro; private int qtd;
private NodePrincipal ultimo;
// métodos da classe (inserção ordenada na lista, remoção na lista, busca na lista, exibição da lista)
....
}

public class Filme implements Comparable <Filme> { private String titulo; // exemplo: “O Rei Leão” private String genero; // exemplo: “Musical infantil” private String classificação; // exemplo: “Livre” private int ano; // exemplo: 1994
// métodos da classe (gets, sets, construtor, compareTo, toString)
....

}