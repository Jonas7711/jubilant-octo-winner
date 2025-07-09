// Produto - Computador
class Computador {
    private String processador;
    private String placaMae;
    private String memoriaRAM;
    private String armazenamento;
    private String placaVideo;
    private String fonte;
    
    // Getters e Setters
    public void setProcessador(String processador) { this.processador = processador; }
    public void setPlacaMae(String placaMae) { this.placaMae = placaMae; }
    public void setMemoriaRAM(String memoriaRAM) { this.memoriaRAM = memoriaRAM; }
    public void setArmazenamento(String armazenamento) { this.armazenamento = armazenamento; }
    public void setPlacaVideo(String placaVideo) { this.placaVideo = placaVideo; }
    public void setFonte(String fonte) { this.fonte = fonte; }
    
    @Override
    public String toString() {
        return String.format("Computador:%n" +
               "Processador: %s%n" +
               "Placa-mãe: %s%n" +
               "Memória RAM: %s%n" +
               "Armazenamento: %s%n" +
               "Placa de vídeo: %s%n" +
               "Fonte: %s",
               processador, placaMae, memoriaRAM, armazenamento, placaVideo, fonte);
    }
}

// Builder abstrato
abstract class ComputadorBuilder {
    protected Computador computador;
    
    public void criarNovoComputador() {
        computador = new Computador();
    }
    
    public Computador obterComputador() {
        return computador;
    }
    
    public abstract void buildProcessador();
    public abstract void buildPlacaMae();
    public abstract void buildMemoriaRAM();
    public abstract void buildArmazenamento();
    public abstract void buildPlacaVideo();
    public abstract void buildFonte();
}

// Concrete Builder - PC Gamer
class GamerPCBuilder extends ComputadorBuilder {
    @Override
    public void buildProcessador() {
        computador.setProcessador("Intel Core i7-13700K");
    }
    
    @Override
    public void buildPlacaMae() {
        computador.setPlacaMae("ASUS ROG Strix Z790-E");
    }
    
    @Override
    public void buildMemoriaRAM() {
        computador.setMemoriaRAM("32GB DDR5 5600MHz");
    }
    
    @Override
    public void buildArmazenamento() {
        computador.setArmazenamento("1TB NVMe SSD + 2TB HDD");
    }
    
    @Override
    public void buildPlacaVideo() {
        computador.setPlacaVideo("NVIDIA RTX 4070 Ti");
    }
    
    @Override
    public void buildFonte() {
        computador.setFonte("750W 80+ Gold Modular");
    }
}

// Concrete Builder - PC de Escritório
class OfficePCBuilder extends ComputadorBuilder {
    @Override
    public void buildProcessador() {
        computador.setProcessador("Intel Core i5-13400");
    }
    
    @Override
    public void buildPlacaMae() {
        computador.setPlacaMae("MSI Pro B760M-A");
    }
    
    @Override
    public void buildMemoriaRAM() {
        computador.setMemoriaRAM("16GB DDR4 3200MHz");
    }
    
    @Override
    public void buildArmazenamento() {
        computador.setArmazenamento("512GB SSD");
    }
    
    @Override
    public void buildPlacaVideo() {
        computador.setPlacaVideo("Integrada Intel UHD Graphics");
    }
    
    @Override
    public void buildFonte() {
        computador.setFonte("500W 80+ Bronze");
    }
}

// Director
class ComputadorDirector {
    private final ComputadorBuilder builder;
    
    public ComputadorDirector(ComputadorBuilder builder) {
        this.builder = builder;
    }
    
    public void construirComputador() {
        builder.criarNovoComputador();
        builder.buildProcessador();
        builder.buildPlacaMae();
        builder.buildMemoriaRAM();
        builder.buildArmazenamento();
        builder.buildPlacaVideo();
        builder.buildFonte();
    }
    
    public Computador obterComputador() {
        return builder.obterComputador();
    }
}

// Exemplo de uso
public class Main {
    public static void main(String[] args) {
        // Construindo PC Gamer
        ComputadorDirector gamerDirector = new ComputadorDirector(new GamerPCBuilder());
        gamerDirector.construirComputador();
        Computador pcGamer = gamerDirector.obterComputador();
        
        System.out.println("=== PC GAMER ===");
        System.out.println(pcGamer);
        
        // Construindo PC de Escritório
        ComputadorDirector officeDirector = new ComputadorDirector(new OfficePCBuilder());
        officeDirector.construirComputador();
        Computador pcOffice = officeDirector.obterComputador();
        
        System.out.println("\n=== PC ESCRITÓRIO ===");
        System.out.println(pcOffice);
    }
}