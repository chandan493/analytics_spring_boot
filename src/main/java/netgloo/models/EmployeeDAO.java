package netgloo.models;

import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.custom.model.CustomStatistics;

/**
 * A DAO for the entity User is simply created by extending the CrudRepository
 * interface provided by spring. The following methods are some of the ones
 * available from such interface: save, delete, deleteAll, findOne and findAll.
 * The magic is that such methods must not be implemented, and moreover it is
 * possible create new query methods working only by defining their signature!
 * 
 * @author chandan
 */
@Transactional
public interface EmployeeDAO extends CrudRepository<Employee, Long> {

  /**
   * Return the user having the passed email or null if no user is found.
   * 
   * @param email the user email.
   */
  public Employee findByEmail(String email);
  @Query(value = "select city as recordkey,count(city) from Employee group by city")
  public List<CustomStatistics> statByCity(); 

} // class UserDao
