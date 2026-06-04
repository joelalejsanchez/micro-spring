-- table company
CREATE TABLE IF NOT EXISTS company (
    id SERIAL PRIMARY KEY,
    "name" VARCHAR(32) NOT NULL UNIQUE,
    founder VARCHAR(128),
    logo VARCHAR(255),
    foundation_date DATE
);
-- index for name
create index name_company on company("name");

-- table web_site
CREATE TABLE IF NOT EXISTS web_site (
    id SERIAL PRIMARY KEY,
    id_company BIGINT,
    "name" VARCHAR(32) NOT NULL UNIQUE,
    category VARCHAR(32) NOT NULL,
    description TEXT,
    CONSTRAINT fk_company
        FOREIGN KEY (id_company)
        REFERENCES company(id)
        ON DELETE CASCADE
);