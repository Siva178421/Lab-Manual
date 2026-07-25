import java.util.LinkedList;

class MyHashSet {
    private final int BUCKET_SIZE = 1000;
    private LinkedList<Integer>[] buckets;

    public MyHashSet() {
        // Initialize the array of buckets
        buckets = new LinkedList[BUCKET_SIZE];
        for (int i = 0; i < BUCKET_SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    
    // Hash function to map keys to bucket indices
    private int getHash(int key) {
        return key % BUCKET_SIZE;
    }

    public void add(int key) {
        int bucketIndex = getHash(key);
        LinkedList<Integer> bucket = buckets[bucketIndex];
        // Only insert if the key does not already exist
        if (!bucket.contains(key)) {
            bucket.add(key);
        }
    }

    public void remove(int key) {
        int bucketIndex = getHash(key);
        LinkedList<Integer> bucket = buckets[bucketIndex];
        // Wrapper required: pass Integer object so it removes by value, not by index
        bucket.remove(Integer.valueOf(key));
    }

    public boolean contains(int key) {
        int bucketIndex = getHash(key);
        LinkedList<Integer> bucket = buckets[bucketIndex];
        return bucket.contains(key);
    }
}
