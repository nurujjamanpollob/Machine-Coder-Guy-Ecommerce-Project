
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

import com.nurujjamanpollob.machinecoderguystore.commonlibrary.Role;
import org.springframework.data.repository.CrudRepository;


/**
 * @author Nurujjaman Pollob
 * Inherited CRUD repository class for Role entity.
 * @see CrudRepository class for more information.
 */

@org.springframework.stereotype.Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

}
