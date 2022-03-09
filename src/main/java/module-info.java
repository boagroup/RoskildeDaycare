module org.boagroup.roskildedaycare {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;


	opens org.boagroup.roskildedaycare to javafx.fxml;
	exports org.boagroup.roskildedaycare;
}