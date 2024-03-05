import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {

    private static void fillTheList(DoublyLinkedList dll) throws FileNotFoundException {
        File txtFile = new File("input.txt");
        Scanner sc = new Scanner(txtFile);
        while(sc.hasNextLine()){
            dll.addFirst(sc.nextLine());
        }
    }

    public void query(DoublyLinkedList dll) throws FileNotFoundException {
        // Symbols '<', '>', '='  |||  words "print_all", "Delete", "Add"
        File queryFile = new File("query.txt");
        Scanner sc = new Scanner(queryFile);
        while(sc.hasNextLine()){
            //TODO: Detect the operation keywords here, then implement required method to complete the query
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        //Fills the list with the content from the input.txt
        try{
            fillTheList(dll);
        }
        catch (FileNotFoundException fnfe){
            System.out.println("File not found --> "+fnfe);
        }
        catch (Exception e){
            System.out.println("An Exception occurred -->" +e);
        }
        dll.printList();
    }
}