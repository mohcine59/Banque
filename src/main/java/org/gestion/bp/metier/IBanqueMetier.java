package org.gestion.bp.metier;

import java.util.List;

import org.gestion.bp.entities.Client;
import org.gestion.bp.entities.Compte;
import org.gestion.bp.entities.Employe;
import org.gestion.bp.entities.Groupe;
import org.gestion.bp.entities.Operation;

public interface IBanqueMetier {

	public Client addClient(Client c);
	public Employe addEmploye(Employe e, Long codeSup);
	public Groupe addGroupe(Groupe g);
	public void addEmployeToGroupe(Long codeEmp, Long codeGroup);
	public Compte addCompte(Compte cp, Long codeCli, Long codeEmp);
	public void verser(double mt, String cpte, Long codeEmp);
	public void virement(double mt, String cpte1, String cpte2, Long codeEmp);
	public void retrait(double mt, String cpte, Long codeEmp);
	public Operation addOperation(Operation op, String codeCpte, Long codeEmp);
	public Compte consulterCompte(String codeCpte);
	public List<Operation> consulterOperation(String codeCpte);
	public Client consulterClient(Long codeCli);
	public List<Client> consulterClients(String motClef);
	public List<Compte> getComptesByClient(Long codeCli);
	public List<Compte> getComptesByEmploye(Long codeEmp);
	public List<Employe> getEmployes();
	public List<Groupe> getGroupes();
	public List<Employe> getEmployesByGroupe(Long codeGr);
}
