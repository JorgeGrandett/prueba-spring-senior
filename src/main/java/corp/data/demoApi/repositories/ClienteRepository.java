package corp.data.demoApi.repositories;

import corp.data.demoApi.models.ClienteModel;
import java.util.ArrayList;

public interface ClienteRepository {

    public ArrayList<ClienteModel> findAll ();
    public ClienteModel findOne (long cedula);
    public Boolean save (ClienteModel cliente);
    public Boolean update (ClienteModel cliente, long cedula);
    public Boolean delete (long cedula);
}
