CREATE TABLE usernamesuggestion ( 
        id INT(64) NOT NULL AUTO_INCREMENT, 
        username VARCHAR(25),
        
 PRIMARY KEY (`id`));
 
 CREATE TABLE restrictedWords ( 
        id INT(64) NOT NULL AUTO_INCREMENT, 
        word VARCHAR(25),
        
 PRIMARY KEY (`id`));