package com.generate.dbgenerate.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the kelas database table.
 * 
 */
@Entity
@Table(name="kelas")
@NamedQuery(name="Kela.findAll", query="SELECT k FROM Kela k")
public class Kela implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String nama;

	//bi-directional one-to-one association to Murid
	@OneToOne(mappedBy="kela", fetch = FetchType.LAZY)
	private Murid murid;

	public Kela() {
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

	public Murid getMurid() {
		return this.murid;
	}

	public void setMurid(Murid murid) {
		this.murid = murid;
	}

}