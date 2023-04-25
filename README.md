# Thoughts

Created on April 24, 2023

- I want to use PostgreSQL
- I want the database and the application running in UTC
- I want the API accepting UTC for date\times
- I want the API returning UTC for date\times

# Setting Timezone

## Spring Boot Plugin

`mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Duser.timezone=UTC"`

## VS Code `launch.json`

Add `"vmArgs": "-Duser.timezone=UTC",` to the launch configuration

## Running Maven Tests

`mvn test -DargLine="-Duser.timezone=UTC"`

## Docker Compose

???

## Kubernetes

???

## Notes

**WARNING** : As of Spring Boot 3, it no longer works to set the timezone using a `PostConstruct` in a Spring Boot Application to set the timezone `TimeZone.setDefault(TimeZone.getTimeZone("UTC"));`
