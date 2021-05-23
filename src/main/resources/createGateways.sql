START TRANSACTION;

INSERT INTO gateway(`serial`, `address`, `name`)
            VALUES('ABC1', '192.147.25.1', 'Gateway1');
INSERT INTO gateway(`serial`, `address`, `name`)
            VALUES('ABC2', '192.147.25.2', 'Gateway2');
INSERT INTO gateway(`serial`, `address`, `name`)
            VALUES('ABC3', '192.147.25.3', 'Gateway3');
INSERT INTO gateway(`serial`, `address`, `name`)
            VALUES('ABC4', '192.147.25.4', 'Gateway4');
INSERT INTO gateway(`serial`, `address`, `name`)
            VALUES('ABC5', '192.147.25.5', 'Gateway5');

COMMIT;