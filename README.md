# Test técnico EDS
Desenvolvimento de uma API JSON RESTful em Java, utilizando o framework Spring boot, com os métodos (GET, POST, PUT, DELETE). 
Com banco de dados MySQL.

# API Endpoint
GET /veiculos

Retorna todos os veículos.

GET /veiculos /busca

Retorna os veículos de acordo com filtros passados através de query string.
Exemplo para o front: /veiculos/busca?veiculo=carro&marca=ferrari&ano=1995

GET /veiculos/{id}

Retorna os detalhes do veículo.

POST /veiculos

Adiciona um novo veículo.
Exemplo JSON: 
{
    "veiculo":"carro",
    "marca":"Gol",
    "ano":1990,
    "descricao":"Famoso Gol bolinha",
    "vendido":true,
    "dataCriacao":"",
    "dataAtualizacao":"",
    "chassi":"2323",
    "preco":6000
}

PUT /veiculos/{id}

Atualiza os dados de um veículo.

DELETE /veiculos/{id}

Apaga o veículo

GET /veiculos /paginado

Paginação.

Exemplo para o front: /veiculos/paginado?page=0&size=1

