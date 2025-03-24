-- Drop existing tables in the correct order to avoid foreign key constraint issues
DROP TABLE IF EXISTS tournament_members;
DROP TABLE IF EXISTS tournaments;
DROP TABLE IF EXISTS members;

-- Create the MEMBERS table
CREATE TABLE IF NOT EXISTS members (
                                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       name VARCHAR(100) NOT NULL,
    address VARCHAR(255),
    email VARCHAR(100),
    phone_number VARCHAR(20),
    start_date DATE,
    duration INT,
    membership_type VARCHAR(50)
    ) ENGINE=InnoDB;

-- Create the TOURNAMENTS table
CREATE TABLE IF NOT EXISTS tournaments (
                                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                           start_date DATE,
                                           end_date DATE,
                                           location VARCHAR(100),
    entry_fee DECIMAL(10, 2),
    cash_prize DECIMAL(10, 2)
    ) ENGINE=InnoDB;

-- Create the join table for the many-to-many relationship
CREATE TABLE IF NOT EXISTS tournament_members (
                                                  tournament_id BIGINT NOT NULL,
                                                  member_id BIGINT NOT NULL,
                                                  PRIMARY KEY (tournament_id, member_id),
    CONSTRAINT fk_tournament
    FOREIGN KEY (tournament_id) REFERENCES tournaments (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    CONSTRAINT fk_member
    FOREIGN KEY (member_id) REFERENCES members (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    ) ENGINE=InnoDB;
