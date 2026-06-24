# miapi — API simple en Spring Boot

API REST mínima desarrollada en Spring Boot (Java 17, Maven) lista para
desplegarse de forma manual en [Render](https://render.com/).

## Endpoints

| Método | Ruta                  | Descripción                          | Ejemplo                         |
|--------|-----------------------|--------------------------------------|---------------------------------|
| GET    | `/`                   | Estado de la API                     | `/`                             |
| GET    | `/api/saludo`         | Saludo con parámetro `nombre`        | `/api/saludo?nombre=Juan`       |
| GET    | `/api/suma/{a}/{b}`   | Suma dos números                     | `/api/suma/5/3`                 |

## Ejecutar localmente

```bash
./mvnw spring-boot:run
```

Luego abre: http://localhost:8080/

## Compilar el .jar

```bash
./mvnw clean package -DskipTests
```

El artefacto queda en `target/miapi-0.0.1-SNAPSHOT.jar`.

## Desplegar en Render (build nativo con Maven)

1. Sube este proyecto a un repositorio de GitHub.
2. En Render: **New + → Web Service** y conecta el repositorio.
3. Configura:
   - **Language**: Java
   - **Build Command**: `./mvnw clean package -DskipTests`
   - **Start Command**: `java -jar target/miapi-0.0.1-SNAPSHOT.jar`
   - **Instance Type**: Free
4. **Create Web Service**. Render compila y publica una URL pública.

> La app lee el puerto desde la variable de entorno `PORT` que Render asigna
> automáticamente (configurado en `application.properties`).
