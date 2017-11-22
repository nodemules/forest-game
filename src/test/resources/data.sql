-- MYSQL (H2) TEST DATA FOR INTEGRATION TESTS

-- ITEMS
INSERT INTO ITEM (NAME, DESCRIPTION)
VALUES ('TOAST', 'A slice of toast');
INSERT INTO ITEM (NAME, DESCRIPTION)
VALUES ('ROAST', 'A slice of roast');

-- USERS
INSERT INTO USER (USERNAME)
VALUES ('LIAM_NEESON');
INSERT INTO USER (USERNAME, PASSWORD)
VALUES ('TEST_USERNAME', '$2a$10$no8cdDkoISG5gV8KkuU77OqW/L2qjScLdxtv6yTuFdcwEZKOzN2My');

-- COMMANDS
INSERT INTO COMMAND (VALUE, NAME, DESCRIPTION)
VALUES ('bamboozle', 'Bamboozle',
'1 :to deceive by underhanded methods :dupe, hoodwink I got bamboozled by the salesperson to buy a more expensive model.\n2 :to confuse, frustrate, or throw off thoroughly or completely a quarterback bamboozled by an unexpected defense');
INSERT INTO COMMAND (VALUE, NAME, DESCRIPTION)
VALUES ('drizzle', 'Drizzle', 'Pour a litle sauce');