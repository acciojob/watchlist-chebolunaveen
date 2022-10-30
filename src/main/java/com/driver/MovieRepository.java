package com.driver;
import org.springframework.stereotype.Component;

import java.util.*;
@Component
public class MovieRepository {
HashMap<String,Movie> movies=new HashMap<>();
HashMap<String,Director> directors=new HashMap<>();
HashMap<String,String> movieDirector=new HashMap<>();
HashMap<String,List<String>> moviebydirector=new HashMap<>();//directorname ,moviesname

    void addMovie(Movie movie){
        movies.put(movie.getName(),movie);
    }
    void addDirector(Director director ){
        directors.put(director.getName(),director);
    }
   void  addMovieDirectorPair(String moviename,String directorname){
        //movieDirector.put(directorname,moviename);
       int flag=0;
        if(moviebydirector.containsKey(directorname)){
            for(String name:moviebydirector.get(directorname)){
                if(name==moviename) {
                    flag = 1;
                }
            }if(flag==0) {
                moviebydirector.get(directorname).add(moviename);
            }
            flag=0;
        }else{
            List<String> names=new ArrayList<>();
            names.add(moviename);
            moviebydirector.put(directorname,names);
        }
   }
   Movie getMovie(String name){
        return movies.get(name);
   }
   Director getDirector(String name){
        return directors.get(name);
   }
   List<String> getallMovies(String name){
        List<String> all=new ArrayList<>();
        for(String s:moviebydirector.get(name)){
            all.add(s);
        }
        return all;
   }
   List<String> findAllMovies(){
        List<String> a=new ArrayList<>();
        for(String movie:movies.keySet()){
            a.add(movie);
        }
        return a;
   }
   void deleteDirectorByName(String name){
        directors.remove(name);
       for(String movie:moviebydirector.get(name)){
           movies.remove(movie);
       }
        moviebydirector.remove(name);

   }
   void deleteAllDirectors(){
    directors.clear();
    for(String s:moviebydirector.keySet()){
        for(String a:moviebydirector.get(s)){
            movies.remove(a);
        }
    }
    moviebydirector.clear();

   }
}
