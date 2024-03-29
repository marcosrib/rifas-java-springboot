CREATE TABLE points (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   user_id BIGINT,
   raffle_id BIGINT,
   point VARCHAR(10) NOT NULL,
   value DECIMAL(10, 2) NOT NULL,
   point_selected BOOLEAN NOT NULL,
   create_at TIMESTAMP WITHOUT TIME ZONE,
   updated_at TIMESTAMP WITHOUT TIME ZONE,
   deleted_at TIMESTAMP WITHOUT TIME ZONE,
   CONSTRAINT pk_points PRIMARY KEY (id)
);

CREATE TABLE profiles (
  id INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   name VARCHAR(30) NOT NULL,
   CONSTRAINT pk_profiles PRIMARY KEY (id)
);

CREATE TABLE raffles (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
   updated_at TIMESTAMP WITHOUT TIME ZONE,
   raffle_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
   description VARCHAR(255) NOT NULL,
   title VARCHAR(50) NOT NULL,
   image_name VARCHAR(255),
   point_quantity INTEGER NOT NULL,
   valuer DECIMAL(10, 2) NOT NULL,
   type_raffle VARCHAR(50),
   user_id BIGINT NOT NULL,
   CONSTRAINT pk_raffles PRIMARY KEY (id)
);

CREATE TABLE user_profiles (
  profile_id INTEGER NOT NULL,
   user_id BIGINT NOT NULL,
   CONSTRAINT pk_user_profiles PRIMARY KEY (profile_id, user_id)
);

CREATE TABLE users (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   name VARCHAR(100) NOT NULL,
   username VARCHAR(100) NOT NULL,
   email VARCHAR(100) NOT NULL,
   password VARCHAR(255) NOT NULL,
   status VARCHAR(255),
   created_at TIMESTAMP WITHOUT TIME ZONE,
   updated_at TIMESTAMP WITHOUT TIME ZONE,
   deleted_at TIMESTAMP WITHOUT TIME ZONE,
   CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE users ADD CONSTRAINT uc_users_email UNIQUE (email);

ALTER TABLE points ADD CONSTRAINT FK_POINTS_ON_RAFFLE FOREIGN KEY (raffle_id) REFERENCES raffles (id);

ALTER TABLE points ADD CONSTRAINT FK_POINTS_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE raffles ADD CONSTRAINT FK_RAFFLES_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE user_profiles ADD CONSTRAINT fk_usepro_on_profile_entity FOREIGN KEY (profile_id) REFERENCES profiles (id);

ALTER TABLE user_profiles ADD CONSTRAINT fk_usepro_on_user_entity FOREIGN KEY (user_id) REFERENCES users (id);