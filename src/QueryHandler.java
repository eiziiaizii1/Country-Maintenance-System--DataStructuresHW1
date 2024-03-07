// Aziz Önder - 22050141021

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QueryHandler {
    final private DoublyLinkedList dll;
    final private File queryFile;

    public QueryHandler(DoublyLinkedList doublyLinkedList, String queryPath){
        dll = doublyLinkedList;
        queryFile = new File(queryPath);
    }

    public void handleQueries(){
        Scanner sc = null;
        try {
            sc = new Scanner(queryFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        int queryLineNum = 1;
        while(sc.hasNextLine()){
            String lineData = sc.nextLine();
            String[] words = lineData.split("\\s+");

            if(words[0].equals("Query")){
                // "< > =" queries
                if(words.length == 4){
                    if (   (words[2].equals("=") || words[2].equals("<") || words[2].equals(">")) &&
                            words[1].equals("country") || words[1].equals("population") || words[1].equals("capital_city") ||
                            words[1].equals("largest_city") || words[1].equals("official_language") || words[1].equals("currency") ){
                        check(words[1],words[2],words[3]);
                    }
                    else
                    {
                        System.out.println("UNDEFINED QUERY FORMAT!!");
                    }
                }
                // "print_all" query
                else if(words.length == 2 && words[1].equals("print_all")){
                    dll.printList();
                }
                else
                {
                    System.out.println("UNDEFINED QUERY FORMAT!!");
                }
            }
            else if (words[0].equals("Delete")) {
                if(words.length == 2){
                    dll.deleteSpecific(words[1]);
                }
                else
                {
                    System.out.println("UNDEFINED QUERY FORMAT!!");
                }
            }
            else if(words[0].equals("Add")){
                StringBuilder wordsAfterAdd = new StringBuilder();

                if(words.length == 7)
                {
                    for(int i = 1; i < words.length; i++){
                        wordsAfterAdd.append(words[i]).append(" ");
                    }
                    if(dll.addLast(wordsAfterAdd.toString())){
                        System.out.println("A new country has been added.");
                    }
                }
                else
                {
                    System.out.println("UNDEFINED QUERY FORMAT!!");
                }
            }
            System.out.println("-------------------------------------------------------" + (queryLineNum++));
        }
        sc.close();
    }


    private void check(String attribute, String symbol, String data){
        switch (attribute){
            case "country":
                dll.checkAttribute(0,symbol,data);
                break;
            case "population":
                dll.checkAttribute(1,symbol,data);
                break;
            case "capital_city":
                dll.checkAttribute(2,symbol,data);
                break;
            case "largest_city":
                dll.checkAttribute(3,symbol,data);
                break;
            case "official_language":
                dll.checkAttribute(4,symbol,data);
                break;
            case "currency":
                dll.checkAttribute(5,symbol,data);
                break;
            default:
                System.out.println(attribute + " is not defined!!!");
        }
    }
}