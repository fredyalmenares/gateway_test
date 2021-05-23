START TRANSACTION;

INSERT INTO gateway(`serial`, `address`, `name`)
VALUES ('1ABC', '192.147.25.1', 'Gateway1');
INSERT INTO gateway(`serial`, `address`, `name`)
VALUES ('2ABC', '192.147.25.2', 'Gateway2');
INSERT INTO gateway(`serial`, `address`, `name`)
VALUES ('3ABC', '192.147.25.3', 'Gateway3');

INSERT INTO peripheral
(`uid`, `status`, `vendor`)
VALUES (1, 'online', 'vendor1');
INSERT INTO peripheral
(`uid`, `status`, `vendor`)
VALUES (2, 'offline', 'vendor2');
INSERT INTO peripheral
(`uid`, `status`, `vendor`)
VALUES (3, 'offline', 'vendor3');
INSERT INTO peripheral
(`uid`, `status`, `vendor`)
VALUES (4, 'offline', 'vendor4');
INSERT INTO peripheral
(`uid`, `status`, `vendor`)
VALUES (5, 'offline', 'vendor5');
INSERT INTO peripheral
(`uid`, `status`, `vendor`)
VALUES (6, 'offline', 'vendor6');
INSERT INTO peripheral
(`uid`, `status`, `vendor`)
VALUES (7, 'offline', 'vendor7');
INSERT INTO peripheral
(`uid`, `status`, `vendor`)
VALUES (8, 'offline', 'vendor8');
INSERT INTO peripheral
(`uid`, `status`, `vendor`)
VALUES (9, 'offline', 'vendor9');
INSERT INTO peripheral
(`uid`, `status`, `vendor`)
VALUES (10, 'offline', 'vendor10');
INSERT INTO peripheral
(`uid`, `status`, `vendor`)
VALUES (11, 'online', 'vendor11');
INSERT INTO peripheral
(`uid`, `status`, `vendor`)
VALUES (12, 'offline', 'vendor12');
INSERT INTO peripheral
(`uid`, `status`, `vendor`)
VALUES (13, 'online', 'vendor13');
INSERT INTO peripheral
(`uid`, `status`, `vendor`)
VALUES (14, 'offline', 'vendor14');
INSERT INTO peripheral
(`uid`, `status`, `vendor`)
VALUES (15, 'online', 'vendor15');
INSERT INTO peripheral
(`uid`, `status`, `vendor`)
VALUES (16, 'offline', 'vendor16');
INSERT INTO peripheral
(`uid`, `status`, `vendor`)
VALUES (17, 'online', 'vendor17');
INSERT INTO peripheral
(`uid`, `status`, `vendor`)
VALUES (18, 'offline', 'vendor18');
INSERT INTO peripheral
(`uid`, `status`, `vendor`)
VALUES (19, 'online', 'vendor19');
INSERT INTO peripheral
(`uid`, `status`, `vendor`)
VALUES (20, 'offline', 'vendor20');
INSERT INTO peripheral
(`uid`, `status`, `vendor`)
VALUES (21, 'online', 'vendor21');
INSERT INTO peripheral
(`uid`, `status`, `vendor`)
VALUES (22, 'offline', 'vendor22');
INSERT INTO peripheral
(`uid`, `status`, `vendor`)
VALUES (23, 'online', 'vendor23');
INSERT INTO peripheral
(`uid`, `status`, `vendor`)
VALUES (24, 'offline', 'vendor24');
INSERT INTO peripheral
(`uid`, `status`, `vendor`)
VALUES (25, 'online', 'vendor25');
INSERT INTO peripheral
(`uid`, `status`, `vendor`)
VALUES (26, 'offline', 'vendor26');
INSERT INTO peripheral
(`uid`, `status`, `vendor`)
VALUES (27, 'online', 'vendor27');
INSERT INTO peripheral
(`uid`, `status`, `vendor`)
VALUES (28, 'offline', 'vendor28');
INSERT INTO peripheral
(`uid`, `status`, `vendor`)
VALUES (29, 'online', 'vendor29');
INSERT INTO peripheral
(`uid`, `status`, `vendor`)
VALUES (30, 'offline', 'vendor30');

COMMIT;