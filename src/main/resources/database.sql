USE demo_db;

CREATE TABLE movie_cast(
                           act_id INT,
                           movie_id INT,
                           role VARCHAR(50) NOT NULL,
                           created_at TIMESTAMP default current_timestamp
);


-- INSERT INTO movie_cast (act_id, movie_id, role){
-- value(1, 1, "Ripley"),
-- value(2, 2, "Marty McFly"),
-- value(3, 3, "Ferris"),
-- values (4, 4, "MAJ Arnold"),
-- value(5, 7, "Idiot from Dumb and Dumber"),
-- value(6, 5, "Imposter Wife")
-- }
-- this did not work, so I looked up a subquery similar instead I tried below:

INSERT INTO movie_cast (act_id, movie_id, role)
-- VALUES (
-- (SELECT actor_id FROM actor WHERE actor_name = "Sigourney Weaver"),
-- (SELECT movie_id FROM movie WHERE movie_name = "Aliens"), "Ripley"
-- );
-- VALUES (
-- (SELECT actor_id FROM actor WHERE actor_name = "Michael J Fox"),
-- (SELECT movie_id FROM movie WHERE movie_name = "Back to the Future"), "Marty McFly"
-- )
-- VALUES (
-- (SELECT actor_id FROM actor WHERE actor_name = "Matthew Broderick"),
-- (SELECT movie_id FROM movie WHERE movie_name = "Ferris Bueller's Day Off"), "Ferris"
-- );
-- VALUES (
-- (SELECT actor_id FROM actor WHERE actor_name = "Sigourney Weaver"),
-- (SELECT movie_id FROM movie WHERE movie_name = "Aliens"), "Ripley"
-- );
-- VALUES (
-- (SELECT actor_id FROM actor WHERE actor_name = "Arnold Scharzenegger"),
-- (SELECT movie_id FROM movie WHERE movie_name = "Predator"), "MAJ Arnold"
-- );
-- VALUES (
-- (SELECT actor_id FROM actor WHERE actor_name = "Jim Carrey"),
-- (SELECT movie_id FROM movie WHERE movie_name = "The Cable Guy"), "Chip Douglas"
-- );
-- VALUES (
-- (SELECT actor_id FROM actor WHERE actor_name = "Jim Carrey"),
-- (SELECT movie_id FROM movie WHERE movie_name = "Dumb and Dumber"), "That Idiot guy"
-- );
-- VALUES (
-- (SELECT actor_id FROM actor WHERE actor_name = "Sharon Stone"),
-- (SELECT movie_id FROM movie WHERE movie_name = "Total Recall"), "Nelina"
-- );
-- VALUES (
-- (SELECT actor_id FROM actor WHERE actor_name = "Arnold Scharzenegger"),
-- (SELECT movie_id FROM movie WHERE movie_name = "Total Recall"), "Quade"
-- );

-- select * from movie_cast;


-- USE demo_db;
-- select * from movie;
-- SELECT actor.actor_name, movie.movie_name, movie_cast.role
-- FROM movie_cast
-- JOIN actor ON movie_cast.act_id = actor.actor_id
-- JOIN movie ON movie_cast.movie_id = movie.movie_id;

-- USE demo_db;
-- SELECT a.actor_name, m.movie_name, mc.role
-- FROM movie_cast mc
-- JOIN actor a ON mc.act_id = a.actor_id
-- JOIN movie m ON mc.movie_id = m.movie_id;

-- movie_name

-- USE demo_db;
-- SELECT * from movie;
-- DELETE FROM movie WHERE movie_id='11111';
-- SELECT * from movie;

-- SELECT * from movie WHERE movie_id='5';