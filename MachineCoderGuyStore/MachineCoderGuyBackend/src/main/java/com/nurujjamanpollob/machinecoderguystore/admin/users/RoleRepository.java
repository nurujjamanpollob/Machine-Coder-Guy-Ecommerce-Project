
package com.nurujjamanpollob.machinecoderguystore.admin.users;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.nurujjamanpollob.machinecoderguystore.*;
import com.nurujjamanpollob.machinecoderguystore.*;
import com.nurujjamanpollob.machinecoderguystore.commonlibrary.Role;

/**
 * @author Nurujjaman Pollob
 *
 */


@Repository
public interface RoleRepository extends CrudRepository<Role, Integer>{
	
	
	

}
