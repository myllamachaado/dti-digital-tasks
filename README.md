# Desafio Dti Digital - Backend

<p align="center">
    <a alt="Java">
          <img src="https://img.shields.io/badge/Java-v17-blue.svg" />
    </a>
    <a alt="JPA">
        <img src="https://img.shields.io/badge/JPA-v3.1.0-brightgreen.svg" />
    </a>
     <a alt="Validation">
        <img src="https://img.shields.io/badge/Validation-v3.0.2-red.svg" />
    </a>
     <a alt="Flyway">
        <img src="https://img.shields.io/badge/Flyway-v9.18.0-blueviolet.svg" />
    </a>
     <a alt="Model Mapper">
        <img src="https://img.shields.io/badge/Model_Mapper-v3.1.1-orange.svg" />
  </a>
  <a alt="Lombok">
          <img src="https://img.shields.io/badge/Lombok-v1.18.20.0-blue.svg" />
    </a>
    <a alt="H2">
        <img src="https://img.shields.io/badge/H2-v2.1.214-brightgreen.svg" />
    </a>
     <a alt="JUnit">
        <img src="https://img.shields.io/badge/JUnit-v4.13.2-red.svg" />
    </a>
     <a alt="Mockito">
        <img src="https://img.shields.io/badge/Mockito-v5.3.1-blueviolet.svg" />
    </a>
  
</p>

- Descrição do projeto:


Você deverá desenvolver um sistema de criação de lembretes, seguindo as seguintes régras: Deverá ser possível adicionar um novo lembrete, informando o nome e a data do lembrete

o Ao clicar em “Criar”, os campo deverão ser validados seguindo as regras:

▪ O campo “Nome” deverá estar preenchido

▪ O campo “Data” deverá estar preenchido, com uma data válida, e essa data tem de estar no futuro

o Caso os valores dos campos sejam válidos, o novo lembrete deverá ser exibido na seção 

o Lista de lembretes
- Deverá ser possível deletar um lembrete anteriormente adicionado, clicando no “x”

- Ao adicionar um novo lembrete, caso a sua data já exista, ele deverá aparecer dentro da lista referente àquele dia; caso não, um novo dia deverá ser exibido, contendo aquele novo dia

- Os dias da lista de lembretes deverão ser exibidos em ordem cronológica


## Interface
   
![Frontend projeto Lembretes Dti Digital](https://github.com/myllamachaado/dti-digital-task-frontend/blob/master/src/interface_angular.png)     


## Endpoints

A collection do Postman com todos os endpoints se econtra em [/postman](https://github.com/myllamachaado/dti-digital-tasks/tree/master/postman), Basta importar o arquivo no Postman para a validação backend.


## Comandos para rodar o projeto:

<p>No Terminal/Console:</p>
<ol>
	<li>Faça um clone do projeto na sua máquina: <code>git clone https://github.com/myllamachaado/dti-digital-tasks.git</code></li>
	<li>Entre na pasta raiz do projeto: <code>cd </code></li> 
	<li>Execute o comando: <code>./gradlew bootrun</code></li>
</ol>
<h6>** Visando facilitar a demostração da aplicação, recomendo instalar apenas o IntelliJ IDEA e executar o projeto através da IDE **</h6>
