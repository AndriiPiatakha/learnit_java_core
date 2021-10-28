ALTER TABLE `learn_it_db`.`user` ADD COLUMN `money` DECIMAL(15,2) NULL DEFAULT 0 AFTER `fk_user_role`;

UPDATE `learn_it_db`.`user` SET `money` = '1000.75' WHERE (`id` = '00012');
UPDATE `learn_it_db`.`user` SET `money` = '754.28' WHERE (`id` = '00011');
UPDATE `learn_it_db`.`user` SET `money` = '100.25' WHERE (`id` = '00003');
UPDATE `learn_it_db`.`user` SET `money` = '400.60' WHERE (`id` = '00001');