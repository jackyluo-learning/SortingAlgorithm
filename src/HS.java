import org.junit.Test;

public class HS {
    /**
     * 建堆：
     * 1. 从下往上(插入)
     * 2. 从上往下(原地建堆)
     */

    private int[] item;

    private int size;

    public HS (int num) {
        this.item = new int[num];
        this.size = 0;
    }

    public HS (int[] num) {
        this.item = num;
        this.size = num.length;
    }

    public void insert(int val) {
        this.item[this.size] = val;
        int i = this.size;
        while ((i-1)/2 >= 0 && this.item[(i-1)/2] < this.item[i]) {
            swap(i, (i-1)/2);
            i = (i-1)/2;
        }
        this.size++;
    }

    public void heapify (int size, int i) {
        while (true) {
            int maxIndex = i;
            int leftChild = i * 2 + 1;
            int rightChild = i * 2 + 2;
            if (leftChild < size && this.item[i] < this.item[leftChild]) {
                maxIndex = leftChild;
            }
            if (rightChild < size && this.item[i] < this.item[rightChild]) {
                maxIndex = rightChild;
            }
            if (maxIndex == i) break;
            swap(i, maxIndex);
            i = maxIndex;
        }
    }

    public void buildHeap () {
        int size = this.item.length;
        for (int i = size/2; i >= 0; i--) {
            heapify(size, i);
        }
    }

    private void swap (int i1, int i2) {
        int tmp = this.item[i2];
        this.item[i2] = this.item[i1];
        this.item[i1] = tmp;
    }

    public void printArray () {
        for (int i = 0; i < this.size; i++) {
            System.out.println(this.item[i]);
        }
    }
}


