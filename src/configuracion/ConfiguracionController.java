/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configuracion;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Whoami
 */
public class ConfiguracionController implements Initializable {

    static ArrayList<Dispostivos> dispostivos = new ArrayList();
    @FXML
    TextArea historialConfig;
    @FXML
    TextField txt_modeloDipostipo;
    @FXML
    TextField txt_TipoDeipositivo;
    @FXML
    TextField txt_ipDispositivo;
    @FXML
    TextField txt_configDipositivo;
    @FXML
    TextField txt_ID_Dipositivo;
    @FXML
    Button btnAgreagr;

    int contador = 0;
    String datos = "";

    @FXML
    public void btnAgregar() {

        agregarConfiguracion();
        mostrarDipositivos();
        LimpiarTextField();
        contador++;

    }

    public void LimpiarTextField() {

        txt_TipoDeipositivo.setText(" ");
        txt_configDipositivo.setText(" ");
        txt_modeloDipostipo.setText(" ");
        txt_ipDispositivo.setText(" ");

    }

    @FXML
    public void BuscarDipos() {

        if (!dispostivos.isEmpty()) {
            datos = dispostivos.get(Integer.parseInt(txt_ID_Dipositivo.getText()) - 1).toString();
            historialConfig.setText(datos);

        } else {
            System.out.println("Lista vacia..!" + dispostivos.size());
        }
        txt_ID_Dipositivo.setText(" ");
    }

    public void BorrarDipos() {

        if (!dispostivos.isEmpty()) {
            dispostivos.remove(Integer.parseInt(txt_ID_Dipositivo.getText()) - 1);
            historialConfig.clear();
            mostrarDipositivos();

        } else {
            System.out.println("Lista vacia..!" + dispostivos.size());
        }
        txt_ID_Dipositivo.setText(" ");
    }

    public void agregarConfiguracion() {

        String ID_Dispositivo;
        String ip_Dispositivo;
        String configuracion;
        String modeloDipositivo;
        String tipoDispositivo;

        //Variable auxiliar que contendrá la referencia a cada dipositivo nuevo.
        Dispostivos aux;

        ID_Dispositivo = String.valueOf(contador + 1);
        ip_Dispositivo = txt_ipDispositivo.getText();
        configuracion = txt_configDipositivo.getText();
        modeloDipositivo = txt_modeloDipostipo.getText();
        tipoDispositivo = txt_TipoDeipositivo.getText();

        aux = new Dispostivos();

        //se asignan valores a los atributos del nuevo objeto
        aux.setID_Dipositivo(ID_Dispositivo);
        aux.setIp_Dispositivo(ip_Dispositivo);
        aux.setConfiguracion(configuracion);
        aux.setModeloDipositivo(modeloDipositivo);
        aux.setTipoDispositivo(tipoDispositivo);

        //se añade el objeto al final del array
        dispostivos.add(aux);

    }//fin método 

    public void mostrarDipositivos() {

        for (int i = contador; i < dispostivos.size(); i++) {
            //System.out.println(dispostivos.get(i));  //se invoca el método toString de la clase Dipos
            //datos += "\n Dipositivo ID: " + String.valueOf(contador + 1);
            datos += dispostivos.get(i).toString();
            datos += "\n -----------------------------------------------------------------------------------------";
        }

        historialConfig.setText(datos);
    }//fin de metodo

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void btn_back(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent raiz = FXMLLoader.load(getClass().getResource("/main/homepage.fxml"));
        Scene escena = new Scene(raiz);
        primaryStage.setScene(escena);
        primaryStage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

}
