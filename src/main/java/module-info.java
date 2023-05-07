module ui.pages {
    requires javafx.controls;
    requires javafx.fxml;
            requires com.dlsc.formsfx;
                    requires org.kordamp.bootstrapfx.core;
            
    opens ui.pages to javafx.fxml;
    exports ui.pages;
}