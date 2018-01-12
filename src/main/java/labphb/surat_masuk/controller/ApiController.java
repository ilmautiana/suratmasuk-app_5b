package labphb.surat_masuk.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import labphb.surat_masuk.repo.SuratmasukRepo;
import labphb.surat_masuk.entity.Suratmasuk;

@RestController
public class ApiController{
	@Autowired
	private SuratmasukRepo suratmasukRepo;

	@RequestMapping("/get-judul")
	public Map<String, Object> getJudul(){
		Map<String, Object> result = new HashMap<>();
		result.put("judul", "OOP2");
		return result;
	}

	@RequestMapping("/ambil-judul/{judul}")
	public Map<String, Object> ambilJudul(
		@PathVariable("judul") String judul){
		Map<String, Object> result = new HashMap<>();
		result.put("judul", judul);
		return result;
	}

	@RequestMapping("/set-judul")
	public Map<String, Object> setJudul(
		@RequestParam("judul") String judul){
		Map<String, Object> result = new HashMap<>();
		result.put("judul", judul);
		return result;
	}



	//Aplikasi Surat Masuk
	@RequestMapping("/daftar-suratmasuk")
	public List<Suratmasuk> getDaftarSuratmasuk(){
		return suratmasukRepo.findAll();
	}

	@RequestMapping(value = "/simpan", method = RequestMethod.POST)
	public void simpan(@RequestBody Suratmasuk suratmasuk){
		suratmasukRepo.save(suratmasuk);
	}

	@RequestMapping("/ambil-data-stm/{id}")
	public Suratmasuk getDataStm(@PathVariable("id") String id) {
		return suratmasukRepo.findOneById(id);
	}

	@RequestMapping(value = "/hapus/{id}", method = RequestMethod.DELETE)
	public void hapus(@PathVariable("id") String id){
		suratmasukRepo.delete(id);
	}
}