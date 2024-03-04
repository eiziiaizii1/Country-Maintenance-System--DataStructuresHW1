public class DoublyLinkedList {
    private static class Node {

        private Node prev;
        private Node next;
        private String countyName;
        private String population;
        private String capitalCity;
        private String largestCity;
        private String language;
        private String currency;
        public Node(Node prev, Node next, String line){
            //TODO implement line to to attributes logic

            this.prev = prev;
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public Node getNext() {
            return next;
        }

        public String getCountyName() {
            return countyName;
        }

        public String getPopulation() {
            return population;
        }

        public String getCapitalCity() {
            return capitalCity;
        }

        public String getLargestCity() {
            return largestCity;
        }

        public String getLanguage() {
            return language;
        }

        public String getCurrency() {
            return currency;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public void setNext(Node next) {
            this.next = next;
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
    }

    public void addLast(String lineData){
        // Creates a new node from the line data and make its prevNode header and nextNode the 2nd node in list
        Node n = new Node(trailer.getPrev(),trailer,lineData);
        // Changes the adjacent Nodes' next and prev
        trailer.setPrev(n);
        trailer.getPrev().setNext(n);
    }

}
