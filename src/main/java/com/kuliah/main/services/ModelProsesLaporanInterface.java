package com.kuliah.main.services;

import java.util.List;

import com.kuliah.main.entity.ProsesLaporan;




public interface ModelProsesLaporanInterface {
	
	public List<ProsesLaporan> getAllProsesLaporan();
	
	public void deleteProsesLaporan(String id);
	
	public ProsesLaporan cariProsesLaporan(String id);
	
	public ProsesLaporan addProsesLaporan(ProsesLaporan proses);

}
