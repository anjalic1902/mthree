import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Random;

public class InsertData {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/TelecomNetworkPerformance"; // Replace with your DB URL
        String username = "root"; // Replace with your DB username
        String password = "root"; // Replace with your DB password

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            conn.setAutoCommit(false);  // Start transaction

            // Insert records into each table
            insertDimDateData(conn);
            insertDimTowerData(conn);
            insertDimServiceData(conn);
            insertDimUserData(conn);
            insertFactNetworkEventsData(conn);

            conn.commit();  // Commit the transaction if all inserts are successful
            System.out.println("Data insertion completed successfully!");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Insert records into DimDate table (168 records for 7 days of hourly data)
    public static void insertDimDateData(Connection conn) throws SQLException {
        String insertSQL = "INSERT INTO DimDate (DateID, Date, Year, Month, Day, Hour) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(insertSQL);

        LocalDateTime dateTime = LocalDateTime.of(2024, 10, 1, 0, 0);
        int dateID = 1;

        for (int i = 0; i < 168; i++) {
            pstmt.setInt(1, dateID);  // DateID
            pstmt.setString(2, dateTime.toLocalDate().toString());  // Date
            pstmt.setInt(3, dateTime.getYear());  // Year
            pstmt.setInt(4, dateTime.getMonthValue());  // Month
            pstmt.setInt(5, dateTime.getDayOfMonth());  // Day
            pstmt.setInt(6, dateTime.getHour());  // Hour
            
            pstmt.addBatch();  // Add the record to the batch
            dateTime = dateTime.plusHours(1);  // Increment by 1 hour
            dateID++;  // Increment DateID
        }

        pstmt.executeBatch();
        System.out.println("168 records inserted into DimDate table.");
    }

    // Insert records into DimTower table (10 sample towers)
    public static void insertDimTowerData(Connection conn) throws SQLException {
        String insertSQL = "INSERT INTO DimTower (TowerID, Location, Capacity) VALUES (?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(insertSQL);

        for (int i = 1; i <= 10; i++) {
            pstmt.setInt(1, i);  // TowerID
            pstmt.setString(2, "Location " + i);  // Location
            pstmt.setInt(3, 100 + i * 10);  // Capacity
            
            pstmt.addBatch();  // Add the record to the batch
        }

        pstmt.executeBatch();
        System.out.println("10 records inserted into DimTower table.");
    }

    // Insert records into DimService table (5 sample services)
    public static void insertDimServiceData(Connection conn) throws SQLException {
        String insertSQL = "INSERT INTO DimService (ServiceID, ServiceName, ServiceType) VALUES (?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(insertSQL);

        for (int i = 1; i <= 5; i++) {
            pstmt.setInt(1, i);  // ServiceID
            pstmt.setString(2, "Service " + i);  // ServiceName
            pstmt.setString(3, "Type " + i);  // ServiceType
            
            pstmt.addBatch();  // Add the record to the batch
        }

        pstmt.executeBatch();
        System.out.println("5 records inserted into DimService table.");
    }

    // Insert records into DimUser table (50 sample users)
    public static void insertDimUserData(Connection conn) throws SQLException {
        String insertSQL = "INSERT INTO DimUser (UserID, Name, PlanType) VALUES (?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(insertSQL);

        for (int i = 1; i <= 50; i++) {
            pstmt.setInt(1, i);  // UserID
            pstmt.setString(2, "User " + i);  // Name
            pstmt.setString(3, i % 2 == 0 ? "Premium" : "Standard");  // PlanType (alternate between Premium and Standard)
            
            pstmt.addBatch();  // Add the record to the batch
        }

        pstmt.executeBatch();
        System.out.println("50 records inserted into DimUser table.");
    }

    // Insert records into FactNetworkEvents table (Sample 6 million records)
    public static void insertFactNetworkEventsData(Connection conn) throws SQLException {
        String insertSQL = "INSERT INTO FactNetworkEvents (EventID, DateID, TowerID, ServiceID, UserID, Duration, DataUsed) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(insertSQL);

        Random random = new Random();
        int eventID = 1;

        for (int i = 0; i < 6000000; i++) {
            pstmt.setInt(1, eventID);  // EventID
            pstmt.setInt(2, random.nextInt(168) + 1);  // Random DateID between 1 and 168
            pstmt.setInt(3, random.nextInt(10) + 1);  // Random TowerID between 1 and 10
            pstmt.setInt(4, random.nextInt(5) + 1);  // Random ServiceID between 1 and 5
            pstmt.setInt(5, random.nextInt(50) + 1);  // Random UserID between 1 and 50
            pstmt.setInt(6, random.nextInt(60) + 1);  // Random Duration (1 to 60 minutes)
            pstmt.setInt(7, random.nextInt(1000) + 1);  // Random DataUsed (1MB to 1000MB)
            
            pstmt.addBatch();  // Add the record to the batch
            eventID++;  // Increment EventID

            // Execute batch every 10,000 records for efficiency
            if (i % 10000 == 0) {
                pstmt.executeBatch();
                System.out.println("Inserted " + (i + 1) + " records into FactNetworkEvents...");
            }
        }

        pstmt.executeBatch();
        System.out.println("6 million records inserted into FactNetworkEvents table.");
    }
}
