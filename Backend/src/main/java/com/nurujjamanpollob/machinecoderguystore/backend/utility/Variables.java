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

package com.nurujjamanpollob.machinecoderguystore.backend.utility;


/**
 * @author Nurujjaman Pollob
 * <p>
 * This class is designed to store useful variable collections to use in other classes.
 */
public class Variables {

    /**
     * Variable of User html page for MVC controller view
     */
    public static final String DIRECTORY_WEB_USER_LINK = "users";

    /**
     * Variable of new User form html page for MVC controller view
     */
    public static final String DIRECTORY_WEB_NEW_USER_LINK = "user_form";


    /**
     * Variable Key for get all user for Model Attribute
     */
    public static final String USER_MODEL_ATTRIBUTE_ALL_USER = "alluser";

    /**
     * Variable key for get all role for Model Attribute
     */
    public static final String MODEL_ATTRIBUTE_ALL_ROLE = "allrole";

    /**
     * Variable key for User Model Attribute
     */
    public static final String USER_MODEL_ATTRIBUTE_USER = "user";

    /**
     * Variable for post mapping users/save
     */
    public static final String POST_USERS_SAVE = "/users/save";

    /**
     * Variable  for put mapping users/edit
     */
    public static final String USERS_EDIT_URL = "/users/edit/{id}";

    /**
     * Variable for delete mapping users/delete
     */
    public static final String USERS_DELETE_URL = "/users/delete/{id}";

    /**
     * Variable for get mapping users/check_email
     */
    public static final String GET_USERS_CHECK_EMAIL = "/users/check_email";

    /**
     * Variable to store redirect URL to users mapping
     */
    public static final String REDIRECT_USER_AFTER_SAVE = "redirect:/users";


    /**
     * Variable to STORE GET response email not duplicated
     */
    public static String USER_EMAIL_NOT_DUPLICATED = "OK";


    /**
     * Variable to STORE GET response email duplicated
     */
    public static String USER_EMAIL_DUPLICATED = "DUPLICATED";


    /**
     * Variable to Store User form page title
     */
    public static String PAGE_TITLE_USER_FORM = "pageTitle";


    /**
     * Variable to store entity point of Machine Coder Guy Web application
     */
    public static final String BACKEND_LIBRARY_ENTRY_POINT_USER = "com.nurujjamanpollob.machinecoderguystore.backend.users";


    /**
     * Variable to store User uploaded files directory name
     */
    public static final String USERS_FILE_DIRECTORY = "user-files/";

    /**
     * Variable to store User uploaded avatar directory name
     */
    public static final String USER_AVATAR_DIRECTORY = "/avatar/";

}
