import java.util.LinkedList;

class MyHashSet {
    private final int BUCKET_SIZE = 1000;
    private LinkedList<Integer>[] buckets;

    public MyHashSet() {
        
        buckets = new LinkedList[BUCKET_SIZE];
        for (int i = 0; i < BUCKET_SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    
    
    private int getHash(int key) {
        return key % BUCKET_SIZE;
    }

    public void add(int key) {
        int bucketIndex = getHash(key);
        LinkedList<Integer> bucket = buckets[bucketIndex];
        
        if (!bucket.contains(key)) {
            bucket.add(key);
        }
    }

    public void remove(int key) {
        int bucketIndex = getHash(key);
        LinkedList<Integer> bucket = buckets[bucketIndex];
        
        bucket.remove(Integer.valueOf(key));
    }

    public boolean contains(int key) {
        int bucketIndex = getHash(key);
        LinkedList<Integer> bucket = buckets[bucketIndex];
        return bucket.contains(key);
    }
}
