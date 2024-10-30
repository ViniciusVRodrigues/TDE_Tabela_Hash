package joao.TabelasHash;

import TabelasHash.HashTable;

public class HashTableFunctionA extends HashTable {
    public HashTableFunctionA(int size) {
        super(size);
    }

    @Override
    public int hash(String value) {
        int hash = 0;
        for (int i = 0; i < value.length(); i++) {
            hash += value.charAt(i);
        }
        return hash % table.length;
    }
}
