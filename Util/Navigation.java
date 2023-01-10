package lk.ijse.Fusion.Util;


import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.Fusion.controller.Main;
import javafx.stage.Window;


import java.io.IOException;

public class Navigation {
    private static AnchorPane pane;

    public static void navigate(Routes route, AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage) Navigation.pane.getScene().getWindow();

        switch(route){

            case  MAINPAGE:
                window.setTitle(" MAINPAGE");
                initUI("Main.fxml");
                break;

            case SIGNUPPAGE:
                window.setTitle("SIGNUPPAGE");
                initUI("SignInForm.fxml");
                break;

            case DASHBOARD:
                window.setTitle("Dashboardwindow");
                initUI("DashHome.fxml");
                break;

            case STOCKDASH:
                window.setTitle("StockDashboardwindow");
                initUI("StockKeeperDashHome.fxml");
                break;

            case IT_MANAGERDASH:
                window.setTitle("ITMANAGERDashboardwindow");
                initUI("ITManagerDashHome.fxml");
                break;

            case ITEM:
                window.setTitle("Itemwindow");
                initUI("ItemForm.fxml");
                break;

            case ORDERS:
                window.setTitle("orderwindow");
                initUI("OrderForm.fxml");
                break;

            case EMPLOYEE:
                window.setTitle("employeewindow");
                initUI("Employee.fxml");
                break;

            case CUSTOMER:
                window.setTitle("Customer");
                initUI("CustomerForm.fxml");
                break;

            case PAYMENT:
                window.setTitle("paymentwindow");
                initUI("PaymetForm.fxml");
                break;

            case SUPPLIER:
                window.setTitle("SupplierWindow");
                initUI("SupplierForm.fxml");
                break;

            case ATTENDS:
                window.setTitle("attendsWindow");
                initUI("Attends.fxml");
                break;

            case SALARY:
                window.setTitle("Salary Window");
                initUI("SalaryForm.fxml");
                break;

            case STOCK:
                window.setTitle("StockWidow");
                initUI("StockForm.fxml");
                break;

            case DELIVERY:
                window.setTitle("DeliveryWindow");
                initUI("DeliveryForm.fxml");
                break;

            case RETURN:
                window.setTitle("Return Window");
                initUI("ReturnForm.fxml");
                break;


            case PLACEORDER:
                window.setTitle("PlaceOrder Window");
                initUI("PlaceOrderForm.fxml");
                break;

            default:
                new Alert(Alert.AlertType.ERROR,"ui not found!!!").show();
        }
    }
    private static void initUI(String location) throws IOException {
       Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class.getResource("/lk/ijse/Fusion/View/"+location )));
   }
}