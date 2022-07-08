package corp.data.demoApi.controllers;

import corp.data.demoApi.models.ClienteModel;
import corp.data.demoApi.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/demo")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/viewClientes")
    public ArrayList<ClienteModel> getClientes () {
        return clienteService.findAll();
    }

    @GetMapping(value = "/viewCliente", params = "cedula")
    public ClienteModel getCliente (@RequestParam Long cedula) {
        return clienteService.findOne(cedula);
    }

    @PostMapping("/addCliente")
    public Boolean createCliente (@RequestBody ClienteModel cliente) {
        return clienteService.save(cliente);
    }

    @PutMapping(value = "/updateCliente", params = "cedula")
    public boolean updateCliente (@RequestBody ClienteModel cliente, @RequestParam long cedula) {
        return clienteService.update(cliente, cedula);
    }

    @DeleteMapping(value = "/deleteCliente", params = "cedula")
    public boolean deleteCliente (@RequestParam long cedula) {
        return clienteService.delete(cedula);
    }

}
