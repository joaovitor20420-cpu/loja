<div align="center">
  # 🛒 Suburbio Store - Plataforma de E-commerce

  *Uma solução completa de comércio eletrônico desenvolvida com Java, Spring Boot e arquitetura MVC focada em moda Streetwear.*
  
  <p align="center">
    <a href="#-sobre-o-projeto">Sobre</a> •
    <a href="#-tecnologias-e-ferramentas">Tecnologias</a> •
    <a href="#%EF%B8%8F-arquitetura-e-padrões">Arquitetura</a> •
    <a href="#-funcionalidades-em-destaque">Funcionalidades</a> •
    <a href="#-skills-i-learned-habilidades-adquiridas">Habilidades Adquiridas</a> •
    <a href="#-como-executar-localmente">Como Executar</a>
  </p>

  ![Status Concluído](https://img.shields.io/badge/Status-Concluído-brightgreen?style=for-the-badge)
  ![Licença MIT](https://img.shields.io/badge/License-MIT-blue.svg?style=for-the-badge)
</div>

---

## 📖 Sobre o Projeto

Este projeto é uma **plataforma completa de E-commerce** desenvolvida do zero para demonstrar habilidades avançadas no ecossistema Java. A aplicação foi projetada para resolver problemas reais de lojas virtuais, dividindo-se em duas áreas principais:

1. **Storefront (Área do Cliente):** Interface amigável para navegação do catálogo de produtos, sistema de carrinho de compras via sessão e integração real com gateway de pagamentos.
2. **Admin Dashboard (Painel Administrativo):** Sistema de gestão integrado sob a rota `/admin`, com controle total sobre inventário, gestão de pedidos e controle de usuários VIPs.

> **💡 Foco para Recrutadores:** O código foi construído prezando pelas melhores práticas de engenharia de software, incluindo **SOLID**, **Design Patterns**, **Separação em Camadas (Model-Service-Controller)**, renderização do lado do servidor (SSR) otimizada para SEO, Autenticação Segura (OAuth2) e interface responsiva "Mobile-First".

## 🛠️ Tecnologias e Ferramentas

As ferramentas foram escolhidas a dedo, refletindo o que há de mais moderno e demandado no mercado corporativo atual:

### ⚙️ Back-end
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)
![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![H2 Database](https://img.shields.io/badge/H2_Database-4479A1?style=for-the-badge&logo=database&logoColor=white)
![Stripe](https://img.shields.io/badge/Stripe-008CDD?style=for-the-badge&logo=stripe&logoColor=white)

### 🎨 Front-end
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-%23005C0F.svg?style=for-the-badge&logo=Thymeleaf&logoColor=white)
![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white)
![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E)

---

## 🏗️ Arquitetura e Padrões

O projeto adota de forma estrita a arquitetura **MVC (Model-View-Controller)**, garantindo um código limpo, testável e de fácil manutenção:
- **Models (Entities):** Mapeamento Objeto-Relacional (ORM) estruturado com Hibernate/JPA, explorando recursos de validação e Enums.
- **Controllers:** Orquestração de requisições HTTP, tratamento de validações e integração com a camada de serviços.
- **Views (Thymeleaf):** Renderização de páginas dinâmicas no servidor, favorecendo tempo de resposta e segurança de dados.
- **Security (OIDC/OAuth2):** Integração segura e moderna com o Google OIDC para sincronização de contas.

---

## 📁 Estrutura de Pastas (Padrão MVC)

```text
📦 loja
 ┣ 📂 src/main/java/com/example/loja
 ┃ ┣ 📂 config       <-- Configurações Globais (Segurança, AdminSeeder, Swagger)
 ┃ ┣ 📂 controllers  <-- Camada de Rotas e Requests HTTP
 ┃ ┣ 📂 models       <-- Entidades JPA e Enums do Banco de Dados
 ┃ ┣ 📂 repositories <-- Interfaces de Acesso a Dados (Spring Data)
 ┃ ┣ 📂 security     <-- Filtros e Serviços Customizados do Spring Security
 ┃ ┗ 📂 services     <-- Camada de Regras de Negócio, Integração Stripe e Uploads
 ┣ 📂 src/main/resources
 ┃ ┣ 📂 static/css   <-- Estilos e UX/UI da aplicação
 ┃ ┣ 📂 static/js    <-- Lógica assíncrona e DOM local
 ┃ ┗ 📂 templates    <-- Arquivos HTML dinâmicos do Thymeleaf
 ┗ 📜 pom.xml        <-- Gerenciamento do ecossistema e dependências Maven
```

---

## ✨ Funcionalidades em Destaque

### 🛍️ Storefront (Experiência do Usuário)
- **Catálogo Dinâmico:** Navegação fluida com filtros categóricos voltados a Moda Urbana e Streetwear.
- **Carrinho e Checkout Real:** Sistema de adição de itens na sessão com cálculo de subtotais e integração real com API do **Stripe** para finalização de compras.
- **Tema Personalizado:** Suporte nativo completo a **Dark Mode / Light Mode** salvo localmente.
- **Mobile-First:** Design completamente responsivo e agradável para dispositivos móveis e desktop.

### 🔐 Autenticação (`signin.html` / `signup.html`)
- Tela de **Login** com validação de credenciais de banco.
- **Login social com Google (OIDC):** Sincronização automática com o banco de dados e atribuição dinâmica de perfis (User/Admin).
- Proteção total de rotas (`CSRF` e restrição de acesso a `/admin`).

### 📊 Dashboard Administrativo (Gestão em `/admin`)
- **Blindagem Completa:** Todas as rotas restritas via `hasAuthority('ROLE_ADMIN')` no `SecurityConfig`.
- **CRUD Completo de Produtos:** Criar, Listar, Editar e Excluir produtos com persistência no banco de dados H2.
- **Upload de Arquivos:** Processamento local de envio de imagens e exibição assíncrona.
- **Gestão de Pedidos:** Acompanhamento dinâmico do banco após checkout finalizado via Stripe.
- **Dashboard Analítico:** Painel dinâmico listando estoque crítico, ganhos totais e transações recentes.

---

## 🧠 Skills I Learned (Habilidades Adquiridas)

Durante a arquitetura e desenvolvimento completo desta plataforma E-commerce, conquistei conhecimento prático e profundo nas seguintes áreas:

- **Desenvolvimento Backend Robusto (Java & Spring Boot):** Estruturação limpa de pacotes usando Arquitetura em Camadas (Model, Repository, Service, Controller).
- **Segurança da Informação (Spring Security):** Implementação de Proteção contra ataques (CSRF, restrições de URL), login híbrido manual e via Auth Providers (Google OAuth2/OIDC).
- **Bancos de Dados Relacionais e ORM:** Modelagem estruturada com Spring Data JPA, Hibernate, uso avançado de Queries, relacionamentos de Entidades, Sequences e Enums controlados.
- **Integração de APIs de Pagamento (Stripe):** Criação de _Payment Intents_, controle de _Sessions_, manipulação de API keys de terceiros e redirecionamento dinâmico no E-commerce.
- **Design de Interfaces e SSR (Thymeleaf & Front-end):** Compreensão do ciclo de requisição HTTP e renderização no lado do Servidor com Thymeleaf integrado ao ecossistema Spring. Refino técnico de UI/UX, Flexbox/Grid CSS e manipulação de DOM via JS.
- **Engenharia de Software (Clean Code & SOLID):** Delegação de responsabilidades entre serviços garantindo alta coesão e baixo acoplamento no desenvolvimento do ciclo de vida das requisições (por exemplo, desacoplando `StripeService` e `CartService`).

---

## 🚀 Como Executar Localmente

### 1. Pré-requisitos
- **Java 21** (ou superior) instalado e configurado no seu PATH.
- (Opcional) Chaves de Teste da API do Stripe para processamento completo.

### 2. Passo a Passo (Via Maven)

```bash
# Clone este repositório
git clone https://github.com/joaovitor20420/loja.git

# Acesse o diretório do projeto
cd loja

# Inicie o Servidor Tomcat embutido (Windows)
.\mvnw.cmd spring-boot:run
```

### 3. Passo a Passo (Via Docker) 🐳

Para rodar a aplicação sem instalar o Java na sua máquina, utilize o Docker. O projeto já inclui um `Dockerfile` otimizado (Multi-stage) e um `docker-compose.yml` pré-configurado.

```bash
# Inicia a aplicação construindo a imagem do zero
docker-compose up --build -d

# Para ver os logs em tempo real
docker-compose logs -f
```

*(O Docker Compose criará automaticamente diretórios locais `/database` e `/uploads` para persistir as fotos dos produtos e o seu banco de dados H2, mesmo após reiniciar o container).*

### 4. Acessando a Aplicação
| Ambiente | URL |
| :--- | :--- |
| **Loja Virtual (Público)** | [http://localhost:8080/](http://localhost:8080/) |
| **Painel Admin** | [http://localhost:8080/admin/dashboard](http://localhost:8080/admin/dashboard) |
| **Console H2 (Banco)** | [http://localhost:8080/h2-console](http://localhost:8080/h2-console) |

---
<p align="center">
  <i>Desenvolvido com foco na qualidade e melhores práticas de Engenharia de Software.</i>
</p>
