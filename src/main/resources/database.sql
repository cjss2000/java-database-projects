USE demo_db;

CREATE TABLE IF NOT EXISTS actor
(
    actor_id   INT PRIMARY KEY AUTO_INCREMENT,
    actor_name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS movie
(
    movie_id   INT PRIMARY KEY AUTO_INCREMENT,
    movie_name VARCHAR(255) NOT NULL UNIQUE,
    movie_year INT
);


CREATE TABLE IF NOT EXISTS movie_cast
(
    act_id   INT NOT NULL,
    movie_id INT NOT NULL,
    role     VARCHAR(255),
    PRIMARY KEY (act_id, movie_id),
    FOREIGN KEY (act_id) REFERENCES actor (actor_id),
    FOREIGN KEY (movie_id) REFERENCES movie (movie_id)
);


INSERT INTO actor (actor_name)
VALUES ('Sigourney Weaver'),
       ('Michael J Fox'),
       ('Matthew Broderick'),
       ('Arnold Scharzenegger'),
       ('Jim Carrey'),
       ('Sharon Stone');

INSERT INTO movie (movie_name, movie_year)
VALUES ('Aliens', 1986),
       ('Back to the Future', 1985),
       ('Ferris Bueller''s Day Off', 1986),
       ('Predator', 1987),
       ('The Cable Guy', 1996),
       ('Dumb and Dumber', 1994),
       ('Total Recall', 1990);

INSERT INTO movie_cast (act_id, movie_id, role)
VALUES ((SELECT actor_id FROM actor WHERE actor_name = 'Sigourney Weaver'),
        (SELECT movie_id FROM movie WHERE movie_name = 'Aliens'), 'Ripley'),

       ((SELECT actor_id FROM actor WHERE actor_name = 'Michael J Fox'),
        (SELECT movie_id FROM movie WHERE movie_name = 'Back to the Future'), 'Marty McFly'),

       ((SELECT actor_id FROM actor WHERE actor_name = 'Matthew Broderick'),
        (SELECT movie_id FROM movie WHERE movie_name = 'Ferris Bueller''s Day Off'), 'Ferris'),

       ((SELECT actor_id FROM actor WHERE actor_name = 'Arnold Scharzenegger'),
        (SELECT movie_id FROM movie WHERE movie_name = 'Predator'), 'MAJ Arnold'),

       ((SELECT actor_id FROM actor WHERE actor_name = 'Jim Carrey'),
        (SELECT movie_id FROM movie WHERE movie_name = 'The Cable Guy'), 'Chip Douglas'),

       ((SELECT actor_id FROM actor WHERE actor_name = 'Jim Carrey'),
        (SELECT movie_id FROM movie WHERE movie_name = 'Dumb and Dumber'), 'That Idiot guy'),

       ((SELECT actor_id FROM actor WHERE actor_name = 'Sharon Stone'),
        (SELECT movie_id FROM movie WHERE movie_name = 'Total Recall'), 'Nelina'),

       ((SELECT actor_id FROM actor WHERE actor_name = 'Arnold Scharzenegger'),
        (SELECT movie_id FROM movie WHERE movie_name = 'Total Recall'), 'Quade');
