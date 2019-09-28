import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Application app = new BankApplication();
        app.setTitle(bankTitle);
        app.run(args);
    }
}
