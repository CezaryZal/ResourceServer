CREATE
DATABASE IF NOT EXISTS `user_server`;

SET FOREIGN_KEY_CHECKS = 0;


DROP TABLE IF EXISTS `users_hc`;

CREATE TABLE `users_hc`
(
    `id`          BIGINT      NOT NULL AUTO_INCREMENT,
    `login_name`  VARCHAR(24) NOT NULL,
    `password`    char(60) NOT NULL,
    `approved`      BOOLEAN     DEFAULT FALSE,
    `roles`       VARCHAR(200) NOT NULL,
    `permissions` VARCHAR(200) DEFAULT NULL,
    `user_id`     INTEGER     DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `users_hc` VALUES
(1, 'tomek', '$2a$14$YMpWNeW5XrzvJnI/TuosWenErLQght/C56DhIE5BNkUs296PvPFLC', true, 'USER', 'ADD', 2),
(2, 'janek', '$2a$14$qvPKR4sT9jI1svoxv/IbaOC0hQJ9sHDUkW5W9lsBCXKF84oWglyDa', true, 'VIEWER', 'ADD', 1),
(3, 'czar', '$2a$14$XHvkIs6TbxrBM9msB31DI.M9OLHkfTDBBKcIsG56fLB0FZ3DtgB7a', true, 'ADMIN', 'ADD', 3);


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