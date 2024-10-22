package CSV;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorCSV {
    private String caminho;
    private List<String> nomes;
    public  LeitorCSV(String caminho){
        this.caminho = caminho;
        this.nomes = new ArrayList<>();
        try {
            ler();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void ler() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String line;
            while ((line = br.readLine()) != null) {
                nomes.add(line);
            }
        }
    }

    public List<String> getNomes() {
        return nomes;
    }
}
