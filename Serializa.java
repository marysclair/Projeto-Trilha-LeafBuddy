import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializa {
    public static boolean criarArquivo(){
        File arquivo = new File("arquivo.bin");
        try{
            if(arquivo.createNewFile()){
                return true;
            } else{
                return false;
            }
        } catch(IOException e){
            System.out.println("erro ao criar arquivo");
            e.printStackTrace();
            return false;
        }
    }

    public static void salvarArquivoSerializado(Plantas planta){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            fos = new FileOutputStream("arquivo.bin");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(planta);
        } catch(FileNotFoundException e){
            System.out.println("Arquivo não encontrado");
        } catch(IOException e){
            System.out.println("Erro ao criar arquivo");
            e.printStackTrace();
        } finally{
            if(oos != null){
                try{
                    oos.close();
                } catch(IOException e){
                    System.out.println("Erro ao fechar o arquivo");
                }
            }
        }
    }

    public static Plantas lerPlantasDeArquivoBinario(){
        Plantas plantas = new Plantas();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            if(criarArquivo()!=true){
                fis = new FileInputStream("arquivo.bin");
                ois = new ObjectInputStream(fis);
                plantas = (Plantas)ois.readObject();
            }
            return plantas;
        }catch(ClassNotFoundException e){
            System.out.println("Classe não encontrada");
        }catch(IOException e){
            System.out.println("erro ao criar arquivo");
            e.printStackTrace();
        }finally{
            if(ois != null){
                try{
                    ois.close();
                }catch(IOException e){
                    System.out.println("erro ao fechar arquivo");
                }
            }
        }
        return plantas;
    }
}
