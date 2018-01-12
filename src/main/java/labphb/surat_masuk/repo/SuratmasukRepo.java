package labphb.surat_masuk.repo;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import labphb.surat_masuk.entity.Suratmasuk;

@Repository
public interface SuratmasukRepo 
extends JpaRepository<Suratmasuk, String>{
	Suratmasuk findOneById(String id);
}