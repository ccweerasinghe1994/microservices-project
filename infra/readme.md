## postgres database creation 

[docker-compose.yml](docker-compose.yml)

let's connect to the database and create a database and a table

```bash
docker-compose exec postgres psql -U microservices -d microservices_db
```

```sql