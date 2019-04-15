# Проект UI автотестов сайта магазина компьютерной техники DNS

**Запуск тестов в многопоточном режиме:**
```
mvn clean test -Dtest=Testt -Djupiter.parallel=true
```
**Запуск тестов в однопоточном режиме:**
```
mvn clean test -Dtest=Testt
```