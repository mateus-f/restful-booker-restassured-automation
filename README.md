# 🔌 Restful-Booker API Automation

[![Java Version](https://img.shields.io/badge/Java-25-orange.svg)](https://jdk.java.net/)
[![RestAssured](https://img.shields.io/badge/RestAssured-6.0.0-green.svg)](https://rest-assured.io/)
[![JUnit](https://img.shields.io/badge/JUnit-4.13.2-blue.svg)](https://junit.org/junit4/)
[![Platform](https://img.shields.io/badge/API-Restful--Booker-critical.svg)](https://restful-booker.herokuapp.com/apidoc/index.html)

Projeto de automação de testes de API ponta a ponta com **RestAssured** para a API pública [Restful-Booker](https://restful-booker.herokuapp.com/apidoc/index.html). Cobre validações funcionais, segurança, fumaça (smoke) e contratos.

## 📂 Estrutura do Projeto 

A estrutura utiliza a Arquitetura Clean Slice, que organiza o projeto por fatias verticais de domínio (`auth`, `booking`, `ping`). Cada componente de negócio contém suas próprias requisições, payloads e validações, reduzindo o acoplamento e facilitando a manutenção.

```text
```text
src/
└── test/
    ├── java/br/com/
    │   ├── base/BaseTest.java              # Infraestrutura: Configuração global de URI e filtros
    │   ├── runners/                        # Executores: Gatilhos para CI/CD (Smoke, Contract, etc.)
    │   ├── suites/                         # Interfaces: Categorias de marcação do JUnit 4
    │   ├── tests/                          # --- SLICES DE NEGÓCIO ---
    │   │   ├── auth/                       # Slice: Payloads, Requisições e Testes de Autenticação
    │   │   ├── booking/                    # Slice: Payloads, Requisições e Testes de Reservas
    │   │   └── ping/                       # Slice: Validações de Healthcheck da API
    │   └── utils/Utils.java                # Classes utilitárias gerais
    └── resources/
        ├── schemas/                        # Contratos: Arquivos JSON Schema para validação
        └── test-cases/                     # Especificação: Cenários documentados em Markdown
```

## 📋 Pré-requisitos
- JDK 25
- Apache Maven 3.9+

## 🔧 Como Executar

``` bash

# 1. Clone o repositório
git clone https://github.com/mateus-f/restful-booker-restassured-automation.git

# 2. Acesse a pasta do projeto
cd restful-booker-restassured-automation

# 3. Executar toda a suíte de testes via Maven
mvn clean test

# 4. Executar uma suíte/runner específica via Maven
mvn test -Dtest=SmokeTests

```