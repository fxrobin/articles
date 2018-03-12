package model_avec_lombok_builder;

import java.time.LocalDate;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.UtilityClass;

@UtilityClass
public class VehiculeFactory 
{
	@Builder(builderClassName="SmallBuilder", builderMethodName="smallBuilder")
	public static Vehicule newVehicule(String numeroChassis, String numeroMoteur)
	{
		return Vehicule.builder().numeroChassis(numeroChassis)
						  .numeroMoteur(numeroMoteur)
						  .dateMiseEnCirculation(LocalDate.now())
						  .numeroImmatriculation("XX-XXX-XX")
						  .build();
	}
	
	@Builder(builderClassName="FullBuilder", builderMethodName="fullBuilder")
	public static Vehicule newVehicule(String numeroChassis, 
									   String numeroMoteur, 
									   LocalDate dateMiseEnCirculation, 
									   String numeroImmatriculation)
	{
		return Vehicule.builder().numeroChassis(numeroChassis)
						  .numeroMoteur(numeroMoteur)
						  .dateMiseEnCirculation(dateMiseEnCirculation)
						  .numeroImmatriculation(numeroImmatriculation)
						  .build();
	}
}
