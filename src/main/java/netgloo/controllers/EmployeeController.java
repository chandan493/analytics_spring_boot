package netgloo.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import netgloo.models.Employee;
import netgloo.models.EmployeeDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.custom.model.CustomStatistics;
import com.custom.util.EmployeeUtil;

/**
 * A class to test interactions with the MySQL database using the UserDao class.
 *
 * @author netgloo
 */
@RestController
public class EmployeeController {
	@Autowired
	EmployeeDAO empDao;

	@RequestMapping("/get-all-employee")
	public @ResponseBody List<Employee> getAllEmployeeList() {
		List<Employee> list = new ArrayList<>();
		Iterator<Employee> employeeIterator = empDao.findAll().iterator();
		employeeIterator.forEachRemaining(list::add);
		return list;
	}

	@RequestMapping("/present-by-city")
	public @ResponseBody Map<String,Long> presentByCity() {
		return EmployeeUtil.percentageCalculator(empDao.statByCity());
	}

}