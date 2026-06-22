# Testes de Contrato

## Auth

### Validação do JSON Schema da resposta de autenticação com sucesso
``` gherkin
Dado que eu realizo uma requisição de autenticação válida
Quando eu receber a resposta do endpoint "/auth"
Então a estrutura do JSON de retorno deve corresponder exatamente ao schema definido para "auth-schema.json"
```