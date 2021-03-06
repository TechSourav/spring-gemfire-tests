DROP TABLE IF EXISTS APP.Users;

CREATE TABLE APP.Users (
  username VARCHAR(50) PRIMARY KEY,
  email VARCHAR(100),
  active VARCHAR(5) DEFAULT 'true',
  since TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
