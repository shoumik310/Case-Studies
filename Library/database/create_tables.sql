CREATE SCHEMA `library` DEFAULT CHARACTER SET utf8mb4 ;
USE library;

CREATE TABLE `library`.`membership`(
	`id` INT NOT NULL AUTO_INCREMENT,
    `name`  VARCHAR(10) NOT NULL,
    `borrow_limit` INT NOT NULL,
    `duration` VARCHAR(20) NOT NULL,
    `price` DECIMAL(7,2),
	PRIMARY KEY(id)
);

CREATE TABLE `library`.`user`(
	`id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
	`first_name` VARCHAR(45) NOT NULL,
    `last_name` VARCHAR(45) NOT NULL,
    `email` VARCHAR(50) NOT NULL,
    `password` VARCHAR(20) NOT NULL,
    `fine` INT DEFAULT 0,
    `user_type` VARCHAR(10),
    `fk_user_membership` INT,
    `borrowed` INT,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_user_membership` FOREIGN KEY (`fk_user_membership`)
		REFERENCES `library`.`membership` (`id`)
		ON DELETE RESTRICT ON UPDATE RESTRICT,
    UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE
);

CREATE TABLE `author`(
	`id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(45) NOT NULL,
    `last_name`	VARCHAR(45) NOT NULL,
    PRIMARY KEY(`id`)
);

CREATE TABLE `book`(
	`id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(45) NOT NULL,
    `author_id` INT UNSIGNED NOT NULL,
    `price` DECIMAL(7,2),
    `total_quantity` INT DEFAULT 0,
    `available_quantity` INT UNSIGNED DEFAULT 0,
	PRIMARY KEY(`id`),
    CONSTRAINT FOREIGN KEY `fk_book_author`(`author_id`) 
		REFERENCES `library`.`author`(`id`)
        ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `transaction`(
	`id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `user_id` INT UNSIGNED NOT NULL,
    `book_id` INT UNSIGNED NOT NULL,
    `issue_date` DATE,
    `due_date` DATE,
    `return_date` DATE NULL,
    PRIMARY KEY(`id`),
    CONSTRAINT FOREIGN KEY `fk_trans_user`(`user_id`) 
		REFERENCES `library`.`user`(`id`)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT FOREIGN KEY `fk_trans_book`(`book_id`) 
		REFERENCES `library`.`book`(`id`)
        ON DELETE RESTRICT ON UPDATE RESTRICT
);


