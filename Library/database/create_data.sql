USE library; 

LOCK TABLES `author` WRITE;
INSERT INTO author(first_name, last_name) VALUES ('Dan','Brown'), ('Rick','Riordan'), 
													('Amish','Tripathi');
UNLOCK TABLES;

LOCK TABLES `book` WRITE;
INSERT INTO book(title, author_id, price, total_quantity) VALUES ('Da Vinci Code', 1,166.25,3 ), 
											('Percy Jackson and the Lightning Thief', 2,276.00,1 ),
											('Angels And Demons', 1,232.75, 5 ),
											('Inferno', 1,74.40,3 ),
											('Heroes of Olympus: The Lost Hero', 2,299.00,4 ),
											('Immortals of Mehula', 3,325.00,1 );
UNLOCK TABLES;