package c;

import org.json.JSONObject;
import org.json.XML;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class XMLaJSON {
    public static void main(String[] args) {
        String xmlFilePath = "car_sales.xml";
        String jsonFilePath = "car_sales2.json";

        try {

            String xmlContent = new String(Files.readAllBytes(Paths.get(xmlFilePath)));
            JSONObject jsonObject = XML.toJSONObject(xmlContent);
            Files.write(Paths.get(jsonFilePath), jsonObject.toString(4).getBytes());

            System.out.println("Se ha convertido el XML a JSON");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

