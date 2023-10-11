public class MoveToFrontList<T extends Comparable<T>> extends SelfOrderingList<T> {
    @Override
    public SelfOrderingList<T> getBlankList() {
        //TODO: Implement the function
        MoveToFrontList<T> obj = new MoveToFrontList<>();
        return obj;
    }

    @Override
    public void access(T data) {
        Node<T> nodePtr = head;
        if(nodePtr == null){
            head = new Node<T>(data);
            return;
        }

        Node<T> prev = null;
        while(nodePtr != null){
            if((nodePtr.data).compareTo(data) == 0){
                break;
                //if prev is not null you have to rearrange
                //meaning the element is not on 1st postion
            }
            prev = nodePtr;
            nodePtr = nodePtr.next;
            
        }

        if(nodePtr == null){
            prev.next = new Node<T>(data);
            return;
        }
        else if(prev != null){
            prev.next = nodePtr.next;
            nodePtr.next = head;
            head = nodePtr;
        }

        /* 
        if(head != null){
            Node<T> nodePtr = head;
            while(nodePtr != null){

                if(nodePtr.data == data){
                    if(nodePtr.prev  != null){
                        nodePtr.prev.next = nodePtr.next;
                        nodePtr.next = head;
                        head = nodePtr;
                    }
                }

                nodePtr.prev = nodePtr;
                nodePtr = nodePtr.next;
            }
        }
        else{
            return;
        }*/
    }
}
