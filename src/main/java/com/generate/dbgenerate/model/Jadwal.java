package com.generate.dbgenerate.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the jadwal database table.
 * 
 */
@Entity
@NamedQuery(name="Jadwal.findAll", query="SELECT j FROM Jadwal j")
public class Jadwal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private Timestamp date;

	//bi-directional many-to-one association to Guru
	@ManyToOne
	@JoinColumn(name="guru")
	private Guru guruBean;

	//bi-directional many-to-one association to Kela
	@ManyToOne
	@JoinColumn(name="kelas")
	private Kela kela;

	public Jadwal() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public Guru getGuruBean() {
		return this.guruBean;
	}

	public void setGuruBean(Guru guruBean) {
		this.guruBean = guruBean;
	}

	public Kela getKela() {
		return this.kela;
	}

	public void setKela(Kela kela) {
		this.kela = kela;
	}

}