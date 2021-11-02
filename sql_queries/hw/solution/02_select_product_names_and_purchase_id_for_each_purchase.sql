SELECT p.product_name, pp.purchase_id FROM product p
JOIN purchase_product pp
ON p.id = pp.product_id;