public class IterativeTraverse<T extends Comparable<T>> extends Traverser<T>{
    public IterativeTraverse(){
    
        this.list = null;
    };
    
    public IterativeTraverse(SelfOrderingList<T> list){
        /*if(list.head == null){
            return;
        }

        //SelfOrderingList<T> aList = list.getBlankList();
        Node<T> nodePtr = list.head;
        while(nodePtr.next != null){
            this.list.insert(nodePtr.data);
            nodePtr = nodePtr.next;
        }*/

        this.list = list;
        
        //System.out.println("Constructor worked");
        /* 
        Node<T> temp = list.head; //used to traverse the list
        Node<T> temp2 = this.list.head;


        while(temp != null){
            Node<T> newNode = new Node<T>(temp.data);

            if(this.list.head == null){
                this.list.head = newNode;
            }
            else{
                temp2.next = newNode;
                temp2 = temp2.next;
            }
            
            temp = temp.next;
        }*/

        
    }

    @Override
    public SelfOrderingList<T> reverseList() {
        SelfOrderingList<T> otherList = list.getBlankList();
        Node<T> nodePtr = list.head;
        while(nodePtr.next != null){
            nodePtr = nodePtr.next;
        }
        
        while(nodePtr.prev != null){
           // System.out.print("--"+ nodePtr.data);
            otherList.insert(nodePtr.data);
            nodePtr = nodePtr.prev;
        }
        otherList.head = nodePtr;



        return otherList;
    }

    @Override
    public boolean contains(T data) {
        
        Node<T> nodePtr = list.head;

        while(nodePtr != null){
            if(nodePtr.data == data){
                return true;
            }
            else{
                nodePtr = nodePtr.next;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        String myStr = "->";

        Node<T> nodePtr = list.head;
        while(nodePtr != null){
            myStr += nodePtr.toString();
            
            nodePtr = nodePtr.next;
            if(nodePtr != null){
                myStr += "->";
            }
        }

        return myStr;
      
    }

    @Override
    public Node<T> get(int pos) {
        int count=0;
        Node<T> nodePtr = list.head;

        if(list.head == null || pos > size()){
            return null;
        }
        else{
            while(nodePtr != null && count != pos){
                count++;
                nodePtr = nodePtr.next;
            }

            return nodePtr;
        }
    }

    @Override
    public Node<T> find(T data) {
        Node<T> nodePtr = list.head;

        while(nodePtr != null){
            if(nodePtr.data == data){
                return nodePtr;
            }
            else{
                nodePtr = nodePtr.next;
            }
        }

        return null;
    }

    @Override
    public int size() {
        int count = 0;
        Node<T> nodePtr = list.head;

        if(list.head == null){
            return 0;
        }
        else{
            while(nodePtr != null){
                count++;
                nodePtr = nodePtr.next;
            }

            return count;
        }
    }

    @Override
    public SelfOrderingList<T> clone(SelfOrderingList<T> otherList) {
        if(otherList == null){
            return null;
        }

        if(otherList.head == null){
            return null;
        }
        else{
            Node<T> temp = otherList.head; //used to traverse the list
            Node<T> temp2 = list.head;


            while(temp != null){
                Node<T> newNode = new Node<T>(temp.data);

                if(temp2 == null){
                    list.head = newNode;
                    newNode.prev = null;
                }
                else{
                    temp2.next = newNode;
                    newNode.prev = temp2;
                    temp2 = temp2.next;
                }
                
                temp = temp.next;
            }

            return list;
        }
        
        
    }
}
