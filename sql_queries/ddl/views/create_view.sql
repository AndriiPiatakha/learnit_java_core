CREATE VIEW `user_email_role_view` AS
SELECT u.email, r.role_name FROM user u
JOIN role r
ON r.id = u.fk_user_role;