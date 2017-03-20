package org.gestion.bp.metier;

import java.util.Date;
import java.util.List;

import org.gestion.bp.dao.IBanqueDao;
import org.gestion.bp.entities.Client;
import org.gestion.bp.entities.Compte;
import org.gestion.bp.entities.Employe;
import org.gestion.bp.entities.Groupe;
import org.gestion.bp.entities.Operation;
import org.gestion.bp.entities.Retrait;
import org.gestion.bp.entities.Versement;
import org.springframework.transaction.annotation.Transactional;

@Transactional //toutes les methodes sont transactionelles (rollback...)
public class BanqueMetierImpl implements IBanqueMetier{
	
	private IBanqueDao dao;
	
	public void setDao(IBanqueDao dao){
		this.dao = dao;
	}

	@Override
	public Client addClient(Client c) {
		return dao.addClient(c);
	}

	@Override
	public Employe addEmploye(Employe e, Long codeSup) {
		return dao.addEmploye(e, codeSup);
	}

	@Override
	public Groupe addGroupe(Groupe g) {
		return dao.addGroupe(g);
	}

	@Override
	public void addEmployeToGroupe(Long codeEmp, Long codeGroup) {
		dao.addEmployeToGroupe(codeEmp, codeGroup);
	}

	@Override
	public Compte addCompte(Compte cp, Long codeCli, Long codeEmp) {
		return dao.addCompte(cp, codeCli, codeEmp);
	}

	@Override
	public void verser(double mt, String cpte, Long codeEmp) {
		Versement v = new Versement();
		v.setMontant(mt);
		v.setDateOperation(new Date());
		dao.addOperation(v, cpte, codeEmp);
		Compte cp = dao.consulterCompte(cpte);
		cp.setSolde(cp.getSolde()+mt);
		
		
	}

	@Override
	public void retrait(double mt, String cpte, Long codeEmp) {
		Retrait r = new Retrait();
		r.setMontant(mt);
		r.setDateOperation(new Date());
		dao.addOperation(r, cpte, codeEmp);
		Compte cp = dao.consulterCompte(cpte);
		cp.setSolde(cp.getSolde()-mt);
	}

	@Override
	public void virement(double mt, String cpte1, String cpte2, Long codeEmp) {
		retrait(mt, cpte1, codeEmp);
		verser(mt, cpte2, codeEmp);
	}

	@Override
	public Compte consulterCompte(String codeCpte) {
		return dao.consulterCompte(codeCpte);
	}

	@Override
	public List<Operation> consulterOperation(String codeCpte) {
		return dao.consulterOperation(codeCpte);
	}
	
	@Override
	public Operation addOperation(Operation op, String codeCpte, Long codeEmp) {
		return dao.addOperation(op, codeCpte, codeEmp);
	}

	@Override
	public Client consulterClient(Long codeCli) {
		return dao.consulterClient(codeCli);
	}

	@Override
	public List<Client> consulterClients(String motClef) {
		return dao.consulterClients(motClef);
	}

	@Override
	public List<Compte> getComptesByClient(Long codeCli) {
		return dao.getComptesByClient(codeCli);
	}

	@Override
	public List<Compte> getComptesByEmploye(Long codeEmp) {
		return dao.getComptesByEmploye(codeEmp);
	}

	@Override
	public List<Employe> getEmployes() {
		return dao.getEmployes();
	}

	@Override
	public List<Groupe> getGroupes() {
		return dao.getGroupes();
	}

	@Override
	public List<Employe> getEmployesByGroupe(Long codeGr) {
		return dao.getEmployesByGroupe(codeGr);
	}



	
}
