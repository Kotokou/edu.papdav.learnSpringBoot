package edu.papdav.learnSpringBoot.controllers;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.papdav.learnSpringBoo.requests.FirstNameAndLastNameRequest;
import edu.papdav.learnSpringBoo.requests.TitreAndVilleRequest;
import edu.papdav.learnSpringBoot.entities.Utilisateur;
import edu.papdav.learnSpringBoot.services.UtilisateurService;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	@GetMapping(path = "/getAllUtilisateurs")
	public List<Utilisateur> getAllUtilisateurs() {
		return utilisateurService.getAllUtilisateur();
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Utilisateur> findUtilisateurById(@PathVariable Long id) {
		Utilisateur utilisateur = utilisateurService.findUtilisateurById(id);
		if(utilisateur == null) {
			return new ResponseEntity<Utilisateur>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<Utilisateur>(utilisateur, HttpStatus.OK);
		}
	}
	
	@GetMapping(path = "/findByFirstName/{firstName}")
	public ResponseEntity<List<Utilisateur>> findUtilisateurById(@PathVariable String firstName) {
		List<Utilisateur> utilisateurs = utilisateurService.findByFirstName(firstName);
		if(utilisateurs.isEmpty()) {
			return new ResponseEntity<List<Utilisateur>>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<Utilisateur>>(utilisateurs, HttpStatus.OK);
		}
	}
	
	@GetMapping(path = "/findByFirstNameAndLastName")
	public ResponseEntity<List<Utilisateur>> findByFirstNameAndLastName(@RequestBody FirstNameAndLastNameRequest firstNameAndLastNameRequest) {
		List<Utilisateur> utilisateurs = utilisateurService.findByFirstNameAndLastName(firstNameAndLastNameRequest.getFirstName(), firstNameAndLastNameRequest.getLastName());
		if(utilisateurs.isEmpty()) {
			return new ResponseEntity<List<Utilisateur>>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<Utilisateur>>(utilisateurs, HttpStatus.OK);
		}
	}
	
	@GetMapping(path = "/findByFirstNameOrLastNameWithJPQLWithNamedParameters")
	public ResponseEntity<List<Utilisateur>> findByFirstNameOrLastNameWithJPQLWithNamedParameters(@RequestBody FirstNameAndLastNameRequest firstNameAndLastNameRequest) {
		List<Utilisateur> utilisateurs = utilisateurService.findByFirstNameOrLastNameWithJPQLWithNamedParameters(firstNameAndLastNameRequest.getFirstName(), firstNameAndLastNameRequest.getLastName());
		if(utilisateurs.isEmpty()) {
			return new ResponseEntity<List<Utilisateur>>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<Utilisateur>>(utilisateurs, HttpStatus.OK);
		}
	}
	
	@GetMapping(path = "/findByAge")
	public ResponseEntity<List<Utilisateur>> findUtilisateurByAge(@RequestBody List<Integer> ages) {
		List<Utilisateur> utilisateurs = utilisateurService.findByAgeIn(ages);
		if(utilisateurs.isEmpty()) {
			return new ResponseEntity<List<Utilisateur>>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<Utilisateur>>(utilisateurs, HttpStatus.OK);
		}
	}
	
	@GetMapping(path = "/findByStarterDateAfterAndActiveFalse/{date}")
	public ResponseEntity<List<Utilisateur>> findUtilisateurByStarterDateAfterAndActiveFalse(@PathVariable Date date) {
		List<Utilisateur> utilisateurs = utilisateurService.findByStarterDateAfterAndActiveFalse(date);
		if(utilisateurs.isEmpty()) {
			return new ResponseEntity<List<Utilisateur>>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<Utilisateur>>(utilisateurs, HttpStatus.OK);
		}
	}
	
	@GetMapping(path = "/findByRolesTitre/{titre}")
	public ResponseEntity<List<Utilisateur>> findUtilisateurByRoles(@PathVariable String titre) {
		List<Utilisateur> utilisateurs = utilisateurService.findByRolesTitre(titre);
		if(utilisateurs.isEmpty()) {
			return new ResponseEntity<List<Utilisateur>>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<Utilisateur>>(utilisateurs, HttpStatus.OK);
		}
	}
	
	@GetMapping(path = "/findByRolesTitreAndAdressesVille")
	public ResponseEntity<List<Utilisateur>> findUtilisateurByRolesTitreAndAdressesVille(@RequestBody TitreAndVilleRequest titreAndVilleRequest) {
		List<Utilisateur> utilisateurs = utilisateurService.findByRolesTitreAndAdressesVille(titreAndVilleRequest.getTitre(), titreAndVilleRequest.getVille());
		if(utilisateurs.isEmpty()) {
			return new ResponseEntity<List<Utilisateur>>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<Utilisateur>>(utilisateurs, HttpStatus.OK);
		}
	}
	
	@PostMapping
	public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur) {
		return utilisateurService.createUtilisateur(utilisateur);
	}
	 
	@PutMapping
	public Utilisateur updateUtilisateur(@RequestBody Utilisateur utilisateur) {
		return utilisateurService.updateUtilisateur(utilisateur);
	}
	
	@DeleteMapping(path = "/{id}")
	public void deleteUtilisateur(@PathVariable Long id) {
		utilisateurService.deleteUtilisateur(id);
	}

}
