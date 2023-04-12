package online.pythonbot.springsecurity.controller;


import online.pythonbot.springsecurity.DTO.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {

    @PostMapping(path = "/save")
    public String saveEmployee(@RequestBody EmployeeDTO employeeDTO){
            String id= employeeserviec.addEmpoyee(employeeDTO);
            return id;
    }

}
