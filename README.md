# atividade-contatos

Roteiro de implantação

No diretório postgres que está dentro do diretório do projeto execute o comando:
docker build -t postgres-contatos .
No diretório do projeto execute o comando:
docker build -t payara-contatos .
Depois execute os comandos abaixo:
docker run -p 5433:5432 -d --name banco-contatos postgres-contatos
docker run -p 8081:8080 -d --name contatos-web --link banco-contatos:banco-contatos payara-contatos