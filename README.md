# Drone Fleet Manager

Petit projet Spring Boot autour d'une flotte de drones et de ses composants.

## Quick start

1. Start PostgreSQL:

```bash
docker compose up -d postgres
```

2. Start the Spring Boot app:

```bash
./mvnw spring-boot:run
```

API base URL: `http://localhost:8080/api`

## Database seed behavior

- Seed file: `sql/seed.sql`
- It runs automatically via Docker init at first database creation.
- If you need to re-run seed from scratch:

```bash
docker compose down -v
docker compose up -d postgres
```

[OneToMany](https://www.baeldung.com/hibernate-one-to-many)
