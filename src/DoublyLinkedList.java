// Aziz Önder - 22050141021

public class DoublyLinkedList {
    private static class Node {
        private Node prev;
        private Node next;
        private String[] data;
        //data[0] -> country
        //data[1] -> population
        //data[2] -> capital_city
        //data[3] -> largest_city
        //data[4] -> official_language
        //data[5] -> currency

        public Node(Node prev, Node next, String line){
            data = new String[6];

            if(line != null){
                line = line.trim();
                data = line.split("\\s+");
            }

            this.prev = prev;
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public Node getNext() {
            return next;
        }

        public String getCountryName() {
            return data[0];
        }

        public String getPopulation() {
            return data[1];
        }

        public String getCapitalCity() { return data[2]; }

        public String getLargestCity() {
            return data[3];
        }

        public String getLanguage() {
            return data[4];
        }

        public String getCurrency() {
            return data[5];
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return  data[0] + ' ' + data[1] + ' ' + data[2] + ' ' +
                    data[3] + ' ' + data[4] + ' ' + data[5];
        }
    }

    private final Node header;
    private final Node trailer;

    private int size;

    public DoublyLinkedList(){
        header = new Node(null, null, null);
        trailer = new Node(header, null, null);
        header.setNext(trailer);
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean addLast(String lineData){
        // Creates a new node from the line data and make its prevNode header and nextNode the 2nd node in list
        Node n = new Node(trailer.getPrev(),trailer,lineData);

        // Makes sure that population is a positive number
        try {
            if(Long.parseLong(n.getPopulation().replace(".",""))<0){
                System.out.println("Population can't be negative!!!");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("The population value needs to be represented with the positive long data type!!!");
            return false;
        }

        // Iterates through the list. If there exists a same country, won't add
        Node walk = header.getNext();
        while(walk != trailer){

            // As countryNames, largest_cities, and capital_cities are special to country we check them
            if(n.getCountryName().compareToIgnoreCase(walk.getCountryName()) == 0){
                System.out.println("There exists a country named " + n.getCountryName() +". You can't add this country!!!" );
                return false;
            }
            else if(n.getCapitalCity().compareToIgnoreCase(walk.getCapitalCity()) == 0){
                System.out.println("There exists a country whose capital is " + n.getCapitalCity() +". You can't add this country!!!" );
                return false;
            }
            else if(n.getLargestCity().compareToIgnoreCase(walk.getLargestCity()) == 0){
                System.out.println("There exists a country whose largest city is " + n.getLargestCity() +". You can't add this country!!!" );
                return false;
            }
            walk = walk.getNext();
        }

        // Provides connection for existing nodes
        trailer.getPrev().setNext(n);
        trailer.setPrev(n);
        size++;
        return true;
    }

    public void deleteSpecific(String countryName){
        if(size == 0) {
            System.out.println("Your list is empty!!!");
            return;
        }

        Node walk = header.getNext();
        //Traverse through the list until finding specified country name
        while(walk != trailer){
            if(walk.getCountryName().compareToIgnoreCase(countryName) == 0){
                walk.getPrev().setNext(walk.getNext());
                walk.getNext().setPrev(walk.getPrev());
                size--;
                System.out.println(countryName + " is removed from the list");
                return;
            }
            walk = walk.getNext();
        }

        System.out.println("Country " + countryName + " is not found in the list!!!");
    }

    public void checkAttribute(int attributeIndex, String symbol, String dataToCompare) {
        if (size == 0) return;

        Node walk = header.getNext();
        int index = 1;

        // Iterates through the list, compares data based on the provided symbol, prints the matching node
        boolean isSymbolDefined = true;
        while (walk != trailer && isSymbolDefined) {
            switch (symbol) {
                case "=":
                    if (attributeIndex != 1 && walk.data[attributeIndex].compareToIgnoreCase(dataToCompare) == 0) {
                        System.out.println(index++ + ". " + walk);
                    } else if (attributeIndex == 1) {
                        long populationToCompare = Long.parseLong(dataToCompare.replace(".", ""));
                        long walkPopulation = Long.parseLong(walk.getPopulation().replace(".", ""));
                        System.out.print((walkPopulation == populationToCompare ? (index++ + ". " + walk + "\n") : ""));
                    }
                    break;
                case "<":
                    if (attributeIndex != 1 && walk.data[attributeIndex].compareToIgnoreCase(dataToCompare) < 0) {
                        System.out.println(index++ + ". " + walk);
                    } else if (attributeIndex == 1) {
                        long populationToCompare = Long.parseLong(dataToCompare.replace(".", ""));
                        long walkPopulation = Long.parseLong(walk.getPopulation().replace(".", ""));
                        System.out.print(walkPopulation < populationToCompare ? (index++ + ". " + walk + "\n") : "");
                    }
                    break;
                case ">":
                    if (attributeIndex != 1 && walk.data[attributeIndex].compareToIgnoreCase(dataToCompare) > 0) {
                        System.out.println(index++ + ". " + walk);
                    } else if (attributeIndex == 1) {
                        long populationToCompare = Long.parseLong(dataToCompare.replace(".", ""));
                        long walkPopulation = Long.parseLong(walk.getPopulation().replace(".", ""));
                        System.out.print(walkPopulation > populationToCompare ? (index++ + ". " + walk + "\n") : "");
                    }
                    break;
                default:
                    isSymbolDefined = false;
                    System.out.println("Undefined symbol");
                    break;
            }
            walk = walk.getNext();
        }
        // Index holds the numbers of specified countries, so when it is incremented it means that we have found at least 1 country
        if (index <= 1 && isSymbolDefined){
            System.out.println("There is no country with the specified feature in the list");
        }
    }

    public void printList(){
        if(size == 0) return;

        Node walk = header.getNext();
        int lineNum = 1;
        while(walk != trailer){
            System.out.print(lineNum++ + ") " + walk + '\n');
            walk = walk.getNext();
        }
    }
}
