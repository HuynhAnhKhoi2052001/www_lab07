package chanh.com.wwwweek789.controllers;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class OpenOnStartup {
    @PostConstruct
    public void openBrowser() {
        String url = "http://localhost:8080/homes";
        openBrowser(url);
    }

    private void openBrowser(String url) {
        String os = System.getProperty("os.name").toLowerCase();
        try {
            if (os.contains("win")) {
                Runtime.getRuntime().exec("cmd /c start chrome " + url);
            } else {
                System.out.println("Hệ điều hành không được hỗ trợ. Vui lòng mở trình duyệt và truy cập: " + url);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
