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

public class Variables {

    // Store variable of User html page
    public static final String DIRECTORY_WEB_USER_LINK = "users";

    public static final String DIRECTORY_WEB_NEW_USER_LINK = "user_form";

    //Store key for get all user for Model Attribute
    public static final String USER_MODEL_ATTRIBUTE_ALL_USER = "alluser";

    //Store key for get all role for Model Attribute
    public static final String MODEL_ATTRIBUTE_ALL_ROLE = "allrole";

    //Store key for user for Model Attribute
    public static final String USER_MODEL_ATTRIBUTE_USER = "user";

    // Store URL for post mapping users/save
    public static final String POST_USERS_SAVE = "/users/save";

    // Store email for post mapping users/check_email
    public static final String POST_USERS_CHECK_EMAIL = "/users/check_email";

    // Store URL for redirect user after save
    public static final String REDIRECT_USER_AFTER_SAVE = "redirect:/users";

    // Here we are adding some variable for indicate entity point for our application
    public static final String BACKEND_LIBRARY_ENTRY_POINT_USER = "com.nurujjamanpollob.machinecoderguystore.backend.users";
}
