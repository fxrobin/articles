package model_avec_lombok_avance;

import java.time.LocalDate;

public class MainProg {

	public static void main(String[] args) {
		
		Vehicule v = Vehicule.of("AABBCC123", "X06123", LocalDate.of(1989, 01, 18));
		v.setNumeroImmatriculation("AA-123-BB");
		System.out.println(v);

	}

}
