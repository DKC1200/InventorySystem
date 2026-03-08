module com.debora.inventory {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.debora.inventory to javafx.fxml;
    exports com.debora.inventory;
}
