package edu.papdav.learnSpringBoot.repositories;
import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import edu.papdav.learnSpringBoot.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
	
	public List<Utilisateur> findByFirstName(String firstName);
	public List<Utilisateur> findByFirstNameAndLastName(String firstName, String lastName);
	
	@Query("SELECT u FROM Utilisateur u WHERE u.firstName = ?1 AND u.lastName = ?2")
	public List<Utilisateur> findByFirstNameAndLastNameWithJPQL(String firstName, String lastName);
	
	@Query("SELECT u FROM Utilisateur u WHERE u.firstName LIKE :myFirstName OR u.lastName LIKE :myLastName")
	public List<Utilisateur> findByFirstNameOrLastNameWithJPQLWithNamedParameters (@Param(value = "myFirstName") String firstName, @Param(value = "myLastName") String lastName);
	
	public List<Utilisateur> findByAgeIn(List<Integer> ages);
	public List<Utilisateur> findByStarterDateAfterAndActiveFalse(Date date);
	public List<Utilisateur> findByRolesTitre(String titre);
	public List<Utilisateur> findByRolesTitreAndAdressesVille(String titre, String ville); 
}
