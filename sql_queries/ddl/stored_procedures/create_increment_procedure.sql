DELIMITER $$
CREATE PROCEDURE `increment` (INOUT counter INT, IN increment INT)
BEGIN
	SET counter = counter + increment;
END$$
DELIMITER ;