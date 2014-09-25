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
package org.openmrs.module.ppr.db;

import java.util.Collection;

import org.openmrs.Encounter;
import org.openmrs.Obs;
import org.openmrs.module.ppr.service.PprService;
/**
 *  Database methods for {@link PprService}.
 */
public interface PprDAO {	
	
	public Collection<Obs> scheduledVisit(String startDate, String endDate, String gender, String ageRange);
	public Collection<Encounter> followupVisit(String startDate, String endDate, String gender, String ageRange);
	public Collection<Encounter> totalClienSeen(String startDate, String endDate, String gender, String ageRange);
	public Collection<Encounter> initialVisit(String startDate, String endDate, String gender, String ageRange);
	public Collection<Object[]> followupCD4Tests(String startDate, String endDate, String gender, String ageRange);
	public Collection<Obs> initialCD4Tests(String startDate, String endDate, String gender, String ageRange);
	public Collection<Object[]> clientOnART(String startDate, String endDate, String gender, String ageRange);
	public Collection<Object[]> deceasedNotOnART(String startDate, String endDate, String gender, String ageRange);
	public Collection<Object[]> deceasedARTClients(String startDate, String endDate, String gender, String ageRange);
	public Collection<Encounter> clientSeenByNurse(String startDate, String endDate, String gender, String ageRange);
	public Collection<Encounter> clientSeenByPhysician(String startDate, String endDate, String gender, String ageRange);
	public Collection<Object[]> missedAppointment(String startDate, String endDate, String gender, String ageRange);
}