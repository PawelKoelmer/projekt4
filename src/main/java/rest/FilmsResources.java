package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import domain.Comments;
import domain.Film;
import domain.services.FilmService;

import java.util.ArrayList;
@Path("/film")
public class FilmsResources {
		
	 FilmService db = new FilmService();
	
	 @GET
	 @Produces(MediaType.APPLICATION_JSON)
	 public Response getAll(Film result){
		return Response.ok(db.getAll()).build();
	 }
	 
	 @GET
	 @Produces(MediaType.APPLICATION_JSON)
	 @Path("/{id}")
	 public Response get(@PathParam("id")int id){
	 	Film result = db.get(id);
	 	if(result==null){
	 		return Response.ok("Brak filmu o numerze ID: " + id).build();
		}
		return Response.ok(result).build();
	 }
	 
	 @POST
	 @Consumes(MediaType.APPLICATION_JSON)
	 public Response add(Film f){
		 db.add(f);
	   return Response.ok("Dodano nowy film").build();
	 }
	 
	 @DELETE
	 @Path("/{id}")
	 	public Response delete(@PathParam("id")int id){
		Film result = db.get(id);
		if(result==null){
			return Response.ok("Brak filmu o podanym numerze ID").build();
		}
		db.delete(result);
		return Response.ok("Usunieto film o numerze ID:" + id).build();
	 }
	 
	 @PUT
	 @Path("/{id}")
	 @Consumes(MediaType.APPLICATION_JSON)
	 public Response update(@PathParam("id")int id,Film f){
	 	Film result = db.get(id);
	 	if(result==null){
	 		return Response.ok("Brak filmu o podanym ID").build();
		}
		f.setId(id);
		db.update(f);
	 	return Response.ok().build();
	 }
	 
	 @GET
	 @Path("/{id}/comments")
	 public Response getComments(@PathParam("id")int id){
		Film result = db.get(id);
		if(result==null){
			return Response.ok("Brak filmu o podanym ID").build();
		}
		if(result.getComments()==null)
		result.setComments(new ArrayList<Comments>());
		return Response.ok(result.getComments()).build();
	 }

	 @DELETE
	 @Path("/{filmId}/{id}/comments")
	 public Response deleteComment(@PathParam("filmId")int filmId,@PathParam("id")int id,Comments c){
		 Film result = db.get(filmId);
		 if(result==null){
			 return Response.ok("Brak filmu o podanym ID").build();
		 }
		 for (Comments com : result.getComments()) {
		 	if(com.getId()==id)
			 result.getComments().remove(com);
		 }
		 return Response.ok("Usunieto komentarz").build();
	 }

	 @POST
	 @Path("/{id}/comments")
	 public Response addComment(@PathParam("id")int id, Comments comment){

	 	Film result = db.get(id);
	 	if(result==null){
	 		return Response.ok("Brak filmu o podanym ID").build();
		}
		if(result.getComments()==null)
			result.setComments(new ArrayList<Comments>());
	 	int id1 = result.getComments().size();
	 	comment.setId(id1+1);
	 	result.getComments().add(comment);
	 	return Response.ok("Dodano komentarz").build();
	 }
	
}
