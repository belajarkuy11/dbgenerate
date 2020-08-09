package com.generate.dbgenerate.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the matpel database table.
 * 
 */
@Entity
@NamedQuery(name="Matpel.findAll", query="SELECT m FROM Matpel m")
public class Matpel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String nama;

	//bi-directional many-to-one association to Guru
	@OneToMany(mappedBy="matpelBean")
	private List<Guru> gurus;

	public Matpel() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNama() {
		return this.nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public List<Guru> getGurus() {
		return this.gurus;
	}

	public void setGurus(List<Guru> gurus) {
		this.gurus = gurus;
	}

	public Guru addGurus(Guru gurus) {
		getGurus().add(gurus);
		gurus.setMatpelBean(this);

		return gurus;
	}

	public Guru removeGurus(Guru gurus) {
		getGurus().remove(gurus);
		gurus.setMatpelBean(null);

		return gurus;
	}

}