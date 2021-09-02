
package com.nurujjamanpollob.machinecoderguystore.backend.users;

import com.nurujjamanpollob.machinecoderguystore.commonlibrary.Role;
import org.springframework.data.repository.CrudRepository;


/**
 * @author Nurujjaman Pollob
 *
 */


@org.springframework.stereotype.Repository
public interface RoleRepository extends CrudRepository<Role, Integer>{

}
