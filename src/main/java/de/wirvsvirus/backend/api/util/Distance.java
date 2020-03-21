package de.wirvsvirus.backend.api.util;

import de.wirvsvirus.backend.api.model.entity.UserCoordinate;
import de.wirvsvirus.backend.api.model.entity.UserOffer;

import static java.lang.Math.toRadians;

public class Distance {

	/**
	 *
	 * @param offer The offer of an human in quarantine
	 * @param user The {@link UserCoordinate} of the helping person
	 * @param distance acceptable distance in kilometers
	 * @return true if the distance between the two coordinates is less or equals the given distance
	 */
	public static boolean isInRange(UserOffer offer, UserCoordinate user, long distance){
		return calculateDistance(offer.getUserCoordinate(), user) <= distance;
	}

	/**
	 *
	 * @param c1 The first coordinate
	 * @param c2 The second coordinate
	 * @return The distance between these two points
	 */
	public static double calculateDistance(UserCoordinate c1, UserCoordinate c2){
		int r = 6371000; // metres
		double radian1 = toRadians(c1.getLatitude());
		double radian2 = toRadians(c2.getLatitude());
		double deltaLat = toRadians(c2.getLatitude() - c1.getLatitude());
		double deltaLon = toRadians(c2.getLongitude() - c1.getLongitude());

		double a = Math.sin(deltaLat/2) * Math.sin(deltaLat/2) +
				Math.cos(radian1) * Math.cos(radian2) *
						Math.sin(deltaLon/2) * Math.sin(deltaLon/2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

		return r * c;
	}
}
