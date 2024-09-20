INSERT INTO table_learning_module (name, description, in_maintenance) VALUES ('Vocabulário', 'Módulo focado no aumento de vocabulário', true);

-- Inserindo um nível de dificuldade na tabela 'table_difficulty_level' referenciando o módulo recém-criado
-- Assumindo que o ID do módulo criado automaticamente é 1
INSERT INTO table_difficulty_level (name, learning_module_id) VALUES ('Iniciante', 1);

-- Inserindo um usuário na tabela 'table_user'
--INSERT INTO table_users (name, email, password) VALUES ('Carlos', 'Carlosedu44@outlook.com', '12345');

-- Inserindo uma lição na tabela 'table_lesson', referenciando o 'user_id' e 'difficulty_level_id'
-- Assumindo que o ID do nível de dificuldade criado automaticamente é 1 e o ID do usuário é 1
-- INSERT INTO table_lesson (title, status, available, user_id, difficulty_level_id) VALUES ('Present Simple 1', 'pending', true, 1, 1);

-- Inserindo progresso na tabela 'table_progress', referenciando o 'lesson_id'
-- Assumindo que o ID da lição criada automaticamente é 1
-- INSERT INTO table_progress (percentual, lesson_id) VALUES (0, 1);
