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
package org.openmrs.module.ppr.service;

import java.util.Collection;

import org.openmrs.Encounter;
import org.openmrs.Obs;
import org.openmrs.api.OpenmrsService;
import org.springframework.transaction.annotation.Transactional;

/**
 * This service exposes module's core functionality. It is a Spring managed bean which is configured in moduleApplicationContext.xml.
 * <p>
 * It can be accessed only via Context:<br>
 * <code>
 * Context.getService(Ppr.class).someMethod();
 * </code>
 * 
 * @see org.openmrs.api.context.Context
 */
@Transactional
public interface PprService extends OpenmrsService {	
	public Collection<Obs> scheduledVisit(String startDate, String endDate, String gender, String ageRange);
	public Collection<Object[]> followupVisit(String startDate, String endDate, String gender, String ageRange);
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