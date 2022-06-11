CREATE SEQUENCE IF NOT EXISTS hibernate_sequence START 1;

CREATE TABLE IF NOT EXISTS task (
    id int8 NOT NULL,
    name varchar(255) NOT NULL,
    description varchar(255) NOT NULL,
    completed bool NOT NULL,
    deleted bool NOT NULL,

    CONSTRAINT task_id_pkey PRIMARY KEY (id)
);