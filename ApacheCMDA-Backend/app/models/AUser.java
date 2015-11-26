/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package models;

import com.google.gson.JsonObject;

import javax.persistence.*;

@Entity
public class AUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String middleInitial;
	private String affiliation;
	private String title;
	private String email;
	private String mailingAddress;
	private String phoneNumber;
	private String faxNumber;
	private String researchFields;
	private String highestDegree;
	@ManyToOne
	@JoinColumn(name = "aworkflow_id", referencedColumnName = "id")
	private AWorkflow aWorkflow;
	@ManyToOne
	@JoinColumn(name = "agroup_id", referencedColumnName = "id")
	private AGroup aGroup;


	public AUser() {
	}

	public AUser(String userName, String password, String firstName,
				 String lastName, String middleInitial, String affiliation,
				 String title, String email, String mailingAddress,
				 String phoneNumber, String faxNumber, String researchFields,
				 String highestDegree, AWorkflow aWorkflow, AGroup aGroup) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleInitial = middleInitial;
		this.affiliation = affiliation;
		this.title = title;
		this.email = email;
		this.mailingAddress = mailingAddress;
		this.phoneNumber = phoneNumber;
		this.faxNumber = faxNumber;
		this.researchFields = researchFields;
		this.highestDegree = highestDegree;
		this.aWorkflow = aWorkflow;
		this.aGroup = aGroup;
	}

	public long getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getMiddleInitial() {
		return middleInitial;
	}

	public String getAffiliation() {
		return affiliation;
	}

	public String getTitle() {
		return title;
	}

	public String getEmail() {
		return email;
	}

	public String getMailingAddress() {
		return mailingAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public String getResearchFields() {
		return researchFields;
	}

	public String getHighestDegree() {
		return highestDegree;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMailingAddress(String mailingAddress) {
		this.mailingAddress = mailingAddress;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public void setResearchFields(String researchFields) {
		this.researchFields = researchFields;
	}

	public void setHighestDegree(String highestDegree) {
		this.highestDegree = highestDegree;
	}

	public AWorkflow getaWorkflow() {
		return aWorkflow;
	}

	public void setaWorkflow(AWorkflow aWorkflow) {
		this.aWorkflow = aWorkflow;
	}

	public AGroup getaGroup() {
		return aGroup;
	}

	public void setaGroup(AGroup aGroup) {
		this.aGroup = aGroup;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password="
				+ password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", middleInitial=" + middleInitial
				+ ", affiliation=" + affiliation + ", title=" + title
				+ ", email=" + email + ", mailingAddress=" + mailingAddress
				+ ", phoneNumber=" + phoneNumber + ", faxNumber=" + faxNumber
				+ ", researchFields=" + researchFields + ", highestDegree="
				+ highestDegree + "]";
	}

	public JsonObject toJson() {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("userName", this.userName);
		jsonObject.addProperty("firstName", this.firstName);
		jsonObject.addProperty("lastName", this.lastName);
		jsonObject.addProperty("middleInitial", this.middleInitial);
		jsonObject.addProperty("affiliation", this.affiliation);
		jsonObject.addProperty("title", this.title);
		jsonObject.addProperty("email", this.email);
		jsonObject.addProperty("mailingAddress", this.mailingAddress);
		jsonObject.addProperty("phoneNumber", this.phoneNumber);
		jsonObject.addProperty("faxNumber", this.faxNumber);
		jsonObject.addProperty("researchFields", this.researchFields);
		jsonObject.addProperty("highestDegree", this.highestDegree);
		return jsonObject;
	}


}

