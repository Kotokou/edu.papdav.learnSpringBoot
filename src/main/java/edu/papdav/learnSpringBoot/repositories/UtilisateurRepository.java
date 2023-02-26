package edu.papdav.learnSpringBoot.repositories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.papdav.learnSpringBoot.entities.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
	
	public List<Utilisateur> findByFirstName(String firstName);
}
