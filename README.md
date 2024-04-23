<div>

## Monitoring System

</div>

---

### Разработчик

- [Муслимов Владислав](https://github.com/MuVlad)
- Контактная информация: *[muslimov.vlad@mail.ru]()*

---

## Описание проекта и его функциональность

Этот проект реализует систему мониторинга метрик с использованием Kafka и состоит из двух микросервисов:

- `Metrics Producer`
- `Metrics Consumer`

### Metrics Producer

Сервис собирает различные метрики из приложения с помощью Spring Boot Actuator и
предоставляет API для отправки метрик на кластер Kafka.

### Metrics Consumer

Сервис обрабатывает сообщения из кластера Kafka и сохраняет в базу данных.
Также предоставляются REST API для просмотра и управления метриками.

---

## Запуск приложения

Для запуска приложения Вам потребуется выполнить несколько шагов:

1. Клонировать проект и открыть его в среде разработки (например, *IntelliJ IDEA* или *VSCode*);
2. В файле **docker-compose.yml** выполнить инструкции по запуску Zookeeper, Kafka и базы данных PostgreSQL;
3. В модуле `Metrics Producer` Запустить метод **main** в файле **MetricsProducerApplication.java**
4. модуле `Metrics Consumer` Запустить метод **main** в файле **MetricsConsumerApplication.java**

Swagger будет доступен по следующим адресам:

Metrics Producer - http://localhost:8080/swagger-ui/index.html

Metrics Consumer - http://localhost:8081/swagger-ui/index.html

---

## Стэк технологий

* **Backend**:
    - Java 17
    - Maven
    - Spring Boot
    - Spring Web
    - Spring Actuator
    - Spring Data JPA
    - Kafka
    - Swagger
    - Lombok
    - Mapstruct


* **SQL**:
    - PostgreSQL


* **Tests**:
    - JUnit
    - Mockito