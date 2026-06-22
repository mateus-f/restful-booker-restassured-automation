# Testes de Fumaça

## Auth

### Autenticação realizada com sucesso utilizando credenciais válidas
``` gherkin
Dado que eu possuo credenciais de autenticação válidas
Quando eu enviar uma requisição POST para o endpoint "/auth"
Então a API deve responder com o status code 200
E deve retornar um token de acesso válido no corpo da resposta
```