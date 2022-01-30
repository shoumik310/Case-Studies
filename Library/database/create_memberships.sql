USE library; 

LOCK TABLES `membership` WRITE;
INSERT INTO membership (`name`, `borrow_limit`, `duration`, `price`) VALUES ('BRONZE',3,'monthly',100.0),
																		('SILVER',5,'semi-anually',400.0),
																		('GOLD',7,'anually',700.0),
																		('DIAMOND',4,'lifetime',2000.0);
													
UNLOCK TABLES;