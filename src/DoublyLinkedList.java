public class DoublyLinkedList {
    private static class Node {

        private Node prev;
        private Node next;

        // 0:countryName, 1:population, 2:capitalCity, 3:largestCity, 4:language, 5:currency
        private String[] data;
        public Node(Node prev, Node next, String line){
            data = new String[6];

            //TODO implement line to attributes logic
            if(line != null){
                data = line.split("\\s+");
            }

//            StringBuffer bf = new StringBuffer();
//            int dataIndex = 0;
//            for(int i =0; line!=null && i < line.length();i++){
//                if(i > 0 &&  line.charAt(i-1) == ' ' &&  line.charAt(i) != ' '){
//                    data[dataIndex] = bf.toString();
//                    bf.delete(0,bf.length());
//                    dataIndex++;
//                }
//                else if(line.charAt(i)== ' '){
//                    continue;
//                }
//                else{
//                    bf.append(line.charAt(i));
//                }
//            }
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

    private Node header;
    private Node trailer;

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
        // Changes the adjacent Nodes' next and prev
        header.setNext(n);
        header.getNext().setPrev(n);
        size++;
    }

    public void addLast(String lineData){
        // Creates a new node from the line data and make its prevNode header and nextNode the 2nd node in list
        Node n = new Node(trailer.getPrev(),trailer,lineData);
        // Changes the adjacent Nodes' next and prev
        trailer.setPrev(n);
        trailer.getPrev().setNext(n);
        size++;
    }

    public void deleteSpecific(String countryName){
        if(size == 0) return;

        Node walk = header.getNext();

        //Traverse through the list until finding specified country name
        while(walk != trailer){
            if(walk.getCountryName().equals(countryName)){
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

    public void printList(){
        if(size == 0) return;

        Node walk = header.getNext();
        while(walk != trailer){
            System.out.println(walk);
            walk = walk.getNext();
        }
    }
}
