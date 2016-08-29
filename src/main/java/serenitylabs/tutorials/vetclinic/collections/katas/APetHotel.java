package serenitylabs.tutorials.vetclinic.collections.katas;

import java.util.List;
import java.util.Random;

import com.google.common.collect.ImmutableList;

import serenitylabs.tutorials.vetclinic.Breed;
import serenitylabs.tutorials.vetclinic.Pet;

/**
 * A utility class to generate pet hotels with pets already booked
 */
public class APetHotel {
    public static PetAdder with(int petCount) {
        return new PetAdder(petCount);
    }

	public static class PetAdder {
		private final int petCount;

		public PetAdder(int petCount) {
			this.petCount = petCount;
		}

		private Pet somePet(int petCount) {
			return new Pet(someName(petCount), someBreed());
		}

		private final static Random random = new Random();

		private Breed someBreed() {
			return Breed.values()[random.nextInt(Breed.values().length)];
		}

		private final static List<String> PET_NAMES = ImmutableList.of("Fido", "Felix", "Rover", "Spot");

		private String someName(int petCount) {
			return PET_NAMES.get(random.nextInt(PET_NAMES.size())) + " " + petCount;
		}
	}
}
