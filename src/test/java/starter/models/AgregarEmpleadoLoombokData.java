package starter.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//este model es para extraer los datos del empleado del feature

@Data
public class AgregarEmpleadoLoombokData {

    String firstName;
    String middleName;
    String lastName;
    String firstNameConId;

    public static List<AgregarEmpleadoLoombokData> setData(DataTable dataTable){

        List<AgregarEmpleadoLoombokData> dates = new ArrayList<>();
        List<Map<String,String>> mapInfo = dataTable.asMaps();

        for (Map<String,String> map:mapInfo){
            dates.add(new ObjectMapper().convertValue(map, AgregarEmpleadoLoombokData.class));
        }

        return dates;
    }

}
