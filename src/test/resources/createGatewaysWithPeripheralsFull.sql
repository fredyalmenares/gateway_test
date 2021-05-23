START TRANSACTION;

INSERT INTO gateway(`serial`, `address`, `name`)
VALUES ('1ABC', '192.147.25.1', 'Gateway1');

INSERT INTO peripheral
    (`uid`, `status`, `vendor`, `gateway_serial`)
VALUES (1, 'online', 'vendor1', '1ABC');
INSERT INTO peripheral
    (`uid`, `status`, `vendor`, `gateway_serial`)
VALUES (2, 'offline', 'vendor2', '1ABC');
INSERT INTO peripheral
    (`uid`, `status`, `vendor`, `gateway_serial`)
VALUES (3, 'offline', 'vendor3', '1ABC');
INSERT INTO peripheral
    (`uid`, `status`, `vendor`, `gateway_serial`)
VALUES (4, 'offline', 'vendor4', '1ABC');
INSERT INTO peripheral
    (`uid`, `status`, `vendor`, `gateway_serial`)
VALUES (5, 'offline', 'vendor5', '1ABC');
INSERT INTO peripheral
    (`uid`, `status`, `vendor`, `gateway_serial`)
VALUES (6, 'offline', 'vendor6', '1ABC');
INSERT INTO peripheral
    (`uid`, `status`, `vendor`, `gateway_serial`)
VALUES (7, 'offline', 'vendor7', '1ABC');
INSERT INTO peripheral
    (`uid`, `status`, `vendor`, `gateway_serial`)
VALUES (8, 'offline', 'vendor8', '1ABC');
INSERT INTO peripheral
    (`uid`, `status`, `vendor`, `gateway_serial`)
VALUES (9, 'offline', 'vendor9', '1ABC');
INSERT INTO peripheral
    (`uid`, `status`, `vendor`, `gateway_serial`)
VALUES (10, 'offline', 'vendor10', '1ABC');

INSERT INTO gateway(`serial`, `address`, `name`)
VALUES ('2ABC', '192.147.25.2', 'Gateway2');

INSERT INTO peripheral
    (`uid`, `status`, `vendor`, `gateway_serial`)
VALUES (11, 'online', 'vendor11', '2ABC');
INSERT INTO peripheral
    (`uid`, `status`, `vendor`, `gateway_serial`)
VALUES (12, 'offline', 'vendor12', '2ABC');
INSERT INTO peripheral
    (`uid`, `status`, `vendor`, `gateway_serial`)
VALUES (13, 'online', 'vendor13', '2ABC');
INSERT INTO peripheral
    (`uid`, `status`, `vendor`, `gateway_serial`)
VALUES (14, 'offline', 'vendor14', '2ABC');
INSERT INTO peripheral
    (`uid`, `status`, `vendor`, `gateway_serial`)
VALUES (15, 'online', 'vendor15', '2ABC');
INSERT INTO peripheral
    (`uid`, `status`, `vendor`, `gateway_serial`)
VALUES (16, 'offline', 'vendor16', '2ABC');
INSERT INTO peripheral
    (`uid`, `status`, `vendor`, `gateway_serial`)
VALUES (17, 'online', 'vendor17', '2ABC');
INSERT INTO peripheral
    (`uid`, `status`, `vendor`, `gateway_serial`)
VALUES (18, 'offline', 'vendor18', '2ABC');
INSERT INTO peripheral
    (`uid`, `status`, `vendor`, `gateway_serial`)
VALUES (19, 'online', 'vendor19', '2ABC');
INSERT INTO peripheral
    (`uid`, `status`, `vendor`, `gateway_serial`)
VALUES (20, 'offline', 'vendor20', '2ABC');

INSERT INTO gateway(`serial`, `address`, `name`)
VALUES ('3ABC', '192.147.25.3', 'Gateway3');

INSERT INTO peripheral
    (`uid`, `status`, `vendor`, `gateway_serial`)
VALUES (21, 'online', 'vendor21', '3ABC');
INSERT INTO peripheral
    (`uid`, `status`, `vendor`, `gateway_serial`)
VALUES (22, 'offline', 'vendor22', '3ABC');
INSERT INTO peripheral
    (`uid`, `status`, `vendor`, `gateway_serial`)
VALUES (23, 'online', 'vendor23', '3ABC');
INSERT INTO peripheral
    (`uid`, `status`, `vendor`, `gateway_serial`)
VALUES (24, 'offline', 'vendor24', '3ABC');
INSERT INTO peripheral
    (`uid`, `status`, `vendor`, `gateway_serial`)
VALUES (25, 'online', 'vendor25', '3ABC');
INSERT INTO peripheral
    (`uid`, `status`, `vendor`, `gateway_serial`)
VALUES (26, 'offline', 'vendor26', '3ABC');
INSERT INTO peripheral
    (`uid`, `status`, `vendor`, `gateway_serial`)
VALUES (27, 'online', 'vendor27', '3ABC');
INSERT INTO peripheral
    (`uid`, `status`, `vendor`, `gateway_serial`)
VALUES (28, 'offline', 'vendor28', '3ABC');
INSERT INTO peripheral
    (`uid`, `status`, `vendor`, `gateway_serial`)
VALUES (29, 'online', 'vendor29', '3ABC');
INSERT INTO peripheral
    (`uid`, `status`, `vendor`, `gateway_serial`)
VALUES (30, 'offline', 'vendor30', '3ABC');

COMMIT;