# PlayerVault

PlayerVault es una aplicación móvil para Android que permite llevar el registro de tu colección de videojuegos: los que tienes pendientes, a los que estás jugando, los que has terminado y los que has abandonado.

Está pensada para cualquier jugador que quiera tener toda su colección organizada en un solo sitio, con sus puntuaciones y horas de juego.

## Funcionalidades

### Primera versión

- Registro e inicio de sesión de usuarios, de forma que cada persona tenga su propia colección.
- Búsqueda de videojuegos a través de una API externa, para añadirlos a la colección sin tener que introducir los datos a mano.
- Gestión de la colección: añadir, consultar, editar y eliminar videojuegos.
- Seguimiento del estado de cada videojuego: `PENDIENTE`, `JUGANDO`, `PASADO` o `ABANDONADO`.
- Puntuación (de 0 a 10) y horas jugadas por videojuego.

### Próximamente

- Filtros y búsqueda dentro de la colección (por estado, plataforma o género).
- Estadísticas: horas totales, puntuación media, videojuegos terminados por año, etc.
- Portadas de los videojuegos.
- Lista de deseos.

## Arquitectura

El proyecto se divide en dos partes:

```
App Android (Kotlin + Jetpack Compose)
            │
            │  HTTP / JSON
            ▼
   API REST (Java + Spring Boot)
            │
            ▼
         MySQL
```

- **App Android**: interfaz de usuario. Se comunica únicamente con la API REST y nunca accede directamente a la base de datos.
- **API REST**: contiene la lógica de negocio, la autenticación de usuarios y el acceso a la base de datos y a la API externa de videojuegos.
- **Base de datos**: MySQL, donde se guardan los usuarios y sus colecciones.

## Tecnologías

| Parte          | Tecnologías                          |
|----------------|--------------------------------------|
| App móvil      | Kotlin, Jetpack Compose, Android Studio |
| Backend        | Java 21, Spring Boot, Maven          |
| Base de datos  | MySQL                                |
| Despliegue     | Docker                               |

## Estado del proyecto

El proyecto está en desarrollo.

- [x] Diseño de la base de datos (tabla `videojuego`).
- [x] Backend inicial en Java con JDBC: CRUD completo de videojuegos.
- [ ] Migración del backend a Spring Boot como API REST.
- [ ] Registro e inicio de sesión de usuarios.
- [ ] Integración con una API externa de videojuegos.
- [ ] App Android con Kotlin y Jetpack Compose.
- [ ] Contenedores Docker para el backend y la base de datos.

## Estructura del repositorio

Estructura actual:

```
PlayerVault/
├── sql/
│   └── database.sql          # Creación de la base de datos y datos de ejemplo
├── src/main/java/org/playervault/
│   ├── App.java              # Punto de entrada (menú de pruebas por consola)
│   ├── model/                # Clases del modelo (Videojuego, Estado)
│   ├── mysql/                # Acceso a datos (VideojuegoDAO)
│   └── util/                 # Conexión a la base de datos y menú
└── pom.xml
```

## Modelo de datos

Tabla `videojuego`:

| Campo               | Tipo            | Descripción                                          |
|---------------------|-----------------|------------------------------------------------------|
| `id`                | INT             | Identificador (autoincremental)                      |
| `titulo`            | VARCHAR(128)    | Título del videojuego                                |
| `genero`            | VARCHAR(128)    | Género                                               |
| `plataforma`        | VARCHAR(20)     | Plataforma en la que se juega                        |
| `estado`            | ENUM            | `PENDIENTE`, `JUGANDO`, `PASADO` o `ABANDONADO`      |
| `puntuacion`        | DECIMAL(3,1)    | Puntuación de 0 a 10 (opcional)                      |
| `horas_jugadas`     | DECIMAL(10,1)   | Horas jugadas (0 por defecto)                        |
| `fecha_lanzamiento` | YEAR            | Año de lanzamiento (opcional)                        |

## Instalación y ejecución

### Requisitos

- Java 21
- Maven
- MySQL 8 (instalado en el equipo o mediante Docker)
- Un IDE para Java, como IntelliJ IDEA

### 1. Clonar el repositorio

```bash
git clone https://github.com/HectorMA06/PlayerVault.git
cd PlayerVault
```

### 2. Levantar MySQL

**Opción A: con Docker**

```bash
docker run --name playervault-mysql \
  -e MYSQL_ROOT_PASSWORD=tu_contraseña \
  -p 3307:3306 \
  -d mysql:8
```

**Opción B: con una instalación local de MySQL**

Asegúrate de que el servidor de MySQL está en marcha y anota el puerto en el que escucha (por defecto, `3306`).

### 3. Crear la base de datos

Ejecuta el script `sql/database.sql`, que crea la base de datos `playervault`, la tabla `videojuego` y algunos datos de ejemplo.

Con Docker:

```bash
docker exec -i playervault-mysql mysql -uroot -p < sql/database.sql
```

Con MySQL local:

```bash
mysql -uroot -p < sql/database.sql
```

### 4. Configurar la conexión

Crea un archivo `database-config.properties` en la raíz del proyecto con este contenido, ajustando el puerto, el usuario y la contraseña:

```properties
db.url=jdbc:mysql://127.0.0.1:3307/playervault
db.user=root
db.password=tu_contraseña
```

Este archivo está incluido en el `.gitignore` para que las credenciales no se suban nunca al repositorio.

### 5. Ejecutar

Abre el proyecto en el IDE y ejecuta la clase `org.playervault.App`. Se mostrará un menú por consola para probar las operaciones del CRUD.

## Autor

Desarrollado por [@HectorMA06](https://github.com/HectorMA06).

## Licencia

Este proyecto no tiene licencia de código abierto. Todos los derechos reservados.
