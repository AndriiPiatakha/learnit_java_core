SELECT DISTINCT u.email FROM user u
JOIN purchase p 
ON p.fk_purchase_user = u.id;
