SELECT COUNT(*) AS amount, last_name FROM user GROUP BY last_name;

SELECT COUNT(*) amount, last_name FROM user GROUP BY last_name HAVING amount >= 2;