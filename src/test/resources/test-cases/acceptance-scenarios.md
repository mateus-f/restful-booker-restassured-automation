# Testes Críticos de Aceitação

## Auth

### Retorno exclusivo do campo token na resposta de sucesso
``` gherkin
Dado que eu realizo uma autenticação com sucesso
Quando a resposta retornar do endpoint "/auth"
Então o corpo da resposta deve conter apenas o campo "token"
E o valor do token não deve ser nulo ou vazio
```

# Testes de Exceção de Aceitação

## Auth

### Rejeição de autenticação com credenciais incorretas
``` gherkin
Dado que eu informo o usuário <usuario>
E a senha <senha>
Quando eu enviar uma requisição POST para o endpoint "/auth"
Então a API deve responder com o status code 200
E o corpo da resposta deve conter a mensagem de erro "Bad credentials"

Exemplos:
  | usuario        | senha         |
  | "admin"        | "senhaErrada" |
  | "userInvalido" | "password123" |
  | ""             | ""            |
```