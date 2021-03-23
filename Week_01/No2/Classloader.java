import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Classloader extends ClassLoader{

    public static void main(String[] args) throws Exception {
        Class<?> aClass = new Classloader().findClass("Hello");
        Object obj = aClass.newInstance();
        Method method = aClass.getDeclaredMethod("hello");
        method.setAccessible(true);
        method.invoke(obj);
    }

    public String getPath(){
        return "Hello.xlass";
    }

    public byte[] getBytesByPath(String pathName){
        File file = new File(pathName);
        Path path = Paths.get(file.getAbsolutePath());
        byte[] data = new byte[0];
        try {
            data = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    public byte[] decodeConvert(byte[] origin){
        byte[] fin = new byte[origin.length];
        for (int i = 0; i < origin.length; i++) {
            fin[i] = (byte) (255 - origin[i]);
        }
        return fin;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = getBytesByPath(getPath());
        byte[] finBytes = decodeConvert(bytes);
        return defineClass(name,finBytes,0,finBytes.length);
    }


    //TODO 有个问题为什么我自己复制过来的class文件，转成byte 运行就会报错，是因为字符串转换进制的问题么；
    //TODO ncompatible magic value 4278124643 in class file
//    private void temp(){
//        String asd = "cafe babe 0000 0034 0023 0a00 0600 1509\n" +
//                "0016 0017 0800 180a 0019 001a 0700 1b07\n" +
//                "001c 0100 063c 696e 6974 3e01 0003 2829\n" +
//                "5601 0004 436f 6465 0100 0f4c 696e 654e\n" +
//                "756d 6265 7254 6162 6c65 0100 124c 6f63\n" +
//                "616c 5661 7269 6162 6c65 5461 626c 6501\n" +
//                "0004 7468 6973 0100 074c 4141 4141 413b\n" +
//                "0100 046d 6169 6e01 0016 285b 4c6a 6176\n" +
//                "612f 6c61 6e67 2f53 7472 696e 673b 2956\n" +
//                "0100 0461 7267 7301 0013 5b4c 6a61 7661\n" +
//                "2f6c 616e 672f 5374 7269 6e67 3b01 0008\n" +
//                "3c63 6c69 6e69 743e 0100 0a53 6f75 7263\n" +
//                "6546 696c 6501 000a 4141 4141 412e 6a61\n" +
//                "7661 0c00 0700 0807 001d 0c00 1e00 1f01\n" +
//                "000b 4865 6c6c 6f20 576f 726c 6407 0020\n" +
//                "0c00 2100 2201 0005 4141 4141 4101 0010\n" +
//                "6a61 7661 2f6c 616e 672f 4f62 6a65 6374\n" +
//                "0100 106a 6176 612f 6c61 6e67 2f53 7973\n" +
//                "7465 6d01 0003 6f75 7401 0015 4c6a 6176\n" +
//                "612f 696f 2f50 7269 6e74 5374 7265 616d\n" +
//                "3b01 0013 6a61 7661 2f69 6f2f 5072 696e\n" +
//                "7453 7472 6561 6d01 0007 7072 696e 746c\n" +
//                "6e01 0015 284c 6a61 7661 2f6c 616e 672f\n" +
//                "5374 7269 6e67 3b29 5600 2100 0500 0600\n" +
//                "0000 0000 0300 0100 0700 0800 0100 0900\n" +
//                "0000 2f00 0100 0100 0000 052a b700 01b1\n" +
//                "0000 0002 000a 0000 0006 0001 0000 0001\n" +
//                "000b 0000 000c 0001 0000 0005 000c 000d\n" +
//                "0000 0009 000e 000f 0001 0009 0000 002b\n" +
//                "0000 0001 0000 0001 b100 0000 0200 0a00\n" +
//                "0000 0600 0100 0000 0800 0b00 0000 0c00\n" +
//                "0100 0000 0100 1000 1100 0000 0800 1200\n" +
//                "0800 0100 0900 0000 2500 0200 0000 0000\n" +
//                "09b2 0002 1203 b600 04b1 0000 0001 000a\n" +
//                "0000 000a 0002 0000 0003 0008 0004 0001\n" +
//                "0013 0000 0002 0014 ";
//    }
}
