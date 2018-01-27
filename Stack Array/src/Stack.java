
public class Stack<Item> {

    private Item[] stack;
    private int pointer;

    public Stack() {
        this.stack = (Item[]) new Object[1];
    }

    public void push(Item item){
        if (pointer == stack.length){
            resize(2*this.stack.length);
        }
        this.stack[pointer++] = item;
    }

    public Item pop(){
        Item item = stack[--pointer];
        if( pointer > 0 && pointer == stack.length/4 ){
            resize(this.stack.length/2);
        }

        return item;
    }

    public boolean isEmpty(){
        return this.pointer == 0;
    }

    public int size(){
        return this.pointer;
    }

    private void resize(int capacity) {

        Item[] stackCopy = ( Item[] ) new Object[capacity];

        for(int i=0;i<pointer;i++){
            stackCopy[i]=this.stack[i];
        }

        this.stack = stackCopy;
    }
}

