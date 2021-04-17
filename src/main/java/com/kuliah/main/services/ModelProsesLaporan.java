package com.kuliah.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuliah.main.entity.ProsesLaporan;
import com.kuliah.main.repository.ProsesLaporanRepository;



@Service
public class ModelProsesLaporan implements ModelProsesLaporanInterface {

	@Autowired
	ProsesLaporanRepository prosesRepo;
	
	@Override
	public List<ProsesLaporan> getAllProsesLaporan() {
		// TODO Auto-generated method stub
		return (List<ProsesLaporan>) this.prosesRepo.findAll();
	}

	@Override
	public void deleteProsesLaporan(String id) {
		// TODO Auto-generated method stub
		this.prosesRepo.deleteById(Long.parseLong(id));
	}

	@Override
	public ProsesLaporan cariProsesLaporan(String id) {
		// TODO Auto-generated method stub
		return this.prosesRepo.findById(Long.parseLong(id)).get();
	}

	@Override
	public ProsesLaporan addProsesLaporan(ProsesLaporan proses) {
		// TODO Auto-generated method stub
		return this.prosesRepo.save(proses);
	}

	public Object getAllTambahLaporan() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
