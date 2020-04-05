package net.mims.minnlakes.data;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import net.mims.minnlakes.domain.FishSpecies;
import net.mims.minnlakes.domain.Waterbody;

public class WriteMinnDataToDatabase {

	Session session = null;
	Transaction transaction = null;

	public WriteMinnDataToDatabase(ArrayList<Waterbody> waterbodies) {

		// HashMap<String, FishSpecies> fishHashMap =
		// createFishSpeciesHashMap(waterbodies);

		try {

			this.session = HibernateUtil.getSessionFactory().openSession();
			this.transaction = session.beginTransaction();

			HashMap<String, FishSpecies> fishHashMap = createFishSpeciesHashMap(waterbodies);

			System.out.println(fishHashMap.size());

			for (Waterbody waterbody : waterbodies) {
				
				HashSet<FishSpecies> hashedFish = new HashSet<FishSpecies>(); 

				for (FishSpecies fishSpecies : waterbody.getFishSpeciesList()){
					
					hashedFish.add(fishHashMap.get(fishSpecies.getFishTypeName()));
					

				}
				
				waterbody.getFishSpeciesList().clear();
				waterbody.addFishSpeciesList(hashedFish);

				this.session.save(waterbody);

			}
		 this.transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				System.out.println("Transaction is being rolled back.");
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {

			// if (session != null) {
			// session.close();
			// }
		}

		// HibernateUtil.shutdown();
		return;
	}

	HashMap<String, FishSpecies> createFishSpeciesHashMap(ArrayList<Waterbody> waterbodies) {

		HashMap<String, FishSpecies> fishHashMap = new HashMap<String, FishSpecies>();

		// this.session = HibernateUtil.getSessionFactory().openSession();
		// this.transaction = session.beginTransaction();

		for (Waterbody waterbody : waterbodies) {

			for (FishSpecies fishSpecies : waterbody.getFishSpeciesList()) {

				if (!fishHashMap.containsKey(fishSpecies.getFishTypeName()))

					fishHashMap.put(fishSpecies.getFishTypeName(), fishSpecies);

			}

		}

		return fishHashMap;

	}

}
