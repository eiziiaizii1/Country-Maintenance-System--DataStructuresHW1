// TODO: compare population
// TODO: adding
public class DoublyLinkedList {
    private static class Node {

        private Node prev;
        private Node next;

        // 0:countryName, 1:population, 2:capitalCity, 3:largestCity, 4:language, 5:currency
        private String[] data;
        public Node(Node prev, Node next, String line){
            data = new String[6];
            if(line != null){
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

        public String getCapitalCity() {
            return data[2];
        }

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
                    data[3] + ' ' + data[4] + ' ' + data[5] + ' ' ;
        }
    }

    private final Node header;
    private final Node trailer;

    private int size;

    public DoublyLinkedList(){
        header = new Node(null, null, null);
        trailer = new Node(header, null, null);
        header.setNext(trailer);
    }

    public Node getFirst(){
        if(size == 0)
            return null;
        return header.getNext();
    }

    public Node getLast(){
        if(size == 0)
            return null;
        return trailer.getPrev();
    }

    public void addFirst(String lineData){
        // Creates a new node from the lineData and make its prevNode header and nextNode the 2nd node in list
        Node n = new Node(header,header.getNext(),lineData);
        header.setNext(n);
        header.getNext().setPrev(n);
        size++;
    }

    public void addLast(String lineData){
        // Creates a new node from the line data and make its prevNode header and nextNode the 2nd node in list
        Node n = new Node(trailer.getPrev(),trailer,lineData);
        trailer.getPrev().setNext(n);
        trailer.setPrev(n);
        size++;
    }

    public void deleteSpecific(String countryName){
        if(size == 0) return;

        Node walk = header.getNext();
        //Traverse through the list until finding specified country name
        while(walk != trailer){
            if(walk.getCountryName().compareToIgnoreCase(countryName) == 0){
                walk.getPrev().setNext(walk.getNext());
                walk.getNext().setPrev(walk.getPrev());
                size--;
                return;
            }
            walk = walk.getNext();
        }
        // If we couldn't find the country, print message
        System.out.println("Country " + countryName + " is not found in the list!!!");
    }

    private void check(int attributeIndex, String symbol, String dataToCompare){
        if(size == 0) return;

        Node walk = header.getNext();
        while(walk != trailer){
            switch (symbol){
                case "=":
                    if(walk.data[attributeIndex].compareToIgnoreCase(dataToCompare) == 0) {
                        System.out.println(walk);
                    }
                    break;
                case "<":
                    if(walk.data[attributeIndex].compareToIgnoreCase(dataToCompare) < 0) {
                        System.out.println(walk);
                    }
                    break;
                case ">":
                    if(walk.data[attributeIndex].compareToIgnoreCase(dataToCompare) > 0) {
                        System.out.println(walk);
                    }
                    break;
                default:
                    System.out.println("Undefined symbol");
                    break;
            }
            walk = walk.getNext();
        }
    }

    public void queryControl(String attribute, String symbol, String data){
        // 0:countryName, 1:population, 2:capitalCity, 3:largestCity, 4:language, 5:currency
        switch (attribute){
            case "country":
                check(0,symbol,data);
                break;
            case "population":
                check(1,symbol,data);
                break;
            case "capital_city":
                check(2,symbol,data);
                break;
            case "largest_city":
                check(3,symbol,data);
                break;
            case "language":
                check(4,symbol,data);
                break;
            case "currency":
                check(5,symbol,data);
                break;
        }

    }

    public void printList(){
        if(size == 0) return;

        Node walk = header.getNext();
        while(walk != trailer){
            System.out.println(walk);
            walk = walk.getNext();
        }
    }
}
