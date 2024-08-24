package model;

import java.util.*;
import java.io.Serializable;
public class Pessoas implements Serializable {
  private String nome;
  private String email;

  public Pessoas(String nome, String email){
    this.nome = nome;
    this.email = email;
  }

  public String getNome(){
    return this.nome;
  }
  public String getEmail(){
    return this.email;
  }

  public String toString(){
    return "Nome: " + this.nome + "\nEmail: " + this.email;
  }

  @Override
  public boolean equals(Object obj){
    if(obj instanceof Pessoas){
      Pessoas p = (Pessoas) obj;
      if(this.email.equals(p.getEmail())){
        return true;
      }
    }
    return false;
  }

  public int hashCode() {
      return email != null ? email.hashCode() : 0;
  } 
  
  
  
}