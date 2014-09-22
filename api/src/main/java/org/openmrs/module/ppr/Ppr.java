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
package org.openmrs.module.ppr;

public class Ppr {

	private static final long serialVersionUID = 1L;
	
	private int indicatorMonday;
	private int indicatorTuesday;
	private int indictorWednesday;
	private int indicatorThursday;
	private int indicatorFriday;
	private int indicatorSuturday;

	public Ppr(int indicatorMonday, int indicatorTuesday, int indictorWednesday, int indicatorThursday, int indicatorFriday, int indicatorSuturday) {
		this.indicatorMonday = indicatorMonday;
		this.indicatorTuesday = indicatorTuesday;
		this.indictorWednesday = indictorWednesday;
		this.indicatorThursday = indicatorThursday;
		this.indicatorFriday = indicatorFriday;
		this.indicatorSuturday = indicatorSuturday;
	}

	public Integer getIndicatorMonday() {
		return indicatorMonday;
	}

	public void setIndicatorMonday(int indicatorMonday) {
		this.indicatorMonday = indicatorMonday;
	}

	public Integer getIndicatorTuesday() {
		return indicatorTuesday;
	}

	public void setIndicatorTuesday(int indicatorTuesday) {
		this.indicatorTuesday = indicatorTuesday;
	}

	public Integer getIndictorWednesday() {
		return indictorWednesday;
	}

	public void setIndictorWednesday(int indictorWednesday) {
		this.indictorWednesday = indictorWednesday;
	}

	public Integer getIndicatorThursday() {
		return indicatorThursday;
	}

	public void setIndicatorThursday(int indicatorThursday) {
		this.indicatorThursday = indicatorThursday;
	}



	public Integer getIndicatorFriday() {
		return indicatorFriday;
	}

	public void setIndicatorFriday(int indicatorFriday) {
		this.indicatorFriday = indicatorFriday;
	}

	public Integer getIndicatorSuturday() {
		return indicatorSuturday;
	}

	public void setIndicatorSuturday(int indicatorSuturday) {
		this.indicatorSuturday = indicatorSuturday;
	}
	
}