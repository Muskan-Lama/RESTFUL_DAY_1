package com.TTN.spring.quetion2to9;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class EmployeeResource {


    @Autowired
    private EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService)
    {

        this.employeeService = employeeService;
    }


    //getting all the Employee
    //mapping to specific url using GET
    @GetMapping("/users")
    public List<Employee> getAll()
    {

        return employeeService.findAll();
    }



    //getting Pathvariable
    //Implement GET
    // http request using path variable top get one employee
    @GetMapping("/users/{id}")
    public Employee findOne(@PathVariable int id)
    {


        Employee employee= employeeService.findOne(id);
           //handling exception by using custom exception class and displaying message
        if(employee==null)
            throw new IdNotFoundException("id : "+ id);
        //it will return the employee details which matches the specific id
        return employee;
    }



    //DELETE
    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable int id)
    {


        //deleting
       employeeService.delete(id);

    }


  /*
    //post
    //Implement POST http request for Employee to create a new employee.
    @PostMapping("/users")
    //send web request with body along with it
    //in body it will have all request and that will be mapped to Employee bean
    public void createEmployee(@RequestBody Employee employee)
    {
          employeeService.save(employee);
    }

   */

    //updating id
    //put mapping
    @PutMapping(path = "/users/{id}")
    public void updateEmployee(@RequestBody Employee employee, @PathVariable Integer id)
    {
        employeeService.updateById(id, employee);
    }

     //Apply validation while
    // create a new employee using POST http Request.
     // create user
     @PostMapping("/users")
     public ResponseEntity<Employee> createUser(@Valid @RequestBody Employee employee)
     {
         Employee save=employeeService.save(employee);

         URI location= ServletUriComponentsBuilder.fromCurrentRequest()
                 .path("/{id}")
                 .buildAndExpand(save.getId())
                 .toUri();

         return ResponseEntity.created(location).build();
     }





}
