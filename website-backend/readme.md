# How to use the backend?

## Database:

This is used to configure the database settings

src/main/resources/application-database.yml

```yaml
websiteConfig:
  database:
    url: ${jdbc-url}
    username: ${jdbc-username}
    password: ${jdbc-password}
```

## Email:

This is used to configure the email settings

src/main/resources/application-email.yml

```yaml
websiteConfig:
    mail:
        username: ${username}
        password: ${password}
    url:
      activation: ${activation-url}
```

## Log

This is used to configure the log settings

src/main/resources/application-log.yml

```yaml
# Log
websiteConfig:
  log:
    logPath: ${log-path}
    logRollingPath: ${log-rolling-path}
```

## Resource

This is used to figure the resource paths

src/main/resources/application-resource.yml

```yaml
websiteConfig:
  resource:
    blog: ${blog-path}
```