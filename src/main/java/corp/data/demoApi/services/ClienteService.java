package corp.data.demoApi.services;

import corp.data.demoApi.models.ClienteModel;
import java.util.ArrayList;

public interface ClienteService {

    public ArrayList<ClienteModel> findAll();

    public ClienteModel findOne (long cedula);

    public Boolean save(ClienteModel cliente);

    public Boolean update(ClienteModel cliente, long cedula);

    public Boolean delete(long cedula);
}
