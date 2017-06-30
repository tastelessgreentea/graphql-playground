# GraphQL Playground
Personal sandbox to do some graphql experiment.

# Quick Start

### Run the dev environment

`docker-compose up`

### Create migration file

`lein migratus create <migration_file_name>`

### Run migration files
connect to the app container:
`docker exec -it <container_name> /bin/bash`
run migrate command in it
`lein migratus migrate`

### Interact with postgres database

`psql -U <username> -d health -h localhost`
