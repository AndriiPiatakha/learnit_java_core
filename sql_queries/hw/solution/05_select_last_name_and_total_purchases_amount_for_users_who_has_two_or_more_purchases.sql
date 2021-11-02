SELECT u.last_name, COUNT(*) AS purchases_amount FROM user u 
JOIN purchase p 
ON u.id = p.fk_purchase_user
GROUP BY u.last_name
HAVING purchases_amount >= 2;