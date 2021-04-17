package com.kuliah.main.services;

import java.util.List;

import com.kuliah.main.entity.TambahLaporan;



public interface ModelTambahLaporanInterface {
	
public List<TambahLaporan> getAllTambahLaporan();
	
	public void deleteTambahLaporan(String id);
	
	public TambahLaporan cariTambahLaporan(String id);
	
	public TambahLaporan addTambahLaporan(TambahLaporan tambah);

}
