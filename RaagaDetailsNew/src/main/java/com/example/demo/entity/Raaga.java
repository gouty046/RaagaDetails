package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.EntityGraph;

@Entity
@Table(name = "TBL_RAAGAS")

public class Raaga {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="raaga_name")
	private String Raaganame;
	
	@Column(name="raaga_timing")
	private String Raagatiming;
	
	@Column(name="raaga_aarohana")
	private String Raagaarohana;

	@Column(name="raaga_avarohana")
	private String Raagaavarohana;
	

	
	@Override
	public String toString() {
		return "Raaga [id=" + id + ", Raaganame=" + Raaganame + ", Raagatiming=" + Raagatiming + ", Raagaarohana="
				+ Raagaarohana + ", Raagaavarohana=" + Raagaavarohana + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRaaganame() {
		return Raaganame;
	}
	public void setRaaganame(String raaganame) {
		Raaganame = raaganame;
	}
	public String getRaagatiming() {
		return Raagatiming;
	}
	public void setRaagatiming(String raagatiming) {
		Raagatiming = raagatiming;
	}
	public String getRaagaarohana() {
		return Raagaarohana;
	}
	public void setRaagaarohana(String raagaarohana) {
		Raagaarohana = raagaarohana;
	}
	public String getRaagaavarohana() {
		return Raagaavarohana;
	}
	public void setRaagaavarohana(String raagaavarohana) {
		Raagaavarohana = raagaavarohana;
	}
	
}
