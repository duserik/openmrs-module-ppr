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
package org.openmrs.module.ppr.web.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Encounter;
import org.openmrs.Obs;
import org.openmrs.api.context.Context;
import org.openmrs.module.ppr.Constants;
import org.openmrs.module.ppr.Ppr;
import org.openmrs.module.ppr.api.PprService;
import org.openmrs.module.ppr.utils.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * This class configured as controller using annotation and mapped with the URL of 'module/ppr/ppr'.
 */
@Controller("pprManageController")
@RequestMapping(value = "/module/ppr/ppr")
public class PprManageController {

	/** Logger for this class and subclasses */
	protected final Log log = LogFactory.getLog(getClass());

	/** Success form view name */
	private final String SUCCESS_FORM_VIEW = "/module/ppr/ppr";

	/**	
	 * Initially called after the formBackingObject method to get the landing form name  
	 * @return String form view name
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {		
		PprService service = Context.getService(PprService.class);
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = formater.parse("2014-01-18");
			endDate = formater.parse("2014-08-23");
		} catch(ParseException pe) { }
		return SUCCESS_FORM_VIEW;
	}
	
	/**
	 * All the parameters are optional based on the necessity  
	 * 
	 * @param httpSession
	 * @param anyRequestObject
	 * @param errors
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindingResult errors) throws Exception {

		// if (errors.hasErrors()) {
		// 	// return error view
		// }

		// return SUCCESS_FORM_VIEW;


		ModelAndView mav = new ModelAndView();

		String startDateParam = request.getParameter("startDate");
		String endDateParam = request.getParameter("endDate");

		PprService service = Context.getService(PprService.class);
		
		String startDate = startDateParam.split("/")[2] + "-" + startDateParam.split("/")[1] + "-" + startDateParam.split("/")[0];
		String endDate = endDateParam.split("/")[2] + "-" + endDateParam.split("/")[1] + "-" + endDateParam.split("/")[0];

		//Scheduled Visit Details
		Collection<Obs> scheduledVisitMaleAdultList = service.scheduledVisit(startDate, endDate, "M", Constants.ADULT);
		Collection<Obs> scheduledVisitFemaleAdultList = service.scheduledVisit(startDate, endDate, "F", Constants.ADULT);
		Collection<Obs> scheduledVisitMalePedList = service.scheduledVisit(startDate, endDate, "M", Constants.PEDIATRIC);
		Collection<Obs> scheduledVisitFemalePedList = service.scheduledVisit(startDate, endDate, "F", Constants.PEDIATRIC);
		
		//Followup clients Details	
		Collection<Encounter> followupVisitMaleAdultList = service.followupVisit(startDate, endDate, "M", Constants.ADULT);
		Collection<Encounter> followupVisitFemaleAdultList = service.followupVisit(startDate, endDate, "F", Constants.ADULT);
		Collection<Encounter> followupVisitMalePedList = service.followupVisit(startDate, endDate, "M", Constants.PEDIATRIC);
		Collection<Encounter> followupVisitFemalePedList = service.followupVisit(startDate, endDate, "F", Constants.PEDIATRIC);
		
		//Total clients seen Details	
		Collection<Encounter> totalClienSeenMaleAdultList = service.totalClienSeen(startDate, endDate, "M", Constants.ADULT);
		Collection<Encounter> totalClienSeenFemaleAdultList = service.totalClienSeen(startDate, endDate, "F", Constants.ADULT);
		Collection<Encounter> totalClienSeenMalePedList = service.totalClienSeen(startDate, endDate, "M", Constants.PEDIATRIC);
		Collection<Encounter> totalClienSeenFemalePedList = service.totalClienSeen(startDate, endDate, "F", Constants.PEDIATRIC);
		
		//Initial visit Details	
		Collection<Encounter> initialVisitMaleAdultList = service.initialVisit(startDate, endDate, "M", Constants.ADULT);
		Collection<Encounter> initialVisitFemaleAdultList = service.initialVisit(startDate, endDate, "F", Constants.ADULT);
		Collection<Encounter> initialVisitMalePedList = service.initialVisit(startDate, endDate, "M", Constants.PEDIATRIC);
		Collection<Encounter> initialVisitFemalePedList = service.initialVisit(startDate, endDate, "F", Constants.PEDIATRIC);		

		//Followup CD4 tests Details
		Collection<Object[]> followupCD4TestsMaleAdultList = service.followupCD4Tests(startDate, endDate, "M", Constants.ADULT);
		Collection<Object[]> followupCD4TestsFemaleAdultList = service.followupCD4Tests(startDate, endDate, "F", Constants.ADULT);
		Collection<Object[]> followupCD4TestsMalePedList = service.followupCD4Tests(startDate, endDate, "M", Constants.PEDIATRIC);
		Collection<Object[]> followupCD4TestsFemalePedList = service.followupCD4Tests(startDate, endDate, "F", Constants.PEDIATRIC);		

		//initial CD4 tests Details
		Collection<Obs> initialCD4TestsMaleAdultList = service.initialCD4Tests(startDate, endDate, "M", Constants.ADULT);
		Collection<Obs> initialCD4TestsFemaleAdultList = service.initialCD4Tests(startDate, endDate, "F", Constants.ADULT);
		Collection<Obs> initialCD4TestsMalePedList = service.initialCD4Tests(startDate, endDate, "M", Constants.PEDIATRIC);
		Collection<Obs> initialCD4TestsFemalePedList = service.initialCD4Tests(startDate, endDate, "F", Constants.PEDIATRIC);				

		//Client on ART Details
		Collection<Object[]> clientOnARTMaleAdultList = service.clientOnART(startDate, endDate, "M", Constants.ADULT);
		Collection<Object[]> clientOnARTFemaleAdultList = service.clientOnART(startDate, endDate, "F", Constants.ADULT);
		Collection<Object[]> clientOnARTMalePedList = service.clientOnART(startDate, endDate, "M", Constants.PEDIATRIC);
		Collection<Object[]> clientOnARTFemalePedList = service.clientOnART(startDate, endDate, "F", Constants.PEDIATRIC);			

		//Deceased not on ART Details
		Collection<Object[]> deceasedNotOnARTMaleAdultList = service.deceasedNotOnART(startDate, endDate, "M", Constants.ADULT);
		Collection<Object[]> deceasedNotOnARTFemaleAdultList = service.deceasedNotOnART(startDate, endDate, "F", Constants.ADULT);
		Collection<Object[]> deceasedNotOnARTMalePedList = service.deceasedNotOnART(startDate, endDate, "M", Constants.PEDIATRIC);
		Collection<Object[]> deceasedNotOnARTFemalePedList = service.deceasedNotOnART(startDate, endDate, "F", Constants.PEDIATRIC);

		//Deceased not on ART Details
		Collection<Object[]> deceasedARTClientsMaleAdultList = service.deceasedARTClients(startDate, endDate, "M", Constants.ADULT);
		Collection<Object[]> deceasedARTClientsFemaleAdultList = service.deceasedARTClients(startDate, endDate, "F", Constants.ADULT);
		Collection<Object[]> deceasedARTClientsMalePedList = service.deceasedARTClients(startDate, endDate, "M", Constants.PEDIATRIC);
		Collection<Object[]> deceasedARTClientsFemalePedList = service.deceasedARTClients(startDate, endDate, "F", Constants.PEDIATRIC);

		//Clients seen by Nurse Details
		Collection<Encounter> clientSeenByNurseMaleAdultList = service.clientSeenByNurse(startDate, endDate, "M", Constants.ADULT);
		Collection<Encounter> clientSeenByNurseFemaleAdultList = service.clientSeenByNurse(startDate, endDate, "F", Constants.ADULT);
		Collection<Encounter> clientSeenByNurseMalePedList = service.clientSeenByNurse(startDate, endDate, "M", Constants.PEDIATRIC);
		Collection<Encounter> clientSeenByNurseFemalePedList = service.clientSeenByNurse(startDate, endDate, "F", Constants.PEDIATRIC);

		//Clients seen by Physician Details
		Collection<Encounter> clientSeenByPhysicianMaleAdultList = service.clientSeenByPhysician(startDate, endDate, "M", Constants.ADULT);
		Collection<Encounter> clientSeenByPhysicianFemaleAdultList = service.clientSeenByPhysician(startDate, endDate, "F", Constants.ADULT);
		Collection<Encounter> clientSeenByPhysicianMalePedList = service.clientSeenByPhysician(startDate, endDate, "M", Constants.PEDIATRIC);
		Collection<Encounter> clientSeenByPhysicianFemalePedList = service.clientSeenByPhysician(startDate, endDate, "F", Constants.PEDIATRIC);

		//Missed Appointments Details
		Collection<Object[]> missedAppointmentMaleAdultList = service.missedAppointment(startDate, endDate, "M", Constants.ADULT);
		Collection<Object[]> missedAppointmentFemaleAdultList = service.missedAppointment(startDate, endDate, "F", Constants.ADULT);
		Collection<Object[]> missedAppointmentMalePedList = service.missedAppointment(startDate, endDate, "M", Constants.PEDIATRIC);
		Collection<Object[]> missedAppointmentFemalePedList = service.missedAppointment(startDate, endDate, "F", Constants.PEDIATRIC);





		//Scheduled Visit aggragated
		Ppr scheduledVisitMaleAdult = Utils.indicatorsPerDays(startDate, endDate, scheduledVisitMaleAdultList, null, null);
		Ppr scheduledVisitFemaleAdult = Utils.indicatorsPerDays(startDate, endDate, scheduledVisitFemaleAdultList, null, null);
		Ppr scheduledVisitMalePed = Utils.indicatorsPerDays(startDate, endDate, scheduledVisitMalePedList, null, null);
		Ppr scheduledVisitFemalePed = Utils.indicatorsPerDays(startDate, endDate, scheduledVisitFemalePedList, null, null);		
		
		//Followup clients aggragated
		Ppr followupVisitMaleAdult = Utils.indicatorsPerDays(startDate, endDate, null, followupVisitMaleAdultList, null);
		Ppr followupVisitFemaleAdult = Utils.indicatorsPerDays(startDate, endDate, null, followupVisitFemaleAdultList, null);
		Ppr followupVisitMalePed = Utils.indicatorsPerDays(startDate, endDate, null, followupVisitMalePedList, null);
		Ppr followupVisitFemalePed = Utils.indicatorsPerDays(startDate, endDate, null, followupVisitFemalePedList, null);
		log.info("Followup Visit: " + followupVisitMaleAdult + " - " + followupVisitFemaleAdult + " - " + followupVisitMalePed + " - " + followupVisitFemalePed);	
		
		//Total clients seen aggragated
		Ppr totalClienSeenMaleAdult = Utils.indicatorsPerDays(startDate, endDate, null, totalClienSeenMaleAdultList, null);
		Ppr totalClienSeenFemaleAdult = Utils.indicatorsPerDays(startDate, endDate, null, totalClienSeenFemaleAdultList, null);
		Ppr totalClienSeenMalePed = Utils.indicatorsPerDays(startDate, endDate, null, totalClienSeenMalePedList, null);
		Ppr totalClienSeenFemalePed = Utils.indicatorsPerDays(startDate, endDate, null, totalClienSeenFemalePedList, null);
		log.info("Client seen: " + totalClienSeenMaleAdult + " - " + totalClienSeenFemaleAdult + " - " + totalClienSeenMalePed + " - " + totalClienSeenFemalePed);
		
		//Initial Visit aggragated
		Ppr initialVisitMaleAdult = Utils.indicatorsPerDays(startDate, endDate, null, initialVisitMaleAdultList, null);
		Ppr initialVisitFemaleAdult = Utils.indicatorsPerDays(startDate, endDate, null, initialVisitFemaleAdultList, null);
		Ppr initialVisitMalePed = Utils.indicatorsPerDays(startDate, endDate, null, initialVisitMalePedList, null);
		Ppr initialVisitFemalePed = Utils.indicatorsPerDays(startDate, endDate, null, initialVisitFemalePedList, null);
		log.info("Initial Visit: " + initialVisitMaleAdult + " - " + initialVisitFemaleAdult + " - " + initialVisitMalePed + " - " + initialVisitFemalePed);
		
		//Followup CD4 tests aggragated
		Ppr followupCD4TestsMaleAdult = Utils.indicatorsPerDays(startDate, endDate, null, null, followupCD4TestsMaleAdultList);
		Ppr followupCD4TestsFemaleAdult = Utils.indicatorsPerDays(startDate, endDate, null, null, followupCD4TestsFemaleAdultList);
		Ppr followupCD4TestsMalePed = Utils.indicatorsPerDays(startDate, endDate, null, null, followupCD4TestsMalePedList);
		Ppr followupCD4TestsFemalePed = Utils.indicatorsPerDays(startDate, endDate, null, null, followupCD4TestsFemalePedList);
		log.info("followup cd4 test: " + followupCD4TestsMaleAdult + " - " + followupCD4TestsFemaleAdult + " - " + followupCD4TestsMalePed + " - " + followupCD4TestsFemalePed);
		
		//Initial CD4 tests aggragated
		Ppr initialCD4TestsMaleAdult = Utils.indicatorsPerDays(startDate, endDate, initialCD4TestsMaleAdultList, null, null);
		Ppr initialCD4TestsFemaleAdult = Utils.indicatorsPerDays(startDate, endDate, initialCD4TestsFemaleAdultList, null, null);
		Ppr initialCD4TestsMalePed = Utils.indicatorsPerDays(startDate, endDate, initialCD4TestsMalePedList, null, null);
		Ppr initialCD4TestsFemalePed = Utils.indicatorsPerDays(startDate, endDate, initialCD4TestsFemalePedList, null, null);
		log.info("initial cd4 test: " + initialCD4TestsMaleAdult + " - " + initialCD4TestsFemaleAdult + " - " + initialCD4TestsMalePed + " - " + initialCD4TestsFemalePed);

		//Client on ART aggragated
		Ppr clientOnARTMaleAdult = Utils.indicatorsPerDays(startDate, endDate, null, null, clientOnARTMaleAdultList);
		Ppr clientOnARTFemaleAdult = Utils.indicatorsPerDays(startDate, endDate, null, null, clientOnARTFemaleAdultList);
		Ppr clientOnARTMalePed = Utils.indicatorsPerDays(startDate, endDate, null, null, clientOnARTMalePedList);
		Ppr clientOnARTFemalePed = Utils.indicatorsPerDays(startDate, endDate, null, null, clientOnARTFemalePedList);
		log.info("client on ART: " + clientOnARTMaleAdult + " - " + clientOnARTFemaleAdult + " - " + clientOnARTMalePed + " - " + clientOnARTFemalePed);

		//Deceased client not on ART aggragated
		Ppr deceasedNotOnARTMaleAdult = Utils.indicatorsPerDays(startDate, endDate, null, null, deceasedNotOnARTMaleAdultList);
		Ppr deceasedNotOnARTFemaleAdult = Utils.indicatorsPerDays(startDate, endDate, null, null, deceasedNotOnARTFemaleAdultList);
		Ppr deceasedNotOnARTMalePed = Utils.indicatorsPerDays(startDate, endDate, null, null, deceasedNotOnARTMalePedList);
		Ppr deceasedNotOnARTFemalePed = Utils.indicatorsPerDays(startDate, endDate, null, null, deceasedNotOnARTFemalePedList);
		log.info("Deceased not on ART: " + deceasedNotOnARTMaleAdult + " - " + deceasedNotOnARTFemaleAdult + " - " + deceasedNotOnARTMalePed + " - " + deceasedNotOnARTFemalePed);

		//Deceased client not on ART aggragated
		Ppr deceasedARTClientsMaleAdult = Utils.indicatorsPerDays(startDate, endDate, null, null, deceasedARTClientsMaleAdultList);
		Ppr deceasedARTClientsFemaleAdult = Utils.indicatorsPerDays(startDate, endDate, null, null, deceasedARTClientsFemaleAdultList);
		Ppr deceasedARTClientsMalePed = Utils.indicatorsPerDays(startDate, endDate, null, null, deceasedARTClientsMalePedList);
		Ppr deceasedARTClientsFemalePed = Utils.indicatorsPerDays(startDate, endDate, null, null, deceasedARTClientsFemalePedList);
		log.info("Deceased ART client: " + deceasedARTClientsMaleAdult + " - " + deceasedARTClientsFemaleAdult + " - " + deceasedARTClientsMalePed + " - " + deceasedARTClientsFemalePed);

		//Clients seen by Nurse aggragated
		Ppr clientSeenByNurseMaleAdult = Utils.indicatorsPerDays(startDate, endDate, null, clientSeenByNurseMaleAdultList, null);
		Ppr clientSeenByNurseFemaleAdult = Utils.indicatorsPerDays(startDate, endDate, null, clientSeenByNurseFemaleAdultList, null);
		Ppr clientSeenByNurseMalePed = Utils.indicatorsPerDays(startDate, endDate, null, clientSeenByNurseMalePedList, null);
		Ppr clientSeenByNurseFemalePed = Utils.indicatorsPerDays(startDate, endDate, null, clientSeenByNurseFemalePedList, null);
		log.info("Seen by Nurse client: " + clientSeenByNurseMaleAdult + " - " + clientSeenByNurseFemaleAdult + " - " + clientSeenByNurseMalePed + " - " + clientSeenByNurseFemalePed);
		
		//Clients seen by Physicians aggragated
		Ppr clientSeenByPhysicianMaleAdult = Utils.indicatorsPerDays(startDate, endDate, null, clientSeenByPhysicianMaleAdultList, null);
		Ppr clientSeenByPhysicianFemaleAdult = Utils.indicatorsPerDays(startDate, endDate, null, clientSeenByPhysicianFemaleAdultList, null);
		Ppr clientSeenByPhysicianMalePed = Utils.indicatorsPerDays(startDate, endDate, null, clientSeenByPhysicianMalePedList, null);
		Ppr clientSeenByPhysicianFemalePed = Utils.indicatorsPerDays(startDate, endDate, null, clientSeenByPhysicianFemalePedList, null);
		log.info("Seen by Physician client: " + clientSeenByPhysicianMaleAdult + " - " + clientSeenByPhysicianFemaleAdult + " - " + clientSeenByPhysicianMalePed + " - " + clientSeenByPhysicianFemalePed);
		
		//Missed Appointments aggragated
		Ppr missedAppointmentMaleAdult = Utils.indicatorsPerDays(startDate, endDate, null, null, missedAppointmentMaleAdultList);
		Ppr missedAppointmentFemaleAdult = Utils.indicatorsPerDays(startDate, endDate, null, null, missedAppointmentFemaleAdultList);
		Ppr missedAppointmentMalePed = Utils.indicatorsPerDays(startDate, endDate, null, null, missedAppointmentMalePedList);
		Ppr missedAppointmentFemalePed = Utils.indicatorsPerDays(startDate, endDate, null, null, missedAppointmentFemalePedList);
		log.info("Missed Appointments: " + missedAppointmentMaleAdult + " - " + missedAppointmentFemaleAdult + " - " + missedAppointmentMalePed + " - " + missedAppointmentFemalePed);



		mav.addObject("scheduledVisitMaleAdult", scheduledVisitMaleAdult);
		mav.addObject("scheduledVisitFemaleAdult", scheduledVisitFemaleAdult);
		mav.addObject("scheduledVisitMalePed", scheduledVisitMalePed);
		mav.addObject("scheduledVisitFemalePed", scheduledVisitFemalePed);

		mav.addObject("followupVisitMaleAdult", followupVisitMaleAdult);
		mav.addObject("followupVisitFemaleAdult", followupVisitFemaleAdult);
		mav.addObject("followupVisitMalePed", followupVisitMalePed);
		mav.addObject("followupVisitFemalePed", followupVisitFemalePed);

		mav.addObject("totalClienSeenMaleAdult", totalClienSeenMaleAdult);
		mav.addObject("totalClienSeenFemaleAdult", totalClienSeenFemaleAdult);
		mav.addObject("totalClienSeenMalePed", totalClienSeenMalePed);
		mav.addObject("totalClienSeenFemalePed", totalClienSeenFemalePed);

		mav.addObject("initialVisitMaleAdult", initialVisitMaleAdult);
		mav.addObject("initialVisitFemaleAdult", initialVisitFemaleAdult);
		mav.addObject("initialVisitMalePed", initialVisitMalePed);
		mav.addObject("initialVisitFemalePed", initialVisitFemalePed);

		mav.addObject("followupCD4TestsMaleAdult", followupCD4TestsMaleAdult);
		mav.addObject("followupCD4TestsFemaleAdult", followupCD4TestsFemaleAdult);
		mav.addObject("followupCD4TestsMalePed", followupCD4TestsMalePed);
		mav.addObject("followupCD4TestsFemalePed", followupCD4TestsFemalePed);

		mav.addObject("initialCD4TestsMaleAdult", initialCD4TestsMaleAdult);
		mav.addObject("initialCD4TestsFemaleAdult", initialCD4TestsFemaleAdult);
		mav.addObject("initialCD4TestsMalePed", initialCD4TestsMalePed);
		mav.addObject("initialCD4TestsFemalePed", initialCD4TestsFemalePed);

		mav.addObject("clientOnARTMaleAdult", clientOnARTMaleAdult);
		mav.addObject("clientOnARTFemaleAdult", clientOnARTFemaleAdult);
		mav.addObject("clientOnARTMalePed", clientOnARTMalePed);
		mav.addObject("clientOnARTFemalePed", clientOnARTFemalePed);

		mav.addObject("deceasedNotOnARTMaleAdult", deceasedNotOnARTMaleAdult);
		mav.addObject("deceasedNotOnARTFemaleAdult", deceasedNotOnARTFemaleAdult);
		mav.addObject("deceasedNotOnARTMalePed", deceasedNotOnARTMalePed);
		mav.addObject("deceasedNotOnARTFemalePed", deceasedNotOnARTFemalePed);

		mav.addObject("deceasedARTClientsMaleAdult", deceasedARTClientsMaleAdult);
		mav.addObject("deceasedARTClientsFemaleAdult", deceasedARTClientsFemaleAdult);
		mav.addObject("deceasedARTClientsMalePed", deceasedARTClientsMalePed);
		mav.addObject("deceasedARTClientsFemalePed", deceasedARTClientsFemalePed);		

		mav.addObject("clientSeenByNurseMaleAdult", clientSeenByNurseMaleAdult);
		mav.addObject("clientSeenByNurseFemaleAdult", clientSeenByNurseFemaleAdult);
		mav.addObject("clientSeenByNurseMalePed", clientSeenByNurseMalePed);
		mav.addObject("clientSeenByNurseFemalePed", clientSeenByNurseFemalePed);		

		mav.addObject("clientSeenByPhysicianMaleAdult", clientSeenByPhysicianMaleAdult);
		mav.addObject("clientSeenByPhysicianFemaleAdult", clientSeenByPhysicianFemaleAdult);
		mav.addObject("clientSeenByPhysicianMalePed", clientSeenByPhysicianMalePed);
		mav.addObject("clientSeenByPhysicianFemalePed", clientSeenByPhysicianFemalePed);		

		mav.addObject("missedAppointmentMaleAdult", missedAppointmentMaleAdult);
		mav.addObject("missedAppointmentFemaleAdult", missedAppointmentFemaleAdult);
		mav.addObject("missedAppointmentMalePed", missedAppointmentMalePed);
		mav.addObject("missedAppointmentFemalePed", missedAppointmentFemalePed);

		return mav;
	}

	/**
	 * This class returns the form backing object. This can be a string, a boolean, or a normal java
	 * pojo. The bean name defined in the ModelAttribute annotation and the type can be just
	 * defined by the return type of this method
	 */
	@ModelAttribute("pprMap")
	protected Map formBackingObject(HttpServletRequest request) throws Exception {
		// get all patients that have an identifier "101" (from the demo sample data)
		// see http://resources.openmrs.org/doc/index.html?org/openmrs/api/PatientService.html for
		// a list of all PatientService methods
		// Collection<Patient> patients = Context.getPatientService().findPatients("101", false);

		// this object will be made available to the jsp page under the variable name
		// that is defined in the @ModuleAttribute tag
		// model.addAttribute("user", Context.getAuthenticatedUser());

//		PprService service = Context.getService(PprService.class);

//		Map pprMap = new HashMap<String, Ppr>();

//		String startDate = "2014-07-07";
//		String endDate = "2014-07-12";
//
//		//Scheduled Visit Details
//		Collection<Obs> scheduledVisitMaleAdultList = service.scheduledVisit(startDate, endDate, "M", Constants.ADULT);
//		Collection<Obs> scheduledVisitFemaleAdultList = service.scheduledVisit(startDate, endDate, "F", Constants.ADULT);
//		Collection<Obs> scheduledVisitMalePedList = service.scheduledVisit(startDate, endDate, "M", Constants.PEDIATRIC);
//		Collection<Obs> scheduledVisitFemalePedList = service.scheduledVisit(startDate, endDate, "F", Constants.PEDIATRIC);
//		
//		//Followup clients Details	
//		Collection<Encounter> followupVisitMaleAdultList = service.followupVisit(startDate, endDate, "M", Constants.ADULT);
//		Collection<Encounter> followupVisitFemaleAdultList = service.followupVisit(startDate, endDate, "F", Constants.ADULT);
//		Collection<Encounter> followupVisitMalePedList = service.followupVisit(startDate, endDate, "M", Constants.PEDIATRIC);
//		Collection<Encounter> followupVisitFemalePedList = service.followupVisit(startDate, endDate, "F", Constants.PEDIATRIC);
//		
//		//Total clients seen Details	
//		Collection<Encounter> totalClienSeenMaleAdultList = service.totalClienSeen(startDate, endDate, "M", Constants.ADULT);
//		Collection<Encounter> totalClienSeenFemaleAdultList = service.totalClienSeen(startDate, endDate, "F", Constants.ADULT);
//		Collection<Encounter> totalClienSeenMalePedList = service.totalClienSeen(startDate, endDate, "M", Constants.PEDIATRIC);
//		Collection<Encounter> totalClienSeenFemalePedList = service.totalClienSeen(startDate, endDate, "F", Constants.PEDIATRIC);
//		
//		//Initial visit Details	
//		Collection<Encounter> initialVisitMaleAdultList = service.initialVisit(startDate, endDate, "M", Constants.ADULT);
//		Collection<Encounter> initialVisitFemaleAdultList = service.initialVisit(startDate, endDate, "F", Constants.ADULT);
//		Collection<Encounter> initialVisitMalePedList = service.initialVisit(startDate, endDate, "M", Constants.PEDIATRIC);
//		Collection<Encounter> initialVisitFemalePedList = service.initialVisit(startDate, endDate, "F", Constants.PEDIATRIC);		
//
//		//Followup CD4 tests Details
//		Collection<Obs> followupCD4TestsMaleAdultList = service.followupCD4Tests(startDate, endDate, "M", Constants.ADULT);
//		Collection<Obs> followupCD4TestsFemaleAdultList = service.followupCD4Tests(startDate, endDate, "F", Constants.ADULT);
//		Collection<Obs> followupCD4TestsMalePedList = service.followupCD4Tests(startDate, endDate, "M", Constants.PEDIATRIC);
//		Collection<Obs> followupCD4TestsFemalePedList = service.followupCD4Tests(startDate, endDate, "F", Constants.PEDIATRIC);				
//
//		//initial CD4 tests Details
//		Collection<Obs> initialCD4TestsMaleAdultList = service.initialCD4Tests(startDate, endDate, "M", Constants.ADULT);
//		Collection<Obs> initialCD4TestsFemaleAdultList = service.initialCD4Tests(startDate, endDate, "F", Constants.ADULT);
//		Collection<Obs> initialCD4TestsMalePedList = service.initialCD4Tests(startDate, endDate, "M", Constants.PEDIATRIC);
//		Collection<Obs> initialCD4TestsFemalePedList = service.initialCD4Tests(startDate, endDate, "F", Constants.PEDIATRIC);				
//
//		//Client on ART Details
//		Collection<Object[]> clientOnARTMaleAdultList = service.clientOnART(startDate, endDate, "M", Constants.ADULT);
//		Collection<Object[]> clientOnARTFemaleAdultList = service.clientOnART(startDate, endDate, "F", Constants.ADULT);
//		Collection<Object[]> clientOnARTMalePedList = service.clientOnART(startDate, endDate, "M", Constants.PEDIATRIC);
//		Collection<Object[]> clientOnARTFemalePedList = service.clientOnART(startDate, endDate, "F", Constants.PEDIATRIC);			
//
//		//Deceased not on ART Details
//		Collection<Object[]> deceasedNotOnARTMaleAdultList = service.deceasedNotOnART(startDate, endDate, "M", Constants.ADULT);
//		Collection<Object[]> deceasedNotOnARTFemaleAdultList = service.deceasedNotOnART(startDate, endDate, "F", Constants.ADULT);
//		Collection<Object[]> deceasedNotOnARTMalePedList = service.deceasedNotOnART(startDate, endDate, "M", Constants.PEDIATRIC);
//		Collection<Object[]> deceasedNotOnARTFemalePedList = service.deceasedNotOnART(startDate, endDate, "F", Constants.PEDIATRIC);			
//
//		//Deceased not on ART Details
//		Collection<Object[]> deceasedARTClientsMaleAdultList = service.deceasedARTClients(startDate, endDate, "M", Constants.ADULT);
//		Collection<Object[]> deceasedARTClientsFemaleAdultList = service.deceasedARTClients(startDate, endDate, "F", Constants.ADULT);
//		Collection<Object[]> deceasedARTClientsMalePedList = service.deceasedARTClients(startDate, endDate, "M", Constants.PEDIATRIC);
//		Collection<Object[]> deceasedARTClientsFemalePedList = service.deceasedARTClients(startDate, endDate, "F", Constants.PEDIATRIC);
//
//
//
//
//
//		//Scheduled Visit aggragated
//		Ppr scheduledVisitMaleAdult = Utils.indicatorsPerDays(startDate, endDate, null, scheduledVisitMaleAdultList, null, null);
//		Ppr scheduledVisitFemaleAdult = Utils.indicatorsPerDays(startDate, endDate, scheduledVisitFemaleAdultList, null, null);
//		Ppr scheduledVisitMalePed = Utils.indicatorsPerDays(startDate, endDate, scheduledVisitMalePedList, null, null);
//		Ppr scheduledVisitFemalePed = Utils.indicatorsPerDays(startDate, endDate, scheduledVisitFemalePedList, null, null);		
//		
//		//Followup clients aggragated
//		Ppr followupVisitMaleAdult = Utils.indicatorsPerDays(startDate, endDate, null, followupVisitMaleAdultList, null, null);
//		Ppr followupVisitFemaleAdult = Utils.indicatorsPerDays(startDate, endDate, null, followupVisitFemaleAdultList, null, null);
//		Ppr followupVisitMalePed = Utils.indicatorsPerDays(startDate, endDate, null, followupVisitMalePedList, null, null);
//		Ppr followupVisitFemalePed = Utils.indicatorsPerDays(startDate, endDate, null, followupVisitFemalePedList, null, null);
//		log.info("Followup Visit: " + followupVisitMaleAdult + " - " + followupVisitFemaleAdult + " - " + followupVisitMalePed + " - " + followupVisitFemalePed);	
//		
//		//Total clients seen aggragated
//		Ppr totalClienSeenMaleAdult = Utils.indicatorsPerDays(startDate, endDate, null, totalClienSeenMaleAdultList, null, null);
//		Ppr totalClienSeenFemaleAdult = Utils.indicatorsPerDays(startDate, endDate, null, totalClienSeenFemaleAdultList, null, null);
//		Ppr totalClienSeenMalePed = Utils.indicatorsPerDays(startDate, endDate, null, totalClienSeenMalePedList, null, null);
//		Ppr totalClienSeenFemalePed = Utils.indicatorsPerDays(startDate, endDate, null, totalClienSeenFemalePedList, null, null);
//		log.info("Client seen: " + totalClienSeenMaleAdult + " - " + totalClienSeenFemaleAdult + " - " + totalClienSeenMalePed + " - " + totalClienSeenFemalePed);
//		
//		//Initial Visit aggragated
//		Ppr initialVisitMaleAdult = Utils.indicatorsPerDays(startDate, endDate, null, initialVisitMaleAdultList, null, null);
//		Ppr initialVisitFemaleAdult = Utils.indicatorsPerDays(startDate, endDate, null, initialVisitFemaleAdultList, null, null);
//		Ppr initialVisitMalePed = Utils.indicatorsPerDays(startDate, endDate, null, initialVisitMalePedList, null, null);
//		Ppr initialVisitFemalePed = Utils.indicatorsPerDays(startDate, endDate, null, initialVisitFemalePedList, null, null);
//		log.info("Initial Visit: " + initialVisitMaleAdult + " - " + initialVisitFemaleAdult + " - " + initialVisitMalePed + " - " + initialVisitFemalePed);
//		
//		//Followup CD4 tests aggragated
//		Ppr followupCD4TestsMaleAdult = Utils.indicatorsPerDays(startDate, endDate, followupCD4TestsMaleAdultList, null, null);
//		Ppr followupCD4TestsFemaleAdult = Utils.indicatorsPerDays(startDate, endDate, followupCD4TestsFemaleAdultList, null, null);
//		Ppr followupCD4TestsMalePed = Utils.indicatorsPerDays(startDate, endDate, followupCD4TestsMalePedList, null, null);
//		Ppr followupCD4TestsFemalePed = Utils.indicatorsPerDays(startDate, endDate, followupCD4TestsFemalePedList, null, null);
//		log.info("followup cd4 test: " + followupCD4TestsMaleAdult + " - " + followupCD4TestsFemaleAdult + " - " + followupCD4TestsMalePed + " - " + followupCD4TestsFemalePed);
//		
//		//Initial CD4 tests aggragated
//		Ppr initialCD4TestsMaleAdult = Utils.indicatorsPerDays(startDate, endDate, initialCD4TestsMaleAdultList, null, null);
//		Ppr initialCD4TestsFemaleAdult = Utils.indicatorsPerDays(startDate, endDate, initialCD4TestsFemaleAdultList, null, null);
//		Ppr initialCD4TestsMalePed = Utils.indicatorsPerDays(startDate, endDate, initialCD4TestsMalePedList, null, null);
//		Ppr initialCD4TestsFemalePed = Utils.indicatorsPerDays(startDate, endDate, initialCD4TestsFemalePedList, null, null);
//		log.info("initial cd4 test: " + initialCD4TestsMaleAdult + " - " + initialCD4TestsFemaleAdult + " - " + initialCD4TestsMalePed + " - " + initialCD4TestsFemalePed);
//
//		//Client on ART aggragated
//		Ppr clientOnARTMaleAdult = Utils.indicatorsPerDays(startDate, endDate, null, null, clientOnARTMaleAdultList);
//		Ppr clientOnARTFemaleAdult = Utils.indicatorsPerDays(startDate, endDate, null, null, clientOnARTFemaleAdultList);
//		Ppr clientOnARTMalePed = Utils.indicatorsPerDays(startDate, endDate, null, null, clientOnARTMalePedList);
//		Ppr clientOnARTFemalePed = Utils.indicatorsPerDays(startDate, endDate, null, null, clientOnARTFemalePedList);
//		log.info("client on ART: " + clientOnARTMaleAdult + " - " + clientOnARTFemaleAdult + " - " + clientOnARTMalePed + " - " + clientOnARTFemalePed);
//
//		//Deceased client not on ART aggragated
//		Ppr deceasedNotOnARTMaleAdult = Utils.indicatorsPerDays(startDate, endDate, null, null, deceasedNotOnARTMaleAdultList);
//		Ppr deceasedNotOnARTFemaleAdult = Utils.indicatorsPerDays(startDate, endDate, null, null, deceasedNotOnARTFemaleAdultList);
//		Ppr deceasedNotOnARTMalePed = Utils.indicatorsPerDays(startDate, endDate, null, null, deceasedNotOnARTMalePedList);
//		Ppr deceasedNotOnARTFemalePed = Utils.indicatorsPerDays(startDate, endDate, null, null, deceasedNotOnARTFemalePedList);
//		log.info("Deceased not on ART: " + deceasedNotOnARTMaleAdult + " - " + deceasedNotOnARTFemaleAdult + " - " + deceasedNotOnARTMalePed + " - " + deceasedNotOnARTFemalePed);
//
//		//Deceased client not on ART aggragated
//		Ppr deceasedARTClientsMaleAdult = Utils.indicatorsPerDays(startDate, endDate, null, null, deceasedARTClientsMaleAdultList);
//		Ppr deceasedARTClientsFemaleAdult = Utils.indicatorsPerDays(startDate, endDate, null, null, deceasedARTClientsFemaleAdultList);
//		Ppr deceasedARTClientsMalePed = Utils.indicatorsPerDays(startDate, endDate, null, null, deceasedARTClientsMalePedList);
//		Ppr deceasedARTClientsFemalePed = Utils.indicatorsPerDays(startDate, endDate, null, null, deceasedARTClientsFemalePedList);
//		log.info("Deceased ART client: " + deceasedARTClientsMaleAdult + " - " + deceasedARTClientsFemaleAdult + " - " + deceasedARTClientsMalePed + " - " + deceasedARTClientsFemalePed);
//
//
//
//
//		pprMap.put("scheduledVisitMaleAdult", scheduledVisitMaleAdult);
//		pprMap.put("scheduledVisitFemaleAdult", scheduledVisitFemaleAdult);
//		pprMap.put("scheduledVisitMalePed", scheduledVisitMalePed);
//		pprMap.put("scheduledVisitFemalePed", scheduledVisitFemalePed);
//
//		pprMap.put("followupVisitMaleAdult", followupVisitMaleAdult);
//		pprMap.put("followupVisitFemaleAdult", followupVisitFemaleAdult);
//		pprMap.put("followupVisitMalePed", followupVisitMalePed);
//		pprMap.put("followupVisitFemalePed", followupVisitFemalePed);
//
//		pprMap.put("totalClienSeenMaleAdult", totalClienSeenMaleAdult);
//		pprMap.put("totalClienSeenFemaleAdult", totalClienSeenFemaleAdult);
//		pprMap.put("totalClienSeenMalePed", totalClienSeenMalePed);
//		pprMap.put("totalClienSeenFemalePed", totalClienSeenFemalePed);
//
//		pprMap.put("initialVisitMaleAdult", initialVisitMaleAdult);
//		pprMap.put("initialVisitFemaleAdult", initialVisitFemaleAdult);
//		pprMap.put("initialVisitMalePed", initialVisitMalePed);
//		pprMap.put("initialVisitFemalePed", initialVisitFemalePed);
//
//		pprMap.put("followupCD4TestsMaleAdult", followupCD4TestsMaleAdult);
//		pprMap.put("followupCD4TestsFemaleAdult", followupCD4TestsFemaleAdult);
//		pprMap.put("followupCD4TestsMalePed", followupCD4TestsMalePed);
//		pprMap.put("followupCD4TestsFemalePed", followupCD4TestsFemalePed);
//
//		pprMap.put("initialCD4TestsMaleAdult", initialCD4TestsMaleAdult);
//		pprMap.put("initialCD4TestsFemaleAdult", initialCD4TestsFemaleAdult);
//		pprMap.put("initialCD4TestsMalePed", initialCD4TestsMalePed);
//		pprMap.put("initialCD4TestsFemalePed", initialCD4TestsFemalePed);
//
//		pprMap.put("clientOnARTMaleAdult", clientOnARTMaleAdult);
//		pprMap.put("clientOnARTFemaleAdult", clientOnARTFemaleAdult);
//		pprMap.put("clientOnARTMalePed", clientOnARTMalePed);
//		pprMap.put("clientOnARTFemalePed", clientOnARTFemalePed);
//
//		pprMap.put("deceasedNotOnARTMaleAdult", deceasedNotOnARTMaleAdult);
//		pprMap.put("deceasedNotOnARTFemaleAdult", deceasedNotOnARTFemaleAdult);
//		pprMap.put("deceasedNotOnARTMalePed", deceasedNotOnARTMalePed);
//		pprMap.put("deceasedNotOnARTFemalePed", deceasedNotOnARTFemalePed);
//
//		pprMap.put("deceasedARTClientsMaleAdult", deceasedARTClientsMaleAdult);
//		pprMap.put("deceasedARTClientsFemaleAdult", deceasedARTClientsFemaleAdult);
//		pprMap.put("deceasedARTClientsMalePed", deceasedARTClientsMalePed);
//		pprMap.put("deceasedARTClientsFemalePed", deceasedARTClientsFemalePed);

		return null;
	}

}

