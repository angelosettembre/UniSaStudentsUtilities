package onlyTest;



import gestioneMaterialeDidattico.Risorsa;
import gestioneUtente.Utente;

import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import gestioneVendite.CondizioneLibro;
import gestioneVendite.GestoreLibri;
import storageLayer.DatabaseGM;
import storageLayer.DatabaseGU;

public class TestDb {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		// boolean b=DatabaseGU.addUser(new Utente("erfre", "Brgrgco",
		// "giggdsfdsgdsgl.it", "cucccabacucco",true ,false));
		// Utente c=DatabaseGU.getUtenteByID("ang@hotmail.it");
		// System.out.println(c);
		// boolean b=DatabaseGU.deleteUser("giggimiticol@hotmail.it");
		// System.out.println(b);

		// GestoreLibri gst = new GestoreLibri();
		//Risorsa r = DatabaseGM.getRisorsaByID(0);
		//System.out.println(r);
		Date data=new Date(2016, 12, 16);
		Risorsa risorsa=new Risorsa("materiale", "ang@hotmail.it", 10, data, 5, 0, "src/banana");
		System.out.println(DatabaseGM.insertRisorsa(risorsa));
		// if(gst.inserisciAnnuncio("qwe", "Something", CondizioneLibro.nuovo,
		// "Prog Distribuita", 40, "Gigi", 2016, "Libro di prog distr", new
		// Date(), "JavaEE", "pas@hotmail.it"))
		// System.out.println("inserimento avvenuto");
		/*
		 * if(gst.inserisciAnnuncio("qwe", "qwe", CondizioneLibro.nuovo, "qwe",
		 * 40, "Gigi", 2016, "Libro di prog distr", new Date(2016, 12, 12),
		 * "JavaEE", "pas@hotmail.it"))
		 * System.out.println("inserimento avvenuto2");
		 */
		//boolean b=DatabaseGU.addUser(new Utente("erfre", "Brgrgco", "giggdsfdsgdsgl.it", "cucccabacucco",true ,false));
		Utente c=DatabaseGU.getUtenteByID("ang@hootmail.it");
		System.out.println(c);
		//boolean b=DatabaseGU.deleteUser("giggimiticol@hotmail.it");
		//System.out.println(b);
				
		//GestoreLibri gst = new GestoreLibri();
			
	
		//if(gst.inserisciAnnuncio("qwe", "Something", CondizioneLibro.nuovo, "Prog Distribuita", 40, "Gigi", 2016, "Libro di prog distr", new Date(), "JavaEE", "pas@hotmail.it"))
		//	System.out.println("inserimento avvenuto");
		/*if(gst.inserisciAnnuncio("qwe", "qwe", CondizioneLibro.nuovo, "qwe", 40, "Gigi", 2016, "Libro di prog distr", new Date(2016, 12, 12), "JavaEE", "pas@hotmail.it"))
			System.out.println("inserimento avvenuto2");*/
	}

}