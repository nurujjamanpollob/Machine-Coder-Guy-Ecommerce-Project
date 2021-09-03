/*
 * Copyright (c) 2021 Nurujjaman Pollob, All Right Reserved.
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *           http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *
 */

package com.nurujjamanpollob.machinecoderguystore.commonlibrary;

import com.nurujjamanpollob.machinecoderguystore.commonlibrary.utilities.Variables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = Variables.DATABASE_TABLE_NAME_ROLES)
public class Role {


	//create constructor parameter with role name and description
	@SuppressWarnings({"UnusedDeclaration"})
	public Role(String roleName, String roleDescription){

		this.name = roleName;
		this.description = roleDescription;
	}

	//create constructor parameter with name only
	@SuppressWarnings({"UnusedDeclaration"})
	public Role(String roleName){

		this.name = roleName;
	}

	// create constructor with no parameter
	public Role(){

	}

	
	//create field of role id and generate id in database
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	//create field of role name and assign it to column with various params
	@Column(name = Variables.DATABASE_COLUMN_ROLE_KEY_NAME, length = 40, nullable = false, unique = true)
	private String name;
	
	//create field of role description assign it to column with various parameter
	@Column(name = Variables.DATABASE_COLUMN_ROLE_KEY_DESCRIPTION, length = 250, nullable = false)
	private String description;
	
	// create getter for id
	public Integer getRoleID() {
		
		return id;
	}
	
	// create setter for id
	public void setRoleID(Integer id) {
		
		this.id = id;
	}
	
	// create getter for name
	public String getRoleName() {
		
		return name;
	}
	
	// create setter for name
	public void setRoleName(String name) {
		
		this.name = name;
	}
	
	// create getter for description
	public String getRoleDescription() {
		
		return description;
	}
	
	// create setter for description
	public void setRoleDescription(String roleDescription) {
		
		this.description = roleDescription;
	}
	
	
}
