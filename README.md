# DashboardDB

## Criação da Base de Dados

1. Com o usuário postgres, execute o aplicativo psql no servidor onde esta instalado o serviço PostgreSQL:
```Bash
$ psql
```
2. Crie um usuario para o aplicativo DashboardDB, juntamente com a senha que será utilizada para acesso. Estas credenciais devem ser informadas no arquivo application.properties:
```Bash
postgres=# CREATE ROLE dashboarddb WITH LOGIN PASSWORD 'dashboarddb';
```
3. Em seguida, crie a base de dados que será utilizada pelo aplicativo DashboardDB:
```Bash
postgres=# CREATE DATABASE dashboarddb OWNER=dashboarddb ENCODING=UTF8;
```
4. Conecte-se com a base de dados recem criada e crie o schema "dashboarddb" que será utilizado para organizar os objetos de banco de dados utilizados pelo aplicativo:
```Bash
postgres=# \c dashboarddb
dashboarddb=# CREATE SCHEMA dashboarddb;
```
5. Por fim, ajuste as permissões para que o usuário criado no item 2 possa utilizar o schema:
```Bash
dashboarddb=# ALTER SCHEMA dashboarddb OWNER TO dashboarddb;
dashboarddb=# GRANT ALL PRIVILEGES ON DATABASE dashboarddb TO dashboarddb;
dashboarddb=# GRANT ALL PRIVILEGES ON SCHEMA dashboarddb TO dashboarddb;
dashboarddb=# \q
```
