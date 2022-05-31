CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
DROP TABLE IF EXISTS app_folders CASCADE;
CREATE TABLE IF NOT EXISTS app_folders(
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    parent_id UUID,
    name TEXT NOT NUlL,
    content jsonb,
    date_created TIMESTAMP DEFAULT now(),
    last_updated TIMESTAMP DEFAULT now()
);