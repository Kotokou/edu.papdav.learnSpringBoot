package edu.papdav.learnSpringBoot.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.papdav.learnSpringBoot.entities.Utilisateur;
import edu.papdav.learnSpringBoot.repositories.UtilisateurRepository;

@Service
public class UtilsateurServiceImpl implements UtilisateurService{
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Override
	public List<Utilisateur> getAllUtilisateur() {
		
		return utilisateurRepository.findAll();
	}

	@Override
	public Utilisateur findUtilisateurById(Long id) {
		
		Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findById(id);
		
		if(optionalUtilisateur.isEmpty()) {
			return null;
		}
		else {
			return optionalUtilisateur.get();
		}
	}

	@Override
	public Utilisateur createUtilisateur(Utilisateur utilisateur) {
		
		return utilisateurRepository.save(utilisateur);
	}

	@Override
	public Utilisateur updateUtilisateur(Utilisateur utilisateur) {
		
		Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findById(utilisateur.getId());
		
		if(optionalUtilisateur.isEmpty()) {
			return null;
		}
		else {
			return utilisateurRepository.save(utilisateur);
		}
	}

	@Override
	public void deleteUtilisateur(Long id) {
		
		utilisateurRepository.deleteById(id);
		
	}

	@Override
	public List<Utilisateur> findByFirstName(String firstName) {
		
		return utilisateurRepository.findByFirstName(firstName);
	}

}
