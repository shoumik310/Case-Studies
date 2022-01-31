DELIMITER $$

DROP TRIGGER `transaction`.transaction_date_setter;

CREATE TRIGGER transaction_date_setter
BEFORE INSERT
ON library.`transaction`
FOR EACH ROW
BEGIN
	IF NEW.issue_date IS NULL THEN
		SET NEW.issue_date = NOW();
	END IF;
    IF NEW.due_date IS NULL THEN
		SET NEW.due_date = NOW() + INTERVAL 14 DAY;
	END IF;
END$$

CREATE TRIGGER available_book_setter
BEFORE INSERT
ON book
FOR EACH ROW
BEGIN
	SET NEW.available_quantity = NEW.total_quantity;
END$$

-- CREATE TRIGGER book_return
-- BEFORE UPDATE
-- ON transaction
-- FOR EACH ROW
-- BEGIN
-- 	
-- END$$

DELIMITER ;

