# View Database Content

This project uses PostgreSQL from Docker with:

- Host: localhost
- Port: 5433
- Database: spring1db
- User: postgresuser
- Password: password

## Option 1: Use psql (Terminal)

Open a shell inside the running database container:

```bash
docker exec -it spring1-postgres psql -U postgresuser -d spring1db
```

List all tables:

```sql
\dt
```

Check data in component tables:

```sql
SELECT * FROM gpus;
SELECT * FROM cpus;
SELECT * FROM ram_modules;
SELECT * FROM motherboards;
SELECT * FROM psus;
```

Exit psql:

```sql
\q
```

## Option 2: Use a GUI Tool

You can use DBeaver or pgAdmin and connect with the same values above.

## Useful Docker Commands

Check container status:

```bash
docker ps
```

Start DB service if needed:

```bash
docker compose up -d postgres
```
