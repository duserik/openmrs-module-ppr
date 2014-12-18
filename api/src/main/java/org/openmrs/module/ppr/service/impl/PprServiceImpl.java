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
package org.openmrs.module.ppr.service.impl;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Encounter;
import org.openmrs.Obs;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.ppr.db.PprDAO;
import org.openmrs.module.ppr.service.PprService;
/**
 * It is a default implementation of {@link ReportingVariablesService}.
 */
public class PprServiceImpl extends BaseOpenmrsService implements PprService {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private PprDAO dao;
	
	/**
     * @param dao the dao to set
     */
    public void setDao(PprDAO dao) {
	    this.dao = dao;
    }
    
    /**
     * @return the dao
     */
    public PprDAO getDao() {
	    return dao;
    }

    @Override
    public Collection<Obs> scheduledVisit(String startDate, String endDate, String gender, String ageRange) {
        return dao.scheduledVisit(startDate, endDate, gender, ageRange);
    }

    @Override
    public Collection<Object[]> followupVisit(String startDate, String endDate, String gender, String ageRange){
        return dao.followupVisit(startDate, endDate, gender, ageRange);
    }

    @Override
    public Collection<Encounter> totalClienSeen(String startDate, String endDate, String gender, String ageRange){
        return dao.totalClienSeen(startDate, endDate, gender, ageRange);
    }
    
    @Override
    public Collection<Encounter> initialVisit(String startDate, String endDate, String gender, String ageRange){
        return dao.initialVisit(startDate, endDate, gender, ageRange);
    }
    
    @Override
    public Collection<Object[]> followupCD4Tests(String startDate, String endDate, String gender, String ageRange){
        return dao.followupCD4Tests(startDate, endDate, gender, ageRange);
    }
    
    @Override
    public Collection<Obs> initialCD4Tests(String startDate, String endDate, String gender, String ageRange){
        return dao.initialCD4Tests(startDate, endDate, gender, ageRange);
    }
    
    @Override
    public Collection<Object[]> clientOnART(String startDate, String endDate, String gender, String ageRange){
        return dao.clientOnART(startDate, endDate, gender, ageRange);
    }
    
    @Override
    public Collection<Object[]> deceasedNotOnART(String startDate, String endDate, String gender, String ageRange){
        return dao.deceasedNotOnART(startDate, endDate, gender, ageRange);
    }
    
    @Override
    public Collection<Object[]> deceasedARTClients(String startDate, String endDate, String gender, String ageRange){
        return dao.deceasedARTClients(startDate, endDate, gender, ageRange);
    }

    @Override
    public Collection<Encounter> clientSeenByNurse(String startDate, String endDate, String gender, String ageRange) {
        return dao.clientSeenByNurse(startDate, endDate, gender, ageRange);
    }

    @Override
    public Collection<Encounter> clientSeenByPhysician(String startDate, String endDate, String gender, String ageRange) {
        return dao.clientSeenByPhysician(startDate, endDate, gender, ageRange);
    }

    @Override
    public Collection<Object[]> missedAppointment(String startDate, String endDate, String gender, String ageRange) {
        return dao.missedAppointment(startDate, endDate, gender, ageRange);
    }
}