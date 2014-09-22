<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>

<%@ include file="template/localHeader.jsp"%>

<openmrs:htmlInclude file="/scripts/calendar/calendar.js" /> 

<style>
	table {
		border: 1px solid black;
		box-shadow: 10px 10px 5px #888888;
		margin: 0 auto;s
	}
	table, th, td {
		border: 1px solid black;
	}
	.indicator {
		background-color: black;
	}
</style>
<form class="box" method="post">
Start Date: <input type="text" name="startDate" onfocus="showCalendar(this)" size="10" /> &nbsp; 
End date: <input type="text" name="endDate" onfocus="showCalendar(this)" size="10" /> </br>
<input type="submit" value="<spring:message code="Run report" />">
</form>

<table style="border:1px; table-spacing:0px">
	<thead>
		<tr>
			<th>&nbsp;</th>
			<th>&nbsp;</th>
			<th>Monday</th>
			<th>Tuesday</th>
			<th>Wednesday</th>
			<th>Thursday</th>
			<th>Friday</th>
			<th>Saturday</th>
			<th>Total</th>
		</tr>
	</thead>
	
	<tr>
		<td>1</td>
		<td><b>Total Clients Scheduled</b></td>
		<td class="indicator" colspan="8"></td>
	</tr>
	<tr>
		<td></td>
		<td>Adult - Male</td>
		<td>${scheduledVisitMaleAdult.indicatorMonday}</td>
		<td>${scheduledVisitMaleAdult.indicatorTuesday}</td>
		<td>${scheduledVisitMaleAdult.indictorWednesday}</td>
		<td>${scheduledVisitMaleAdult.indicatorThursday}</td>
		<td>${scheduledVisitMaleAdult.indicatorFriday}</td>
		<td>${scheduledVisitMaleAdult.indicatorSuturday}</td>
		<td>${scheduledVisitMaleAdult.indicatorMonday + scheduledVisitMaleAdult.indicatorTuesday + scheduledVisitMaleAdult.indictorWednesday + scheduledVisitMaleAdult.indicatorThursday + scheduledVisitMaleAdult.indicatorFriday + scheduledVisitMaleAdult.indicatorSuturday}</td>
	</tr>
	<tr>
		<td></td>
		<td>Adult - Female</td>
		<td>${scheduledVisitFemaleAdult.indicatorMonday}</td>
		<td>${scheduledVisitFemaleAdult.indicatorTuesday}</td>
		<td>${scheduledVisitFemaleAdult.indictorWednesday}</td>
		<td>${scheduledVisitFemaleAdult.indicatorThursday}</td>
		<td>${scheduledVisitFemaleAdult.indicatorFriday}</td>
		<td>${scheduledVisitFemaleAdult.indicatorSuturday}</td>
		<td>${scheduledVisitFemaleAdult.indicatorMonday + scheduledVisitFemaleAdult.indicatorTuesday + scheduledVisitFemaleAdult.indictorWednesday + scheduledVisitFemaleAdult.indicatorThursday + scheduledVisitFemaleAdult.indicatorFriday + scheduledVisitFemaleAdult.indicatorSuturday}</td>
	</tr>
	<tr>
		<td></td>
		<td>Pediatric - Male</td>
		<td>${scheduledVisitMalePed.indicatorMonday}</td>
		<td>${scheduledVisitMalePed.indicatorTuesday}</td>
		<td>${scheduledVisitMalePed.indictorWednesday}</td>
		<td>${scheduledVisitMalePed.indicatorThursday}</td>
		<td>${scheduledVisitMalePed.indicatorFriday}</td>
		<td>${scheduledVisitMalePed.indicatorSuturday}</td>
		<td>${scheduledVisitMalePed.indicatorMonday + scheduledVisitMalePed.indicatorTuesday + scheduledVisitMalePed.indictorWednesday + scheduledVisitMalePed.indicatorThursday + scheduledVisitMalePed.indicatorFriday + scheduledVisitMalePed.indicatorSuturday}</td>
	</tr>
	<tr>
		<td></td>
		<td>Pediatric - Female</td>
		<td>${scheduledVisitFemalePed.indicatorMonday}</td>
		<td>${scheduledVisitFemalePed.indicatorTuesday}</td>
		<td>${scheduledVisitFemalePed.indictorWednesday}</td>
		<td>${scheduledVisitFemalePed.indicatorThursday}</td>
		<td>${scheduledVisitFemalePed.indicatorFriday}</td>
		<td>${scheduledVisitFemalePed.indicatorSuturday}</td>
		<td>${scheduledVisitFemalePed.indicatorMonday + scheduledVisitFemalePed.indicatorTuesday + scheduledVisitFemalePed.indictorWednesday + scheduledVisitFemalePed.indicatorThursday + scheduledVisitFemalePed.indicatorFriday + scheduledVisitFemalePed.indicatorSuturday}</td>
	</tr>
	
	<tr>
		<td>2</td>
		<td><b>Total Clients who were Followed-up</b></td>
		<td class="indicator" colspan="8"></td>
	</tr>
	<tr>
		<td></td>
		<td>Adult - Male</td>
		<td>${followupVisitMaleAdult.indicatorMonday}</td>
		<td>${followupVisitMaleAdult.indicatorTuesday}</td>
		<td>${followupVisitMaleAdult.indictorWednesday}</td>
		<td>${followupVisitMaleAdult.indicatorThursday}</td>
		<td>${followupVisitMaleAdult.indicatorFriday}</td>
		<td>${followupVisitMaleAdult.indicatorSuturday}</td>
		<td>${followupVisitMaleAdult.indicatorMonday + followupVisitMaleAdult.indicatorTuesday + followupVisitMaleAdult.indictorWednesday + followupVisitMaleAdult.indicatorThursday + followupVisitMaleAdult.indicatorFriday + followupVisitMaleAdult.indicatorSuturday}</td>
	</tr>
	<tr>
		<td></td>
		<td>Adult - Female</td>
		<td>${followupVisitFemaleAdult.indicatorMonday}</td>
		<td>${followupVisitFemaleAdult.indicatorTuesday}</td>
		<td>${followupVisitFemaleAdult.indictorWednesday}</td>
		<td>${followupVisitFemaleAdult.indicatorThursday}</td>
		<td>${followupVisitFemaleAdult.indicatorFriday}</td>
		<td>${followupVisitFemaleAdult.indicatorSuturday}</td>
		<td>${followupVisitFemaleAdult.indicatorMonday + followupVisitFemaleAdult.indicatorTuesday + followupVisitFemaleAdult.indictorWednesday + followupVisitFemaleAdult.indicatorThursday + followupVisitFemaleAdult.indicatorFriday + followupVisitFemaleAdult.indicatorSuturday}</td>
	</tr>
	<tr>
		<td></td>
		<td>Pediatric - Male</td>
		<td>${followupVisitMalePed.indicatorMonday}</td>
		<td>${followupVisitMalePed.indicatorTuesday}</td>
		<td>${followupVisitMalePed.indictorWednesday}</td>
		<td>${followupVisitMalePed.indicatorThursday}</td>
		<td>${followupVisitMalePed.indicatorFriday}</td>
		<td>${followupVisitMalePed.indicatorSuturday}</td>
		<td>${followupVisitMalePed.indicatorMonday + followupVisitMalePed.indicatorTuesday + followupVisitMalePed.indictorWednesday + followupVisitMalePed.indicatorThursday + followupVisitMalePed.indicatorFriday + followupVisitMalePed.indicatorSuturday}</td>
	</tr>
	<tr>
		<td></td>
		<td>Pediatric - Female</td>
		<td>${followupVisitFemalePed.indicatorMonday}</td>
		<td>${followupVisitFemalePed.indicatorTuesday}</td>
		<td>${followupVisitFemalePed.indictorWednesday}</td>
		<td>${followupVisitFemalePed.indicatorThursday}</td>
		<td>${followupVisitFemalePed.indicatorFriday}</td>
		<td>${followupVisitFemalePed.indicatorSuturday}</td>
		<td>${followupVisitFemalePed.indicatorMonday + followupVisitFemalePed.indicatorTuesday + followupVisitFemalePed.indictorWednesday + followupVisitFemalePed.indicatorThursday + followupVisitFemalePed.indicatorFriday + followupVisitFemalePed.indicatorSuturday}</td>
	</tr>
	
	<tr>
		<td>3</td>
		<td><b>Total Existing Clients Seen</b></td>
		<td class="indicator" colspan="8"></td>
	</tr>
	<tr>
	<tr>
		<td></td>
		<td>Adult - Male</td>
		<td>${totalClienSeenMaleAdult.indicatorMonday}</td>
		<td>${totalClienSeenMaleAdult.indicatorTuesday}</td>
		<td>${totalClienSeenMaleAdult.indictorWednesday}</td>
		<td>${totalClienSeenMaleAdult.indicatorThursday}</td>
		<td>${totalClienSeenMaleAdult.indicatorFriday}</td>
		<td>${totalClienSeenMaleAdult.indicatorSuturday}</td>
		<td>${totalClienSeenMaleAdult.indicatorMonday + totalClienSeenMaleAdult.indicatorTuesday + totalClienSeenMaleAdult.indictorWednesday + totalClienSeenMaleAdult.indicatorThursday + totalClienSeenMaleAdult.indicatorFriday + totalClienSeenMaleAdult.indicatorSuturday}</td>
	</tr>
	<tr>
		<td></td>
		<td>Adult - Female</td>
		<td>${totalClienSeenFemaleAdult.indicatorMonday}</td>
		<td>${totalClienSeenFemaleAdult.indicatorTuesday}</td>
		<td>${totalClienSeenFemaleAdult.indictorWednesday}</td>
		<td>${totalClienSeenFemaleAdult.indicatorThursday}</td>
		<td>${totalClienSeenFemaleAdult.indicatorFriday}</td>
		<td>${totalClienSeenFemaleAdult.indicatorSuturday}</td>
		<td>${totalClienSeenFemaleAdult.indicatorMonday + totalClienSeenFemaleAdult.indicatorTuesday + totalClienSeenFemaleAdult.indictorWednesday + totalClienSeenFemaleAdult.indicatorThursday + totalClienSeenFemaleAdult.indicatorFriday + totalClienSeenFemaleAdult.indicatorSuturday}</td>
	</tr>
	<tr>
		<td></td>
		<td>Pediatric - Male</td>
		<td>${totalClienSeenMalePed.indicatorMonday}</td>
		<td>${totalClienSeenMalePed.indicatorTuesday}</td>
		<td>${totalClienSeenMalePed.indictorWednesday}</td>
		<td>${totalClienSeenMalePed.indicatorThursday}</td>
		<td>${totalClienSeenMalePed.indicatorFriday}</td>
		<td>${totalClienSeenMalePed.indicatorSuturday}</td>
		<td>${totalClienSeenMalePed.indicatorMonday + totalClienSeenMalePed.indicatorTuesday + totalClienSeenMalePed.indictorWednesday + totalClienSeenMalePed.indicatorThursday + totalClienSeenMalePed.indicatorFriday + totalClienSeenMalePed.indicatorSuturday}</td>
	</tr>
	<tr>
		<td></td>
		<td>Pediatric - Female</td>
		<td>${totalClienSeenFemalePed.indicatorMonday}</td>
		<td>${totalClienSeenFemalePed.indicatorTuesday}</td>
		<td>${totalClienSeenFemalePed.indictorWednesday}</td>
		<td>${totalClienSeenFemalePed.indicatorThursday}</td>
		<td>${totalClienSeenFemalePed.indicatorFriday}</td>
		<td>${totalClienSeenFemalePed.indicatorSuturday}</td>
		<td>${totalClienSeenFemalePed.indicatorMonday + totalClienSeenFemalePed.indicatorTuesday + totalClienSeenFemalePed.indictorWednesday + totalClienSeenFemalePed.indicatorThursday + totalClienSeenFemalePed.indicatorFriday + totalClienSeenFemalePed.indicatorSuturday}</td>
	</tr>
	
	<tr>
		<td>4</td>
		<td><b>Total New Clients Seen</b></td>
		<td class="indicator" colspan="8"></td>
	</tr>
	<tr>
		<td></td>
		<td>Adult - Male</td>
		<td>${initialVisitMaleAdult.indicatorMonday}</td>
		<td>${initialVisitMaleAdult.indicatorTuesday}</td>
		<td>${initialVisitMaleAdult.indictorWednesday}</td>
		<td>${initialVisitMaleAdult.indicatorThursday}</td>
		<td>${initialVisitMaleAdult.indicatorFriday}</td>
		<td>${initialVisitMaleAdult.indicatorSuturday}</td>
		<td>${initialVisitMaleAdult.indicatorMonday + initialVisitMaleAdult.indicatorTuesday + initialVisitMaleAdult.indictorWednesday + initialVisitMaleAdult.indicatorThursday + initialVisitMaleAdult.indicatorFriday + initialVisitMaleAdult.indicatorSuturday}</td>
	</tr>
	<tr>
		<td></td>
		<td>Adult - Female</td>
		<td>${initialVisitFemaleAdult.indicatorMonday}</td>
		<td>${initialVisitFemaleAdult.indicatorTuesday}</td>
		<td>${initialVisitFemaleAdult.indictorWednesday}</td>
		<td>${initialVisitFemaleAdult.indicatorThursday}</td>
		<td>${initialVisitFemaleAdult.indicatorFriday}</td>
		<td>${initialVisitFemaleAdult.indicatorSuturday}</td>
		<td>${initialVisitFemaleAdult.indicatorMonday + initialVisitFemaleAdult.indicatorTuesday + initialVisitFemaleAdult.indictorWednesday + initialVisitFemaleAdult.indicatorThursday + initialVisitFemaleAdult.indicatorFriday + initialVisitFemaleAdult.indicatorSuturday}</td>
	</tr>
	<tr>
		<td></td>
		<td>Pediatric - Male</td>
		<td>${initialVisitMalePed.indicatorMonday}</td>
		<td>${initialVisitMalePed.indicatorTuesday}</td>
		<td>${initialVisitMalePed.indictorWednesday}</td>
		<td>${initialVisitMalePed.indicatorThursday}</td>
		<td>${initialVisitMalePed.indicatorFriday}</td>
		<td>${initialVisitMalePed.indicatorSuturday}</td>
		<td>${initialVisitMalePed.indicatorMonday + initialVisitMalePed.indicatorTuesday + initialVisitMalePed.indictorWednesday + initialVisitMalePed.indicatorThursday + initialVisitMalePed.indicatorFriday + initialVisitMalePed.indicatorSuturday}</td>
	</tr>
	<tr>
		<td></td>
		<td>Pediatric - Female</td>
		<td>${initialVisitFemalePed.indicatorMonday}</td>
		<td>${initialVisitFemalePed.indicatorTuesday}</td>
		<td>${initialVisitFemalePed.indictorWednesday}</td>
		<td>${initialVisitFemalePed.indicatorThursday}</td>
		<td>${initialVisitFemalePed.indicatorFriday}</td>
		<td>${initialVisitFemalePed.indicatorSuturday}</td>
		<td>${initialVisitFemalePed.indicatorMonday + initialVisitFemalePed.indicatorTuesday + initialVisitFemalePed.indictorWednesday + initialVisitFemalePed.indicatorThursday + initialVisitFemalePed.indicatorFriday + initialVisitFemalePed.indicatorSuturday}</td>
	</tr>
	
	<tr>
		<td>5</td>
		<td><b>Total Follow-up CD4 Tests Conducted</b></td>
		<td class="indicator" colspan="8"></td>
	</tr>
	<tr>
		<td></td>
		<td>Adult - Male</td>
		<td>${followupCD4TestsMaleAdult.indicatorMonday}</td>
		<td>${followupCD4TestsMaleAdult.indicatorTuesday}</td>
		<td>${followupCD4TestsMaleAdult.indictorWednesday}</td>
		<td>${followupCD4TestsMaleAdult.indicatorThursday}</td>
		<td>${followupCD4TestsMaleAdult.indicatorFriday}</td>
		<td>${followupCD4TestsMaleAdult.indicatorSuturday}</td>
		<td>${followupCD4TestsMaleAdult.indicatorMonday + followupCD4TestsMaleAdult.indicatorTuesday + followupCD4TestsMaleAdult.indictorWednesday + followupCD4TestsMaleAdult.indicatorThursday + followupCD4TestsMaleAdult.indicatorFriday + followupCD4TestsMaleAdult.indicatorSuturday}</td>
	</tr>
	<tr>
		<td></td>
		<td>Adult - Female</td>
		<td>${followupCD4TestsFemaleAdult.indicatorMonday}</td>
		<td>${followupCD4TestsFemaleAdult.indicatorTuesday}</td>
		<td>${followupCD4TestsFemaleAdult.indictorWednesday}</td>
		<td>${followupCD4TestsFemaleAdult.indicatorThursday}</td>
		<td>${followupCD4TestsFemaleAdult.indicatorFriday}</td>
		<td>${followupCD4TestsFemaleAdult.indicatorSuturday}</td>
		<td>${followupCD4TestsFemaleAdult.indicatorMonday + followupCD4TestsFemaleAdult.indicatorTuesday + followupCD4TestsFemaleAdult.indictorWednesday + followupCD4TestsFemaleAdult.indicatorThursday + followupCD4TestsFemaleAdult.indicatorFriday + followupCD4TestsFemaleAdult.indicatorSuturday}</td>
	</tr>
	<tr>
		<td></td>
		<td>Pediatric - Male</td>
		<td>${followupCD4TestsMalePed.indicatorMonday}</td>
		<td>${followupCD4TestsMalePed.indicatorTuesday}</td>
		<td>${followupCD4TestsMalePed.indictorWednesday}</td>
		<td>${followupCD4TestsMalePed.indicatorThursday}</td>
		<td>${followupCD4TestsMalePed.indicatorFriday}</td>
		<td>${followupCD4TestsMalePed.indicatorSuturday}</td>
		<td>${followupCD4TestsMalePed.indicatorMonday + followupCD4TestsMalePed.indicatorTuesday + followupCD4TestsMalePed.indictorWednesday + followupCD4TestsMalePed.indicatorThursday + followupCD4TestsMalePed.indicatorFriday + followupCD4TestsMalePed.indicatorSuturday}</td>
	</tr>
	<tr>
		<td></td>
		<td>Pediatric - Female</td>
		<td>${followupCD4TestsFemalePed.indicatorMonday}</td>
		<td>${followupCD4TestsFemalePed.indicatorTuesday}</td>
		<td>${followupCD4TestsFemalePed.indictorWednesday}</td>
		<td>${followupCD4TestsFemalePed.indicatorThursday}</td>
		<td>${followupCD4TestsFemalePed.indicatorFriday}</td>
		<td>${followupCD4TestsFemalePed.indicatorSuturday}</td>
		<td>${followupCD4TestsFemalePed.indicatorMonday + followupCD4TestsFemalePed.indicatorTuesday + followupCD4TestsFemalePed.indictorWednesday + followupCD4TestsFemalePed.indicatorThursday + followupCD4TestsFemalePed.indicatorFriday + followupCD4TestsFemalePed.indicatorSuturday}</td>
	</tr>
	
	<tr>
		<td>6</td>
		<td><b>Total Initial CD4 Tests Conducted</b></td>
		<td class="indicator" colspan="8"></td>
	</tr>
	<tr>
		<td></td>
		<td>Adult - Male</td>
		<td>${initialCD4TestsMaleAdult.indicatorMonday}</td>
		<td>${initialCD4TestsMaleAdult.indicatorTuesday}</td>
		<td>${initialCD4TestsMaleAdult.indictorWednesday}</td>
		<td>${initialCD4TestsMaleAdult.indicatorThursday}</td>
		<td>${initialCD4TestsMaleAdult.indicatorFriday}</td>
		<td>${initialCD4TestsMaleAdult.indicatorSuturday}</td>
		<td>${initialCD4TestsMaleAdult.indicatorMonday + initialCD4TestsMaleAdult.indicatorTuesday + initialCD4TestsMaleAdult.indictorWednesday + initialCD4TestsMaleAdult.indicatorThursday + initialCD4TestsMaleAdult.indicatorFriday + initialCD4TestsMaleAdult.indicatorSuturday}</td>
	</tr>
	<tr>
		<td></td>
		<td>Adult - Female</td>
		<td>${initialCD4TestsFemaleAdult.indicatorMonday}</td>
		<td>${initialCD4TestsFemaleAdult.indicatorTuesday}</td>
		<td>${initialCD4TestsFemaleAdult.indictorWednesday}</td>
		<td>${initialCD4TestsFemaleAdult.indicatorThursday}</td>
		<td>${initialCD4TestsFemaleAdult.indicatorFriday}</td>
		<td>${initialCD4TestsFemaleAdult.indicatorSuturday}</td>
		<td>${initialCD4TestsFemaleAdult.indicatorMonday + initialCD4TestsFemaleAdult.indicatorTuesday + initialCD4TestsFemaleAdult.indictorWednesday + initialCD4TestsFemaleAdult.indicatorThursday + initialCD4TestsFemaleAdult.indicatorFriday + initialCD4TestsFemaleAdult.indicatorSuturday}</td>
	</tr>
	<tr>
		<td></td>
		<td>Pediatric - Male</td>
		<td>${initialCD4TestsMalePed.indicatorMonday}</td>
		<td>${initialCD4TestsMalePed.indicatorTuesday}</td>
		<td>${initialCD4TestsMalePed.indictorWednesday}</td>
		<td>${initialCD4TestsMalePed.indicatorThursday}</td>
		<td>${initialCD4TestsMalePed.indicatorFriday}</td>
		<td>${initialCD4TestsMalePed.indicatorSuturday}</td>
		<td>${initialCD4TestsMalePed.indicatorMonday + initialCD4TestsMalePed.indicatorTuesday + initialCD4TestsMalePed.indictorWednesday + initialCD4TestsMalePed.indicatorThursday + initialCD4TestsMalePed.indicatorFriday + initialCD4TestsMalePed.indicatorSuturday}</td>
	</tr>
	<tr>
		<td></td>
		<td>Pediatric - Female</td>
		<td>${initialCD4TestsFemalePed.indicatorMonday}</td>
		<td>${initialCD4TestsFemalePed.indicatorTuesday}</td>
		<td>${initialCD4TestsFemalePed.indictorWednesday}</td>
		<td>${initialCD4TestsFemalePed.indicatorThursday}</td>
		<td>${initialCD4TestsFemalePed.indicatorFriday}</td>
		<td>${initialCD4TestsFemalePed.indicatorSuturday}</td>
		<td>${initialCD4TestsFemalePed.indicatorMonday + initialCD4TestsFemalePed.indicatorTuesday + initialCD4TestsFemalePed.indictorWednesday + initialCD4TestsFemalePed.indicatorThursday + initialCD4TestsFemalePed.indicatorFriday + initialCD4TestsFemalePed.indicatorSuturday}</td>
	</tr>
	
	<tr>
		<td>7</td>
		<td><b>Total Clients initiated on ART</b></td>
		<td class="indicator" colspan="8"></td>
	</tr>
	<tr>
		<td></td>
		<td>Adult - Male</td>
		<td>${clientOnARTMaleAdult.indicatorMonday}</td>
		<td>${clientOnARTMaleAdult.indicatorTuesday}</td>
		<td>${clientOnARTMaleAdult.indictorWednesday}</td>
		<td>${clientOnARTMaleAdult.indicatorThursday}</td>
		<td>${clientOnARTMaleAdult.indicatorFriday}</td>
		<td>${clientOnARTMaleAdult.indicatorSuturday}</td>
		<td>${clientOnARTMaleAdult.indicatorMonday + clientOnARTMaleAdult.indicatorTuesday + clientOnARTMaleAdult.indictorWednesday + clientOnARTMaleAdult.indicatorThursday + clientOnARTMaleAdult.indicatorFriday + clientOnARTMaleAdult.indicatorSuturday}</td>
	</tr>
	<tr>
		<td></td>
		<td>Adult - Female</td>
		<td>${clientOnARTFemaleAdult.indicatorMonday}</td>
		<td>${clientOnARTFemaleAdult.indicatorTuesday}</td>
		<td>${clientOnARTFemaleAdult.indictorWednesday}</td>
		<td>${clientOnARTFemaleAdult.indicatorThursday}</td>
		<td>${clientOnARTFemaleAdult.indicatorFriday}</td>
		<td>${clientOnARTFemaleAdult.indicatorSuturday}</td>
		<td>${clientOnARTFemaleAdult.indicatorMonday + clientOnARTFemaleAdult.indicatorTuesday + clientOnARTFemaleAdult.indictorWednesday + clientOnARTFemaleAdult.indicatorThursday + clientOnARTFemaleAdult.indicatorFriday + clientOnARTFemaleAdult.indicatorSuturday}</td>
	</tr>
	<tr>
		<td></td>
		<td>Pediatric - Male</td>
		<td>${clientOnARTMalePed.indicatorMonday}</td>
		<td>${clientOnARTMalePed.indicatorTuesday}</td>
		<td>${clientOnARTMalePed.indictorWednesday}</td>
		<td>${clientOnARTMalePed.indicatorThursday}</td>
		<td>${clientOnARTMalePed.indicatorFriday}</td>
		<td>${clientOnARTMalePed.indicatorSuturday}</td>
		<td>${clientOnARTMalePed.indicatorMonday + clientOnARTMalePed.indicatorTuesday + clientOnARTMalePed.indictorWednesday + clientOnARTMalePed.indicatorThursday + clientOnARTMalePed.indicatorFriday + clientOnARTMalePed.indicatorSuturday}</td>
	</tr>
	<tr>
		<td></td>
		<td>Pediatric - Female</td>
		<td>${clientOnARTFemalePed.indicatorMonday}</td>
		<td>${clientOnARTFemalePed.indicatorTuesday}</td>
		<td>${clientOnARTFemalePed.indictorWednesday}</td>
		<td>${clientOnARTFemalePed.indicatorThursday}</td>
		<td>${clientOnARTFemalePed.indicatorFriday}</td>
		<td>${clientOnARTFemalePed.indicatorSuturday}</td>
		<td>${clientOnARTFemalePed.indicatorMonday + clientOnARTFemalePed.indicatorTuesday + clientOnARTFemalePed.indictorWednesday + clientOnARTFemalePed.indicatorThursday + clientOnARTFemalePed.indicatorFriday + clientOnARTFemalePed.indicatorSuturday}</td>
	</tr>
	
	<tr>
		<td>8</td>
		<td><b>Total number of deceased clients not on ART</b></td>
		<td class="indicator" colspan="8"></td>
	</tr>
	<tr>
		<td></td>
		<td>Adult - Male</td>
		<td>${deceasedNotOnARTMaleAdult.indicatorMonday}</td>
		<td>${deceasedNotOnARTMaleAdult.indicatorTuesday}</td>
		<td>${deceasedNotOnARTMaleAdult.indictorWednesday}</td>
		<td>${deceasedNotOnARTMaleAdult.indicatorThursday}</td>
		<td>${deceasedNotOnARTMaleAdult.indicatorFriday}</td>
		<td>${deceasedNotOnARTMaleAdult.indicatorSuturday}</td>
		<td>${deceasedNotOnARTMaleAdult.indicatorMonday + deceasedNotOnARTMaleAdult.indicatorTuesday + deceasedNotOnARTMaleAdult.indictorWednesday + deceasedNotOnARTMaleAdult.indicatorThursday + deceasedNotOnARTMaleAdult.indicatorFriday + deceasedNotOnARTMaleAdult.indicatorSuturday}</td>
	</tr>
	<tr>
		<td></td>
		<td>Adult - Female</td>
		<td>${deceasedNotOnARTFemaleAdult.indicatorMonday}</td>
		<td>${deceasedNotOnARTFemaleAdult.indicatorTuesday}</td>
		<td>${deceasedNotOnARTFemaleAdult.indictorWednesday}</td>
		<td>${deceasedNotOnARTFemaleAdult.indicatorThursday}</td>
		<td>${deceasedNotOnARTFemaleAdult.indicatorFriday}</td>
		<td>${deceasedNotOnARTFemaleAdult.indicatorSuturday}</td>
		<td>${deceasedNotOnARTFemaleAdult.indicatorMonday + deceasedNotOnARTFemaleAdult.indicatorTuesday + deceasedNotOnARTFemaleAdult.indictorWednesday + deceasedNotOnARTFemaleAdult.indicatorThursday + deceasedNotOnARTFemaleAdult.indicatorFriday + deceasedNotOnARTFemaleAdult.indicatorSuturday}</td>
	</tr>
	<tr>
		<td></td>
		<td>Pediatric - Male</td>
		<td>${deceasedNotOnARTMalePed.indicatorMonday}</td>
		<td>${deceasedNotOnARTMalePed.indicatorTuesday}</td>
		<td>${deceasedNotOnARTMalePed.indictorWednesday}</td>
		<td>${deceasedNotOnARTMalePed.indicatorThursday}</td>
		<td>${deceasedNotOnARTMalePed.indicatorFriday}</td>
		<td>${deceasedNotOnARTMalePed.indicatorSuturday}</td>
		<td>${deceasedNotOnARTMalePed.indicatorMonday + deceasedNotOnARTMalePed.indicatorTuesday + deceasedNotOnARTMalePed.indictorWednesday + deceasedNotOnARTMalePed.indicatorThursday + deceasedNotOnARTMalePed.indicatorFriday + deceasedNotOnARTMalePed.indicatorSuturday}</td>
	</tr>
	<tr>
		<td></td>
		<td>Pediatric - Female</td>
		<td>${deceasedNotOnARTFemalePed.indicatorMonday}</td>
		<td>${deceasedNotOnARTFemalePed.indicatorTuesday}</td>
		<td>${deceasedNotOnARTFemalePed.indictorWednesday}</td>
		<td>${deceasedNotOnARTFemalePed.indicatorThursday}</td>
		<td>${deceasedNotOnARTFemalePed.indicatorFriday}</td>
		<td>${deceasedNotOnARTFemalePed.indicatorSuturday}</td>
		<td>${deceasedNotOnARTFemalePed.indicatorMonday + deceasedNotOnARTFemalePed.indicatorTuesday + deceasedNotOnARTFemalePed.indictorWednesday + deceasedNotOnARTFemalePed.indicatorThursday + deceasedNotOnARTFemalePed.indicatorFriday + deceasedNotOnARTFemalePed.indicatorSuturday}</td>
	</tr>
	
	<tr>
		<td>9</td>
		<td><b>Total number of deceased ART clients</b></td>
		<td class="indicator" colspan="8"></td>
	</tr>
	<tr>
		<td></td>
		<td>Adult - Male</td>
		<td>${deceasedARTClientsMaleAdult.indicatorMonday}</td>
		<td>${deceasedARTClientsMaleAdult.indicatorTuesday}</td>
		<td>${deceasedARTClientsMaleAdult.indictorWednesday}</td>
		<td>${deceasedARTClientsMaleAdult.indicatorThursday}</td>
		<td>${deceasedARTClientsMaleAdult.indicatorFriday}</td>
		<td>${deceasedARTClientsMaleAdult.indicatorSuturday}</td>
		<td>${deceasedARTClientsMaleAdult.indicatorMonday + deceasedARTClientsMaleAdult.indicatorTuesday + deceasedARTClientsMaleAdult.indictorWednesday + deceasedARTClientsMaleAdult.indicatorThursday + deceasedARTClientsMaleAdult.indicatorFriday + deceasedARTClientsMaleAdult.indicatorSuturday}</td>
	</tr>
	<tr>
		<td></td>
		<td>Adult - Female</td>
		<td>${deceasedARTClientsFemaleAdult.indicatorMonday}</td>
		<td>${deceasedARTClientsFemaleAdult.indicatorTuesday}</td>
		<td>${deceasedARTClientsFemaleAdult.indictorWednesday}</td>
		<td>${deceasedARTClientsFemaleAdult.indicatorThursday}</td>
		<td>${deceasedARTClientsFemaleAdult.indicatorFriday}</td>
		<td>${deceasedARTClientsFemaleAdult.indicatorSuturday}</td>
		<td>${deceasedARTClientsFemaleAdult.indicatorMonday + deceasedARTClientsFemaleAdult.indicatorTuesday + deceasedARTClientsFemaleAdult.indictorWednesday + deceasedARTClientsFemaleAdult.indicatorThursday + deceasedARTClientsFemaleAdult.indicatorFriday + deceasedARTClientsFemaleAdult.indicatorSuturday}</td>
	</tr>
	<tr>
		<td></td>
		<td>Pediatric - Male</td>
		<td>${deceasedARTClientsMalePed.indicatorMonday}</td>
		<td>${deceasedARTClientsMalePed.indicatorTuesday}</td>
		<td>${deceasedARTClientsMalePed.indictorWednesday}</td>
		<td>${deceasedARTClientsMalePed.indicatorThursday}</td>
		<td>${deceasedARTClientsMalePed.indicatorFriday}</td>
		<td>${deceasedARTClientsMalePed.indicatorSuturday}</td>
		<td>${deceasedARTClientsMalePed.indicatorMonday + deceasedARTClientsMalePed.indicatorTuesday + deceasedARTClientsMalePed.indictorWednesday + deceasedARTClientsMalePed.indicatorThursday + deceasedARTClientsMalePed.indicatorFriday + deceasedARTClientsMalePed.indicatorSuturday}</td>
	</tr>
	<tr>
		<td></td>
		<td>Pediatric - Female</td>
		<td>${deceasedARTClientsFemalePed.indicatorMonday}</td>
		<td>${deceasedARTClientsFemalePed.indicatorTuesday}</td>
		<td>${deceasedARTClientsFemalePed.indictorWednesday}</td>
		<td>${deceasedARTClientsFemalePed.indicatorThursday}</td>
		<td>${deceasedARTClientsFemalePed.indicatorFriday}</td>
		<td>${deceasedARTClientsFemalePed.indicatorSuturday}</td>
		<td>${deceasedARTClientsFemalePed.indicatorMonday + deceasedARTClientsFemalePed.indicatorTuesday + deceasedARTClientsFemalePed.indictorWednesday + deceasedARTClientsFemalePed.indicatorThursday + deceasedARTClientsFemalePed.indicatorFriday + deceasedARTClientsFemalePed.indicatorSuturday}</td>
	</tr>
		<td>10</td>
		<td><b>Total number of clients seen by Nurses</b></td>
		<td class="indicator" colspan="8"></td>
	</tr>
	<tr>
		<td></td>
		<td>Adult - Male</td>
		<td>${clientSeenByNurseMaleAdult.indicatorMonday}</td>
		<td>${clientSeenByNurseMaleAdult.indicatorTuesday}</td>
		<td>${clientSeenByNurseMaleAdult.indictorWednesday}</td>
		<td>${clientSeenByNurseMaleAdult.indicatorThursday}</td>
		<td>${clientSeenByNurseMaleAdult.indicatorFriday}</td>
		<td>${clientSeenByNurseMaleAdult.indicatorSuturday}</td>
		<td>${clientSeenByNurseMaleAdult.indicatorMonday + clientSeenByNurseMaleAdult.indicatorTuesday + clientSeenByNurseMaleAdult.indictorWednesday + clientSeenByNurseMaleAdult.indicatorThursday + clientSeenByNurseMaleAdult.indicatorFriday + clientSeenByNurseMaleAdult.indicatorSuturday}</td>
	</tr>
	<tr>
		<td></td>
		<td>Adult - Female</td>
		<td>${clientSeenByNurseFemaleAdult.indicatorMonday}</td>
		<td>${clientSeenByNurseFemaleAdult.indicatorTuesday}</td>
		<td>${clientSeenByNurseFemaleAdult.indictorWednesday}</td>
		<td>${clientSeenByNurseFemaleAdult.indicatorThursday}</td>
		<td>${clientSeenByNurseFemaleAdult.indicatorFriday}</td>
		<td>${clientSeenByNurseFemaleAdult.indicatorSuturday}</td>
		<td>${clientSeenByNurseFemaleAdult.indicatorMonday + clientSeenByNurseFemaleAdult.indicatorTuesday + clientSeenByNurseFemaleAdult.indictorWednesday + clientSeenByNurseFemaleAdult.indicatorThursday + clientSeenByNurseFemaleAdult.indicatorFriday + clientSeenByNurseFemaleAdult.indicatorSuturday}</td>
	</tr>
	<tr>
		<td></td>
		<td>Pediatric - Male</td>
		<td>${clientSeenByNurseMalePed.indicatorMonday}</td>
		<td>${clientSeenByNurseMalePed.indicatorTuesday}</td>
		<td>${clientSeenByNurseMalePed.indictorWednesday}</td>
		<td>${clientSeenByNurseMalePed.indicatorThursday}</td>
		<td>${clientSeenByNurseMalePed.indicatorFriday}</td>
		<td>${clientSeenByNurseMalePed.indicatorSuturday}</td>
		<td>${clientSeenByNurseMalePed.indicatorMonday + clientSeenByNurseMalePed.indicatorTuesday + clientSeenByNurseMalePed.indictorWednesday + clientSeenByNurseMalePed.indicatorThursday + clientSeenByNurseMalePed.indicatorFriday + clientSeenByNurseMalePed.indicatorSuturday}</td>
	</tr>
	<tr>
		<td></td>
		<td>Pediatric - Female</td>
		<td>${clientSeenByNurseFemalePed.indicatorMonday}</td>
		<td>${clientSeenByNurseFemalePed.indicatorTuesday}</td>
		<td>${clientSeenByNurseFemalePed.indictorWednesday}</td>
		<td>${clientSeenByNurseFemalePed.indicatorThursday}</td>
		<td>${clientSeenByNurseFemalePed.indicatorFriday}</td>
		<td>${clientSeenByNurseFemalePed.indicatorSuturday}</td>
		<td>${clientSeenByNurseFemalePed.indicatorMonday + clientSeenByNurseFemalePed.indicatorTuesday + clientSeenByNurseFemalePed.indictorWednesday + clientSeenByNurseFemalePed.indicatorThursday + clientSeenByNurseFemalePed.indicatorFriday + clientSeenByNurseFemalePed.indicatorSuturday}</td>
	</tr>
		<td>11</td>
		<td><b>Total number of clients seen by Phyisicians</b></td>
		<td class="indicator" colspan="8"></td>
	</tr>
	<tr>
		<td></td>
		<td>Adult - Male</td>
		<td>${clientSeenByPhysicianMaleAdult.indicatorMonday}</td>
		<td>${clientSeenByPhysicianMaleAdult.indicatorTuesday}</td>
		<td>${clientSeenByPhysicianMaleAdult.indictorWednesday}</td>
		<td>${clientSeenByPhysicianMaleAdult.indicatorThursday}</td>
		<td>${clientSeenByPhysicianMaleAdult.indicatorFriday}</td>
		<td>${clientSeenByPhysicianMaleAdult.indicatorSuturday}</td>
		<td>${clientSeenByPhysicianMaleAdult.indicatorMonday + clientSeenByPhysicianMaleAdult.indicatorTuesday + clientSeenByPhysicianMaleAdult.indictorWednesday + clientSeenByPhysicianMaleAdult.indicatorThursday + clientSeenByPhysicianMaleAdult.indicatorFriday + clientSeenByPhysicianMaleAdult.indicatorSuturday}</td>
	</tr>
	<tr>
		<td></td>
		<td>Adult - Female</td>
		<td>${clientSeenByPhysicianFemaleAdult.indicatorMonday}</td>
		<td>${clientSeenByPhysicianFemaleAdult.indicatorTuesday}</td>
		<td>${clientSeenByPhysicianFemaleAdult.indictorWednesday}</td>
		<td>${clientSeenByPhysicianFemaleAdult.indicatorThursday}</td>
		<td>${clientSeenByPhysicianFemaleAdult.indicatorFriday}</td>
		<td>${clientSeenByPhysicianFemaleAdult.indicatorSuturday}</td>
		<td>${clientSeenByPhysicianFemaleAdult.indicatorMonday + clientSeenByPhysicianFemaleAdult.indicatorTuesday + clientSeenByPhysicianFemaleAdult.indictorWednesday + clientSeenByPhysicianFemaleAdult.indicatorThursday + clientSeenByPhysicianFemaleAdult.indicatorFriday + clientSeenByPhysicianFemaleAdult.indicatorSuturday}</td>
	</tr>
	<tr>
		<td></td>
		<td>Pediatric - Male</td>
		<td>${clientSeenByPhysicianMalePed.indicatorMonday}</td>
		<td>${clientSeenByPhysicianMalePed.indicatorTuesday}</td>
		<td>${clientSeenByPhysicianMalePed.indictorWednesday}</td>
		<td>${clientSeenByPhysicianMalePed.indicatorThursday}</td>
		<td>${clientSeenByPhysicianMalePed.indicatorFriday}</td>
		<td>${clientSeenByPhysicianMalePed.indicatorSuturday}</td>
		<td>${clientSeenByPhysicianMalePed.indicatorMonday + clientSeenByPhysicianMalePed.indicatorTuesday + clientSeenByPhysicianMalePed.indictorWednesday + clientSeenByPhysicianMalePed.indicatorThursday + clientSeenByPhysicianMalePed.indicatorFriday + clientSeenByPhysicianMalePed.indicatorSuturday}</td>
	</tr>
	<tr>
		<td></td>
		<td>Pediatric - Female</td>
		<td>${clientSeenByPhysicianFemalePed.indicatorMonday}</td>
		<td>${clientSeenByPhysicianFemalePed.indicatorTuesday}</td>
		<td>${clientSeenByPhysicianFemalePed.indictorWednesday}</td>
		<td>${clientSeenByPhysicianFemalePed.indicatorThursday}</td>
		<td>${clientSeenByPhysicianFemalePed.indicatorFriday}</td>
		<td>${clientSeenByPhysicianFemalePed.indicatorSuturday}</td>
		<td>${clientSeenByPhysicianFemalePed.indicatorMonday + clientSeenByPhysicianFemalePed.indicatorTuesday + clientSeenByPhysicianFemalePed.indictorWednesday + clientSeenByPhysicianFemalePed.indicatorThursday + clientSeenByPhysicianFemalePed.indicatorFriday + clientSeenByPhysicianFemalePed.indicatorSuturday}</td>
	</tr>
		<td>12</td>
		<td><b>Total number of clients who missed their appointments</b></td>
		<td class="indicator" colspan="8"></td>
	</tr>
	<tr>
		<td></td>
		<td>Adult - Male</td>
		<td>${missedAppointmentMaleAdult.indicatorMonday}</td>
		<td>${missedAppointmentMaleAdult.indicatorTuesday}</td>
		<td>${missedAppointmentMaleAdult.indictorWednesday}</td>
		<td>${missedAppointmentMaleAdult.indicatorThursday}</td>
		<td>${missedAppointmentMaleAdult.indicatorFriday}</td>
		<td>${missedAppointmentMaleAdult.indicatorSuturday}</td>
		<td>${missedAppointmentMaleAdult.indicatorMonday + missedAppointmentMaleAdult.indicatorTuesday + missedAppointmentMaleAdult.indictorWednesday + missedAppointmentMaleAdult.indicatorThursday + missedAppointmentMaleAdult.indicatorFriday + missedAppointmentMaleAdult.indicatorSuturday}</td>
	</tr>
	<tr>
		<td></td>
		<td>Adult - Female</td>
		<td>${missedAppointmentFemaleAdult.indicatorMonday}</td>
		<td>${missedAppointmentFemaleAdult.indicatorTuesday}</td>
		<td>${missedAppointmentFemaleAdult.indictorWednesday}</td>
		<td>${missedAppointmentFemaleAdult.indicatorThursday}</td>
		<td>${missedAppointmentFemaleAdult.indicatorFriday}</td>
		<td>${missedAppointmentFemaleAdult.indicatorSuturday}</td>
		<td>${missedAppointmentFemaleAdult.indicatorMonday + missedAppointmentFemaleAdult.indicatorTuesday + missedAppointmentFemaleAdult.indictorWednesday + missedAppointmentFemaleAdult.indicatorThursday + missedAppointmentFemaleAdult.indicatorFriday + missedAppointmentFemaleAdult.indicatorSuturday}</td>
	</tr>
	<tr>
		<td></td>
		<td>Pediatric - Male</td>
		<td>${missedAppointmentMalePed.indicatorMonday}</td>
		<td>${missedAppointmentMalePed.indicatorTuesday}</td>
		<td>${missedAppointmentMalePed.indictorWednesday}</td>
		<td>${missedAppointmentMalePed.indicatorThursday}</td>
		<td>${missedAppointmentMalePed.indicatorFriday}</td>
		<td>${missedAppointmentMalePed.indicatorSuturday}</td>
		<td>${missedAppointmentMalePed.indicatorMonday + missedAppointmentMalePed.indicatorTuesday + missedAppointmentMalePed.indictorWednesday + missedAppointmentMalePed.indicatorThursday + missedAppointmentMalePed.indicatorFriday + missedAppointmentMalePed.indicatorSuturday}</td>
	</tr>
	<tr>
		<td></td>
		<td>Pediatric - Female</td>
		<td>${missedAppointmentFemalePed.indicatorMonday}</td>
		<td>${missedAppointmentFemalePed.indicatorTuesday}</td>
		<td>${missedAppointmentFemalePed.indictorWednesday}</td>
		<td>${missedAppointmentFemalePed.indicatorThursday}</td>
		<td>${missedAppointmentFemalePed.indicatorFriday}</td>
		<td>${missedAppointmentFemalePed.indicatorSuturday}</td>
		<td>${missedAppointmentFemalePed.indicatorMonday + missedAppointmentFemalePed.indicatorTuesday + missedAppointmentFemalePed.indictorWednesday + missedAppointmentFemalePed.indicatorThursday + missedAppointmentFemalePed.indicatorFriday + missedAppointmentFemalePed.indicatorSuturday}</td>
	</tr>

</table>

<%@ include file="/WEB-INF/template/footer.jsp"%>