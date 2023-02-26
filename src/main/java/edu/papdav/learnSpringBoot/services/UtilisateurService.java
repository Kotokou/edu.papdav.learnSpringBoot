package edu.papdav.learnSpringBoot.services;
import java.util.List;
import edu.papdav.learnSpringBoot.entities.Utilisateur;

public interface UtilisateurService {
	
	public List<Utilisateur> getAllUtilisateur();
	public Utilisateur findUtilisateurById(Long id);
	public Utilisateur createUtilisateur(Utilisateur utilisateur);
	public Utilisateur updateUtilisateur(Utilisateur utilisateur);
	public void deleteUtilisateur(Long id);
	
	public List<Utilisateur> findByFirstName(String firstName);
	

}
