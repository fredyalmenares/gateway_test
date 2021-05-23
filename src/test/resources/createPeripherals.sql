START TRANSACTION;

INSERT INTO peripheral
    (`uid`, `status`, `vendor`)
VALUES (1, 'online', 'vendor1');
INSERT INTO peripheral
    (`uid`, `status`, `vendor`)
VALUES (2, 'offline', 'vendor2');
INSERT INTO peripheral
    (`uid`, `status`, `vendor`)
VALUES (3, 'online', 'vendor3');
INSERT INTO peripheral
    (`uid`, `status`, `vendor`)
VALUES (4, 'offline', 'vendor4');
INSERT INTO peripheral
    (`uid`, `status`, `vendor`)
VALUES (5, 'online', 'vendor5');
INSERT INTO peripheral
    (`uid`, `status`, `vendor`)
VALUES (6, 'offline', 'vendor6');
INSERT INTO peripheral
    (`uid`, `status`, `vendor`)
VALUES (7, 'online', 'vendor7');
INSERT INTO peripheral
    (`uid`, `status`, `vendor`)
VALUES (8, 'offline', 'vendor8');
INSERT INTO peripheral
    (`uid`, `status`, `vendor`)
VALUES (9, 'online', 'vendor9');
INSERT INTO peripheral
    (`uid`, `status`, `vendor`)
VALUES (10, 'offline', 'vendor10');

COMMIT;