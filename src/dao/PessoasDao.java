package dao;

import model.Pessoas;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class PessoasDao{
  private File arquivo;

  public PessoasDao(){
    arquivo = new File("src/dao/pessoas.ser");
    if (!arquivo.exists() ){
      try{
        arquivo.createNewFile();
      }catch (IOException e){
        System.out.println("Falha ao criar arquivo");
      }
    }
  }
  public Set<Pessoas> getPessoas(){
    try{
      FileInputStream fis = new FileInputStream(arquivo);
      ObjectInputStream ois = new ObjectInputStream(fis);
      Set<Pessoas> pessoas = (Set<Pessoas>) ois.readObject();
      return pessoas;
    }catch (FileNotFoundException e) {
      System.out.println("Arquivo não encontrado");
    } catch (IOException e) {
      System.out.println("Falha ao ler arquivo");
    } catch (ClassNotFoundException e) {
      System.out.println("Falha ao ler arquivo");
    }
    return new HashSet<>();
  }
  
  
  public boolean salvar(Pessoas pessoa){
    Set<Pessoas> pessoas = this.getPessoas();
    if(pessoas.add(pessoa)){
      try{
        FileOutputStream fos = new FileOutputStream(arquivo);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(pessoas);
        return true;
      }catch (FileNotFoundException e) {
          System.out.println("Arquivo não encontrado");
      }catch (IOException e){
        System.out.println("Falha ao salvar arquivo");
      } 
      
    }
    return false;    
  }

  public boolean deletar(String email){
    Set<Pessoas> pessoas = getPessoas();
    for(Pessoas p : pessoas){
      if(p.getEmail().equals(email)){
        pessoas.remove(p);
        try{
          FileOutputStream fos = new FileOutputStream(arquivo);
          ObjectOutputStream oos = new ObjectOutputStream(fos);
          oos.writeObject(pessoas);
          return true;
          
        }catch (FileNotFoundException e){
              System.out.println("Arquivo não encontrado");
        }catch(IOException e){
          System.out.println("Falha ao salvar arquivo");
        }
        
      }
     
    }
    return false;
    }

  public void ListarPessoas(){
    Set<Pessoas> pessoas = getPessoas();
    for(Pessoas p : pessoas){
      System.out.println(p+"\n");
    }
    
  }
  
  
} 