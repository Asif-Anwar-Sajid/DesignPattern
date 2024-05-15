package Composite;

import java.util.ArrayList;
import java.util.List;

// Component Interface
interface StorageComponent {
    int size();
}

// Leaf Node
class Document implements StorageComponent {
    private int documentSize;

    public Document(int documentSize) {
        this.documentSize = documentSize;
    }

    @Override
    public int size() {
        return documentSize;
    }
}

// Composite Node
class Directory implements StorageComponent {
    private List<StorageComponent> components = new ArrayList<>();

    public void add(StorageComponent component) {
        components.add(component);
    }

    public void remove(StorageComponent component) {
        components.remove(component);
    }

    @Override
    public int size() {
        return components.stream().mapToInt(StorageComponent::size).sum();
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        // Creating documents
        StorageComponent doc1 = new Document(100);
        StorageComponent doc2 = new Document(200);
        StorageComponent doc3 = new Document(150);

        // Creating directories
        Directory dir1 = new Directory();
        dir1.add(doc1);
        dir1.add(doc2);

        Directory dir2 = new Directory();
        dir2.add(doc3);

        Directory rootDir = new Directory();
        rootDir.add(dir1);
        rootDir.add(dir2);

        // Calculate size
        int rootSize = rootDir.size();
        System.out.println("Total size of root directory: " + rootSize);
    }
}
