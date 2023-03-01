package edu.papdav.learnSpringBoot.services;
import java.sql.Date;
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
	
	@Override
	public List<Utilisateur> findByFirstNameAndLastName(String firstName, String lastName) {
		return utilisateurRepository.findByFirstNameAndLastNameWithJPQL(firstName, lastName);
	}

	@Override
	public List<Utilisateur> findByFirstNameOrLastNameWithJPQLWithNamedParameters(String firstName, String lastName) {
		return utilisateurRepository.findByFirstNameOrLastNameWithJPQLWithNamedParameters(firstName, lastName);
	}

	@Override
	public List<Utilisateur> findByAgeIn(List<Integer> ages) {
		return utilisateurRepository.findByAgeIn(ages);
	}

	@Override
	public List<Utilisateur> findByStarterDateAfterAndActiveFalse(Date date) {
		return utilisateurRepository.findByStarterDateAfterAndActiveFalse(date);
	}

	@Override
	public List<Utilisateur> findByRolesTitre(String titre) {
		return utilisateurRepository.findByRolesTitre(titre);
	}

	@Override
	public List<Utilisateur> findByRolesTitreAndAdressesVille(String titre, String ville) {
		return utilisateurRepository.findByRolesTitreAndAdressesVille(titre, ville);
	}


}
