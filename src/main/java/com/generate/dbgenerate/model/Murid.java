package com.generate.dbgenerate.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the murid database table.
 * 
 */
@Entity
@NamedQuery(name="Murid.findAll", query="SELECT m FROM Murid m")
public class Murid implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String alamat;

	private String nama;

	private Long umur;

	//bi-directional many-to-one association to Kela
	@ManyToOne
	@JoinColumn(name="kelas")
	private Kela kela;

	public Murid() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAlamat() {
		return this.alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getNama() {
		return this.nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public Long getUmur() {
		return this.umur;
	}

	public void setUmur(Long umur) {
		this.umur = umur;
	}

	public Kela getKela() {
		return this.kela;
	}

	public void setKela(Kela kela) {
		this.kela = kela;
	}

}