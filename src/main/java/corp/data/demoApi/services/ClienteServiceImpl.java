package corp.data.demoApi.services;

import corp.data.demoApi.models.ClienteModel;
import corp.data.demoApi.repositories.ClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ClienteServiceImpl implements ClienteService{

    private final Logger log = LoggerFactory.getLogger(ClienteServiceImpl.class);

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public ArrayList<ClienteModel> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public ClienteModel findOne(long cedula) {
        return clienteRepository.findOne(cedula);
    }

    @Override
    public Boolean save(ClienteModel cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Boolean update(ClienteModel cliente, long cedula) {
        return clienteRepository.update(cliente, cedula);
    }

    @Override
    public Boolean delete(long cedula) {
        return clienteRepository.delete(cedula);
    }
}
