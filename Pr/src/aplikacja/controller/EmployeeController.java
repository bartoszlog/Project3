package aplikacja.controller;



import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import aplikacja.model.Employee;
import database.DbController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;


public class EmployeeController implements Initializable{

    @FXML
    private Button DoneTwo;
    @FXML
    private MenuButton MenuTwo;
    @FXML
    private TableView<Employee> TableTwo;
    @FXML
    private TableColumn<Employee, Integer> IdTwo;
    @FXML
    private TableColumn<Employee, String> FirstNameTwo;
    @FXML
    private TableColumn<Employee, String> LastNameTwo;
    @FXML
    private TableColumn<Employee, String> GrossSalaryTwo;
    @FXML
    private TableColumn<Employee, String> NetSalaryTwo;

    @FXML
    private Button ButtonTwo;
    @FXML
    private Button ButtonThree;
    @FXML
    private Button ButtonCommit;
    @FXML
    private TextField textFirstName;
    @FXML
    private ImageView imgTwo;
    @FXML
    private TextField textLastName;
    @FXML
    private TextField textGrossSalary;
    @FXML
    private TextField textNetSalary;
    
    public DbController db;
 
    public ObservableList<Employee>data=FXCollections.observableArrayList();
   
   

    public void btnRefreshAction(ActionEvent event) throws SQLException, ClassNotFoundException{
    	try{
    		Connection conn = db.Connection();
            data = FXCollections.observableArrayList();       
            ResultSet rs = conn.createStatement().executeQuery("SELECT * from employee");
            while (rs.next()){
                data.add(new Employee(rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5)));
            }
            
        }catch (SQLException ex){
            System.err.print("Error" + ex);
        }
        
        FirstNameTwo.setCellValueFactory(new PropertyValueFactory<Employee,String>("firstName"));
        LastNameTwo.setCellValueFactory(new PropertyValueFactory<Employee,String>("lastName"));
        GrossSalaryTwo.setCellValueFactory(new PropertyValueFactory<Employee,String>("salary1"));
        NetSalaryTwo.setCellValueFactory(new PropertyValueFactory<Employee,String>("salary2"));
        
        TableTwo.setItems(null);
        TableTwo.setItems(data);
    }
    
    @FXML
    private void btnSaveChangesAction(ActionEvent event) throws ClassNotFoundException, SQLException {
        
        java.sql.PreparedStatement preparedStatement = null;
        
        String surname = TableTwo.getSelectionModel().getSelectedItem().getLastName();
        Connection conn = db.Connection();
            try {
		String sql = "UPDATE employee SET firstName_employee = ?, lastName_employee = ?, gross_earnings = ?, net_eartnings = ?" 
                              + " WHERE lastName_employee = ?";
		
		preparedStatement = conn.prepareStatement(sql);	    		        
		preparedStatement.setString(1, textFirstName.getText());
		preparedStatement.setString(2, textLastName.getText());
		preparedStatement.setString(3, textGrossSalary.getText());
		preparedStatement.setString(4, textNetSalary.getText());
                preparedStatement.setString(5, surname);
		    		        		
		preparedStatement.executeUpdate();
		
		
                
            } catch (SQLException ex) {
		System.err.print("Error " + ex);
            }
        
        try{
            data = FXCollections.observableArrayList();
         
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM employee ORDER BY lastName_employee");
            while (rs.next()){
                data.add(new Employee(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        }catch (SQLException ex){
            System.err.print("Error " + ex);
        }
        FirstNameTwo.setCellValueFactory(new PropertyValueFactory<Employee,String>("firstName"));
        LastNameTwo.setCellValueFactory(new PropertyValueFactory<Employee,String>("lastName"));
        GrossSalaryTwo.setCellValueFactory(new PropertyValueFactory<Employee,String>("salary1"));
        NetSalaryTwo.setCellValueFactory(new PropertyValueFactory<Employee,String>("salary2"));
             
        TableTwo.setItems(null);
        TableTwo.setItems(data);
    }   
    
    @FXML
    private void btnSaveEmployeeAction(ActionEvent event) throws ClassNotFoundException {
        
        java.sql.PreparedStatement preparedStatement = null;

        try {
            Connection conn = db.Connection();
            String sql = "INSERT INTO employee (firstName_employee, lastName_employee, gross_earnings, net_eartnings)"
                        + " values (?, ?, ?, ?)";
            preparedStatement = conn.prepareStatement(sql);
            
    		preparedStatement.setString(1, textFirstName.getText());
    		preparedStatement.setString(2, textLastName.getText());
    		preparedStatement.setString(3, textGrossSalary.getText());
    		preparedStatement.setString(4, textNetSalary.getText());
		    		        		
            preparedStatement.executeUpdate();
            
            textFirstName.setText("");
            textLastName.setText("");
            textGrossSalary.setText("");
            textNetSalary.setText("");

                    
            } catch (SQLException ex) {
                System.err.print("Error " + ex);
            }
            
        try{
            Connection conn = db.Connection();
            data = FXCollections.observableArrayList();
         
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM employee");
            while (rs.next()){
                data.add(new Employee(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        }catch (SQLException ex){
            System.err.print("Error " + ex);
        }
        FirstNameTwo.setCellValueFactory(new PropertyValueFactory<Employee,String>("firstName"));
        LastNameTwo.setCellValueFactory(new PropertyValueFactory<Employee,String>("lastName"));
        GrossSalaryTwo.setCellValueFactory(new PropertyValueFactory<Employee,String>("salary1"));
        NetSalaryTwo.setCellValueFactory(new PropertyValueFactory<Employee,String>("salary2"));
        
        TableTwo.setItems(null);
        TableTwo.setItems(data);
    }  
    @FXML
    private void btnDeleteAction(ActionEvent event) throws ClassNotFoundException, SQLException {
        
        java.sql.PreparedStatement preparedStatement = null;
        String surname = TableTwo.getSelectionModel().getSelectedItem().getlastName();
        Connection conn = db.Connection();
        try {
		String sql = "DELETE FROM  employee WHERE lastName_employee = '" + surname + "'";
                preparedStatement = conn.prepareStatement(sql);
		preparedStatement.executeUpdate();
		
		textFirstName.setText("");
        textLastName.setText("");
        textGrossSalary.setText("");
        textNetSalary.setText("");
            
                
            }catch (SQLException ex) {
		System.err.print("Error" + ex);
            }
            
        try{
            data = FXCollections.observableArrayList();
         
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM employee ORDER BY lastName_employee");
            while (rs.next()){
                data.add(new Employee(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        }catch (SQLException ex){
            System.err.print("Error " + ex);
        }
        FirstNameTwo.setCellValueFactory(new PropertyValueFactory<Employee,String>("firstName"));
        LastNameTwo.setCellValueFactory(new PropertyValueFactory<Employee,String>("lastName"));
        GrossSalaryTwo.setCellValueFactory(new PropertyValueFactory<Employee,String>("salary1"));
        NetSalaryTwo.setCellValueFactory(new PropertyValueFactory<Employee,String>("salary2"));
        
        TableTwo.setItems(null);
        TableTwo.setItems(data);
    }   

          
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		db = new DbController();	
	}

}
