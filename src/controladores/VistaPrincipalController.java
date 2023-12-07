/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

import com.sun.rowset.internal.Row;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.paint.Color;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.util.Callback;
import javax.swing.DefaultRowSorter;
import modelos.Compra;
import modelos.Vehiculo;
import modelos.listas.ListaClientes;
import modelos.listas.ListaVehiculos;
import modelos.pilas.Pilas;
import utiliades.ManejoDatos;
import utiliades.Utilidades;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class VistaPrincipalController implements Initializable, Utilidades {

    private ListaVehiculos listaV = ManejoDatos.getDatos().getListaVehiculos();
    private ListaClientes listaC = ManejoDatos.getDatos().getListaClientes();
    private Pilas pilas = ManejoDatos.getDatos().getPilas();

    private HashMap<Pane, Image> paneImageMap;
    @FXML
    private Label btnInicio;
    @FXML
    private Label txtNombreCliente;
    @FXML
    private Pane panelA1;
    @FXML
    private Label txtMarca1;
    @FXML
    private Label txtModelo1;
    @FXML
    private Label txtMarca;
    @FXML
    private Label txtModelo;
    @FXML
    private TextField txtPrecioA;
    @FXML
    private Pane panelA2;

    @FXML
    private TextField txtPrecioA1;
    @FXML
    private Pane panelA3;
    @FXML
    private Label txtMarca2;
    @FXML
    private Label txtModelo2;
    @FXML
    private TextField txtPrecioA2;
    @FXML
    private Pane panelA4;

    @FXML
    private TextField txtPrecioA3;
    @FXML
    private GridPane vistaInicio;
    @FXML
    private Pane panelDescripcion;
    @FXML
    private Label txtMarcaGeneral;
    @FXML
    private Label txtModeloGneral;
    @FXML
    private Label txtColorGeneral;
    @FXML
    private Label txtStockGeneral;
    @FXML
    private TextField txtPrecioGenral;
    @FXML
    private Spinner<Integer> spinnerCantidadGenral;
    @FXML
    private Button btnAddCarrito;
    @FXML
    private ImageView btnAddDeseos;
    @FXML
    private Label btnCarrito;
    @FXML
    private Label btnDeseos;
    @FXML
    private Label btnCompras;
    @FXML
    private Label btnSalir;
    @FXML
    private Pane VistaCarrito;
    @FXML
    private Button btnAddCarrito1;
    @FXML
    private Button btnAddCarrito11;
    @FXML
    private Button btnAddCarrito12;
    @FXML
    private Pane vistaDeseos;
    @FXML
    private Button btnAddCarrito111;
    @FXML
    private Button btnAddCarrito121;
    @FXML
    private Pane vistaCompras;
    @FXML
    private Pane PanelHistorial;
    @FXML
    private Label txtMarca3;
    @FXML
    private Label txtModelo3;
    @FXML
    private Pane contenImg;
    @FXML
    private Label txtIdC;
    @FXML
    private Label txtIdC1;
    @FXML
    private Label txtIdC2;
    @FXML
    private Label txtIdC3;
    @FXML
    private Label txtIdGeneral;
    @FXML
    private TableView<Compra> tablaCarrito;
    @FXML
    private TableColumn<Compra, String> colC1;
    @FXML
    private TableColumn<Compra, Integer> colC2;
    @FXML
    private TableColumn<Compra, String> colC3;
    @FXML
    private TableColumn<Compra, Integer> colC4;
    @FXML
    private TableColumn<Compra, Double> colC5;
    @FXML
    private TableColumn<Compra, Double> colC6;
    private Button compra;
    @FXML
    private TableColumn<Compra, String> colBtn;
    @FXML
    private TableView<Compra> tablaCompras;
    @FXML
    private TableColumn<Compra, String> colCopra;
    @FXML
    private TableColumn<Compra, Integer> colCopra2;
    @FXML
    private TableColumn<Compra, String> colCopra3;
    @FXML
    private TableColumn<Compra, Integer> colCopra4;
    @FXML
    private TableColumn<Compra, Double> colCopra5;
    @FXML
    private TableColumn<Compra, Double> colCopra6;
    @FXML
    private TableColumn<Compra, LocalDate> colCopra7;
    @FXML
    private Label txtTotal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        colC1.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colC1.setStyle("-fx-alignment: CENTER");
        colC2.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        colC2.setStyle("-fx-alignment: CENTER");
        colC3.setCellValueFactory(new PropertyValueFactory<>("color"));
        colC3.setStyle("-fx-alignment: CENTER");
        colC4.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        colC4.setStyle("-fx-alignment: CENTER");
        colC5.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colC5.setStyle("-fx-alignment: CENTER");
        colC6.setCellValueFactory(new PropertyValueFactory<>("subTotal"));
        colC6.setStyle("-fx-alignment: CENTER");
        colBtn.setStyle("-fx-alignment: CENTER");
        colCopra.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colCopra.setStyle("-fx-alignment: CENTER");
        colCopra2.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        colCopra2.setStyle("-fx-alignment: CENTER");
        colCopra3.setCellValueFactory(new PropertyValueFactory<>("color"));
        colCopra3.setStyle("-fx-alignment: CENTER");
        colCopra4.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        colCopra4.setStyle("-fx-alignment: CENTER");
        colCopra5.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colCopra5.setStyle("-fx-alignment: CENTER");
        colCopra6.setCellValueFactory(new PropertyValueFactory<>("subTotal"));
        colCopra6.setStyle("-fx-alignment: CENTER");
        colCopra7.setCellValueFactory(new PropertyValueFactory<>("fechaS"));
        colCopra7.setStyle("-fx-alignment: CENTER");
        actualizarTabla();
        actualizarTabla2();
        if (listaV.getCab() == null) {
            listaV.cargarDatosVehiculo();
        }
        Vehiculo aux = listaV.getBuscarId(1);
        Vehiculo aux2 = listaV.getBuscarId(2);
        Vehiculo aux3 = listaV.getBuscarId(3);
        Vehiculo aux4 = listaV.getBuscarId(4);

        double numero = aux.getPrecio();
        double numero2 = aux2.getPrecio();
        double numero3 = aux3.getPrecio();
        double numero4 = aux4.getPrecio();

        DecimalFormat formato = new DecimalFormat("#.00");
        String numeroFormateado;
        txtMarca.setText(aux.getMarca());
        txtModelo.setText("Modelo: " + aux.getModelo());
        txtPrecioA.setText(numeroFormateado = formato.format(numero));
        txtIdC.setText("" + aux.getCodigo());

        txtMarca1.setText(aux2.getMarca());
        txtModelo1.setText("Modelo: " + aux2.getModelo());
        txtPrecioA1.setText(numeroFormateado = formato.format(numero2));
        txtIdC1.setText("" + aux2.getCodigo());

        txtMarca2.setText(aux3.getMarca());
        txtModelo2.setText("Modelo" + aux3.getModelo());
        txtPrecioA2.setText(numeroFormateado = formato.format(numero3));
        txtIdC2.setText("" + aux3.getCodigo());

        txtMarca3.setText(aux4.getMarca());
        txtModelo3.setText(" Modelo" + aux4.getModelo());
        txtPrecioA3.setText(numeroFormateado = formato.format(numero4));
        txtIdC3.setText("" + aux4.getCodigo());
        almacenarImagen();

        Callback<TableColumn<Compra, String>, TableCell<Compra, String>> construirColCompra = (param) -> {
            final TableCell<Compra, String> celda3 = new TableCell<Compra, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        compra = crearBotonC("Comprar");
                        compra.setOnAction(new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent event) {
                                Compra compra = getTableView().getItems().get(getIndex());

                                /*
                                 
                                actualizarTableC(event);
                                Tabla_P.getItems().remove(proDu);
                                Alert b = new Alert(Alert.AlertType.INFORMATION);
                                b.setTitle("Compra");
                                b.setContentText("Compra Realizada..!!\n"
                                        + "El total de su compra fue de: " + proDu.getPrecio());
                                b.show();
                                 */
                                pilas.setPushCompra(compra);
                                pilas.eliminar(pilas.getCarrito(), (int) compra.getIdCliente());
                                tablaCarrito.getItems().remove(compra);
                                actualizarTabla2();
                                Alert b = new Alert(Alert.AlertType.INFORMATION);
                                b.setTitle("Compra");
                                b.setContentText("Compra Realizada..!!\n"
                                        + "El total de su compra fue de: " + compra.getPrecio());
                                b.show();
                                tablaCarrito.getItems().remove(compra);
                                actualizarTabla();
                            }
                        });
                        setGraphic(compra);
                        setText(null);
                    }
                }
            };
            return celda3;
        };

        colBtn.setCellFactory(construirColCompra);

    }

    public Label getTxtNombreCliente() {
        return txtNombreCliente;
    }

    @FXML
    private void abrirCatalogo(MouseEvent event) {
        reseterarVistas();
        panelDescripcion.setVisible(false);
        vistaInicio.setVisible(true);
        reseterarBackground(btnInicio, btnDeseos, btnCarrito, btnCompras);
    }

    @FXML
    private void VerCarrito(MouseEvent event) {
        reseterarVistas();
        panelDescripcion.setVisible(false);
        VistaCarrito.setVisible(true);
        reseterarBackground(btnCarrito, btnDeseos, btnCompras, btnInicio);
    }

    @FXML
    private void verListaDeseos(MouseEvent event) {
        reseterarVistas();
        panelDescripcion.setVisible(false);
        vistaDeseos.setVisible(true);
        reseterarBackground(btnDeseos, btnCarrito, btnCompras, btnInicio);

    }

    @FXML
    private void verCompras(MouseEvent event) {
        reseterarVistas();
        panelDescripcion.setVisible(false);
        vistaCompras.setVisible(true);
        reseterarBackground(btnCompras, btnDeseos, btnCarrito, btnInicio);
    }

    public void reseterarBackground(Label label1, Label label2, Label label3, Label label4) {

        BackgroundFill background_fill = new BackgroundFill(Color.web("#A18B8B"), null, null);
        Background background = new Background(background_fill);
        BackgroundFill background_fill2 = new BackgroundFill(Color.web("#675A5A"), null, null);
        Background background2 = new Background(background_fill2);
        label1.setBackground(background);
        label2.setBackground(background2);
        label3.setBackground(background2);
        label4.setBackground(background2);

    }

    @FXML
    private void regresar(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/vistas/VistaLogin.fxml"));
            Scene scene = new Scene(root);
            Stage stage2 = new Stage();
            stage2.setScene(scene);
            stage2.initStyle(StageStyle.UNDECORATED);
            stage2.show();
            Stage stage = (Stage) this.btnSalir.getScene().getWindow();
            stage.close();
        } catch (IOException ex) {
            Logger.getLogger(VistaLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void reseterarVistas() {
        VistaCarrito.setVisible(false);
        vistaCompras.setVisible(false);
        vistaDeseos.setVisible(false);
        vistaInicio.setVisible(false);
    }

    @FXML
    private void agregarDeseos(MouseEvent event) {
    }

    @FXML
    private void hoverEntro(MouseDragEvent event) {

    }

    @FXML
    private void hoverSalio(MouseDragEvent event) {
    }

    private void almacenarImagen() {
        paneImageMap = new HashMap<>();
        paneImageMap.put(panelA2, new Image("/img/Audi_r8.png"));
        paneImageMap.put(panelA1, new Image("/img/Mazda 3_2015.png"));
        paneImageMap.put(panelA3, new Image("/img/Mercedes_amg.png"));
        paneImageMap.put(panelA4, new Image("/img/Mustang_GT.png"));
    }

    @FXML
    private void verCarro(MouseEvent event) {
        DecimalFormat formato = new DecimalFormat("#.00");
        String numeroFormateado;
        Pane pane = (Pane) event.getSource();
        Image image = paneImageMap.get(pane);
        ImageView imageView = new ImageView(image);
        imageView.preserveRatioProperty().set(true);
        contenImg.getChildren().clear();
        imageView.setFitWidth(contenImg.getWidth());
        imageView.setFitHeight(contenImg.getHeight());
        contenImg.getChildren().add(imageView);

        if (pane.getId().equals("panelA1")) {
            if (listaV.getBuscarId(Integer.parseInt(txtIdC.getText())) != null) {
                Vehiculo aux = listaV.getBuscarId(Integer.parseInt(txtIdC.getText()));
                txtMarcaGeneral.setText(String.valueOf(aux.getMarca()));
                txtColorGeneral.setText(String.valueOf(aux.getColor()));
                txtModeloGneral.setText(String.valueOf(aux.getModelo()));
                txtStockGeneral.setText(String.valueOf(aux.getStock()));
                txtPrecioGenral.setText(numeroFormateado = formato.format(aux.getPrecio()));
                txtIdGeneral.setText(txtIdC.getText());
                SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, aux.getStock(), 1);
                spinnerCantidadGenral.setValueFactory(valueFactory);

                panelDescripcion.setVisible(true);
                System.out.println("Entro en carro 1");
            }
        } else if (pane.getId().equals("panelA2")) {
            if (listaV.getBuscarId(Integer.parseInt(txtIdC1.getText())) != null) {
                Vehiculo aux = listaV.getBuscarId(Integer.parseInt(txtIdC1.getText()));
                txtMarcaGeneral.setText(String.valueOf(aux.getMarca()));
                txtColorGeneral.setText(String.valueOf(aux.getColor()));
                txtModeloGneral.setText(String.valueOf(aux.getModelo()));
                txtStockGeneral.setText(String.valueOf(aux.getStock()));
                txtPrecioGenral.setText(numeroFormateado = formato.format(aux.getPrecio()));
                txtIdGeneral.setText(txtIdC1.getText());
                SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, aux.getStock(), 1);
                spinnerCantidadGenral.setValueFactory(valueFactory);

                panelDescripcion.setVisible(true);
                System.out.println("Entro en carro 2");
            }
        } else if (pane.getId().equals("panelA3")) {
            if (listaV.getBuscarId(Integer.parseInt(txtIdC2.getText())) != null) {
                Vehiculo aux = listaV.getBuscarId(Integer.parseInt(txtIdC2.getText()));
                txtMarcaGeneral.setText(String.valueOf(aux.getMarca()));
                txtColorGeneral.setText(String.valueOf(aux.getColor()));
                txtModeloGneral.setText(String.valueOf(aux.getModelo()));
                txtStockGeneral.setText(String.valueOf(aux.getStock()));
                txtPrecioGenral.setText(numeroFormateado = formato.format(aux.getPrecio()));
                txtIdGeneral.setText(txtIdC2.getText());
                SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, aux.getStock(), 1);
                spinnerCantidadGenral.setValueFactory(valueFactory);

                panelDescripcion.setVisible(true);
                System.out.println("Entro en carro 3");
            }
        } else if (pane.getId().equals("panelA4")) {

            if (listaV.getBuscarId(Integer.parseInt(txtIdC3.getText())) != null) {
                Vehiculo aux = listaV.getBuscarId(Integer.parseInt(txtIdC3.getText()));
                txtMarcaGeneral.setText(String.valueOf(aux.getMarca()));
                txtColorGeneral.setText(String.valueOf(aux.getColor()));
                txtModeloGneral.setText(String.valueOf(aux.getModelo()));
                txtStockGeneral.setText(String.valueOf(aux.getStock()));
                txtPrecioGenral.setText(numeroFormateado = formato.format(aux.getPrecio()));
                txtIdGeneral.setText(txtIdC3.getText());
                SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, aux.getStock(), 1);
                spinnerCantidadGenral.setValueFactory(valueFactory);
                panelDescripcion.setVisible(true);
                System.out.println("Entro en carro 4");
            }
        } else {
            System.out.println("no entro en ninguna");
        }

    }

    @SuppressWarnings("unchecked")
    public void actualizarTabla() {
        tablaCarrito.getItems().clear();
        if (!pilas.getCarrito().isEmpty()) {
            ObservableList<Compra> data = FXCollections.observableArrayList();
            Stack<Compra> pilaAux = new Stack<>();

            pilaAux.addAll(pilas.getCarrito());

            data.addAll(pilaAux);

            tablaCarrito.setItems(data);
        }
    }

    @SuppressWarnings("unchecked")
    private void actualizarTabla2() {

        tablaCompras.getItems().clear();

        if (!pilas.getCompras().isEmpty()) {
            ObservableList<Compra> data = FXCollections.observableArrayList();
            Stack<Compra> pilaAux = new Stack<>();

            pilaAux.addAll(pilas.getCompras());

            data.addAll(pilaAux);

            tablaCompras.setItems(data);
        }
    }

    @FXML
    private void agregarCarrito(ActionEvent event) {
        if (event.getSource() == btnAddCarrito1) {
            tablaCarrito.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) {

                    Compra c = new Compra();
                    LocalDate date = LocalDate.now();

                    c.setMarca(newValue.getMarca());
                    c.setModelo(newValue.getModelo());
                    c.setColor(newValue.getColor());
                    c.setCantidad(newValue.getCantidad());
                    c.setPrecio(newValue.getPrecio());
                    c.setSubTotal(newValue.getSubTotal());
                    c.setFecha(date);
                    pilas.getCarrito(c.getCodigoCompra());
                    pilas.setPushCompra(c);
                    pilas.eliminar(pilas.getCarrito(), (int) newValue.getIdCliente());
                    tablaCarrito.getItems().remove(newValue);
                    actualizarTabla2();
                    actualizarTabla();
                    mostrarAlerta(Alert.AlertType.INFORMATION, "Datos actulizados correctamente", "Informacion");
                }
            });
        }

        if (event.getSource() == btnAddCarrito) {
            String[] x = txtPrecioGenral.getText().split(",");
            double sub = Double.parseDouble(x[0]) * spinnerCantidadGenral.getValue();
            Compra nueva = new Compra(spinnerCantidadGenral.getValue(),
                    Double.parseDouble(x[0]),
                    txtMarcaGeneral.getText(),
                    Integer.parseInt(txtModeloGneral.getText()),
                    txtColorGeneral.getText(),
                    sub);
            System.out.println("" + nueva.getMarca());
            System.out.println("" + nueva.getColor());
            System.out.println("" + nueva.getModelo());
            pilas.setPushCarrito(nueva);
            mostrarAlerta(Alert.AlertType.INFORMATION, "Datos cargados en la tabla", "Exitoso");
            actualizarTabla();

        }

    }

    private Button crearBotonC(String toolTip) {
        Button boton = new Button();
        boton.setTooltip(new Tooltip(toolTip));
        boton.setText("Compra");
        return boton;
    }

    @Override
    public void mostrarAlerta(Alert.AlertType tipo, String mensaje, String titulo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    @Override
    public boolean cajasVacias() {
        return true;
    }

}
