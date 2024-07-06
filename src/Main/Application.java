
package Main;

import View1.DangNhap;
import View1.QL1080View;

import java.awt.*;

public class Application {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    QL1080View frame = new QL1080View();
                    frame.setVisible(true);
                    System.out.println("Khởi động thành công");
                } catch (Exception var2) {
                    var2.printStackTrace();
                }

            }
        });
    }

}
