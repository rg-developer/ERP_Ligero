USE erp_ligero

-- Crear los roles iniciales
INSERT INTO roles (name)
VALUES
    ('ADMIN'),
    ('MANAGER'),
    ('EMPLOYEE');

-- Crear el primer usuario administrador
-- Crear los roles iniciales
INSERT INTO roles (name)
VALUES
    ('ADMIN'),
    ('MANAGER'),
    ('EMPLOYEE');

-- Crear el primer usuario administrador
INSERT INTO users (
    username,
    first_name,
    last_name,
    email,
    password,
    role_id,
    active,
    created_at
)
SELECT
    'admin',
    'Administrador',
    'Sistema',
    'admin@erp-ligero.local',
    '$2a$12$rzNPZC9FvC8Yo1IqSzP1weXErLt4nrzJxFkKFz53gvy8eRxRpJOJS',
    r.id,
    TRUE,
    NOW()
FROM roles r
WHERE r.name = 'ADMIN';