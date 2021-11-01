DELIMITER $$
CREATE PROCEDURE `select_user_by_email` (IN in_email VARCHAR(50))
BEGIN
	SELECT * FROM user WHERE email = in_email;
END$$
DELIMITER ;