-- Insertar roles
INSERT INTO Role (role) VALUES ('ADMIN');
INSERT INTO Role (role) VALUES ('USER');

-- Insertar usuarios
INSERT INTO AppUser (email, password, role)
VALUES ('admin@visionariosunidos.com', 'adminpassword', (SELECT id FROM Role WHERE role = 'ADMIN'));

INSERT INTO AppUser (email, password, role)
VALUES ('user@visionariosunidos.com', 'userpassword', (SELECT id FROM Role WHERE role = 'USER'));

-- Insertar mensajes
-- Nota: Asegúrate de que los id de los usuarios son correctos (en este caso asumimos que 1 es admin y 2 es user)
INSERT INTO Message (user_id)
SELECT id FROM AppUser WHERE email = 'admin@visionariosunidos.com';

INSERT INTO Message (user_id)
SELECT id FROM AppUser WHERE email = 'user@visionariosunidos.com';
