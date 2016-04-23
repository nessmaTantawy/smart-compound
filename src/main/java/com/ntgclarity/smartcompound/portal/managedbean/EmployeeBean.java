package com.ntgclarity.smartcompound.portal.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.ntgclarity.smartcompound.business.management.SmartCompoundManagment;
import com.ntgclarity.smartcompound.common.entity.Employee;
import com.ntgclarity.smartcompound.portal.base.BaseBean;

@ManagedBean
@ViewScoped
public class EmployeeBean extends BaseBean implements Serializable {

	@ManagedProperty(value = "#{smartCompoundManagmentImpl}")
	private SmartCompoundManagment smartCompoundManagment;

	private Employee selectedEmployee;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Employee> allEmployees;

	@PostConstruct
	public void init() {
		loadAllEmployees();
		initiateNewEmployee();
	}

	private void initiateNewEmployee() {
		selectedEmployee = new Employee();
		
	}
/**
 *methodCreater:nessma 
 *create Employee 
 *this metohd will call smartCompoundManagment.insertEmployee
 
  **/
 
	public void createEmployee() {
			
		
			smartCompoundManagment.insertEmployee(selectedEmployee);
			addInfoMessage("Employee has been created successfully");
		
	}

	public void loadAllEmployees() {
		allEmployees = smartCompoundManagment.getAllEmployees();
	}

	public void testMethod() {

		loadAllEmployees();
	}

	public void printEmployee() {
		System.out.println(selectedEmployee);
	}

	public List<Employee> getAllEmployees() {
		return allEmployees;
	}

	public void setAllEmployees(List<Employee> allEmployees) {
		this.allEmployees = allEmployees;
	}

	public SmartCompoundManagment getSmartCompoundManagment() {
		return smartCompoundManagment;
	}

	public void setSmartCompoundManagment(
			SmartCompoundManagment smartCompoundManagment) {
		this.smartCompoundManagment = smartCompoundManagment;
	}

	public Employee getSelectedEmployee() {
		return selectedEmployee;
	}

	public void setSelectedEmployee(Employee selectedEmployee) {
		this.selectedEmployee = selectedEmployee;
	}

	

}
