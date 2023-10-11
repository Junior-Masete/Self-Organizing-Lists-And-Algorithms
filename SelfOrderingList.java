abstract class SelfOrderingList<T extends Comparable<T>> {
    public Node<T> head = null;

    public void insert(T data){
        Node<T> newNode = new Node<T>(data);
        newNode.next = null;
        Node<T> nodePtr;

        if(head == null){
            head = newNode;
        }
        else{
            nodePtr = head;
            while(nodePtr.next != null){
                nodePtr = nodePtr.next;
            }

            nodePtr.next = newNode;
            newNode.prev = nodePtr;
        }
        
    }

    public void remove(T data){
        if(head == null){
            return;
        }
        
        if(head.data == data){
                head = head.next;
                head.prev = null;
                return;
           }

        Node<T> nodePtr = head;
        while(nodePtr.next != null && nodePtr.data != data){
               nodePtr = nodePtr.next;
           }

        if(nodePtr.next != null){
            nodePtr.next.prev = nodePtr.prev;
        }
        
        if(nodePtr.prev != null){
            nodePtr.prev.next = nodePtr.next;
        }

        return;
           
           
           /* 
           else{
                Node<T> nodePtr = head;
                while(nodePtr.next != null && nodePtr.data != data){
                    nodePtr = nodePtr.next;
                }

                System.out.println("Traversing works");
                nodePtr.prev.next = nodePtr.next;
                nodePtr.next.prev = nodePtr.prev;

           }*/
        

       
    }

    public abstract void access(T data);

    public abstract SelfOrderingList<T> getBlankList();
}
