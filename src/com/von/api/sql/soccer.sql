-- Soccer JPA 버전
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    name VARCHAR(20),
    phone VARCHAR(20),
    job VARCHAR(20),
    height VARCHAR(20),
    weight VARCHAR(20)
);

DROP TABLE users;

CREATE TABLE stadium(
    id INT AUTO_INCREMENT PRIMARY KEY,
    stadium_name VARCHAR(40),
    hometeam_id VARCHAR(10),
    seat_count INT,
    address VARCHAR(60),
    ddd VARCHAR(10),
    tel VARCHAR(10)
);

CREATE TABLE schedule(
    id INT,
    stadium_id INT,
    guhan VARCHAR(40),
    hometeam_id VARCHAR(10),
    awayteam_id INT,
    home_score VARCHAR(60),
    away_score VARCHAR(10),
    PRIMARY KEY(id),
    FOREIGN KEY(stadium_id) REFERENCES stadium(id)
);

CREATE TABLE team(
    id INT,
    region_name VARCHAR(10),
    team_name VARCHAR(40),
    e_team_name VARCHAR(50),
    orig_yyy VARCHAR(10),
    zip_code1 VARCHAR(10),
    zip_code2 VARCHAR(10),
    address VARCHAR(80),
    ddd VARCHAR(10),
    tel VARCHAR(10),
    fax VARCHAR(10),
    homepage VARCHAR(50),
    owner VARCHAR(10),
    stadium_id INT,
    PRIMARY KEY(id),
    FOREIGN KEY(stadium_id) REFERENCES stadium(id)
);

CREATE TABLE player(
    id INT,
    player_name VARCHAR(20),
    e_player_name VARCHAR(40),
    nickname VARCHAR(30),
    join_yyy VARCHAR(10),
    position VARCHAR(10),
    back_no INT,
    nation VARCHAR(20),
    birth_date DATE,
    solar VARCHAR(10),
    height INT,
    weight INT,
    team_id INT,
    PRIMARY KEY(id),
    FOREIGN KEY(team_id) REFERENCES team(id)
);