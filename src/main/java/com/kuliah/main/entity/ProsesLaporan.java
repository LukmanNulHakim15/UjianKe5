package com.kuliah.main.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table (name="proses_laporan")

public class ProsesLaporan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long id;
	private String namaLaporan;
	private String kejadianLaporan;
	private String alamatLaporan;
	private String statusLaporan;
	
	
	 @OneToMany(cascade = CascadeType.ALL)
	 @JoinColumn(name="id_proses", referencedColumnName = "id")
     private List<TambahLaporan> lstTambahLaporan = new ArrayList<TambahLaporan>();

}
