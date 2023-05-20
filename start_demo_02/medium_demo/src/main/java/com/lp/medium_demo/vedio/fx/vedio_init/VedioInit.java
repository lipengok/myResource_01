package com.lp.medium_demo.vedio.fx.vedio_init;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @Author lipeng
 * @Date 2023/4/13 9:59
 * @Version 1.0
 */
//@Slf4j
//@Component
public class VedioInit implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
//        log.info("开始创建javaFX应用程序");
//        Label label = new Label("Hello, World!");
//        StackPane root = new StackPane();
//        root.getChildren().add(label);
//        Scene scene = new Scene(root, 300, 200);
//        Stage primaryStage = new Stage();
//        primaryStage.setScene(scene);
//        primaryStage.setTitle("Hello, World!");
//        primaryStage.show();
//        log.info("创建javaFX应用程序完成");
    }
}
