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
	private Long id;

	private String alamat;

	private Long kelas;

	private String nama;

	private Long umur;

	//bi-directional one-to-one association to Kela
	@OneToOne
	@JoinColumn(name="id")
	private Kela kela;

	public Murid() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAlamat() {
		return this.alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public Long getKelas() {
		return this.kelas;
	}

	public void setKelas(Long kelas) {
		this.kelas = kelas;
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