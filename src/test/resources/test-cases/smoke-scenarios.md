# Testes de Fumaça

## Auth

### Autenticação realizada com sucesso utilizando credenciais válidas

``` gherkin
Dado que eu possuo credenciais de autenticação válidas
Quando eu enviar uma requisição POST para o endpoint "/auth"
Então a API deve responder com o status code 200
E deve retornar um token de acesso válido no corpo da resposta
```

## Ping

### Confirmação de integridade do servidor com sucesso

``` gherkin
Dado que o servidor da API está online
Quando eu enviar uma requisição GET para o endpoint "/ping"
Então a API deve responder com o status code 201
E o corpo da resposta deve conter o texto "Created"
E o tempo de resposta deve ser inferior a 2 segundos
```

## Booking

### Listagem geral de IDs de reservas com sucesso

``` gherkin
Dado que existem reservas cadastradas no sistema
Quando eu enviar uma requisição GET para o endpoint "/booking" sem nenhum filtro
Então a API deve responder com o status code 200
E deve retornar uma lista contendo os IDs das reservas
```
