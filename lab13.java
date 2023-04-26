import java.util.*;
import java.io.*;

public class lab13 {
    public static void main(String args[]) {
        if( args.length < 2 ) {
            System.out.println("Two call parameters are needed: file name and search string");
            return;
        }
        String thisLine;
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader fin = null;
        try {
            fin = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
            while ((thisLine = fin.readLine()) != null) {
                System.out.println("==Entered string:"+thisLine);
                list.add(thisLine);
            }
            Collections.sort(list);
            System.out.println("Sorted list of strings:");
            Iterator<String> iter = list.iterator();
            while (iter.hasNext()) {
                String str = iter.next();
                System.out.println(str);
            }
            String searchStr = args[1];
            int index = Collections.binarySearch(list, searchStr);
            if (index >= 0) {
                System.out.println("Search results:" + list.get(index));
            } else {
                System.out.println("Search result: Row not found.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found:" + args[0]);
            System.out.println("Error: " + e);
        } catch (IOException e) {
            System.out.println("I/O error. File" + args[0]);
            System.out.println("Error: " + e);
        } finally {
            if (fin != null)
                try {
                    fin.close(); // !!! close file
                } catch (IOException ex) {
                    System.out.println("File close error" + args[0]);
                    System.out.println("Error: " + ex);
                }
            fin = null;
        }
    }
}