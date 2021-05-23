START TRANSACTION;

INSERT INTO gateway(`serial`, `address`, `name`)
VALUES ('10ABC', '192.147.25.1', 'Gateway1');
INSERT INTO gateway(`serial`, `address`, `name`)
VALUES ('11ABC', '192.147.25.2', 'Gateway2');
INSERT INTO gateway(`serial`, `address`, `name`)
VALUES ('12ABC', '192.147.25.3', 'Gateway3');
INSERT INTO gateway(`serial`, `address`, `name`)
VALUES ('13ABC', '192.147.25.4', 'Gateway4');
INSERT INTO gateway(`serial`, `address`, `name`)
VALUES ('14ABC', '192.147.25.5', 'Gateway5');
INSERT INTO gateway(`serial`, `address`, `name`)
VALUES ('15ABC', '192.147.25.1', 'Gateway6');
INSERT INTO gateway(`serial`, `address`, `name`)
VALUES ('16ABC', '192.147.25.2', 'Gateway7');
INSERT INTO gateway(`serial`, `address`, `name`)
VALUES ('17ABC', '192.147.25.3', 'Gateway8');
INSERT INTO gateway(`serial`, `address`, `name`)
VALUES ('18ABC', '192.147.25.4', 'Gateway9');
INSERT INTO gateway(`serial`, `address`, `name`)
VALUES ('19ABC', '192.147.25.4', 'Gateway10');

COMMIT;