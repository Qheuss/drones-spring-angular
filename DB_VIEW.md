# View Drone Database Content

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
SELECT * FROM drones;
SELECT * FROM motors;
SELECT * FROM flight_controllers;
SELECT * FROM cameras;
SELECT * FROM frames;
SELECT * FROM batteries;
SELECT * FROM props;
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

If need to destroy and rebuild the db:

```bash
docker compose down -v
docker compose up -d
```
