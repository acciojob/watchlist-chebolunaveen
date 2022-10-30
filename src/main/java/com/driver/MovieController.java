package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movies")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    ResponseEntity addMovie(@RequestBody Movie movie){
          movieService.addMovie(movie);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
    @PostMapping("/add-director")
    ResponseEntity addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("success",HttpStatus.OK);
    }
    @PutMapping("/add-movie-director-pair")
    ResponseEntity  addMovieDirectorPair(@RequestParam("moviename")String moviename,@RequestParam("directorname")String directorname){
        movieService.addMovieDirectorPair(moviename,directorname);

        return new ResponseEntity<>("success",HttpStatus.OK);
    }
    @GetMapping("/get-movie-by-name/{name}")
    ResponseEntity getMovieByName(@PathVariable String name){

       return new  ResponseEntity<>(movieService.getMovie(name),HttpStatus.OK);
    }
    @GetMapping("/get-director-by-name/{name}")
    ResponseEntity getDirectorByName(@PathVariable String name){

        return new  ResponseEntity<>(movieService.getDirector(name),HttpStatus.OK);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    ResponseEntity getMoviesByDirectorName(@PathVariable String director){
        return new ResponseEntity<>(movieService.getallMovies(director),HttpStatus.OK);
    }
    @GetMapping("/get-all-movies")
    ResponseEntity findAllMovies(){
        return new ResponseEntity<>(movieService.findAllMovies(),HttpStatus.OK);
    }
    @DeleteMapping("/delete-director-by-name")
    ResponseEntity  deleteDirectorByName(@RequestParam("name") String name){
        movieService.deleteDirectorByName(name);
        return new ResponseEntity<>("success",HttpStatus.OK);
    }
    @DeleteMapping("/delete-all-directors")
        ResponseEntity  deleteAllDirectors(){
            movieService.deleteAllDirectors();
            return new ResponseEntity<>("success",HttpStatus.OK);
        }
    }

