// Aziz Önder - 22050141021

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {

    // Iterates through the input file's lines, then adds them to list
    private static void fillTheList(DoublyLinkedList dll) throws FileNotFoundException {
        File txtFile = new File("input.txt");
        Scanner sc = new Scanner(txtFile);
        while(sc.hasNextLine()){
            String inputLine = sc.nextLine().trim();
            String[] words = inputLine.split("\\s+");

            // Bypasses the blank and undefined lines in input file
            if(words.length != 6){
                if(inputLine.isBlank()){
                    continue;
                }
                System.out.println("Undefined input format. Skipping this line.");
                continue;
            }
            dll.addLast(inputLine);
        }
        sc.close();
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        QueryHandler queryHandler = new QueryHandler(dll,"query.txt");

        //Fills the list with the content from the input.txt
        try{
            fillTheList(dll);
        }
        catch (FileNotFoundException fnfe){
            System.out.println("File not found --> "+fnfe);
        }
        catch (Exception e){
            System.out.println("An Exception occurred --> " +e);
        }

        try {
            queryHandler.handleQueries();
        }catch (NumberFormatException nfe){
            System.out.println("The population value needs to be represented with the positive long data type!!!\n --> " + nfe);
        }
        catch (Exception e){
            System.out.println("Unexpected problem has occurred --> " + e);
        }

    }
}