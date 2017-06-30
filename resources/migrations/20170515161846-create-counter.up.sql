CREATE TABLE counter

(counter_id     SERIAL      NOT NULL PRIMARY KEY,

 count    INTEGER NOT NULL);

--;;

INSERT INTO counter (count) VALUES (0);
