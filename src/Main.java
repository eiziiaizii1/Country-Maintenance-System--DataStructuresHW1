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
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

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