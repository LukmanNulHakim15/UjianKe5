package com.kuliah.main.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kuliah.main.entity.Dosen;
import com.kuliah.main.entity.Pertanyaan;
import com.kuliah.main.entity.TambahLaporan;
import com.kuliah.main.services.ModelTambahLaporan;
import com.kuliah.main.utility.FileUtility;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
public class TambahLaporanPage {
	
	@Autowired
	ModelTambahLaporan modelTambah;
	
	 private final String UPLOAD_DIR = "./src/main/resources/static/uploads/";
	 
	 @GetMapping("/tambah/view")
		public String viewTambahLaporan(Model model) {
			model.addAttribute("listTambahLaporan",modelTambah.getAllTambahLaporan());
			model.addAttribute("active");
			return "view_tambahlaporan";
		}
	 
	 
	 @GetMapping("/tambah/add")
		public String viewAddPertanyaan(Model model) {
			model.addAttribute("tambahlaporan",new TambahLaporan());
			return "add_tambahlaporan";
		}
	 
	 @PostMapping("/tambah/vieew")
		public String addPertanyaan(@RequestParam(value = "file")MultipartFile file,@ModelAttribute TambahLaporan tambahlaporan, Model model) throws IOException { {
			   String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			  
		         
		        String uploadDir = "user-photos/" ;
		
		        FileUtility.saveFile(uploadDir, fileName, file);
		 
	          tambahlaporan.setGambar("/"+uploadDir + fileName);
	           this.modelTambah.addTambahLaporan(tambahlaporan);

			model.addAttribute("listTambahLaporan",modelTambah.getAllTambahLaporan());
			
			return "redirect:/tambah/view";
		  }
		}
	 
		@GetMapping("/tambah/delete/{id}")
		public String deletePertanyaan(@PathVariable String id, Model model) {
			
			this.modelTambah.deleteTambahLaporan(id);
			
			
			return "redirect:/tambah/view";
		}
		
		@GetMapping("/tambah/update/{id}")
		public String viewUpdatePertanyaan(@PathVariable String id, Model model) {
			
			TambahLaporan tambahlaporan = modelTambah.cariTambahLaporan(id);
			// buat penampung data MataKuliah di halaman htmlnya
			model.addAttribute("tambahlaporan",tambahlaporan);
			
			return "add_tambahlaporan";
		}
		
		@GetMapping("/tambah/report/pdf")
		public void exportPDF() {
			try {
			File file = ResourceUtils.getFile("classpath:TambahLaporan.jrxml");
			JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
			
			List<TambahLaporan> lstTambahLaporan = modelTambah.getAllTambahLaporan();
	        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lstTambahLaporan);
	        
	        Map<String, Object> parameters = new HashMap<>();
	        parameters.put("createdBy","Juaracoding");
	        
	        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
	        String path = "E:\\tambahlaporan.pdf";
	        JasperExportManager.exportReportToPdfFile(jasperPrint,path);
	        
	       
			
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
}
