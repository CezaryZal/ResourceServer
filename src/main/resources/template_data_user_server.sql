CREATE
DATABASE IF NOT EXISTS `user_server`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `userToDb`;

CREATE TABLE `userToDb`
(
    `id`          BIGINT      NOT NULL AUTO_INCREMENT,
    `login_name`  VARCHAR(24) NOT NULL,
    `password`    VARCHAR(24) NOT NULL,
    `approved`      BOOLEAN     DEFAULT FALSE,
    `roles`       VARCHAR(45) NOT NULL,
    `permissions` VARCHAR(45) DEFAULT NULL,
    `user_id`     INTEGER     NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `userToDb` VALUES
(1, 'tomek', 'tom', true, 'USER', null, 1),
(2, 'janek', 'jan', true, 'VIEWER', null, 2),
(3, 'kris', 'admin123', true, 'ADMIN', null, 3);

    SET FOREIGN_KEY_CHECKS = 1;