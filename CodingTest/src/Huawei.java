// 本题为考试单行多行输入输出规范示例，无需提交，不计分。

import java.util.Scanner;

public class Huawei {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String url = in.nextLine();
        String[] urls = url.split(",");
        if (urls.length == 0) {
            System.out.println("/");
            return;
        }
        if (urls.length == 1) {
            String str = urls[0];
            if (url.indexOf(',') == 0) {
                if (str.charAt(0) == '/') {
                    str = str.substring(1, str.length());
                }
                System.out.println("/" + str);
            } else {
                if (str.charAt(str.length() - 1) == '/') {
                    str = str.substring(0, str.length() - 1);
                }
                System.out.println(str);
            }
        }
        if (urls.length == 2) {
            String a = urls[0];
            String b = urls[1];
            if (a.length() != 0) {
                if (a.charAt(a.length() - 1) == '/') {
                    a = a.substring(0, a.length() - 1);
                }
            }
            if (b.length() != 0) {
                if (b.charAt(0) == '/') {
                    b = b.substring(1, b.length());
                }


            }
            System.out.println(a + "/" + b);
        }
    }
}