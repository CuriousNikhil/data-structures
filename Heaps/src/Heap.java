public class Heap {

    private Integer heap[];
    private int currentPosition = -1;

    public Heap(int size) {
        this.heap = new Integer[size];
    }

    public void insert(Integer data){

        if (isFull()){
            System.out.println("The Heap is Full boss!!");
        }else{
            heap[++currentPosition]=data;
            fixUp(currentPosition);
        }

    }

    private void fixUp(int index) {
        int parent = (index-1)/2;

        while (parent >=0 && this.heap[index]>this.heap[parent]){
            int temp = heap[index];
            heap[index] = heap[parent];
            heap[parent] = temp;
            index = parent;
            parent = (index-1)/2;
        }
    }


    public int getMax(){

        int result = heap[0];

        heap[0] = heap[currentPosition--];
        heap[currentPosition+1]=null;
        fixDown(0,-1);
        return result;

    }

    private void fixDown(int index, int upto) {
        if (upto<0)upto = currentPosition;

        while (index<=upto){

            int leftChild = 2*index+1;
            int rightChild = 2*index+2;

            if( leftChild <= upto ){
                int childToSwap;

                if( rightChild > upto ){
                    childToSwap = leftChild;
                }else{
                    childToSwap = ( this.heap[leftChild] > this.heap[rightChild]) ? leftChild : rightChild;
                }

                if( this.heap[index] < this.heap[childToSwap]){
                    int temp = this.heap[index];
                    this.heap[index]=this.heap[childToSwap];
                    this.heap[childToSwap]=temp;
                }else{
                    break;
                }

                index = childToSwap;
            }else{
                break;
            }

        }

    }


    private boolean isFull() {
        return this.currentPosition == heap.length;
    }

}
