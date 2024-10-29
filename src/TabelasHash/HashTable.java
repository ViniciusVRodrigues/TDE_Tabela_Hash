package TabelasHash;

import java.util.Arrays;

public abstract class HashTable {
    protected String[] table;
    protected int currentSize;

    public HashTable(int size) {
        table = new String[size];
    }

    //Função Hash que não resulta em colisões
    public abstract int hash(String value);

    public boolean isFull() {
        return currentSize == table.length;
    }

    public void increaseSize(){
        table = Arrays.copyOf(table, table.length * 2);
    }

    //Função Inserir que insere uma chave na tabela hash e trata colisões
    public void insert(String value) {
        if (isFull()) {
            increaseSize();
            return;
        }
        int index = hash(value);
        while (table[index] != null) {
            index = (index + 1) % table.length;
        }
        currentSize++;
        table[index] = value;
    }

    //Função Buscar que retorna true se a chave está na tabela
    public boolean search(String value) {
        int index = hash(value);
        while (table[index] != null && !table[index].equals(value)) {
            index = (index + 1) % table.length;
        }
        return table[index] != null;
    }

    //Função Deletar que remove uma chave da tabela
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

    //Função Imprimir que imprime a tabela
    public void print() {
        System.out.println(Arrays.toString(table));
    }

    public String toString() {
        return Arrays.toString(table);
    }
}
