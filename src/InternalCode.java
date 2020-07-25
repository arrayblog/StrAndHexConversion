import java.io.UnsupportedEncodingException;
import java.lang.invoke.SwitchPoint;
import java.util.Scanner;

public class InternalCode {
    public static String str2Hex(String input,String charset) throws UnsupportedEncodingException {
        String output = "";
        byte[] bytes= input.getBytes(charset);

        for (int i=0;i<bytes.length;i++){
            output+=Integer.toHexString(Byte.toUnsignedInt(bytes[i]))+" ";//两个十六进制数代表一个字节，每个字节留出空格
        }
        return output;
    }

    public static String hex2Str(String input,String charset) throws UnsupportedEncodingException {// 汉字转机内码
        byte[] bytes = new byte[input.length() * 2 - 1];
        String[] strings = input.split(" ");// 将字符串两个一组分段，保证每一段为1byte
        for (int i = 0; i < strings.length; i++) {
            int a = Integer.valueOf(strings[i], 16);// 将16进制字符串转换成int类型
            bytes[i] = (byte) a;// 将int类型强转为byte类型
        }
        String output = new String(bytes, charset);
        return output;
    }

    public static void main(String[] args) {
        System.out.println("1.gbk转utf-8\n2.utf-8转gbk\n请输入1或2并回车");
        Scanner scanner = new Scanner(System.in);
        int opt = Integer.valueOf(scanner.nextLine());
        System.out.println("请输入需要转换的字符串并回车");
        String input = scanner.nextLine();
        switch (opt){
            case 1:
                try {
                    System.out.println(hex2Str(str2Hex(input,"GB2312"),"UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    System.out.println(hex2Str(str2Hex(input,"UTF-8"),"GBK"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
