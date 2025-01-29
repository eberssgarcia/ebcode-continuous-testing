# AUTOMATIZACIÓN WEB - [DEMOBLAZE](https://www.demoblaze.com/)

Este proyecto de automatización para la aplicación web demoblaze esta hecho con las herramientas Selenium Web Driver y
desarrollado con Java 1.8.

# Herramientas y/o tecnologías a usar

* **Intellij IDEA:** Este IDE permitirá crear proyectos.
* **JDK Java verisón 17:** Configurar como variable de entorno.
* **Depedencias Selenium:** Estas dependencias se debe ingresar en el POM.XML
* **apache-maven-3.8.6:** Descargar package y configurar como variable de entorno.

# Configurar proyecto

1. Crear proyecto de tipo MAVEN
2. Ingresar las dependencias de selenium en el pom.xml
3. Ejecutar comando `mvn install` a través de la terminal

**Nota**: Si ya tienes definido test de prueba, puedes ejecutar el comando `mvn install -DskipTests` para omitir dichos
tests.

# Ejecución de pruebas

1. Abre proyecto desde la Git Bash
2. Ejecutar el comando `mvn clean test -Dcucumber.options="--tags @freerangetesters-02" -Dbrowser=firefox` para ejecutar
   las pruebas.
3. Para ejecutar los test en un navegador diferente, cambiar el valor de la variable `-Dbrowser` por el navegador
   deseado.

# Dependencias

1. **Cucumber Java**: Esta dependencia te permite utilizar Cucumber en tu proyecto Java.
   **`Repositorio`**: https://mvnrepository.com/artifact/io.cucumber/cucumber-java

        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>7.11.1</version>
            <scope>compile</scope>
        </dependency>

2. **Cucumber JUnit**: Esta dependencia te permite ejecutar pruebas de Cucumber con JUnit.

**`Repositorio`**: https://mvnrepository.com/artifact/io.cucumber/cucumber-junit

        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit</artifactId>
            <version>7.11.1</version>
            <scope>compile</scope>
        </dependency>

3. **Selenium Java**: Esta dependencia te permite utilizar Selenium WebDriver en tu proyecto Java.

**`Repositorio`**: https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java

        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.8.0</version>
            <scope>compile</scope>
        </dependency>

4. **webdrivermanager - bonigarcia**: Esta dependencia permite gestionar los drivers de los navegadores.

**`Repositorio`**: https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager

         <dependency>
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>5.9.2</version>
        </dependency>

# Tags para ejecución de feature

##### Para ejecutar los features de web, de manera independiente, utilizar lo siguiente:

| web Feature                              | TAG             |
|------------------------------------------|-----------------|
| Ejecución de todos los casos de pruebas. | @test-execution |
| Ejecutar casos de pruebas agrupados      | @test-group     |
| Ejecutar casos de pruebas independientes | @test-**        | 

# Referencias

* `Java Documentation - Selenium Web Driver:` https://www.javatpoint.com/selenium-webdriver
* `Selenium WebDriver:` https://www.selenium.dev/documentation/webdriver/getting_started/first_script/
* `Github:` https://github.com/SeleniumHQ/seleniumhq.github.io/tree/trunk/examples/java/src/test/java/dev/selenium