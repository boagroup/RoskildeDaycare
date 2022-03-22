module com.example.daycareroskilde_new {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;


	exports org.boagroup.roskildedaycare;
	opens org.boagroup.roskildedaycare to javafx.fxml;
}