DELIMITER $$  
CREATE FUNCTION user_status(money DECIMAL(15, 2))   
RETURNS VARCHAR(20)  
DETERMINISTIC  
BEGIN  
    DECLARE user_status VARCHAR(20);  
    IF money < 100 THEN  
        SET user_status = 'regular_user';  
    ELSEIF (money >= 100 AND   
            money < 500) THEN  
        SET user_status = 'important_user';  
    ELSEIF money >= 500 THEN  
        SET user_status = 'vip_user';  
    END IF;  
    -- return the user status
    RETURN (user_status);  
END$$  
DELIMITER ;  