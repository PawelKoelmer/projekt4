package domain.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import domain.Film;

public class FilmService {

	private static List<Film> db = new ArrayList<Film>();
	private static final AtomicLong counter = new AtomicLong(1);

	public List<Film> getAll(){
		return db;
	}
	public void add(Film f){
	        f.setId((counter.getAndIncrement()));
	        db.add(f);
	 }

	public Film get(int id){
	        for(Film f: db){
	            if(f.getId()==id){
	                return f;
	            }
	        }
	        return null;
	 }
	public void delete(Film f){
		db.remove(f);
	}

	public void update(Film film){
		for(Film f: db){
			if(f.getId()==film.getId()){

				f.setTitle(film.getTitle());
				f.setKind(film.getKind());
				f.setProduction(film.getProduction());
			}
		}
	}
	
	   
}
