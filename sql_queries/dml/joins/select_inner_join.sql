SELECT u.last_name, r.role_name FROM user u
JOIN role r
ON r.id = u.fk_user_role;