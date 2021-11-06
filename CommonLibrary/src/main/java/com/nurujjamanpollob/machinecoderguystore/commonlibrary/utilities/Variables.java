/*
 * Copyright (c) 2021-2021 Nurujjaman Pollob, All Right Reserved.
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

package com.nurujjamanpollob.machinecoderguystore.commonlibrary.utilities;

public class Variables {


    //Start include table and column key for @User class and reference to other place
    public static final String DATABASE_TABLE_NAME_USER_ROLES = "user_roles";
    public static final String DATABASE_TABLE_NAME_USER_ROLES_COLUMN_ID = "user_id";
    public static final String DATABASE_TABLE_NAME_USER_ROLES_COLUMN_INVERSE = "role_id";
    public static final String DATABASE_TABLE_NAME_USERS = "users";
    public static final String DATABASE_COLUMN_USERS_EMAIL_ADDRESS = "email";
    public static final String DATABASE_COLUMN_USERS_PASSWORD = "password";
    public static final String DATABASE_COLUMN_USERS_FIRST_NAME = "firstname";
    public static final String DATABASE_COLUMN_USERS_LAST_NAME = "lastname";
    public static final String DATABASE_COLUMN_USERS_PHOTO = "photo";
    public static final Boolean DATABASE_COLUMN_USERS_Status = true;


    //Start include table and column key for @Role class and reference to other place
    public static final String DATABASE_TABLE_NAME_ROLES = "roles";
    public static final String DATABASE_COLUMN_ROLE_TYPE_ADMIN = "admin";
    public static final String DATABASE_COLUMN_ROLE_KEY_NAME = "name";
    public static final String DATABASE_COLUMN_ROLE_TYPE_SALES_PERSON = "salesperson";
    public static final String DATABASE_COLUMN_ROLE_TYPE_EDITOR = "editor";
    public static final String DATABASE_COLUMN_ROLE_TYPE_SHIPPER = "shipper";
    public static final String DATABASE_COLUMN_ROLE_TYPE_ASSISTANT = "assistant";
    public static final String DATABASE_COLUMN_ROLE_KEY_DESCRIPTION = "description";


    // Here we are adding some variable for indicate entity point for our application
    public static final String COMMON_LIBRARY_ENTRY_POINT = "com.nurujjamanpollob.machinecoderguystore.commonlibrary";
    public static final String BASE_PACKAGE_NAME = "com.nurujjamanpollob.machinecoderguystore.*";


    // Here we are storing application context path
    public static final String APPLICATION_CONTEXT_PATH = "/MachineCoderGuyAdmin/";


}
