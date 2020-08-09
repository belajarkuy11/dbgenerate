package com.generate.dbgenerate.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the guru database table.
 * 
 */
@Entity
@NamedQuery(name="Guru.findAll", query="SELECT g FROM Guru g")
public class Guru implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String nama;

	//bi-directional many-to-one association to Matpel
	@ManyToOne
	@JoinColumn(name="matpel")
	private Matpel matpelBean;

	//bi-directional many-to-one association to Jadwal
	@OneToMany(mappedBy="guruBean")
	private List<Jadwal> jadwals;

	public Guru() {
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

	public Matpel getMatpelBean() {
		return this.matpelBean;
	}

	public void setMatpelBean(Matpel matpelBean) {
		this.matpelBean = matpelBean;
	}

	public List<Jadwal> getJadwals() {
		return this.jadwals;
	}

	public void setJadwals(List<Jadwal> jadwals) {
		this.jadwals = jadwals;
	}

	public Jadwal addJadwal(Jadwal jadwal) {
		getJadwals().add(jadwal);
		jadwal.setGuruBean(this);

		return jadwal;
	}

	public Jadwal removeJadwal(Jadwal jadwal) {
		getJadwals().remove(jadwal);
		jadwal.setGuruBean(null);

		return jadwal;
	}

}