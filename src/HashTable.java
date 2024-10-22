import java.util.Arrays;

public class HashTable {
    private int[] table;

    public HashTable(int size) {
        table = new int[size];
    }

    //Função Hash que não resulta em colisões
    public int hash(int value) {
        return value % table.length;
    }

    //Função Inserir que insere uma chave na tabela
    public void insert(int value) {
        table[hash(value)] = value;
    }

    //Função Buscar que retorna true se a chave está na tabela
    public boolean search(int value) {
        return table[hash(value)] == value;
    }

    //Função Deletar que remove uma chave da tabela
    public void delete(int value) {
        table[hash(value)] = 0;
    }

    //Função Imprimir que imprime a tabela
    public void print() {
        System.out.println(Arrays.toString(table));
    }

    public String toString() {
        return Arrays.toString(table);
    }
}
