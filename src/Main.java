
import br.com.view.*;


public class Main {
  public static void main(String[] args) {
    var employeeView = new EmployeeView();
    var adminView = new AdminView();
    var loginView = new LoginView(employeeView, adminView);
    var startView = new StartView(loginView);
    startView.init();

  }
}