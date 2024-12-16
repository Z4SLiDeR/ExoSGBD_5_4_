module mvc {
    requires transitive java.desktop;
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.postgresql.jdbc;

    opens mvc to javafx.fxml;
    exports mvc.View;
    exports mvc.Controller;
    exports mvc.Model;
}
