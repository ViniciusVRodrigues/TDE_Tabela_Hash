package Relatorio;

public abstract class ReportManager {
    private long insertionStartTime;
    private long insertionEndTime;
    private long insertionDelta;
    private long searchStartTime;
    private long searchEndTime;
    private long searchDelta;
    protected int collisions;

    public void startInsertion(){
        insertionStartTime = System.nanoTime();
    }
    public void endInsertion(){
        insertionEndTime = System.nanoTime();
        insertionDelta = insertionEndTime - insertionStartTime;
    }
    public void incrementCollisions(){
        collisions++;
    }
    public void startSearch(){
        searchStartTime = System.nanoTime();
    }
    public void endSearch(){
        searchEndTime = System.nanoTime();
        searchDelta = searchEndTime - searchStartTime;
    }
    public void printReport(){
        System.out.println("Tempo de inserção: " + insertionDelta + "ns");
        System.out.println("Tempo de busca: " + searchDelta + "ns");
        System.out.println("Colisões: " + collisions);
        keysPerHash();
    }

    public abstract void keysPerHash();

    public void compare(ReportManager other, String name, String otherName){
        System.out.println("Comparação entre " + name + " e " + otherName);
        if (insertionDelta < other.insertionDelta){
            System.out.println(name + " é mais rápido em " + (other.insertionDelta - insertionDelta) + "ns na inserção");
        } else {
            System.out.println(otherName + " é mais rápido em " + (insertionDelta - other.insertionDelta) + "ns na inserção");
        }
        if (searchDelta < other.searchDelta){
            System.out.println(name + " é mais rápido em " + (other.searchDelta - searchDelta) + "ns na busca");
        } else {
            System.out.println(otherName + " é mais rápido em " + (searchDelta - other.searchDelta) + "ns na busca");
        }
        if (collisions < other.collisions){
            System.out.println(name + " tem " + (other.collisions - collisions) + " colisões a menos");
        } else {
            System.out.println(otherName + " tem " + (collisions - other.collisions) + " colisões a menos");
        }
    }
}
