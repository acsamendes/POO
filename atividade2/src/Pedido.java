import java.util.ArrayList;
import java.util.Scanner;

public class Pedido implements EstiloI{
    private float precoTot;
    private String transportadora;
    private  AList<Item> itens = new ArrayList<>();

    public Pedido(String transportadora, Item item){
        this.precoTot += item.getPrecoProduto();
        this.transportadora = transportadora;
        itens.add(item);
    }

    public void addItem(Item item){
        itens.add(item);
        precoTot += item.getPrecoProduto();
    }

    public void removeItem(Item item){
        itens.remove(item);
        precoTot -= item.getPrecoProduto();
    }
    public float getPrecoTot(ArrayList<Item>itens) {
        for(Item item: itens){
            precoTot+= item.getPrecoProduto();
        }
        return precoTot;
    }
    public String getTransportadora() {
        return transportadora;
    }
    public void setPrecoTot(int precoTot) {
        this.precoTot = precoTot;
    }
    public void setTransportadora(String transportadora) {
        this.transportadora = transportadora;
    }

    public static Pedido pedidoBuilder(){
        Item item = Item.itemBuilder(); 
        Scanner scan = EstiloI.abrirScan();
        System.out.print("Transportadora:");
        String transportadora = scan.nextLine();
        Pedido pedido = new Pedido(transportadora, item);
        System.out.println("Deseja acrescentar um novo item(0 = sim/1 = não)");
        int aux = -1;
        do{
            aux = Integer.parseInt(scan.nextLine());
            System.out.println("Digite 0 para sim ou 1 para não: ");
        } while(aux != 0 && aux!=1);
        
        if(aux == 0) {
            System.out.println("\nNOVO ITEM");
            Item it = Item.itemBuilder();
            pedido.addItem(it);
        }
        return pedido;
    }


    @Override
    public String toString() {
        System.out.println("\n\nPEDIDO");
        int aux = 1;
        for(Item item : itens){
            System.out.printf("ITEM %d\n", aux);
            System.out.println(item + "\n");
            aux+=1;
        }
        System.out.println("\n||||||||||||||||||||||||||");
        System.out.println("\n\nDETALHES DO PEDIDO");
        
        return "Preco total: R$" + this.precoTot + "\tTransportadora: " + this.transportadora;
    }
    
}

