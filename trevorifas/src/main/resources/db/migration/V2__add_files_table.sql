CREATE TABLE files (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   name VARCHAR(100) NOT NULL,
   raffle_id BIGINT NOT NULL,
   created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
   updated_at TIMESTAMP WITHOUT TIME ZONE,
   CONSTRAINT pk_files PRIMARY KEY (id)
);

ALTER TABLE files ADD CONSTRAINT FK_FILES_ON_RAFFLE FOREIGN KEY (raffle_id) REFERENCES raffles (id);