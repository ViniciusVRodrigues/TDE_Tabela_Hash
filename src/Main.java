public class Main {
    public static void main(String[] args) {
        //Testando o Hash
        HashTable hashTable = new HashTable(10);
        //Inserindo 12, 25, 37, 41, 53, 64, 78, 89
        hashTable.insert(12);
        hashTable.insert(25);
        hashTable.insert(37);
        hashTable.insert(41);
        hashTable.insert(53);
        hashTable.insert(64);
        hashTable.insert(78);
        hashTable.insert(89);
        //Buscando alguns valores
        System.out.println(hashTable.search(12)); //true
        System.out.println(hashTable.search(26)); //false
        System.out.println(hashTable.search(53)); //true
        //Deletando alguns valores
        hashTable.delete(12);
        hashTable.delete(53);
        //Imprimindo a tabela
        hashTable.print(); //[0, 25, 37, 41, 0, 64, 78, 89, 0, 0]
    }
}