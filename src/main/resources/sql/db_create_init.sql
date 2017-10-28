DROP TABLE IF EXISTS `T_USER`;

CREATE TABLE `T_USER` (
  `id`        INT          NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(100) NOT NULL,
  `firstName` VARCHAR(100) NOT NULL,
  `lastName`  VARCHAR(100) NOT NULL,
  `yearBorn`  INT          NOT NULL,
  `email`     VARCHAR(100) NOT NULL,
  `phone`     VARCHAR(100) NOT NULL,
  `address`   VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`)
);

# 参数的值用单冒号包括，字段名用点号（按键1前面的按键）
INSERT INTO `T_USER` (`userName`, `firstName`, `lastName`, `yearBorn`, `email`, `phone`, `address`)
VALUES ('kwei', 'Kevin', 'Wei', 1989, 'weicee@foxmail.com', '123456', '937 Greenbriar Ave');

INSERT INTO `T_USER` (`userName`, `firstName`, `lastName`, `yearBorn`, `email`, `phone`, `address`)
VALUES ('lulu', 'Mike', 'Lu', 1990, 'mikelu@gmail.com', '123456', '1001 Kanata Ave');

INSERT INTO `T_USER` (`userName`, `firstName`, `lastName`, `yearBorn`, `email`, `phone`, `address`)
VALUES ('brh', 'Bruce', 'He', 1992, 'brucehe@qq.com', '666666', '2202 Browns Ave');