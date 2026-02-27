package starter.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class LoginLoombokData {


    String url;
    String usuario;
    String contrasena;
    public static List<LoginLoombokData> setData(DataTable dataTable){

        List<LoginLoombokData> dates = new ArrayList<>();
        List<Map<String,String>> mapInfo = dataTable.asMaps();

        for (Map<String,String> map:mapInfo){
            dates.add(new ObjectMapper().convertValue(map, LoginLoombokData.class));
        }

        return dates;
    }

}
