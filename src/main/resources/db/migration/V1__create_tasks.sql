CREATE TABLE tasks (
    id UUID PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    responsible VARCHAR(100) NOT NULL,
    delivery_date TIMESTAMP NOT NULL,
    completed BOOLEAN DEFAULT false NOT NULL
);