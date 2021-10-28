SELECT * FROM user u
LEFT JOIN role r ON u.fk_user_role = r.id
UNION
SELECT * FROM user u
RIGHT JOIN role r ON u.fk_user_role = r.id