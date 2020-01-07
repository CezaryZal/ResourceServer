CREATE
DATABASE IF NOT EXISTS `user_server`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `users_to_hc`;

CREATE TABLE `users_to_hc`
(
    `id`          BIGINT      NOT NULL AUTO_INCREMENT,
    `login_name`  VARCHAR(24) NOT NULL,
    `password`    char(60) NOT NULL,
    `approved`      BOOLEAN     DEFAULT FALSE,
    `roles`       VARCHAR(45) NOT NULL,
    `permissions` VARCHAR(45) DEFAULT NULL,
    `user_id`     INTEGER     NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `users_to_hc` VALUES
(1, 'tomek', 'tom', true, 'USER', null, 1),
(2, 'janek', 'jan', true, 'VIEWER', null, 2),
(3, 'czar', '$2a$10$PgvbUQsnWj4oj3bq0tIcmO3QoEWJunCekgDV3g.LnC6VkU9tTJf8C', true, 'ADMIN', 'ADD', 3);

-- {bcrypt}$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K'

    SET FOREIGN_KEY_CHECKS = 1;