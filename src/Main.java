import CSV.LeitorCSV;
import TabelasHash.HashTableFunctionA;
import TabelasHash.HashTableFunctionB;

public class Main {
    public static void main(String[] args) {
        String caminho = "names_5000.csv";
        LeitorCSV leitor = new LeitorCSV(caminho);
        int quantidadeParaInserir = 5000;
        int quantidadeParaBuscar = 500;
        String[] valoresParaInserir = new String[quantidadeParaInserir];
        for (int i = 0; i < quantidadeParaInserir; i++) {
            valoresParaInserir[i] = leitor.getNomes()[i];
        }
        String[] valoresParaBuscar = new String[quantidadeParaBuscar];
        int index = (int) (Math.random() * (4999-quantidadeParaBuscar));
        for (int i = 0; i < quantidadeParaBuscar; i++) {
            valoresParaBuscar[i] = leitor.getNomes()[(index + i) % 5000];
        }
        int size = quantidadeParaInserir * 2;
        HashTableFunctionA tabelaA = new HashTableFunctionA(size);
        tabelaA.insertAll(valoresParaInserir);
        tabelaA.searchAll(valoresParaBuscar);
        System.out.println("Relatório da Tabela A:");
        tabelaA.printReport();

        HashTableFunctionB tabelaB = new HashTableFunctionB(size);
        tabelaB.insertAll(valoresParaInserir);
        tabelaB.searchAll(valoresParaBuscar);
        System.out.println("Relatório da Tabela B:");
        tabelaB.printReport();

        tabelaA.compare(tabelaB,"Tabela A","Tabela B");
    }
}