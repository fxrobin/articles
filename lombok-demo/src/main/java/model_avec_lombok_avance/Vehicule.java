package model_avec_lombok_avance;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@SuppressWarnings("serial")

@FieldDefaults(level=AccessLevel.PRIVATE)
@RequiredArgsConstructor(staticName="of")
@EqualsAndHashCode(of= {"numeroMoteur","numeroChassis"})
@ToString(of= {"numeroMoteur","numeroChassis","numeroImmatriculation","dateMiseEnCirculation"})
public class Vehicule implements Serializable
{
	@Getter
	final String numeroMoteur;

	@Getter
	final String numeroChassis;
	
	@Getter
	final LocalDate dateMiseEnCirculation;

	@Getter	@Setter
	String numeroImmatriculation;
	
	// champs de relation
	@Getter
	List<Intervention> interventions = new ArrayList<>();
}

