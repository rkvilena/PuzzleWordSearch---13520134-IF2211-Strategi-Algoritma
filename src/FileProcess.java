import java.io.FileReader;
import java.io.IOException;

public class FileProcess {
    public static char[][] matrixProcessing(String nameFile){
        String firstStep = fileInput(nameFile);
        return strToMat(firstStep);
    }

    public static String[] arrayProcessing(String nameFile){
        String firstStep = fileInput(nameFile);
        return strToArr(firstStep);
    }
    
    public static String fileInput(String strFile)
    {
        String strConv = "";
        String namaFile = "../test/" + strFile;
        try {
            FileReader fRead = new FileReader(namaFile);

            int ch;
            while ((ch = fRead.read()) != -1) {
                strConv += (char)ch;
            }
            fRead.close();
        }
        catch (IOException e) {
            System.out.println("Pembacaan file masukan error.");
        }
        return strConv;
    }

    public static char[][] strToMat(String mat){
        String[] hasilSplit = mat.split("\n");
        boolean isRowMax = true;
        int i = 0;
        while (isRowMax){
            boolean isWhitespace = hasilSplit[i+1].matches("^\\s*$");
            if (isWhitespace){
                isRowMax = false;
                i++;
            }
            else{
                i++;
            }
        }
        char[][] matrix = new char[i][];
        i = 0;
        
        boolean matLooping = true;
        while (i < matrix.length && (matLooping)) {
            String[] arr2 = hasilSplit[i].split(" ");
            matrix[i] = new char[arr2.length];

            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = arr2[j].charAt(0);
            }
            boolean isWhitespace = hasilSplit[i+1].matches("^\\s*$");
            if (isWhitespace){
                matLooping = false;
            }
            i++;
        }
        return matrix;
    }

    public static String[] strToArr(String arr){
        String[] hasilSplit = arr.split("\n");
        boolean startWordlist = false;
        int i = 0;
        while (!startWordlist){
            boolean isWhitespace = hasilSplit[i].matches("^\\s*$");
            if (isWhitespace){
                startWordlist = true;
            }
            i++;
        }
        String[] wordList = new String[hasilSplit.length - i];
        for (int s = 0; s < wordList.length; s++){
            wordList[s] = hasilSplit[i];
            wordList[s] = wordList[s].replaceAll("\\s","");
            i++;
        }
        return wordList;
    }
}