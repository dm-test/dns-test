# Проект UI автотестов сайта DNS

**Запуск тестов в многопоточном режиме:**
```
mvn clean test -Dtest=JunitTests -Djupiter.parallel=true
```

**Запуск тестов в однопоточном режиме:**
```
mvn clean test -Dtest=JunitTests
```

**Формирование Allure-отчета**
```
mvn allure:serve
```