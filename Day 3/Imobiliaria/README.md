# 🏠 Sistema de Gerenciamento de Imóveis

Este projeto é um sistema simples em Java para gerenciamento de imóveis, permitindo cadastrar **Casas** e **Apartamentos**, calcular o valor do aluguel com base no tempo de construção e benefícios adicionais, além de aplicar descontos progressivos.

## 📋 Funcionalidades

- Representação de imóveis com atributos como:
  - Valor de venda
  - Endereço
  - Ano de construção
  - Benefícios adicionados
- Cálculo automático do valor de aluguel com base:
  - No tipo de imóvel (Casa ou Apartamento)
  - No tempo desde a construção (descontos progressivos)
  - Em benefícios cadastrados
- Geração de relatório detalhado do imóvel
- **Cálculo do valor a receber pela imobiliária:** 12% sobre o valor de cada aluguel (sem condomínio)
- **Busca de imóveis por ano de construção**
- **Cálculo de valores para o proprietário:**
  - Valor bruto arrecadado com aluguéis
  - Valor líquido repassado (descontando a comissão de 12%)

## 🧱 Estrutura do Projeto

- `Imovel.java`: Classe base contendo atributos e métodos comuns.
- `Casa.java`: Subclasse que representa uma casa e aplica desconto de 5% ao aluguel a cada 5 anos.
- `Apartamento.java`: Subclasse que representa um apartamento e aplica desconto de 4% ao aluguel a cada 5 anos.

### Funções Pendentes!

## 💰 Cálculos e Relatórios Financeiros

- Comissão da imobiliária:

  - A imobiliária retém 12% sobre o valor do aluguel de cada imóvel.

- Busca por ano de construção:

  - O sistema permite buscar imóveis com base no ano em que foram construídos.

- Valor bruto e líquido para proprietários:
  - É possível calcular o total arrecadado em aluguéis (valor bruto) e o valor a ser repassado ao proprietário (valor líquido, descontando a comissão de 12%).

## 💻 Tecnologias Utilizadas

- Java 8+

- Console (entrada/saída padrão)
