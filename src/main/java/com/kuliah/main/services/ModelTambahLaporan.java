package com.kuliah.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuliah.main.entity.TambahLaporan;
import com.kuliah.main.repository.TambahLaporanRepository;



@Service
public class ModelTambahLaporan implements ModelTambahLaporanInterface {
	
	@Autowired
	TambahLaporanRepository tambahRepo;
	
	@Override
	public List<TambahLaporan> getAllTambahLaporan() {
		// TODO Auto-generated method stub
		return (List<TambahLaporan>) this.tambahRepo.findAll();
	}

	@Override
	public void deleteTambahLaporan(String id) {
		// TODO Auto-generated method stub
		this.tambahRepo.deleteById(Long.parseLong(id));
	}

	@Override
	public TambahLaporan cariTambahLaporan(String id) {
		// TODO Auto-generated method stub
		return this.tambahRepo.findById(Long.parseLong(id)).get();
	}

	@Override
	public TambahLaporan addTambahLaporan(TambahLaporan tambah) {
		// TODO Auto-generated method stub
		return this.tambahRepo.save(tambah);
	}

}
