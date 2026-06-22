# Testes de Segurança

## Auth

### Rejeição de autenticação por omissão de campo
``` gherkin
Dado que eu monto o payload de autenticação apenas com o campo <nome_campo>
Quando eu enviar uma requisição POST para o endpoint "/auth"
Então a API deve responder com o status code 200
E o corpo da resposta deve indicar uma falha nas credenciais através da mensagem "Bad credentials"

Exemplos:
  | nome_campo |
  | username   |
  | password   |
```