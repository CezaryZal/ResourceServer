CREATE
DATABASE IF NOT EXISTS 'user_server';

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user`
(
    `id`          BIGINT      NOT NULL AUTO_INCREMENT,
    `login_name`  VARCHAR(24) NOT NULL,
    `password`    VARCHAR(24) NOT NULL,
    `active`      BOOLEAN     DEFAULT FALSE,
    `roles`       VARCHAR(45) NOT NULL,
    `permissions` VARCHAR(45) DEFAULT NULL,
    `user_id`     INTEGER     NOT NULL,
    PRIMARY KEY ('id')
) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `user` VALUES
(1, 'tomek', 'tom', true, 'USER', null, 1),
(1, 'janek', 'jan', true, 'VIEWER', null, 2),
(1, 'kris', 'admin123', true, 'ADMIN', null, 3);

    SET FOREIGN_KEY_CHECKS = 1;