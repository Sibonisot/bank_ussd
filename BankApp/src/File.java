import java.io.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class File {
    DecimalFormat df = new DecimalFormat("#,##0.00");

    /**
     * display the contents in the out.txt to the console
     */
    public void displayText() {
        try {
            java.io.File file = new java.io.File("out.txt");    //creates a new file instance
            FileReader fr = new FileReader(file);   //reads the file
            BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream
            StringBuffer sb = new StringBuffer();    //constructs a string buffer with no characters
            String line;
            while ((line=br.readLine())!= null) {
                sb.append(line);      //appends line to string buffer
                sb.append("\n");     //line feed
            }
            fr.close();    //closes the stream and release the resource
            System.out.println(sb.toString());   //returns a string that textually represents the object
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * adds a blank line to the out.txt file
     */
    public void appendBlankLine(){
        appendText("", "", "", "", true);
    }

    /**
     * adds the first line to the out.txt file
     * @param text the first line
     */
    public void appendFirstLine(String text){
        appendText(text, "", "", "", false);
    }

    /**
     * appending text to the out.txt file
     * @param text the text
     */
    public void appendLine(String text){
        appendText(text, "", "", "", true);
    }

    /**
     * appending text to the out.txt file
     * @param text1 the text1
     * @param text2 the text2
     */
    public void appendLine(String text1, BigDecimal text2){
        appendText(text1, df.format(text2), "", "", true);
    }

    /**
     * appending text to the out.txt file
     * @param text1 the text1
     * @param text2 the text2
     */
    public void appendLine(String text1, double text2){
        appendText(text1, df.format(text2), "", "", true);
    }

    /**
     * appending text to the out.txt file
     * @param text1 the text1
     * @param text2 the text2
     * @param text3 the text3
     */
    public void appendLine(String text1, BigDecimal text2, BigDecimal text3){
        appendText(text1, df.format(text2), df.format(text3), "", true);
    }

    /**
     * appending text to the out.txt file
     * @param text1 the text1
     * @param text2 the text2
     * @param text3 the text3
     */
    public void appendLine(String text1, Double text2, BigDecimal text3){
        appendText(text1, df.format(text2), df.format(text3), "", true);
    }

    /**
     * appending text to the out.txt file
     * @param text1 the text1
     * @param text2 the text2
     * @param text3 the text3
     */
    public void appendLine(String text1, String text2, String text3){
        appendText(text1, text2, text3, "", true);
    }

    /**
     * appending text to the out.txt file
     * @param text1 the text1
     * @param text2 the text2
     * @param text3 the text3
     * @param text4 the text4
     */
    public void appendLine(double text1, Integer text2, Double text3, BigDecimal text4){
        appendText(df.format(text1), df.format(text2), df.format(text3), df.format(text4), true);
    }

    /**
     * appending text to the out.txt file
     * @param text1 the text1
     * @param text2 the text2
     * @param text3 the text3
     * @param text4 the text4
     */
    public void appendLine(String text1, String text2, String text3, String text4){
        appendText(text1, text2, text3, text4, true);
    }

    /**
     * appends the text to the out.txt file
     * @param text1 the text to append to the out.txt file
     * @param append if true, then data will be written to the end of the file, else the beginning
     */
    public void appendText(String text1, String text2, String text3, String text4, boolean append){
        String fileName = "out.txt";
        String text = String.format("%-25s %-25s %-25s %-25s", text1, text2, text3, text4);

        FileWriter fw;
        BufferedWriter bw;
        PrintWriter pw;
        try {
            fw = new FileWriter(fileName, append);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);

            pw.println(text);

            pw.flush();
            //System.out.println("Done! ");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}