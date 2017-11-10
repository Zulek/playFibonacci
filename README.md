
# Запустить проект
```
sbt "~re-start"
```

По адресу http://localhost:9000/fib доступно вычисление последовательности Фибоначчи

Указать индекс до которого будет высчитываться последовательность можно через параметр index http://localhost:9000/fib?index=10

# Собрать проект в JAR
```
sbt assembly
```

Запустить сервер
```
java -jar target/scala-2.12/play-embedded-assembly-0.0.1.jar
```

# Запустить тесты
```
sbt test
```