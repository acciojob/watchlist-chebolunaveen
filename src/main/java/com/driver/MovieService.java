package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie){
        movieRepository.addMovie(movie);
    }
    public void addDirector(Director director){
        movieRepository.addDirector(director);
    }

     public void  addMovieDirectorPair(String moviename,String directorname){
        movieRepository.addMovieDirectorPair(moviename,directorname);
    }
    public Movie getMovie(String name){
        return movieRepository.getMovie(name);
    }
    public Director getDirector(String name){
        return movieRepository.getDirector(name);
    }
   public  List<String> getallMovies(String name){
        return movieRepository.getallMovies(name);
    }
   public List<String> findAllMovies(){
        return movieRepository.findAllMovies();
    }
    public void deleteDirectorByName(String name){
        movieRepository.deleteDirectorByName(name);
    }
   public void deleteAllDirectors(){
        movieRepository.deleteAllDirectors();
   }
}
