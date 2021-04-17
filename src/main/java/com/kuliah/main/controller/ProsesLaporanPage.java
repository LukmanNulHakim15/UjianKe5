package com.kuliah.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.kuliah.main.entity.ProsesLaporan;
import com.kuliah.main.services.ModelProsesLaporan;
import com.kuliah.main.services.ModelTambahLaporan;

@Controller
public class ProsesLaporanPage {
	
	@Autowired
	ModelProsesLaporan modelProses;
	
	@Autowired
	ModelTambahLaporan modelTambah;
	
	@GetMapping("/proses/view")
	public String viewProsesLaporan(Model model) {
		model.addAttribute("listProsesLaporan",modelProses.getAllProsesLaporan());
		model.addAttribute("active");
		return "view_proseslaporan";
	}
	
//	@GetMapping("/proses/add")
//	public String viewAddProsesLaporan(Model model) {
//		
//		// buat penampung data PlotMataKuliah di halaman htmlnya
//		model.addAttribute("proseslaporan",new ProsesLaporan());
//		model.addAttribute("listTambahLaporan", modelTambah.getAllTambahLaporan());
////		model.addAttribute("listMahasiswa", modelMahasiswa.getAllMahasiswa());
////		model.addAttribute("listDosen", modelDosen.getAllDosen());
////		model.addAttribute("listSoal", modelSoal.getAllSoal());
////		
//		
//		return "add_plotmatakuliah2";
//	}
	
	@PostMapping("/proses/view")
	  public String addPlotProsesLaporan(@ModelAttribute ProsesLaporan proseslaporan, Model model) {
		
		// buat penampung data PlotMataKuliah di halaman htmlnya
		this.modelProses.addProsesLaporan(proseslaporan);
		model.addAttribute("listProsesLaporan",modelProses.getAllProsesLaporan());
		
		
		
		return "redirect:/proses/view";
	}
	
	@GetMapping("/proses/update/{id}")
	public String viewUpdateProsesLaporan(@PathVariable String id, Model model) {
		
		ProsesLaporan proseslaporan = modelProses.cariProsesLaporan(id);
		// buat penampung data MataKuliah di halaman htmlnya
		model.addAttribute("proseslaporan",proseslaporan);
		
		return "add_proseslaporan";
	}
	
	@GetMapping("/proses/delete/{id}")
	public String deleteProsesLaporan(@PathVariable String id, Model model) {
		
		this.modelTambah.deleteTambahLaporan(id);
		
		
		return "redirect:/proses/view";
	}
	

}
