# Testes Críticos de Aceitação

## Auth

### Retorno exclusivo do campo token na resposta de sucesso

``` gherkin
Dado que eu realizo uma autenticação com sucesso
Quando a resposta retornar do endpoint "/auth"
Então o corpo da resposta deve conter apenas o campo "token"
E o valor do token não deve ser nulo ou vazio
```

## Booking

### Filtragem combinada de reservas por nome e sobrenome

``` gherkin
Dado que existem reservas cadastradas para o cliente com <firstname> e <lastname>
Quando eu enviar uma requisição GET para o endpoint "/booking" filtrando por "<parametro>" com o valor "<valor>"
Então a API deve responder com o status code 200
E todos os IDs retornados devem corresponder a reservas que possuem esse "<valor>" no campo correspondente

Exemplos:
  | parametro | valor   | firstname | lastname |
  | firstname | Sally   | Sally     | Brown    |
  | lastname  | Brown   | Sally     | Brown    |
```

### Filtragem de reservas por período de datas

``` gherkin
Dado que existem reservas cadastradas com datas de estadia variadas
Quando eu enviar uma requisição GET para o endpoint "/booking" passando o query parameter "<filtro_data>" com o valor "<data_limite>"
Então a API deve responder com o status code 200
E os IDs retornados devem ser de reservas com datas maiores ou iguais a "<data_limite>"

Exemplos:
  | filtro_data | data_limite |
  | checkin     | 2026-05-15  |
  | checkout    | 2026-06-01  |
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
### Busca por filtros que não correspondem a nenhuma reserva existente

``` gherkin
Dado que eu informo um critério de busca inexistente no sistema
Quando eu enviar uma requisição GET para o endpoint "/booking" passando o parâmetro "<parametro>" com o valor "<valor>"
Então a API deve responder com o status code 200
E deve retornar uma lista vazia `[]`

Exemplos:
  | parametro | valor                  |
  | firstname | "NomeInexistenteXYZ"   |
  | lastname  | "SobrenomeQueNaoExiste"|
  | checkin   | "2099-12-31"           |
```

### Envio de parâmetros com formatos de data inválidos

``` gherkin
Dado que eu desejo filtrar reservas por uma data fora do padrão esperado
Quando eu enviar uma requisição GET para o endpoint "/booking" passando o parâmetro "<parametro_data>" com o valor "<formato_errado>"
Então a API deve responder com o status code 500
E deve lidar com o erro graciosamente sem derrubar o serviço

Exemplos:
  | parametro_data | formato_errado |
  | checkin        | 15-05-2026     |
  | checkin        | texto_aleatorio|
```