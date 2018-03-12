package model_avec_lombok_builder;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MainProg {

	public static void main(String[] args) {

		Vehicule.VehiculeBuilder builder = Vehicule.builder();
		
		Vehicule v = builder.numeroChassis("AABBCC123")
				.numeroMoteur("X06123")
				.dateMiseEnCirculation(LocalDate.of(1989, 01, 18))
				.numeroImmatriculation("AA-123-BB")
				.intervention(Intervention.of(LocalDate.of(2018, 03, 05), 1850000L, "Vidange", new BigDecimal("175.0")))
				.intervention(Intervention.of(LocalDate.of(2018, 02, 03), 1840000L, "Freins", new BigDecimal("210.0")))
				.intervention(Intervention.of(LocalDate.of(2018, 01, 15), 1830000L, "Embrayage", new BigDecimal("350.0")))
				.intervention(Intervention.of(LocalDate.of(2017, 12, 10), 1820000L, "Pneus", new BigDecimal("450.0")))
				.build();
		
		System.out.println(v);
		v.getInterventions().forEach(System.out::println);
		
		
		Vehicule v1 = VehiculeFactory.smallBuilder()
					  .numeroChassis("AAABB123")
					  .numeroMoteur("123ABCD")
					  .build();
		
		Vehicule v2 = VehiculeFactory.fullBuilder()
				      .numeroChassis("AAABB578")
				      .numeroMoteur("458AAA")
				      .dateMiseEnCirculation(LocalDate.now())
				      .numeroImmatriculation("789-AAA-987")
				      .build();
		
		System.out.println(v1);
		System.out.println(v2);

	}

}
