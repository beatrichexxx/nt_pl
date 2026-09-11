import com.fasterxml.jackson.databind.node.*;
import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.File; // подключаем класс для работы с файлами
import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;

class Test{
    public int id;
    public String title;
    @JsonIgnoreProperties(ignoreUnknown = true)
    public String value;
    @JsonIgnoreProperties(ignoreUnknown = true)
    public ArrayList<Test> values = new ArrayList<>();
}

class Tests{
    public ArrayList<Test> tests = new ArrayList<>();
    public Tests(ArrayList<Test> tests)
    {
        this.tests = tests;
    }
    public Tests()
    {
    }
}

class Value{
    public int id;
    public String value;
}
class Values{
    public ArrayList<Value> values = new ArrayList<>();
}


public class task3 {

    public static void fillTests(Tests tests, Values values)
    {
        for (Test t : tests.tests)
        {
            for (Value v : values.values)
            {
                if (v.id == t.id) t.value = v.value;
            };
            if (t.values != null && t.values.size()>0) //если есть вложенность тестов
            {
               // for (Test tt : t.values) fillTests(tt, values);
                fillTests(new Tests(t.values), values);
            }
        }
    }
    public static void main(String[] args) {
      //  String valuesFilePath = args[0]; //путь к файлу values
       // String testsFilePath = args[1];  //путь к файлу tests
     //   String reportFilePath = args[2];  //путь к файлу report
        String valuesFilePath = "task3/values.json"; //путь к файлу values
        String testsFilePath ="task3/tests.json";  //путь к файлу tests
        String reportFilePath ="task3/report.json";  //путь к файлу tests

       Tests tests = new Tests();
       ObjectMapper om = new ObjectMapper();
        try {
            tests = om.readValue(new File(testsFilePath), tests.getClass());
            System.out.println();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Values values = new Values();
        try {
            values = om.readValue(new File(valuesFilePath), values.getClass());
            System.out.println();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        fillTests(tests, values);

        try {
            om.writeValue(new File(reportFilePath), tests);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
    }
}