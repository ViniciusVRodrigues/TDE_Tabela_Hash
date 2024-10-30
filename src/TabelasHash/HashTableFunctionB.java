package TabelasHash;

public class HashTableFunctionB extends HashTable {
    public HashTableFunctionB(int size) {
        super(size);
    }

    @Override
    public int hash(String value) {
        int hash = 0;
        for (int i = 0; i < value.length(); i++) {
            hash += value.charAt(i) * (31 ^ i);
        }
        return Math.abs(hash) % table.length;
    }
}
