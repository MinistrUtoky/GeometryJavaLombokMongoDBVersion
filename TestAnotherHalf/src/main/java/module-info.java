module com.example.javafxapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.swing;

    requires transitive javafx.base;
    requires transitive javafx.graphics;
    requires transitive java.desktop;

    requires com.dlsc.formsfx;
    requires org.mongodb.bson;
    requires org.mongodb.driver.sync.client;
    requires java.logging;
    requires TestFirstHalf;
    requires org.mongodb.driver.core;
    requires lombok;


    opens com.example.javafxapp to javafx.fxml;
    exports com.example.javafxapp;
}