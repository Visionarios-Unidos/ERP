-- Insertar roles
INSERT INTO roles (role) VALUES ('ADMIN');
INSERT INTO roles (role) VALUES ('USER');

-- Insertar usuarios
INSERT INTO users (email, password, role_id)
VALUES ('admin@visionariosunidos.com', '$2a$12$gFSLmRLKil1/WeiEjT8Ej.Nf30SOq85VnfqucXG4Z7AyFtiuafyH2', (SELECT id FROM roles WHERE role = 'ADMIN'));

INSERT INTO users (email, password, role_id)
VALUES ('user@visionariosunidos.com', '$2a$12$EIYYGDu8HletD0PETVeRJ.hRMyTcf9CM3SgBFNU5kPrrNnbMOFwcS', (SELECT id FROM roles WHERE role = 'USER'));

-- Insertar datos para la entidad Project
INSERT INTO project (name, description) VALUES
('Project A', 'Este es el primer proyecto, relacionado con el desarrollo de una API RESTful.'),
('Project B', 'Un proyecto enfocado en la creación de una aplicación de gestión de usuarios.'),
('Project C', 'Este proyecto está relacionado con la creación de una plataforma de e-commerce.');

-- Insertar datos para la entidad Issue
INSERT INTO issue (name, description, closed, created_at, project_id) VALUES
('Problema A1', 'Error en la autenticación de usuarios en la API', false, NOW(), 1),
('Problema A2', 'Fallo en la carga de datos en el endpoint de productos', false, NOW(), 1),
('Problema B1', 'Bug en la validación de formularios de registro', true, NOW(), 2),
('Problema B2', 'El sistema no envía correos de confirmación', false, NOW(), 2),
('Problema C1', 'Error al procesar pagos en la plataforma de e-commerce', false, NOW(), 3);
