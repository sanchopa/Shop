package Date;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class ParseFile {
    public static Object [] getArrayProduct(){
        List stringProduct = new ArrayList<String>();
        try {
            LineNumberReader lineNumberReader =
                    new LineNumberReader(
                            new BufferedReader(
                                    new FileReader(".\\src\\Resurce\\Product.txt")));
            String line;
            while ((line = lineNumberReader.readLine()) != null) {
                stringProduct.add(line);
            }
            lineNumberReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringProduct.toArray();
    }
}
