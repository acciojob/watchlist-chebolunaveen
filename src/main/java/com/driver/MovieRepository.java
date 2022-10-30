package com.driver;
import org.springframework.stereotype.Component;

import java.util.*;
@Component
public class MovieRepository {
HashMap<String,Movie> movies=new HashMap<>();
HashMap<String,Director> directors=new HashMap<>();
HashMap<String,String> movieDirector=new HashMap<>();
HashMap<String,List<String>> moviebydirector=new HashMap<>();//directorname ,moviesname

    public void addMovie(Movie movie){
        movies.put(movie.getName(),movie);
    }
    public void addDirector(Director director ){
        directors.put(director.getName(),director);
    }
   public void  addMovieDirectorPair(String moviename,String directorname){
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
   public Movie getMovie(String name){
        return movies.get(name);
   }
   public Director getDirector(String name){
        return directors.get(name);
   }
   public List<String> getallMovies(String name){
        List<String> all=new ArrayList<>();
        for(String s:moviebydirector.get(name)){
            all.add(s);
        }
        return all;
   }
   public List<String> findAllMovies(){
        List<String> a=new ArrayList<>();
        for(String movie:movies.keySet()){
            a.add(movie);
        }
        return a;
   }
   public void deleteDirectorByName(String name){
        directors.remove(name);
       for(String movie:moviebydirector.get(name)){
           movies.remove(movie);
       }
        moviebydirector.remove(name);

   }
   public void deleteAllDirectors(){
    directors.clear();
    for(String s:moviebydirector.keySet()){
        for(String a:moviebydirector.get(s)){
            movies.remove(a);
        }
    }
    moviebydirector.clear();

   }
}
