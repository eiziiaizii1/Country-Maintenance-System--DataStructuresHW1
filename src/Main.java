import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {

    private static void fillTheList(DoublyLinkedList dll) throws FileNotFoundException {
        File txtFile = new File("input.txt");
        Scanner sc = new Scanner(txtFile);
        while(sc.hasNextLine()){
            dll.addLast(sc.nextLine());
        }
    }

//    public static void query(DoublyLinkedList dll) throws FileNotFoundException {
//        // Symbols '<', '>', '='  |||  words "print_all", "Delete", "Add"
//        File queryFile = new File("query.txt");
//        Scanner sc = new Scanner(queryFile);
//        while(sc.hasNextLine()){
//            String lineData = sc.nextLine();
//            String[] words = lineData.split("\\s+");
//            if(words[0].equals("Query")){
//                // "< > =" queries
//                if(words.length == 4){
//                    if (   (words[2].equals("=") || words[2].equals("<") || words[2].equals(">")) &&
//                            words[1].equals("country") || words[1].equals("population") || words[1].equals("capital_city") ||
//                            words[1].equals("largest_city") || words[1].equals("language") || words[1].equals("currency") ){
//                        dll.queryControl(words[1],words[2],words[3]);
//                    }
//                }
//                // "print_all" query
//                else if(words.length == 2 && words[1].equals("print_all")){
//                    dll.printList();
//                }
//            }
//            else if (words[0].equals("Delete")) {
//                if(words.length == 2){
//                    dll.deleteSpecific(words[1]);
//                }
//            }
//            else if(words[0].equals("Add")){
//                // doneTODO: implement adding
//                StringBuilder wordsAfterAdd = new StringBuilder();
//
//                for(int i = 1; i < words.length; i++){
//                    wordsAfterAdd.append(words[i] + " ");
//                }
//                dll.addLast(wordsAfterAdd.toString());
//            }
//            System.out.println("-------------------------------------------------------");
//        }
//    }

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
            System.out.println("An Exception occurred -->" +e);
        }

        queryHandler.handleQueries();


    }
}