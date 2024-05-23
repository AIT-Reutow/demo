# Используем официальный образ Java
FROM openjdk:17-jdk-slim

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем gradle скрипты и исходники проекта
COPY . .

# Собираем проект без тестов
RUN ./gradlew build -x test --no-daemon

# Копируем JAR файл в контейнер
COPY build/libs/demo-0.0.1-SNAPSHOT.jar app.jar

# Открываем порт для приложения
EXPOSE 8080

# Команда для запуска приложения
ENTRYPOINT ["java", "-jar", "app.jar"]
