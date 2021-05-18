DROP TABLE IF EXISTS TBL_RAAGAS;
 
CREATE TABLE TBL_RAAGAS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  raaga_name VARCHAR(250) NOT NULL,
  raaga_timing VARCHAR(250) NOT NULL,
  raaga_aarohana VARCHAR(250) NOT NULL,
  raaga_avarohana VARCHAR(250) NOT NULL
  
);


create table user(
  id INT AUTO_INCREMENT  PRIMARY KEY,
  username VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL
);