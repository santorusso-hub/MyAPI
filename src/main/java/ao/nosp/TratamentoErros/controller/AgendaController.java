package ao.nosp.TratamentoErros.controller;

import ao.nosp.TratamentoErros.model.Agenda;
import ao.nosp.TratamentoErros.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgendaController {

    @Autowired
    AgendaService agendaService;

    @GetMapping(value = "/agenda/getAllContactos",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Agenda getAllContacto() {
        var result = agendaService.findAllContactos();
        return result;
    }
}
