import java.sql.*;
import java.util.Scanner;

public class abcd {
    public static void main(String args[]) {
        try {
            String url = "jdbc:mysql://localhost:3306/test";
            String username = "root";
            String password = "root@1234";
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT response FROM responses WHERE question = ?");

            Scanner scanner = new Scanner(System.in);
            boolean response = true;
            

            while (response) {
                System.out.println("\nCan I help you today? Enter 'Yes' if you do and 'No' if you don't");
                String inputString = scanner.nextLine().toLowerCase();
                
                if (inputString.equals("yes")) {
                    System.out.println("\nWe know the answers to the following questions:");
                    System.out.println("- How are you?");
                    System.out.println("- What is the weather like today?");
                    System.out.println("- Who are you?\n");
                    System.out.println("What do you need help with?");
                    String help = scanner.nextLine().toLowerCase();

                    preparedStatement.setString(1, help);
                    ResultSet resultSet = preparedStatement.executeQuery();

                    // Check if there's a response in the database
                    if (resultSet.next()) {
                        String responseFromDB = resultSet.getString("response");
                        System.out.println("\n"+responseFromDB);
                    } else {
                        System.out.println("Sorry, I don't have a solution for that problem.");
                    }
                } else {
                    response = false;
                }
            }
            preparedStatement.close();
            connection.close();
            scanner.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
