package model_no_lombok;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Vehicule implements Serializable
{
	// champs métier
	private String numeroMoteur;
	private String numeroChassis;
	private String numeroImmatriculation;
	private LocalDate dateMiseEnCirculation;
	
	// champs de relation
	private List<Intervention> interventions;
	
	// constructeurs
	public Vehicule()
	{
		interventions = new ArrayList<>();
	}
	
	public Vehicule(String numeroMoteur, 
			String numeroChassis, 
			String numeroImmatriculation, 
			LocalDate dateMiseEnCirculation)
	{
		this();
		this.numeroMoteur = numeroMoteur;
		this.numeroChassis = numeroChassis;
		this.numeroImmatriculation = numeroImmatriculation;
		this.dateMiseEnCirculation = dateMiseEnCirculation;
	}

	// getters/setters : génération par Eclipse
	
	public String getNumeroMoteur() 
	{
		return numeroMoteur;
	}

	public void setNumeroMoteur(String numeroMoteur) 
	{
		this.numeroMoteur = numeroMoteur;
	}

	public String getNumeroChassis() 
	{
		return numeroChassis;
	}

	public void setNumeroChassis(String numeroChassis) 
	{
		this.numeroChassis = numeroChassis;
	}

	public String getNumeroImmatriculation() 
	{
		return numeroImmatriculation;
	}

	public void setNumeroImmatriculation(String numeroImmatriculation) 
	{
		this.numeroImmatriculation = numeroImmatriculation;
	}

	public LocalDate getDateMiseEnCirculation() {
		return dateMiseEnCirculation;
	}

	public void setDateMiseEnCirculation(LocalDate dateMiseEnCirculation) {
		this.dateMiseEnCirculation = dateMiseEnCirculation;
	}

	public List<Intervention> getInterventions() 
	{
		return interventions;
	}

	public void setInterventions(List<Intervention> interventions) 
	{
		this.interventions = interventions;
	}
	
	// equals/hashCode : génération par Eclipse
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroChassis == null) ? 0 : numeroChassis.hashCode());
		result = prime * result + ((numeroMoteur == null) ? 0 : numeroMoteur.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicule other = (Vehicule) obj;
		if (numeroChassis == null) {
			if (other.numeroChassis != null)
				return false;
		} else if (!numeroChassis.equals(other.numeroChassis))
			return false;
		if (numeroMoteur == null) {
			if (other.numeroMoteur != null)
				return false;
		} else if (!numeroMoteur.equals(other.numeroMoteur))
			return false;
		return true;
	}	
	
	
	// toString : génération via Eclipse avec "StringBuilder chaining".
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Vehicule [numeroMoteur=")
			 	.append(numeroMoteur)
			 	.append(", numeroChassis=")
			 	.append(numeroChassis)
				.append(", numeroImmatriculation=")
				.append(numeroImmatriculation)
				.append(", dateMiseEnCirculation=")
				.append(dateMiseEnCirculation)
				.append(", interventions=")
				.append(interventions)
				.append("]");
		return builder.toString();
	}	
}

