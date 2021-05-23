START TRANSACTION;

INSERT INTO gateway(`serial`, `address`, `name`)
            VALUES('1ABC', '192.147.25.1', 'Gateway1');
INSERT INTO gateway(`serial`, `address`, `name`)
            VALUES('2ABC', '192.147.25.2', 'Gateway2');
INSERT INTO gateway(`serial`, `address`, `name`)
            VALUES('3ABC', '192.147.25.3', 'Gateway3');
INSERT INTO gateway(`serial`, `address`, `name`)
            VALUES('4ABC', '192.147.25.4', 'Gateway4');
INSERT INTO gateway(`serial`, `address`, `name`)
            VALUES('5ABC', '192.147.25.5', 'Gateway5');

COMMIT;