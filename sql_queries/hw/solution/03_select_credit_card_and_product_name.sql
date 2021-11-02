SELECT u.credit_card, p.product_name FROM user u 
JOIN purchase pur 
ON pur.fk_purchase_user = u.id 
JOIN purchase_product pp
ON pp.purchase_id = pur.id
JOIN product p 
ON p.id = pp.product_id; 
