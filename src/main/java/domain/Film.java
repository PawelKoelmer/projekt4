package domain;

import java.time.LocalDate;
import java.util.List;

public class Film {
	
	private long id;
	private float rate;
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	private String title;
	private LocalDate dateOfRelease;
	private String production;
	private String kind;
	private List<Comments> comments;



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDate getDateOfRelease() {
		return dateOfRelease;
	}
	public void setDateOfRelease(LocalDate dateOfRelease) {
		this.dateOfRelease = dateOfRelease;
	}
	public List<Comments> getComments() {
		return this.comments;
	}
	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}
	public String getProduction() {
		return production;
	}
	public void setProduction(String production) {
		this.production = production;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	
}
