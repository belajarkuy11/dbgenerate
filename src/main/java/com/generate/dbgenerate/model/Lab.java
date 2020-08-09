package com.generate.dbgenerate.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the lab database table.
 * 
 */
@Entity
@NamedQuery(name="Lab.findAll", query="SELECT l FROM Lab l")
public class Lab implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String deskripsi;

	private String nama;

	public Lab() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeskripsi() {
		return this.deskripsi;
	}

	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}

	public String getNama() {
		return this.nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

}