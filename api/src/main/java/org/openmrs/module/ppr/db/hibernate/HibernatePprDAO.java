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
package org.openmrs.module.ppr.db.hibernate;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.SQLGrammarException;
import org.openmrs.Encounter;
import org.openmrs.Obs;
import org.openmrs.module.ppr.db.PprDAO;

/**
 * It is a default implementation of  {@link PprDAO}.
 */
public class HibernatePprDAO implements PprDAO {
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private SessionFactory sessionFactory;
	
	/**
     * @param sessionFactory the sessionFactory to set
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
	    this.sessionFactory = sessionFactory;
    }
    
	/**
     * @return the sessionFactory
     */
    public SessionFactory getSessionFactory() {
	    return sessionFactory;
    }

	@Override
	public Collection<Obs> scheduledVisit(String startDate, String endDate, String gender, String ageRange) {

		StringBuffer sb = new StringBuffer();

		sb.append("SELECT o.* FROM obs o INNER JOIN person p ON o.person_id = p.person_id WHERE concept_id = 5096");

		if(startDate != null && !startDate.equals(""))
			sb.append(" AND value_datetime >= '" + startDate + "' ");

		if(endDate != null && !endDate.equals(""))
			sb.append(" AND value_datetime <= '" + endDate + "' ");

		if(gender != null && !gender.equals(""))
			sb.append(" AND p.gender = '" + gender + "' ");

		if(ageRange != null && !ageRange.equals(""))
			sb.append(" AND  DATEDIFF('" + endDate	+ "', STR_TO_DATE(p.birthdate, '%Y-%m-%d'))/365 " + ageRange + " ");

		sb.append(" AND o.voided = 0;");

		Session session = sessionFactory.getCurrentSession();

		Collection<Obs> collection = session.createSQLQuery(sb.toString()).addEntity("obs", Obs.class).list();

		return collection;
	}

    @Override
    public Collection<Encounter> followupVisit(String startDate, String endDate, String gender, String ageRange) {

		StringBuffer sb = new StringBuffer();

		sb.append("SELECT e.* FROM encounter e INNER JOIN person p ON e.patient_id = p.person_id WHERE encounter_type = 2");

		if(startDate != null && !startDate.equals(""))
			sb.append(" AND e.encounter_datetime >= '" + startDate + "' ");

		if(endDate != null && !endDate.equals(""))
			sb.append(" AND e.encounter_datetime <= '" + endDate + "' ");

		if(gender != null && !gender.equals(""))
			sb.append(" AND p.gender = '" + gender + "' ");

		if(ageRange != null && !ageRange.equals(""))
			sb.append(" AND  DATEDIFF('" + endDate	+ "', STR_TO_DATE(p.birthdate, '%Y-%m-%d'))/365 " + ageRange + " ");

		sb.append(" AND e.voided = 0;");

		Session session = sessionFactory.getCurrentSession();

		Collection<Encounter> collection = session.createSQLQuery(sb.toString()).addEntity("encounter", Encounter.class).list();

		return collection;
    }

    @Override
    public Collection<Encounter> totalClienSeen(String startDate, String endDate, String gender, String ageRange){
        

		StringBuffer sb = new StringBuffer();

		sb.append("SELECT e.* FROM encounter e INNER JOIN person p ON e.patient_id = p.person_id WHERE 1 = 1");

		if(startDate != null && !startDate.equals(""))
			sb.append(" AND e.encounter_datetime >= '" + startDate + "' ");

		if(endDate != null && !endDate.equals(""))
			sb.append(" AND e.encounter_datetime <= '" + endDate + "' ");

		if(gender != null && !gender.equals(""))
			sb.append(" AND p.gender = '" + gender + "' ");

		if(ageRange != null && !ageRange.equals(""))
			sb.append(" AND  DATEDIFF('" + endDate	+ "', STR_TO_DATE(p.birthdate, '%Y-%m-%d'))/365 " + ageRange + " ");

		sb.append(" AND e.voided = 0;");

		Session session = sessionFactory.getCurrentSession();

		Collection<Encounter> collection = session.createSQLQuery(sb.toString()).addEntity("encounter", Encounter.class).list();

		return collection;
    }
    
    @Override
    public Collection<Encounter> initialVisit(String startDate, String endDate, String gender, String ageRange){

		StringBuffer sb = new StringBuffer();

		sb.append("SELECT e.* FROM encounter e INNER JOIN person p ON e.patient_id = p.person_id WHERE encounter_type = 1");

		if(startDate != null && !startDate.equals(""))
			sb.append(" AND e.encounter_datetime >= '" + startDate + "' ");

		if(endDate != null && !endDate.equals(""))
			sb.append(" AND e.encounter_datetime <= '" + endDate + "' ");

		if(gender != null && !gender.equals(""))
			sb.append(" AND p.gender = '" + gender + "' ");

		if(ageRange != null && !ageRange.equals(""))
			sb.append(" AND  DATEDIFF('" + endDate	+ "', STR_TO_DATE(p.birthdate, '%Y-%m-%d'))/365 " + ageRange + " ");

		sb.append(" AND e.voided = 0;");

		Session session = sessionFactory.getCurrentSession();

		Collection<Encounter> collection = session.createSQLQuery(sb.toString()).addEntity("encounter", Encounter.class).list();

		return collection;
    }
    
    @Override
    public Collection<Object[]> followupCD4Tests(String startDate, String endDate, String gender, String ageRange){

		StringBuffer sb = new StringBuffer();

		sb.append("SELECT o.person_id, MAX(o.obs_datetime) FROM obs o INNER JOIN person p ON o.person_id = p.person_id WHERE o.concept_id = 5497");

		if(gender != null && !gender.equals(""))
			sb.append(" AND p.gender = '" + gender + "' ");

		if(ageRange != null && !ageRange.equals(""))
			sb.append(" AND  DATEDIFF('" + endDate	+ "', STR_TO_DATE(p.birthdate, '%Y-%m-%d'))/365 " + ageRange + " ");

		sb.append(" AND o.voided = 0 GROUP BY o.person_id HAVING count(o.person_id) > 1 ");

		if(startDate != null && !startDate.equals(""))
			sb.append(" AND MAX(o.obs_datetime) >= '" + startDate + "' ");

		if(endDate != null && !endDate.equals(""))
			sb.append(" AND MAX(o.obs_datetime) <= '" + endDate + "' ");
		
		sb.append(" ORDER BY COUNT(o.person_id) DESC;");

		Session session = sessionFactory.getCurrentSession();

		Collection<Object[]> collection = session.createSQLQuery(sb.toString()).list();

		return collection;
    }
    
    @Override
    public Collection<Obs> initialCD4Tests(String startDate, String endDate, String gender, String ageRange){

		StringBuffer sb = new StringBuffer();

		sb.append("SELECT s.* FROM person k INNER JOIN "
			+ " (SELECT o.* FROM obs o WHERE concept_id = 5497 GROUP BY o.person_id HAVING COUNT(o.person_id) < 2) s ON k.person_id = s.person_id");

		if(startDate != null && !startDate.equals(""))
			sb.append(" AND s.obs_datetime >= '" + startDate + "' ");

		if(endDate != null && !endDate.equals(""))
			sb.append(" AND s.obs_datetime <= '" + endDate + "' ");

		if(gender != null && !gender.equals(""))
			sb.append(" AND k.gender = '" + gender + "' ");

		if(ageRange != null && !ageRange.equals(""))
			sb.append(" AND  DATEDIFF('" + endDate	+ "', STR_TO_DATE(k.birthdate, '%Y-%m-%d'))/365 " + ageRange + " ");

		sb.append(" AND s.voided = 0;");

		Session session = sessionFactory.getCurrentSession();

		Collection<Obs> collection = session.createSQLQuery(sb.toString()).addEntity("obs", Obs.class).list();

		return collection;
	}

    @Override
    public Collection<Object[]> clientOnART(String startDate, String endDate, String gender, String ageRange) throws SQLGrammarException{

        StringBuffer sb = new StringBuffer();
        
		sb.append(" SELECT distinct orders.patient_id, orders.start_date, orders.discontinued_date FROM orders orders ");
		sb.append(" INNER JOIN person person ON (orders.patient_id = person.person_id) ");
		// sb.append(" where orders.concept_id in (select distinct concept_id from concept_set WHERE concept_set = 1085) ");
		sb.append(" INNER JOIN concept_set cs ON (orders.concept_id = cs.concept_id) WHERE cs.concept_set = 1085 ");

		if(startDate != null && !startDate.equals("")
			&& endDate != null && !endDate.equals("")) {
			sb.append(" AND (orders.start_date >= '" + startDate + "' OR  orders.discontinued_date > '" + endDate + "') ");
		}

		if(gender != null && !gender.equals(""))
			sb.append(" AND person.gender = '" + gender + "' ");

		if(ageRange != null && !ageRange.equals(""))
			sb.append(" AND  DATEDIFF('" + endDate	+ "', STR_TO_DATE(person.birthdate, '%Y-%m-%d'))/365 " + ageRange + " ");

		sb.append(" AND orders.discontinued = 0;");

		Session session = sessionFactory.getCurrentSession();

		// System.out.println("*********************** Query ****************************: " + session.createSQLQuery(sb.toString()).addScalar("patient_id", Hibernate.INTEGER).list());//.addEntity("orders", Order.class).list());

        Collection<Object[]> collection = session.createSQLQuery(sb.toString())
        				.addScalar("patient_id", Hibernate.INTEGER)
        				.addScalar("start_date", Hibernate.DATE)
        				.addScalar("discontinued_date", Hibernate.DATE)
        				.list();

		return collection;
    }
    
    @Override
    public Collection<Object[]> deceasedNotOnART(String startDate, String endDate, String gender, String ageRange){
        StringBuffer sb = new StringBuffer();

		sb.append("SELECT orders.patient_id, orders.start_date, orders.discontinued_date FROM orders orders INNER JOIN person p ON orders.patient_id = p.person_id WHERE orders.concept_id NOT IN (SELECT concept_id FROM concept_set WHERE concept_set = 1085)");

		if(startDate != null && !startDate.equals("")
			&& endDate != null && !endDate.equals("")) {
			sb.append(" AND (start_date >= '" + startDate + "' OR  discontinued_date > '" + endDate + "') ");
		}

		if(gender != null && !gender.equals(""))
			sb.append(" AND p.gender = '" + gender + "' ");

		if(ageRange != null && !ageRange.equals(""))
			sb.append(" AND  DATEDIFF('" + endDate	+ "', STR_TO_DATE(p.birthdate, '%Y-%m-%d'))/365 " + ageRange + " ");

		sb.append(" AND dead = 1 ;");

		Session session = sessionFactory.getCurrentSession();		 

		// Collection<Order> collection = session.createSQLQuery(sb.toString()).addEntity("o", Order.class).list();

		Collection<Object[]> collection = session.createSQLQuery(sb.toString())
        				.addScalar("patient_id", Hibernate.INTEGER)
        				.addScalar("start_date", Hibernate.DATE)
        				.addScalar("discontinued_date", Hibernate.DATE)
        				.list();

		return collection;
    }
    
    @Override
    public Collection<Object[]> deceasedARTClients(String startDate, String endDate, String gender, String ageRange){
        StringBuffer sb = new StringBuffer();

		sb.append(" SELECT distinct orders.patient_id, orders.start_date, orders.discontinued_date FROM orders orders ");
		sb.append(" INNER JOIN person person ON (orders.patient_id = person.person_id) ");
		sb.append(" INNER JOIN concept_set cs ON (orders.concept_id = cs.concept_id) WHERE cs.concept_set = 1085 ");

		if(startDate != null && !startDate.equals("")
			&& endDate != null && !endDate.equals("")) {
			sb.append(" AND (start_date >= '" + startDate + "' OR  discontinued_date > '" + endDate + "') ");
		}

		if(gender != null && !gender.equals(""))
			sb.append(" AND person.gender = '" + gender + "' ");

		if(ageRange != null && !ageRange.equals(""))
			sb.append(" AND  DATEDIFF('" + endDate	+ "', STR_TO_DATE(person.birthdate, '%Y-%m-%d'))/365 " + ageRange + " ");

		sb.append(" AND dead = 1;");

		Session session = sessionFactory.getCurrentSession();

		// Collection<Order> collection = session.createSQLQuery(sb.toString()).addEntity("o", Order.class).list();
		Collection<Object[]> collection = session.createSQLQuery(sb.toString())
        				.addScalar("patient_id", Hibernate.INTEGER)
        				.addScalar("start_date", Hibernate.DATE)
        				.addScalar("discontinued_date", Hibernate.DATE)
        				.list();

		return collection;
    }

     @Override
    public Collection<Encounter> clientSeenByNurse(String startDate, String endDate, String gender, String ageRange) {
    	StringBuffer sb = new StringBuffer();

    	String nurse = "Nurse";

		sb.append("select enc.* from encounter enc ");
		sb.append("inner join patient p on enc.patient_id = p.patient_id ");
		sb.append("inner join users us on enc.provider_id = us.person_id ");
		sb.append("inner join person prsn on enc.patient_id = prsn.person_id ");
		sb.append("inner join user_role ur on us.user_id = ur.user_id ");
		sb.append("where ur.role = '" + nurse + "' " );

		if(startDate != null && !startDate.equals(""))
			sb.append(" AND enc.encounter_datetime >= '" + startDate + "' ");

		if(endDate != null && !endDate.equals(""))
			sb.append(" AND enc.encounter_datetime <= '" + endDate + "' ");

		if(gender != null && !gender.equals(""))
			sb.append(" AND prsn.gender = '" + gender + "' ");

		if(ageRange != null && !ageRange.equals(""))
			sb.append(" AND  DATEDIFF('" + endDate	+ "', STR_TO_DATE(prsn.birthdate, '%Y-%m-%d'))/365 " + ageRange + " ");

		sb.append(" AND p.voided = 0 GROUP BY enc.patient_id;");

		Session session = sessionFactory.getCurrentSession();

		Collection<Encounter> collection = session.createSQLQuery(sb.toString()).addEntity("encounter", Encounter.class).list();
		System.out.println("Client seen by Nurse ************************************************ : " + collection.size());

		return collection;
    }

    @Override
    public Collection<Encounter> clientSeenByPhysician(String startDate, String endDate, String gender, String ageRange) {
    	StringBuffer sb = new StringBuffer();

    	String clinician = "Clinician";

		sb.append("select enc.* from encounter enc ");
		sb.append("inner join patient p on enc.patient_id = p.patient_id ");
		sb.append("inner join users us on enc.provider_id = us.person_id ");
		sb.append("inner join person prsn on enc.patient_id = prsn.person_id ");
		sb.append("inner join user_role ur on us.user_id = ur.user_id ");
		sb.append("where ur.role = '" + clinician + "' " );

		if(startDate != null && !startDate.equals(""))
			sb.append(" AND enc.encounter_datetime >= '" + startDate + "' ");

		if(endDate != null && !endDate.equals(""))
			sb.append(" AND enc.encounter_datetime <= '" + endDate + "' ");

		if(gender != null && !gender.equals(""))
			sb.append(" AND prsn.gender = '" + gender + "' ");

		if(ageRange != null && !ageRange.equals(""))
			sb.append(" AND  DATEDIFF('" + endDate	+ "', STR_TO_DATE(prsn.birthdate, '%Y-%m-%d'))/365 " + ageRange + " ");

		sb.append(" AND p.voided = 0 GROUP BY enc.patient_id;");

		Session session = sessionFactory.getCurrentSession();

		Collection<Encounter> collection = session.createSQLQuery(sb.toString()).addEntity("encounter", Encounter.class).list();
		System.out.println("Client seen by Physicians ************************************************ : " + collection.size());
		
		return collection;
    }

    @Override
    public Collection<Object[]> missedAppointment(String startDate, String endDate, String gender, String ageRange) {
    	StringBuffer sb = new StringBuffer();

    	sb.append("select app.patient_id, app.appointment_date from appointment app ");
		sb.append("inner join patient p on p.patient_id = app.patient_id ");
		sb.append("inner join person prsn on p.patient_id = prsn.person_id ");
		sb.append("where app.attended = 0 " );

		if(startDate != null && !startDate.equals(""))
			sb.append(" AND app.appointment_date >= '" + startDate + "' ");

		if(endDate != null && !endDate.equals(""))
			sb.append(" AND app.appointment_date <= '" + endDate + "' ");

		if(gender != null && !gender.equals(""))
			sb.append(" AND prsn.gender = '" + gender + "' ");

		if(ageRange != null && !ageRange.equals(""))
			sb.append(" AND  DATEDIFF('" + endDate	+ "', STR_TO_DATE(prsn.birthdate, '%Y-%m-%d'))/365 " + ageRange + " ");
			
		sb.append(" AND p.voided = 0;");

		Session session = sessionFactory.getCurrentSession();
		
		Collection<Object[]> collection = session.createSQLQuery(sb.toString())
				.addScalar("patient_id", Hibernate.INTEGER)
				.addScalar("appointment_date", Hibernate.DATE)
				.list();
		return collection;
    }
}