public class RecursiveTraverse<T extends Comparable<T>> extends Traverser<T>{
    public RecursiveTraverse(){
        this.list = null;
    }
    
    public RecursiveTraverse(SelfOrderingList<T> list){
        this.list = list;
    }

    @Override
    public SelfOrderingList<T> reverseList() {
        SelfOrderingList<T> alist = list.getBlankList();
        alist = clone(list);
        reverse( list.head, alist);
        return alist;
    }

    private Node<T> reverse(Node<T> currNode, SelfOrderingList<T> list){
        if(currNode == null){
            return null;
        } 

        Node<T> temp = currNode.next;
        currNode.next = currNode.prev;
        currNode.prev = temp;

        if(currNode.prev == null){
            return currNode;
        }

        return reverse(currNode.prev, list);
    }

    @Override
    public boolean contains(T data) {
        Node<T> node = cont(list.head, data);
        if(node != null){
            return true;
        }
        else{
            return false;
        }
    }

    private Node<T> cont(Node<T> currNode, T data){
        if(currNode == null){
            return null;
        }

        if(currNode.data == data){
            return currNode;
        }
        else{
            return cont(currNode.next, data);
        }
    }

    @Override
    public String toString() {
       // String myStr = "->";
        return aString(list.head);
    }

    private String aString(Node<T> currNode){
        if(currNode != null){
            String str = "->" + currNode.toString();
            return str + aString(currNode.next);

        }
        
        return "";
    }

    @Override
    public Node<T> get(int pos) {
        return getPos(list.head, pos);
    }

    private Node<T> getPos(Node<T> currNode, int pos){
        if(currNode == null){
            return null;
        }

        if(pos == 0){
            return currNode;
        }
        else{
            return getPos(currNode.next, --pos);
        }
    }

    @Override
    public Node<T> find(T data) {
        return search(list.head, data);
    }

    private Node<T> search(Node<T> currNode, T data){
        if(currNode == null){
            return null;
        }

        if(currNode.data == data){
            return currNode;
        }
        else{
            return search(currNode.next, data);
        }
    }

    @Override
    public int size() {
        return counter(list.head);

        /*num = counter(list.head, num);
        return num;*/
    }

    private int counter(Node<T> currNode){
        if(currNode == null){
            return 0;
        }
       
        return 1 + counter(currNode.next);


    }

    @Override
    public SelfOrderingList<T> clone(SelfOrderingList<T> otherList) {
        copy(otherList.head, null, otherList);
        return otherList;
    }

    private Node<T> copy(Node<T> currNode, Node<T> prevNode, SelfOrderingList<T> alist){
        if(currNode == null){
            return null;
        }
        else{
            Node<T> newNode = new Node<T>(alist.head.data);
            newNode.prev = prevNode;

            newNode.next = copy(currNode.next, newNode, alist);
            return newNode;
        }

        
    }
}
