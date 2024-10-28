# Running Silo with Docker

This guide will help you get Silo up and running using Docker and Docker Compose.

## Prerequisites

- Docker
- Docker Compose

## Steps

1. Clone the Silo repository:

   ```sh
   git clone https://github.com/dobraalkan/silo.git
   ```

2. Navigate to the `docker_example` directory:

   ```sh
   cd langflow/docker_example
   ```

3. Run the Docker Compose file:

   ```sh
   docker compose up
   ```

Silo will now be accessible at [http://localhost:7860/](http://localhost:7860/).

## Docker Compose Configuration

The Docker Compose configuration spins up two services: `silo` and `postgres`.

### Silo Service

The `silo` service uses the `dobraalkan/silo:latest` Docker image and exposes port 7860. It depends on the `postgres` service.

Environment variables:

- `SILO_DATABASE_URL`: The connection string for the PostgreSQL database.
- `SILO_CONFIG_DIR`: The directory where Silo stores logs, file storage, monitor data, and secret keys.

Volumes:

- `silo-data`: This volume is mapped to `/var/lib/silo` in the container.

### PostgreSQL Service

The `postgres` service uses the `postgres:16` Docker image and exposes port 5432.

Environment variables:

- `POSTGRES_USER`: The username for the PostgreSQL database.
- `POSTGRES_PASSWORD`: The password for the PostgreSQL database.
- `POSTGRES_DB`: The name of the PostgreSQL database.

Volumes:

- `silo-postgres`: This volume is mapped to `/var/lib/postgresql/data` in the container.

## Switching to a Specific Silo Version

If you want to use a specific version of Silo, you can modify the `image` field under the `silo` service in the Docker Compose file. For example, to use version 1.0-alpha, change `dobraalkan/silo:latest` to `dobraalkan/silo:1.0-alpha`.
