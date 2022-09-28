# 📦 Controle de usuário BackEnd [<img align="right" src="https://img.shields.io/badge/release-v0.0.1-green">](user-control-system/releases)

> <b>Status code:</b> 🚧 andamento 🚧

<br>

## ℹ index

-   [📥 download](#-download)
    -   [setup](#-setup)
    -   [starting](#-starting)
-   [🛠 tecnologias](#-tecnologias)
-   [✍🏼 autor](#-autor)
-   [📝 license](#-license)

## 📥 download

Antes de começar, você precisará ter as seguintes ferramentas instaladas em sua máquina:
[Git](https://git-scm.com), [JDK17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) este projeto usa o java **_17_**, o uso do drive do [PostgreSQL](https://www.postgresql.org/download/) também será necessário (ou qualquer outro banco SQL). Além disso, é bom ter um editor para trabalhar com código como [Intelij](https://www.jetbrains.com/idea/)  .

### 💻 setup

```php
# clonar este repositório
$ git clone https://github.com/br3nds0n/user-control-system.git

# acesse a pasta do projeto
$ cd user-control-system

# acesse a pasta do backend
$ cd backend

# instale as dependências
$ ./mvnw install
```

### ⚙ Configurar variáveis de ambiente

```python
# configuração banco de dados
spring.jpa.properties.hibernate.dialect = <dialect>
spring.datasource.url = <jdbc.url>

spring.jpa.hibernate.ddl-auto = update
spring.jpa.hibernate.show-sql = true

spring.datasource.username = <user>
spring.datasource.password = <password>

# configuração de segurança
spring.security.user.name =  <user>
spring.security.user.password = <password>

jwt.secret = <user>

# configuração de servidor
server.port = 5000
server.servlet.contextPath=/api
url.web = http://localhost:8080/

# api externa cep
viaCep.api.url = https://viacep.com.br/ws/
```

<br>

## ▶ starting

```php
# executando o comando
$ ./mvnw spring-boot:run

# aplicação iniciará em <http://localhost:5000/api>
```

<br>

## 🛠 tecnologias

As seguintes ferramentas/tecnologias foram usadas na construção e teste do projeto. Ao clicar no ícone da tecnologia, você será redirecionado ao site oficial para instalação:

<br>

|                                   logo                                     |                       Framework                       | Version  |
| :------------------------------------------------------------------------: |:-----------------------------------------------------:|:--------:|
| <img height="35" width="40" src="https://skillicons.dev/icons?i=idea">     |     [Intelij](https://www.jetbrains.com/idea/)        |  `2022`  |
| <img height="35" width="40" src="https://skillicons.dev/icons?i=java">     |          [Java](https://www.java.com/pt-BR/)          | `17.0.0` |
| <img height="35" width="40" src="https://skillicons.dev/icons?i=spring">   |        [SpringBoot](https://start.spring.io/)         | `2.7.0`  |
| <img height="35" width="40" src="https://skillicons.dev/icons?i=maven">    |           [Maven](https://maven.apache.org)           | `4.0.0`  |
| <img height="35" width="40" src="https://skillicons.dev/icons?i=postgres"> |  [PostgreSQL](https://www.postgresql.org/download/)   | `8.7.3`  |
| <img height="35" width="40" src="https://skillicons.dev/icons?i=docker">   |           [Docker](https://www.docker.com/)           | `1.27.4` |

<br>

## ✍🏼 autor

<table>
  <tr>
   <tr align=center>
        <th><a href="https://github.com/br3nds0n"><strong> Brendson Victor </strong><a></th>
  </tr>
    <td align="center">
      <a href="https://github.com/br3nds0n">
        <img src="https://user-images.githubusercontent.com/82064724/185726784-e8d151e8-29d6-4475-ba50-ca23f9429650.png" width="110"/></a><br>
        <sub>
            <a href="https://www.linkedin.com/in/brendson/" target="_blank" rel="noreferrer" rel="noopener">
              <img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt="Linkedin"/>
            </a></br>
          </div>
        </sub>
    </td>
  </tr>
</table>

<br>

[[ ↑ voltar ]](#-controle-usuario-backend-)