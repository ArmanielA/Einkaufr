package de.wirvsvirus.backend.api.util;

import de.wirvsvirus.backend.api.model.UserCoordinate;
import de.wirvsvirus.backend.api.model.UserOffer;

public class Distance {

	/**
	 *
	 * @param offer The offer of an human in quarantine
	 * @param user The {@link UserCoordinate} of the helping person
	 * @param distance acceptable distance in kilometers
	 * @return true if the distance between the two coordinates is less or equals the given distance
	 */
	public static boolean isInRange(UserOffer offer, UserCoordinate user, long distance){
		return false;
	}
}
