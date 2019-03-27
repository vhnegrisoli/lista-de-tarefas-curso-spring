# lista-de-tarefas-curso-spring
Aplicação de listagem de tarefas de usuários feita em Spring Boot para o curso de Desenvolvimento Java Spring pelos alunos Victor Hugo Negrisoli e Rafael Nonino Filho na UniFil.

Docentes: Victor Hugo Negrisoli, Rafael Nonino Filho 
Curso: Desenvolvimento de API REST em Java com Spring Boot (Centro Universitário Filadélfia - UNIFIL)

Tecnologias:
* Linguagem de programação JAVA
* Banco de dados em memória H2
* Lombok Project
* Spring Boot
* Spring Data JPA
* Front end em ReactJS
* Linguagem SQL

Endpoints desenvolvidos:

Categorias:

GET:

Lista todas as categorias:
"http://localhost:8080/api/categorias/todas"

Busca uma categoria:
"http://localhost:8080/api/categorias/buscar/id"

Remove uma categoria:
"http://localhost:8080/api/categorias/delete/id"

POST:
Salva uma categoria:
"http://localhost:8080/api/categorias/salvar"

JSON: { "id":value, "descricao":"value" }

Usuários:

GET:

Lista todos os usuários:
"http://localhost:8080/api/usuários/todos"

Busca um usuário:
"http://localhost:8080/api/usuários/buscar/id"

Remove um usuário:
"http://localhost:8080/api/usuários/delete/id"

POST:
Salva um usuário:
"http://localhost:8080/api/usuários/salvar"

JSON: { "id":value, "email":"value@value", "nome":"value" }


Tarefas:

GET:

Lista todas as tarefas:
"http://localhost:8080/api/tarefas/todas"

Busca uma tarefa:
"http://localhost:8080/api/tarefas/buscar/id"

Remove uma tarefa:
"http://localhost:8080/api/tarefas/delete/id"

Inicia uma tarefa:
"http://localhost:8080/api/tarefas/fazer/id"

Finaliza uma tarefa:
"http://localhost:8080/api/tarefas/finalizar/id"

POST:
Salva uma tarefa:
"http://localhost:8080/api/categorias/salvar"

JSON: { "id":value, "tarefa":"value", "categorias":{"id":"value"}, "usuarios":[{"id":"value"}] }
