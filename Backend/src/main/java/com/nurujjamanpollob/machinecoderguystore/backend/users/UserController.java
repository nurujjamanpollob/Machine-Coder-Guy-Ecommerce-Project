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
import com.nurujjamanpollob.machinecoderguystore.backend.utility.FileManagementUtility;
import com.nurujjamanpollob.machinecoderguystore.backend.utility.Variables;
import com.nurujjamanpollob.machinecoderguystore.commonlibrary.Role;
import com.nurujjamanpollob.machinecoderguystore.commonlibrary.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * @author Nurujjaman Pollob
 * Controller class for User Entity
 * Exclusive for User related functions only
 * For more information, please
 * @see Controller class documentation
 */
@Controller
public class UserController {


    private final UserService userService;

    /**
     * @param userService Spring injected bean of UserService Object
     */
    public UserController(UserService userService) {

        this.userService = userService;
    }

    /**
     * Creates a new get mappings at this URL $SERVER_URL$/users
     *
     * @param uiModel Spring MVC injected UI Model
     * @return users.html file to resolve model view
     */
    @GetMapping("/users")
    public String listAllUsers(Model uiModel) {

        // get all user from service
        List<User> allUser = userService.getAllUser();
        //add attribute to UI MODEL
        uiModel.addAttribute(Variables.USER_MODEL_ATTRIBUTE_ALL_USER, allUser);
        // Return newly created site url with Model View
        return Variables.DIRECTORY_WEB_USER_LINK;
    }

    /**
     * Creates a new get mappings at this URL $SERVER_URL$/users/new
     *
     * @param model Spring MVC injected UI Model
     * @return user_form.html file to resolve model view
     */
    @GetMapping("/users/new")
    public String createNewUser(Model model) {

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


    /**
     * Method to save a User(New or Updated)
     *
     * @param user               Thymeleaf injected User Object
     * @param redirectAttributes Spring injected RedirectAttributes bean to
     *                           add new attribute after process data
     * @param userImage          Get user uploaded image file
     * @return users.html upon saving user
     * @throws IOException if the User Image is write failed on disk.
     */
    @PostMapping(Variables.POST_USERS_SAVE)
    public String saveUser(User user, RedirectAttributes redirectAttributes, @RequestParam("user-avatar-photo") MultipartFile userImage) throws IOException {

        String fileName = StringUtils.cleanPath(Objects.requireNonNull(userImage.getOriginalFilename()));
        if (userImage.isEmpty()) {
            user.setPhoto(null);
        } else {
            user.setPhoto(fileName);
        }
        User savedUser = userService.saveUser(user);
        FileManagementUtility.saveUserImage(savedUser.getId(), userImage);

        redirectAttributes.addFlashAttribute("message", "This account is successfully created!");


        return Variables.REDIRECT_USER_AFTER_SAVE;
    }


    /**
     * Method to edit an existing User
     *
     * @param id                 User Identity number to get a User Object
     * @param model              Spring Model object
     * @param redirectAttributes Spring injected RedirectAttributes bean
     *                           to add new attribute after process data
     * @return users.html upon saving user
     */
    @GetMapping(Variables.USERS_EDIT_URL)
    public String updateUser(@PathVariable(name = "id") Long id,
                             Model model,
                             RedirectAttributes redirectAttributes) {

        try {

            User user = userService.getUserById(id);
            // add user Object to the Model
            model.addAttribute("user", user);
            // Add page title for the Model
            model.addAttribute(Variables.PAGE_TITLE_USER_FORM, "Edit Existing User");
            List<Role> roleList = userService.getAllRoles();
            // Add all roles to the Model
            model.addAttribute(Variables.MODEL_ATTRIBUTE_ALL_ROLE, roleList);
            return "user_form";

        } catch (UserNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            return Variables.REDIRECT_USER_AFTER_SAVE;
        }


    }


    /**
     * Method to delete a user from database
     *
     * @param id                 Identity number to look up a user in Database and get Its object
     * @param redirectAttributes Spring injected RedirectAttributes Object
     * @return users.html upon deleting user
     */
    @GetMapping(Variables.USERS_DELETE_URL)
    public String deleteUser(@PathVariable(name = "id") Long id,
                             RedirectAttributes redirectAttributes) {

        try {

            userService.deleteUserById(id);
            // remove all user file directory
            FileManagementUtility.clearUserDirectory(id);
            redirectAttributes.addFlashAttribute("message", "The user requested for deletion is successful.");
            return "users";

        } catch (UserNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            return Variables.REDIRECT_USER_AFTER_SAVE;
        }

    }


    /**
     * Method to update a user Enabled / Disabled status
     *
     * @param id                 Identity number to look up a user in database and find a User object
     * @param status             user status to set
     * @param redirectAttributes Spring injected RedirectAttributes Object
     * @return users.html upon updating user
     */
    @GetMapping("/users/{id}/enabled/{status}")
    public String updateUserStatus(@PathVariable("id") Long id, @PathVariable("status") boolean status, RedirectAttributes redirectAttributes) {


        userService.updateUserStatus(id, status);
        redirectAttributes.addFlashAttribute("message", "The user " + id + " has been" + status);

        return Variables.REDIRECT_USER_AFTER_SAVE;
    }

}
