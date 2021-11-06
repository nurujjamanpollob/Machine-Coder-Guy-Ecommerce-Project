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

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

public class FileManagementUtility {


    /**
     * @param multipartFile get input user image file
     * @throws IOException if write failed on disk
     */
    public static void saveUserImage(Long userId, MultipartFile multipartFile) throws IOException {

        // get upload file path by UID
        Path uploadPath = Paths.get(Variables.USERS_FILE_DIRECTORY + userId + Variables.USER_AVATAR_DIRECTORY);

        // if the directory is not created, create one
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // directory exists so clean this, as we will store one photo for one user only
        else {

            cleanDirectory(uploadPath, false);

        }

        // let's resolve path by upload path, copy / replace input file
        Path filePath = uploadPath.resolve(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        Files.copy(multipartFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

    }


    /**
     * Method to clean a directory, with all file / folder
     *
     * @param dirPath                  pass directory path to clean
     * @param isClearAllFilesAndFolder if true it will clean all files and folder including user directory
     *                                 Else, it will delete the files only under user directory.
     */

    private static void cleanDirectory(Path dirPath, boolean isClearAllFilesAndFolder) {

        // remove user directory
        if (isClearAllFilesAndFolder) {

            try {
                // delete user directory
                FileUtils.deleteDirectory(dirPath.toFile());
            } catch (IOException e) {
                System.out.println("Unable to delete user folder: "
                        + dirPath.toFile().getAbsolutePath()
                        + " because " + e);
            }

        }

        // remove user all files, no directory
        else {

            removeFilesOnly(dirPath);

        }

    }


    /**
     * Method to delete a user directory, when a user account is removed from the server.
     *
     * @param userId to get user id, so by this id we resolve the specific user directory
     *               For standard IO operations in Java, Please
     * @see Files class for more information
     */
    public static void clearUserDirectory(Long userId) {


        // get upload file path
        Path uploadPath = Paths.get(Variables.USERS_FILE_DIRECTORY + userId);

        // remove this directory
        cleanDirectory(uploadPath, true);

    }

    /**
     * @param dirPath path to list all files and folder under this directory
     *                Removes file only!
     */

    private static void removeFilesOnly(Path dirPath) {

        // list all files and folder under this directory
        try {
            Files.list(dirPath).forEach(path -> {

                // clean all files only
                if (!Files.isDirectory(path)) {
                    try {
                        Files.delete(path);
                    } catch (IOException e) {
                        System.out.println("Error removing this " + path.toFile().getAbsolutePath() + " file because " + e.getMessage());
                    }
                }

            });
        } catch (IOException e) {
            System.out.println("Error Listing DIR: " + e.getMessage());
        }

    }


}
