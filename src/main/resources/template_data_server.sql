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
    `roles`       VARCHAR(200) NOT NULL,
    `permissions` VARCHAR(200) DEFAULT NULL,
    `user_id`     INTEGER     NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `users_to_hc` VALUES
(1, 'tomek', '$2a$10$yZVdAgWG3suGQI033C7O.emzIiJf4o4K.wzxLsrXYQD7z9KIFfUPO', true, 'USER', 'ADD', 1),
(2, 'jan', '$2a$10$zm8PcMsChwxMiNS82hnFhOlwpKMzHdEmu4gNW383kt9dOofjF4NES', true, 'VIEWER', 'ADD', 2),
(3, 'czar', '$2a$10$4J29DXW/W2BMVEzInZ8wPuduiPnsAZh5U2097InJGemW5SOc5uFUi', true, 'ADMIN', 'ADD', 3);


DROP TABLE IF EXISTS `users_app`;

CREATE TABLE `users_app`
(
    `id`          BIGINT      NOT NULL AUTO_INCREMENT,
    `login_name`  VARCHAR(24) NOT NULL,
    `password`    char(60) NOT NULL,
    `roles`       VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `users_app` VALUES
(1, 'frontend', '$2a$10$fusCmo3WQsLjdOiZIm30Y.hdPLsLcPsIO5d3RDEYyv0QYh7iwVJHa', 'MODERATOR'),
(2, 'czar', '$2a$10$V6B96RZal4Ybk9sqggYl2.mq8K62Ek4zlB7YMpxCTUbNjchMCgpoe', 'ADMIN');


    SET FOREIGN_KEY_CHECKS = 1;