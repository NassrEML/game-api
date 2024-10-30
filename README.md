# 🎮 game-api

## 🚀 Requirements

- ☕ Java 21
- 📦 Maven 3.8.6 o superior
- 🐳 Docker

## 📥 Installation

To install dependencies without running tests, execute the following command:

```sh
mvn clean install -DskipTests
```

## ▶️ Run

To start the application, run the following commands:

```sh
make build-postgres-image
make run-postgres-container
java -jar game-api-app/target/game-api-app-1.0.0-SNAPSHOT.jar
```

## 🧪 Testing

To run unit tests, execute the following command:

```sh
mvn test
```
