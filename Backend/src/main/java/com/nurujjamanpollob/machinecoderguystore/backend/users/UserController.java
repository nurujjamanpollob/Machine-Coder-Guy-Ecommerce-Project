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

package com.nurujjamanpollob.machinecoderguystore.backend.users;


import com.nurujjamanpollob.machinecoderguystore.backend.exception.UserNotFoundException;
import com.nurujjamanpollob.machinecoderguystore.backend.utility.Variables;
import com.nurujjamanpollob.machinecoderguystore.commonlibrary.Role;
import com.nurujjamanpollob.machinecoderguystore.commonlibrary.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 *
 * @author Nurujjaman Pollob
 */
@Controller
public class UserController {


    /** Spring Dependency with method level Injection
     * @serialField userService
     */
    @Autowired
    private UserService userService;


    // create a map in webserver with given URL
    @GetMapping("/users")
    public String listAllUsers(Model uiModel) {

        // get all user from service
        List<User> allUser = userService.getAllUser();

        //add attribute to UI MODEL
        //So thymeleaf can get data from key
        uiModel.addAttribute(Variables.USER_MODEL_ATTRIBUTE_ALL_USER, allUser);

        // Return newly created site url
        return Variables.DIRECTORY_WEB_USER_LINK;
    }

    @GetMapping("/users/new")
    public String createNewUser(Model model){

        // Create new user object for MVC UI controller
        User user = new User();
        model.addAttribute(Variables.USER_MODEL_ATTRIBUTE_USER, user);

        // create new List of Role object for MVC UI controller
        List<Role> roleList = userService.getAllRoles();
        model.addAttribute(Variables.MODEL_ATTRIBUTE_ALL_ROLE, roleList);

        // pass page title as model attribute
        model.addAttribute(Variables.PAGE_TITLE_USER_FORM, "Create new user");


        return Variables.DIRECTORY_WEB_NEW_USER_LINK;
    }


    @PostMapping(Variables.POST_USERS_SAVE)
    public String saveNewUser(User user, RedirectAttributes redirectAttributes){

        userService.saveUser(user);

        redirectAttributes.addFlashAttribute("message", "This account is successfully created!");


        return Variables.REDIRECT_USER_AFTER_SAVE;
    }


    @GetMapping(Variables.USERS_EDIT_URL)
    public String updateUser(@PathVariable(name = "id") Integer id,
                             Model model,
                             RedirectAttributes redirectAttributes){

        try{

            User user = userService.getUserById(Long.valueOf(id));
            model.addAttribute("user", user);
            model.addAttribute(Variables.PAGE_TITLE_USER_FORM, "Edit Existing User");
            List<Role> roleList = userService.getAllRoles();
            model.addAttribute(Variables.MODEL_ATTRIBUTE_ALL_ROLE, roleList);
            return "user_form";

        } catch (UserNotFoundException e) {
           redirectAttributes.addFlashAttribute("message", e.getMessage());
            return Variables.REDIRECT_USER_AFTER_SAVE;
        }



    }


}
