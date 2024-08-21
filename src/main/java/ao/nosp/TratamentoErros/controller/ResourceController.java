package ao.nosp.TratamentoErros.controller;

import ao.nosp.TratamentoErros.Exception.ResourceBadRequestException;
import ao.nosp.TratamentoErros.Exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

    @GetMapping("/resource/{id}")
    public String getResource(@PathVariable String id) {
        if (id.equals("0")) {
            throw new ResourceNotFoundException("Resource not found with id: " + id);
        }
        return "Resource " + id;
    }

    @GetMapping("/calculate/{number}")
    public String calculateSquare(@PathVariable String number) {
        try {
            int num = Integer.parseInt(number);
            return "Square of " + num + " is " + (num * num);
        } catch (NumberFormatException ex) {
            throw new ResourceBadRequestException("dsdds");
        }
    }



}
