-- Insertar roles
INSERT INTO roles (role) VALUES ('ADMIN');
INSERT INTO roles (role) VALUES ('USER');

-- Insertar usuarios
INSERT INTO users (email, password, roles)
VALUES ('admin@visionariosunidos.com', 'adminpassword', (SELECT id FROM roles WHERE role = 'ADMIN'));

INSERT INTO users (email, password, roles)
VALUES ('user@visionariosunidos.com', 'userpassword', (SELECT id FROM roles WHERE role = 'USER'));

-- Insertar mensajes
-- Nota: Asegúrate de que los id de los usuarios son correctos (en este caso asumimos que 1 es admin y 2 es user)
INSERT INTO Message (user_id)
SELECT id FROM users WHERE email = 'admin@visionariosunidos.com';

INSERT INTO Message (user_id)
SELECT id FROM users WHERE email = 'user@visionariosunidos.com';
