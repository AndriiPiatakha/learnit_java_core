SET @counter = 1;
CALL increment(@counter, 3); -- 4
CALL increment(@counter, 5); # 9
CALL increment(@counter, 3); /* 12 */
SELECT @counter; -- 12