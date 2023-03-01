package edu.papdav.learnSpringBoot.services;
import java.sql.Date;
import java.util.List;
import edu.papdav.learnSpringBoot.entities.Utilisateur;

public interface UtilisateurService {
	
	public List<Utilisateur> getAllUtilisateur();
	public Utilisateur findUtilisateurById(Long id);
	public Utilisateur createUtilisateur(Utilisateur utilisateur);
	public Utilisateur updateUtilisateur(Utilisateur utilisateur);
	public void deleteUtilisateur(Long id);
	
	public List<Utilisateur> findByFirstName(String firstName);
	public List<Utilisateur> findByFirstNameAndLastName(String firstName, String lastName);
	public List<Utilisateur> findByFirstNameOrLastNameWithJPQLWithNamedParameters(String firstName, String lastName);
	public List<Utilisateur> findByAgeIn(List<Integer> ages);
	public List<Utilisateur> findByStarterDateAfterAndActiveFalse(Date date);
	public List<Utilisateur> findByRolesTitre(String titre);
	public List<Utilisateur> findByRolesTitreAndAdressesVille(String titre, String ville); 


}
