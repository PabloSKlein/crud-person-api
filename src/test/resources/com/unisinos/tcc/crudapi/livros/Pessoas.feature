#language: pt
Funcionalidade: Crud de Pessoas

  Cenario: Pesquisa de uma pessoa por documento
    Quando Eu pesquisar a pessoa de documento "04000440444"
    Entao  O status retornado deve ser 200
    E O campo "nome" deve ser "Pablo Kleim"