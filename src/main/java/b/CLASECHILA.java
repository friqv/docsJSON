package b;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class CLASECHILA {

    public static void AYPAPA() { //METODO
        //FRAME
        JFrame framesito = new JFrame("VENTANA");
        framesito.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //CREACION DEL GSON (OBJETC) para manerjar los JSON
        Gson gson = new Gson();

       //LISTA DE OBJETOS TOKEN
        Type tipoLista = new TypeToken<List<Persona>>(){}.getType();

        try {
            //LEER EL JSON
            //MANDARLO A LA LISTA
            List<Persona> listaPersonas = gson.fromJson(new FileReader("src/main/java/b/car_sales.json"), tipoLista);


             //AQUI ALMACENAMOS LOS DATOS DEL JSON
            Object[][] data = new Object[listaPersonas.size()][6];
            String[] columnNames = {"ID", "Nombre", "Apellido", "Coche", "Precio", "Estado"};


            //MATRIZ PAPA, de los DATOS QUE CONTIENE EL JSON, ID, NOMBRE, APELLIDO, COCHE, PRECIO, ESTADO
            for (int i = 0; i < listaPersonas.size(); i++) {
                Persona persona = listaPersonas.get(i);
                data[i][0] = persona.getId();
                data[i][1] = persona.getFirst_name();
                data[i][2] = persona.getLast_name();
                data[i][3] = persona.getCar();
                data[i][4] = persona.getPrice();
                data[i][5] = persona.getState();
            }

           //TRABAJAR CON EL JTABLE (objeto)
            JTable table = new JTable(data, columnNames);
            JScrollPane scrollPane = new JScrollPane(table); //SCROLL PARA DESPLAZAR EL JTABLE

            //FRAMESITO
            framesito.add(scrollPane); //agrego el scroll al frame
            framesito.pack(); //Tamaño
            framesito.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
