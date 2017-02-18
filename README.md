# atividade-contatos

Roteiro de implantação

docker build -t postgres-contatos .
docker build -t payara-contatos .
docker run -p 5433:5432 -d --name banco-contatos postgres-contatos
docker run -p 8081:8080 -d --name contatos-web --link banco-contatos:banco-contatos payara-contatos