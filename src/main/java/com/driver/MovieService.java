package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    void addMovie(Movie movie){
        movieRepository.addMovie(movie);
    }
    void addDirector(Director director){
        movieRepository.addDirector(director);
    }

    void  addMovieDirectorPair(String moviename,String directorname){
        movieRepository.addMovieDirectorPair(moviename,directorname);
    }
    Movie getMovie(String name){
        return movieRepository.getMovie(name);
    }
    Director getDirector(String name){
        return movieRepository.getDirector(name);
    }
    List<String> getallMovies(String name){
        return movieRepository.getallMovies(name);
    }
    List<String> findAllMovies(){
        return movieRepository.findAllMovies();
    }
    void deleteDirectorByName(String name){
        movieRepository.deleteDirectorByName(name);
    }
   void deleteAllDirectors(){
        movieRepository.deleteAllDirectors();
   }
}
