
INSERT INTO members (name, address, email, phone_number, start_date, duration, membership_type)
VALUES
    ('Alice Johnson', '123 Golf Lane', 'alice@example.com', '555-1234', '2023-01-01', 12, 'Gold'),
    ('Bob Smith', '456 Fairway Blvd', 'bob@example.com', '555-5678', '2023-02-10', 6, 'Silver');


INSERT INTO tournaments (start_date, end_date, location, entry_fee, cash_prize)
VALUES
    ('2023-09-01', '2023-09-03', 'Augusta', 200.00, 5000.00),
    ('2023-10-10', '2023-10-12', 'Pebble Beach', 250.00, 7500.00);


INSERT INTO tournament_members (tournament_id, member_id)
VALUES
    (1, 1),
    (2, 2);
