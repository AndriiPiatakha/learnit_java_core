DELIMITER $$
CREATE PROCEDURE `select_average_money` (OUT avg_money INT)
BEGIN
	SELECT AVG(money) INTO avg_money FROM user;
END$$
DELIMITER ;