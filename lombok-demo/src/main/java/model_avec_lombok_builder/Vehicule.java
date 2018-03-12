package model_avec_lombok_builder;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@SuppressWarnings("serial")

@FieldDefaults(level=AccessLevel.PRIVATE)
@EqualsAndHashCode(of= {"numeroMoteur","numeroChassis"})
@ToString(of= {"numeroMoteur","numeroChassis","numeroImmatriculation","dateMiseEnCirculation"})
@Builder
public class Vehicule implements Serializable
{
	@Getter
	@NonNull
	String numeroMoteur;

	@Getter
	@NonNull
	String numeroChassis;
	
	@Getter
	@NonNull
	LocalDate dateMiseEnCirculation;

	@Getter	@Setter
	String numeroImmatriculation;
	
	// champs de relation
	@Getter
	@Singular
	List<Intervention> interventions = new ArrayList<>();
}

