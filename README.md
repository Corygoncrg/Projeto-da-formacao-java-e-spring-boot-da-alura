# Projeto Java e Spring Boot
## Um programa que cria uma API RESTful utilizando MySQL como banco de dados

Esse é um projeto em que aprendemos a criar uma API RESTful com spring boot e aplicamos boas práticas conforme a evolução do projeto.

## Instalação

1. Faça o download do projeto
2. Modifique os diretórios conforme for necessário para às atender as suas necessidades em applications.properties
3. Crie um banco de dados para guardar as tables que serão criadas durante a Inicialização do programa
4. Cadastre um usuário no banco de dados, exemplo:
 
insert into usuarios values(1, 'ana.souza@voll.med', '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.');

*Senha escrita em formato Bcrypt, para criar a sua própria para testes clique [aqui](https://bcrypt-generator.com)

## Funções

* Metódos CRUD para um banco de dados contendo médicos e pacientes 
* Uso de autenticação por token obtido ao fazer login
