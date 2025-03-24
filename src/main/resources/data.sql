INSERT INTO members (name, address, email, phone_number, start_date, duration, membership_type)
VALUES ('Alice Johnson', '123 Golf Lane', 'alice@example.com', '555-1234', '2022-01-01', 12, 'Gold');

INSERT INTO members (name, address, email, phone_number, start_date, duration, membership_type)
VALUES ('Bob Smith', '456 Fairway Ave', 'bob@example.com', '555-5678', '2023-02-15', 24, 'Platinum');

INSERT INTO tournaments (start_date, end_date, location, entry_fee, cash_prize)
VALUES ('2023-09-01', '2023-09-03', 'Augusta', 200.00, 5000.00);

-- Example of joining a member to a tournament
-- Suppose the new tournament is ID=1 and the new member is ID=1
INSERT INTO tournament_members (tournament_id, member_id)
VALUES (1, 1);
