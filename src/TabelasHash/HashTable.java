package TabelasHash;

import Relatorio.ReportManager;

import java.util.Arrays;

public abstract class HashTable extends ReportManager {
    protected String[] table;
    protected int currentSize;
    protected double loadFactor;

    public HashTable(int size) {
        table = new String[size];
        currentSize = 0;
        collisions = 0;
    }

    public abstract int hash(String value);

    public boolean isFull() {
        return currentSize >= table.length * loadFactor;
    }

    public void rehash(){
        String[] temp = table;
        table = new String[table.length*2];
        currentSize = 0;
        for(String value : temp){
            if(value != null){
                insert(value);
            }
        }
    }

    public void insert(String value) {
        if (isFull()) {
            rehash();
        }
        int index = hash(value);
        while (table[index] != null) {
            incrementCollisions();
            index = (index + 1) % table.length;
        }
        currentSize++;
        table[index] = value;
    }

    public void insertAll(String[] values) {
        startInsertion();
        for (String value : values) {
            insert(value);
        }
        endInsertion();
    }

    public boolean search(String value) {
        int index = hash(value);
        while (table[index] != null && !table[index].equals(value)) {
            index = (index + 1) % table.length;
        }
        return table[index] != null;
    }

    public void searchAll(String[] values) {
        startSearch();
        for (String value : values) {
            search(value);
        }
        endSearch();
    }

    public void delete(String value) {
        int index = hash(value);
        while (table[index] != null && !table[index].equals(value)) {
            index = (index + 1) % table.length;
        }
        if (table[index] != null) {
            table[index] = null;
            index = (index + 1) % table.length;
            while (table[index] != null) {
                String temp = table[index];
                table[index] = null;
                insert(temp);
                index = (index + 1) % table.length;
            }
        }
    }

    public void keysPerHash() {
        int[] keysPerHash = new int[table.length];
        for (String key : table) {
            if (key != null) {
                keysPerHash[hash(key)]++;
            }
        }
        System.out.println("Distribuição das chaves:");
        for(int i = 0; i < keysPerHash.length; i++){
            if(keysPerHash[i] != 0)
                System.out.println(i + ": " + keysPerHash[i]);
        }
    }

    //Função Imprimir que imprime a tabela
    public void print() {
        System.out.println(Arrays.toString(table));
    }

    public String toString() {
        return Arrays.toString(table);
    }
}
