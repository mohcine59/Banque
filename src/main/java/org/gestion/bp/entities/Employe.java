package org.gestion.bp.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Employe implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeEmploye;
	private String nomEmploye;
	@ManyToOne
	@JoinColumn(name="code_emp_sup")
	private Employe employeSup;
	@ManyToMany //implique joinTable
	@JoinTable(name="EMP_GR")
	private Collection<Groupe> groupes;
	public Long getCodeEmploye() {
		return codeEmploye;
	}
	public void setCodeEmploye(Long codeEmploye) {
		this.codeEmploye = codeEmploye;
	}
	public String getNomEmploye() {
		return nomEmploye;
	}
	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}
	public Employe getEmployeSup() {
		return employeSup;
	}
	public void setEmployeSup(Employe employeSup) {
		this.employeSup = employeSup;
	}
	public Collection<Groupe> getGroupes() {
		return groupes;
	}
	public void setGroupes(Collection<Groupe> groupes) {
		this.groupes = groupes;
	}
	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
