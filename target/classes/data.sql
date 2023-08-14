
INSERT INTO ITEM (id, name, count)
VALUES (1, 'item_1', '1');

INSERT INTO ITEM (id, name, count)
VALUES (2, 'item_2', '2');

INSERT INTO PLAYER (player_id, credential, created, modified, last_session, total_spent, total_refund,
                    total_transactions,
                    last_purchase, level, xp, total_playtime, country, language, birthdate, gender, device_id, item_id)
VALUES (1, 'apple_credential', '2021-01-10 13:37:17Z', '2021-01-23 13:37:17Z', '2021-01-23 13:37:17Z', 400, 0, 5,
        '2021-01-22 13:37:17Z',
        3, 1000, 144, 'CA', 'fr', '2000-01-10 13:37:17Z', 'male', 1, 1);

INSERT INTO PLAYER (player_id, credential, created, modified, last_session, total_spent, total_refund,
                    total_transactions,
                    last_purchase, level, xp, total_playtime, country, language, birthdate, gender, device_id, item_id)
VALUES (2, 'apple_credential', '2021-01-10 13:37:17Z', '2021-01-23 13:37:17Z', '2021-01-23 13:37:17Z', 400, 0, 5,
        '2021-01-22 13:37:17Z',
        3, 1000, 144, 'CA', 'fr', '2000-01-10 13:37:17Z', 'male', 1, 2);


INSERT INTO PLAYER (player_id, credential, created, modified, last_session, total_spent, total_refund,
                    total_transactions,
                    last_purchase, level, xp, total_playtime, country, language, birthdate, gender, device_id, item_id)
VALUES (3, 'apple_credential', '2021-01-10 13:37:17Z', '2021-01-23 13:37:17Z', '2021-01-23 13:37:17Z', 400, 0, 5,
        '2021-01-22 13:37:17Z',
        3, 1000, 144, 'CA', 'fr', '2000-01-10 13:37:17Z', 'male', 2, 2);


INSERT INTO DEVICE (model, carrier, firmware,player_id)
VALUES ('apple iphone 11', 'vodafone', '123',1);

INSERT INTO DEVICE (model, carrier, firmware, player_id)
VALUES ('apple iphone 12', 'vodafone', '12345',2);

