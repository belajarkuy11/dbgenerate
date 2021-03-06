package com.generate.dbgenerate.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String nama;

	//bi-directional many-to-one association to Jadwal
	@OneToMany(mappedBy="kela")
	private List<Jadwal> jadwals;

	//bi-directional many-to-one association to Murid
	@OneToMany(mappedBy="kela")
	private List<Murid> murids;

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

	public List<Jadwal> getJadwals() {
		return this.jadwals;
	}

	public void setJadwals(List<Jadwal> jadwals) {
		this.jadwals = jadwals;
	}

	public Jadwal addJadwal(Jadwal jadwal) {
		getJadwals().add(jadwal);
		jadwal.setKela(this);

		return jadwal;
	}

	public Jadwal removeJadwal(Jadwal jadwal) {
		getJadwals().remove(jadwal);
		jadwal.setKela(null);

		return jadwal;
	}

	public List<Murid> getMurids() {
		return this.murids;
	}

	public void setMurids(List<Murid> murids) {
		this.murids = murids;
	}

	public Murid addMurid(Murid murid) {
		getMurids().add(murid);
		murid.setKela(this);

		return murid;
	}

	public Murid removeMurid(Murid murid) {
		getMurids().remove(murid);
		murid.setKela(null);

		return murid;
	}

}