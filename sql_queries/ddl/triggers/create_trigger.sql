DELIMITER $$
CREATE TRIGGER add_default_role_if_empty
BEFORE INSERT
ON user
FOR EACH ROW
BEGIN
   IF NEW.fk_user_role IS NULL THEN
		SET NEW.fk_user_role = 6;
    END IF;
END$$
DELIMITER ;