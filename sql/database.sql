CREATE DATABASE IF NOT EXISTS playervault ;
use playervault;

CREATE TABLE IF NOT EXISTS videojuego (
    id INT AUTO_INCREMENT,
    titulo VARCHAR(128) NOT NULL,
    genero VARCHAR(128) NOT NULL,
    plataforma VARCHAR(20) NOT NULL,
    estado ENUM('PENDIENTE','JUGANDO',"PASADO","ABANDONADO") NOT NULL DEFAULT("PENDIENTE"),
    puntuacion DECIMAL(2,1) DEFAULT NULL,
    horas_jugadas DECIMAL(10,1) DEFAULT 0,
    fecha_lanzamiento YEAR,

    CONSTRAINT pk_id PRIMARY KEY (id),
    CONSTRAINT chk_horas CHECK (horas_jugadas >= 0),
    CONSTRAINT chk_puntuacion CHECK (puntuacion BETWEEN 0 AND 10)
);

INSERT INTO videojuego (titulo, genero, plataforma, estado, puntuacion, horas_jugadas, fecha_lanzamiento) VALUES ("The Legend Of Zelda Ocarina Of Time", "Aventura", "Nintendo Switch 2", "JUGANDO", 9.6, 10.4, 2026);
INSERT INTO videojuego (titulo, genero, plataforma, estado, puntuacion, horas_jugadas, fecha_lanzamiento) VALUES ("Super Mario Wonder", "Plataformas", "Nintendo Switch 2", "PASADO", 9.6, 15.3, 2023);
INSERT INTO videojuego (titulo, genero, plataforma, puntuacion, horas_jugadas, fecha_lanzamiento) VALUES ("Doki Doki Literature Club", "Novela visual", "PC", 6.6, 12.3, 2017);

UPDATE videojuego set titulo = "GTA 6", plataforma = "PS5", fecha_lanzamiento = 2026 where id = 2;
DELETE FROM videojuego where id = 2;

