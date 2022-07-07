package corp.data.demoApi.repositories;

import corp.data.demoApi.DemoApiApplication;
import corp.data.demoApi.models.ClienteModel;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {

    @Override
    public ArrayList<ClienteModel> findAll() {
        try {
            return DemoApiApplication.btree.search(1, 9999999999L);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ClienteModel findOne(long cedula) {
        try {

            return DemoApiApplication.btree.search(cedula);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean save(ClienteModel cliente) {
        try {
            ClienteModel aux = findOne(cliente.getCedula());
            if(aux != null) {
                return false;
            }
            DemoApiApplication.btree.insert(cliente.getCedula(), cliente);

            completeFileWrite();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean update(ClienteModel cliente, long cedula) {
        try {
            ClienteModel aux = findOne(cedula);
            if(aux == null) {
                return false;
            }
            aux.setNombre((cliente.getNombre() != null) ? cliente.getNombre() : aux.getNombre());
            aux.setApellidos((cliente.getApellidos() != null) ? cliente.getApellidos() : aux.getApellidos());
            aux.setCedula((cliente.getCedula() != 0) ? cliente.getCedula() : aux.getCedula());
            aux.setDireccion((cliente.getDireccion() != null) ? cliente.getDireccion() : aux.getDireccion());
            aux.setEdad((cliente.getEdad() != 0) ? cliente.getEdad() : aux.getEdad());

            DemoApiApplication.btree.delete(cedula);

            DemoApiApplication.btree.insert(aux.getCedula(), aux);

            completeFileWrite();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean delete(long cedula) {
        try {
            ClienteModel aux = findOne(cedula);
            if(aux == null) {
                return false;
            }

            DemoApiApplication.btree.delete(cedula);

            completeFileWrite();

            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean completeFileRead () {
        File file;
        FileReader fr = null;
        BufferedReader br = null;
        ClienteModel auxModel;
        StringTokenizer st;

        try {
            file = new File ("clientes.txt");
            file.createNewFile();
            fr = new FileReader (file);
            br = new BufferedReader(fr);

            String line;
            while((line = br.readLine()) != null) {

                st = new StringTokenizer(line, "*");

                auxModel = new ClienteModel();
                auxModel.setNombre(st.nextToken());
                auxModel.setApellidos(st.nextToken());
                auxModel.setCedula(Long.parseLong(st.nextToken()));
                auxModel.setDireccion(st.nextToken());
                auxModel.setEdad(Integer.parseInt(st.nextToken()));

                DemoApiApplication.btree.insert(auxModel.getCedula(), auxModel);
            }
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            try{
                if(fr != null){
                    fr.close();
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return true;
    }

    public boolean completeFileWrite () {
        FileWriter file = null;
        PrintWriter pw;
        ArrayList<ClienteModel> datos;

        try {
            file = new FileWriter("clientes.txt");
            pw = new PrintWriter(file);
            datos = findAll();

            String linea;

            for (ClienteModel dato : datos) {
                linea = dato.toString();
                pw.println(linea);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (file != null) {
                    file.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return true;
    }
}
