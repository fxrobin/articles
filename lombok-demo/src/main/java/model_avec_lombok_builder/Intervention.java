package model_avec_lombok_builder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@SuppressWarnings("serial")
@FieldDefaults(level=AccessLevel.PRIVATE)
@AllArgsConstructor(staticName="of")
@ToString
@Getter
public class Intervention implements Serializable, Comparable<Intervention> 
{
	final LocalDate dateIntervention;
	
	final Long kilometrage;
	
	@Setter
	String libelle;
	
	@Setter
	BigDecimal prix;

	@Override
	public int compareTo(Intervention o) 
	{	
		return this.dateIntervention.compareTo(o.getDateIntervention());
	}
}
