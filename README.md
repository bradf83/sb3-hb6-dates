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

# Data After Save

## System Time

```json
{
  "name": "Test2023-04-25T01:16:36.385523300Z",
  "creationDate": "2023-04-24T19:16:36.385523Z",
  "creationDateTz": "2023-04-25T01:16:36.385523Z"
}
```

## Using the old `TimeZone.setDefault...`

```json
{
  "name": "Test2023-04-25T01:21:48.072176100Z",
  "creationDate": "2023-04-24T19:21:48.072176Z",
  "creationDateTz": "2023-04-25T01:21:48.072176Z"
}
```

## Setting Time Zone with the JVM Argument

```json
{
  "name": "Test2023-04-25T01:42:13.717011600Z",
  "creationDate": "2023-04-25T01:42:13.717012Z",
  "creationDateTz": "2023-04-25T01:42:13.717012Z"
}
```
