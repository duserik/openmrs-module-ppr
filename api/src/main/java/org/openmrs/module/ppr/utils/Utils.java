/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.ppr.utils;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openmrs.Encounter;
import org.openmrs.Obs;
import org.openmrs.module.ppr.Ppr;

public class Utils {
	public static Map getDaysNameByDate(String startDate, String endDate) {

		List<Obs> moObs = new ArrayList<Obs>();
		List<Obs> tuObs = new ArrayList<Obs>();
		List<Obs> weObs = new ArrayList<Obs>();
		List<Obs> thObs = new ArrayList<Obs>();
		List<Obs> frObs = new ArrayList<Obs>();
		List<Obs> suObs = new ArrayList<Obs>();

		HashMap<String, Date> map = new HashMap<String, Date>();

		GregorianCalendar gcal = new GregorianCalendar();
		GregorianCalendar gcalEnd = new GregorianCalendar();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date start = null, end = null, ende = null;
		try {
			start = sdf.parse(startDate);
		} catch (ParseException e) {
		}

		try {
			ende = sdf.parse(endDate);
		} catch (ParseException e) {
		}

		gcal.setTime(start);
		gcalEnd.setTime(ende);
		gcalEnd.add(Calendar.DAY_OF_YEAR, 1);
		end = gcalEnd.getTime();

		String dayNames[] = new DateFormatSymbols().getWeekdays();

		while (gcal.getTime().before(end)) {

			// System.out.println("Day of week: " +
			// dayNames[gcal.get(Calendar.DAY_OF_WEEK)] + " Date: " +
			// gcal.getTime().toString() + " End: " + ende);

			// if(gcal.getTime().equals(ende)) {
			// System.out.println("Yeahhhhhhhhhhhhh!!!!");
			// }

			if (dayNames[gcal.get(Calendar.DAY_OF_WEEK)].toString().equals(
					"Monday"))
				map.put("Monday", gcal.getTime());

			if (dayNames[gcal.get(Calendar.DAY_OF_WEEK)].toString().equals(
					"Tuesday"))
				map.put("Tuesday", gcal.getTime());

			if (dayNames[gcal.get(Calendar.DAY_OF_WEEK)].toString().equals(
					"Wednesday"))
				map.put("Wednesday", gcal.getTime());

			if (dayNames[gcal.get(Calendar.DAY_OF_WEEK)].toString().equals(
					"Thursday"))
				map.put("Thursday", gcal.getTime());

			if (dayNames[gcal.get(Calendar.DAY_OF_WEEK)].toString().equals(
					"Friday"))
				map.put("Friday", gcal.getTime());

			if (dayNames[gcal.get(Calendar.DAY_OF_WEEK)].toString().equals(
					"Saturday"))
				map.put("Saturday", gcal.getTime());

			gcal.add(Calendar.DAY_OF_YEAR, 1);
		}
		return map;
	}

	public static Ppr indicatorsPerDays(String startDate, String endDate,
			Collection<Obs> obsList, Collection<Encounter> encList,
			Collection<Object[]> orderList) throws ParseException {

		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		Ppr ppr = null;

		List<Obs> moInd = new ArrayList<Obs>();
		List<Obs> tuInd = new ArrayList<Obs>();
		List<Obs> weInd = new ArrayList<Obs>();
		List<Obs> thInd = new ArrayList<Obs>();
		List<Obs> frInd = new ArrayList<Obs>();
		List<Obs> suInd = new ArrayList<Obs>();

		List<Encounter> moInd1 = new ArrayList<Encounter>();
		List<Encounter> tuInd1 = new ArrayList<Encounter>();
		List<Encounter> weInd1 = new ArrayList<Encounter>();
		List<Encounter> thInd1 = new ArrayList<Encounter>();
		List<Encounter> frInd1 = new ArrayList<Encounter>();
		List<Encounter> suInd1 = new ArrayList<Encounter>();

		List<Object[]> moInd2 = new ArrayList<Object[]>();
		List<Object[]> tuInd2 = new ArrayList<Object[]>();
		List<Object[]> weInd2 = new ArrayList<Object[]>();
		List<Object[]> thInd2 = new ArrayList<Object[]>();
		List<Object[]> frInd2 = new ArrayList<Object[]>();
		List<Object[]> suInd2 = new ArrayList<Object[]>();

		if (obsList != null) {
			for (Obs obs : obsList) {
				if (formater.parse(
						obs.getValueDatetime() != null ? obs.getValueDatetime()
								.toString() : obs.getObsDatetime().toString())
						.equals(getDaysNameByDate(startDate, endDate).get(
								"Monday"))) {
					moInd.add(obs);
				}

				if (formater.parse(
						obs.getValueDatetime() != null ? obs.getValueDatetime()
								.toString() : obs.getObsDatetime().toString())
						.equals(getDaysNameByDate(startDate, endDate).get(
								"Tuesday"))) {
					tuInd.add(obs);
				}

				if (formater.parse(
						obs.getValueDatetime() != null ? obs.getValueDatetime()
								.toString() : obs.getObsDatetime().toString())
						.equals(getDaysNameByDate(startDate, endDate).get(
								"Wednesday"))) {
					weInd.add(obs);
				}

				if (formater.parse(
						obs.getValueDatetime() != null ? obs.getValueDatetime()
								.toString() : obs.getObsDatetime().toString())
						.equals(getDaysNameByDate(startDate, endDate).get(
								"Thursday"))) {
					thInd.add(obs);
				}

				if (formater.parse(
						obs.getValueDatetime() != null ? obs.getValueDatetime()
								.toString() : obs.getObsDatetime().toString())
						.equals(getDaysNameByDate(startDate, endDate).get(
								"Friday"))) {
					frInd.add(obs);
				}

				if (formater.parse(
						obs.getValueDatetime() != null ? obs.getValueDatetime()
								.toString() : obs.getObsDatetime().toString())
						.equals(getDaysNameByDate(startDate, endDate).get(
								"Saturday"))) {
					suInd.add(obs);
				}
			}
			ppr = new Ppr(moInd.size(), tuInd.size(), weInd.size(),
					thInd.size(), frInd.size(), suInd.size());
		}

		if (encList != null) {
			for (Encounter enc : encList) {
				if (formater.parse(enc.getEncounterDatetime().toString())
						.equals(getDaysNameByDate(startDate, endDate).get(
								"Monday"))) {
					moInd1.add(enc);
				}

				if (formater.parse(enc.getEncounterDatetime().toString())
						.equals(getDaysNameByDate(startDate, endDate).get(
								"Tuesday"))) {
					tuInd1.add(enc);
				}

				if (formater.parse(enc.getEncounterDatetime().toString())
						.equals(getDaysNameByDate(startDate, endDate).get(
								"Wednesday"))) {
					weInd1.add(enc);
				}

				if (formater.parse(enc.getEncounterDatetime().toString())
						.equals(getDaysNameByDate(startDate, endDate).get(
								"Thursday"))) {
					thInd1.add(enc);
				}

				if (formater.parse(enc.getEncounterDatetime().toString())
						.equals(getDaysNameByDate(startDate, endDate).get(
								"Friday"))) {
					frInd1.add(enc);
				}

				if (formater.parse(enc.getEncounterDatetime().toString())
						.equals(getDaysNameByDate(startDate, endDate).get(
								"Saturday"))) {
					suInd1.add(enc);
				}
			}
			ppr = new Ppr(moInd1.size(), tuInd1.size(), weInd1.size(),
					thInd1.size(), frInd1.size(), suInd1.size());

		}

		if (orderList != null) {
			for (Object[] object : orderList) {
				if (formater.parse(object[1].toString()).equals(
						getDaysNameByDate(startDate, endDate).get("Monday"))) {
					moInd2.add(object);
				}

				if (formater.parse(object[1].toString()).equals(
						getDaysNameByDate(startDate, endDate).get("Tuesday"))) {
					tuInd2.add(object);
				}

				if (formater.parse(object[1].toString()).equals(
						getDaysNameByDate(startDate, endDate).get("Wednesday"))) {
					weInd2.add(object);
				}

				if (formater.parse(object[1].toString()).equals(
						getDaysNameByDate(startDate, endDate).get("Thursday"))) {
					thInd2.add(object);
				}

				if (formater.parse(object[1].toString()).equals(
						getDaysNameByDate(startDate, endDate).get("Friday"))) {
					frInd2.add(object);
				}

				if (formater.parse(object[1].toString()).equals(
						getDaysNameByDate(startDate, endDate).get("Saturday"))) {
					suInd2.add(object);
				}
			}
			ppr = new Ppr(moInd2.size(), tuInd2.size(), weInd2.size(),
					thInd2.size(), frInd2.size(), suInd2.size());
		}

		return ppr;
	}
}
